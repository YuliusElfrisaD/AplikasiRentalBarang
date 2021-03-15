/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSatuan;

import DataKategori.*;
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
public class Kontrol_Satuan {

    //Buat objek dan method terlebih dahulu
    private Connection conn;

    public Kontrol_Satuan(Connection koneksi) {
        this.conn = koneksi;
    }

    public static Kontrol_Satuan getKoneksi() {
        koneksiOracle k = new koneksiOracle();
        Kontrol_Satuan kon = new Kontrol_Satuan(k.getKoneksiOracleDB());
        return kon;
    }

    public int kodeOtomatis(String kodemasuk) throws SQLException{
        ResultSet rset= null;
        int kode=0;
        String sql="select substr(kodesatuan,2) from satuan where"
                + " kodesatuan like "
                +"'"+kodemasuk+"%' order by kodesatuan";
        Statement stat= conn.createStatement();
        rset = stat.executeQuery(sql);
        ResultSet rset1 = null;
        String sql1="select substr(max(kodesatuan),2) from satuan where "
                + "kodesatuan like "
                +"'"+kodemasuk+"%' order by kodesatuan";
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
    
     public Satuan CariSatuan(String kode) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "select * from satuan where kodesatuan=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, kode);
        ResultSet result = statement.executeQuery();
        Satuan kat = new Satuan();
        while (result.next()) {
            kat.setKode(result.getString(1));
            kat.setNama(result.getString(2));
        }
        statement.close();
        conn.commit();
        conn.close();
        return kat;
    }
    
    public List<Satuan> tampilSatuan() {
        ArrayList<Satuan> kat = new ArrayList<>();
        try {
            String sql = "select * from satuan order by kodesatuan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Satuan kate = new Satuan();
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

    public void InsertSatuan(Satuan s) {
        try {

            String sql = "insert into satuan(kodesatuan,namasatuan) values(?,?)";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getKode());
            ps.setString(2, s.getNama());

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

    public void DeleteSatuan(String kode) {
        try {
            String sql = "delete from satuan where kodesatuan=?";
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

    public void UpdateSatuan(Satuan s) {
        try {
            String sql = "update satuan set namasatuan=? where kodesatuan=?";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getNama());
            ps.setString(2, s.getKode());
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
    
    
}
