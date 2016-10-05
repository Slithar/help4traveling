/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.*;
import java.sql.*;
import Datos.DatosCategorias;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author usuario
 */
public class ControladorCategorias implements IControladorCategorias{
    
    private DatosCategorias categorias;
    
    private HashMap<String, Categoria> ListaCategorias;
    
    public ControladorCategorias(){
        
        
    }
    
    public void actualizarCategorias() throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        ListaCategorias = new HashMap<String, Categoria>();
        ArrayList<Categoria> categoriasResultado = categorias.selectAllCategorias();
        for(int i = 0; i < categoriasResultado.size(); i++){
            ListaCategorias.put(categoriasResultado.get(i).getNombre(), categoriasResultado.get(i));
        }
        Iterator it = ListaCategorias.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry cat = (Map.Entry) it.next();
            //System.out.println("* " + cat.getKey());
            ArrayList<Categoria> catHijas = categorias.selectCategoriasHijas(String.valueOf(cat.getKey()));
            Categoria c = (Categoria) cat.getValue();
            c.setCategoriasHijas(catHijas);
            for(int i = 0; i < c.getCategoriasHijas().size(); i++){
                //System.out.println("-- " + c.getCategoriasHijas().get(i).getNombre());
            }
        }
    }
    
    public int getCantCategorias(){
        return ListaCategorias.size();
    }
    
    @Override
    public ArrayList<DataCategoria> getCategoriasPadres() throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        
        ArrayList<Categoria> categoriasPadres = categorias.selectCategoriasPadres();
        ArrayList<DataCategoria> resultado = new ArrayList<DataCategoria>();
        
        for(int i = 0; i < categoriasPadres.size(); i++){
            resultado.add(new DataCategoria(categoriasPadres.get(i).getNombre()));
        }
        
        return resultado;
        
    }
    
    @Override
    public ArrayList<DataCategoria> getCategoriasHijas(String c) throws SQLException, ClassNotFoundException{
        
        Categoria cat = new Categoria();
        cat.setNombre(c);
        
        categorias = new DatosCategorias();
        
        ArrayList<Categoria> categoriasPadres = categorias.selectCategoriasHijas(cat.getNombre());
        ArrayList<DataCategoria> resultado = new ArrayList<DataCategoria>();
        
        for(int i = 0; i < categoriasPadres.size(); i++){
            resultado.add(new DataCategoria(categoriasPadres.get(i).getNombre()));
        }
        
        return resultado;
        
    }    
    @Override
    public boolean agregarNuevaCategoriaPadre(String c) throws SQLException, ClassNotFoundException{
        
        Categoria cat = new Categoria(c, "", new ArrayList());
        
        categorias = new DatosCategorias();
        int rows = categorias.agregarCategoriaPadre(cat.getNombre());
        if(rows>0){
            boolean resultado = true;
            return resultado;
        }else{
            boolean resultado = false;
            return resultado;
        }
    }
    
    @Override
    public boolean agregarNuevaCategoriaHija(String c, String padre) throws SQLException,ClassNotFoundException{
       
       Categoria catHija = new Categoria(c, "", new ArrayList());
       
       categorias = new DatosCategorias();
       ArrayList existeCate = categorias.existeCategoria(catHija.getNombre());
       boolean existe = false;
       if(!existeCate.isEmpty()){
           existe = true;
       }else{
           existe= false;
       }
       if(existe==true){
            boolean resultado = categorias.agregarNuevaCategoriaHija(catHija.getNombre(), padre);
            return resultado;
       }else{
           categorias.agregarCategoriaPadre(catHija.getNombre());
           boolean resultado = categorias.agregarNuevaCategoriaHija(catHija.getNombre(), padre);
           return resultado;
       }
    }
    
    

    public HashMap<String, Categoria> getListaCategorias() {
        return ListaCategorias;
    }

    public void setListaCategorias(HashMap<String, Categoria> ListaCategorias) {
        this.ListaCategorias = ListaCategorias;
    }
    
    public boolean existeCategoria(String c) throws SQLException, ClassNotFoundException{
        Categoria cat = new Categoria(c, "", new ArrayList());
        categorias = new DatosCategorias();
        
        if(categorias.existeCategoria(cat.getNombre()).size() > 0)
            return true;
        else
            return false;
    }

    @Override
    public void deleteAllCategorias() throws SQLException, ClassNotFoundException {
        categorias = new DatosCategorias();
        categorias.deleteAllCategorias("delete from categoriasdeservicios where nombreCategoria <> \"\";" + 
                        "delete from categoriasrelacionadas where categoriaHija <> \"\";\n" +
                        "delete from categorias where nombre <> \"\";");
    }

    @Override
    public void insertCategoriasDePrueba() throws SQLException, ClassNotFoundException {
        categorias = new DatosCategorias();
        categorias.insertCategoriasDePrueba("insert into categorias values('Vuelos');\n" +
                        "insert into categorias values('Alojamientos');\n" +
                        "insert into categorias values('Automóviles');\n" +
                        "insert into categorias values('Cruceros');\n" +
                        "insert into categorias values('Empresas');\n" +
                        "insert into categorias values('Iberia');\n" +
                        "insert into categorias values('American Airlines');\n" +
                        "insert into categorias values('Air France');\n" +
                        "insert into categorias values('TAM');\n" +
                        "insert into categorias values('Tipo vuelo');\n" +
                        "insert into categorias values('LowCost');\n" +
                        "insert into categorias values('Standard');\n" +
                        "insert into categorias values('First class');\n" +
                        "insert into categorias values('Tipo alojamiento');\n" +
                        "insert into categorias values('Hotel');\n" +
                        "insert into categorias values('Hostal');\n" +
                        "insert into categorias values('Apartamento');\n" +
                        "insert into categorias values('Casa');\n" +
                        "insert into categorias values('Ubicación');\n" +
                        "insert into categorias values('Playa');\n" +
                        "insert into categorias values('Rural');\n" +
                        "insert into categorias values('Montaña');\n" +
                        "insert into categorias values('Habitaciones');\n" +
                        "insert into categorias values('1 ambiente');\n" +
                        "insert into categorias values('1 dormitorio');\n" +
                        "insert into categorias values('2 dormitorios');\n" +
                        "insert into categorias values('Tarifa');\n" +
                        "insert into categorias values('Mini');\n" +
                        "insert into categorias values('Económico');\n" +
                        "insert into categorias values('Full');\n" +
                        "insert into categorias values('Tipo vehículo');\n" +
                        "insert into categorias values('Auto');\n" +
                        "insert into categorias values('Camioneta');\n" +
                        "insert into categorias values('Camión');\n" +
                        "insert into categorias values('Moto');\n" +
                        "insert into categorias values('Marca');\n" +
                        "insert into categorias values('Chevrolet');\n" +
                        "insert into categorias values('Peugeot');\n" +
                        "insert into categorias values('Daihatsu');\n" +
                        "insert into categorias values('Fiat');\n" +
                        "insert into categorias values('Ford');\n" +
                        "insert into categorias values('Mediterráneo');\n" +
                        "insert into categorias values('Mar Negro');\n" +
                        "insert into categorias values('Caribe');\n" +
                        "insert into categorias values('Nilo');\n" +
                        "insert into categorias values('Alaska');\n" +
                        "insert into categoriasrelacionadas values('Vuelos', 'Empresas'), ('Vuelos', 'Tipo vuelo');\n" +
                        "insert into categoriasrelacionadas values('Empresas', 'Iberia'), ('Empresas', 'American Airlines'), ('Empresas', 'Air France'), ('Empresas', 'TAM');\n" +
                        "insert into categoriasrelacionadas values('Tipo vuelo', 'LowCost'), ('Tipo vuelo', 'Standard'), ('Tipo vuelo', 'First Class');\n" +
                        "insert into categoriasrelacionadas values('Alojamientos', 'Tipo alojamiento'), ('Alojamientos', 'Ubicación'), ('Alojamientos', 'Habitaciones');\n" +
                        "insert into categoriasrelacionadas values('Tipo alojamiento', 'Hotel'), ('Tipo alojamiento', 'Hostal'), ('Tipo alojamiento', 'Apartamento'), ('Tipo alojamiento', 'Casa');\n" +
                        "insert into categoriasrelacionadas values('Ubicación', 'Playa'), ('Ubicación', 'Rural'), ('Ubicación', 'Montaña');\n" +
                        "insert into categoriasrelacionadas values('Habitaciones', '1 ambiente'), ('Habitaciones', '1 dormitorio'), ('Habitaciones', '2 dormitorios');\n" +
                        "insert into categoriasrelacionadas values('Automóviles', 'Tarifa'), ('Automóviles', 'Tipo vehículo'), ('Automóviles', 'Marca');\n" +
                        "insert into categoriasrelacionadas values('Tarifa', 'Mini'), ('Tarifa', 'Económico'), ('Tarifa', 'Standard'), ('Tarifa', 'Full');\n" +
                        "insert into categoriasrelacionadas values('Tipo vehículo', 'Auto'), ('Tipo vehículo', 'Camioneta'), ('Tipo vehículo', 'Camión'), ('Tipo vehículo', 'Moto');\n" +
                        "insert into categoriasrelacionadas values('Marca', 'Chevrolet'), ('Marca', 'Peugeot'), ('Marca', 'Daihatsu'), ('Marca', 'Fiat'), ('Marca', 'Ford');\n" +
                        "insert into categoriasrelacionadas values('Cruceros', 'Mediterráneo'), ('Cruceros', 'Mar Negro'), ('Cruceros', 'Caribe'), ('Cruceros', 'Nilo'), ('Cruceros', 'Alaska');");
    }
    
    @Override
    public ArrayList getCategoriasRelacionadas() throws SQLException, ClassNotFoundException{
        DatosCategorias dc = new DatosCategorias();
        
        return dc.getCategoriasRelacionadas();
    }
    
}
