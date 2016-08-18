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
import java.util.ArrayList;

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

    @Override
    public ArrayList<DataCliente> getClientes() throws SQLException, ClassNotFoundException {
        ArrayList <DataCliente> resultado = new ArrayList();
        
        DatosClientes cliente = new DatosClientes();
        ArrayList <Cliente> arrayClientes = cliente.selectAllClientes();
        
        for(int i=0; i< arrayClientes.size(); i++){
            DataCliente cli = new DataCliente();
            cli.setNickname(arrayClientes.get(i).getNickname());
            cli.setNombre(arrayClientes.get(i).getNombre());
            cli.setApellido(arrayClientes.get(i).getApellido());
            cli.setEmail(arrayClientes.get(i).getEmail());
            cli.setFechaNac(LocalDate.parse(String.valueOf(arrayClientes.get(i).getFechaNac())));
            
            resultado.add(cli);
        }
        
        return resultado;
    }
    
}
