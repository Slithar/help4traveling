/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import Logica.ControladorProveedores;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class ifrmAltaServicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmAltaServicio
     */
    private JLabel lblImagen1 = new JLabel();
    private JLabel lblImagen2;
    private JLabel lblImagen3;
    
    private String rutaImagen1 = "";
    private String rutaImagen2 = "";
    private String rutaImagen3 = "";
    
    //private JLabel lblSeleccionado;
    
    private JMenuItem miEliminar1 = new JMenuItem("Eliminar");
    private JMenuItem miEliminar2 = new JMenuItem("Eliminar");
    private JMenuItem miEliminar3 = new JMenuItem("Eliminar");
    
    private JFrame visor;
     
    
    public ifrmAltaServicio() {
        initComponents();
        this.setTitle("Registro de nuevo servicio");
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (750 - tamanioVentana.height)/2);
        
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 25));
        
        ControladorProveedores proveedores = new ControladorProveedores();
        
        //cmbCiudadOrigen.setFont(new Font("Tahoma", 11, Font.PLAIN));
        
        try{
            cargarComboBox(cmbCiudadOrigen, proveedores.getCiudades(), false);
            cargarComboBox(cmbCiudadDestino, proveedores.getCiudades(), true);
            cargarComboBox(cmbProveedor, proveedores.getProveedores(), false);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         
        //lblImagen1.setIcon(new IconImage(get))
        lblImagen1.setSize(143, 143);
        panelImagenes.add(lblImagen1);
        lblImagen1.setLocation(0, 0);
        lblImagen1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        agregarPopup(1);
                    
        setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
        
        lblImagen1.addMouseListener(new OyenteLabel(this));
        
        /*JFrame marco = new JFrame();
        marco.setBounds(515, 200, 900, 600);
        marco.setVisible(true);*/
        /*frmVisor visor = new frmVisor();
        visor.setBounds(515, 200, 900, 600);
        visor.setVisible(true);*/
        
        
        
                
        
    }
    
    public void agregarPopup(int sub){
        if(sub == 1){
            JPopupMenu eliminarImagen1 = new JPopupMenu();            
            miEliminar1.setIcon(new ImageIcon(getClass().getResource("../Presentacion/Imagenes/iconoEliminar.png")));
            miEliminar1.addActionListener(new OyentePopup());
            eliminarImagen1.add(miEliminar1);
            lblImagen1.setComponentPopupMenu(eliminarImagen1);
        }
        else if(sub == 2){
            JPopupMenu eliminarImagen2 = new JPopupMenu();
            //JMenuItem miEliminar2 = new JMenuItem("Eliminar");
            miEliminar2.setIcon(new ImageIcon(getClass().getResource("../Presentacion/Imagenes/iconoEliminar.png")));
            miEliminar2.addActionListener(new OyentePopup());
            eliminarImagen2.add(miEliminar2);
            lblImagen2.setComponentPopupMenu(eliminarImagen2);
        }
        else if(sub == 3){
            JPopupMenu eliminarImagen3 = new JPopupMenu();
            //JMenuItem miEliminar3 = new JMenuItem("Eliminar");
            miEliminar3.setIcon(new ImageIcon(getClass().getResource("../Presentacion/Imagenes/iconoEliminar.png")));
            miEliminar3.addActionListener(new OyentePopup());
            eliminarImagen3.add(miEliminar3);
            lblImagen3.setComponentPopupMenu(eliminarImagen3);
        }
    }
    
    public void cargarComboBox(JComboBox combo, ArrayList datos, boolean opcional){
        for(int i = 0; i < datos.size(); i++){
            combo.addItem(datos.get(i));
        }
        if(opcional){
            combo.addItem("No corresponde");
        }
    }
    
    public void setImagenLabel(String ruta, String tipo){
        //System.out.println("entre");
        JLabel lblImagen = labelActual();
        if(tipo.equals("defecto")){
            ImageIcon imagenPerfil = new ImageIcon(getClass().getResource(ruta));
            ImageIcon imagenDimensionada = new ImageIcon(imagenPerfil.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(imagenDimensionada);
        }
        else{
            ImageIcon imagenPerfil = new ImageIcon(ruta);
            ImageIcon imagenDimensionada = new ImageIcon(imagenPerfil.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(imagenDimensionada);
            
            if(lblImagen == lblImagen1){
                //System.out.println("2");
                rutaImagen1 = ruta;
                lblImagen2 = new JLabel();
                lblImagen2.setSize(143, 143);
                panelImagenes.add(lblImagen2);
                lblImagen2.setLocation(190, 0);
                lblImagen2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblImagen2.addMouseListener(new OyenteLabel(this));
                setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                //lblImagen2.setComponentPopupMenu(eliminarImagen1);
                agregarPopup(2);
            }
            else if(lblImagen == lblImagen2){
                //System.out.println("3");
                rutaImagen2 = ruta;
                lblImagen3 = new JLabel();
                lblImagen3.setSize(143, 143);
                panelImagenes.add(lblImagen3);
                lblImagen3.setLocation(380, 0);
                lblImagen3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblImagen3.addMouseListener(new OyenteLabel(this));
                setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                //lblImagen3.setComponentPopupMenu(eliminarImagen2);
                agregarPopup(3);
            }
            else{
                rutaImagen3 = ruta;
            }
        }       
    }
    
    public boolean cambioValido(JLabel label){
        if(label == lblImagen1){
            if(rutaImagen1 == "")
                return true;
            else
                return false;
        }
        else if(label == lblImagen2){
            if(rutaImagen2 == "")
                return true;
            else
                return false;
        }
        else{
            if(rutaImagen3 == "")
                return true;
            else
                return false;
        }
    }
    
    public JLabel labelActual(){
        
        if(lblImagen2 == null){
            return lblImagen1;
        }
        else if(lblImagen3 == null)
            return lblImagen2;
        else
            return lblImagen3;
    }
    
    private class OyenteLabel implements MouseListener{
        
        private JLabel lblImagen;
        private ifrmAltaServicio vAltaServicio;
        
        public OyenteLabel(ifrmAltaServicio ifrm){
            this.vAltaServicio = ifrm;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
                if(cambioValido((JLabel) e.getSource())){
                    fchImagenes selectorImagen = new fchImagenes(vAltaServicio);
                    selectorImagen.setVisible(true);
                }
                else{
                    if((JLabel) e.getSource() == lblImagen1)
                        visor = new JFrame(rutaImagen1);
                    
                    //visor.setUndecorated(true);
                    visor.setBackground(Color.WHITE);
                    visor.setBounds(515, 200, 900, 600);
                    visor.setVisible(true);
                }
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
    }
    
    private class OyentePopup implements ActionListener{
        
        private JLabel lblImagen;
        
        public OyentePopup(){
            //lblImagen = lbl;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(labelSeleccionado);
            //JOptionPane.showMessageDialog(null, e.getSource());
            if(e.getSource() == miEliminar1 && rutaImagen1 != ""){
                
                if(rutaImagen2 == ""){
                    lblImagen2.setVisible(false);
                    lblImagen2 = null;
                    
                    setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                    rutaImagen1 = "";
                }
                else if(rutaImagen2 != "" && rutaImagen3 == ""){
                    lblImagen3.setVisible(false);
                    lblImagen3 = null;
                    
                    lblImagen2.setVisible(false);
                    lblImagen2 = null;
                    
                    setImagenLabel(rutaImagen2, "absoluta");
                                                          
                    setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                    
                    rutaImagen1 = rutaImagen2;
                    rutaImagen2 = "";                   
                }
                else if(rutaImagen3 != ""){
                    lblImagen3.setVisible(false);
                    lblImagen3 = null;
                    
                    lblImagen2.setVisible(false);
                    lblImagen2 = null;
                    
                    setImagenLabel(rutaImagen2, "absoluta");
                    
                    setImagenLabel(rutaImagen3, "absoluta");
                    
                    setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                    
                    rutaImagen1 = rutaImagen2;
                    rutaImagen2 = rutaImagen3;
                    rutaImagen3 = "";                    
                }                
            }
            else if(e.getSource() == miEliminar2 && rutaImagen2 != ""){
                
                if(rutaImagen3 == ""){
                    lblImagen3.setVisible(false);
                    lblImagen3 = null;
                    
                    setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                    rutaImagen2 = "";
                }
                
                else if(rutaImagen3 != ""){
                    lblImagen3.setVisible(false);
                    lblImagen3 = null;
                    
                    setImagenLabel(rutaImagen3, "absoluta");
                    rutaImagen2 = rutaImagen3;
                    rutaImagen3 = "";
                }
            }
            else if(e.getSource() == miEliminar3 && rutaImagen3 != ""){
                setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                rutaImagen3 = "";
            }
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

        jPanel1 = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        lblEmpresa = new javax.swing.JLabel();
        lblSitioWeb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDescripcion = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        cmbCiudadOrigen = new javax.swing.JComboBox<>();
        lblSitioWeb1 = new javax.swing.JLabel();
        cmbCiudadDestino = new javax.swing.JComboBox<>();
        lblSitioWeb2 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        panelBotones = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelImagenes = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nombre del servicio:");

        txtNickname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmpresa.setText("Imágenes:");

        lblSitioWeb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSitioWeb.setText("Ciudad orígen:");

        areaDescripcion.setColumns(20);
        areaDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setRows(5);
        jScrollPane1.setViewportView(areaDescripcion);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Descripción:");

        cmbCiudadOrigen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblSitioWeb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSitioWeb1.setText("Ciudad destino:");

        cmbCiudadDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblSitioWeb2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSitioWeb2.setText("Proveedor:");

        cmbProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Categorías:");

        jScrollPane3.setViewportView(jTree1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setPreferredSize(new java.awt.Dimension(95, 26));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.setPreferredSize(new java.awt.Dimension(95, 26));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImagenesLayout = new javax.swing.GroupLayout(panelImagenes);
        panelImagenes.setLayout(panelImagenesLayout);
        panelImagenesLayout.setHorizontalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );
        panelImagenesLayout.setVerticalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblSitioWeb2)
                                .addGap(112, 112, 112)
                                .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(52, 52, 52)
                                .addComponent(txtNickname))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(lblSitioWeb)
                                .addGap(90, 90, 90)
                                .addComponent(cmbCiudadOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(lblSitioWeb1)
                                .addGap(83, 83, 83)
                                .addComponent(cmbCiudadDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(panelImagenes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)))
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(34, 34, 34))
            .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lblEmpresa)
                        .addGap(18, 18, 18)
                        .addComponent(panelImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSitioWeb)
                            .addComponent(cmbCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSitioWeb1)
                            .addComponent(cmbCiudadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSitioWeb2)
                            .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelDatos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescripcion;
    private javax.swing.JComboBox<String> cmbCiudadDestino;
    private javax.swing.JComboBox<String> cmbCiudadOrigen;
    private javax.swing.JComboBox<String> cmbProveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblSitioWeb;
    private javax.swing.JLabel lblSitioWeb1;
    private javax.swing.JLabel lblSitioWeb2;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JTextField txtNickname;
    // End of variables declaration//GEN-END:variables
}
