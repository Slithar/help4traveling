/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author usuario
 */

@WebService
public class WSPrincipal {
    
    private Endpoint endpoint = null;
    private IControladorClientes iccli = new ControladorClientes();
    private IControladorProveedores icprov = new ControladorProveedores();
    private IControladorCategorias iccat = new ControladorCategorias();
    private IControladorPromociones icprom = new ControladorPromociones();
    private IControladorLogs iclog = new ControladorLogs();
    
    @WebMethod(exclude = true)
    public void publicar(){
        endpoint = Endpoint.publish("http://localhost:8810/wsmains", this);
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
    public int realizarReserva(int precio, String estado, String cliente){
        try {
            return iccli.realizarReserva(LocalDate.now(), precio, estado, cliente);
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
    public byte[] imagenLogueado(String nickname){
        try {
            BufferedImage imagen = iccli.imagenLogueado(nickname);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(imagen, "jpg", baos);
            return baos.toByteArray();
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
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, String FechaNac, String rutaImagen, String pass){
        try {
            String[] fecha = FechaNac.split("/");            
            iccli.agregarCliente(nickname, nombre, apellido, mail, LocalDate.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0])), rutaImagen, pass);
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
    
    public void agregarImagenPerfilWeb(byte[] imagen, String nick){
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(imagen);
            iccli.agregarImagenPerfilWeb(ImageIO.read(bais), nick);
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
    
    @WebMethod
    public ArrayList<DataCategoria> getCategorias(String nombre, String nombreProveedor){
        try {
            //System.out.println("HOLAAAA");
            return icprov.getCategorias(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataProveedor> getInfoProveedores() {
        try {
            return icprov.getInfoProveedores();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataImagen> getImagenesProv(String nombreProveedor) {
        try {
            return icprov.getImagenesProv(nombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public byte[] copiarImagenesServicio(String ruta){
        try {
            BufferedImage imagen = icprov.copiarImagenesServicio(ruta);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(imagen, "jpg", baos);
            return baos.toByteArray();
        } catch (SQLException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServicios() {
        try {
            return icprov.getServicios();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataImagen> getImagenes(String nombre, String nombreProveedor) {
        try {
            return icprov.getImagenes(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public void deleteAllProveedores() {
        try {
            icprov.deleteAllProveedores();
        } catch (SQLException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void insertCiudadesDePrueba() {
        try {
            icprov.insertCiudadesDePrueba();
        } catch (SQLException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public DataProveedor verInfoProveedor(String nickname) {
        try {
            return icprov.verInfoProveedor(nickname);
        } catch (SQLException ex) {
            return new DataProveedor();
        } catch (ClassNotFoundException ex) {
            return new DataProveedor();
        }
    }
    
    @WebMethod
    public void insertDatosProveedoresDePrueba() {
        try {
            icprov.insertDatosProveedoresDePrueba();
        } catch (SQLException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public ArrayList getMaxServicios() {
        try {
            return icprov.getMaxServicios();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public DataProveedor getNombreEmpresa(String nick) {
        try {
            return icprov.getNombreEmpresa(nick);
        } catch (SQLException ex) {
            return new DataProveedor();
        } catch (ClassNotFoundException ex) {
            return new DataProveedor();
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServiciosProveedor(String NombreProveedor) {
        try {
            return icprov.getServiciosProveedor(NombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public DataServicio getDatosServicio(String nombre, String nombreProveedor) {
        try {
            return icprov.getDatosServicio(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new DataServicio();
        } catch (ClassNotFoundException ex) {
            return new DataServicio();
        }
    }
    
    @WebMethod
    public DataCiudad getCiudadOrigen(String nombre, String nombreProveedor) {
        try {
            return icprov.getCiudadOrigen(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new DataCiudad();
        } catch (ClassNotFoundException ex) {
            return new DataCiudad();
        }
    }
    
    @WebMethod
    public DataCiudad getCiudadDestino(String nombre, String nombreProveedor) {
        try {
            return icprov.getCiudadDestino(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new DataCiudad();
        } catch (ClassNotFoundException ex) {
            return new DataCiudad();
        }
    }
    
    @WebMethod
    public ArrayList<String> rutaImagenesServicios(String nombre, String nickProveedor) {
        try {
            return icprov.rutaImagenesServicios(nombre, nickProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public void agregarVisita(String nombreServicio, String nombreProveedor){
        try {
            icprov.agregarVisita(nombreServicio, nombreProveedor);
        } catch (SQLException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServiciosPorCategoriaOrdenPrecio(String categoria) {
        try {
            return icprov.getServiciosPorCategoriaOrdenPrecio(categoria);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServiciosPorCategoriaOrdenAlfabeticamente(String categoria) {
        try {
            return icprov.getServiciosPorCategoriaOrdenAlfabeticamente(categoria);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<String> selectBusquedaDatosOrdenPrecio(String buscar) {
        try {
            return icprom.selectBusquedaDatosOrdenPrecio(buscar);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<String> selectBusquedaDatosOrdenAlfabeticamente(String buscar) {
        try {
            return icprom.selectBusquedaDatosOrdenAlfabeticamente(buscar);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public void deleteAllPromociones() {
        try {
            icprom.deleteAllPromociones();
        } catch (SQLException ex) {
            Logger.getLogger(WSPromociones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSPromociones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void insertDatosPromocionesDePrueba() {
        try {
            icprom.insertDatosPromocionesDePrueba();
        } catch (SQLException ex) {
            Logger.getLogger(WSPromociones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSPromociones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public ArrayList getMaxPromociones() {
        try {
            return icprom.getMaxPromociones();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataPromocion> getPromociones() {
        try {
            return icprom.getPromociones();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public DataPromocion getDataPromocion(String nombrePromo, String nombreProveedor) {
        try {
            return icprom.getDataPromocion(nombrePromo, nombreProveedor);
        } catch (SQLException ex) {
            return new DataPromocion();
        } catch (ClassNotFoundException ex) {
            return new DataPromocion();
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServiciosPromocion(String nombrePromo, String nombreProveedor) {
        try {
            return icprom.getServiciosPromocion(nombrePromo, nombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataPromocion> getPromocionesOrdenPrecio() {
        try {
            return icprom.getPromocionesOrdenPrecio();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataPromocion> getPromocionesOrdenAlfabeticamente() {
        try {
            return icprom.getPromocionesOrdenAlfabeticamente();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataCategoria> getCategoriasPadres(){
        try {
            return iccat.getCategoriasPadres();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList getCategoriasRelacionadas(){       
        try {
            return iccat.getCategoriasRelacionadas();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public void deleteAllCategorias(){
        try {
            iccat.deleteAllCategorias();
        } catch (SQLException ex) {
            Logger.getLogger(WSCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void insertCategoriasDePrueba(){
        try {
            iccat.insertCategoriasDePrueba();
        } catch (SQLException ex) {
            Logger.getLogger(WSCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void agregarLog(String ruta, String navegador, String so) {
        try {
            iclog.agregarLog(LocalDate.now(), ruta, navegador, so);
        } catch (SQLException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void eliminarLogsViejos() {
        try {
            iclog.eliminarLogsViejos();
        } catch (SQLException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void posibleAgregar() {
        try {
            iclog.posibleAgregar();
        } catch (SQLException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public String hola(){
        return "hola";
    }
    @WebMethod
    public ArrayList<DataReserva> reservaProveedor(String nickProveedor){
         try {
            return  iccli.ReservaProveedor(nickProveedor);
        } catch (SQLException ex) {
             return new ArrayList();
        } catch (ClassNotFoundException ex) {
             return new ArrayList();
        }
    }
}
