    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.*;
import java.util.*;
import javax.swing.table.TableModel;

/**
 *
 * @author usuario
 */
public interface IControladorClientes {
    public abstract boolean correoValido(String correo);
    public abstract boolean copiarPerfil(String nickname, String rutaImagen) throws IOException;
    public abstract boolean existeNickname(String c) throws SQLException, ClassNotFoundException;
    public abstract boolean existeCorreo(String correo) throws SQLException, ClassNotFoundException; 
    public abstract void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate FechaNac, String rutaImagen, String pass) throws SQLException, ClassNotFoundException;
    public abstract ArrayList verInfoReserva()throws SQLException, ClassNotFoundException;
    public abstract DataReserva getReserva(String nombreRes)throws SQLException, ClassNotFoundException;
    public abstract ArrayList getReservasPromo(String numeroProm) throws SQLException, ClassNotFoundException;
    public abstract ArrayList getReservasServ(String numeroServ) throws SQLException, ClassNotFoundException;
    public abstract void actualizarClientes() throws SQLException, ClassNotFoundException;    
    public abstract int getCantClientes();
    public abstract HashMap<String, Proveedor> getListaProveedores();
    public abstract void setListaProveedores(HashMap<String, Proveedor> ListaProveedores);
    public abstract HashMap<String, Promocion> getListaPromociones();
    public abstract void setListaPromociones(HashMap<String, Promocion> ListaPromociones);
    public abstract ArrayList datosReserva ()throws SQLException, ClassNotFoundException;
    public abstract void updateEstadoReserva(int numero,String estado) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataCliente> getClientes()throws SQLException, ClassNotFoundException;
    public abstract void deleteAllClientes() throws SQLException, ClassNotFoundException;
    public abstract void insertDatosClientesDePrueba() throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataCliente> verInfoCliente() throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataCliente> verInfoClienteBusqueda(String nickname) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataReserva> reservasCliente(String nickname)throws SQLException, ClassNotFoundException;
    public abstract void deleteReserva(int numReserva) throws SQLException, ClassNotFoundException;    
    public abstract DataCliente seleccionarCliente(String nickname) throws SQLException, ClassNotFoundException;
    public abstract int  realizarReserva(LocalDate fecha, int precio, String estado, String cliente)throws SQLException, ClassNotFoundException;
    public abstract void datosAsociadosReserva(int numReserva, TableModel modelo)throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataReserva> getAllReservas() throws SQLException, ClassNotFoundException;
    public abstract int getNumeroReserva(LocalDate fecha, int precio, String nickname) throws SQLException, ClassNotFoundException;
    public abstract String encriptar(String pass);
    public abstract DataCliente getClienteByNickname(String Nickname) throws SQLException, ClassNotFoundException;
    public abstract DataCliente seleccionarClienteWeb(String nickname) throws SQLException, ClassNotFoundException; 
    public abstract BufferedImage imagenLogueado(String nickname) throws SQLException, ClassNotFoundException, IOException;
    public abstract void datosAsociadosReservaWeb(int numReserva, String tipo, String nombreProducto, String nickProveedor, String fechaInicio, String fechaFin, int cantidad, int totalLinea) throws SQLException, ClassNotFoundException;
    public abstract void agregarImagenPerfilWeb(BufferedImage img, String nick) throws SQLException, ClassNotFoundException, IOException;
    public  abstract ArrayList<DataReserva> ReservaProveedor(String nickProveedor)throws SQLException, ClassNotFoundException;
}
