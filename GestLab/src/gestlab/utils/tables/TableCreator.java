
package gestlab.utils.tables;

import java.util.List;

/**
 * Classe que permet crear les diferents taules a mostrar a la interfície
 * @author manel bosch
 */
public class TableCreator {
    
    private static final String[] CLIENTHEADERS = {"DNI","Nom","Cognom","E-mail","Telefon"};
    private static final String[] COMPANYHEADERS = {"NIF","Nom","Adreça"};
    private static final String[] PRODUCTHEADERS = {"ID","Nom","Casa_Comercial","Referencia","Quantitat","Unitats"};
    private static final String[] EQUIPHEADERS = {"ID","Nom","Marca","Model","Num_Inventari","Llogat"};
    
    /**
     * Crea una Taula model amb la llista de tots els usuaris a la base de dades
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
     * Mètode per obtenir les capçaleres en funció de la classe a mostrar
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
            case "Equipo": headers = EQUIPHEADERS.clone();
                break;
        }
        return headers;
    }
}
