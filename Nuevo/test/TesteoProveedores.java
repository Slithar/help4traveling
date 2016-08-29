/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Logica.*;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class TesteoProveedores {
    
    public TesteoProveedores() {
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
    
    @org.junit.Test 
    public void testExisteNickname() throws SQLException, ClassNotFoundException {
        IControladorProveedores icprov = new ControladorProveedores();
        boolean resultado = icprov.existeNickname("nickname");
        assertEquals(false, resultado);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
