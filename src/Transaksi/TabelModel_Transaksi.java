/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aweng
 */
public class TabelModel_Transaksi extends AbstractTableModel {

//    private List<DetailTransaksi> dtr = new ArrayList<DetailTransaksi>();
    private List<Transaksi> tr = new ArrayList<Transaksi>();

    public TabelModel_Transaksi(List<Transaksi> dt) {
        this.tr = dt;
    }

    @Override
    public int getRowCount() {
        return tr.size();
    }

    @Override
    public int getColumnCount() {
        return 7;//menampil kan jumlah kolom
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaksi t = tr.get(rowIndex);
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
