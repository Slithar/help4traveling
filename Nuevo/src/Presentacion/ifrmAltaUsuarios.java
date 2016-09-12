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
import Logica.*;
import java.awt.event.MouseEvent;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import org.apache.commons.codec.binary.Base64;

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
    private IControladorClientes iccli;
    
    public ifrmAltaUsuarios() {        
        initComponents();               
    }
    
    public ifrmAltaUsuarios(IControladorClientes iccli) {
        setTitle("Registro de clientes");
        
        initComponents();
        
        
        panelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        lblImagenPerfil.setSize(200, 200); 
        
        limpiar();
        
        this.iccli = iccli;
        
        //txtPass.set
        txtSeguridad.setText("Protección baja");
        txtSeguridad.setForeground(Color.RED);
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
    
    
    
    public void limpiar(){
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (650 - tamanioVentana.height)/2);
        
        txtNickname.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        spnDia.setModel(new SpinnerNumberModel(1,1,31,1)); //(valor por defecto, mínimo, máximo, orden incremental)
        spnMes.setModel(new SpinnerNumberModel(1,1,12,1));
        Calendar fecha = Calendar.getInstance();
        spnAnio.setModel(new SpinnerNumberModel(fecha.get(Calendar.YEAR), 1900, fecha.get(Calendar.YEAR), 1));
        setImagenPerfil("../Logica/perfiles/perfil.PNG", "defecto");
        setRutaImagen("src/Logica/perfiles/perfil.PNG");
        txtPass.setText("");
        txtRePass.setText("");
        
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
        jLabel3 = new javax.swing.JLabel();
        spnMes = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spnAnio = new javax.swing.JSpinner();
        panelPerfil = new javax.swing.JPanel();
        lblImagenPerfil = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSeguridad = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtRePass = new javax.swing.JPasswordField();
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
        setIconifiable(true);
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("/");

        spnMes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("/");

        spnAnio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblImagenPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImagenPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenPerfilMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPerfilLayout = new javax.swing.GroupLayout(panelPerfil);
        panelPerfil.setLayout(panelPerfilLayout);
        panelPerfilLayout.setHorizontalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelPerfilLayout.setVerticalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblImagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Contraseña:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Confirmar contraseña:");

        txtSeguridad.setText("Pass");

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel1)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
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
                            .addComponent(txtPass)
                            .addComponent(txtRePass)))
                    .addComponent(txtSeguridad))
                .addGap(75, 75, 75)
                .addComponent(panelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtSeguridad)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(panelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
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
            .addGroup(panelSurLayout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        panelSurLayout.setVerticalGroup(
            panelSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSurLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(panelSur, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lblImagenPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenPerfilMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1){
            fchImagenes selectorImagen = new fchImagenes(this);
            selectorImagen.setVisible(true);
        }
       
    }//GEN-LAST:event_lblImagenPerfilMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        boolean imagenCorrecta = false;
        LocalDate fechaNac;
               
        if(txtNickname.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado el nickname del nuevo cliente", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtNickname.requestFocus();
        }
        else if(txtNombre.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado el nombre del nuevo cliente", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
        }
        else if(txtApellido.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado el apellido del nuevo cliente", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtApellido.requestFocus();
        }
        else if(txtCorreo.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado el correo electrónico del nuevo cliente", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtCorreo.requestFocus();
        }
        else if(txtPass.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado contraseña para el nuevo usuario", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtPass.requestFocus();
        }
        else if(txtRePass.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "No se ha ingresado confirmación de contraseña para el nuevo usuario", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtRePass.requestFocus();
        }
        else if(!txtPass.getText().equals(txtRePass.getText())){
            JOptionPane.showMessageDialog(this, "La contraseña ingresada no coincide con su confirmación", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            txtPass.requestFocus();
        }
        else{
            boolean fechaValida = false;
                    
            try{
                LocalDate.of((Integer) spnAnio.getValue(), (Integer) spnMes.getValue(), (Integer) spnDia.getValue());
                fechaValida = true;
            }
            catch(DateTimeException ex){
                JOptionPane.showMessageDialog(this, "El fomato de la fecha de nacimiento ingresada para el nuevo cliente es inválida", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                fechaValida = false;
            }
            
            if(fechaValida){
                fechaNac = LocalDate.of((Integer) spnAnio.getValue(), (Integer) spnMes.getValue(), (Integer) spnDia.getValue());
                
                if(!iccli.correoValido(txtCorreo.getText())){
                       JOptionPane.showMessageDialog(this, "El formato del correo electrónico ingresado no es válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                       txtCorreo.requestFocus();
                    }
                    else{

                        try{
                            if(iccli.existeNickname(txtNickname.getText())){
                                JOptionPane.showMessageDialog(this, "El nickname ingresado ya se encuentra en uso", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                txtNickname.requestFocus();
                            }                            
                            else if(iccli.existeCorreo(txtCorreo.getText())){
                                JOptionPane.showMessageDialog(this, "El correo electrónico ingresado ya se encuentra en uso", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                txtCorreo.requestFocus();
                            }
                            else{
                                if(this.rutaImagen != "src/Logica/perfiles/perfil.PNG"){
                                    imagenCorrecta = iccli.copiarPerfil(txtNickname.getText(), rutaImagen);
                                    this.rutaImagen = "src/Logica/perfiles/" + txtNickname.getText() + ".jpg";
                                }
                                else
                                    imagenCorrecta = true;
                                if(imagenCorrecta){
                                    iccli.agregarCliente(txtNickname.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), fechaNac , rutaImagen, iccli.encriptar(txtPass.getText()));
                                    JOptionPane.showMessageDialog(this, "El nuevo cliente ha sido agregado de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
                                    limpiar();
                                }
                            }
                        }
                        catch(SQLException ex){                            
                            JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                            //JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(ClassNotFoundException ex){
                            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(this, "No se ha podido agregar imagen de perfil", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                            lblImagenPerfil.requestFocus();
                        }
                    }
                /**/
            }                       
        }        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        limpiar();
    }//GEN-LAST:event_formInternalFrameClosed

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        if(txtPass.getText().length() < 5){
            txtSeguridad.setText("Protección baja");
            txtSeguridad.setForeground(Color.RED);
        }
        else if(txtPass.getText().length() > 4 &&  txtPass.getText().length() < 8){
            txtSeguridad.setText("Protección intermedia");
            txtSeguridad.setForeground(Color.ORANGE);
        }
        else{
            txtSeguridad.setText("Segura");
            txtSeguridad.setForeground(Color.GREEN.darker());
        }
            
    }//GEN-LAST:event_txtPassKeyTyped
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImagenPerfil;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JPanel panelSur;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JSpinner spnMes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtRePass;
    private javax.swing.JLabel txtSeguridad;
    // End of variables declaration//GEN-END:variables
}
