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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    /*
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
    }*/
    @Override
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
        ArrayList<DataCantidadReservasPromociones> listProm = new ArrayList();
        ArrayList<DataCantidadReservasServicios> listServ = new ArrayList();
        Reserva res= datCli.getReserva(numeroRes);
     dtAux.setNumero(res.getNumero());
     dtAux.setCliente(res.getCliente().getNickname());
     dtAux.setPrecio(res.getPrecio());
     dtAux.setFecha(res.getFecha());
     dtAux.setEstado(res.getEstado().toString());
     ArrayList<DataCantidadReservasServicios> todosDataServ = new ArrayList();
     ArrayList<DataCantidadReservasPromociones> todosDataPromo = new ArrayList();
    
     DataCantidadReservasServicios DataCantResServ = new DataCantidadReservasServicios();
     DataCantidadReservasPromociones DataCantResProm = new DataCantidadReservasPromociones();
     
     // paso de objeto "cantidadReservasServicios " a datatype "DatacantidadREsservasServicios"
     for(int i = 0; i < res.getServiciosReserva().size(); i++){
         DataCantResServ.setServicio(res.getServiciosReserva().get(i).getNombreS());
         DataCantResServ.setProveedor(res.getServiciosReserva().get(i).getProveedor().getNombreEmpresa());
         DataCantResServ.setCantidad(res.getServiciosReserva().get(i).getCantidad());
         DataCantResServ.setTotalLinea(res.getServiciosReserva().get(i).getTotalLinea());
         DataCantResServ.setFechaInicio(res.getServiciosReserva().get(i).getFechaInicio());
         DataCantResServ.setFechaFin(res.getServiciosReserva().get(i).getFechaFin());
         todosDataServ.add(DataCantResServ);
     }
     
     for(int i = 0; i < res.getReservacantPromociones().size(); i++){
         DataCantResProm.setPromocion(res.getReservacantPromociones().get(i).getNombreP());
         DataCantResProm.setCantidad(res.getReservacantPromociones().get(i).getCantidad());
         DataCantResProm.setTotalLinea(res.getReservacantPromociones().get(i).getTotalL());
         DataCantResProm.setFechaInicio(res.getReservacantPromociones().get(i).getFechaInicio());
         DataCantResProm.setFechaFin(res.getReservacantPromociones().get(i).getFechaFin());
         todosDataPromo.add(DataCantResProm);
     }
     dtAux.setReservaPromociones(todosDataPromo);
     dtAux.setServiciosReserva(todosDataServ);
     
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
    
    

    @Override
    public void deleteAllClientes() throws SQLException, ClassNotFoundException {
        DatosClientes dc = new DatosClientes();
        dc.deleteAllClientes("delete from imagenesusuarios where ruta <> \"\";\n" +
                        "delete from proveedores where nombreEmpresa <> \"\";\n" +
                        "delete from reservas where numero > 0;\n" +
                        "delete from usuarios where nickname <> \"\";\n" +
                        "\n" +
                        "ALTER TABLE reservas AUTO_INCREMENT=1;");
    }

    @Override
    public void insertDatosClientesDePrueba() throws SQLException, ClassNotFoundException {
        DatosClientes dc = new DatosClientes();
        dc.insertDatosClientesDePrueba("insert into reservas(fecha, precio, estado, nicknameCliente) values ('2016-1-1', 1100, 'FACTURADA', 'oWood');\n" +
                        "insert into reservas(fecha, precio, estado, nicknameCliente) values ('2016-1-1', 3050, 'CANCELADA', 'eWatson');\n" +
                        "insert into reservas(fecha, precio, estado, nicknameCliente) values ('2016-3-5', 135, 'PAGADA', 'BruceS');\n" +
                        "insert into reservas(fecha, precio, estado, nicknameCliente) values ('2016-5-8', 600, 'PAGADA', 'JeffW');\n" +
                        "insert into reservas(fecha, precio, estado, nicknameCliente) values ('2016-8-7', 200, 'REGISTRADA', 'oWood');\n" +
                        "insert into reservas(fecha, precio, estado, nicknameCliente) values ('2016-8-7', 542, 'REGISTRADA', 'eWatson');\n" +
                        "insert into reservas(fecha, precio, estado, nicknameCliente) values ('2016-8-7', 1700, 'REGISTRADA', 'BruceS');\n" +
                        "insert into cantidadreservaspromociones values(3, 'Sudamérica-Casas', 'Segundo Hogar', 1, 135, '2016-3-5', '2016-4-2', 135);\n" +
                        "insert into cantidadreservaspromociones values(6, 'Miami-Viaje', 'Segundo Hogar', 1, 462, '2016-8-7', '2016-8-14', 462);\n" +
                        "insert into cantidadreservasservicios values(1, 'Euro-Vuelo-S', 'Iberia', 1, 1100, '2016-1-1', '2016-1-1', 1100);\n" +
                        "insert into cantidadreservasservicios values(2, 'Euro-Vuelo-S', 'Iberia', 2, 2200, '2016-1-1', '2016-1-1', 1100);\n" +
                        "insert into cantidadreservasservicios values(2, 'Euro-Vuelo-LC', 'Iberia', 1, 850, '2016-1-1', '2016-1-1', 850);\n" +
                        "insert into cantidadreservasservicios values(4, 'Euro-Car-2', 'EuropCar', 1, 300, '2016-5-8', '2016-5-12', 300);\n" +
                        "insert into cantidadreservasservicios values(4, 'Euro-Car-3', 'EuropCar', 1, 300, '2016-5-8', '2016-5-12', 300);\n" +
                        "insert into cantidadreservasservicios values(5, 'Air-France-FC', 'AirFrance', 2, 200, '2016-8-7', '2016-8-10', 100);\n" +
                        "insert into cantidadreservasservicios values(6, 'Casa para p4 BsAs', 'Segundo Hogar', 1, 80, '2016-8-14', '2016-8-21', 80);\n" +
                        "insert into cantidadreservasservicios values(7, 'Euro-Vuelo-LC', 'Iberia', 2, 1700, '2016-8-7', '2016-8-7', 850);");
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
        //System.out.println(numReserva + "dentro");
        DatosReservas res = new DatosReservas();
     //Tipo", "Nombre","proveedor" ,  "Cantidad", "Precio Unitario","Total", "Inicio", "Fin"

        for(int i = 0; i< modelo.getRowCount(); i++){
            if(modelo.getValueAt(i, 0) == "SERVICIO"){
                    
                    Servicio s = new Servicio();
                    s.setNombreServicio(modelo.getValueAt(i, 1).toString());
                    Proveedor p = new Proveedor();
                    p.setNombreEmpresa(modelo.getValueAt(i, 2).toString());
                    String fechaInicio = modelo.getValueAt(i, 6).toString();
                    String[] datosFI = fechaInicio.split("/");
                    LocalDate fInicio = LocalDate.of(Integer.parseInt(datosFI[2]), Integer.parseInt(datosFI[1]), Integer.parseInt(datosFI[0]));
                    String fechaFin = modelo.getValueAt(i, 7).toString();
                    String[] datosFF = fechaFin.split("/");
                    LocalDate fFin = LocalDate.of(Integer.parseInt(datosFF[2]), Integer.parseInt(datosFF[1]), Integer.parseInt(datosFF[0]));
                    cantidadReservasServicios crs = new cantidadReservasServicios(Integer.parseInt(modelo.getValueAt(i, 3).toString()), Integer.parseInt(modelo.getValueAt(i, 5).toString()), fInicio, fFin, p, s);
                    int precioUnitario = crs.getTotalLinea() / crs.getCantidad();
                    res.insertarServicioReserva(numReserva, crs.getServicio().getNombreServicio(), crs.getProveedor().getNombreEmpresa(), crs.getCantidad(), crs.getTotalLinea(), crs.getFechaInicio().toString(), crs.getFechaFin().toString(), precioUnitario);
                    //res.insertarServicioReserva(numReserva, modelo.getValueAt(i, 1).toString(), modelo.getValueAt(i, 2).toString(), , , , modelo.getValueAt(i, 7).toString(), Integer.parseInt(modelo.getValueAt(i, 4).toString()));
            }
            else{   
                    Promocion prom = new Promocion();
                    prom.setNombre(modelo.getValueAt(i, 1).toString());
                    Proveedor p = new Proveedor();
                    p.setNombreEmpresa(modelo.getValueAt(i, 2).toString());
                    String fechaInicio = modelo.getValueAt(i, 6).toString();
                    String[] datosFI = fechaInicio.split("/");
                    LocalDate fInicio = LocalDate.of(Integer.parseInt(datosFI[2]), Integer.parseInt(datosFI[1]), Integer.parseInt(datosFI[0]));
                    String fechaFin = modelo.getValueAt(i, 7).toString();
                    String[] datosFF = fechaFin.split("/");
                    LocalDate fFin = LocalDate.of(Integer.parseInt(datosFF[2]), Integer.parseInt(datosFF[1]), Integer.parseInt(datosFF[0]));
                    cantidadReservasPromociones crp = new cantidadReservasPromociones(Integer.parseInt(modelo.getValueAt(i, 3).toString()), Integer.parseInt(modelo.getValueAt(i, 5).toString()), fInicio, fFin, prom, p);
                    int precioUnitario = crp.getTotalLinea() / crp.getCantidad();
                    res.insertarPromocionReserva(numReserva, crp.getPromocion().getNombre(), crp.getProveedor().getNombreEmpresa(), crp.getCantidad(), crp.getTotalLinea(), crp.getFechaInicio().toString(), crp.getFechaFin().toString(), precioUnitario);
                   //res.insertarPromocionReserva(numReserva, modelo.getValueAt(i, 1).toString(), modelo.getValueAt(i, 2).toString(), Integer.parseInt(modelo.getValueAt(i, 3).toString()), Integer.parseInt(modelo.getValueAt(i, 5).toString()), modelo.getValueAt(i, 6).toString(), modelo.getValueAt(i, 7).toString(), Integer.parseInt(modelo.getValueAt(i, 4).toString()));
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
    
    
    @Override
    public void deleteReserva(int numReserva) throws SQLException, ClassNotFoundException {
        DatosReservas datosreservas = new DatosReservas();
        datosreservas.deleteCantResPromo(numReserva);
        datosreservas.deleteCantResServ(numReserva);
        datosreservas.deleteReservas(numReserva);
    }
}
