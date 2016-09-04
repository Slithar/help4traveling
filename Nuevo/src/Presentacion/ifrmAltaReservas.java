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
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
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
    
    private int precioTotal= 0;
    
    public ifrmAltaReservas() {
        initComponents();
    }

    ifrmAltaReservas(IControladorProveedores icprov, IControladorClientes iccli, IControladorPromociones icprom){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        initComponents();
    
        setTitle("Nueva reserva");
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (800 - tamanioVentana.height)/2);
        panelGeneral.setVisible(true);
        panelDatos.setVisible(true);
        panelReservas.setVisible(false);
        btnCancelar.setVisible(true);

        lblAgregarProducto.setSize(38, 38);
        
        ImageIcon iconoProducto = new ImageIcon(getClass().getResource("Imagenes/iconoAgregarCategoria.png"));
        ImageIcon iconoDimensionado = new ImageIcon(iconoProducto.getImage().getScaledInstance(lblAgregarProducto.getWidth(), lblAgregarProducto.getHeight(), Image.SCALE_DEFAULT));
        lblAgregarProducto.setIcon(iconoDimensionado);
        
        lblAgregarReserva.setSize(49, 46);
        
        ImageIcon iconoReserva = new ImageIcon(getClass().getResource("Imagenes/iconoAgregarReserva.png"));
        ImageIcon iconoRDimensionado = new ImageIcon(iconoReserva.getImage().getScaledInstance(lblAgregarReserva.getWidth(), lblAgregarReserva.getHeight(), Image.SCALE_DEFAULT));
        lblAgregarReserva.setIcon(iconoRDimensionado);
        
        panelSeleccionado.setBorder(BorderFactory.createTitledBorder("Servicio/Promoción seleccionado"));
        
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
                
                modeloServ.addRow(new Object[]{"SERVICIO", DatasServicios.get(i).getNombreServicio(), DatasServicios.get(i).getNombreProveedor(), icprov.getDatosServicio(DatasServicios.get(i).getNombreServicio(), DatasServicios.get(i).getNombreProveedor()).getPrecioServicio()});
            
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
                
                    //String proveedor = icprom.getServiciosPorPromocion(DatasPromociones.get(i).getNombre()).get(0).getNombreProveedor();
                    modeloServ.addRow(new Object[] {"PROMOCIÓN", DatasPromociones.get(i).getNombre(), DatasPromociones.get(i).getProveedor() ,DatasPromociones.get(i).getPrecio() });
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
        panelConfirmacion = new javax.swing.JPanel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblAgregarProducto = new javax.swing.JLabel();
        panelSeleccionado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spnCant = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        spnIniDia = new javax.swing.JSpinner();
        spnIniMes = new javax.swing.JSpinner();
        spnIniAnio = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        spnFinDia = new javax.swing.JSpinner();
        spnFinMes = new javax.swing.JSpinner();
        spnFinAnio = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblAgregarReserva = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);

        tblAsociaciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblAsociaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblAsociaciones);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Servicio y promociones asociados:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cliente:");

        cmbUsuarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuariosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Precio total: U$S");

        lblPrecioTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrecioTotal.setText("0");

        javax.swing.GroupLayout panelReservasLayout = new javax.swing.GroupLayout(panelReservas);
        panelReservas.setLayout(panelReservasLayout);
        panelReservasLayout.setHorizontalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReservasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(cmbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        panelReservasLayout.setVerticalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
            .addGroup(panelConfirmacionLayout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelConfirmacionLayout.setVerticalGroup(
            panelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfirmacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar)))
        );

        tblServicios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione servicio o promoción a asociar a la reserva:");

        lblAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarProductoMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre: ");

        lblServicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblServicio.setText("No seleccionado");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Proveedor:");

        lblProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProveedor.setText("No seleccionado");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Precio: U$S");

        lblPrecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrecio.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Cantidad:");

        spnCant.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Fecha de incio:");

        spnIniDia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        spnIniMes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        spnIniAnio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Fecha de fin:");

        spnFinDia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        spnFinMes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        spnFinAnio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tipo:");

        lblTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTipo.setText("No seleccionado");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("/");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("/");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("/");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("/");

        lblAgregarReserva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAgregarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregarReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarReservaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSeleccionadoLayout = new javax.swing.GroupLayout(panelSeleccionado);
        panelSeleccionado.setLayout(panelSeleccionadoLayout);
        panelSeleccionadoLayout.setHorizontalGroup(
            panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTipo))
                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                        .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnIniDia)
                            .addComponent(spnFinDia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                                        .addComponent(spnFinMes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14))
                                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                                        .addComponent(spnIniMes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnFinAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnIniAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblAgregarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelSeleccionadoLayout.setVerticalGroup(
            panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeleccionadoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTipo))
                .addGap(18, 18, 18)
                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(spnCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                        .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(spnIniDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(spnFinDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSeleccionadoLayout.createSequentialGroup()
                        .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnIniAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnIniMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(panelSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnFinMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnFinAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))))
                .addGap(26, 26, 26)
                .addComponent(lblAgregarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelSeleccionado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(lblAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(panelReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(panelConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        getContentPane().add(panelGeneral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsuariosActionPerformed

    private void tblServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiciosMouseClicked
        
    }//GEN-LAST:event_tblServiciosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int numRes = 0;
        if(tblAsociaciones.getModel().getRowCount() == 0){
           JOptionPane.showMessageDialog(this, "No se puede completar la accion, no se ha seleccionado ningun servicio o promocion", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
           
        }
        else if(cmbUsuarios.getSelectedItem().toString() == ""){
            JOptionPane.showMessageDialog(this, "No hay clientes registrados en el sistema", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            try {   
                numRes  = iccli.realizarReserva(LocalDate.now(), Integer.parseInt(lblPrecioTotal.getText()), "REGISTRADA", cmbUsuarios.getSelectedItem().toString());
                iccli.datosAsociadosReserva(numRes, tblAsociaciones.getModel());
                JOptionPane.showMessageDialog(this, "La reserva ha sido agregada de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (SQLException ex) {
                //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            } 
            catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            limpiar();
            lblPrecioTotal.setText("0");
            DefaultTableModel modeloServ = new DefaultTableModel();
            modeloServ.setColumnIdentifiers(new Object[]{"Tipo","Nombre","Proveedor","Precio"});

            DefaultTableModel modeloAsociaciones = new DefaultTableModel();
            modeloAsociaciones.setColumnIdentifiers(new Object[]{""});
            tblAsociaciones.setModel(modeloAsociaciones);

            try{
                ArrayList<DataServicio> DatasServicios = icprov.getServicios();
                for(int i = 0 ; i < DatasServicios.size(); i++){

                    modeloServ.addRow(new Object[]{"SERVICIO", DatasServicios.get(i).getNombreServicio(), DatasServicios.get(i).getNombreProveedor(), icprov.getDatosServicio(DatasServicios.get(i).getNombreServicio(), DatasServicios.get(i).getNombreProveedor()).getPrecioServicio()});

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

                        //String proveedor = icprom.getServiciosPorPromocion(DatasPromociones.get(i).getNombre()).get(0).getNombreProveedor();
                        modeloServ.addRow(new Object[] {"PROMOCIÓN", DatasPromociones.get(i).getNombre(), DatasPromociones.get(i).getProveedor(),DatasPromociones.get(i).getPrecio() });
                }
            }
            catch(SQLException ex){
                    JOptionPane.showMessageDialog(this, "Hay un problema de conexion con la base de datos por los que no fue posible completar la accion", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            catch(ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
        
        }
        
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void lblAgregarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarProductoMouseClicked
        /*if(evt.getButton() == MouseEvent.BUTTON1){
            DefaultListModel modelo = (DefaultListModel) lstCategorias.getModel();
            if(categoriaRepetida(modelo, rutaCategoria)){
                JOptionPane.showMessageDialog(this, "La categoría ya se encuentra agregada para el servicio", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
            else{
                modelo.addElement(rutaCategoria);
            }
            lstCategorias.setModel(modelo);

        }*/
        if(tblServicios.getSelectedRow() > -1){
            try {
                // TODO add your handling code here:
                lblTipo.setText((String) tblServicios.getValueAt(tblServicios.getSelectedRow(), 0));
                lblServicio.setText((String) tblServicios.getValueAt(tblServicios.getSelectedRow(), 1));
                lblProveedor.setText((String) tblServicios.getValueAt(tblServicios.getSelectedRow(), 2));
                //lblPrecio.setText((String) tblServicios.getValueAt(tblServicios.getSelectedRow(), 3));
                if("SERVICIO".equals(lblTipo.getText())){
                    lblPrecio.setText(String.valueOf(icprov.getDatosServicio(lblServicio.getText(), lblProveedor.getText()).getPrecioServicio()));
                }
                else{
                    lblPrecio.setText(String.valueOf(icprom.getDataPromocion(lblServicio.getText(), lblProveedor.getText()).getPrecio()));
                }
                Calendar fecha = Calendar.getInstance();

                spnIniDia.setModel(new SpinnerNumberModel(fecha.get(Calendar.DAY_OF_MONTH),1,31,1));
                spnIniMes.setModel(new SpinnerNumberModel(fecha.get(Calendar.MONTH) + 1,1,12,1));
                spnFinDia.setModel(new SpinnerNumberModel(fecha.get(Calendar.DAY_OF_MONTH),1,31,1));
                spnFinMes.setModel(new SpinnerNumberModel(fecha.get(Calendar.MONTH) + 1,1,12,1));
                spnCant.setModel(new SpinnerNumberModel(1,1,99,1));

                spnIniAnio.setModel(new SpinnerNumberModel(fecha.get(Calendar.YEAR), fecha.get(Calendar.YEAR), 2099, 1));        
                spnFinAnio.setModel(new SpinnerNumberModel(fecha.get(Calendar.YEAR), fecha.get(Calendar.YEAR), 2099, 1));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "No se ha indicado servicio o promoción a asociar", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_lblAgregarProductoMouseClicked

    private void lblAgregarReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarReservaMouseClicked
        lblAgregarReserva.requestFocus();
        boolean ok = true;
        try{
            if(lblServicio.getText() == "No seleccionado" && lblProveedor.getText() == "No seleccionado" && lblPrecio.getText() == "0"){
                ok = false;
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún producto de la lista", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
            else if(LocalDate.now().isAfter(LocalDate.of((Integer) spnIniAnio.getValue(), (Integer) spnIniMes.getValue(),(Integer) spnIniDia.getValue()))){
               ok = false;
               JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser posterior o igual al día de hoy", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
            else if(LocalDate.of((Integer) spnIniAnio.getValue(), (Integer) spnIniMes.getValue(),(Integer) spnIniDia.getValue()).isAfter(LocalDate.of((Integer) spnFinAnio.getValue(), (Integer) spnFinMes.getValue(), (Integer) spnFinDia.getValue()))){
                ok = false;
               JOptionPane.showMessageDialog(this, "La fecha de Inicio debe ser anterior o igual a la fecha de fin", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
            else for(int i = 0; i < tblAsociaciones.getRowCount(); i++){
                if( tblAsociaciones.getValueAt(i,1 ).toString().equals(lblServicio.getText())){
                    ok = false;
                    JOptionPane.showMessageDialog(this, "El producto ingresado ya se encuentra asociado a la reserva", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    break;
                }
                    if(!tblAsociaciones.getValueAt(i, 2).toString().equals(lblProveedor.getText())){
                        ok = false;
                        JOptionPane.showMessageDialog(this, "No se puede asociar a la reserva un producto de distinto proveedor", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        break;
                }
            }
            int cantidad = (Integer) spnCant.getValue();
            int precio = Integer.parseInt(lblPrecio.getText());
            //JOptionPane.showMessageDialog(this, cantidad + " * " + precio);
            if(ok == true){
                JPopupMenu popup = new JPopupMenu();
                JMenuItem miEliminar = new JMenuItem("Eliminar");
                miEliminar.setIcon(new ImageIcon(getClass().getResource("Imagenes/iconoEliminar.png")));
                miEliminar.addActionListener(new OyentePopup());
                popup.add(miEliminar);
                tblAsociaciones.setComponentPopupMenu(popup);
                DefaultTableModel modeloAsoc = new DefaultTableModel();
                modeloAsoc = (DefaultTableModel) tblAsociaciones.getModel();
                modeloAsoc.setColumnIdentifiers(new Object[]{ "Tipo", "Nombre", "Proveedor" , "Cantidad", "Precio unitario", "Total línea", "Inicio", "Fin"});
                //modeloAsoc.addRow(new Object[]{ lblTipo.getText() , lblServicio.getText(), lblProveedor.getText() , String.valueOf(spnCant.getValue()), lblPrecio.getText(), String.valueOf(cantidad * precio), LocalDate.of((Integer) spnIniAnio.getValue(), (Integer) spnIniMes.getValue(), (Integer) spnIniDia.getValue()), LocalDate.of((Integer) spnFinAnio.getValue(), (Integer) spnFinMes.getValue(), (Integer) spnFinDia.getValue())});
                modeloAsoc.addRow(new Object[]{ lblTipo.getText() , lblServicio.getText(), lblProveedor.getText() , String.valueOf(spnCant.getValue()), lblPrecio.getText(), String.valueOf(cantidad * precio), spnIniDia.getValue() + "/" + spnIniMes.getValue() + "/" + spnIniAnio.getValue(), spnFinDia.getValue() + "/" + spnFinMes.getValue() + "/" + spnFinAnio.getValue()});
                
                precioTotal += cantidad * precio;
                lblPrecioTotal.setText(String.valueOf(Integer.parseInt(lblPrecioTotal.getText()) + precioTotal));
                precioTotal = 0;
                tblAsociaciones.setModel(modeloAsoc);
                panelGeneral.setVisible(true);
                panelReservas.setVisible(true);
                tblAsociaciones.setVisible(true);
                //limpiar();
                lblServicio.setText("No seleccionado");
                lblProveedor.setText("No seleccionado");
                lblPrecio.setText("0");
                lblTipo.setText("No seleccionado");

                Calendar fecha = Calendar.getInstance();

                spnIniDia.setModel(new SpinnerNumberModel(fecha.get(Calendar.DAY_OF_MONTH),1,31,1));
                spnIniMes.setModel(new SpinnerNumberModel(fecha.get(Calendar.MONTH) + 1,1,12,1));
                spnFinDia.setModel(new SpinnerNumberModel(fecha.get(Calendar.DAY_OF_MONTH),1,31,1));
                spnFinMes.setModel(new SpinnerNumberModel(fecha.get(Calendar.MONTH) + 1,1,12,1));
                spnCant.setModel(new SpinnerNumberModel(1,1,99,1));

                spnIniAnio.setModel(new SpinnerNumberModel(fecha.get(Calendar.YEAR), fecha.get(Calendar.YEAR), 2099, 1));        
                spnFinAnio.setModel(new SpinnerNumberModel(fecha.get(Calendar.YEAR), fecha.get(Calendar.YEAR), 2099, 1));
            }
        }
        catch(DateTimeException ex){
                JOptionPane.showMessageDialog(this, "El fomato de la fecha ingresada para la reserva es inválida", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                
        }
        
    }//GEN-LAST:event_lblAgregarReservaMouseClicked
    
    private class OyentePopup implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tblAsociaciones.getSelectedRow() > -1){
                DefaultTableModel modelo = (DefaultTableModel) tblAsociaciones.getModel();
                int precioLinea = Integer.parseInt(tblAsociaciones.getValueAt(tblAsociaciones.getSelectedRow(), 5).toString());
                int precioTotalNuevo = Integer.parseInt(lblPrecioTotal.getText()) - precioLinea;
                lblPrecioTotal.setText(String.valueOf(precioTotalNuevo));
                modelo.removeRow(tblAsociaciones.getSelectedRow());
                if(tblAsociaciones.getModel().getRowCount() == 0){
                    lblPrecioTotal.setText("0");
                    panelReservas.setVisible(false);
                    
                }
                System.out.println(lblPrecioTotal.getText());
            }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cmbUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel lblAgregarProducto;
    private javax.swing.JLabel lblAgregarReserva;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecioTotal;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel panelConfirmacion;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelReservas;
    private javax.swing.JPanel panelSeleccionado;
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
        lblServicio.setText("No seleccionado");
        lblProveedor.setText("No seleccionado");
        lblPrecio.setText("0");
        lblTipo.setText("No seleccionado");
        
        Calendar fecha = Calendar.getInstance();
        
        spnIniDia.setModel(new SpinnerNumberModel(fecha.get(Calendar.DAY_OF_MONTH),1,31,1));
        spnIniMes.setModel(new SpinnerNumberModel(fecha.get(Calendar.MONTH) + 1,1,12,1));
        spnFinDia.setModel(new SpinnerNumberModel(fecha.get(Calendar.DAY_OF_MONTH),1,31,1));
        spnFinMes.setModel(new SpinnerNumberModel(fecha.get(Calendar.MONTH) + 1,1,12,1));
        spnCant.setModel(new SpinnerNumberModel(1,1,99,1));
        
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
