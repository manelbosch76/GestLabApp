
package gestlab.view;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe per testar el funcionament de la classe Login que ha de permetre l'accés al programa principal
 * @author manel bosch
 */
public class PE_01 {

    /**
     * Test of checkData method, of class Login.
     * @author manel bosch
     */
    @Test
    public void PE_01_01() {
        System.out.println("checkData");
        Login instance = new Login();
        assertEquals(false, instance.checkData("99998663J", "maria"));//Login incorrecte
        assertEquals(false, instance.checkData("99998663A", "maria"));//Password incorreccte, sense codificar
        String pass = instance.encodePasswd(new char[]{'m','a','r','i','a'});
        assertEquals(true, instance.checkData("99998663A", pass));//Correcte
    }

    /**
     * Test of checkLogin method, of class Login.
     * @author manel bosch
     */
    @Test
    public void PE_01_02() {
        System.out.println("checkLogin");
        Login instance = new Login();
        assertEquals(false, instance.checkLogin("786"));//Login més curt
        assertEquals(false, instance.checkLogin("99998663AJ"));//Login més llarg
        assertEquals(true, instance.checkLogin("99998663A"));//Login mida correcte
    }

    /**
     * Test of checkPassword method, of class Login.
     * @author manel bosch
     */
    @Test
    public void PE_01_03() {
        System.out.println("checkPassword");
        Login instance = new Login();
        assertEquals(false, instance.checkPassword(new char[]{'m'}));//Password més curt
        assertEquals(true, instance.checkPassword(new char[]{'m','a','r','i','a'}));//Password mida correcte
    }
}
