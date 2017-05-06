/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestlab.view;

import gestlab.model.Cliente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author manel
 */
public class GestLabFrameTest {
    
    public GestLabFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of editProfileTextFields method, of class GestLabFrame.
     */
    @Test
    public void testEditProfileTextFields() {
        System.out.println("editProfileTextFields");
        Boolean b = null;
        GestLabFrame instance = null;
        instance.editProfileTextFields(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeProfile method, of class GestLabFrame.
     */
    @Test
    public void testChangeProfile() {
        System.out.println("changeProfile");
        GestLabFrame instance = null;
        instance.changeProfile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillClientsList method, of class GestLabFrame.
     */
    @Test
    public void testFillClientsList_0args() {
        System.out.println("fillClientsList");
        GestLabFrame instance = null;
        instance.fillClientsList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillClientsList method, of class GestLabFrame.
     */
    @Test
    public void testFillClientsList_List() {
        System.out.println("fillClientsList");
        List l = null;
        GestLabFrame instance = null;
        instance.fillClientsList(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillProductsList method, of class GestLabFrame.
     */
    @Test
    public void testFillProductsList_0args() {
        System.out.println("fillProductsList");
        GestLabFrame instance = null;
        instance.fillProductsList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillProductsList method, of class GestLabFrame.
     */
    @Test
    public void testFillProductsList_List() {
        System.out.println("fillProductsList");
        List l = null;
        GestLabFrame instance = null;
        instance.fillProductsList(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillHistorialProductos method, of class GestLabFrame.
     */
    @Test
    public void testFillHistorialProductos() {
        System.out.println("fillHistorialProductos");
        List l = null;
        GestLabFrame instance = null;
        instance.fillHistorialProductos(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkProductStock method, of class GestLabFrame.
     */
    @Test
    public void testCheckProductStock() {
        System.out.println("checkProductStock");
        GestLabFrame instance = null;
        instance.checkProductStock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillEquipsList method, of class GestLabFrame.
     */
    @Test
    public void testFillEquipsList_0args() {
        System.out.println("fillEquipsList");
        GestLabFrame instance = null;
        instance.fillEquipsList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillEquipsList method, of class GestLabFrame.
     */
    @Test
    public void testFillEquipsList_List() {
        System.out.println("fillEquipsList");
        List l = null;
        GestLabFrame instance = null;
        instance.fillEquipsList(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillHistorialEquipos method, of class GestLabFrame.
     */
    @Test
    public void testFillHistorialEquipos() {
        System.out.println("fillHistorialEquipos");
        List l = null;
        GestLabFrame instance = null;
        instance.fillHistorialEquipos(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBookingOfEquips method, of class GestLabFrame.
     */
    @Test
    public void testUpdateBookingOfEquips() {
        System.out.println("updateBookingOfEquips");
        GestLabFrame instance = null;
        instance.updateBookingOfEquips();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of askForClient method, of class GestLabFrame.
     */
    @Test
    public void testAskForClient() {
        System.out.println("askForClient");
        GestLabFrame instance = null;
        Cliente expResult = null;
        Cliente result = instance.askForClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
