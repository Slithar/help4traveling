/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Presentacion.frmMenuPrincipal;
import Presentacion.help4travelingUI;
import Presentacion.Presentacion;
import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 *
 * @author Mauro
 * 
 */

public class Presentacion {
    public static void main (String [ ] args) {
        
        //System.out.println("Acá empece");
 
        frmMenuPrincipal menuPrincipal = new frmMenuPrincipal();
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = miPantalla.getScreenSize();
        //Cambié acá también, un tamaño para mi pantalla
        menuPrincipal.setSize(1300, 730);
        menuPrincipal.setLocationRelativeTo(null);

        menuPrincipal.setVisible(true);
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPrincipal.setTitle("Help4Traveling - Menú principal");
        
        menuPrincipal.setContentPane(new Panel());
        
        menuPrincipal.add(new Panel());
        
        

    }
}


