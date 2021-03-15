/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Databarang;

import DataKategori.Kategori;
import Databarang.Barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author basisc16
 */
public class TabelModel_Barang extends AbstractTableModel{

    private List<Barang> bar = new ArrayList<>();

    public TabelModel_Barang(List<Barang> b) {
        this.bar = b;
    }

    @Override
    public int getRowCount() {
        return bar.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Barang ba = bar.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return ba.getKodeBarang();
            case 2:
                return ba.getNamaBarang();
            case 3:
                return ba.getKategori().getKode();
            case 4:
                return ba.getSatuan();
            case 5:
                return ba.getHargaBarang();
            case 6:
                return ba.getHargasewa();
            case 7:
                return ba.getImage();

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
                return "Kode Barang";
            case 2:
                return "Nama Barang";
            case 3:
                return "Kategori";
            case 4:
                return "Satuan";
            case 5:
                return "Harga Barang";
            case 6:
                return "Harga Sewa";
            case 7:
                return "Image";
            default:
                return "";
        }
    }
}
