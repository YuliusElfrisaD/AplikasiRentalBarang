/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import Databarang.Barang;
import Databarang.KontrolBarang;
import Koneksi.koneksiOracle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aweng
 */
public class Kontrol_DetailTransaksi {

    private Connection conn;

    public Kontrol_DetailTransaksi(Connection koneksi) {
        this.conn = koneksi;
    }

    public static Kontrol_DetailTransaksi getkoneksi() throws SQLException {
        koneksiOracle k = new koneksiOracle();
        Kontrol_DetailTransaksi kon = new Kontrol_DetailTransaksi(k.getKoneksiOracleDB());
        return kon;
    }

    public int kodeOtomatis() throws SQLException {
        ResultSet rset = null;
        int bantu = 0;
        String sql = "select max(id) from detailtransaksi";
        Statement stat = conn.createStatement();
        rset = stat.executeQuery(sql);
        while (rset.next()) {
            bantu = rset.getInt(1) + 1;
        }
        conn.close();
        return bantu;
    }

    public void InsertDetailTransaksi(DetailTransaksi tr) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "insert into detailtransaksi (id,kodebarang,jumlahpinjam,lamapinjam,totalharga,idtransaksi) values (?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, tr.getId());
        statement.setString(2, tr.getKodebarang().getKodeBarang());
        statement.setInt(3, tr.getJumlahBarang());
        statement.setInt(4, tr.getLamaPinjam());
        statement.setDouble(5, tr.getTotalHarga());
        statement.setString(6, tr.getIdTranksai().getIdTransaksi());
        statement.executeUpdate();
        statement.close();
        conn.commit();
        conn.close();
    }

    public void DeleteDetailTransaksi(String kode) {
        try {
            String sql = "delete from detailtransaksi where id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, kode);
            st.executeUpdate();

            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Kontrol_DetailTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UpdateDetailTransaksi(DetailTransaksi tr) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "update detailtransaksi set kodebarang=?, jumlahpinjam=?, lamapinjam=?, totalharga=?, idtransaksi=? where id =?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(6, tr.getId());
        statement.setString(1, tr.getKodebarang().getKodeBarang());
        statement.setInt(2, tr.getJumlahBarang());
        statement.setInt(3, tr.getLamaPinjam());
        statement.setDouble(4, tr.getTotalHarga());
        statement.setString(5, tr.getIdTranksai().getIdTransaksi());
        statement.executeUpdate();
        statement.close();
        conn.commit();
        conn.close();
    }

    public List<DetailTransaksi> tampilDataDetailTransaksi(String ID) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "select * from detailtransaksi where idtransaksi='" + ID + "' order by id desc";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        List<DetailTransaksi> tr = new ArrayList<DetailTransaksi>();
        while (result.next()) {
            DetailTransaksi t = new DetailTransaksi();
            t.setId(result.getString(1));
            Barang b = new Barang();
            b.setKodeBarang(result.getString(2));
            Barang brg = KontrolBarang.getKoneksi().LihatSatuBarang(b.getKodeBarang());
            b.setNamaBarang(brg.getNamaBarang());
            t.setKodebarang(b);

            t.setJumlahBarang(result.getInt(3));
            t.setLamaPinjam(result.getInt(4));
            t.setTotalHarga(result.getLong(5));

            Transaksi kt = new Transaksi();
            kt.setIdTransaksi(result.getString(6));
            t.setIdTranksai(kt);

            tr.add(t);
        }
        statement.close();
        conn.commit();
        conn.close();
        return tr;
    }

    public DetailTransaksi LihatSatuBarang(String kode) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "select * from detailtransaksi where id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, kode);
        ResultSet result = statement.executeQuery();
        DetailTransaksi t = new DetailTransaksi();
        while (result.next()) {
            t.setId(result.getString(1));
            Barang b = new Barang();
            b.setKodeBarang(result.getString(2));
            Barang brg = KontrolBarang.getKoneksi().LihatSatuBarang(b.getKodeBarang());
            t.setKodebarang(b);
            b.setNamaBarang(brg.getNamaBarang());

            t.setJumlahBarang(result.getInt(3));
            t.setLamaPinjam(result.getInt(4));
            t.setTotalHarga(result.getLong(5));

            Transaksi kt = new Transaksi();
            kt.setIdTransaksi(result.getString(6));
            t.setIdTranksai(kt);
        }
        statement.close();
        conn.commit();
        conn.close();
        return t;
    }

    public long totalHargaDataDetailTransaksi(String ID) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "select * from detailtransaksi where idtransaksi='" + ID + "' order by id desc";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        long total = 0;
        while (result.next()) {
            total += result.getLong(5);
        }
        statement.close();
        conn.commit();
        conn.close();
        return total;
    }

    public int jumlahBarangDataDetailTransaksi(String ID) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "select * from detailtransaksi where idtransaksi='" + ID + "' order by id desc";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        int total = 0;
        while (result.next()) {
            total += result.getInt(3);
        }
        statement.close();
        conn.commit();
        conn.close();
        return total;
    }
}
