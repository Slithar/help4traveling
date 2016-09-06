/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
public class EstadoIT {
    
    public EstadoIT() {
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
     * Test of obtenerEstado method, of class Estado.
     */
    @Test
    public void testObtenerEstado1() {
        String estado = "registrada";
        Estado expResult = Estado.REGISTRADA;
        Estado result = Estado.obtenerEstado(estado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testObtenerEstado2() {
        String estado = "cancelada";
        Estado expResult = Estado.CANCELADA;
        Estado result = Estado.obtenerEstado(estado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testObtenerEstado3() {
        String estado = "facturada";
        Estado expResult = Estado.FACTURADA;
        Estado result = Estado.obtenerEstado(estado);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testObtenerEstado4() {
        String estado = "pagada";
        Estado expResult = Estado.PAGADA;
        Estado result = Estado.obtenerEstado(estado);
        assertEquals(expResult, result);
    }
}
