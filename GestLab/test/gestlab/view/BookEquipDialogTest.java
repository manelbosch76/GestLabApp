
package gestlab.view;

import gestlab.model.Equipo;
import gestlab.model.Usuario;
import gestlab.restfulclient.UsuarioClientSsl;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JTextField;
import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.TestUtils;

/**
 * Classe per poder provar la classe BookEquipDialog
 * @author manel bosch
 */
public class BookEquipDialogTest {
    
    static Equipo equipo;
    static Usuario usuario;
    private UsuarioClientSsl uClient;
    private final Date date = new Date(Calendar.getInstance().getTimeInMillis());//Data del dia actual
    Date today = java.sql.Date.valueOf(date.toString());
    
    /**
     * Mètode per accedir al sistema com a usuari correcte i crear un equip de prova per fer el test
     * @author manel bosch
     */
    @Before
    public void setUp() {
        byte[]  bytesEncoded = Base64.encodeBase64("maria".getBytes());
        uClient = new UsuarioClientSsl("99998663A", new String(bytesEncoded));//Accedeixo amb un usuari existent
        usuario = uClient.find_JSON(Usuario.class, "99998663A");
        equipo = new Equipo();
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
     * Mètode per testar si la data passada com a text és vàlida
     * @author manel bosch
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        BookEquipDialog instance = new BookEquipDialog(null,true,usuario,null,equipo);
        assertEquals(null, instance.isValidDate("12345"));
        assertEquals(null, instance.isValidDate("2017/04/05"));
        assertEquals(today, instance.isValidDate("2017-05-04"));//Modificar data perquè sigui sempre l'actual perquè funcioni
    }
    
    /**
     * Mètode per testar si les dates de reserva són correctes
     * @author manel bosch
     */
    @Test
    public void testCheckDates() {
        System.out.println("checkDates");
        BookEquipDialog instance = new BookEquipDialog(null,true,usuario,null,equipo);
        
        //Entro dates en les caselles de text de la interfície
        JTextField textBegin = (JTextField)TestUtils.getChildNamed(instance, "begin");
        JTextField textEnd = (JTextField)TestUtils.getChildNamed(instance, "end");
        textBegin.setText("2017-04-04");
        textEnd.setText("2017-04-03");//Abans de l'anterior
        assertEquals(false, instance.checkDates());
        
        textBegin.setText("2017-04-04");//Abans de l'actual
        textEnd.setText("2017-04-05");
        assertEquals(false, instance.checkDates());
        
        equipo.setEstadoAlquiler(true);
        textBegin.setText("2017-05-04");//Actual però equip reservat
        textEnd.setText("2017-05-05");
        assertEquals(false, instance.checkDates());
        
        textBegin.setText("2017-06-07");//Correcte
        textEnd.setText("2017-06-10");
        assertEquals(true, instance.checkDates());
    }
}
