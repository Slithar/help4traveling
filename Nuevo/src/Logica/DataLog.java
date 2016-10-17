/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.LocalDate;

/**
 *
 * @author usuario
 */
public class DataLog {
    
    private int numero;
    private LocalDate fecha;
    private String ruta;
    private String navegador;
    private String so;

    public DataLog(int numero, LocalDate fecha, String ruta, String navegador, String so) {
        this.numero = numero;
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
