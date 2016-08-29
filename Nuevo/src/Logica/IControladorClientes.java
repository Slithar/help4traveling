/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.IOException;
import java.sql.*;
import java.time.*;
import java.util.*;

/**
 *
 * @author usuario
 */
public interface IControladorClientes {
    public abstract boolean correoValido(String correo);
    public abstract boolean copiarPerfil(String nickname, String rutaImagen) throws IOException;
    public abstract boolean existeNickname(String c) throws SQLException, ClassNotFoundException;
    public abstract void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate FechaNac, String rutaImagen) throws SQLException, ClassNotFoundException;
    public abstract ArrayList verInfoReserva()throws SQLException, ClassNotFoundException;
    public abstract DataReserva getReserva(String nombreRes)throws SQLException, ClassNotFoundException;
    public abstract ArrayList getReservasPromo(String numeroProm);
    public abstract ArrayList getReservasServ(String numeroServ);
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
    
}
