
package gestlab.utils.tables;

import java.util.List;

/**
 * Classe que permet crear les diferents taules a mostrar a la interfície del programa
 * @author manel bosch
 */
public class TableCreator {
    
    private static final String[] CLIENTHEADERS = {"DNI","Nom","Cognom","E-mail","Telefon"};
    private static final String[] COMPANYHEADERS = {"NIF","Nom","Adreça"};
    private static final String[] PRODUCTHEADERS = {"ID","Nom","Casa_Comercial","Referencia","Quantitat","Unitats"};
    private static final String[] PRODUCTSCONSUMEDHEADERS = {"ID","Nom","Casa_Comercial","Referencia","Quantitat"
                                                            ,"Unitats", "Data_Compra"};
    private static final String[] EQUIPHEADERS = {"ID","Nom","Marca","Model","Num_Inventari","Reservat avui"};
    private static final String[] EQUIPSBOOKEDHEADERS = {"ID_Equip","ID_Reserva","Nom","Num_Inventari","Inici_Lloguer","Fi_Lloguer"};
    
    /**
     * Crea una Taula model amb la llista dels objectes passada com a paràmetre
     * @author manel bosch
     * @param objectClass tipus de classe sobre la que fer la taula
     * @param l lista d'objectes a afegir a la taula
     * @return taula amb els objectes
     */
    public ListTableModel createTableModel(Class objectClass, List l){
        String name = objectClass.getSimpleName();
        String[] headers = getHeaders(name);
        try{
            return new ListTableModel(
                l,
                objectClass,
                headers
            );
        }catch(Exception e){
            return null;
        }
    }
    
    /**
     * Mètode per obtenir les capçaleres de la taula en funció de la classe a mostrar
     * @author manel bosch
     * @param name nom simple de la classe a mostrar
     * @return array amb els noms de les columnes
     */
    private String[] getHeaders(String name){
        String[] headers = null;
        switch (name){
            case "Cliente": headers = CLIENTHEADERS.clone();
                break;
            case "Empresa": headers = COMPANYHEADERS.clone();
                break;
            case "Producto": headers = PRODUCTHEADERS.clone();
                break;
            case "HistorialProductos": headers = PRODUCTSCONSUMEDHEADERS.clone();
                break;
            case "Equipo": headers = EQUIPHEADERS.clone();
                break;
            case "HistorialEquipos": headers = EQUIPSBOOKEDHEADERS.clone();
                break;
        }
        return headers;
    }
}
