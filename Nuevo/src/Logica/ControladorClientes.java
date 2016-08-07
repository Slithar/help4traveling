/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Datos.*;
import java.sql.*;

/**
 *
 * @author usuario
 */
public class ControladorClientes {
    
    public ControladorClientes(){
        
    }
    
    public boolean existeNickname(Usuario c) throws SQLException, ClassNotFoundException{
        
        DatosUsuarios cliente = new DatosUsuarios();
        if(cliente.selectCountUsuarios(c.getNickname()) == 0)
            return true;
        else
            return false;              
    }
    
    public void agregarCliente(Usuario c) throws SQLException, ClassNotFoundException{
        DatosClientes cliente = new DatosClientes();
        cliente.insertar(c.getNickname(), c.getNombre(), c.getApellido(), c.getEmail(), c.getFechaNac());
        if(c.getImagenUsuario().getPath() != "perfiles/perfil.PNG"){
            cliente.agregarImagen(c.getNickname(), c.getImagenUsuario().getPath());
        }
    }
    
}
