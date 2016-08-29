/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Ciudad;
import Logica.Cliente;
import Logica.DataCantidadReservasPromociones;
import Logica.DataCantidadReservasServicios;
import Logica.Pais;
import Logica.Promocion;
import Logica.Reserva;
import Logica.Servicio;
import Logica.Estado;
import Logica.Proveedor;
import Logica.cantidadReservasPromociones;
import Logica.cantidadReservasServicios;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author usuario
 */
public class DatosClientes {

    //private ConexionBD conexion;
    public DatosClientes() {
        //conexion = new ConexionBD();
    }

    public void insertar(String nickname, String nombre, String apellido, String email, String fechaNac) throws SQLException, ClassNotFoundException {
        Connection conn;

        ConexionBD conexion = new ConexionBD();

        conn = conexion.conectar();

        PreparedStatement pConsulta = conn.prepareStatement("insert into usuarios values(?, ?, ?, ?, ?, true)");

        pConsulta.setString(1, nickname);
        pConsulta.setString(2, nombre);
        pConsulta.setString(3, apellido);
        pConsulta.setString(4, email);
        pConsulta.setString(5, fechaNac);

        pConsulta.executeUpdate();

        //conexion.cerrar();
        conn.close();
    }

    public void agregarImagen(String nickname, String ruta) throws SQLException, ClassNotFoundException {
        Connection conn;

        ConexionBD conexion = new ConexionBD();

        conn = conexion.conectar();

        PreparedStatement pConsulta = conn.prepareStatement("insert into imagenesusuarios values(?, ?)");

        pConsulta.setString(1, ruta);
        pConsulta.setString(2, nickname);

        pConsulta.executeUpdate();

        //conexion.cerrar();
        conn.close();
    }

    public ArrayList verInfoReserva() throws SQLException, ClassNotFoundException {
        ArrayList reservas = new ArrayList();
        int indice = 0;
        Connection conn;

        ConexionBD conexion = new ConexionBD();

        conn = conexion.conectar();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("select numero from reservas order by numero");

        while (rs.next()) {
            //System.out.println("a");
            reservas.add(indice, rs.getString("numero"));
            indice++;
        }

        rs.close();
        //conexion.cerrar();
        conn.close();

        return reservas;

    }
    public ArrayList datosReserva ()throws SQLException, ClassNotFoundException {
        ArrayList<Reserva> reservas = new ArrayList();
         Connection conn;
         int indice = 0;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select numero,estado from reservas ");
        while (rs.next()) {
            Reserva res= new Reserva();
            res.setNumero(rs.getInt("numero"));
            res.setEstado(rs.getString("estado"));
            reservas.add(res);
            indice++;
        }

        rs.close();
      conn.close();
        return reservas;
    }
    public void updateEstadoReserva(int numero,String estado) throws SQLException, ClassNotFoundException{
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        PreparedStatement pConsulta = conn.prepareStatement("update reservas set estado=? where numero=? " );
        pConsulta.setString(1, estado);
        pConsulta.setInt(2, numero);
        pConsulta.executeUpdate();
    }
    public Reserva getReserva(String numeroRes) {
        Reserva dtaux = new Reserva();
        ArrayList<cantidadReservasPromociones> listProm = new ArrayList();
        ArrayList<cantidadReservasServicios> listServ = new ArrayList();
        Connection conn;

        ConexionBD conexion = new ConexionBD();
        try {
            conn = conexion.conectar();

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM reservas r ,usuarios u WHERE numero = " + numeroRes + " and r.nicknameCliente =u.nickname ");

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNickname(rs.getString("nicknameCliente"));
                dtaux.setCliente(c);
                dtaux.setNumero(rs.getInt("numero"));
                dtaux.setPrecio(rs.getInt("precio"));

                String fechaR = rs.getString("fecha");
                String[] partesFecha = fechaR.split("-");
                LocalDate fechaReserva = LocalDate.of(Integer.parseInt(partesFecha[0]), Integer.parseInt(partesFecha[1]), Integer.parseInt(partesFecha[2]));
                dtaux.setFecha(fechaReserva);
                dtaux.setEstado(rs.getString("estado"));

//           ResultSet rsCant = st.executeQuery("SELECT * FROM cantidadreservaspromociones cr,promociones p WHERE cr.nombrePromocion=p.nombre and numeroReserva="+numeroRes);
//           while(rsCant.next()){
//               Promocion prom = new Promocion();
//               prom.setDescuento(rsCant.getInt("descuento"));
//               prom.setNombre(rsCant.getString("nombrePromocion"));
//               prom.setPrecio(rsCant.getInt("precio"));
//               listProm.add(prom);
//               
//           }
//           dtaux.setReservaPromociones(listProm);
            }
            rs.close();
            //conexion.cerrar();
            conn.close();
        } catch (Exception e) {
        }
        return dtaux;
    }

    public ArrayList getReservasPromo(String numeroProm) {

        ArrayList<cantidadReservasPromociones> dtProm = new ArrayList();
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        try {
            conn = conexion.conectar();
            Statement st = conn.createStatement();
            ResultSet rsCant = st.executeQuery("SELECT * FROM cantidadreservaspromociones cr,promociones p WHERE cr.nombrePromocion=p.nombre and cr.nombreProveedor = p.nombreProveedor and numeroReserva=" + numeroProm);
            while (rsCant.next()) {
                cantidadReservasPromociones cantProm = new cantidadReservasPromociones();
                cantProm.setnombreP(rsCant.getString("nombrePromocion"));
                cantProm.setCantidad(rsCant.getInt("cantidad"));
                cantProm.setTotalL(rsCant.getInt("totalLinea"));
                String fechaR = rsCant.getString("fechaInicio");
                String[] partesFecha = fechaR.split("-");
                LocalDate fechaReserva = LocalDate.of(Integer.parseInt(partesFecha[0]), Integer.parseInt(partesFecha[1]), Integer.parseInt(partesFecha[2]));
                cantProm.setFechaInicio(fechaReserva);
                String fechaRf = rsCant.getString("fechaFin");
                String[] partesFechaf = fechaRf.split("-");
                LocalDate fechaReservaf = LocalDate.of(Integer.parseInt(partesFechaf[0]), Integer.parseInt(partesFechaf[1]), Integer.parseInt(partesFechaf[2]));
                cantProm.setFechaFin(fechaReservaf);
                Proveedor p = new Proveedor();
                p.setNombreEmpresa(rsCant.getString("nombreProveedor"));
                cantProm.setProveedor(p);

                dtProm.add(cantProm);

            }
            //dtaux.setReservaPromociones(listProm);

            rsCant.close();
            //conexion.cerrar();
            conn.close();
        } catch (Exception e) {
        }
        return dtProm;

    }

    public ArrayList getServiciosPromo(String numeroSer) {
        ArrayList<cantidadReservasServicios> dtSer = new ArrayList();
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        try {
            conn = conexion.conectar();
            Statement st = conn.createStatement();
            ResultSet rsCant = st.executeQuery("SELECT * FROM cantidadreservasservicios cs,servicios s WHERE cs.nombreServicio=s.nombre and cs.nombreProveedor = s.nombreProveedor and numeroReserva=" + numeroSer);

            while (rsCant.next()) {
                cantidadReservasServicios cantSer = new cantidadReservasServicios();
                cantSer.setNombreS(rsCant.getString("nombreServicio"));
                Proveedor p = new Proveedor();
                p.setNombreEmpresa(rsCant.getString("nombreProveedor"));
                cantSer.setProveedor(p);
                cantSer.setCantidad(rsCant.getInt("cantidad"));
                cantSer.setTotalLinea(rsCant.getInt("totalLinea"));
                String fechaR = rsCant.getString("fechaInicio");
                String[] partesFecha = fechaR.split("-");
                LocalDate fechaReserva = LocalDate.of(Integer.parseInt(partesFecha[0]), Integer.parseInt(partesFecha[1]), Integer.parseInt(partesFecha[2]));
                cantSer.setFechaInicio(fechaReserva);
                String fechaRf = rsCant.getString("fechaFin");
                String[] partesFechaf = fechaRf.split("-");
                LocalDate fechaReservaf = LocalDate.of(Integer.parseInt(partesFechaf[0]), Integer.parseInt(partesFechaf[1]), Integer.parseInt(partesFechaf[2]));
                cantSer.setFechaFin(fechaReservaf);

                dtSer.add(cantSer);
            }
            rsCant.close();
            //conexion.cerrar();
            conn.close();
        } catch (Exception e) {
        }
        return dtSer;
    }

    public ArrayList<Cliente> verInfoCliente() throws SQLException, ClassNotFoundException {
        ArrayList<Cliente> clientes = new ArrayList();
        int indice = 0;
        Connection conn;

        ConexionBD conexion = new ConexionBD();

        conn = conexion.conectar();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("select * from usuarios where cliente= true order by nickname");
        while (rs.next()) {
            //System.out.println("a");
            Cliente c = new Cliente();
            c.setNickname(rs.getString("nickname"));
            clientes.add(indice, c);
            indice++;
        }

        rs.close();
        //conexion.cerrar();
        conn.close();
        return clientes;
    }
    
    public ArrayList<Cliente> verInfoClienteBusqueda(String nickname) throws SQLException, ClassNotFoundException {
        ArrayList<Cliente> clientes = new ArrayList();
        int indice = 0;
        Connection conn;

        ConexionBD conexion = new ConexionBD();

        conn = conexion.conectar();

        PreparedStatement pConsulta = conn.prepareCall("select * from usuarios where cliente= true and nickname like ? order by nickname");
        
        pConsulta.setString(1, "%" + nickname + "%");
        
        ResultSet rs = pConsulta.executeQuery();
        
        while (rs.next()) {
            //System.out.println("a");
            Cliente c = new Cliente();
            c.setNickname(rs.getString("nickname"));
            clientes.add(indice, c);
            indice++;
        }

        rs.close();
        //conexion.cerrar();
        conn.close();
        return clientes;
    }
    
    public ArrayList<Cliente> selectAllObjetosClientes() throws SQLException, ClassNotFoundException{
        
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from usuarios u where cliente = true");
        
        while(rs.next()){
            //categorias.add(new Proveedor(rs.getString("nombre"), "", new ArrayList()));
            String fecha = rs.getString("fechaNacimiento");
            String[] datosFecha = fecha.split("-");
            clientes.add(new Cliente(rs.getString("nickname"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), LocalDate.of(Integer.parseInt(datosFecha[0]), Integer.parseInt(datosFecha[1]), Integer.parseInt(datosFecha[2])), "", new HashMap()));
        }
        
        rs.close();
        conn.close();
        
        return clientes;
        
    }
    
    public ArrayList<cantidadReservasPromociones> selectPromocionesReserva(int numero) throws SQLException, ClassNotFoundException{
        
        ArrayList<cantidadReservasPromociones> promociones = new ArrayList<cantidadReservasPromociones>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select * from cantidadreservaspromociones where numeroReserva = ?");
        
        pConsulta.setInt(1, numero);
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            String fechaInicio = rs.getString("fechaInicio");
            String[] datosFI  = fechaInicio.split("-");
            String fechaFin = rs.getString("fechaFin");
            String[] datosFF  = fechaFin.split("-");
            cantidadReservasPromociones crp = new cantidadReservasPromociones(rs.getInt("cantidad"), rs.getInt("totalLinea"), LocalDate.of(Integer.parseInt(datosFI[0]), Integer.parseInt(datosFI[1]), Integer.parseInt(datosFI[2])), LocalDate.of(Integer.parseInt(datosFF[0]), Integer.parseInt(datosFF[1]), Integer.parseInt(datosFF[2])), new Promocion(), new Proveedor());
            crp.setNombrePromocion(rs.getString("nombrePromocion"));
            crp.setNombreProveedor(rs.getString("nombreProveedor"));
            //System.out.println("****" + rs.getString("nombrePromocion") + "****");
            promociones.add(crp);
        }
        
        rs.close();
        conn.close();
        
        return promociones;
    }
    
    public ArrayList<cantidadReservasServicios> selectServiciosReserva(int numero) throws SQLException, ClassNotFoundException{
        
        ArrayList<cantidadReservasServicios> servicios = new ArrayList<cantidadReservasServicios>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select * from cantidadreservasservicios where numeroReserva = ?");
        
        pConsulta.setInt(1, numero);
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            String fechaInicio = rs.getString("fechaInicio");
            String[] datosFI  = fechaInicio.split("-");
            String fechaFin = rs.getString("fechaFin");
            String[] datosFF  = fechaFin.split("-");
            cantidadReservasServicios crs = new cantidadReservasServicios(rs.getInt("cantidad"), rs.getInt("totalLinea"), LocalDate.of(Integer.parseInt(datosFI[0]), Integer.parseInt(datosFI[1]), Integer.parseInt(datosFI[2])), LocalDate.of(Integer.parseInt(datosFF[0]), Integer.parseInt(datosFF[1]), Integer.parseInt(datosFF[2])), new Proveedor(), new Servicio());
            crs.setNombreProveedor(rs.getString("nombreProveedor"));
            crs.setNombreServicio(rs.getString("nombreServicio"));
            servicios.add(crs);
        }
        
        rs.close();
        conn.close();
        
        return servicios;
    }
    
    public ArrayList<Reserva> selectReservasCliente(Cliente c) throws SQLException, ClassNotFoundException{
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select * from reservas where nicknameCliente = ?");
        
        pConsulta.setString(1, c.getNickname());
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            String fecha = rs.getString("fecha");
            String[] datosFecha = fecha.split("-");
            String estado = rs.getString("estado");
            Estado estadoReserva = Estado.REGISTRADA;
            switch(estado){
                case "registrada":
                    estadoReserva = Estado.REGISTRADA;
                    break;
                case "cancelada":
                    estadoReserva = Estado.CANCELADA;
                    break;
                case "facturada":
                    estadoReserva = Estado.FACTURADA;
                    break;
                case "pagada":
                    estadoReserva = Estado.PAGADA;
                    break;
            }
            reservas.add(new Reserva(rs.getInt("numero"), LocalDate.of(Integer.parseInt(datosFecha[0]), Integer.parseInt(datosFecha[1]), Integer.parseInt(datosFecha[2])), rs.getInt("precio"), c, new ArrayList(), new ArrayList(), estadoReserva));
        }
        
        rs.close();
        conn.close();
        
        return reservas;
    }
    
    public Cliente seleccionarCliente(String nickname) throws SQLException, ClassNotFoundException{
         ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select * from usuarios u left join imagenesusuarios i on u.nickname=i.nickname where u.cliente=true and u.nickname=?");
        
        pConsulta.setString(1,nickname);
        
        ResultSet rs = pConsulta.executeQuery();
        
        Cliente c = new Cliente();
        HashMap<Integer,Reserva> reservas = new HashMap<Integer,Reserva>();
                
        while(rs.next()){
            
            String fecha = rs.getString("fechaNacimiento");
            String[] datosFecha = fecha.split("-");
            c=new Cliente(rs.getString("nickname"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), LocalDate.of(Integer.parseInt(datosFecha[0]), Integer.parseInt(datosFecha[1]), Integer.parseInt(datosFecha[2])), rs.getString("ruta"), new HashMap());
                        
        }
        
        c.setReservasCliente(reservas);
        
        return c;
        
    }
    public ArrayList<Reserva> reservasCliente(String nickname)throws SQLException, ClassNotFoundException{
         ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select * from reservas where nicknameCliente=? order by numero");
        
        pConsulta.setString(1,nickname);
        
        ResultSet rs = pConsulta.executeQuery();
        ArrayList<Reserva> listRes=new ArrayList<Reserva>();
        while(rs.next()){
            Reserva r =new Reserva();
            r.setNumero(rs.getInt("numero"));
            listRes.add(r);
        }
        return listRes;
    }
    
    
    public void deleteAllClientes(String s) throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        String[] sql = s.split(";");
        
        for(int i = 0; i < sql.length; i++){
            st.executeUpdate(sql[i]);
        }
        
        conn.close();
        
        
    }
    
    public void insertDatosClientesDePrueba(String s) throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        String[] sql = s.split(";");
        
        for(int i = 0; i < sql.length; i++){
            st.executeUpdate(sql[i]);
        }
        
        conn.close();
        
    }
}
