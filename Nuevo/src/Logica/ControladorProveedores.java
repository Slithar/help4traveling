/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author usuario
 */
public class ControladorProveedores {
    
    public ControladorProveedores(){
        
    }
    
    public boolean existeNickname(Usuario p) throws SQLException, ClassNotFoundException{
        
        DatosUsuarios proveedor = new DatosUsuarios();
        if(proveedor.selectCountUsuarios(p.getNickname()) == 0)
            return false;
        else
            return true;              
    }
    
    public boolean existeNombreEmpresa(Proveedor p) throws SQLException, ClassNotFoundException{
        DatosProveedores proveedor = new DatosProveedores();
        if(proveedor.selectCountNombreEmpresa(p.getNombreEmpresa()) == 0)
            return false;
        else
            return true;
    }
    
    public void agregarProveedor(Proveedor p) throws SQLException, ClassNotFoundException{
        DatosProveedores proveedor = new DatosProveedores();
        proveedor.insertar(p.getNickname(), p.getNombre(), p.getApellido(), p.getEmail(), p.getFechaNac().toString());
        proveedor.agregarDatosProveedor(p.getNickname(), p.getNombreEmpresa(), p.getLink());
        if(p.getImagenUsuario().getPath() != "perfiles/perfil.PNG"){
            proveedor.agregarImagen(p.getNickname(), p.getImagenUsuario().getPath());
        }
    }
    
    public ArrayList getCiudades() throws SQLException, ClassNotFoundException{
        DatosCiudades ciudades = new DatosCiudades();
        
        ArrayList<Ciudad> arrayCiudades = ciudades.selectAllCiudades();
        ArrayList resultado = new ArrayList();
        
        for(int i = 0; i < arrayCiudades.size(); i++){
            resultado.add(i, arrayCiudades.get(i).getNombre() + " (" + arrayCiudades.get(i).getPais().getNombre() + ")");
        }
        
        return resultado;
        
    }
    
    public ArrayList getProveedores() throws SQLException, ClassNotFoundException{
        DatosProveedores proveedores = new DatosProveedores();
        
        ArrayList<Proveedor> arrayProveedores = proveedores.selectAllProveedores();
        ArrayList resultado = new ArrayList();
        
        for(int i = 0; i < arrayProveedores.size(); i++){
            resultado.add(i, arrayProveedores.get(i).getNombreEmpresa());
        }
        
        return resultado;
    }
    
    public boolean existeNombreServicio(String nombre) throws SQLException, ClassNotFoundException{
        DatosServicios servicios = new DatosServicios();
        
        if(servicios.selectCountNombreServicio(nombre) == 0)
            return false;
        else
            return true;
    }
    
}
