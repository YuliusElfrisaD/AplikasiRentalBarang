/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPelanggan;

import Koneksi.koneksiOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author basisc13
 */
public class KontrolPelanggan {

    private Connection conn;

    public KontrolPelanggan(Connection koneksi) {
        this.conn = koneksi;
    }

    public static KontrolPelanggan getKoneksi() {
        koneksiOracle k = new koneksiOracle();
        KontrolPelanggan kon = new KontrolPelanggan(k.getKoneksiOracleDB());
        return kon;
    }

    public List<Pelanggan> tampilPelanggan() {
        ArrayList<Pelanggan> kat = new ArrayList<>();
        try {
            String sql = "select * from pelanggan ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setKode(rs.getString(1));
                p.setNama(rs.getString(2));
                p.setEmail(rs.getString(3));
                p.setTelp(rs.getString(4));
                p.setAlamat(rs.getString(5));
                kat.add(p);//Jangan lupa add ke dalam array list kategori
            }
            conn.commit();
            conn.close();
        } catch (SQLException ex) {

        }
        return kat;
    }

    public void InsertPelanggan(Pelanggan p) {
        try {

            String sql = "insert into pelanggan(kode,nama,email,telp,alamat) values(?,?,?,?,?)";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getKode());
            ps.setString(2, p.getNama());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getTelp());
            ps.setString(5, p.getAlamat());

            ps.executeUpdate();
            System.out.println("Data berhasil ditambahkan");
//
            conn.commit();
            conn.close();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");

        } catch (SQLException ex) {

        }
    }

    public void DeletePelanggan(String kode) {
        try {
            String sql = "delete from pelanggan where kode=?";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode);
            ps.executeUpdate();
            System.out.println("Data berhasil dihapus");
//
            conn.commit();
            conn.close();

            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");

        } catch (SQLException ex) {

        }
    }

    public void UpdatePelanggan(Pelanggan p) {
        try {
            String sql = "update pelanggan set nama=?, email=?, telp=?, alamat=? where kode=?";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelp());
            ps.setString(4, p.getAlamat());
            ps.setString(5, p.getKode());
            ps.executeUpdate();
            System.out.println("Data berhasil diubah");
//
            conn.commit();
            conn.close();

            JOptionPane.showMessageDialog(null, "Data berhasil diubah");

        } catch (SQLException ex) {

        }
    }

    public int kodeOtomatis() throws SQLException {
        ResultSet rset = null;
        int bantu = 0;
        String sql = "select max(kode) from pelanggan";
        Statement stat = conn.createStatement();
        rset = stat.executeQuery(sql);
        while (rset.next()) {
            bantu = rset.getInt(1);
        }
        conn.close();
        return bantu;
    }
    
    public int kodeOtomatis(String kodemasuk) throws SQLException{
        ResultSet rset= null;
        int kode=0;
        String sql="select substr(kode,2) from pelanggan where kode like "
                +"'"+kodemasuk+"%' order by kode";
        Statement stat= conn.createStatement();
        rset = stat.executeQuery(sql);
        ResultSet rset1 = null;
        String sql1="select substr(max(kode),2) from pelanggan where kode like "
                +"'"+kodemasuk+"%' order by kode";
        Statement stat1= conn.createStatement();
        rset1 = stat1.executeQuery(sql);
        int bantu = 1;
        boolean x=false;
        
        while(rset.next()){
//            System.out.println(bantu+" = "+rset.getInt(1));
            if (bantu != rset.getInt(1)) {
                kode = bantu -1;
                x = true;
                break;
            }
            bantu++;
            
        }
        if (x == false) {
            kode = 0;
            while  (rset1.next()){
                kode=rset1.getInt(1);
            }
        }
        
        stat.close();
        conn.close();
        return kode;
    }
    
    public Pelanggan CariPelanggan(String kode) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "select * from pelanggan where kode=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, kode);
        ResultSet result = statement.executeQuery();
        Pelanggan pe = new Pelanggan();
        while (result.next()) {
            pe.setKode(result.getString(1));
            pe.setNama(result.getString(2));
            pe.setEmail(result.getString(3));
            pe.setTelp(result.getString(4));
            pe.setAlamat(result.getString(5));
        }
        statement.close();
        conn.commit();
        conn.close();
        return pe;
    }

    }

