package DataLaporan;

import DataPelanggan.*;
import DataSatuan.*;
import DataKategori.*;
import DataBarang.*;
import Transaksi.*;
import Koneksi.koneksiOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Laporan_Kontrol {

    private Connection conn;

    public Laporan_Kontrol(Connection koneksi) {
        this.conn = koneksi;
    }

    public Laporan_Kontrol() {
    }

    public static Laporan_Kontrol getkoneksi() throws SQLException {//membuat koneksi dikontrol dengan memanggil kelas koneksi
        koneksiOracle k = new koneksiOracle();
        Laporan_Kontrol ko = new Laporan_Kontrol(k.getKoneksiOracleDB());
        return ko;
    }

    public List<Transaksi> getAllLaporan(Date tgl1, Date tgl2) throws SQLException {
        PreparedStatement psmt = null;
        ResultSet result = null;
        conn.setAutoCommit(false);
//        String sql = "select k.kodebarang, b.namabarang, SUM(k.masuk-k.keluar), b.belisetelah from KARTUSTOK k left join barang b on k.kodebarang=b.kodebarang where b.kodebarang in(select kodebarang from KARTUSTOK where tanggal between ? and ?) group by k.kodebarang, b.namabarang, b.belisetelah";
//        String sql = "select ID_TRANSAKSI, TANGGAL, id_PELANGGAN, JUMLAH_BARANG, "
//                + "TOTAL_HARGA, JAMINAN from transaksi "
//                + "where To_char(tanggal,'YYYY-MM-DD') between "+tgl1+" and "+tgl2+" ";
        String sql = "select IDTRANSAKSI, IDPELANGGAN, JUMLAHBARANG, "
                + "TOTALHARGA, JAMINAN, TANGGAL from transaksi "
                + "where tanggal between ? and ? ";
        psmt = conn.prepareStatement(sql);
        psmt.setDate(1, new java.sql.Date(tgl1.getTime()));
        psmt.setDate(2, new java.sql.Date(tgl2.getTime()));
        result = psmt.executeQuery();
        List<Transaksi> tr = new ArrayList<Transaksi>();
        while (result.next()) {
            Transaksi t = new Transaksi();
            t.setIdTransaksi(result.getString(1));

            Pelanggan pl = new Pelanggan();
            pl.setKode(result.getString(2));
            t.setIdPelangan(pl);
            t.setJumlahBarang(result.getInt(3));
            t.setTotalHarga(result.getLong(4));
            t.setJaminan(result.getString(5));
            t.setTanggal(result.getDate(6));
            tr.add(t);
        }
        psmt.close();
        conn.commit();
        conn.close();
        return tr;
    }

    public List<Transaksi> getAllLaporan() throws SQLException {
        PreparedStatement psmt = null;
        ResultSet rset = null;
        conn.setAutoCommit(false);
//        String sql = "select k.kodebarang, b.namabarang, SUM(k.masuk-k.keluar), b.belisetelah from KARTUSTOK k left join barang b on k.kodebarang=b.kodebarang where b.kodebarang in(select kodebarang from KARTUSTOK where tanggal between ? and ?) group by k.kodebarang, b.namabarang, b.belisetelah";
        String sql = "select IDTRANSAKSI, IDPELANGGAN, JUMLAHBARANG, "
                + "TOTALHARGA, JAMINAN, TANGGAL from transaksi";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        List<Transaksi> tr = new ArrayList<Transaksi>();
        while (result.next()) {
             Transaksi t = new Transaksi();
            t.setIdTransaksi(result.getString(1));

            Pelanggan pl = new Pelanggan();
            pl.setKode(result.getString(2));
            t.setIdPelangan(pl);
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
}
