/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Databarang;

import DataKategori.Kategori;
import Koneksi.Cara_CreateStatement;
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
 * @author basisc16
 */
public class KontrolBarang {

    private Connection conn;

    public KontrolBarang(Connection koneksi) {
        this.conn = koneksi;
    }

    public static KontrolBarang getKoneksi() {
        koneksiOracle k = new koneksiOracle();
        KontrolBarang kon = new KontrolBarang(k.getKoneksiOracleDB());
        return kon;
    }

    public List<Barang> tampilDataBarang() {
        List<Barang> b = new ArrayList<>();
        try {
            String sql = "select * from databarang ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Barang bar = new Barang();
                bar.setKodeBarang(rs.getString(1));
                bar.setNamaBarang(rs.getString(2));

                Kategori k = new Kategori();
                k.setKode(rs.getString(3));
                bar.setKategori(k);

                bar.setSatuan(rs.getString(4));
                bar.setHargaBarang(rs.getDouble(5));
                bar.setHargasewa(rs.getDouble(6));
                bar.setImage(rs.getString(7));
                b.add(bar);//Jangan lupa add ke dalam array list kategori
            }
            conn.commit();
            conn.close();
        } catch (SQLException ex) {

        }
        return b;
    }

    public void InsertBarang(Barang s) {
        try {
            String sql = "insert into databarang(kodebarang,namabarang,kategori,satuan,hargabarang,hargasewa,image) "
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getKodeBarang());
            ps.setString(2, s.getNamaBarang());
            ps.setString(3, s.getKategori().getKode());
            ps.setString(4, s.getSatuan());
            ps.setDouble(5, s.getHargaBarang());
            ps.setDouble(6, s.getHargasewa());
            ps.setString(7, s.getImage());
            ps.executeUpdate();
            System.out.println("Data berhasil ditambahkan");
//
            conn.commit();
            conn.close();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");

        } catch (SQLException ex) {
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteBarang(String kodeBarang) {
        try {
            String sql = "delete from databarang where kodebarang=?";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kodeBarang);
            ps.executeUpdate();
            System.out.println("Data berhasil dihapus");
//
            conn.commit();
            conn.close();

            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");

        } catch (SQLException ex) {
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateBarang(Barang b) {
        try {
            String sql = "update databarang set namabarang=?, kategori=?, satuan=?, hargabarang=?, hargasewa=?, image=? where kodebarang=?";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getNamaBarang());
            ps.setString(2, b.getKategori().getKode());
            ps.setString(3, b.getSatuan());
            ps.setDouble(4, b.getHargaBarang());
            ps.setDouble(5, b.getHargasewa());
            ps.setString(6, b.getImage());
            ps.setString(7, b.getKodeBarang());

            ps.executeUpdate();
            System.out.println("Data berhasil diubah");
//
            conn.commit();
            conn.close();

            JOptionPane.showMessageDialog(null, "Data berhasil diubah");

        } catch (SQLException ex) {
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public int kodeOtomatis(String kodemasuk) throws SQLException{
        ResultSet rset= null;
        int kode=0;
        String sql="select substr(kodebarang,7) from databarang where kodebarang like "
                +"'"+kodemasuk+"%' order by kodebarang";
        Statement stat= conn.createStatement();
        rset = stat.executeQuery(sql);
        ResultSet rset1 = null;
        String sql1="select substr(max(kodebarang),7) from databarang where kodebarang like "
                +"'"+kodemasuk+"%' order by kodebarang";
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
    
    public Barang LihatSatuBarang(String kode) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "select * from databarang where kodebarang=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, kode);
        ResultSet result = statement.executeQuery();
        Barang barangbaru = new Barang();
        while (result.next()) {
            barangbaru.setKodeBarang(result.getString(1));
            barangbaru.setNamaBarang(result.getString(2));
            Kategori kt = new Kategori();
            kt.setKode(result.getString(3));
            barangbaru.setKategori(kt);
            barangbaru.setSatuan(result.getString(4));
            barangbaru.setHargaBarang(result.getInt(5));
            barangbaru.setHargasewa(result.getInt(6));
        }
        statement.close();
        conn.commit();
        conn.close();
        return barangbaru;
    }

}
