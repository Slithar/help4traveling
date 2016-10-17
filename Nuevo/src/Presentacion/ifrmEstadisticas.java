/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;

/**
 *
 * @author usuario
 */
public class ifrmEstadisticas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmEstadisticas
     */
    private IControladorProveedores icprov;
    
    public ifrmEstadisticas() {
        initComponents();
    }
    
    public ifrmEstadisticas(IControladorProveedores icprov) {
        initComponents();
        this.icprov = icprov;
        setTitle("Estadísticas de visitas a servicios");
        
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (725 - tamanioVentana.height)/2);
        
        /*DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        try{
            ArrayList<DataServicio> servicios = icprov.getServiciosMasVisitados();
            for(int i = 0; i < servicios.size(); i++){
                data.addValue(servicios.get(i).getVisitas(), "Servicio", servicios.get(i).getNombreServicio() + " (" + servicios.get(i).getNombreProveedor() + ")");
            }
            
            JFreeChart grafica = ChartFactory.createBarChart3D("Servicios más visitados", "Servicio", "Visitas", data, PlotOrientation.VERTICAL, false, true, false);
            
            ChartPanel contenedor = new ChartPanel(grafica);
            add(contenedor);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "El número de la reserva indicada es incorrecto", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
