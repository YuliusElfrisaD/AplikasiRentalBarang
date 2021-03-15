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
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Asus a455l
 */
public class koneksiOracle {

    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    String userId = "HR";
    String password = "hr";
    Connection conn;

    public koneksiOracle() {

    }

    public Connection getKoneksiOracleDB() {
        try {
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdbcUrl);
            conn = ds.getConnection(userId, password);
            System.out.println("Berhasil terhubung ke Oracle");
        } catch (SQLException ex) {
            System.out.println("Gagal terhubung ke Oracle");
        }
        return conn;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Tidak bisa tutup koneksi");
        }
    }

    public void tampilEmployee() {
        try {
            String sql = "select * from employees where employee_id in (201,202,203) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("First_Name") +" Nama Pegawai : "+rs.getString(2));
            }
                    
        } catch (SQLException ex) {
        
        }

    }

    public static void main(String[] args) {
        koneksiOracle c = new koneksiOracle();
        c.getKoneksiOracleDB();
        
    }

}
