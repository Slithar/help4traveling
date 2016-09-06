/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
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
public class ImagenServicioIT {
    
    public ImagenServicioIT() {
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
     * Test of copiarImagen method, of class ImagenServicio.
     */
    @Test
    public void testCopiarImagen() throws Exception {
        String nombre = "imagenTesteo";
        ImagenServicio is = new ImagenServicio();
        is.setPath("src/Logica/Perfiles/perfil.png");
        is.copiarImagen(nombre);
        File fichero = new File("src/Logica/ImagenesServicios");
        File[]imagenes = fichero.listFiles();
        boolean existe = false;
        for(int i = 0; i < imagenes.length; i++){
            if(!imagenes[i].getName().equalsIgnoreCase("imagenTesteo.png")) 
                existe = true;
        }
        boolean esperado = true;
        assertEquals(esperado, existe);
   }
    
}
