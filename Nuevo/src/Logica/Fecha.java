/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author usuario
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    
    public Fecha(){
        anio = 1900;
        mes = 1;
        dia = 1;
    }
    
    public Fecha(int anio, int mes, int dia){
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }
    
    public String toString(){
        return anio + "-" + mes + "-" + dia;
    }
    
    public int getDia(){
        return this.dia;
    }
    
    public int getMes(){
        return this.mes;
    }
    
    public int getAnio(){
        return this.anio;
    }
    
    public void setDia(int dia){
        this.dia = dia;
    }
    
    public void setMes(int mes){
        this.mes = mes;
    }
    
    public void setAnio(int anio){
        this.anio = anio;
    }
}
