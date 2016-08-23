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

    public ArrayList verInfoReserva() throws SQLException, ClassNotFoundException {
        //solo obtiene los numeros de la reserva
        DatosClientes dataux = new DatosClientes();
        return dataux.verInfoReserva();
    }
  
    public DataReserva getReserva(String numeroRes){
        DataReserva dtAux =new  DataReserva ();
        DatosClientes datCli = new DatosClientes();
     Reserva res= datCli.getReserva(numeroRes);
     dtAux.setNumero(res.getNumero());
     dtAux.setCliente(res.getCliente());
     dtAux.setPrecio(res.getPrecio());
     dtAux.setFecha(res.getFecha());
     dtAux.setEstado(res.getEstado());
     dtAux.setReservaPromociones(res.getReservacantPromociones());
     dtAux.setServiciosReserva(res.getServiciosReserva());
     
     return dtAux;
        
    }
      public ArrayList getReservasPromo(String numeroProm){
          DatosClientes dataux = new DatosClientes();
        return dataux.getReservasPromo(numeroProm);
      }
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
}
