package gestlab;

import gestlab.model.Usuario;
import gestlab.view.GestLabFrame;
import gestlab.view.Login;

/**
 * Classe que gestiona l'inici del programa
 * @author manel bosch
 */
public class GestLab {
    
    public static GestLabFrame gestlabFrame;
    public static Login login;
    public static Usuario usuario;

    /**
     * Mètode principal
     * @author manel bosch
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        login = new Login();
        login.setVisible(true);
       
    }
    
}
