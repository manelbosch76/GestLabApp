
package gestlab.view;

import gestlab.model.Producto;
import gestlab.model.Usuario;
import gestlab.restfulclient.ProductoClientSsl;
import gestlab.restfulclient.UsuarioClientSsl;
import javax.swing.JTextField;
import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import utils.TestUtils;

/**
 * Classe per provar la classe BuyProductDialog
 * @author manel bosch
 */
public class PE_17 {
    
    private Producto producto;
    private static Usuario usuario;
    private static UsuarioClientSsl uClient;
    private static ProductoClientSsl pClient;
    private float realQuantity;
    
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
    public void PE_17_01() {
        System.out.println("correctAmount");
        BuyProductDialog instance = new BuyProductDialog(null,true,usuario,null,producto);
        
        //Entro dates en la casella de text de la interfície
        JTextField text = (JTextField)TestUtils.getChildNamed(instance, "quantityText");
        text.setText("pep");//Incorrecte: no és float
        assertEquals(false, instance.correctAmount());
        
        //Incorrecte: quantitat major que el stock. 
        text.setText("225");
        assertEquals(false, instance.correctAmount());
        
        text.setText("100.25");//Correcte
        assertEquals(true, instance.correctAmount());
    }
    
    /**
     * Mètode per testar si es fa correctament el update del producte
     * @author manel bosch
     */
    @Test
    public void PE_17_02(){
        System.out.println("updateProduct");
        //Per fer la prova ho faig amb un producte real de la base de dades
        producto = pClient.find_JSON(Producto.class, "3");
        BuyProductDialog instance = new BuyProductDialog(null,true,usuario,null,producto);

        realQuantity = producto.getCantidad();
        float newQuantity = (float) (realQuantity*0.5);
        instance.updateProduct(newQuantity);//Quantitat diferent a la que tenia definida
        producto = pClient.find_JSON(Producto.class, "3");
        assertEquals(newQuantity, producto.getCantidad(),0);
        
        producto.setCantidad(realQuantity);//Retorno la quantitat inicial al producte
        pClient.edit_JSON(producto, "3");
    }
}
