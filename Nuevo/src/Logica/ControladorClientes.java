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
    private HashMap<String, Proveedor> ListaProveedores = new HashMap<String, Proveedor>();
    private HashMap<String, Promocion> ListaPromociones = new HashMap<String, Promocion>();
    
    public ControladorClientes() {

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
    
    
    
    @Override
    public void actualizarClientes() throws SQLException, ClassNotFoundException {
        ListaClientes = new HashMap<String, Cliente>();
        DatosClientes clientes = new DatosClientes();
        DatosUsuarios usuarios = new DatosUsuarios();
        ArrayList<Cliente> cli = clientes.selectAllObjetosClientes();
        for(int i = 0; i < cli.size(); i++){
            System.out.println("CLIENTE: " + cli.get(i).getNickname());
            cli.get(i).setImagenUsuario(usuarios.selectImagenPerfil(cli.get(i)));
            HashMap<Integer, Reserva> reservas = new HashMap<Integer, Reserva>();
            ArrayList<Reserva> resultadoReservas = clientes.selectReservasCliente(cli.get(i));
            for(int j = 0; j < resultadoReservas.size(); j++){
                System.out.println(" --" + resultadoReservas.get(j).getNumero());
                reservas.put(resultadoReservas.get(j).getNumero(), resultadoReservas.get(j));
            }
            cli.get(i).setReservasCliente(reservas);
            //System.out.println("***** " + cli.get(i).getNickname() + " *****");
            ListaClientes.put(cli.get(i).getNickname(), cli.get(i));
            //cli.get(i).setReservasCliente();
        }
        
        //ACÁ VOY A ASOCIAR CADA RESERVA DE CLIENTE A CANTIDAD_RESERVA_PROMOCIONES O CANTIDAD_RESERVA_SERVICIOS
        
        Iterator it = ListaClientes.entrySet().iterator();
        
        while(it.hasNext()){
            Map.Entry c = (Map.Entry) it.next();
            Cliente cliente = (Cliente) c.getValue();
            
            Iterator itReserva = cliente.getReservasCliente().entrySet().iterator();
            
            System.out.println("CLIENTE: "+ cliente.getNickname());
            
            while(itReserva.hasNext()){
                Map.Entry re = (Map.Entry) itReserva.next();
                Reserva r = (Reserva) re.getValue();
                System.out.println(" - RESERVA: " + r.getNumero());
                ArrayList<cantidadReservasPromociones> crp = clientes.selectPromocionesReserva(r.getNumero());
                if(crp.size() > 0){
                    for(int i = 0; i < crp.size(); i++){
                        crp.get(i).setProveedor((Proveedor) ListaProveedores.get(crp.get(i).getNombreProveedor()));
                        System.out.println("  ** PROVEEDOR PROMOCIÓN: " + crp.get(i).getProveedor().getNombreEmpresa());
                        crp.get(i).setPromocion((Promocion) ListaPromociones.get(crp.get(i).getNombrePromocion()));
                        System.out.println("  ** PROMOCION: " + crp.get(i).getPromocion().getNombre());
                    }
                    r.setReservacantPromociones(crp);
                }
                
                
                ArrayList<cantidadReservasServicios> crs = clientes.selectServiciosReserva(r.getNumero());
                
                if(crs.size() > 0){
                    for(int i = 0; i < crs.size(); i++){
                        
                        crs.get(i).setProveedor((Proveedor) ListaProveedores.get(crs.get(i).getNombreProveedor()));
                        System.out.println("  ** PROVEEDOR SERVICIO: " + crs.get(i).getProveedor().getNombreEmpresa());
                        HashMap<String, Servicio> servs = crs.get(i).getProveedor().getServicios();
                        crs.get(i).setServicio(servs.get(crs.get(i).getNombreServicio()));
                        System.out.println("  ** SERVICIO: " + crs.get(i).getServicio().getNombreServicio());
                    }

                    r.setServiciosReserva(crs);
                }
                
            }
        }
    }

    @Override
    public int getCantClientes() {
        return ListaClientes.size();
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
        Cliente c = new Cliente(nickname, nombre, apellido, mail, FechaNac, rutaImagen, new HashMap<Integer, Reserva>());
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
     /*if(res.getReservacantPromociones().size() > 0){
         for(int i=0;i<res.getReservacantPromociones().size();i++){
            cantidadReservasPromociones promAux= res.getReservacantPromociones().get(i);
            DataCantidadReservasPromociones dataProm=new DataCantidadReservasPromociones(promAux.getCantidad(),promAux.getFechaInicio(),promAux.getFechaFin(),promAux.getPromocion().getNombre(), promAux.getProveedor().getNombreEmpresa());
            listProm.add(dataProm);


         }
         for(int i=0;i<res.getServiciosReserva().size();i++){
             cantidadReservasServicios promServ =res.getServiciosReserva().get(i);
             DataCantidadReservasServicios promServi = new DataCantidadReservasServicios(promServ.getCantidad(),promServ.getFechaInicio(),promServ.getFechaFin(),0,promServ.getNombreS(),promServ.getProveedor().getNombreEmpresa());
             listServ.add(promServi);

         }
     }*/
          
     return dtAux;
    //return new DataReserva();
        
    }
    @Override
      public ArrayList getReservasPromo(String numeroProm){
        DatosClientes dataux = new DatosClientes();
        ArrayList<cantidadReservasPromociones> listProm = new ArrayList();
        listProm = dataux.getReservasPromo(numeroProm);
        
        ArrayList<DataCantidadReservasPromociones> dataListProm = new ArrayList<DataCantidadReservasPromociones>();
        for(int i=0;i<listProm.size();i++){
            cantidadReservasPromociones promAux= (cantidadReservasPromociones) listProm.get(i);
            DataCantidadReservasPromociones dataProm=new DataCantidadReservasPromociones(promAux.getCantidad(), promAux.getTotalLinea(), promAux.getFechaInicio(),promAux.getFechaFin(),promAux.getPromocion().getNombre(), promAux.getProveedor().getNombreEmpresa());
            dataListProm.add(dataProm);
        }
        
        return dataListProm;
        //return new ArrayList();
      }
      
    @Override
       public ArrayList getReservasServ(String numeroServ){
          DatosClientes dataux = new DatosClientes();
          ArrayList <cantidadReservasServicios> listServ= new ArrayList();
          listServ = dataux.getServiciosPromo(numeroServ);
          
          ArrayList<DataCantidadReservasServicios> dataListServ = new ArrayList<DataCantidadReservasServicios>();
           for(int i=0;i<listServ.size();i++){
         cantidadReservasServicios promServ = listServ.get(i);
         DataCantidadReservasServicios promServi = new DataCantidadReservasServicios(promServ.getCantidad(), promServ.getTotalLinea(), promServ.getFechaInicio(),promServ.getFechaFin(), 0, promServ.getNombreS(), promServ.getProveedor().getNombreEmpresa());
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
    
    public ArrayList<DataCliente> getClientes()throws SQLException, ClassNotFoundException{
        ArrayList<DataCliente> listResult = new ArrayList ();
        DatosClientes datCli = new DatosClientes();
        DatosUsuarios datosU =new DatosUsuarios();
        
        ArrayList<Cliente> listClientes =datCli.selectAllObjetosClientes();
        for(int i=0;i<listClientes.size();i++){
            Imagen imagenPerf = datosU.selectImagenPerfil(listClientes.get(i));
            listResult.add(new DataCliente(listClientes.get(i).getNickname(),listClientes.get(i).getNombre(),listClientes.get(i).getApellido(),listClientes.get(i).getEmail(),listClientes.get(i).getFechaNac(),imagenPerf.getPath()));
        }
        return listResult;
    }
    
    
    
}
