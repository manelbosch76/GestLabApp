
package gestlab.view.functionality;

import java.util.List;

/**
 * Classe que permet ccrear les diferents taules a mostrar a la interfície
 * @author manel bosch
 */
public class TablesFunctionality {
    
    private static final String[] USERHEADERS = {"id","DNI","Nom","Cognom","E-mail","Telefon","Administrador"};
    
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
            case "Usuario": headers = USERHEADERS.clone();
                break;
        }
        return headers;
    }
}
