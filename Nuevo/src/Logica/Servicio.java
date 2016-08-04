/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.*;
/**
 *
 * @author Mauro
 */
public class Servicio {
    private String nombreServicio;
    private String descripcionServicio;
    private int precioServicio;
    private Proveedor proveedorServicio;
    private ArrayList<Imagen> imagenesServicio;
    private ArrayList<Reserva> reservasServicio;
    private ArrayList<Promocion> promocionesServicio;
    private ArrayList<Categoria> categoriasServicio;
    private Ciudad origen;
    private Ciudad destino;
    
    public ArrayList<Categoria> getCategoriasServicio() {
        return categoriasServicio;
    }

    public void setCategoriasServicio(ArrayList<Categoria> CategoriasServicio) {
        this.categoriasServicio = CategoriasServicio;
    }

    public ArrayList<Promocion> getPromocionesServicio() {
        return promocionesServicio;
    }

    public void setPromocionesServicio(ArrayList<Promocion> PromocionesServicio) {
        this.promocionesServicio = PromocionesServicio;
    }


    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad Origen) {
        this.origen = Origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad Destino) {
        this.destino = Destino;
    }
    
    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String NombreServicio) {
        this.nombreServicio = NombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String DescripcionServicio) {
        this.descripcionServicio = DescripcionServicio;
    }

    public int getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(int PrecioServicio) {
        this.precioServicio = PrecioServicio;
    }

    public Proveedor getProveedorServicio() {
        return proveedorServicio;
    }

    public void setProveedorServicio(Proveedor ProveedorServicio) {
        this.proveedorServicio = ProveedorServicio;
    }

    public ArrayList<Imagen> getImagenesServicio() {
        return imagenesServicio;
    }

    public void setImagenesServicio(ArrayList<Imagen> ImagenesServicio) {
        this.imagenesServicio = ImagenesServicio;
    }

    public ArrayList<Reserva> getReservaServicio() {
        return reservasServicio;
    }

    public void setReservaServicio(ArrayList<Reserva> ReservaServicio) {
        this.reservasServicio = ReservaServicio;
    }
    
}
