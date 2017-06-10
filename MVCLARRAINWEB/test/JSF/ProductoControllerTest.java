/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import Models.Producto;
import Models.TipoProducto;
import SessionBeans.ProductoFacade;
import java.util.ArrayList;
import java.util.List;
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
public class ProductoControllerTest {
    
    public ProductoControllerTest() {
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
     * Test of getSelected method, of class ProductoController.
     */
    @Test
    public void testGetSelected() {
        System.out.println("getSelected");
        ProductoController instance = new ProductoController();
        Producto expResult = new Producto();
        Producto result = instance.getSelected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult))
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelected1 method, of class ProductoController.
     */
    @Test
    public void testGetSelected1() {
        System.out.println("getSelected1");
        ProductoController instance = new ProductoController();
        TipoProducto expResult = new TipoProducto();
        TipoProducto result = instance.getSelected1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult))
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductos method, of class ProductoController.
     */
    @Test
    public void testGetProductos() {
        System.out.println("getProductos");
        ProductoController instance = new ProductoController();
        List<Producto> expResult = new ArrayList<>();
        List<Producto> result = instance.getProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult))
        fail("The test case is a prototype.");
    }
    
}
