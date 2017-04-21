
package gestlab.utils.tables;

import gestlab.utils.GestlabConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe per establir el color de fons de les cel·les d'una taula
 * @author manel bosch
 */
public class MyTableRenderer extends DefaultTableCellRenderer {

    /**
     * Mètode per establir el color d'una cel·la concreta d'una taula
     * @param table Taula a pintar
     * @param value valor de la cel·la a comparar
     * @param isSelected indica si la cel·la està seleccionada
     * @param hasFocus indica si la cel·la té el focus
     * @param row fila de la taula
     * @param col columan de la taula
     * @return el component per aquella  cel·la amb el color especificat
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
                                                    boolean hasFocus, int row, int col) {
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        float valueF = 0;
        if(value instanceof Float){
            valueF = (float) value;
        }
        if (valueF <= GestlabConstants.MIN_STOCK){//Comparem el valor de la cel·la amb la quantitat mínima d'estoc indicada
            comp.setBackground(Color.red);
        }else{
            comp.setBackground(Color.white);
        }
        return comp;
    }
}

