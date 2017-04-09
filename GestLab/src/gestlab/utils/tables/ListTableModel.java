
package gestlab.utils.tables;

import gestlab.model.Cliente;
import gestlab.model.Empresa;
import gestlab.model.Producto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Classe que estableix com seran les taules model a mostrar en la interfície
 * @author manel bosch
 */
   
 /**
 * Classe que estableix com seran les taules model a mostrar en la interfície 
 * independentment de l'element a mostrar
 * @author manel bosch
 * @param <T> tipus d'objecte per crear la taula model
 */
public class ListTableModel <T> extends DefaultTableModel {

    private List <T> list=null;
    Class auxClass;
    
    /**
     * Constructor
     * @author manel bosch
     * @param objectList llista d'objectes a mostrar a la taula
     * @param objectClass Classe dels objectes de la llista
     * @param columnHeaders vector amb les capçaleres de cada columna
     */
    ListTableModel (List <T> objectList, Class objectClass, String [] columnHeaders){
        super(columnHeaders, 0);
        this.list=objectList;
        auxClass=objectClass;
    }
    
    /**
     * Mètode per actualitzar la llista del model
     * @author manel bosch
     * @param list new list of the model
     */
    public void setList(List<T> list) {
        this.list = list;
    }
    
    /**
    * Mètode per retornar el número de files amb dades
    * @author manel bosch
    * @return number of rows with data
    */
    @Override
    public int getRowCount() {
        if (list==null){
            return 0;
        } else {
            return list.size();
        }
    }
    
    /**
     * mètoe per retornar l'objecte a la fila i columan indicats per paràmetre
     * @author manel bosch
     * @param row  fila de l'objecte a mostrar
     * @param col  columna de l'objecte a mostrar
     * @return  objecte a mostrar
     **/
    @Override
    public Object getValueAt(int row, int col) {
        String name = auxClass.getSimpleName();
        switch (name) {
            case "Cliente":
                Cliente c = (Cliente) list.get(row);
                switch(col){
                    case 0: return c.getDni();
                    case 1: return c.getNombre();
                    case 2: return c.getPrimerApellido();
                    case 3: return c.getEmail();
                    case 4: return c.getTelefono();
                    default: return null;
                }
            case "Empresa":
                Empresa e = (Empresa) list.get(row);
                switch(col){
                    case 0: return e.getNif();
                    case 1: return e.getNombreEmpresa();
                    case 2: return e.getDireccionEmpresa();
                    default: return null;
                }
            case "Producto":
                Producto p = (Producto) list.get(row);
                switch(col){
                    case 0: return p.getId();
                    case 1: return p.getNombre();
                    case 2: return p.getCasaComercial();
                    case 3: return p.getReferencia();
                    case 4: return p.getCantidad();
                    case 5: return p.getUnidades();
                }
            //case "Equip":
        default: return null;
        }
    }
    
    /**
     * Mètode que indica que la taula no és editable
     * @author manel bosch
     * @param row s'ignora
     * @param column s'ignora
     * @return false
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
