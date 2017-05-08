
package gestlab.view;

import gestlab.model.Usuario;
import gestlab.restfulclient.UsuarioClientSsl;
import javax.swing.JPasswordField;
import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import utils.TestUtils;

/**
 * Classe per testar el canvi de password
 * @author manel bosch
 */
public class PE_02 {
    
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
    public void PE_02_01() {
        System.out.println("checkPasswd");
        PasswordDialog instance = new PasswordDialog(null, true, usuario);
        
        JPasswordField textOld = (JPasswordField)TestUtils.getChildNamed(instance, "old");
        JPasswordField textNew1 = (JPasswordField)TestUtils.getChildNamed(instance, "new1");
        JPasswordField textNew2 = (JPasswordField)TestUtils.getChildNamed(instance, "new2");
        
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
        
        //contrasenyes noves buides (més petites que les demanades)
        textOld.setText("maria");
        textNew1.setText("");
        textNew2.setText("");
        assertFalse(instance.checkPasswd());
        
        //contrasenyes noves iguals a l'antiga
        textOld.setText("maria");
        textNew1.setText("maria");
        textNew2.setText("maria");
        assertFalse(instance.checkPasswd());
        
        //correcte
        textOld.setText("maria");
        textNew1.setText("manel");
        textNew2.setText("manel");
        assertTrue(instance.checkPasswd());
    }
    
}
