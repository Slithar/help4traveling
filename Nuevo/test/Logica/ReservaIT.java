/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.LocalDate;
import java.util.ArrayList;
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
public class ReservaIT {
    
    public ReservaIT() {
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
     * Test of getEstado method, of class Reserva.
     */
    @Test
    public void testGetEstado() {
        Reserva r = new Reserva();
        r.setEstado("registrada");
        Estado expResult = Estado.REGISTRADA;
        Estado result = r.getEstado();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getEstado method, of class Reserva.
     */
    @Test
    public void testGetEstado2() {
        Reserva r = new Reserva();
        r.setEstado("pagada");
        Estado expResult = Estado.PAGADA;
        Estado result = r.getEstado();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getEstado method, of class Reserva.
     */
    @Test
    public void testGetEstado3() {
        Reserva r = new Reserva();
        r.setEstado("facturada");
        Estado expResult = Estado.FACTURADA;
        Estado result = r.getEstado();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getEstado method, of class Reserva.
     */
    @Test
    public void testGetEstado4() {
        Reserva r = new Reserva();
        r.setEstado("cancelada");
        Estado expResult = Estado.CANCELADA;
        Estado result = r.getEstado();
        assertEquals(expResult, result);
    }
    
    
}
