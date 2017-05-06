/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestlab.view;

import gestlab.model.Empresa;
import gestlab.model.Usuario;
import gestlab.restfulclient.EmpresaClientSsl;
import gestlab.restfulclient.UsuarioClientSsl;
import static gestlab.view.PasswordDialogTest.usuario;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.TestUtils;

/**
 *
 * @author manel
 */
public class CompanyDialogTest {
    
    static Usuario usuario;
    private UsuarioClientSsl uClient;
    private Empresa empresa;
    private EmpresaClientSsl eClient;

    /**
     * Mètode per accedir al sistema com a usuari correcte per poder realitzar el test
     * @author manel bosch
     */
    @Before
    public void setUp() {
        byte[]  bytesEncoded = Base64.encodeBase64("maria".getBytes());
        uClient = new UsuarioClientSsl("99998663A", new String(bytesEncoded));//Accedeixo amb un usuari existent
        usuario = uClient.find_JSON(Usuario.class, "99998663A");
        eClient = new EmpresaClientSsl(usuario.getToken());
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
     * Mètode per provar si es fa la inserció/modificació d'una empresa a la base de dades
     * @author manel bosch
     */
    @Test
    public void testSaveActionPerformed() {
        Empresa e;
        JButton botoSave; JTextField textNif, textNom, textAdreca; 
        System.out.println("checkPasswd");
        
        //Creo la finestra sense passar-li una empresa
        CompanyDialog instance = new CompanyDialog(null, true, usuario);
        //Recullo les caixes de text i el botó de guardar de la finestra
        botoSave = (JButton)TestUtils.getChildNamed(instance, "save");
        textNif = (JTextField)TestUtils.getChildNamed(instance, "nif");
        textNom = (JTextField)TestUtils.getChildNamed(instance, "nom");
        textAdreca = (JTextField)TestUtils.getChildNamed(instance, "adreca");
        
        textNif.setText("Q53733110X");//No Existent (a la 1ª prova)
        textNom.setText("IRBB");
        textAdreca.setText("Josep Samitier");
        botoSave.doClick();
        empresa = new Empresa(textNif.getText(),textNom.getText(),textAdreca.getText());
        e = eClient.find_JSON(Empresa.class, textNif.getText());//Recupero l'empresa que s'hauria d'haver creat
        assertEquals(empresa, e);
        
        textNif.setText("Q33733110R");//Dades incomplertes i empresa no existent
        textNom.setText("");
        textAdreca.setText("");
        botoSave.doClick();
        //Recupero l'empresa que volia entrar però no s'hauria d'haver creat
        e = eClient.find_JSON(Empresa.class, textNif.getText());
        assertNull(e);
        
        //Creo la finestra passant-li l'empresa que he creat abans.
        CompanyDialog instanceWithCompany = new CompanyDialog(null, true, usuario, empresa);
        //Recullo les caixes de text i el botó de guardar de la finestra
        botoSave = (JButton)TestUtils.getChildNamed(instanceWithCompany, "save");
        textNif = (JTextField)TestUtils.getChildNamed(instanceWithCompany, "nif");
        textNom = (JTextField)TestUtils.getChildNamed(instanceWithCompany, "nom");
        textAdreca = (JTextField)TestUtils.getChildNamed(instanceWithCompany, "adreca");
        
        textNif.setText("Q53733110X");//Existent però modificant les dades (a la primera prova)
        textNom.setText("IRBB");
        textAdreca.setText("Josep Samitier 25");
        botoSave.doClick();
        empresa = new Empresa(textNif.getText(),textNom.getText(),textAdreca.getText());
        e = eClient.find_JSON(Empresa.class, textNif.getText());//Recupero l'empresa que s'hauria d'haver actualitzat
        assertEquals(empresa, e);
    }
    
}
