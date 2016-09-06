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
public class ControladorCategoriasIT {
    
    public ControladorCategoriasIT() {
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
     * Test of actualizarCategorias method, of class ControladorCategorias.
     */
    @Test
    public void testActualizarCategorias() throws Exception {
        ControladorCategorias cc = new ControladorCategorias();
        cc.actualizarCategorias();
        assertTrue(cc.getCantCategorias() > 0);
    }

    /**
     * Test of getCategoriasPadres method, of class ControladorCategorias.
     */
    @Test
    public void testGetCategoriasPadres() throws Exception {
        ControladorCategorias cc = new ControladorCategorias();
        assertNotNull(cc.getCategoriasPadres());
    }

    /**
     * Test of getCategoriasHijas method, of class ControladorCategorias.
     */
    @Test
    public void testGetCategoriasHijas() throws Exception {
        ControladorCategorias cc = new ControladorCategorias();
        assertNotNull(cc.getCategoriasHijas("Vuelos"));
    }

    /**
     * Test of agregarNuevaCategoriaPadre method, of class ControladorCategorias.
     */
    @Test
    public void testAgregarNuevaCategoriaPadre() throws Exception {
        String c = "nueva";
        ControladorCategorias cc = new ControladorCategorias();
        boolean expResult = true;
        boolean resultado = cc.agregarNuevaCategoriaPadre(c);
        assertEquals(expResult, resultado);
    }

    /**
     * Test of agregarNuevaCategoriaHija method, of class ControladorCategorias.
     */
    @Test
    public void testAgregarNuevaCategoriaHija() throws Exception {
        System.out.println("agregarNuevaCategoriaHija");
        String c = "nuevaHija";
        String padre = "Vuelos";
        ControladorCategorias cc = new ControladorCategorias();
        boolean expResult = true;
        boolean result = cc.agregarNuevaCategoriaHija(c, padre);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of existeCategoria method, of class ControladorCategorias.
     */
    @Test
    public void testExisteCategoria() throws Exception {
        String c = "Vuelos";
        ControladorCategorias cc = new ControladorCategorias();
        boolean expResult = true;
        boolean result = cc.existeCategoria(c);
        assertEquals(expResult, result);
    }    
}
