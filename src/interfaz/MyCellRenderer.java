// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package interfaz;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

//https://coderanch.com/t/641342/java/Changing-color-JList-item

public class MyCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {  
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );  
            if (value.toString().contains("Con")) {
                if (value.toString().contains("No")) {
                    c.setBackground( Color.orange );
                } else {
                    c.setBackground( Color.green );
                }
            } else {
                if (value.toString().contains("No")) {  
                    c.setBackground( Color.blue.brighter());
                } else {
                    c.setBackground( Color.yellow );
                }
            }  
            return c;  
        }  
}
