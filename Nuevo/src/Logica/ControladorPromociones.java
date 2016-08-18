/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ControladorPromociones implements IControladorPromociones{
    
    public ControladorPromociones(){
        
    }

    @Override
    public ArrayList<DataPromocion> getPromociones() throws SQLException, ClassNotFoundException {
        ArrayList<DataPromocion> resultado = new ArrayList();
        //no implementado aun
        
        
        return resultado;
    }
    
}
