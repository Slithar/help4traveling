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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author usuario
 */
public class ControladorClientes implements IControladorClientes {

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
        cliente.insertar(nickname, nombre, apellido, mail, FechaNac.toString());
        if (rutaImagen != "perfiles/perfil.PNG") {
            cliente.agregarImagen(nickname, rutaImagen);
        }
    }

    @Override
    public ArrayList<DataCliente> getClientes() throws SQLException, ClassNotFoundException {
        ArrayList <DataCliente> resultado = new ArrayList();
        
        DatosClientes cliente = new DatosClientes();
        ArrayList <Cliente> arrayClientes = cliente.selectAllClientes();
        
        for(int i=0; i< arrayClientes.size(); i++){
            DataCliente cli = new DataCliente();
            cli.setNickname(arrayClientes.get(i).getNickname());
            cli.setNombre(arrayClientes.get(i).getNombre());
            cli.setApellido(arrayClientes.get(i).getApellido());
            cli.setEmail(arrayClientes.get(i).getEmail());
            cli.setFechaNac(LocalDate.parse(String.valueOf(arrayClientes.get(i).getFechaNac())));
            
            resultado.add(cli);
        }
        
        return resultado;
    }
    
    @Override
    public ArrayList verInfoReserva() throws SQLException, ClassNotFoundException {
        //solo obtiene los numeros de la reserva
        DatosClientes dataux = new DatosClientes();
        return dataux.verInfoReserva();
    }
  
    @Override
    public DataReserva getReserva(String numeroRes) throws SQLException, ClassNotFoundException{
        DataReserva dtAux =new  DataReserva ();
        DatosClientes datCli = new DatosClientes();
     Reserva res= datCli.getReserva(numeroRes);
     dtAux.setNumero(res.getNumero());
     dtAux.setCliente(res.getCliente().getNickname());
     dtAux.setPrecio(res.getPrecio());
     dtAux.setFecha(res.getFecha());
     dtAux.setEstado(res.getEstado().toString());
     ArrayList<DatacantidadReservasServicios> todosDataServ = new ArrayList();
     ArrayList<DatacantidadReservasPromociones> todosDataPromo = new ArrayList();
    
     DatacantidadReservasServicios DataCantResServ = new DatacantidadReservasServicios();
     DatacantidadReservasPromociones DataCantResProm = new DatacantidadReservasPromociones();
     
     // paso de objeto "cantidadReservasServicios " a datatype "DatacantidadREsservasServicios"
     for(int i = 0; i < res.getServiciosReserva().size(); i++){
         DataCantResServ.setNombreServicio(res.getServiciosReserva().get(i).getNombreS());
         DataCantResServ.setNombreProveedor(res.getServiciosReserva().get(i).getProveedor().getNombreEmpresa());
         DataCantResServ.setCantidad(res.getServiciosReserva().get(i).getCantidad());
         DataCantResServ.setTotalLinea(res.getServiciosReserva().get(i).getTotalLinea());
         DataCantResServ.setFechaInicio(res.getServiciosReserva().get(i).getFechaInicio());
         DataCantResServ.setFechaFinal(res.getServiciosReserva().get(i).getFechaFin());
         todosDataServ.add(DataCantResServ);
     }
     
     for(int i = 0; i < res.getReservacantPromociones().size(); i++){
         DataCantResProm.setNombrePromocion(res.getReservacantPromociones().get(i).getNombreP());
         DataCantResProm.setCantidad(res.getReservacantPromociones().get(i).getCantidad());
         DataCantResProm.setTotalLinea(res.getReservacantPromociones().get(i).getTotalL());
         DataCantResProm.setFechaInicio(res.getReservacantPromociones().get(i).getFechaInicio());
         DataCantResProm.setFechaFinal(res.getReservacantPromociones().get(i).getFechaFin());
         todosDataPromo.add(DataCantResProm);
     }
     dtAux.setReservaPromociones(todosDataPromo);
     dtAux.setServiciosReserva(todosDataServ);
     
     return dtAux;
        
    }
    @Override
      public ArrayList getReservasPromo(String numeroProm){
          DatosClientes dataux = new DatosClientes();
        return dataux.getReservasPromo(numeroProm);
      }
    @Override
       public ArrayList getReservasServ(String numeroServ){
          DatosClientes dataux = new DatosClientes();
        return dataux.getServiciosPromo(numeroServ);
      }
      
    public ArrayList verInfoCliente()throws SQLException, ClassNotFoundException {
        DataCliente clientes = new DataCliente();
        DatosClientes dataux = new DatosClientes();
        ArrayList<String> nickCli = new ArrayList();
        ResultSet rs = null;
      

        return dataux.verInfoReserva();
    }
    
    @Override
    //public void realizarReserva(DataReserva dataReserva) throws SQLException, ClassNotFoundException{
    public int realizarReserva(LocalDate Fecha, int precio, String estado, String nickCliente) throws SQLException, ClassNotFoundException{
    
        DatosReservas res = new DatosReservas();
        int numRes = 0;
        Reserva reserva = new Reserva();
        Cliente cliente = new Cliente();
        cliente.setNickname(nickCliente);
        reserva.setCliente(cliente);
        reserva.setEstado(estado);
        reserva.setFecha(Fecha);
        reserva.setPrecio(precio);
        numRes = res.insertarReserva(reserva.getFecha().toString(), reserva.getPrecio(), reserva.getEstado().toString(), reserva.getCliente().getNickname());
        
        return numRes;
        
        
    }
    @Override
    public void datosAsociadosReserva(int numReserva, TableModel modelo)throws SQLException, ClassNotFoundException{
        System.out.println(numReserva + "dentro");
        DatosReservas res = new DatosReservas();
     //Tipo", "Nombre","proveedor" ,  "Cantidad", "Precio Unitario","Total", "Inicio", "Fin"

        for(int i = 0; i< modelo.getRowCount(); i++){
            if(modelo.getValueAt(i, 0) == "Servicio"){
                
                    res.insertarServicioReserva(numReserva, modelo.getValueAt(i, 1).toString(), modelo.getValueAt(i, 2).toString(), Integer.parseInt(modelo.getValueAt(i, 3).toString()), Integer.parseInt(modelo.getValueAt(i, 5).toString()), modelo.getValueAt(i, 6).toString(), modelo.getValueAt(i, 7).toString());
            }
            else{
                   res.insertarPromocionReserva(numReserva, modelo.getValueAt(i, 1).toString(), modelo.getValueAt(i, 2).toString(), Integer.parseInt(modelo.getValueAt(i, 3).toString()), Integer.parseInt(modelo.getValueAt(i, 5).toString()), modelo.getValueAt(i, 6).toString(), modelo.getValueAt(i, 7).toString());
           }
        }
        
    }

    @Override
    public ArrayList<DataReserva> getAllReservas() throws SQLException, ClassNotFoundException {
        ArrayList<DataReserva> AlldataReservas = new ArrayList();
        
        ArrayList<Reserva> AllReservas = new ArrayList();
        DatosReservas datosreservas = new DatosReservas();
        AllReservas = datosreservas.getAllReservas();
        for(int i = 0; i < AllReservas.size(); i++){
            DataReserva dataReserva = new DataReserva();
            dataReserva.setNumero(AllReservas.get(i).getNumero());
            dataReserva.setFecha(AllReservas.get(i).getFecha());
            dataReserva.setPrecio(AllReservas.get(i).getPrecio());
            dataReserva.setEstado(AllReservas.get(i).getEstado().toString());
            dataReserva.setCliente(AllReservas.get(i).getCliente().getNickname());
            AlldataReservas.add(dataReserva);
        }
        return AlldataReservas;
    }
}
