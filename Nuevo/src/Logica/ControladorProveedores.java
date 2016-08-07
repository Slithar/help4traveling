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
        proveedor.insertar(p.getNickname(), p.getNombre(), p.getApellido(), p.getEmail(), p.getFechaNac());
        proveedor.agregarDatosProveedor(p.getNickname(), p.getNombreEmpresa(), p.getLink());
        if(p.getImagenUsuario().getPath() != "perfiles/perfil.PNG"){
            proveedor.agregarImagen(p.getNickname(), p.getImagenUsuario().getPath());
        }
    }
    
}
