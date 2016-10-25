/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import Logica.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.*;
import java.time.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author usuario
 */

@WebService
public class WSClientes {
    
    private Endpoint endpoint = null;
    private IControladorClientes iccli = new ControladorClientes();
    
    @WebMethod(exclude = true)
    public void publicar(){
        endpoint = Endpoint.publish("http://localhost:8810/clientes", this);
    }
    
    @WebMethod
    public void updateEstadoReserva(int numero,String estado){
        try {
            System.out.println("ACÁ: " + numero + " : " + estado);
            iccli.updateEstadoReserva(numero, estado);
        } catch (SQLException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public int realizarReserva(LocalDate fecha, int precio, String estado, String cliente){
        try {
            return iccli.realizarReserva(fecha, precio, estado, cliente);
        } catch (SQLException ex) {
            return 0;
        } catch (ClassNotFoundException ex) {
            return 0;
        }
    }
    
    @WebMethod
    public ArrayList<DataCliente> verInfoCliente(){
        try {
            return iccli.verInfoCliente();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public BufferedImage imagenLogueado(String nickname){
        try {
            return iccli.imagenLogueado(nickname);
        } catch (SQLException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
    @WebMethod
    public boolean correoValido(String correo){
        return iccli.correoValido(correo);
    }
    
    @WebMethod
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate FechaNac, String rutaImagen, String pass){
        try {
            iccli.agregarCliente(nickname, nombre, apellido, mail, FechaNac, rutaImagen, pass);
        } catch (SQLException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void deleteAllClientes(){
        try {
            iccli.deleteAllClientes();
        } catch (SQLException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void insertDatosClientesDePrueba(){
        try {
            iccli.insertDatosClientesDePrueba();
        } catch (SQLException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public DataCliente getClienteByNickname(String Nickname){
        try {
            return iccli.getClienteByNickname(Nickname);
        } catch (SQLException ex) {
            return new DataCliente();
        } catch (ClassNotFoundException ex) {
            return new DataCliente();
        }
    }
    
    @WebMethod
    public void datosAsociadosReservaWeb(int numReserva, String tipo, String nombreProducto, String nickProveedor, String fechaInicio, String fechaFin, int cantidad, int totalLinea){
        try {
            iccli.datosAsociadosReservaWeb(numReserva, tipo, nombreProducto, nickProveedor, fechaInicio, fechaFin, cantidad, totalLinea);
        } catch (SQLException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public DataCliente seleccionarCliente(String nickname){
        try {
            return iccli.seleccionarCliente(nickname);
        } catch (SQLException ex) {
            return new DataCliente();
        } catch (ClassNotFoundException ex) {
            return new DataCliente();
        }
    }
    
    @WebMethod
    public ArrayList<DataReserva> reservasCliente(String nickname){
        try {
            return iccli.reservasCliente(nickname);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public DataReserva getReserva(String nombreRes){
        try {
            return iccli.getReserva(nombreRes);
        } catch (SQLException ex) {
            return new DataReserva();
        } catch (ClassNotFoundException ex) {
            return new DataReserva();
        }
    }
    
    @WebMethod    
    public ArrayList getReservasPromo(String numeroProm){
        try {
            return iccli.getReservasPromo(numeroProm);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList getReservasServ(String numeroServ){
        try {
            return iccli.getReservasServ(numeroServ);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public boolean existeCorreo(String correo){
        try {
            return iccli.existeCorreo(correo);
        } catch (SQLException ex) {
            return true;
        } catch (ClassNotFoundException ex) {
            return true;
        }
    }
    
    @WebMethod
    public void agregarImagenPerfilWeb(BufferedImage img, String nick){
        try {
            iccli.agregarImagenPerfilWeb(img, nick);
        } catch (SQLException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WSClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public boolean existeNickname(String c){
        try {
            return iccli.existeNickname(c);
        } catch (SQLException ex) {
            return true;
        } catch (ClassNotFoundException ex) {
            return true;
        }
    }
}
