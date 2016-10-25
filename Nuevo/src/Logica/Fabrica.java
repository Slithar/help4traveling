/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Servicios.*;

/**
 *
 * @author usuario
 */
public class Fabrica {
    
    
    
    public Fabrica(){
        
    }
    
    public IControladorClientes getIControladorClientes(){
        IControladorClientes iccli = new ControladorClientes();
        return iccli;
    }
    
    public IControladorProveedores getIControladorProveedores(){
        IControladorProveedores icprov = new ControladorProveedores();
        return icprov;
    }
    
    public IControladorCategorias getIControladorCategorias(){
        IControladorCategorias iccat = new ControladorCategorias();
        return iccat;
    }
    
    public IControladorPromociones getIControladorPromociones(){
        IControladorPromociones icprom = new ControladorPromociones();
        return icprom;
    }
    
    public IControladorLogs getIControladorLogs(){
        IControladorLogs iclog = new ControladorLogs();
        return iclog;
    }
    
    public WSClientes getWSClientes(){
        WSClientes wscli = new WSClientes();
        return wscli;
    }
    
    public WSProveedores getWSProveedores(){
        WSProveedores wsprov = new WSProveedores();
        return wsprov;
    }
    
    public WSCategorias getWSCategorias(){
        WSCategorias wscat = new WSCategorias();
        return wscat;
    }
    
    public WSPromociones getWSPromociones(){
        WSPromociones wsprom = new WSPromociones();
        return wsprom;
    }
    
    public WSLogs getWSLogs(){
        WSLogs wslog = new WSLogs();
        return wslog;
    }
    
    public WSPrincipal getWSPrincipal(){
        WSPrincipal wspri = new WSPrincipal();
        return wspri;
    }
}
