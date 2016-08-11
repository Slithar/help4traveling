/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Datos.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

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
    public boolean existeNickname(String c) throws SQLException, ClassNotFoundException{
        
        DatosUsuarios cliente = new DatosUsuarios();
        if(cliente.selectCountUsuarios(c) == 0)
            return false;
        else
            return true;              
    }
    
    @Override
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate FechaNac, String rutaImagen) throws SQLException, ClassNotFoundException{
        DatosClientes cliente = new DatosClientes();
        cliente.insertar(nickname, nombre,apellido, mail, FechaNac.toString());
        if(rutaImagen != "perfiles/perfil.PNG"){
            cliente.agregarImagen(nickname, rutaImagen);
        }
    }
    
}
