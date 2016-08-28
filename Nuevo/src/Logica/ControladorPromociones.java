/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosPromociones;
import java.io.File;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author usuario
 */
public class ControladorPromociones implements IControladorPromociones{
    
    private HashMap<String, Proveedor> ListaProveedores = new HashMap<String, Proveedor>();
    private HashMap<String, Promocion> ListaPromociones;
    
    public ControladorPromociones(){
        
    }

    public HashMap<String, Proveedor> getListaProveedores() {
        return ListaProveedores;
    }

    public void setListaProveedores(HashMap<String, Proveedor> ListaProveedores) {
        this.ListaProveedores = ListaProveedores;
    }

    public HashMap<String, Promocion> getListaPromociones() {
        return ListaPromociones;
    }

    public void setListaPromociones(HashMap<String, Promocion> ListaPromociones) {
        this.ListaPromociones = ListaPromociones;
    }
    
    public void actualizarPromociones() throws SQLException, ClassNotFoundException{
        DatosPromociones promociones = new DatosPromociones();
        ListaPromociones = new HashMap<String, Promocion>();
        ArrayList<Promocion> proms = promociones.selectAllPromociones();
        
        for(int i = 0; i < proms.size(); i++){
            Promocion p = (Promocion) proms.get(i);
            System.out.println("PROMOCION: " + p.getNombre());
            ArrayList<Servicio> servs = promociones.selectServiciosPromocion(p.getNombre());
            ArrayList<Servicio> serviciosDePromocion = new ArrayList<Servicio>();
            for(int j = 0; j < servs.size(); j++){
                //System.out.println(" --" + ListaProveedores.size());
                Proveedor prov = (Proveedor) ListaProveedores.get(servs.get(j).getProveedorServicio().getNombreEmpresa());
                Servicio s = (Servicio) prov.getServicios().get(servs.get(j).getNombreServicio());
                
                //System.out.println(" --" + s.getNombreServicio());
                serviciosDePromocion.add(s);
            }
            p.setServicios(serviciosDePromocion);
            
            Proveedor proveedor = ListaProveedores.get(p.getProveedor().getNombreEmpresa());
            p.setProveedor(proveedor);
            
            ListaPromociones.put(p.getNombre(), p);
        }
    }
    
    public int getCantPromociones(){
        return ListaPromociones.size();
    }
    
    
    
}
