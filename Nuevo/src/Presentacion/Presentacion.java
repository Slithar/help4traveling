/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Presentacion.frmMenuPrincipal;
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
        frmMenuPrincipal menuPrincipal = new frmMenuPrincipal();
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = miPantalla.getScreenSize();

        menuPrincipal.setSize(1400, 900);
        menuPrincipal.setLocationRelativeTo(null);

        menuPrincipal.setVisible(true);
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPrincipal.setTitle("Help4Traveling - Menú principal");
    }    
}


