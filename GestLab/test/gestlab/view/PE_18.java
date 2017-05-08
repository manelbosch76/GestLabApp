
package gestlab.view;

import gestlab.model.Equipo;
import gestlab.model.Usuario;
import gestlab.restfulclient.UsuarioClientSsl;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class PE_18 {
    
    static Equipo equipo;
    static Usuario usuario;
    private UsuarioClientSsl uClient;
    private final Date date = new Date(Calendar.getInstance().getTimeInMillis());//Data del dia actual
    Date today = java.sql.Date.valueOf(date.toString());
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
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
     * @throws java.text.ParseException
     */
    @Test
    public void PE_18_01() throws ParseException {
        System.out.println("isValidDate");
        BookEquipDialog instance = new BookEquipDialog(null,true,usuario,null,equipo);
        assertEquals(null, instance.isValidDate(""));
        assertEquals(null, instance.isValidDate("hola"));
        assertEquals(null, instance.isValidDate("2017/04/05"));//Data mal formatada
        
        String dateString = "2017-08-08";//Data correcte
        java.util.Date d = (java.util.Date) sdf.parse(dateString);
        Date sqlDate = new Date(d.getTime());//Creo la data que hauria de retornar el mètode
        assertEquals(sqlDate, instance.isValidDate(dateString));
    }
    
    /**
     * Mètode per testar si les dates de reserva són correctes
     * @author manel bosch
     */
    @Test
    public void PE_18_02() {
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
        textBegin.setText(today.toString());//Correcte però equip reservat
        textEnd.setText("2017-10-05");
        assertEquals(false, instance.checkDates());
        
        equipo.setEstadoAlquiler(false);
        textBegin.setText(today.toString());//Correcte i equip no reservat
        textEnd.setText("2017-10-05");
        assertEquals(true, instance.checkDates());
    }
}
