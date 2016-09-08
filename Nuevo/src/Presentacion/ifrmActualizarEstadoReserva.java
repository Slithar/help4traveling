/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import Logica.IControladorClientes;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chaos
 */
public class ifrmActualizarEstadoReserva extends javax.swing.JInternalFrame {
 
    private IControladorClientes iccli;
    /**
     * Creates new form ifrmActualizarEstadoReserva
     */
    public ifrmActualizarEstadoReserva() {
        initComponents();
    }
      
    private String[] columnas = {"Numero", "Estado"};
    private DefaultTableModel datosPromocionServ = new DefaultTableModel(null, columnas) {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    public ifrmActualizarEstadoReserva(IControladorClientes iccli){
        initComponents();
        setTitle("Actualizar estado reserva");
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (745 - tamanioVentana.height)/2);
        
        this.iccli = iccli;
        DefaultTableModel model=  new DefaultTableModel(null, columnas);
    
        try{
            ArrayList<DataReserva> numRes= this.iccli.datosReserva(); 
        for(int i =0;i<numRes.size();i++){
            DataReserva resAux=new DataReserva();
            resAux.setNumero(numRes.get(i).getNumero());
            resAux.setEstado(numRes.get(i).getEstado().toString());
            Object[] fila = {resAux.getNumero(),resAux.getEstado()};
            model.addRow(fila);
            
        }
         
        
        }catch(Exception e){}
        
       setTitle("Actualizar reserva");
       tablaRes.setModel(model);
       tablaRes.setVisible(true);
       panelEstado.setVisible(false);
       cmbEstado.addItem("CANCELADA");
       cmbEstado.addItem("FACTURADA");
       cmbEstado.addItem("PAGADA");        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelEstado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaRes = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione reserva:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nuevo estado:");

        cmbEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Número de la reserva:");

        lblNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNumero.setText("numero");

        javax.swing.GroupLayout panelEstadoLayout = new javax.swing.GroupLayout(panelEstado);
        panelEstado.setLayout(panelEstadoLayout);
        panelEstadoLayout.setHorizontalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadoLayout.createSequentialGroup()
                .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEstadoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lblNumero)))
                    .addGroup(panelEstadoLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelEstadoLayout.setVerticalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(lblNumero)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(64, 64, 64))
        );

        tablaRes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número", "Estado"
            }
        ));
        tablaRes.setAutoscrolls(false);
        jScrollPane2.setViewportView(tablaRes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(panelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(tablaRes.getSelectedRow() == -1){
           JOptionPane.showMessageDialog(this, "No se ha seleccionado reserva", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
       }
       else if(!esNumerico(String.valueOf(tablaRes.getValueAt(tablaRes.getSelectedRow(),0)))){
           JOptionPane.showMessageDialog(this, "El valor de la columna correspondiente al número de la reserva seleccionada no es correcto", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
       }
       else if(!String.valueOf(tablaRes.getValueAt(tablaRes.getSelectedRow(),1)).equals("REGISTRADA"))
           JOptionPane.showMessageDialog(this, "El estado de la reserva seleccionada debe ser 'Registrada'", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
       else{
           lblNumero.setText(String.valueOf(tablaRes.getValueAt(tablaRes.getSelectedRow(),0)));
           panelEstado.setVisible(true);
       }
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            iccli.updateEstadoReserva(Integer.parseInt(lblNumero.getText()), (String) cmbEstado.getSelectedItem());
            JOptionPane.showMessageDialog(this, "El estado de la reserva ha sido modificado de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
            panelEstado.setVisible(false);
            cmbEstado.setSelectedIndex(0);
            DefaultTableModel model=  new DefaultTableModel(null, columnas);

            
                ArrayList<DataReserva> numRes= this.iccli.datosReserva(); 

            for(int i =0;i<numRes.size();i++){
                DataReserva resAux=new DataReserva();
                resAux.setNumero(numRes.get(i).getNumero());
                resAux.setEstado(numRes.get(i).getEstado().toString());
                Object[] fila = {resAux.getNumero(),resAux.getEstado()};
                model.addRow(fila);

            }
            
            tablaRes.setModel(model);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "El número de la reserva indicada es incorrecto", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    public boolean esNumerico(String txt){
        try{
            Integer.parseInt(txt);
            return true;
        }
        catch(NumberFormatException ex){
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JTable tablaRes;
    // End of variables declaration//GEN-END:variables
}
