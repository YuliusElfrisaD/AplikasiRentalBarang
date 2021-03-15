/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus a455l
 */
public class Cara_PreparedStatement {

    //Buat objek dan method terlebih dahulu
    private Connection conn;

    public Cara_PreparedStatement(Connection koneksi) {
        this.conn = koneksi;
    }

    public static Cara_PreparedStatement getKoneksi() {
        koneksiOracle k = new koneksiOracle();
        Cara_PreparedStatement kon = new Cara_PreparedStatement(k.getKoneksiOracleDB());
        return kon;
    }

    public void tampilLoginPrepareStatement() {
        try {
            String sql = "select * from login";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(3));
            }
            conn.commit();
            conn.close();
        } catch (SQLException ex) {

        }
    }

    public void InsertdataLoginPrepareStatement() {
        try {
            String id = "1";
            String nama = "Budi";
            String username = "budi";
            String password = "12345678";
            String status = "administrator";

            String sql = "insert into login(id,nama,username,password,status) values(?,?,?,?,?)";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, nama);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, status);

            ps.executeUpdate();
            System.out.println("Data berhasil ditambahkan");
//
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteLoginPrepareStatement() {
        try {
            String id = "1";
            String sql = "delete from login where id=?";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Data berhasil dihapus");
//
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateLoginPrepareStatement() {
        try {
            String id = "1";
            String nama = "Anto";
            String username = "anto";
            String password = "12345678";
            String status = "administrator";

            String sql = "update login set nama=?,username=?,password=?,status=? where id=?";
            //
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(5, id);
            ps.setString(1, nama);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, status);
            
            ps.executeUpdate();
            System.out.println("Data berhasil diubah");
//
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
