
package gestlab.view;

import gestlab.model.Cliente;
import gestlab.model.Equipo;
import gestlab.model.HistorialEquipos;
import gestlab.model.HistorialProductos;
import gestlab.model.Producto;
import gestlab.model.Usuario;
import gestlab.restfulclient.ClienteClientSsl;
import gestlab.restfulclient.EquipoClientSsl;
import gestlab.restfulclient.HistorialEquiposClientSsl;
import gestlab.restfulclient.HistorialProductosClientSsl;
import gestlab.restfulclient.ProductoClientSsl;
import gestlab.restfulclient.UsuarioClientSsl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.ws.rs.core.GenericType;
import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.TestUtils;

/**
 * Classe per provar la classe principal (GestLabFrame) de l'aplicació
 * @author manel bosch
 */
public class PE_GestLabFrameTest {
    
    private Usuario usuario;
    
    private UsuarioClientSsl uClient;
    private ClienteClientSsl cClient;
    private ProductoClientSsl pClient;
    private EquipoClientSsl eqClient;
    private HistorialProductosClientSsl hpClient;
    private HistorialEquiposClientSsl heClient;
    
    private Cliente cliente;
    private List<Cliente> clientes;
    GenericType<List<Cliente>> gTypeClient = new GenericType<List<Cliente>>(){};
    
    private List<Producto> productos;
    GenericType<List<Producto>> gTypeProduct = new GenericType<List<Producto>>(){};
    private List<HistorialProductos> hProductos;
    GenericType<List<HistorialProductos>> gTypeHistorialProduct = new GenericType<List<HistorialProductos>>(){};
    
    private List<Equipo> equipos;
    GenericType<List<Equipo>> gTypeEquip = new GenericType<List<Equipo>>(){};
    private List<HistorialEquipos> hEquipos;
    GenericType<List<HistorialEquipos>> gTypeHistorialEquip = new GenericType<List<HistorialEquipos>>(){};
    
    /**
     * Mètode per accedir al sistema com a usuari correcte per fer el test
     * @author manel bosch
     */
    @Before
    public void setUp() {
        byte[]  bytesEncoded = Base64.encodeBase64("maria".getBytes());
        uClient = new UsuarioClientSsl("99998663A", new String(bytesEncoded));//Accedeixo amb un usuari existent
        usuario = uClient.find_JSON(Usuario.class, "99998663A");
        cClient = new ClienteClientSsl(usuario.getToken());
        pClient = new ProductoClientSsl(usuario.getToken());
        hpClient = new HistorialProductosClientSsl(usuario.getToken());
        eqClient = new EquipoClientSsl(usuario.getToken());
        heClient = new HistorialEquiposClientSsl(usuario.getToken());
    }
    
    /**
     * Mètode per tancar el client d'accés al sistema creat per fer les proves
     * @author manel bosch
     */
    @After
    public void tearDown() {
        uClient.close();
        cClient.close();
        pClient.close();
        hpClient.close();
        eqClient.close();
        hpClient.close();
    }


    /**
     * Test of fillClientsList method, of class GestLabFrame
     * @author manel bosch
     */
    @Test
    public void PE_GestLabFrameTest_04() {
        System.out.println("fillClientsList");
        GestLabFrame instance = new GestLabFrame(usuario);
        JTable table = (JTable) TestUtils.getChildNamed(instance, "clients");
        instance.fillClientsList();
        int nRows = table.getRowCount();
        clientes = cClient.findAll_JSON(gTypeClient);
        //Comprova que el número de files de la taula correspon al número de clients del servidor
        assertEquals(nRows, clientes.size());
        
    }

    /**
     * Test of fillProductsList method, of class GestLabFrame.
     * @author manel bosch
     */
    @Test
    public void PE_GestLabFrameTest_08() {
        System.out.println("fillProductsList");
        GestLabFrame instance = new GestLabFrame(usuario);
        JTable table = (JTable) TestUtils.getChildNamed(instance, "products");
        productos = pClient.findAll_JSON(gTypeProduct);
        instance.fillProductsList();
        int nRows = table.getRowCount();
        //Comprova que el número de files de la taula correspon al número de productes del servidor
        assertEquals(nRows, productos.size());
    }

    /**
     * Test of fillHistorialProductos method, of class GestLabFrame
     * @author manel bosch
     */
    @Test
    public void PE_GestLabFrameTest_24() {
        System.out.println("fillHistorialProductos");
        GestLabFrame instance = new GestLabFrame(usuario);
        JTable table = (JTable) TestUtils.getChildNamed(instance, "products");
        hProductos = hpClient.findAll_JSON(gTypeHistorialProduct);
        instance.fillHistorialProductos(hProductos);
        int nRows = table.getRowCount();
        //Comprova que el número de files de la taula correspon al número de productes comprats del servidor
        assertEquals(nRows, hProductos.size());
    }

    /**
     * Test of fillEquipsList method, of class GestLabFrame
     * @author manel bosch
     */
    @Test
    public void PE_GestLabFrameTest_11() {
        System.out.println("fillEquipsList");
        GestLabFrame instance = new GestLabFrame(usuario);
        JTable table = (JTable) TestUtils.getChildNamed(instance, "equipment");
         instance.fillEquipsList();
        int nRows = table.getRowCount();
        equipos = eqClient.findAll_JSON(gTypeEquip);
        //Comprova que el número de files de la taula correspon al número d'equips del servidor
        assertEquals(nRows, equipos.size());
    }

    /**
     * Test of fillHistorialEquipos method, of class GestLabFrame
     * @author manel bosch
     */
    @Test
    public void PE_GestLabFrameTest_23() {
        System.out.println("fillHistorialEquipos");
        GestLabFrame instance = new GestLabFrame(usuario);
        JTable table = (JTable) TestUtils.getChildNamed(instance, "equipment");
        hEquipos = heClient.findAll_JSON(gTypeHistorialEquip);
        instance.fillHistorialEquipos(hEquipos);
        int nRows = table.getRowCount();
        //Comprova que el número de files de la taula correspon al número de reserves del servidor
        assertEquals(nRows, hEquipos.size());
    }

    /**
     * Test of askForClient method, of class GestLabFrame
     * @author manel bosch
     */
    @Test
    public void PE_GestLabFrameTest_25() {
        System.out.println("askForClient");
        GestLabFrame instance = new GestLabFrame(usuario);
        JTable table = (JTable) TestUtils.getChildNamed(instance, "clients");
        
        Cliente expResult = null;
        table.clearSelection();
        instance.fillClientsList();
        Cliente result = instance.askForClient();//No hi ha cap client seleccionat per tant és null
        assertEquals(expResult, result);
        
        expResult = cClient.find_JSON(Cliente.class, "25744991K");//Busco el primer client que es llista a la taula
        table.setRowSelectionInterval(0, 0);//Selecciono la fila 0 (el primer de la llista)
        result = instance.askForClient();
        assertEquals(expResult, result);
    }
}
