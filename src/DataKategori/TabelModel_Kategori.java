/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataKategori;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus a455l
 */
public class TabelModel_Kategori extends AbstractTableModel {

    private List<Kategori> kat = new ArrayList<>();

    public TabelModel_Kategori(List<Kategori> kate) {
        this.kat = kate;
    }

    @Override
    public int getRowCount() {
        return kat.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kategori k = kat.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return k.getKode();
            case 2:
                return k.getNama();
            default:
                return"";
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "No";
            case 1:
                return "Kode";
            case 2:
                return "Nama Kategori";
            default:
                return "";
        }
    }

}
