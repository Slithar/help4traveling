/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Log {
    private int numero;
    private LocalDate fecha;
    private String ruta;
    private String navegador;
    private String so;

    public Log(int numero, LocalDate fecha, String ruta, String navegador, String so) {
        this.numero = numero;
        this.fecha = fecha;
        this.ruta = ruta;
        this.navegador = navegador;
        this.so = so;
        
        //JOptionPane.showMessageDialog(null, this.numero);
    }  
    
    public Log() {
        this.numero = 0;
        this.fecha = LocalDate.of(1990, 1, 1);
        this.ruta = "";
        this.navegador = "";
        this.so = "";
    }   
    
    public Log(LocalDate fecha, String ruta, String navegador, String so){
        this.fecha = fecha;
        this.ruta = ruta;
        this.navegador = navegador;
        this.so = so;
    }   
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }
    
    
            
}
