/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.IOException;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public interface IControladorClientes {
    public abstract boolean correoValido(String correo);
    public abstract boolean copiarPerfil(String nickname, String rutaImagen) throws IOException;
    public abstract boolean existeNickname(String c) throws SQLException, ClassNotFoundException;
    public abstract void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate FechaNac,String rutaImagen) throws SQLException, ClassNotFoundException;
    public abstract ArrayList verInfoReserva()throws SQLException, ClassNotFoundException;
}
