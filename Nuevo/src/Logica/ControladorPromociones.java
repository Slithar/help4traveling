/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosPromociones;
import Datos.DatosServicios;
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

    @Override
    public HashMap<String, Proveedor> getListaProveedores() {
        return ListaProveedores;
    }

    @Override
    public void setListaProveedores(HashMap<String, Proveedor> ListaProveedores) {
        this.ListaProveedores = ListaProveedores;
    }

    @Override
    public HashMap<String, Promocion> getListaPromociones() {
        return ListaPromociones;
    }

    @Override
    public void setListaPromociones(HashMap<String, Promocion> ListaPromociones) {
        this.ListaPromociones = ListaPromociones;
    }
    
    @Override
    public void actualizarPromociones() throws SQLException, ClassNotFoundException{
        DatosPromociones promociones = new DatosPromociones();
        ListaPromociones = new HashMap<String, Promocion>();
        ArrayList<Promocion> proms = promociones.selectAllPromociones();
        
        for(int i = 0; i < proms.size(); i++){
            Promocion p = (Promocion) proms.get(i);
            //System.out.println("PROMOCION: " + p.getNombre());
            ArrayList<Servicio> servs = promociones.selectServiciosPromocion(p.getNombre());
            ArrayList<Servicio> serviciosDePromocion = new ArrayList<Servicio>();
            for(int j = 0; j < servs.size(); j++){
                Proveedor prov = (Proveedor) ListaProveedores.get(servs.get(j).getProveedorServicio().getNombreEmpresa());
                Servicio s = (Servicio) prov.getServicios().get(servs.get(j).getNombreServicio());
                serviciosDePromocion.add(s);
            }
            p.setServicios(serviciosDePromocion);
            
            Proveedor proveedor = ListaProveedores.get(p.getProveedor().getNombreEmpresa());
            p.setProveedor(proveedor);
            
            ListaPromociones.put(p.getNombre(), p);
        }
    }
    
    @Override
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
                        "insert into promociones values('Miami-Viaje', 30, 462, 'Segundo Hogar');\n" +
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
public int getPrecio(String cadena){
    String [] partes = new String[2];
    partes = cadena.split("/");
    int precio = 0;
    precio = Integer.parseInt(partes[1].trim());
    return precio;
}
@Override
public int calcularPrecio(ArrayList<Integer> precios, int Descuento){
    int tamanio = 0;
    int inicio = 0;
    int precioTotal=0;
    tamanio = precios.size();
    for(inicio = 0; inicio<tamanio;inicio++){
        precioTotal+=precios.get(inicio);
    }
    if(Descuento != 0)
        precioTotal = precioTotal - (precioTotal * Descuento) / 100;
    return precioTotal;
}
@Override
public int agregarPromocion(int PrecioPromocion, String NombrePromocion, int Descuento, String nombreProveedor) throws SQLException, ClassNotFoundException{
    
    DatosPromociones dPromo = new DatosPromociones();
    
    Promocion promo = new Promocion();
    Proveedor p = new Proveedor();
    
    promo.setNombre(NombrePromocion);
    
    promo.setPrecio(PrecioPromocion);
    
    promo.setDescuento(Descuento);
    
    p.setNombreEmpresa(nombreProveedor);
    promo.setProveedor(p);
    
    int a = 0;
    
    a = dPromo.agregarPromocion(promo.getPrecio(),promo.getNombre(),promo.getDescuento(), promo.getProveedor().getNombreEmpresa());
    
    return a;
}
@Override
public int agregarServiciosPromocion(String NombrePromo, String NombreServ, String NombreProv) throws SQLException, ClassNotFoundException{
    Promocion promo = new Promocion();
    
    Servicio serv = new Servicio();
    
    Proveedor prov = new Proveedor();
    
    int resultado = 0;
    
    DatosPromociones dPromo = new DatosPromociones();
    
    promo.setNombre(NombrePromo);
    
    serv.setNombreServicio(NombreServ);
    
    prov.setNombreEmpresa(NombreProv);
    
    resultado = dPromo.agregarServiciosPromocion(promo.getNombre(),serv.getNombreServicio(), prov.getNombreEmpresa());
    
    return resultado;
}

@Override
public String getNombreServicio(String cadena){
    
    String [] partes = new String[2];
    
    partes = cadena.split("/");
    
    String nombre;
    
    nombre = String.valueOf(partes[0].trim());
    
    return nombre;
    
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
            promo.setProveedor(todaslaspromociones.get(i).getProveedor().getNombreEmpresa());
            resultado.add(promo);
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
    
    @Override
    public ArrayList<DataServicio> getServiciosPromocion(String nombrePromo, String nombreProveedor) throws SQLException, ClassNotFoundException{
        ArrayList<DataServicio> DTservs = new ArrayList();
        ArrayList<Servicio> servs = new ArrayList();
        Promocion promo = new Promocion();
        Proveedor prov = new Proveedor();
        promo.setNombre(nombrePromo);
        prov.setNombreEmpresa(nombreProveedor);
        promo.setProveedor(prov);
        DatosPromociones dPromo = new DatosPromociones();
        servs = dPromo.selectAllServiciosPromocion(nombrePromo, nombreProveedor);
        int a = 0;
        for(a=0;a<servs.size();a++){
            DataServicio dservicio = new DataServicio();
            dservicio.setNombreServicio(servs.get(a).getNombreServicio());
            dservicio.setNombreProveedor(servs.get(a).getProveedorServicio().getNombreEmpresa());
            DTservs.add(dservicio);
        }
        return DTservs;

    }
}
