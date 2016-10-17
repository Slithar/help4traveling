/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;
import java.time.LocalDate;
import Datos.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class ControladorLogs implements IControladorLogs{

    @Override
    public void agregarLog(LocalDate fecha, String ruta, String navegador, String so) throws SQLException, ClassNotFoundException {
        DatosLogs dl = new DatosLogs();
        Log l = new Log(fecha, ruta, navegador, so);
        dl.agregarLog(l.getFecha(), l.getRuta(), l.getNavegador(), l.getSo());
    }
    
    @Override
    public String getSO(){
        String so = System.getProperty("os.name");
        return so;
    }
    
    @Override
    public String getNavegador(String userAgent){
        if(userAgent.indexOf("MSIE") > -1)
            return "IE";
        else if(userAgent.indexOf("Trident") > -1)
            return "IE";
        else if(userAgent.indexOf("OPR") > -1)
            return "Opera";
        else if(userAgent.indexOf("Safari") > -1)
            return "Safari";
        else if(userAgent.indexOf("Firefox") > -1)
            return "Firefox";
        else if(userAgent.indexOf("Chrome") > -1)
            return "Chrome";
        else 
            return "N/D";
    }
    
    @Override
    public boolean posibleAgregar() throws SQLException, ClassNotFoundException{
        DatosLogs dl = new DatosLogs();
        if(dl.getCantidadLogs() > 10000 | dl.getCantidadLogs() == 10000)
            return false;
        else
            return true;
    }
    
    @Override
    public ArrayList<DataLog> getLogs() throws SQLException, ClassNotFoundException{
        DatosLogs dl = new DatosLogs();
        ArrayList<Log> resultadoLogs = dl.selectAllLogs();
        
        ArrayList<DataLog> resultado = new ArrayList();
        //JOptionPane.showMessageDialog(null, resultado.get(0).getRuta());
        for(int i = 0; i < resultadoLogs.size(); i++){
            DataLog datosLogs = new DataLog(resultadoLogs.get(i).getNumero(), resultadoLogs.get(i).getFecha(), resultadoLogs.get(i).getRuta(), resultadoLogs.get(i).getNavegador(), resultadoLogs.get(i).getSo());
            resultado.add(datosLogs);
        }
        
        return resultado;
    }
    
}
