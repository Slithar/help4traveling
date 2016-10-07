/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.time.*;

/**
 *
 * @author usuario
 */
public interface IControladorProveedores {
    
    public abstract boolean existeNickname(String nickname) throws SQLException, ClassNotFoundException;
    public abstract boolean existeCorreo(String correo) throws SQLException, ClassNotFoundException;
    public abstract boolean correoValido(String correo);
    public abstract boolean sitiWebValido(String sitioWeb);
    public abstract boolean copiarPerfil(String nickname, ArrayList<String> rutaImagen) throws IOException;
    public abstract void agregarProveedor(String nickname, String nombre, String apellido, String correo, LocalDate fechaNac, ArrayList<String> rutaImagen, String empresa, String sitioWeb, HashMap<String, Servicio> servicios, String pass) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataCiudad> getCiudades() throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataProveedor> getProveedores() throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataProveedor> getInfoProveedores() throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataProveedor> verInfoProveedorBusqueda(String nickname) throws SQLException, ClassNotFoundException;
    public abstract DataProveedor verInfoProveedor(String nickname) throws SQLException, ClassNotFoundException;
    public abstract boolean existeNombreServicio(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException;
    public abstract void agregarServicio(String nombre, String descripcion, int precio, String nombreProveedor, ArrayList<String> imagenes, ArrayList<String> categorias, String ciudadOrigen, String ciudadDestino, boolean tieneDestino) throws SQLException, ClassNotFoundException;
    public abstract void copiarImagenServicio(String nombreActual, String nombreDestino) throws IOException;
    public abstract ArrayList<DataServicio> getServicios() throws SQLException, ClassNotFoundException;
    public abstract DataServicio getDatosServicio(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException;
    public abstract DataCiudad getCiudadOrigen(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException;
    public abstract DataCiudad getCiudadDestino(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataCategoria> getCategorias(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataImagen> getImagenes(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataImagen> getImagenesProv(String nombreProveedor) throws SQLException, ClassNotFoundException;
    public abstract void modificarServicio(String nombre, String descripcion, int precio, String nombreProveedor, ArrayList<String> imagenes, ArrayList<String> categorias, String ciudadOrigen, String ciudadDestino, boolean tieneDestino) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataServicio> getServiciosPorBusqueda(String nombre) throws SQLException, ClassNotFoundException;
    public abstract void actualizarProveedores() throws SQLException, ClassNotFoundException;    
    public abstract int getCantProveedores();
    public abstract void actualizarCiudades() throws SQLException, ClassNotFoundException;    
    public abstract int getCantCiudades();
    public abstract HashMap<String, Categoria> getListaCategorias();
    public abstract void setListaCategorias(HashMap<String, Categoria> ListaCategorias);
    public abstract HashMap<String, Proveedor> getListaProveedores();
    public abstract void setListaProveedores(HashMap<String, Proveedor> ListaProveedores);
    public abstract void eliminarImagenesUsuarios();    
    public abstract void eliminarImagenesServicios();
    public abstract void deleteAllProveedores() throws SQLException, ClassNotFoundException;
    public abstract void insertCiudadesDePrueba() throws SQLException, ClassNotFoundException;
    public abstract void insertDatosProveedoresDePrueba() throws SQLException, ClassNotFoundException;    
    public abstract ArrayList<DataServicio> getServiciosProveedor(String NombreProveedor) throws SQLException,ClassNotFoundException;
    public abstract DataProveedor getNombreEmpresa(String nick) throws SQLException,ClassNotFoundException;
    public abstract String encriptar(String pass);
    public abstract ArrayList<DataServicio> getServiciosPorCategoria(String categoria) throws SQLException,ClassNotFoundException;
    public abstract BufferedImage copiarImagenesServicio(String ruta) throws SQLException, ClassNotFoundException, IOException;
    public abstract ArrayList<BufferedImage> imagenesProveedorABytes(String nickname) throws SQLException, ClassNotFoundException, IOException;
    public abstract ArrayList<String> rutaImagenesServicios(String nombre, String nickProveedor) throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataServicio> getServiciosPorCategoriaOrdenPrecio(String categoria) throws SQLException,ClassNotFoundException;
    public abstract ArrayList<DataServicio> getServiciosPorCategoriaOrdenAlfabeticamente(String categoria) throws SQLException,ClassNotFoundException;
    
    
}
