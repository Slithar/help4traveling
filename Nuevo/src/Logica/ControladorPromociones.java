/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosPromociones;
import Datos.DatosServicios;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ControladorPromociones implements IControladorPromociones{
    
    public ControladorPromociones(){
        
    }

    @Override
    public ArrayList<DataPromocion> getPromociones() throws SQLException, ClassNotFoundException {
        DatosPromociones promocion = new DatosPromociones();
        ArrayList<Promocion> todaslaspromociones = promocion.getDatosPromociones();
        ArrayList<DataPromocion> resultado = new ArrayList();
        for(int i = 0; i < todaslaspromociones.size(); i++){
            DataPromocion promo = new DataPromocion();
            promo.setNombre(todaslaspromociones.get(i).getNombre());
            promo.setDescuento(todaslaspromociones.get(i).getDescuento());
            promo.setPrecio(todaslaspromociones.get(i).getPrecio());
            resultado.add(promo);
        }
        return resultado;
    }
    
    @Override
    public ArrayList<DataServicio> getServiciosPorPromocion(String nombrePromo) throws SQLException, ClassNotFoundException{
        ArrayList<DataServicio> resultado = new ArrayList();
        DatosServicios servicio = new DatosServicios();
        ArrayList<Servicio> todoslosservicios = servicio.getServicioPorPromocion(nombrePromo);
        for(int i = 0; i < todoslosservicios.size(); i++){
            DataServicio serv = new DataServicio();
            serv.setNombreServicio(todoslosservicios.get(i).getNombreServicio());
            serv.setNombreProveedor(todoslosservicios.get(i).getProveedorServicio().getNombreEmpresa());
            serv.setOrigen(todoslosservicios.get(i).getOrigen().getNombre());
            serv.setDestino(todoslosservicios.get(i).getDestino().getNombre());
            serv.setDescripcionServicio(todoslosservicios.get(i).getDescripcionServicio());
            serv.setPrecioServicio(todoslosservicios.get(i).getPrecioServicio());
            
            resultado.add(serv);
        }
       return resultado; 
    }
    @Override
    public DataPromocion getDataPromocion(String nombrePromo, String nombreProveedor) throws SQLException, ClassNotFoundException{
        DataPromocion promocion = new DataPromocion();
        DatosPromociones promociones = new DatosPromociones();
        Promocion promo = new Promocion();
        promo = promociones.getDataPromocion(nombrePromo, nombreProveedor);
        
        
        promocion.setNombre(promo.getNombre());
        promocion.setDescuento(promo.getDescuento());
        promocion.setPrecio(promo.getPrecio());
        
        return promocion;
    }
}
