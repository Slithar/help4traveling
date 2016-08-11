/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Datos.*;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author usuario
 */
public class ControladorClientes implements IControladorClientes{
    
    public ControladorClientes(){
        
    }
    @Override
    public boolean correoValido(String correo){
        Cliente c=new Cliente();
        c.setEmail(correo);
        return c.correoValido();
    }
    @Override
    public boolean copiarPerfil(String nickname, String rutaImagen) throws IOException{
        Cliente c = new Cliente();
        c.setNickname(nickname);
        c.setImagen(rutaImagen);
        
        try{
            c.copiarPerfil();
            return true;
        }
        catch(IOException ex){
            return false;
        }
        
    }
    @Override
    public boolean existeNickname(Usuario c) throws SQLException, ClassNotFoundException{
        
        DatosUsuarios cliente = new DatosUsuarios();
        if(cliente.selectCountUsuarios(c.getNickname()) == 0)
            return false;
        else
            return true;              
    }
    
    @Override
    public void agregarCliente(Usuario c) throws SQLException, ClassNotFoundException{
        DatosClientes cliente = new DatosClientes();
        cliente.insertar(c.getNickname(), c.getNombre(), c.getApellido(), c.getEmail(), c.getFechaNac().toString());
        if(c.getImagenUsuario().getPath() != "perfiles/perfil.PNG"){
            cliente.agregarImagen(c.getNickname(), c.getImagenUsuario().getPath());
        }
    }
    
}
