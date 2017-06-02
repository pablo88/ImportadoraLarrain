/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import Models.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Home
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
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
     * Test of getAlerta method, of class LoginController.
     */
    @Test
    public void testGetAlerta() {
        System.out.println("getAlerta");
        LoginController instance = new LoginController();
        String expResult = null;
        String result = instance.getAlerta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelected method, of class LoginController.
     */
    @Test
    public void testGetSelected() {
        System.out.println("getSelected");
        LoginController instance = new LoginController();
        Usuario expResult = null;
        Usuario result = instance.getSelected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of autenticarUsuario method, of class LoginController.
     */
    @Test
    public void testAutenticarUsuario() {
        System.out.println("autenticarUsuario");
        LoginController instance = new LoginController();
        String expResult = "";
        String result = instance.autenticarUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cerrarSesion method, of class LoginController.
     */
    @Test
    public void testCerrarSesion() {
        System.out.println("cerrarSesion");
        LoginController instance = new LoginController();
        String expResult = instance.cerrarSesion();
        String result = instance.cerrarSesion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult))
        fail("The test case is a prototype.");
    }
    
}
