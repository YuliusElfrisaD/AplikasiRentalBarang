/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPelanggan;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author basisc13
 */
public class TabelModel_Pelanggan extends AbstractTableModel {

    private List<Pelanggan> kat = new ArrayList<>();

    public TabelModel_Pelanggan(List<Pelanggan> kar) {
        this.kat = kar;
    }

    @Override
    public int getRowCount() {
        return kat.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pelanggan k = kat.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return k.getKode();
            case 2:
                return k.getNama();
            case 3:
                return k.getEmail();
            case 4:
                return k.getTelp();
            case 5:
                return k.getAlamat();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Kode";
            case 2:
                return "Nama Pelanggan";
            case 3:
                return "Email Pelanggan";
            case 4:
                return "Telp Pelanggan";
            case 5:
                return "Alamat Pelanggan";
            default:
                return "";
        }
    }
}
