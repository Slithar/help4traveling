/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.time.LocalDate;
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
public class ControladorProveedoresIT {
    
    public ControladorProveedoresIT() {
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

    
    @Test
    public void testActualizarProveedores() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        cp.actualizarProveedores();
        assertTrue(cp.getCantProveedores() > 0);
    }

    /**
     * Test of getCiudadOrigen method, of class ControladorProveedores.
     */
    @Test
    public void testGetCiudadOrigen() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        DataCiudad origen = cp.getCiudadOrigen("Air-France-FC", "AirFrance");
        assertEquals("París", origen.getNombre());
    }

    /**
     * Test of existeCorreo method, of class ControladorProveedores.
     */
    @Test
    public void testExisteCorreo() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertFalse(cp.existeCorreo(""));
    }

    /**
     * Test of actualizarCiudades method, of class ControladorProveedores.
     */
    @Test
    public void testActualizarCiudades() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();        
        cp.actualizarCiudades();
        assertTrue(cp.getCantCiudades() > 0);
    }

    /**
     * Test of existeNickname method, of class ControladorProveedores.
     */
    @Test
    public void testExisteNickname() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertFalse(cp.existeNickname(""));
    }

    /**
     * Test of correoValido method, of class ControladorProveedores.
     */
    @Test
    public void testCorreoValido() {
        ControladorProveedores cp = new ControladorProveedores();
        assertTrue(cp.correoValido("help4traveling@gmail.com"));
    }

    /**
     * Test of sitiWebValido method, of class ControladorProveedores.
     */
    @Test
    public void testSitiWebValido() {
        ControladorProveedores cp = new ControladorProveedores();
        assertTrue(cp.sitiWebValido("http://help4traveling.com.uy"));
    }

    /**
     * Test of agregarProveedor method, of class ControladorProveedores.
     */
    /*@Test
    public void testAgregarProveedor() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        cp.agregarProveedor("testeo", "testeo", "testeo", "testeo@testeo.com", LocalDate.of(1995, 9, 5), new ArrayList(), "Testeo S.A.", "http://testeo.com.uy", new HashMap<String, Servicio>());
        assertTrue(cp.verInfoProveedorBusqueda("testeo").size() > 0);
    }*/

    /**
     * Test of getCiudades method, of class ControladorProveedores.
     */
    @Test
    public void testGetCiudades() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertTrue(cp.getCiudades().size() > 0);
    }

    /**
     * Test of getProveedores method, of class ControladorProveedores.
     */
    @Test
    public void testGetProveedores() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertNotNull(cp.getProveedores());
    }

    /**
     * Test of existeNombreServicio method, of class ControladorProveedores.
     */
    @Test
    public void testExisteNombreServicio() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertFalse(cp.existeNombreServicio("", "AirFrance"));
    }

    /**
     * Test of agregarServicio method, of class ControladorProveedores.
     */
    @Test
    public void testAgregarServicio() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        ArrayList<String> categorias = new ArrayList<String>();
        categorias.add("Vuelos");
        cp.agregarServicio("testeoServicio", "es un testeo", 150, "AirFrance", new ArrayList(), categorias, "Bariloche", "Montevideo", true);
        assertNotNull(cp.getDatosServicio("testeoServicio", "AirFrance"));
    }

    /**
     * Test of getServicios method, of class ControladorProveedores.
     */
    @Test
    public void testGetServicios() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertTrue(cp.getServicios().size() > 0);
    }

    /**
     * Test of getDatosServicio method, of class ControladorProveedores.
     */
    @Test
    public void testGetDatosServicio() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertNotNull(cp.getDatosServicio("Air-France-FC", "AirFrance"));
    }

    /**
     * Test of getCiudadDestino method, of class ControladorProveedores.
     */
    @Test
    public void testGetCiudadDestino() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        DataCiudad destino = cp.getCiudadDestino("Euro-Car-1", "EuropCar");
        assertEquals("Valencia", destino.getNombre());
    }

    /**
     * Test of getCategorias method, of class ControladorProveedores.
     */
    @Test
    public void testGetCategorias() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        ArrayList<DataCategoria> categorias = cp.getCategorias("Euro-Car-1", "EuropCar");
        assertTrue(categorias.size() > 0);
    }

    /**
     * Test of modificarServicio method, of class ControladorProveedores.
     */
    @Test
    public void testModificarServicio() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        ArrayList<String> categorias = new ArrayList<String>();
        categorias.add("Automóviles");
        cp.modificarServicio("Air-France-FC", "es un testeo", 150, "AirFrance", new ArrayList(), categorias, "Bariloche", "Montevideo", true);
        //cp.agregarServicio("testeoServicio", "es un testeo", 150, "AirFrance", new ArrayList(), categorias, "Bariloche", "Montevideo", true);
        assertNotNull(cp.getDatosServicio("Air-France-FC", "AirFrance"));
    }

    /**
     * Test of getServiciosPorBusqueda method, of class ControladorProveedores.
     */
    @Test
    public void testGetServiciosPorBusqueda() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertTrue(cp.getServiciosPorBusqueda("a").size() > 0);
    }

    /**
     * Test of getServiciosProveedor method, of class ControladorProveedores.
     */
    @Test
    public void testGetServiciosProveedor() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertTrue(cp.getServiciosProveedor("").size() == 0);
    }

    /**
     * Test of getInfoProveedores method, of class ControladorProveedores.
     */
    @Test
    public void testGetInfoProveedores() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertTrue(cp.getInfoProveedores().size() > 0);
    }

    /**
     * Test of verInfoProveedorBusqueda method, of class ControladorProveedores.
     */
    @Test
    public void testVerInfoProveedorBusqueda() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertNotNull(cp.verInfoProveedorBusqueda("moody"));
    }

    /**
     * Test of getImagenes method, of class ControladorProveedores.
     */
    /*@Test
    public void testGetImagenes() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertTrue(cp.getImagenes("Air-France-FC", "AirFrance").size() > 0);
    }*/

    /**
     * Test of getImagenesProv method, of class ControladorProveedores.
     */
    @Test
    public void testGetImagenesProv() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertTrue(cp.getImagenesProv("moody").size() > 0);
    }

    /**
     * Test of verInfoProveedor method, of class ControladorProveedores.
     */
    @Test
    public void testVerInfoProveedor() throws Exception {
        ControladorProveedores cp = new ControladorProveedores();
        assertNotNull(cp.verInfoProveedor("moody"));
    }
    
}
