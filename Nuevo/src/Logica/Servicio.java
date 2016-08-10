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
    private ArrayList<ImagenServicio> imagenesServicio;
    private ArrayList<Reserva> reservasServicio;
    private ArrayList<Promocion> promocionesServicio;
    private ArrayList<Categoria> categoriasServicio;
    private Ciudad origen;
    private Ciudad destino;

    public Servicio() {
        nombreServicio = "";
        descripcionServicio = "";
        precioServicio = 0;
        proveedorServicio = new Proveedor();
        imagenesServicio = new ArrayList<ImagenServicio>();
        reservasServicio = new ArrayList<Reserva>();
        promocionesServicio = new ArrayList<Promocion>();
        categoriasServicio = new ArrayList<Categoria>();
        origen = new Ciudad();
        destino = new Ciudad();
    }
    
    public Servicio(String nombreServicio, String descripcionServicio, int previoServicio, Proveedor proveedorServicio,ArrayList<ImagenServicio> imagenesServicio, ArrayList<Reserva> reservasServicio, ArrayList<Promocion> promocionesServicio, ArrayList<Categoria> categoriasServicio, Ciudad origen, Ciudad destino, boolean tieneDestino){
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
        this.precioServicio = precioServicio;
        this.proveedorServicio = proveedorServicio;
        this.imagenesServicio = imagenesServicio;
        this.reservasServicio = reservasServicio;
        this.promocionesServicio = promocionesServicio;
        this.categoriasServicio = categoriasServicio;
        this.origen = origen;
        this.destino = (tieneDestino) ? destino : null;        
    }

    /*public Servicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
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

    public ArrayList<ImagenServicio> getImagenesServicio() {
        return imagenesServicio;
    }

    public void setImagenesServicio(ArrayList<ImagenServicio> ImagenesServicio) {
        this.imagenesServicio = ImagenesServicio;
    }

    public ArrayList<Reserva> getReservaServicio() {
        return reservasServicio;
    }

    public void setReservaServicio(ArrayList<Reserva> ReservaServicio) {
        this.reservasServicio = ReservaServicio;
    }
    
}
