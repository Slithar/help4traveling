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
import Datos.DatosServicios;
import java.sql.SQLException;
import java.util.ArrayList;

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

    @Override
    public void deleteAllPromociones() throws SQLException, ClassNotFoundException {
        DatosPromociones dp = new DatosPromociones();
        dp.deleteAllPromociones("delete from cantidadreservaspromociones where nombrePromocion <> \"\"; \n" +
                        "delete from promociones where nombre <> \"\";");
    }

    @Override
    public void insertDatosPromocionesDePrueba() throws SQLException, ClassNotFoundException {
        DatosPromociones dp = new DatosPromociones();
        dp.insertDatosPromocionesDePrueba("insert into promociones values('Euro-Cars-E-S', 30, 420, 'EuropCar');\n" +
                        "insert into promociones values('Euro-Cars-E-F', 30, 420, 'EuropCar');\n" +
                        "insert into promociones values('Euro-Cars-S-F', 30, 420, 'EuropCar');\n" +
                        "insert into promociones values('Euro-Vuelos-S-LC', 40, 1170, 'Iberia');\n" +
                        "insert into promociones values('Euro-Vuelos-S-FC', 40, 1440, 'Iberia');\n" +
                        "insert into promociones values('Euro-Vuelos-LC-FC', 40, 1290, 'Iberia');\n" +
                        "insert into promociones values('Sudamérica-Casas', 50, 135, 'Segundo Hogar');\n" +
                        "insert into promociones values('Miami-Viaje', 30, 426, 'Segundo Hogar');\n" +
                        "insert into serviciosdepromociones values('Euro-Cars-E-S', 'Euro-Car-1', 'EuropCar');\n" +
                        "insert into serviciosdepromociones values('Euro-Cars-E-S', 'Euro-Car-2', 'EuropCar');\n" +
                        "insert into serviciosdepromociones values('Euro-Cars-E-F', 'Euro-Car-1', 'EuropCar');\n" +
                        "insert into serviciosdepromociones values('Euro-Cars-E-F', 'Euro-Car-3', 'EuropCar');\n" +
                        "insert into serviciosdepromociones values('Euro-Cars-S-F', 'Euro-Car-2', 'EuropCar');\n" +
                        "insert into serviciosdepromociones values('Euro-Cars-S-F', 'Euro-Car-3', 'EuropCar');\n" +
                        "insert into serviciosdepromociones values('Euro-Vuelos-S-LC', 'Euro-Vuelo-S', 'Iberia');\n" +
                        "insert into serviciosdepromociones values('Euro-Vuelos-S-LC', 'Euro-Vuelo-LC', 'Iberia');\n" +
                        "insert into serviciosdepromociones values('Euro-Vuelos-S-FC', 'Euro-Vuelo-S', 'Iberia');\n" +
                        "insert into serviciosdepromociones values('Euro-Vuelos-S-FC', 'Euro-Vuelo-FC', 'Iberia');\n" +
                        "insert into serviciosdepromociones values('Euro-Vuelos-LC-FC', 'Euro-Vuelo-LC', 'Iberia');\n" +
                        "insert into serviciosdepromociones values('Euro-Vuelos-LC-FC', 'Euro-Vuelo-FC', 'Iberia');\n" +
                        "insert into serviciosdepromociones values('Sudamérica-Casas', 'Casa para p4 BsAs', 'Segundo Hogar');\n" +
                        "insert into serviciosdepromociones values('Sudamérica-Casas', 'Floripa G. House', 'Segundo Hogar');\n" +
                        "insert into serviciosdepromociones values('Miami-Viaje', 'Luxury south beach corner apartment', 'Segundo Hogar');\n" +
                        "insert into serviciosdepromociones values('Miami-Viaje', 'Coche-Miami', 'Segundo Hogar');");
    }
    
    
    @Override
    public ArrayList<DataPromocion> getPromociones() throws SQLException, ClassNotFoundException {
        DatosPromociones promocion = new DatosPromociones();
        ArrayList<Promocion> todaslaspromociones = promocion.selectAllPromociones();
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
