/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import DataPelanggan.Pelanggan;
import Databarang.KontrolBarang;
import Koneksi.koneksiOracle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus a455l
 */
public class Kontrol_Transaksi {

    private Connection conn;

    public Kontrol_Transaksi(Connection koneksi) {
        this.conn = koneksi;
    }

    public static Kontrol_Transaksi getKoneksi() {
        koneksiOracle k = new koneksiOracle();
        Kontrol_Transaksi kon = new Kontrol_Transaksi(k.getKoneksiOracleDB());
        return kon;
    }

    public int kodeOtomatisCekKosong(Date tgl) throws SQLException {
        ResultSet rset = null;
        String sql = "select idtransaksi from transaksi where tanggal = '" + tgl + "%' order by idtransaksi desc";
        Statement stat = conn.createStatement();
        rset = stat.executeQuery(sql);
        ResultSet rset1 = null;
        String sql1 = "select max(idtransaksi) from transaksi where tanggal = '" + tgl + "%' order by idtransaksi desc";
        Statement stat1 = conn.createStatement();
        rset1 = stat1.executeQuery(sql1);
        int kodeT = 0;
        int bantu = 0;
        boolean x = false;
        while (rset.next()) {
            String[] id = rset.getString(1).split("/");//0 TR 1 IN tgl 2 bln 3 thn 4 id 5
            if (bantu != new Integer(id[5])) {
                kodeT = bantu;
                x = true;
                break;
            }
            bantu++;
        }
        if (x == false) {
            kodeT = 0;
            while (rset1.next()) {
                kodeT = rset1.getInt(1);
            }
        }
        conn.close();
        return kodeT;
    }
    
    public int kodeOtomatis(Date tgl, String pelanggan) throws SQLException {
        ResultSet rset = null;

        int kode = 0;
        String sql = "select substr(idtransaksi,42) from transaksi "
                + "where To_char(tanggal,'YYYY-MM-DD')='" + tgl + "' and idpelanggan='" + pelanggan + "'"
                + " order by idtransaksi desc";
        Statement stat = conn.createStatement();
        rset = stat.executeQuery(sql);
        ResultSet rset1 = null;

        String sql1 = "select substr(max(idtransaksi),42) from transaksi"
                 + "where To_char(tanggal,'YYYY-MM-DD')='" + tgl + "' and idpelanggan='" + pelanggan + "'"
                + " order by idtransaksi desc";
        Statement stat1 = conn.createStatement();
        rset1 = stat1.executeQuery(sql);
        int bantu = 1;
        boolean x = false;

        while (rset.next()) {

            if (bantu != rset.getInt(1)) {
                kode = bantu - 1;
                x = true;
                break;
            }
            bantu++;

        }
        if (x == false) {
            kode = 0;
            while (rset1.next()) {
                kode = rset1.getInt(1);
            }
        }

        stat.close();
        conn.close();
        return kode;
    }

    public void InsertTransaksi(Transaksi tr) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "insert into transaksi (idtransaksi,idpelanggan,jumlahbarang,totalharga,jaminan,tanggal) values (?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, tr.getIdTransaksi());
        statement.setString(2, tr.getIdPelangan().getKode());
        statement.setInt(3, tr.getJumlahBarang());
        statement.setDouble(4, tr.getTotalHarga());
        statement.setString(5, tr.getJaminan());
        statement.setDate(6, new java.sql.Date(tr.getTanggal().getTime()));
        statement.executeUpdate();
        statement.close();
        conn.commit();
        conn.close();
    }

    public void DeleteTransaksi(String kode) {
        try {
            String sql = "delete from transaksi where idtransaksi=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, kode);
            st.executeUpdate();

            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

    public void UpdateTransaksi(Transaksi tr) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "update transaksi set idpelanggan=?, jumlahbarang=?, totalharga=?, jaminan=?, tanggal=? where idtransaksi =?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(6, tr.getIdTransaksi());
        statement.setString(1, tr.getIdPelangan().getKode());
        statement.setInt(2, tr.getJumlahBarang());
        statement.setDouble(3, tr.getTotalHarga());
        statement.setString(4, tr.getJaminan());
        statement.setDate(5, new java.sql.Date(tr.getTanggal().getTime()));
        statement.executeUpdate();
        statement.close();
        conn.commit();
        conn.close();
    }

    public List<Transaksi> tampilDataTransaksi() throws SQLException {
        conn.setAutoCommit(false);
        String sql = "select * from transaksi order by idtransaksi desc";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        List<Transaksi> tr = new ArrayList<Transaksi>();
        while (result.next()) {
            Transaksi t = new Transaksi();
            t.setIdTransaksi(result.getString(1));

            Pelanggan kt = new Pelanggan();
            kt.setKode(result.getString(2));
            t.setIdPelangan(kt);

            t.setJumlahBarang(result.getInt(3));
            t.setTotalHarga(result.getLong(4));
            t.setJaminan(result.getString(5));
            t.setTanggal(result.getDate(6));
            tr.add(t);
        }
        statement.close();
        conn.commit();
        conn.close();
        return tr;
    }

    public Transaksi LihatSatuBarang(String kode) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "select * from transaksi where idtransaksi=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, kode);
        ResultSet result = statement.executeQuery();
        Transaksi t = new Transaksi();
        while (result.next()) {
            t.setIdTransaksi(result.getString(1));

            Pelanggan kt = new Pelanggan();
            kt.setKode(result.getString(2));
            t.setIdPelangan(kt);

            t.setJumlahBarang(result.getInt(3));
            t.setTotalHarga(result.getLong(4));
            t.setJaminan(result.getString(5));
            t.setTanggal(result.getDate(6));
        }
        statement.close();
        conn.commit();
        conn.close();
        return t;
    }

    public boolean cariKodePelanggan(String kode) throws SQLException{
        conn.setAutoCommit(false);
        String sql = "select * from pelanggan where kode = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.set
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        boolean bantu=false;
        while (rs.next()){
            if (kode.equals(rs.getString(1))) {
                bantu = true;
            }
        }
        ps.close();
        conn.commit();
        conn.close();
        return bantu;
    }
    
}




