/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.LocalDate;
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
public class UsuarioIT {
    
    public UsuarioIT() {
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
     * Test of correoValido method, of class Usuario.
     */
    @Test
    public void testCorreoValido() {
        Usuario u = new Usuario();
        u.setEmail("help4traveling");
        boolean expResult = false;
        boolean result = u.correoValido();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of correoValido method, of class Usuario.
     */
    @Test
    public void testCorreoValido2() {
        Usuario u = new Usuario();
        u.setEmail("help4traveling@gmail.com");
        boolean expResult = true;
        boolean result = u.correoValido();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of correoValido method, of class Usuario.
     */
    @Test
    public void testCorreoValido3() {
        Usuario u = new Usuario();
        u.setEmail("help4traveling@@gmail.com");
        boolean expResult = false;
        boolean result = u.correoValido();
        assertEquals(expResult, result);
    }
    
    
}
