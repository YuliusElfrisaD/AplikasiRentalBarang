/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLaporan;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Cancan
 */
public class CenterRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
setHorizontalAlignment(SwingConstants.CENTER); return this; }
    
//    public CenterRenderer() {
//        super();
//        setHorizontalAlignment(SwingConstants.CENTER);
//        
//    }
}
