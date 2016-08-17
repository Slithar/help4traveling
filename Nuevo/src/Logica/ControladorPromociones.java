/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import Datos.*;
import java.sql.SQLException;
/**
 *
 * @author usuario
 */
public class ControladorPromociones implements IControladorPromociones{
    
    public ControladorPromociones(){
        
    }
    @Override
    public int devolverPrecio(String cadena){
        String[] array = new String[3];
        array = cadena.split(",");
        int A;
        A = Integer.parseInt(array[1].trim());
        return A;
    }
    @Override
    public int obtenerPrecio(int Precio, ArrayList<Integer> todosLosPrecios, int descuento){
        int aDescontar=0;
        Precio = 0;
        for(int i = 0; i < todosLosPrecios.size(); i++){
            Precio += todosLosPrecios.get(i);
            if(descuento!=0){
                aDescontar =(Precio * descuento)/100;
            }
        }
        return Precio-aDescontar;
    }
    @Override
    public String obtenerProveedor(String cadena){
        String[] array = new String[3];
        array = cadena.split(",");
        String A;
        A = String.valueOf((array[2].trim()));
        return A;
    }
    @Override
    public String obtenerServicio(String cadena){
        String[] array = new String[3];
        array = cadena.split(",");
        String A;
        A = String.valueOf((array[0].trim()));
        return A;
    }
    @Override
     public boolean agregarNuevaPromocion(String nombrePromo,int descuentoPromo, int precioPromo ) throws SQLException, ClassNotFoundException{
         DatosPromocion datoPromo = new DatosPromocion();
         Promocion promo = new Promocion(nombrePromo,descuentoPromo,precioPromo);
         int control = 0;
         boolean control2 = false;
         control = datoPromo.agregarPromo(promo.getNombre(), promo.getDescuento(), promo.getPrecio());
         if(control==1)
             control2=true;
         return control2;
     }
     
     @Override
     public boolean agregarServiciosPromocion(String NombrePromo, DefaultListModel modelo) throws SQLException, ClassNotFoundException{
         int vueltas=0;
         String servicio="";
         String prove="";
         int control = 0;
         boolean control2 = false;
         Promocion promo = new Promocion();
         promo.setNombre(NombrePromo);
         DatosPromocion datoPromo = new DatosPromocion();
         for(vueltas=0;vueltas<modelo.size();vueltas++){
             servicio = this.obtenerServicio((String)modelo.get(vueltas));
             prove = this.obtenerProveedor((String)modelo.get(vueltas));
             control = datoPromo.agregarServiciosPromo(promo.getNombre(),servicio,prove);
         }
         if(control==1)
             control2=true;
         return control2;
     }
       
}
