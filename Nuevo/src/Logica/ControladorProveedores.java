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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

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
        p.setEmail(correo);
        
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
    public ArrayList<DataCiudad> getCiudades() throws SQLException, ClassNotFoundException{
        DatosCiudades ciudades = new DatosCiudades();
        
        ArrayList<Ciudad> arrayCiudades = ciudades.selectAllCiudades();
        ArrayList<DataCiudad> resultado = new ArrayList();
        
        for(int i = 0; i < arrayCiudades.size(); i++){
            resultado.add(i, new DataCiudad(arrayCiudades.get(i).getNombre(), arrayCiudades.get(i).getPais().getNombre()));
        }
        
        return resultado;
        
    }
    
    @Override
    public ArrayList<DataProveedor> getProveedores() throws SQLException, ClassNotFoundException{
        DatosProveedores proveedores = new DatosProveedores();
        
        ArrayList<Proveedor> arrayProveedores = proveedores.selectAllProveedores();
        ArrayList<DataProveedor> resultado = new ArrayList();
        
        for(int i = 0; i < arrayProveedores.size(); i++){
            String nombreEmpresa = arrayProveedores.get(i).getNombreEmpresa();
            DataProveedor dp = new DataProveedor();
            dp.setNombreEmpresa(nombreEmpresa);
            resultado.add(dp);
        }
        
        return resultado;
    }
    
    @Override
    public boolean existeNombreServicio(String nombre) throws SQLException, ClassNotFoundException{
        
        Servicio s = new Servicio();
        s.setNombreServicio(nombre);
        
        DatosServicios servicios = new DatosServicios();
        
        if(servicios.selectCountNombreServicio(s.getNombreServicio()) == 0)
            return false;
        else
            return true;
    }
    
    @Override
    public void agregarServicio(String nombre, String descripcion, int precio, String nombreProveedor, ArrayList<String> imagenes, ArrayList reservas, ArrayList promociones, ArrayList<String> categorias, String ciudadOrigen, String ciudadDestino, boolean tieneDestino) throws SQLException, ClassNotFoundException{
        
        Proveedor prov = new Proveedor();
        prov.setNombreEmpresa(nombreProveedor);
        
        ArrayList<ImagenServicio> imagenesServicio = new ArrayList<ImagenServicio>();
        ArrayList<Categoria> categoriasServicio = new ArrayList<Categoria>();
        
        for(int i = 0; i < imagenes.size(); i++){
            imagenesServicio.add(new ImagenServicio(imagenes.get(i), new Servicio()));            
        }
        
        for(int i = 0; i < categorias.size(); i++){
            //JOptionPane.showMessageDialog(null, categorias.get(i));
            String cat = (String) categorias.get(i);
            //int cant = contador(cat, '>');
            
            int cant = 0;
        
            for(int j = 0; j < cat.length(); j++){
                if(cat.charAt(j) == '>')
                    cant++;
            }
            
            String[] c = cat.split(">");
            //categorias.add((String) cat);
            
            categoriasServicio.add(new Categoria(c[cant].trim(), categorias.get(i), new ArrayList()));
        }
        
       
        
        
        Servicio s = new Servicio(nombre, descripcion, precio, prov, imagenesServicio, reservas, promociones, categoriasServicio, new Ciudad(ciudadOrigen, new ArrayList(), new Pais()),  new Ciudad(ciudadDestino, new ArrayList(), new Pais()), tieneDestino);  
        
        
        DatosServicios servicios = new DatosServicios();
        
        boolean hayDestino = true;
        
        if(s.getDestino().getNombre().equals("No"))
            hayDestino = false;
        else
            hayDestino = true;
        
        //System.out.println(s.getDestino().getNombre());
        
        /*if(tieneDestino)
            System.out.println("destino si");
        else
            System.out.println("destino no");*/
        
        
        //JOptionPane.showMessageDialog(null, s.getProveedorServicio().getNombreEmpresa());
        
        servicios.insertar(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa(), s.getOrigen().getNombre(), s.getDestino().getNombre(), s.getDescripcionServicio(), s.getPrecioServicio(), tieneDestino);
        
        
        
        //ArrayList<Categoria> categoriasServicio = s.getCategoriasServicio();
        categoriasServicio = s.getCategoriasServicio();
        
        for(int i = 0; i < categoriasServicio.size(); i++){
            //JOptionPane.showMessageDialog(null, categoriasServicio.get(i).getNombre());
            servicios.agregarCategoria(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa(), categoriasServicio.get(i).getNombre(), categoriasServicio.get(i).getRutaCategoria());
        }
        
        //ArrayList<ImagenServicio> imagenes = s.getImagenesServicio();
        imagenesServicio = s.getImagenesServicio();
        
        for(int i = 0; i <imagenesServicio.size(); i++){
            servicios.agregarImagen(imagenesServicio.get(i).getPath(), s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa());
        }
        
    }
    
    @Override
    public void copiarImagenServicio(String nombreActual, String nombreDestino) throws IOException{
        ImagenServicio is = new ImagenServicio(nombreActual, new Servicio());
        //try {
        is.copiarImagen(nombreDestino);
        //} catch (IOException ex) {
            //Logger.getLogger(ControladorProveedores.class.getName()).log(Level.SEVERE, null, ex);
            //throws ex;
        //}
    }
    
    
    @Override
    public ArrayList<DataServicio> getServicios() throws SQLException, ClassNotFoundException{
        DatosServicios servicios = new DatosServicios();
        ArrayList<DataServicio> arrayServicios = new ArrayList();
        arrayServicios = servicios.getServicios();
        return arrayServicios;
    }
}
