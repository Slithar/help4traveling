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
import java.util.*;

/**
 *
 * @author usuario
 */
public class ControladorProveedores implements IControladorProveedores{
    
    public ControladorProveedores(){
        
    }
    
    @Override
    public boolean existeNickname(String nickname) throws SQLException, ClassNotFoundException{
        
        Proveedor p = new Proveedor();
        p.setNickname(nickname);
        
        DatosUsuarios proveedor = new DatosUsuarios();
        if(proveedor.selectCountUsuarios(p.getNickname()) == 0)
            return false;
        else
            return true;              
    }
    
    @Override
    public boolean correoValido(String correo){
        Proveedor p = new Proveedor();
        
        return p.correoValido();
    }
    
    @Override
    public boolean existeNombreEmpresa(String nombreEmpresa) throws SQLException, ClassNotFoundException{
        Proveedor p = new Proveedor();        
        p.setNombreEmpresa(nombreEmpresa);
        
        DatosProveedores proveedor = new DatosProveedores();
        if(proveedor.selectCountNombreEmpresa(p.getNombreEmpresa()) == 0)
            return false;
        else
            return true;
    }
    
    
    @Override
    public boolean copiarPerfil(String nickname, String rutaImagen) throws IOException{
        Proveedor p = new Proveedor();
        p.setNickname(nickname);
        p.setImagen(rutaImagen);
        
        try{
            p.copiarPerfil();
            return true;
        }
        catch(IOException ex){
            return false;
        }
        
    }
    
    /*@Override
    public boolean existeNombreEmpresa(String nombreEmpresa){
        
        
        //return p.
    }*/
    
    @Override
    public void agregarProveedor(String nickname, String nombre, String apellido, String correo, LocalDate fechaNac, String rutaImagen, String empresa, String sitioWeb) throws SQLException, ClassNotFoundException{
        Proveedor p =new Proveedor(nickname, nombre, apellido, correo, fechaNac, rutaImagen, empresa, sitioWeb);
        DatosProveedores proveedor = new DatosProveedores();
        proveedor.insertar(p.getNickname(), p.getNombre(), p.getApellido(), p.getEmail(), p.getFechaNac().toString());
        proveedor.agregarDatosProveedor(p.getNickname(), p.getNombreEmpresa(), p.getLink());
        if(p.getImagenUsuario().getPath() != "perfiles/perfil.PNG"){
            proveedor.agregarImagen(p.getNickname(), p.getImagenUsuario().getPath());
        }
    }
    
    @Override
    public ArrayList getCiudades() throws SQLException, ClassNotFoundException{
        DatosCiudades ciudades = new DatosCiudades();
        
        ArrayList<Ciudad> arrayCiudades = ciudades.selectAllCiudades();
        ArrayList resultado = new ArrayList();
        
        for(int i = 0; i < arrayCiudades.size(); i++){
            resultado.add(i, arrayCiudades.get(i).getNombre() + " (" + arrayCiudades.get(i).getPais().getNombre() + ")");
        }
        
        return resultado;
        
    }
    
    @Override
    public ArrayList getProveedores() throws SQLException, ClassNotFoundException{
        DatosProveedores proveedores = new DatosProveedores();
        
        ArrayList<Proveedor> arrayProveedores = proveedores.selectAllProveedores();
        ArrayList resultado = new ArrayList();
        
        for(int i = 0; i < arrayProveedores.size(); i++){
            resultado.add(i, arrayProveedores.get(i).getNombreEmpresa());
        }
        
        return resultado;
    }
    
    @Override
    public boolean existeNombreServicio(String nombre) throws SQLException, ClassNotFoundException{
        DatosServicios servicios = new DatosServicios();
        
        if(servicios.selectCountNombreServicio(nombre) == 0)
            return false;
        else
            return true;
    }
    
    @Override
    public void agregarServicio(Servicio s) throws SQLException, ClassNotFoundException{
        
        DatosServicios servicios = new DatosServicios();
        
        boolean tieneDestino = true;
        
        if(s.getDestino().getNombre().equals("No"))
            tieneDestino = false;
        else
            tieneDestino = true;
        
        //System.out.println(s.getDestino().getNombre());
        
        /*if(tieneDestino)
            System.out.println("destino si");
        else
            System.out.println("destino no");*/
        
        servicios.insertar(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa(), s.getOrigen().getNombre(), s.getDestino().getNombre(), s.getDescripcionServicio(), s.getPrecioServicio(), tieneDestino);
        
        ArrayList<Categoria> categoriasServicio = s.getCategoriasServicio();
        
        for(int i = 0; i < categoriasServicio.size(); i++){
            servicios.agregarCategoria(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa(), categoriasServicio.get(i).getNombre());
        }
        
        ArrayList<ImagenServicio> imagenes = s.getImagenesServicio();
        
        for(int i = 0; i <imagenes.size(); i++){
            servicios.agregarImagen(imagenes.get(i).getPath(), s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa());
        }
        
    }
    
}
