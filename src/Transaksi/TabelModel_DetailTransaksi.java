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
public class TabelModel_DetailTransaksi extends AbstractTableModel {

    private List<DetailTransaksi> dtr = new ArrayList<DetailTransaksi>();

    public TabelModel_DetailTransaksi(List<DetailTransaksi> kat) {
        this.dtr = kat;
    }

    @Override
    public int getRowCount() {
        return dtr.size();
    }

    @Override
    public int getColumnCount() {
        return 6;//menampil kan jumlah kolom
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetailTransaksi k = dtr.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return k.getId();
            case 2:
                return k.getKodebarang().getNamaBarang();
            case 3:
                return k.getJumlahBarang();
            case 4:
                return k.getLamaPinjam();
            case 5:
                return k.getTotalHarga();
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
                return "ID";
            case 2:
                return "Barang";
            case 3:
                return "Jumlah";
            case 4:
                return "Lama Sewa";
            case 5:
                return "Total Harga";
            default:
                ;
                return "";
        }
    }
}
