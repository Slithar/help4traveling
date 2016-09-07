/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class ProveedorIT {
    
    public ProveedorIT() {
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
     * Test of sitioWebValido method, of class Proveedor.
     */
    @Test
    public void testSitioWebValido() {
        Proveedor p = new Proveedor();
        p.setLink("help4traveling");
        boolean expResult = false;
        boolean result = p.sitioWebValido();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSitioWebValido2() {
        Proveedor p = new Proveedor();
        p.setLink(".help4traveling.com.uy");
        boolean expResult = false;
        boolean result = p.sitioWebValido();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSitioWebValido3() {
        Proveedor p = new Proveedor();
        p.setLink("help4traveling.com.uy.");
        boolean expResult = false;
        boolean result = p.sitioWebValido();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSitioWebValido4() {
        Proveedor p = new Proveedor();
        p.setLink("help4traveling.com");
        boolean expResult = true;
        boolean result = p.sitioWebValido();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSitioWebValido5() {
        Proveedor p = new Proveedor();
        p.setLink("help4traveling.com.uy");
        boolean expResult = true;
        boolean result = p.sitioWebValido();
        assertEquals(expResult, result);
    }
    
    
    
}
