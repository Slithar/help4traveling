/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author usuario
 */
public class ifrmRegistrosAccesos extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmRegistrosAccesos
     */
    private IControladorLogs iclog;
    
    public ifrmRegistrosAccesos() {
        initComponents();
    }
    
    public ifrmRegistrosAccesos(IControladorLogs iclog) {
        initComponents();
        setTitle("Registros de accesos al sitio web");
        this.iclog = iclog;
        
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (800 - tamanioVentana.height)/2);
        
        verLogs();
               
    }
    
    public void verLogs(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.setColumnIdentifiers(new Object[]{"Número", "Fecha", "Ruta de la página", "Navegador", "Sistema operativo"});        
        try{
            ArrayList<DataLog> logs = iclog.getLogs();
            //JOptionPane.showMessageDialog(this, logs.size());
            
            for(int i = 0; i < logs.size(); i++){                
                modelo.addRow(new Object[]{logs.get(i).getNumero(), logs.get(i).getFecha().getDayOfMonth() + "/" + logs.get(i).getFecha().getMonthValue() + "/" + logs.get(i).getFecha().getYear(), "<html><a href = \"" + logs.get(i).getRuta() + "\">" + logs.get(i).getRuta() + "</a></html>", logs.get(i).getNavegador(), logs.get(i).getSo()});
            }
            tblRegistros.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblRegistros.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblRegistros.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblRegistros.getColumnModel().getColumn(4).setPreferredWidth(0);
            
            tblRegistros.setModel(modelo);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "El número de la reserva indicada es incorrecto", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);

        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Fecha", "Ruta de la página", "Navegador", "Sistema operativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegistros);

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(btnActualizar)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        verLogs();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegistrosMouseClicked
        /*int fila = tblRegistros.rowAtPoint(evt.getPoint());
        int columna = tblRegistros.columnAtPoint(evt.getPoint());
        if(columna == 2){
            try {
                Desktop.getDesktop().browse(new URI((String) tblRegistros.getValueAt(fila, columna)));
            } catch (IOException |  URISyntaxException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                
            }
        }*/
    }//GEN-LAST:event_tblRegistrosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables
}
