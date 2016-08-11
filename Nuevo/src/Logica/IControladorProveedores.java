/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
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
    public abstract boolean correoValido(String correo);
    public abstract boolean copiarPerfil(String nickname, String rutaImagen) throws IOException;
    public abstract boolean existeNombreEmpresa(String nombreEmpresa) throws SQLException, ClassNotFoundException;
    public abstract void agregarProveedor(String nickname, String nombre, String apellido, String correo, LocalDate fechaNac, String rutaImagen, String empresa, String sitioWeb) throws SQLException, ClassNotFoundException;
    public abstract ArrayList getCiudades() throws SQLException, ClassNotFoundException;
    public abstract ArrayList getProveedores() throws SQLException, ClassNotFoundException;
    public abstract boolean existeNombreServicio(String nombre) throws SQLException, ClassNotFoundException;
    public abstract void agregarServicio(Servicio s) throws SQLException, ClassNotFoundException;
    
}
