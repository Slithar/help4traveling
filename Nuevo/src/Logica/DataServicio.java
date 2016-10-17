/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.*;

/**
 *
 * @author usuario
 */
public class DataServicio {
    
    private String nombreServicio;
    private String descripcionServicio;
    private int precioServicio;
    private String nombreProveedor;
    private ArrayList<String> imagenesServicio;
    private ArrayList<String> categoriasServicio;
    private String origen;
    private String destino;
    private int visitas;

    public DataServicio() {
    }

    public DataServicio(String nombreServicio, String descripcionServicio, int precioServicio, String nombreProveedor, ArrayList<String> imagenesServicio, ArrayList<String> categoriasServicio, String origen, String destino) {
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
        this.precioServicio = precioServicio;
        this.nombreProveedor = nombreProveedor;
        this.imagenesServicio = imagenesServicio;
        this.categoriasServicio = categoriasServicio;
        this.origen = origen;
        this.destino = destino;
    }  
    
    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public int getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(int precioServicio) {
        this.precioServicio = precioServicio;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public ArrayList<String> getImagenesServicio() {
        return imagenesServicio;
    }

    public void setImagenesServicio(ArrayList<String> imagenesServicio) {
        this.imagenesServicio = imagenesServicio;
    }

    public ArrayList<String> getCategoriasServicio() {
        return categoriasServicio;
    }

    public void setCategoriasServicio(ArrayList<String> categoriasServicio) {
        this.categoriasServicio = categoriasServicio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }   
}
