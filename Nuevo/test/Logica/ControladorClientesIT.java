/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.TableModel;
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
public class ControladorClientesIT {
    
    public ControladorClientesIT() {
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
    public void testExisteNickname() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        assertFalse(cc.existeNickname(""));
    }

    /**
     * Test of agregarCliente method, of class ControladorClientes.
     */
    @Test
    public void testAgregarCliente() throws Exception {
        
        String nickname = "testeoCliente";
        String nombre = "cliente";
        String apellido = "testeo";
        String mail = "cliente.testeo@gmail.com";
        LocalDate FechaNac = LocalDate.of(1996, 3, 15);
        String rutaImagen = "perfiles/perfil.PNG";
        ControladorClientes cc = new ControladorClientes();
        cc.agregarCliente(nickname, nombre, apellido, mail, FechaNac, rutaImagen);
        assertNotNull(cc.verInfoClienteBusqueda("testeoCliente"));
    }

    /**
     * Test of verInfoReserva method, of class ControladorClientes.
     */
    @Test
    public void testVerInfoReserva() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        assertTrue(cc.verInfoReserva().size() > 0);
    }

    /**
     * Test of datosReserva method, of class ControladorClientes.
     */
    @Test
    public void testDatosReserva() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        assertTrue(cc.datosReserva().size() > 0);
    }

    /**
     * Test of updateEstadoReserva method, of class ControladorClientes.
     */
    /*@Test
    public void testUpdateEstadoReserva() throws Exception {
    }*/

    /**
     * Test of getReserva method, of class ControladorClientes.
     */
    @Test
    public void testGetReserva() throws SQLException, ClassNotFoundException {
        ControladorClientes cc = new ControladorClientes();
        assertNotNull(cc.getReserva("1"));
    }

    /**
     * Test of getReservasPromo method, of class ControladorClientes.
     */
    @Test
    public void testGetReservasPromo() throws SQLException, ClassNotFoundException {
        ControladorClientes cc = new ControladorClientes();
        assertNotNull(cc.getReservasPromo("1"));
    }

    /**
     * Test of getReservasServ method, of class ControladorClientes.
     */
    @Test
    public void testGetReservasServ() throws SQLException, ClassNotFoundException {
        ControladorClientes cc = new ControladorClientes();
        assertNotNull(cc.getReservasServ("1"));
    }

    /**
     * Test of verInfoCliente method, of class ControladorClientes.
     */
    @Test
    public void testVerInfoCliente() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        assertNotNull(cc.verInfoCliente());
    }

    /**
     * Test of verInfoClienteBusqueda method, of class ControladorClientes.
     */
    @Test
    public void testVerInfoClienteBusqueda() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        assertNotNull(cc.verInfoClienteBusqueda("eWatson"));
    }

    /**
     * Test of seleccionarCliente method, of class ControladorClientes.
     */
    @Test
    public void testSeleccionarCliente() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        assertNotNull(cc.seleccionarCliente("eWatson"));
    }

    /**
     * Test of reservasCliente method, of class ControladorClientes.
     */
    @Test
    public void testReservasCliente() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        assertNotNull(cc.reservasCliente("eWatson"));
    }

    /**
     * Test of getClientes method, of class ControladorClientes.
     */
    @Test
    public void testGetClientes() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        assertNotNull(cc.getClientes());
    }

    /**
     * Test of deleteAllClientes method, of class ControladorClientes.
     */
   /* @Test
    public void testDeleteAllClientes() throws Exception {
        System.out.println("deleteAllClientes");
        ControladorClientes instance = new ControladorClientes();
        instance.deleteAllClientes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of insertDatosClientesDePrueba method, of class ControladorClientes.
     */
    /*@Test
    public void testInsertDatosClientesDePrueba() throws Exception {
        System.out.println("insertDatosClientesDePrueba");
        ControladorClientes instance = new ControladorClientes();
        instance.insertDatosClientesDePrueba();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of realizarReserva method, of class ControladorClientes.
     */
    @Test
    public void testRealizarReserva() throws Exception {
        //System.out.println("realizarReserva");
        LocalDate Fecha = LocalDate.now();
        int precio = 100;
        String estado = "REGISTRADA";
        String nickCliente = "eWatson";
        ControladorClientes cc = new ControladorClientes();
        //int expResult = 0;
        int numeroReserva = cc.realizarReserva(Fecha, precio, estado, nickCliente);
        assertTrue(numeroReserva > 0);
    }

    /**
     * Test of datosAsociadosReserva method, of class ControladorClientes.
     */
    /*@Test
    public void testDatosAsociadosReserva() throws Exception {
        System.out.println("datosAsociadosReserva");
        int numReserva = 0;
        TableModel modelo = null;
        ControladorClientes instance = new ControladorClientes();
        instance.datosAsociadosReserva(numReserva, modelo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getAllReservas method, of class ControladorClientes.
     */
    @Test
    public void testGetAllReservas() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        assertNotNull(cc.getAllReservas());
    }

    /**
     * Test of deleteReserva method, of class ControladorClientes.
     */
    /*@Test
    public void testDeleteReserva() throws Exception {
        System.out.println("deleteReserva");
        int numReserva = 0;
        ControladorClientes instance = new ControladorClientes();
        instance.deleteReserva(numReserva);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getNumeroReserva method, of class ControladorClientes.
     */
    @Test
    public void testGetNumeroReserva() throws Exception {
        ControladorClientes cc = new ControladorClientes();
        int resultado = cc.getNumeroReserva(LocalDate.of(2016, 8, 7), 200, "oWood");
        assertTrue(resultado > 0);
    }
    
}
