/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Cliente;
import Logica.DataCiudad;
import Logica.DataCliente;
import Logica.DataPromocion;
import Logica.DataReserva;
import Logica.DataServicio;
import Logica.DataCantidadReservasServicios;
import Logica.DataCantidadReservasPromociones;
import Logica.IControladorClientes;
import Logica.IControladorPromociones;
import Logica.IControladorProveedores;
import Logica.Reserva;
import Logica.cantidadReservasPromociones;
import Logica.cantidadReservasServicios;
import java.awt.Dimension;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ezequiel
 */
public class ifrmAltaReservas extends javax.swing.JInternalFrame {

    /**
     * Creates new form pruebaa
     */
    
    private IControladorClientes iccli;
    private IControladorProveedores icprov;
    private IControladorPromociones icprom;
    
    int precioTotal= 0;
    
    public ifrmAltaReservas() {
        initComponents();
    }

    ifrmAltaReservas(IControladorProveedores icprov, IControladorClientes iccli, IControladorPromociones icprom){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        initComponents();
    
        setTitle("Alta de Reserva");
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (700 - tamanioVentana.height)/2);
        panelGeneral.setVisible(true);
        panelDatos.setVisible(true);
        panelReservas.setVisible(false);
        btnCancelar.setVisible(true);

        limpiar();

        this.iccli = iccli;
        this.icprov = icprov;
        this.icprom = icprom;

        DefaultTableModel modeloServ = new DefaultTableModel();
        modeloServ.setColumnIdentifiers(new Object[]{"Tipo","Nombre","Proveedor","Precio"});
        
        DefaultTableModel modeloAsociaciones = new DefaultTableModel();
        modeloAsociaciones.setColumnIdentifiers(new Object[]{""});
        tblAsociaciones.setModel(modeloAsociaciones);

        try{
            ArrayList<DataServicio> DatasServicios = icprov.getServicios();
            for(int i = 0 ; i < DatasServicios.size(); i++){
                
                modeloServ.addRow(new Object[]{"Servicio", DatasServicios.get(i).getNombreServicio(), DatasServicios.get(i).getNombreProveedor(), icprov.getDatosServicio(DatasServicios.get(i).getNombreServicio(), DatasServicios.get(i).getNombreProveedor()).getPrecioServicio()});
            
                //System.out.println(DatosServicios.get(i).getPrecioServicio()+ "serv 1");
            }
            tblServicios.setModel(modeloServ);
            //ArrayList<DataPromocion> DatosPromocion = icprom.getPromociones();
        }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
            catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        
        try{
            ArrayList<DataPromocion> DatasPromociones = icprom.getPromociones();
            for(int i = 0; i < DatasPromociones.size(); i++){
                
                    String proveedor = icprom.getServiciosPorPromocion(DatasPromociones.get(i).getNombre()).get(0).getNombreProveedor();
                    modeloServ.addRow(new Object[] {"Promocion", DatasPromociones.get(i).getNombre(), proveedor ,DatasPromociones.get(i).getPrecio() });
            }
        }
        catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Hay un problema de conexion con la base de datos por los que no fue posible completar la accion", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        
        try{
            llenarcmbClientes(cmbUsuarios, iccli.getClientes());
        }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch(ClassNotFoundException ex){
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

        panelGeneral = new javax.swing.JPanel();
        panelReservas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAsociaciones = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbUsuarios = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        lblPrecioTotal = new javax.swing.JLabel();
        panelDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spnCant = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        spnIniDia = new javax.swing.JSpinner();
        spnIniMes = new javax.swing.JSpinner();
        spnIniAnio = new javax.swing.JSpinner();
        spnFinDia = new javax.swing.JSpinner();
        spnFinMes = new javax.swing.JSpinner();
        spnFinAnio = new javax.swing.JSpinner();
        btnAsociar = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        panelConfirmacion = new javax.swing.JPanel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);

        tblAsociaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblAsociaciones);

        jLabel3.setText("Servicio y Promociones asociados");

        jLabel5.setText("Seleccione el Usuario correspondiente");

        cmbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuariosActionPerformed(evt);
            }
        });

        jLabel7.setText("Precio Total U$S:");

        javax.swing.GroupLayout panelReservasLayout = new javax.swing.GroupLayout(panelReservas);
        panelReservas.setLayout(panelReservasLayout);
        panelReservasLayout.setHorizontalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cmbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelReservasLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(385, Short.MAX_VALUE))))
        );
        panelReservasLayout.setVerticalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );

        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServiciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicios);

        jLabel1.setText("Seleccione Servicio o Promocion a asociar a la Reserva");

        jLabel2.setText("Nombre: ");

        jLabel4.setText("Proveedor:");

        jLabel6.setText("Precio:");

        jLabel8.setText("Cantidad");

        jLabel9.setText("Inicio");

        jLabel10.setText("Final");

        btnAsociar.setText("Asociar");
        btnAsociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsociarActionPerformed(evt);
            }
        });

        lblTipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("Tipo");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnFinDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnIniDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spnCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(spnIniMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(spnIniAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(spnFinMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnFinAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAsociar)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lblProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(spnCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spnIniDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnIniMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnIniAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnFinDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spnFinMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spnFinAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAsociar))
        );

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConfirmacionLayout = new javax.swing.GroupLayout(panelConfirmacion);
        panelConfirmacion.setLayout(panelConfirmacionLayout);
        panelConfirmacionLayout.setHorizontalGroup(
            panelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfirmacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(73, 73, 73)
                .addComponent(btnCancelar)
                .addGap(22, 22, 22))
        );
        panelConfirmacionLayout.setVerticalGroup(
            panelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfirmacionLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(panelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        getContentPane().add(panelGeneral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsuariosActionPerformed

    private void btnAsociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsociarActionPerformed
        // TODO add your handling code here:
        boolean ok = true;
        if(lblServicio.getText() == "" && lblProveedor.getText() == "" && lblPrecio.getText() == ""){
            ok = false;
            JOptionPane.showMessageDialog(this, "No se ha seleccionado nada de la lista", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        else  if(LocalDate.now().isAfter(LocalDate.of((Integer) spnIniAnio.getValue(), (Integer) spnIniMes.getValue(),(Integer) spnIniDia.getValue()))){
           ok = false;
           JOptionPane.showMessageDialog(this, "La fecha de inicio no debe ser anterior al dia de Hoy", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if(LocalDate.of((Integer) spnIniAnio.getValue(), (Integer) spnIniMes.getValue(),(Integer) spnIniDia.getValue()).isAfter(LocalDate.of((Integer) spnFinAnio.getValue(), (Integer) spnFinMes.getValue(), (Integer) spnFinDia.getValue())) || LocalDate.of((Integer) spnIniAnio.getValue(), (Integer) spnIniMes.getValue(),(Integer) spnIniDia.getValue()).isEqual(LocalDate.of((Integer) spnFinAnio.getValue(), (Integer) spnFinMes.getValue(), (Integer) spnFinDia.getValue()))){
            ok = false;
           JOptionPane.showMessageDialog(this, "La fecha de Inicio debe ser anterior a la Fecha de Fin", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else for(int i = 0; i < tblAsociaciones.getRowCount(); i++){
            if( tblAsociaciones.getValueAt(i,1 ).toString().equals(lblServicio.getText())){
                ok = false;
                JOptionPane.showMessageDialog(this, "No se puede asociar a la reserva un mismo servicio o promocion dos veces", "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
            }
                if(!tblAsociaciones.getValueAt(i, 2).toString().equals(lblProveedor.getText())){
                    ok = false;
                    JOptionPane.showMessageDialog(this, "No se puede asociar a la reserva un servicio o promocion de distinto proveedor", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
        int cantidad = (Integer) spnCant.getValue();
        int precio = Integer.parseInt(lblPrecio.getText());
        if(ok == true){
            DefaultTableModel modeloAsoc = new DefaultTableModel();
            modeloAsoc = (DefaultTableModel) tblAsociaciones.getModel();
            modeloAsoc.setColumnIdentifiers(new Object[]{ "Tipo", "Nombre", "Proveedor" , "Cantidad", "Precio Unitario", "Total", "Inicio", "Fin"});
            modeloAsoc.addRow(new Object[]{ lblTipo.getText() , lblServicio.getText(), lblProveedor.getText() , String.valueOf(spnCant.getValue()), lblPrecio.getText(), String.valueOf(cantidad * precio), LocalDate.of((Integer) spnIniAnio.getValue(), (Integer) spnIniMes.getValue(), (Integer) spnIniDia.getValue()), LocalDate.of((Integer) spnFinAnio.getValue(), (Integer) spnFinMes.getValue(), (Integer) spnFinDia.getValue())});
            precioTotal += cantidad * precio;
            lblPrecioTotal.setText(String.valueOf(precioTotal));
            tblAsociaciones.setModel(modeloAsoc);
            panelGeneral.setVisible(true);
            panelReservas.setVisible(true);
            tblAsociaciones.setVisible(true);
        }
        
    }//GEN-LAST:event_btnAsociarActionPerformed

    private void tblServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiciosMouseClicked
        try {
            // TODO add your handling code here:
            lblTipo.setText((String) tblServicios.getValueAt(tblServicios.getSelectedRow(), 0));
            lblServicio.setText((String) tblServicios.getValueAt(tblServicios.getSelectedRow(), 1));
            lblProveedor.setText((String) tblServicios.getValueAt(tblServicios.getSelectedRow(), 2));
            //lblPrecio.setText((String) tblServicios.getValueAt(tblServicios.getSelectedRow(), 2));
            if("Servicio".equals(lblTipo.getText())){
                lblPrecio.setText(String.valueOf(icprov.getDatosServicio(lblServicio.getText(), lblProveedor.getText()).getPrecioServicio()));
            }
            else{
                lblPrecio.setText(String.valueOf(icprom.getDataPromocion(lblServicio.getText(), lblProveedor.getText()).getPrecio()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblServiciosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int numRes = 0;
        if(tblAsociaciones.getModel().getRowCount() == 0){
           JOptionPane.showMessageDialog(this, "No se puede completar la accion, no se ha seleccionado ningun servicio o promocion", "Error", JOptionPane.INFORMATION_MESSAGE);
           
        }
        else{
            try {   
                numRes  = iccli.realizarReserva(LocalDate.now(), Integer.parseInt(lblPrecioTotal.getText()), "Registrada", cmbUsuarios.getSelectedItem().toString());
                iccli.datosAsociadosReserva(numRes, tblAsociaciones.getModel());
                JOptionPane.showMessageDialog(this, "La accion se ha completado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            } 
            catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            limpiar();
        }
        
        
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsociar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecioTotal;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel panelConfirmacion;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelReservas;
    private javax.swing.JSpinner spnCant;
    private javax.swing.JSpinner spnFinAnio;
    private javax.swing.JSpinner spnFinDia;
    private javax.swing.JSpinner spnFinMes;
    private javax.swing.JSpinner spnIniAnio;
    private javax.swing.JSpinner spnIniDia;
    private javax.swing.JSpinner spnIniMes;
    private javax.swing.JTable tblAsociaciones;
    private javax.swing.JTable tblServicios;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        lblServicio.setText("");
        lblProveedor.setText("");
        lblPrecio.setText("");
        lblTipo.setText("");
                
        spnIniDia.setModel(new SpinnerNumberModel(1,1,31,1));
        spnIniMes.setModel(new SpinnerNumberModel(1,1,12,1));
        spnFinDia.setModel(new SpinnerNumberModel(1,1,31,1));
        spnFinMes.setModel(new SpinnerNumberModel(1,1,12,1));
        spnCant.setModel(new SpinnerNumberModel(1,1,99,1));
        Calendar fecha = Calendar.getInstance();
        spnIniAnio.setModel(new SpinnerNumberModel(fecha.get(Calendar.YEAR), fecha.get(Calendar.YEAR), 2099, 1));        
        spnFinAnio.setModel(new SpinnerNumberModel(fecha.get(Calendar.YEAR), fecha.get(Calendar.YEAR), 2099, 1));
        
        tblAsociaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "", "", "", "",
            }
        ));
        
        panelReservas.setVisible(false);
        tblAsociaciones.setVisible(false);
    }
    
     public void llenarcmbClientes(JComboBox combo, ArrayList<DataCliente> datos){
        for(int i = 0; i < datos.size(); i++){
            combo.addItem(datos.get(i).getNickname());
        }
        
    }
}
