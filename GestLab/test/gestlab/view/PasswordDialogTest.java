
package gestlab.view;

import gestlab.model.Usuario;
import gestlab.restfulclient.UsuarioClientSsl;
import javax.swing.JTextField;
import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import utils.TestUtils;

/**
 * Classe per testar el canvi de password
 * @author manel
 */
public class PasswordDialogTest {
    
    static Usuario usuario;
    private UsuarioClientSsl uClient;
    
    /**
     * Mètode per accedir al sistema com a usuari correcte
     * @author manel bosch
     */
    @Before
    public void setUp() {
        byte[]  bytesEncoded = Base64.encodeBase64("maria".getBytes());
        uClient = new UsuarioClientSsl("99998663A", new String(bytesEncoded));//Accedeixo amb un usuari existent
        usuario = uClient.find_JSON(Usuario.class, "99998663A");
    }
    
    /**
     * Mètode per tancar el client d'accés al sistema creat per fer les proves
     * @author manel bosch
     */
    @After
    public void tearDown() {
        uClient.close();
    }

    /**
     * Test of checkPasswd method, of class PasswordDialog.
     * @author manel bosch
     */
    @Test
    public void testCheckPasswd() {
        System.out.println("checkPasswd");
        PasswordDialog instance = new PasswordDialog(null, true, usuario);
        //canvio la contrasenya de l'usuari per facilitar les proves
        usuario.setContrasena("maria");
        
        JTextField textOld = (JTextField)TestUtils.getChildNamed(instance, "old");
        JTextField textNew1 = (JTextField)TestUtils.getChildNamed(instance, "new1");
        JTextField textNew2 = (JTextField)TestUtils.getChildNamed(instance, "new2");
        
        //contrasenya antiga diferent a la que té l'usuari
        textOld.setText("manel");
        textNew1.setText("maria");
        textNew2.setText("maria");
        assertFalse(instance.checkPasswd());
        
        //contrasenyes noves diferents
        textOld.setText("maria");
        textNew1.setText("manel");
        textNew2.setText("josep");
        assertFalse(instance.checkPasswd());
        
        //contrasenyes noves més curtes
        textOld.setText("manel");
        textNew1.setText("");
        textNew2.setText("");
        assertFalse(instance.checkPasswd());
        
        //correcte
        textOld.setText("maria");
        textNew1.setText("manel");
        textNew2.setText("manel");
        assertTrue(instance.checkPasswd());
    }
    
}
