/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataKategori;

import Koneksi.*;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus a455l
 */
public class Kontrol_Kategori {

    //Buat objek dan method terlebih dahulu
    private Connection conn;

    public Kontrol_Kategori(Connection koneksi) {
        this.conn = koneksi;
    }

    public static Kontrol_Kategori getKoneksi() {
        koneksiOracle k = new koneksiOracle();
        Kontrol_Kategori kon = new Kontrol_Kategori(k.getKoneksiOracleDB());
        return kon;
    }
    
     public int kodeOtomatis() throws SQLException {
        ResultSet rset = null;
        int bantu = 0;
        String sql = "select max(kode) from kategori";
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
        String sql="select substr(kode,2) from kategori where kode like "
                +"'"+kodemasuk+"%' order by kode";
        Statement stat= conn.createStatement();
        rset = stat.executeQuery(sql);
        ResultSet rset1 = null;
        String sql1="select substr(max(kode),2) from kategori where kode like "
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

    public List<Kategori> tampilKategori() {
        ArrayList<Kategori> kat = new ArrayList<>();
        try {
            String sql = "select * from kategori order by kode";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Kategori kate = new Kategori();
                kate.setKode(rs.getString(1));
                kate.setNama(rs.getString(2));
                kat.add(kate);//Jangan lupa add ke dalam array list kategori
            }
            conn.commit();
            conn.close();
        } catch (SQLException ex) {

        }
        return kat;
    }

    public void InsertKategori(Kategori kat) {
        try {

            String sql = "insert into kategori(kode,nama) values(?,?)";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kat.getKode());
            ps.setString(2, kat.getNama());

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

    public void DeleteKategori(String kode) {
        try {
            String sql = "delete from kategori where kode=?";
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
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateKategori(Kategori kat) {
        try {
            String sql = "update kategori set nama=? where kode=?";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kat.getNama());
            ps.setString(2, kat.getKode());
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
    
    public Kategori cariKategori(String kode) throws SQLException{
        conn.setAutoCommit(false);
        String sql = "select * from kategori where kode=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        Kategori k = new Kategori();
        while (rs.next()){
            k.setKode(rs.getString(2));
            k.setNama(rs.getString(1));
        }
        ps.close();
        conn.commit();
        conn.close();
        return k;
    }
}
