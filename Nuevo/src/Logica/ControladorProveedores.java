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
import java.util.logging.*;

import javax.swing.*;

/**
 *
 * @author usuario
 */
public class ControladorProveedores implements IControladorProveedores{
    
    private HashMap<String, Categoria> ListaCategorias = new HashMap<String, Categoria>();
    private HashMap<String, Proveedor> ListaProveedores;
    private HashMap<String, Ciudad> ListaCiudades;
    
    public ControladorProveedores(){
    
    }

    public HashMap<String, Proveedor> getListaProveedores() {
        return ListaProveedores;
    }

    public void setListaProveedores(HashMap<String, Proveedor> ListaProveedores) {
        this.ListaProveedores = ListaProveedores;
    }

    public HashMap<String, Categoria> getListaCategorias() {
        return ListaCategorias;
    }

    public void setListaCategorias(HashMap<String, Categoria> ListaCategorias) {
        this.ListaCategorias = ListaCategorias;
    }
    
    
    
    @Override
    public void actualizarProveedores() throws SQLException, ClassNotFoundException {
        //JOptionPane.showMessageDialog(null, ListaCategorias.size());
        //System.out.println("**** " + ListaCategorias.size() + " ****");
        DatosProveedores proveedores = new DatosProveedores();
        DatosServicios servicios = new DatosServicios();
        DatosUsuarios usuarios = new DatosUsuarios();
        ListaProveedores = new HashMap<String, Proveedor>();
        
        ArrayList<Proveedor> provs = proveedores.selectAllObjetosProveedores();
        
        for(int i = 0; i < provs.size(); i++){
            provs.get(i).setImagenesUsuario(usuarios.selectImagenesPerfil((Proveedor) provs.get(i)));
            ListaProveedores.put(provs.get(i).getNombreEmpresa(), provs.get(i));
        }
        
        Iterator it = ListaProveedores.entrySet().iterator();
        
        while(it.hasNext()){
            /*
            Map.Entry cat = (Map.Entry) it.next();
            System.out.println("* " + cat.getKey());
            ArrayList<Categoria> catHijas = categorias.selectCategoriasHijas(String.valueOf(cat.getKey()));
            Categoria c = (Categoria) cat.getValue();
            c.setCategoriasHijas(catHijas);
            for(int i = 0; i < c.getCategoriasHijas().size(); i++){
                System.out.println("-- " + c.getCategoriasHijas().get(i).getNombre());
            }
            */
            
            Map.Entry prov = (Map.Entry) it.next();
            Proveedor pr = (Proveedor) prov.getValue();
            ArrayList<Servicio> serviciosDelProveedor = proveedores.selectServiciosPorProveedor(pr);
            //System.out.println("PROVEEDOR: " + pr.getNombreEmpresa());
            HashMap<String, Servicio> servs = new HashMap<String, Servicio>();
            for(int i = 0; i < serviciosDelProveedor.size(); i++){
                //System.out.println(" *" + serviciosDelProveedor.get(i).getNombreServicio());
                serviciosDelProveedor.get(i).setOrigen(servicios.getCiudadOrigen(serviciosDelProveedor.get(i).getNombreServicio(), serviciosDelProveedor.get(i).getProveedorServicio().getNombreEmpresa()));
                serviciosDelProveedor.get(i).setDestino(servicios.getCiudadDestino(serviciosDelProveedor.get(i).getNombreServicio(), serviciosDelProveedor.get(i).getProveedorServicio().getNombreEmpresa()));
                serviciosDelProveedor.get(i).setImagenesServicio(servicios.getImagenes(serviciosDelProveedor.get(i).getNombreServicio(), serviciosDelProveedor.get(i).getProveedorServicio().getNombreEmpresa()));
                ArrayList<Categoria> categorias = servicios.selectCategoriasDeServicio(serviciosDelProveedor.get(i));
                ArrayList<Categoria> categoriasServ = new ArrayList<Categoria>();
                for(int j = 0; j < categorias.size(); j++){
                    Categoria c = (Categoria) ListaCategorias.get(categorias.get(j).getNombre());
                    //System.out.println(" --" + c.getNombre());
                    categoriasServ.add((Categoria) ListaCategorias.get(categorias.get(j).getNombre()));
                }
                serviciosDelProveedor.get(i).setCategoriasServicio(categoriasServ);
                servs.put(serviciosDelProveedor.get(i).getNombreServicio(), serviciosDelProveedor.get(i));
                //System.out.println(" -- " + serviciosDelProveedor.get(i).getNombreServicio());
            }
            pr.setServicios(servs);
            
        }
    }

    @Override
    public int getCantProveedores() {
        return ListaProveedores.size();
    }
    
    @Override
    public void actualizarCiudades() throws SQLException, ClassNotFoundException {
        DatosCiudades ciudades = new DatosCiudades();
        ListaCiudades = new HashMap<String, Ciudad>();
        
        ArrayList<Ciudad> ciudadesResultado = ciudades.selectAllCiudades();
        
        for(int i = 0; i < ciudadesResultado.size(); i++){
            ListaCiudades.put(ciudadesResultado.get(i).getNombre(), ciudadesResultado.get(i));
        }
    }

    @Override
    public int getCantCiudades() {
        return ListaCiudades.size();
    }
    
    @Override
    public boolean existeNickname(String nickname) throws SQLException, ClassNotFoundException{
        
        Proveedor p = new Proveedor();
        p.setNickname(nickname);
        
        DatosUsuarios proveedor = new DatosUsuarios();
        if(proveedor.selectCountUsuarios(p.getNickname()) == 0)
            return false;
        else
            return true;              
    }
    
    @Override
    public boolean correoValido(String correo){
        Proveedor p = new Proveedor();
        p.setEmail(correo);
        
        return p.correoValido();
    }
    
    @Override
    public boolean existeNombreEmpresa(String nombreEmpresa) throws SQLException, ClassNotFoundException{
        Proveedor p = new Proveedor();        
        p.setNombreEmpresa(nombreEmpresa);
        
        DatosProveedores proveedor = new DatosProveedores();
        if(proveedor.selectCountNombreEmpresa(p.getNombreEmpresa()) == 0)
            return false;
        else
            return true;
    }
    
    
    @Override
    public boolean copiarPerfil(String nickname, ArrayList<String> rutaImagen) throws IOException{
        Proveedor p = new Proveedor();
        p.setNickname(nickname);
        
        ArrayList<Imagen> imagenes = new ArrayList<Imagen>();
        
        for(int i = 0; i < rutaImagen.size(); i++){
            imagenes.add(new Imagen(rutaImagen.get(i), p));
            //String ruta = rutaImagen.get(i);
            p.setImagenesUsuario(imagenes);
        }
        
        try{
            p.copiarPerfil();
            return true;
        }
        catch(IOException ex){
            return false;
        }       
    }
    
    /*@Override
    public boolean existeNombreEmpresa(String nombreEmpresa){
        
        
        //return p.
    }*/
    
    @Override
    public void agregarProveedor(String nickname, String nombre, String apellido, String correo, LocalDate fechaNac, ArrayList<String> rutaImagen, String empresa, String sitioWeb, HashMap<String, Servicio> servicios) throws SQLException, ClassNotFoundException{
        //System.out.println("1");
        Proveedor p = new Proveedor(nickname, nombre, apellido, correo, fechaNac, rutaImagen, empresa, sitioWeb, servicios);
        //System.out.println("2");
        DatosProveedores proveedor = new DatosProveedores();
        //System.out.println("3");
        proveedor.insertar(p.getNickname(), p.getNombre(), p.getApellido(), p.getEmail(), p.getFechaNac().toString());
        //System.out.println("4");
        proveedor.agregarDatosProveedor(p.getNickname(), p.getNombreEmpresa(), p.getLink());
        //System.out.println("5");
        if(rutaImagen.size() > 0){
            ArrayList<Imagen> imagenes = p.getImagenesUsuario();
            //System.out.println("Tamaño: " + imagenes.size());
            for(int i = 0; i < imagenes.size(); i++){
                if(imagenes.get(i).getPath() != "perfiles/perfil.PNG"){
                    proveedor.agregarImagen(p.getNickname(), imagenes.get(i).getPath());
                }
            } 
        }
        
        
        
        //System.out.println("6");
    }
    
    @Override
    public ArrayList<DataCiudad> getCiudades() throws SQLException, ClassNotFoundException{
        DatosCiudades ciudades = new DatosCiudades();
        
        ArrayList<Ciudad> arrayCiudades = ciudades.selectAllCiudades();
        ArrayList<DataCiudad> resultado = new ArrayList();
        
        for(int i = 0; i < arrayCiudades.size(); i++){
            resultado.add(i, new DataCiudad(arrayCiudades.get(i).getNombre(), arrayCiudades.get(i).getPais().getNombre()));
        }
        
        return resultado;
        
    }
    
    @Override
    public ArrayList<DataProveedor> getProveedores() throws SQLException, ClassNotFoundException{
        DatosProveedores proveedores = new DatosProveedores();
        
        ArrayList<Proveedor> arrayProveedores = proveedores.selectAllProveedores();
        ArrayList<DataProveedor> resultado = new ArrayList();
        
        for(int i = 0; i < arrayProveedores.size(); i++){
            String nombreEmpresa = arrayProveedores.get(i).getNombreEmpresa();
            DataProveedor dp = new DataProveedor();
            dp.setNombreEmpresa(nombreEmpresa);
            resultado.add(dp);
        }
        
        return resultado;
    }
    
    @Override
    public boolean existeNombreServicio(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        
        Servicio s = new Servicio();
        Proveedor p = new Proveedor();
        p.setNombreEmpresa(nombreProveedor);
        s.setNombreServicio(nombre);
        s.setProveedorServicio(p);
        
        DatosServicios servicios = new DatosServicios();
        
        if(servicios.selectCountNombreServicio(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa()) == 0)
            return false;
        else
            return true;
    }
    
    @Override
    public void agregarServicio(String nombre, String descripcion, int precio, String nombreProveedor, ArrayList<String> imagenes, ArrayList<String> categorias, String ciudadOrigen, String ciudadDestino, boolean tieneDestino) throws SQLException, ClassNotFoundException{
        
        Proveedor prov = new Proveedor();
        prov.setNombreEmpresa(nombreProveedor);
        
        ArrayList<ImagenServicio> imagenesServicio = new ArrayList<ImagenServicio>();
        ArrayList<Categoria> categoriasServicio = new ArrayList<Categoria>();
        
        for(int i = 0; i < imagenes.size(); i++){
            imagenesServicio.add(new ImagenServicio(imagenes.get(i), new Servicio()));            
        }
        
        for(int i = 0; i < categorias.size(); i++){
            //JOptionPane.showMessageDialog(null, categorias.get(i));
            String cat = (String) categorias.get(i);
            //int cant = contador(cat, '>');
            
            int cant = 0;
        
            for(int j = 0; j < cat.length(); j++){
                if(cat.charAt(j) == '>')
                    cant++;
            }
            
            String[] c = cat.split(">");
            //categorias.add((String) cat);
            
            categoriasServicio.add(new Categoria(c[cant].trim(), categorias.get(i), new ArrayList()));
        }
        
       
        
        
        Servicio s = new Servicio(nombre, descripcion, precio, prov, imagenesServicio, categoriasServicio, new Ciudad(ciudadOrigen, new ArrayList(), new Pais()),  new Ciudad(ciudadDestino, new ArrayList(), new Pais()), tieneDestino);  
        
        
        DatosServicios servicios = new DatosServicios();
        
        boolean hayDestino = true;
        
        if(s.getDestino().getNombre().equals("No"))
            hayDestino = false;
        else
            hayDestino = true;
        
        //System.out.println(s.getDestino().getNombre());
        
        /*if(tieneDestino)
            System.out.println("destino si");
        else
            System.out.println("destino no");*/
        
        
        //JOptionPane.showMessageDialog(null, s.getProveedorServicio().getNombreEmpresa());
        
        servicios.insertar(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa(), s.getOrigen().getNombre(), s.getDestino().getNombre(), s.getDescripcionServicio(), s.getPrecioServicio(), tieneDestino);
        
        
        
        //ArrayList<Categoria> categoriasServicio = s.getCategoriasServicio();
        categoriasServicio = s.getCategoriasServicio();
        
        for(int i = 0; i < categoriasServicio.size(); i++){
            //JOptionPane.showMessageDialog(null, categoriasServicio.get(i).getNombre());
            servicios.agregarCategoria(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa(), categoriasServicio.get(i).getNombre(), categoriasServicio.get(i).getRutaCategoria());
        }
        
        //ArrayList<ImagenServicio> imagenes = s.getImagenesServicio();
        imagenesServicio = s.getImagenesServicio();
        
        for(int i = 0; i <imagenesServicio.size(); i++){
            servicios.agregarImagen(imagenesServicio.get(i).getPath(), s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa());
        }
        
    }
    
    @Override
    public void copiarImagenServicio(String nombreActual, String nombreDestino) throws IOException{
        ImagenServicio is = new ImagenServicio(nombreActual, new Servicio());
        //try {
        is.copiarImagen(nombreDestino);
        //} catch (IOException ex) {
            //Logger.getLogger(ControladorProveedores.class.getName()).log(Level.SEVERE, null, ex);
            //throws ex;
        //}
    }
    
    @Override
    public ArrayList<DataServicio> getServicios() throws SQLException, ClassNotFoundException{
        DatosServicios servicios = new DatosServicios();
        
        ArrayList<Servicio> todosLosServicios = servicios.selectNombreServicios();
        ArrayList<DataServicio> resultado = new ArrayList<DataServicio>();
        
        for(int i = 0; i < todosLosServicios.size(); i++){
            DataServicio ds = new DataServicio();
            ds.setNombreServicio(todosLosServicios.get(i).getNombreServicio());
            ds.setNombreProveedor(todosLosServicios.get(i).getProveedorServicio().getNombreEmpresa());
            resultado.add(ds);
        }
        
        return resultado;
    }
    
    @Override
    public DataServicio getDatosServicio(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Servicio s = new Servicio();
        Proveedor p = new Proveedor();
        p.setNombreEmpresa(nombreProveedor);
        s.setNombreServicio(nombre);
        s.setProveedorServicio(p);
        
        DatosServicios servicios = new DatosServicios();
        
        Servicio datosServicio = servicios.selectServicioPorNombre(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa());
        DataServicio ds = new DataServicio();
        
        ds.setNombreProveedor(datosServicio.getProveedorServicio().getNombreEmpresa());
        ds.setDescripcionServicio(datosServicio.getDescripcionServicio());
        ds.setPrecioServicio(datosServicio.getPrecioServicio());
        
        return ds;
    }
    
    @Override
    public DataCiudad getCiudadOrigen(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Servicio s = new Servicio();
        Proveedor p = new Proveedor();
        p.setNombreEmpresa(nombreProveedor);
        s.setNombreServicio(nombre);
        s.setProveedorServicio(p);
        
        DatosServicios ds = new DatosServicios();
        
        Ciudad ciudadOrigen = ds.getCiudadOrigen(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa());
        
        DataCiudad resultadoCiudad = new DataCiudad(ciudadOrigen.getNombre(), ciudadOrigen.getPais().getNombre());
        
        return resultadoCiudad;
        
    }
    
    public DataCiudad getCiudadDestino(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Servicio s = new Servicio();
        Proveedor p = new Proveedor();
        p.setNombreEmpresa(nombreProveedor);
        s.setNombreServicio(nombre);
        s.setProveedorServicio(p);
        
        DatosServicios ds = new DatosServicios();
        
        Ciudad ciudadDestino = ds.getCiudadDestino(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa());
        
        DataCiudad resultadoCiudad = new DataCiudad(ciudadDestino.getNombre(), ciudadDestino.getPais().getNombre());
        
        return resultadoCiudad;
        
    }
    
    @Override
    public ArrayList<DataCategoria> getCategorias(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Servicio s = new Servicio();
        Proveedor p = new Proveedor();
        p.setNombreEmpresa(nombreProveedor);
        s.setNombreServicio(nombre);
        s.setProveedorServicio(p);
        
        DatosServicios ds = new DatosServicios();
        
        ArrayList<Categoria> resultadoCategorias = ds.getCategorias(nombre, nombreProveedor);
        
        ArrayList<DataCategoria> categoriasDelServicio = new ArrayList<DataCategoria>();
        
        for(int i = 0; i < resultadoCategorias.size(); i++){
            categoriasDelServicio.add(new DataCategoria(resultadoCategorias.get(i).getNombre(), resultadoCategorias.get(i).getRutaCategoria()));
        }
        
        return categoriasDelServicio;
    }
    
    @Override
    public ArrayList<DataImagen> getImagenes(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Servicio s = new Servicio();
        Proveedor p = new Proveedor();
        p.setNombreEmpresa(nombreProveedor);
        s.setNombreServicio(nombre);
        s.setProveedorServicio(p);
        
        DatosServicios ds = new DatosServicios();
        
        ArrayList<ImagenServicio> resultadoImagenes = ds.getImagenes(nombre, nombreProveedor);
        
        ArrayList<DataImagen> imagenesDelServicio = new ArrayList<DataImagen>();
        
        //System.out.println(resultadoImagenes.size());
        
        if(resultadoImagenes.size() > 0){
            for(int i = 0; i < resultadoImagenes.size(); i++){
                imagenesDelServicio.add(new DataImagen(resultadoImagenes.get(i).getPath(), ""));
            }
        }
        
        return imagenesDelServicio;
    }
    
    @Override
    public void modificarServicio(String nombre, String descripcion, int precio, String nombreProveedor, ArrayList<String> imagenes, ArrayList reservas, ArrayList promociones, ArrayList<String> categorias, String ciudadOrigen, String ciudadDestino, boolean tieneDestino) throws SQLException, ClassNotFoundException{
        
        //Servicio s = new Servicio();
        Proveedor p = new Proveedor();
        p.setNombreEmpresa(nombreProveedor);
        /*s.setNombreServicio(nombre);
        s.setProveedorServicio(p);*/
        
        DatosServicios servicios = new DatosServicios();
        
        ArrayList<ImagenServicio> imagenesServicio = new ArrayList<ImagenServicio>();
        
        for(int i = 0; i < imagenes.size(); i++){
            imagenesServicio.add(new ImagenServicio(imagenes.get(i), new Servicio()));
        }
        
        ArrayList<Categoria> categoriasServicio = new ArrayList<Categoria>();
        
        for(int i = 0; i < categorias.size(); i++){
            
            String cat = (String) categorias.get(i);
            //int cant = contador(cat, '>');
            
            int cant = 0;
        
            for(int j = 0; j < cat.length(); j++){
                if(cat.charAt(j) == '>')
                    cant++;
            }
            
            String[] c = cat.split(">");
            
            categoriasServicio.add(new Categoria(c[cant].trim(), categorias.get(i), new ArrayList()));
        }
        
        Servicio s = new Servicio(nombre, descripcion, precio, p, imagenesServicio, categoriasServicio, new Ciudad(ciudadOrigen, new ArrayList(), new Pais()), new Ciudad(ciudadDestino, new ArrayList(), new Pais()), tieneDestino);
        
        boolean hayDestino = true;
        
        if(s.getDestino().getNombre().equals("No"))
            hayDestino = false;
        else
            hayDestino = true;
        
        servicios.modificarServicio(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa(), s.getOrigen().getNombre(), s.getDestino().getNombre(), s.getDescripcionServicio(), s.getPrecioServicio(), hayDestino);
        
        servicios.eliminarImagenes(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa());
        servicios.eliminarCategorias(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa());
        
        categoriasServicio = s.getCategoriasServicio();
        
        for(int i = 0; i < categoriasServicio.size(); i++){
            servicios.agregarCategoria(s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa(), categoriasServicio.get(i).getNombre(), categoriasServicio.get(i).getRutaCategoria());
        }
        
        imagenesServicio = s.getImagenesServicio();
        
        for(int i = 0; i <imagenesServicio.size(); i++){
            servicios.agregarImagen(imagenesServicio.get(i).getPath(), s.getNombreServicio(), s.getProveedorServicio().getNombreEmpresa());
        }
        
        
        
        //this.agregarServicio(String nombre, String descripcion, int precio, String nombreProveedor, ArrayList<String> imagenes, ArrayList reservas, ArrayList promociones, ArrayList<String> categorias, String ciudadOrigen, String ciudadDestino, boolean tieneDestino);
        
    }
    
    @Override
    public ArrayList<DataServicio> getServiciosPorBusqueda(String nombre) throws SQLException, ClassNotFoundException{
        
        Servicio s = new Servicio();
        s.setNombreServicio(nombre);
        
        DatosServicios ds = new DatosServicios();
        
        ArrayList<Servicio> servicios = ds.getServiciosPorBusqueda(s.getNombreServicio());
        ArrayList<DataServicio> resultadoServicio = new ArrayList<DataServicio>();
        
        for(int i = 0; i < servicios.size(); i++){
            DataServicio serv = new DataServicio();
            serv.setNombreServicio(servicios.get(i).getNombreServicio());
            serv.setNombreProveedor(servicios.get(i).getProveedorServicio().getNombreEmpresa());
            resultadoServicio.add(serv);
        }
        
        return resultadoServicio;
    }

    
@Override
public ArrayList<DataServicio> getServiciosProveedor(String NombreProveedor) throws SQLException,ClassNotFoundException{
    ArrayList<DataServicio> servicios = new ArrayList();
    DatosServicios dServicios = new DatosServicios();
    ArrayList<Servicio> servProve = new ArrayList();
    Proveedor proveedor = new Proveedor();
    proveedor.setNombreEmpresa(NombreProveedor);
    servProve = dServicios.getServiciosProveedor(proveedor.getNombreEmpresa());
    int tamanio = servProve.size();
    int inicio = 0;
    for (inicio = 0;inicio<tamanio;inicio++){
        DataServicio serv = new DataServicio();
        serv.setNombreServicio(servProve.get(inicio).getNombreServicio());
        serv.setPrecioServicio(servProve.get(inicio).getPrecioServicio());
        servicios.add(serv);
    }
    return servicios;
}
    
    
}
