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
 * @author YULIUS ELFRISA D.
 */
public class Cara_CreateStatement {
   //Buat objek dan method terlebih dahulu
    private Connection conn ;

    public Cara_CreateStatement(Connection koneksi) {
        this.conn = koneksi;
    }
     
    public static Cara_CreateStatement getKoneksi(){
        koneksiOracle k = new koneksiOracle();
        Cara_CreateStatement kon = new Cara_CreateStatement(k.getKoneksiOracleDB());
        return kon ;
    }
    
    public void tampilLoginCreateStatement(){
        try{
            String sql = "select * from login";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(3));
            }
            conn.commit();
            conn.close();
        } catch(SQLException ex){
            
        }
    }
    
    public  void InsertdataLoginCreateStatement(){
        try {
            String id = "1";
            String nama = "Budi";
            String username = "budi";
            String password = "12345678";
            String status = "administrator";
            
            String sql = "insert into login(id,nama,username,password,status)"
                    + "values('"+ id +"','"+ nama +"','"+ username +"','"+ password +"','"+ status +"')";
            //
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("Data berhasil ditambahkan");
//
            conn.commit();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteLoginCreateStatement(){
        try {
            String id = "1";
            String sql = "delete from login where id='" + id +"' ";
            //
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("Data berhasil dihapus");
//
            conn.commit();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateLoginCreateStatement(){
        try {
            String id = "1";
            String nama = "Anto";
            String username = "anto";
            String password = "12345678";
            String status = "administrator";
            
            String sql = "update login set nama='"+nama+"',"
                    + "username='"+username+"'"
                    + ",password='"+password+"'"
                    + ",status='"+status+"' where id='"+id+"'";
            //
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("Data berhasil diubah");
//
            conn.commit();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Cara_CreateStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
