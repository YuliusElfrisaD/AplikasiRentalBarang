/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLaporan;


import DataPelanggan.*;
import DataSatuan.*;
import DataKategori.*;
import DataBarang.*;
import Transaksi.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author basisb12
 */
public class TabelModel_Laporan extends AbstractTableModel {
    private List<Transaksi> laporan = new ArrayList<Transaksi>();

    public TabelModel_Laporan(List<Transaksi> lprn) {

        this.laporan = lprn;
    }

    @Override
    public int getRowCount() {
        return laporan.size();
    }

     @Override
    public int getColumnCount() {
        return 7;//menampil kan jumlah kolom
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaksi t = laporan.get(rowIndex);
//        DetailTransaksi d = dtr.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return t.getIdTransaksi();
            case 2:
                return t.getTanggal();
            case 3:
                return t.getIdPelangan().getKode();
            case 4:
                return t.getJumlahBarang();
            case 5:
                return t.getTotalHarga();
            case 6:
                return t.getJaminan();
            default:
                ;
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No.";
            case 1:
                return "ID Transaksi";
            case 2:
                return "Tanggal Rental";
            case 3:
                return "Nama Pelanggan";
            case 4:
                return "Jumlah Barang";
            case 5:
                return "Total Harga";
            case 6:
                return "Jaminan";
            default:
                ;
                return "";
        }
    }
}

