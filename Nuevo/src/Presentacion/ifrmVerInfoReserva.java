/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;


/**
 *
 * @author usuario
 */
public class ifrmVerInfoReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmVerInfoReserva
     */
    
    private IControladorClientes iccli;
    
        private String[] columnas = {"Nombre", "Proveedor", "Cantidad", "Precio unitario", "Total línea","Fecha inicio", "Fecha fin", "Tipo"};
    private DefaultTableModel datosPromocionServ = new DefaultTableModel(null, columnas) {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    
    public ifrmVerInfoReserva() {
        initComponents();
    }
    
    public ifrmVerInfoReserva(IControladorClientes iccli) {
        initComponents();
        /** Después del merge **/
        setTitle("Ver información de reservas");
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (600 - tamanioVentana.height)/2);
        
        this.iccli = iccli;
        
        DefaultListModel model = new DefaultListModel();
        
        try{
            ArrayList<String> numRes= this.iccli.verInfoReserva(); 
            
        for(int i =0;i<numRes.size();i++){
            model.addElement(numRes.get(i));
        }
         
        }catch(Exception e){}
        
        initComponents();
        listRes.setModel(model);
        
        panelInfo.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos = new javax.swing.JPanel();
        panelBuscar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listRes = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        jlabel2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jnickCliente = new javax.swing.JLabel();
        jPrecio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jEstado = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jlabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione reserva:");

        listRes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listResMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listRes);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel2.setText("Nickname del cliente: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Precio:");

        jnickCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jnickCliente.setText("nick");

        jPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPrecio.setText("precio");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Fecha:");

        jFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFecha.setText("fecha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Estado: ");

        jEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jEstado.setText("estado");

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Proveedor", "Cantidad", "Precio unitario", "Total línea", "Fecha Inicio", "Fecha Fin", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable);

        jlabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel3.setText("Productos:");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jnickCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jnickCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPrecio)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFecha)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(panelDatos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listResMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listResMouseClicked
        
    }//GEN-LAST:event_listResMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(listRes.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna reserva", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            String selected =listRes.getSelectedValue();
            /*comentarioo*/
            
            //JOptionPane.showMessageDialog(this, selected);
            
            try{
                datosPromocionServ = new DefaultTableModel(null, columnas);
                DataReserva dtcant =this.iccli.getReserva(selected);
                this.jnickCliente.setText(dtcant.getCliente());
                this.jPrecio.setText("U$S " + dtcant.getPrecio());
                //this.jFecha.setText(dtcant.getFecha().toString());
                this.jFecha.setText(dtcant.getFecha().getDayOfMonth() + "/" + dtcant.getFecha().getMonthValue() + "/" + dtcant.getFecha().getYear());
                this.jEstado.setText(dtcant.getEstado().toString());
                //JOptionPane.showMessageDialog(this, dtcant.getCliente());

                ArrayList <DataCantidadReservasPromociones>  listProm=this.iccli.getReservasPromo(selected);
                ArrayList<DataCantidadReservasServicios>listServ=this.iccli.getReservasServ(selected);
                if(listProm.size()>0){
                    for(int i=0;i<listProm.size();i++){
                        DataCantidadReservasPromociones promAux=listProm.get(i);
                        Object[] fila = {promAux.getPromocion(), promAux.getProveedor(), promAux.getCantidad(), promAux.getTotalLinea() / promAux.getCantidad(), promAux.getTotalLinea(), promAux.getFechaInicio().getDayOfMonth() + "/" + promAux.getFechaInicio().getMonthValue() + "/" + promAux.getFechaInicio().getYear(),promAux.getFechaFin().getDayOfMonth() + "/" + promAux.getFechaFin().getMonthValue()+ "/" + promAux.getFechaFin().getYear(),"PROMOCIÓN"};

                        datosPromocionServ.addRow(fila);
                    }
                    jTable.setModel(datosPromocionServ);
                }

                if(listServ.size()>0){
                    for(int i=0;i<listServ.size();i++){
                        DataCantidadReservasServicios promAux=listServ.get(i);
                        Object[] fila = {promAux.getServicio(), promAux.getProveedor(), promAux.getCantidad(), promAux.getTotalLinea() / promAux.getCantidad(), promAux.getTotalLinea(), promAux.getFechaInicio().getDayOfMonth() + "/" + promAux.getFechaInicio().getMonthValue() + "/" + promAux.getFechaInicio().getYear(),promAux.getFechaFin().getDayOfMonth() + "/" + promAux.getFechaFin().getMonthValue()+ "/" + promAux.getFechaFin().getYear(),"SERVICIO"};

                        datosPromocionServ.addRow(fila);
                    }
                    jTable.setModel(datosPromocionServ);
                }
                panelInfo.setVisible(true);
            }catch(Exception e){}
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jEstado;
    private javax.swing.JLabel jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jPrecio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jnickCliente;
    private javax.swing.JList<String> listRes;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelInfo;
    // End of variables declaration//GEN-END:variables
}
