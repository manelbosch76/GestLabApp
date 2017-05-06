
package gestlab.view;

import gestlab.model.Producto;
import gestlab.model.Usuario;
import gestlab.restfulclient.ProductoClientSsl;
import gestlab.restfulclient.UsuarioClientSsl;
import javax.swing.JTextField;
import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.TestUtils;

/**
 * Classe per provar la classe BuyProductDialog
 * @author manel bosch
 */
public class BuyProductDialogTest {
    
    static Producto producto;
    static Usuario usuario;
    private UsuarioClientSsl uClient;
    private ProductoClientSsl pClient;
    
    /**
     * Mètode per accedir al sistema com a usuari correcte i crear un producte de prova per fer el test
     * @author manel bosch
     * @throws Exception 
     */
    @Before
    public void setUp() throws Exception {
        byte[]  bytesEncoded = Base64.encodeBase64("maria".getBytes());
        uClient = new UsuarioClientSsl("99998663A", new String(bytesEncoded));//Accedeixo amb un usuari existent
        usuario = uClient.find_JSON(Usuario.class, "99998663A");
        producto = new Producto(1,"Producte_Prova", "CasaComercial_Prova", "Ref_Prova", "Unitats_Prova", 150);
        pClient = new ProductoClientSsl(usuario.getToken());
    }

    /**
     * Mètode per tancar el client d'accés al sistema creat per fer les proves
     * @author manel bosch
     * @throws Exception 
     */
    @After
    public void tearDown() throws Exception {
        uClient.close();
        pClient.close();
    }

    /**
     * Test of correctAmount method, of class BuyProductDialog
     * També serveix per comprovar el mètode correctAmount de la classe ProductDialog
     * @author manel bosch
     */
    @Test
    public void testCorrectAmount() {
        System.out.println("correctAmount");
        BuyProductDialog instance = new BuyProductDialog(null,true,usuario,null,producto);
        
        //Entro dates en la casella de text de la interfície
        JTextField text = (JTextField)TestUtils.getChildNamed(instance, "quantityText");
        text.setText("pep");//Incorrecte: no és float
        assertEquals(false, instance.correctAmount());
        
        text.setText("225");//Incorrecte: quantitat major que el stock
        assertEquals(false, instance.correctAmount());
        
        text.setText("100.25");//Correcte
        assertEquals(true, instance.correctAmount());
    }
    
    /**
     * Mètode per testar si es fa correctament el update del producte
     * @author manel bosch
     */
    @Test
    public void testUpdateProduct(){
        System.out.println("updateProduct");
        BuyProductDialog instance = new BuyProductDialog(null,true,usuario,null,producto);
        
        //Per fer la prova ho faig amb un producte real de la base de dades
        producto = pClient.find_JSON(Producto.class, "1");
        assertEquals(204, pClient.edit_JSON(producto, String.valueOf(1)));
    }
}
