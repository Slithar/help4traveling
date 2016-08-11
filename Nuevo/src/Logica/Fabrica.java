/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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
    
    
}
