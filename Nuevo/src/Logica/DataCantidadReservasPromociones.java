/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.time.*;

/**
 *
 * @author usuario
 */
public class DataCantidadReservasPromociones {
    private int cantidad;
    private int totalLinea;
    private LocalDate fechaInicio;
    private String fiDCRP;
    private LocalDate fechaFin;
    private String ffDCRP;
    private int reserva;
    private String promocion;
    private String proveedor;

    public DataCantidadReservasPromociones() {
    }

    public DataCantidadReservasPromociones(int cantidad, int totalLinea, LocalDate fechaInicio, LocalDate fechaFin, int reserva, String promocion, String proveedor) {
        this.cantidad = cantidad;
        this.totalLinea = totalLinea;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.reserva = reserva;
        this.promocion = promocion;
        this.proveedor = proveedor;
        
        String fechaI = fechaInicio.toString();
        String[] fechaPartida = fechaI.split("-");
        this.fiDCRP = fechaPartida[2] + "/" + fechaPartida[1] + "/" + fechaPartida[0];
        
        String fechaF = fechaFin.toString();
        fechaPartida = fechaF.split("-");
        this.ffDCRP = fechaPartida[2] + "/" + fechaPartida[1] + "/" + fechaPartida[0];
    }
      public DataCantidadReservasPromociones(int cantidad, int totalLinea, LocalDate fechaInicio, LocalDate fechaFin, String promocion, String proveedor) {
        this.cantidad = cantidad;
        this.totalLinea = totalLinea;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.promocion = promocion;
        this.proveedor = proveedor;
        
        String fechaI = fechaInicio.toString();
        String[] fechaPartida = fechaI.split("-");
        this.fiDCRP = fechaPartida[2] + "/" + fechaPartida[1] + "/" + fechaPartida[0];
        
        String fechaF = fechaFin.toString();
        String[] fechaP = fechaF.split("-");
        this.ffDCRP = fechaP[2] + "/" + fechaP[1] + "/" + fechaP[0];
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        
        String fechaI = fechaInicio.toString();
        String[] fechaPartida = fechaI.split("-");
        this.fiDCRP = fechaPartida[2] + "/" + fechaPartida[1] + "/" + fechaPartida[0];
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
        
        String fechaF = fechaFin.toString();
        String[] fechaP = fechaF.split("-");
        this.ffDCRP = fechaP[2] + "/" + fechaP[1] + "/" + fechaP[0];
    }

    public int getReserva() {
        return reserva;
    }

    public void setReserva(int reserva) {
        this.reserva = reserva;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getTotalLinea() {
        return totalLinea;
    }

    public void setTotalLinea(int totalLinea) {
        this.totalLinea = totalLinea;
    }

    public String getFiDCRP() {
        return fiDCRP;
    }

    public void setFiDCRP(String fiDCRP) {
        this.fiDCRP = fiDCRP;
    }

    public String getFfDCRP() {
        return ffDCRP;
    }

    public void setFfDCRP(String ffDCRP) {
        this.ffDCRP = ffDCRP;
    }    
}
