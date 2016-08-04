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
    private String NombreServicio;
    private String DescripcionServicio;
    private int PrecioServicio;
    private Proveedor ProveedorServicio;
    private ArrayList<Imagen> ImagenesServicio;
    private ArrayList<Reserva> ReservaServicio;
    private ArrayList<Promocion> PromocionesServicio;
    private ArrayList<Categoria> CategoriasServicio;

    public ArrayList<Categoria> getCategoriasServicio() {
        return CategoriasServicio;
    }

    public void setCategoriasServicio(ArrayList<Categoria> CategoriasServicio) {
        this.CategoriasServicio = CategoriasServicio;
    }

    public ArrayList<Promocion> getPromocionesServicio() {
        return PromocionesServicio;
    }

    public void setPromocionesServicio(ArrayList<Promocion> PromocionesServicio) {
        this.PromocionesServicio = PromocionesServicio;
    }
    private Ciudad Origen;
    private Ciudad Destino;

    public Ciudad getOrigen() {
        return Origen;
    }

    public void setOrigen(Ciudad Origen) {
        this.Origen = Origen;
    }

    public Ciudad getDestino() {
        return Destino;
    }

    public void setDestino(Ciudad Destino) {
        this.Destino = Destino;
    }
    
    public String getNombreServicio() {
        return NombreServicio;
    }

    public void setNombreServicio(String NombreServicio) {
        this.NombreServicio = NombreServicio;
    }

    public String getDescripcionServicio() {
        return DescripcionServicio;
    }

    public void setDescripcionServicio(String DescripcionServicio) {
        this.DescripcionServicio = DescripcionServicio;
    }

    public int getPrecioServicio() {
        return PrecioServicio;
    }

    public void setPrecioServicio(int PrecioServicio) {
        this.PrecioServicio = PrecioServicio;
    }

    public Proveedor getProveedorServicio() {
        return ProveedorServicio;
    }

    public void setProveedorServicio(Proveedor ProveedorServicio) {
        this.ProveedorServicio = ProveedorServicio;
    }

    public ArrayList<Imagen> getImagenesServicio() {
        return ImagenesServicio;
    }

    public void setImagenesServicio(ArrayList<Imagen> ImagenesServicio) {
        this.ImagenesServicio = ImagenesServicio;
    }

    public ArrayList<Reserva> getReservaServicio() {
        return ReservaServicio;
    }

    public void setReservaServicio(ArrayList<Reserva> ReservaServicio) {
        this.ReservaServicio = ReservaServicio;
    }
    
}
