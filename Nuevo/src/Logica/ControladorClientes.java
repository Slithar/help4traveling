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
public class ControladorClientes implements IControladorClientes {
    
    private HashMap<String, Cliente> ListaClientes;
    
    public ControladorClientes() {

    }

    @Override
    public boolean correoValido(String correo) {
        Cliente c = new Cliente();
        c.setEmail(correo);
        return c.correoValido();
    }

    @Override
    public boolean copiarPerfil(String nickname, String rutaImagen) throws IOException {
        Cliente c = new Cliente();
        c.setNickname(nickname);
        c.setImagen(rutaImagen);

        try {
            c.copiarPerfil();
            return true;
        } catch (IOException ex) {
            return false;
        }

    }

    @Override
    public boolean existeNickname(String c) throws SQLException, ClassNotFoundException {

        DatosUsuarios cliente = new DatosUsuarios();
        if (cliente.selectCountUsuarios(c) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate FechaNac, String rutaImagen) throws SQLException, ClassNotFoundException {
        DatosClientes cliente = new DatosClientes();
        Cliente c = new Cliente(nickname, nombre, apellido, mail, FechaNac, rutaImagen, new HashMap<String, Reserva>());
        cliente.insertar(c.getNickname(), c.getNombre(), c.getApellido(), c.getEmail(), c.getFechaNac().toString());
        if (rutaImagen != "perfiles/perfil.PNG") {
            cliente.agregarImagen(c.getNickname(), c.getImagenUsuario().getPath());
        }
    }

    public ArrayList verInfoReserva() throws SQLException, ClassNotFoundException {
        //solo obtiene los numeros de la reserva
        DatosClientes dataux = new DatosClientes();
        return dataux.verInfoReserva();
    }
  
    public DataReserva getReserva(String numeroRes){
        DataReserva dtAux =new  DataReserva ();
        DatosClientes datCli = new DatosClientes();
        ArrayList <DataCantidadReservasPromociones> listProm= new ArrayList();
        ArrayList <DataCantidadReservasServicios> listServ= new ArrayList();
        Reserva res= datCli.getReserva(numeroRes);
     dtAux.setNumero(res.getNumero());
     dtAux.setCliente(res.getCliente().getNickname());
     dtAux.setPrecio(res.getPrecio());
     dtAux.setFecha(res.getFecha());
     dtAux.setEstado(String.valueOf(res.getEstado()));
     if(res.getReservacantPromociones().size() > 0){
         for(int i=0;i<res.getReservacantPromociones().size();i++){
            cantidadReservasPromociones promAux= res.getReservacantPromociones().get(i);
            DataCantidadReservasPromociones dataProm=new DataCantidadReservasPromociones(promAux.getCantidad(),promAux.getFechaInicio(),promAux.getFechaFin(),promAux.getPromocion().getNombre());
            listProm.add(dataProm);


         }
         for(int i=0;i<res.getServiciosReserva().size();i++){
             cantidadReservasServicios promServ =res.getServiciosReserva().get(i);
             DataCantidadReservasServicios promServi = new DataCantidadReservasServicios(promServ.getCantidad(),promServ.getFechaInicio(),promServ.getFechaFin(),0,promServ.getNombreS(),promServ.getProveedor().getNombreEmpresa());
             listServ.add(promServi);

         }
     }
          
     return dtAux;
        
    }
    @Override
      public ArrayList getReservasPromo(String numeroProm){
          DatosClientes dataux = new DatosClientes();
     /*ArrayList <DataCantidadReservasPromociones> listProm= new ArrayList();

        for(int i=0;i<dataux.getReservasPromo(numeroProm).size();i++){
        cantidadReservasPromociones promAux= (cantidadReservasPromociones) dataux.getReservasPromo(numeroProm).get(i);
        DataCantidadReservasPromociones dataProm=new DataCantidadReservasPromociones(promAux.getCantidad(),promAux.getFechaInicio(),promAux.getFechaFin(),promAux.getPromocion().getNombre());
        listProm.add(dataProm);
        
   
     }
        return listProm;*/
        ArrayList<cantidadReservasPromociones> listProm = new ArrayList();
        listProm = dataux.getReservasPromo(numeroProm);
        
        ArrayList<DataCantidadReservasPromociones> dataListProm = new ArrayList<DataCantidadReservasPromociones>();
        for(int i=0;i<listProm.size();i++){
            cantidadReservasPromociones promAux= (cantidadReservasPromociones) listProm.get(i);
            DataCantidadReservasPromociones dataProm=new DataCantidadReservasPromociones(promAux.getCantidad(),promAux.getFechaInicio(),promAux.getFechaFin(),promAux.getPromocion().getNombre());
            dataListProm.add(dataProm);
        }
        
        return dataListProm;
      }
      
    @Override
       public ArrayList getReservasServ(String numeroServ){
          DatosClientes dataux = new DatosClientes();
          ArrayList <cantidadReservasServicios> listServ= new ArrayList();
          listServ = dataux.getServiciosPromo(numeroServ);
          
          ArrayList<DataCantidadReservasServicios> dataListServ = new ArrayList<DataCantidadReservasServicios>();
           for(int i=0;i<listServ.size();i++){
         cantidadReservasServicios promServ = listServ.get(i);
         DataCantidadReservasServicios promServi = new DataCantidadReservasServicios(promServ.getCantidad(),promServ.getFechaInicio(),promServ.getFechaFin(), 0, promServ.getNombreS(), promServ.getProveedor().getNombreEmpresa());
         dataListServ.add(promServi);
         
     }     
           return dataListServ;
      }
      
    public ArrayList verInfoCliente()throws SQLException, ClassNotFoundException {
        DataCliente clientes = new DataCliente();
        DatosClientes dataux = new DatosClientes();
        ArrayList<String> nickCli = new ArrayList();
        ResultSet rs = null;
      

        return dataux.verInfoReserva();
    }
}
