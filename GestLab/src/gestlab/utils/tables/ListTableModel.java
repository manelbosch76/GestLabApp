
package gestlab.utils.tables;

import gestlab.model.Cliente;
import gestlab.model.Empresa;
import gestlab.model.Equipo;
import gestlab.model.HistorialEquipos;
import gestlab.model.HistorialProductos;
import gestlab.model.Producto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

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
                    default: return null;
                }
            case "HistorialProductos":
                HistorialProductos hp = (HistorialProductos) list.get(row);
                switch(col){
                    case 0: return hp.getIdproducto().getId();
                    case 1: return hp.getIdproducto().getNombre();
                    case 2: return hp.getIdproducto().getCasaComercial();
                    case 3: return hp.getIdproducto().getReferencia();
                    case 4: return hp.getCantidad(); 
                    case 5: return hp.getIdproducto().getUnidades();
                    case 6: return hp.getFechaCompra();
                    default: return null;
                }
            case "Equipo":
                Equipo equipo = (Equipo) list.get(row);
                switch(col){
                    case 0: return equipo.getId();
                    case 1: return equipo.getNombre();
                    case 2: return equipo.getMarca();
                    case 3: return equipo.getModelo();
                    case 4: return equipo.getNumeroInventario();
                    case 5: return isRented(equipo.getEstadoAlquiler());
                    default: return null;
                }
            case "HistorialEquipos":
                HistorialEquipos he = (HistorialEquipos) list.get(row);
                switch(col){
                    case 0: return he.getIdequipo().getId();
                    case 1: return he.getId();
                    case 2: return he.getIdequipo().getNombre();
                    case 3: return he.getIdequipo().getNumeroInventario();
                    case 4: return he.getInicioAlquiler();
                    case 5: return he.getFinalAlquiler();
                    default: return null;
                }
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
    
    /**
     * Mètode per convertir un booleà en text que indiqui Si o No
     * @param b booleà
     * @return Si o No essent Si que està reservat i No que està disponible
     */
    private String isRented(Boolean b){
        if(b == true ){
            return "Si";
        }else{
            return "No";
        }
    }
}
