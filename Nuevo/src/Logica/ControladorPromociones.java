/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosPromociones;
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
    
    @Override
    public int getCantPromociones(){
        return ListaPromociones.size();
    }
    
@Override
public int getPrecio(String cadena){
    String [] partes = new String[2];
    partes = cadena.split("-");
    int precio = 0;
    precio = Integer.parseInt(partes[1]);
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
public int agregarPromocion(int PrecioPromocion, String NombrePromocion, int Descuento) throws SQLException, ClassNotFoundException{
    
    DatosPromociones dPromo = new DatosPromociones();
    
    Promocion promo = new Promocion();
    
    promo.setNombre(NombrePromocion);
    
    promo.setPrecio(PrecioPromocion);
    
    promo.setDescuento(Descuento);
    
    int a = 0;
    
    a = dPromo.agregarPromocion(promo.getPrecio(),promo.getNombre(),promo.getDescuento());
    
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
    
    partes = cadena.split("-");
    
    String nombre;
    
    nombre = String.valueOf(partes[0]);
    
    return nombre;
    
}

}
