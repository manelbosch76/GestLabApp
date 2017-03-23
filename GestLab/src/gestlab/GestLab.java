package gestlab;

import gestlab.model.Usuario;
import gestlab.view.GestLabFrame;
import gestlab.view.Login;

/**
 *
 * @author manel bosch
 */
public class GestLab {
    
    public static GestLabFrame gestlabFrame;
    public static Login login;
    public static Usuario usuario;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        usuario = new Usuario(Long.valueOf(10),"jordi","jordi","64591021G","Jordi","Albareda","joalba@gmail.com","633441572", true);
        gestlabFrame = new GestLabFrame(usuario);
        gestlabFrame.setVisible(true);
        
    }
    
}
