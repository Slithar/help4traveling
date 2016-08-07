/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import Logica.Usuario;
import Logica.Cliente;
import Logica.Proveedor;
import Logica.ControladorClientes;
import Logica.ControladorProveedores;
//import javax.swing.filechooser.*;

/**
 *
 * @author usuario
 */
public class ifrmAltaUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmAltaUsuarios
     */
    
    private String rutaImagen = "";
    private Usuario nuevoUsuario;
    private ControladorClientes clientesHandler = new ControladorClientes();
    private ControladorProveedores proveedoresHandler = new ControladorProveedores();
    
    public ifrmAltaUsuarios(frmMenuPrincipal menuPrincipal) {
        setTitle("Registro de usuarios");
        
        initComponents();
        
        
        panelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        aparecerDatosProveedor(false);
        lblImagenPerfil.setSize(200, 200);
        
        
        
        limpiar();
        
    }
    
    public void setImagenPerfil(String ruta, String tipo){
        if(tipo.equals("defecto")){
            ImageIcon imagenPerfil = new ImageIcon(getClass().getResource(ruta));
            ImageIcon imagenDimensionada = new ImageIcon(imagenPerfil.getImage().getScaledInstance(lblImagenPerfil.getWidth(), lblImagenPerfil.getHeight(), Image.SCALE_DEFAULT));
            lblImagenPerfil.setIcon(imagenDimensionada);
        }
        else{
            ImageIcon imagenPerfil = new ImageIcon(ruta);
            ImageIcon imagenDimensionada = new ImageIcon(imagenPerfil.getImage().getScaledInstance(lblImagenPerfil.getWidth(), lblImagenPerfil.getHeight(), Image.SCALE_DEFAULT));
            lblImagenPerfil.setIcon(imagenDimensionada);    
        }
        
    }
    
    public void setRutaImagen(String r){
        this.rutaImagen = r;
    }
    
    public void aparecerDatosProveedor(boolean b){
        lblEmpresa.setVisible(b);
        lblSitioWeb.setVisible(b);
        txtEmpresa.setVisible(b);
        txtSitioWeb.setVisible(b);
    }
    
    public void limpiar(){
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (650 - tamanioVentana.height)/2);
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(new String[]{"Cliente", "Proveedor"});
        cmbTipoUsuario.setModel(modelo);
        /*if(cmbTipoUsuario)
        cmbTipoUsuario.addItem("Cliente");
        cmbTipoUsuario.addItem("Proveedor");*/
        //cmbTipoUsuario.
        
        txtNickname.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        spnDia.setModel(new SpinnerNumberModel(1,1,31,1));
        spnMes.setModel(new SpinnerNumberModel(1,1,12,1));
        Calendar fecha = Calendar.getInstance();
        spnAnio.setModel(new SpinnerNumberModel(fecha.get(Calendar.YEAR), 1900, fecha.get(Calendar.YEAR), 1));
        cmbTipoUsuario.setSelectedItem("Cliente");
        txtEmpresa.setText("");
        txtSitioWeb.setText("");
        aparecerDatosProveedor(false);
        setImagenPerfil("perfiles/perfil.PNG", "defecto");
        setRutaImagen("perfiles/perfil.PNG");
        
        txtNickname.requestFocus();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        spnDia = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spnMes = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spnAnio = new javax.swing.JSpinner();
        lblEmpresa = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        lblSitioWeb = new javax.swing.JLabel();
        txtSitioWeb = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblImagenPerfil = new javax.swing.JLabel();
        panelSur = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nickname:");

        txtNickname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Nombre:");

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Apellido:");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Correo electrónico:");

        spnDia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Fecha de nacimiento:");

        cmbTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tipo de usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("/");

        spnMes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("/");

        spnAnio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmpresa.setText("Nombre de empresa:");

        lblSitioWeb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSitioWeb.setText("Sitio web:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Foto de perfil:");

        lblImagenPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImagenPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenPerfilMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblImagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lblEmpresa)
                    .addComponent(lblSitioWeb))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNickname)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtCorreo)
                    .addComponent(cmbTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmpresa)
                    .addComponent(txtSitioWeb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmpresa)
                            .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSitioWeb)
                    .addComponent(txtSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSurLayout = new javax.swing.GroupLayout(panelSur);
        panelSur.setLayout(panelSurLayout);
        panelSurLayout.setHorizontalGroup(
            panelSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSurLayout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
        );
        panelSurLayout.setVerticalGroup(
            panelSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSurLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(panelSur, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoUsuarioActionPerformed
        // TODO add your handling code here:
        if(cmbTipoUsuario.getSelectedItem() == "Cliente")
            aparecerDatosProveedor(false);
        else{
            aparecerDatosProveedor(true);
            txtEmpresa.requestFocus();
        }
    }//GEN-LAST:event_cmbTipoUsuarioActionPerformed

    private void lblImagenPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenPerfilMouseClicked
        fchImagenes selectorImagen = new fchImagenes(this);
        selectorImagen.setVisible(true);
       
    }//GEN-LAST:event_lblImagenPerfilMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //System.out.println(spnAnio.getValue());
        boolean imagenCorrecta = false;
        
        if(txtNickname.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado el nickname del nuevo usuario", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtNickname.requestFocus();
        }
        else if(txtNombre.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado el nombre del nuevo usuario", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
        }
        else if(txtApellido.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado el apellido del nuevo usuario", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtApellido.requestFocus();
        }
        else if(txtCorreo.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado el correo electrónico del nuevo usuario", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtCorreo.requestFocus();
        }
        else{
            String fechaNac = spnAnio.getValue() + "-" + spnMes.getValue() + "-" + spnDia.getValue();
        
            if(cmbTipoUsuario.getSelectedItem() == "Proveedor"){
                
                if(txtEmpresa.getText().length() == 0){
                    JOptionPane.showMessageDialog(this, "No se ha ingresado el nombre de empresa del proveedor", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    txtEmpresa.requestFocus();
                }
                else if(txtSitioWeb.getText().length() == 0){
                    JOptionPane.showMessageDialog(this, "No se ha ingresado el link al sitio web del proveedor", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    txtSitioWeb.requestFocus();
                }


                //Date fechaNac = new Date(spnAnio.getValue(), spnMes.getValue(), spnDia.getValue());
                nuevoUsuario = new Proveedor(txtNickname.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), fechaNac , rutaImagen, txtEmpresa.getText(), txtSitioWeb.getText());
                if(!nuevoUsuario.correoValido()){
                   JOptionPane.showMessageDialog(this, "El formato del correo electrónico ingresado no es válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                   txtCorreo.requestFocus();
                }
                else if(!nuevoUsuario.fechaValida()){
                    JOptionPane.showMessageDialog(this, "El formato de la fecha de nacimiento ingresada para el nuevo usuario no es válida", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    spnAnio.requestFocus();
                }
                else{
                    
                    try{
                        
                        if(this.rutaImagen != "perfiles/perfil.PNG")
                            imagenCorrecta = nuevoUsuario.copiarPerfil();
                        else
                            imagenCorrecta = true;
                        
                    }
                    catch(IOException ex){
                        JOptionPane.showMessageDialog(this, "No se ha podido agregar imagen de perfil", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        lblImagenPerfil.requestFocus();
                    }
                    if(imagenCorrecta){
                        
                        try{
                           if(proveedoresHandler.existeNickname(nuevoUsuario)){
                                JOptionPane.showMessageDialog(this, "El nickname ingresado ya se encuentra en uso", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                txtNickname.requestFocus();
                            }
                           else{
                                if(proveedoresHandler.existeNombreEmpresa((Proveedor) nuevoUsuario)){
                                    JOptionPane.showMessageDialog(this, "El nombre de emprsa ingresado ya se encuentra en uso", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                    txtEmpresa.requestFocus();
                                }
                                else{
                                    proveedoresHandler.agregarProveedor((Proveedor) nuevoUsuario);
                                    JOptionPane.showMessageDialog(this, "El nuevo usuario ha sido agregado de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
                                    limpiar();  
                                }
                           }
                        }
                        catch(SQLException ex){
                            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                            JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                            //JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(ClassNotFoundException ex){
                            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                }
            }
            else{
                nuevoUsuario = new Cliente(txtNickname.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), fechaNac , rutaImagen, new ArrayList());

                if(!nuevoUsuario.correoValido()){
                   JOptionPane.showMessageDialog(this, "El formato del correo electrónico ingresado no es válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                   txtCorreo.requestFocus();
                }
                else if(!nuevoUsuario.fechaValida()){
                    JOptionPane.showMessageDialog(this, "El formato de la fecha de nacimiento ingresada para el nuevo usuario no es válida", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    spnAnio.requestFocus();
                }
                else{
                    try{
                        if(this.rutaImagen != "perfiles/perfil.PNG")
                            imagenCorrecta = nuevoUsuario.copiarPerfil();
                        else
                            imagenCorrecta = true;
                    }
                    catch(IOException ex){
                        JOptionPane.showMessageDialog(this, "No se ha podido agregar imagen de perfil", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        lblImagenPerfil.requestFocus();
                    }
                    if(imagenCorrecta){
                        
                        try{
                           if(clientesHandler.existeNickname((Cliente) nuevoUsuario)){
                                JOptionPane.showMessageDialog(this, "El nickname ingresado ya se encuentra en uso", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                txtNickname.requestFocus();
                            }
                           else{
                                clientesHandler.agregarCliente(nuevoUsuario);
                                JOptionPane.showMessageDialog(this, "El nuevo usuario ha sido agregado de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
                                limpiar();
                           }
                        }
                        catch(SQLException ex){
                            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                            JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(ClassNotFoundException ex){
                            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                }
            }
        }        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        limpiar();
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblImagenPerfil;
    private javax.swing.JLabel lblSitioWeb;
    private javax.swing.JPanel panelSur;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JSpinner spnMes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSitioWeb;
    // End of variables declaration//GEN-END:variables
}
