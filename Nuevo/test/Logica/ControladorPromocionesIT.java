/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;
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
public class ControladorPromocionesIT {
    
    public ControladorPromocionesIT() {
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
     * Test of calcularPrecio method, of class ControladorPromociones.
     */
    @Test
    public void testCalcularPrecio() {
        ControladorPromociones cp = new ControladorPromociones();
        int result = cp.getPrecio("Nuevo servicio / 150");
        assertEquals(150, result);
    }

    /**
     * Test of agregarPromocion method, of class ControladorPromociones.
     */
    @Test
    public void testAgregarPromocion() throws Exception {
        ControladorPromociones cp = new ControladorPromociones();
        cp.agregarPromocion(100, "Promoción de testeo", 10, "AirFrance");
        assertNotNull(cp.getDataPromocion("Promoción de testeo", "AirFrance"));
    }

    /**
     * Test of agregarServiciosPromocion method, of class ControladorPromociones.
     */
    @Test
    public void testAgregarServiciosPromocion() throws Exception {
        ControladorPromociones cp = new ControladorPromociones();
        assertEquals(1, cp.agregarServiciosPromocion("Promoción de testeo", "Air-France-FC", "AirFrance"));
    }

    /**
     * Test of getNombreServicio method, of class ControladorPromociones.
     */
    @Test
    public void testGetNombreServicio() {
        //System.out.println("getNombreServicio");
        //String cadena = "";
        ControladorPromociones cc = new ControladorPromociones();
        String expResult = "Servicio";
        String resultado = cc.getNombreServicio("Servicio / Proveedor");
        assertEquals(expResult, resultado);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPromociones method, of class ControladorPromociones.
     */
    @Test
    public void testGetPromociones() throws Exception {
        ControladorPromociones cp = new ControladorPromociones();
        assertTrue(cp.getPromociones().size() > 0);
    }

    /**
     * Test of getDataPromocion method, of class ControladorPromociones.
     */
    @Test
    public void testGetDataPromocion() throws Exception {
        ControladorPromociones cp = new ControladorPromociones();
        assertNotNull(cp.getDataPromocion("Euro-Cars-E-F", "EuropCar"));
    }

    /**
     * Test of getServiciosPromocion method, of class ControladorPromociones.
     */
    @Test
    public void testGetServiciosPromocion() throws Exception {
        ControladorPromociones cp = new ControladorPromociones();
        assertNotNull(cp.getDataPromocion("Euro-Cars-E-F", "EuropCar"));
    }
    
}
