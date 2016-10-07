/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;
import Logica.ControladorProveedores;
import java.sql.SQLException;
import Logica.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    private JMenuItem miEliminar1 = new JMenuItem("Eliminar");
    private JMenuItem miEliminar2 = new JMenuItem("Eliminar");
    private JMenuItem miEliminar3 = new JMenuItem("Eliminar");
    
    private JMenuItem miEliminarCategoria = new JMenuItem("Eliminar");
    
    private String rutaCategoria = "";
    
    private frmVisor visor;
    
    private IControladorProveedores icprov;
    private IControladorCategorias iccat;
     
    
    public ifrmAltaServicio(){
        
    }
    
    public ifrmAltaServicio(IControladorProveedores icprov, IControladorCategorias iccat) {
        initComponents();
        this.icprov = icprov;
        this.iccat = iccat;
        
        this.setTitle("Registro de nuevo servicio");
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (800 - tamanioVentana.height)/2);
        
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 25));
        
        try{
            cargarComboBoxCiudades(cmbCiudadOrigen, icprov.getCiudades(), false);
            cargarComboBoxCiudades(cmbCiudadDestino, icprov.getCiudades(), true);
            cargarComboBoxProveedores(cmbProveedor, icprov.getProveedores(), false);
            llenarArbol("", null);
        }
        catch(SQLException ex){
            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        lblImagen1.setSize(143, 143);
        panelImagenes.add(lblImagen1);
        lblImagen1.setLocation(0, 0);
        lblImagen1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        agregarPopup(1);
                    
        setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
        
        lblImagen1.addMouseListener(new OyenteLabel(this));
        
        
        lblAgregarCategoria.setSize(38, 38);
        
        ImageIcon iconoCategoria = new ImageIcon(getClass().getResource("Imagenes/iconoAgregarCategoria.png"));
        ImageIcon iconoDimensionado = new ImageIcon(iconoCategoria.getImage().getScaledInstance(lblAgregarCategoria.getWidth(), lblAgregarCategoria.getHeight(), Image.SCALE_DEFAULT));
        lblAgregarCategoria.setIcon(iconoDimensionado);
        
        DefaultListModel modeloLista = new DefaultListModel();
        lstCategorias.setModel(modeloLista);
        
        agregarPopup(4);               
    }
    
    public void limpiar(){
        txtNombreServicio.setText("");
        areaDescripcion.setText("");
        txtPrecio.setText("");        
        
        if(lblImagen3 != null){
            lblImagen3.setVisible(false);
            lblImagen3 = null;
            rutaImagen3 = "";
            
            if(lblImagen2 != null){
                lblImagen2.setVisible(false);
                lblImagen2 = null;
                rutaImagen2 = "";
            }
        }
        else if(lblImagen2 != null){
            lblImagen2.setVisible(false);
            lblImagen2 = null;
            rutaImagen2 = ""; 
        }               
        
        rutaImagen1 = "";
        
        setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
               
        txtPrecio.setText("");
        cmbCiudadOrigen.setSelectedIndex(0);
        cmbCiudadDestino.setSelectedIndex(0);
        cmbProveedor.setSelectedIndex(0);
        try{
            llenarArbol("", null);
        }
        catch(SQLException ex){
            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        DefaultListModel modeloLista = new DefaultListModel();
        lstCategorias.setModel(modeloLista);
        
        txtNombreServicio.requestFocus();
        
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
            miEliminar2.setIcon(new ImageIcon(getClass().getResource("../Presentacion/Imagenes/iconoEliminar.png")));
            miEliminar2.addActionListener(new OyentePopup());
            eliminarImagen2.add(miEliminar2);
            lblImagen2.setComponentPopupMenu(eliminarImagen2);
        }
        else if(sub == 3){
            JPopupMenu eliminarImagen3 = new JPopupMenu();
            miEliminar3.setIcon(new ImageIcon(getClass().getResource("../Presentacion/Imagenes/iconoEliminar.png")));
            miEliminar3.addActionListener(new OyentePopup());
            eliminarImagen3.add(miEliminar3);
            lblImagen3.setComponentPopupMenu(eliminarImagen3);
        }
        else if(sub == 4){
            JPopupMenu eliminarCategoria = new JPopupMenu();
            miEliminarCategoria.setIcon(new ImageIcon(getClass().getResource("../Presentacion/Imagenes/iconoEliminar.png")));
            miEliminarCategoria.addActionListener(new OyentePopup());
            eliminarCategoria.add(miEliminarCategoria);
            lstCategorias.setComponentPopupMenu(eliminarCategoria);
        }
    }
    
    public void cargarComboBoxCiudades(JComboBox combo, ArrayList<DataCiudad> datos, boolean opcional){
        for(int i = 0; i < datos.size(); i++){
            combo.addItem(datos.get(i).getNombre() + ", " + datos.get(i).getPais());
        }
        if(opcional){
            combo.addItem("No corresponde");
        }
    }
    
    public void cargarComboBoxProveedores(JComboBox combo, ArrayList<DataProveedor> datos, boolean opcional){
        for(int i = 0; i < datos.size(); i++){
            combo.addItem(datos.get(i).getNickname() + " <" + datos.get(i).getNombreEmpresa() + ">");
        }
        if(opcional){
            combo.addItem("No corresponde");
        }
    }
    
    public void setImagenLabel(String ruta, String tipo){
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
                rutaImagen1 = ruta;
                lblImagen2 = new JLabel();
                lblImagen2.setSize(143, 143);
                panelImagenes.add(lblImagen2);
                lblImagen2.setLocation(190, 0);
                lblImagen2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblImagen2.addMouseListener(new OyenteLabel(this));
                setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                agregarPopup(2);
            }
            else if(lblImagen == lblImagen2){
                rutaImagen2 = ruta;
                lblImagen3 = new JLabel();
                lblImagen3.setSize(143, 143);
                panelImagenes.add(lblImagen3);
                lblImagen3.setLocation(380, 0);
                lblImagen3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblImagen3.addMouseListener(new OyenteLabel(this));
                setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
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
                        visor = new frmVisor(rutaImagen1);
                    else if((JLabel) e.getSource() == lblImagen2)
                        visor = new frmVisor(rutaImagen2);
                    else if((JLabel) e.getSource() == lblImagen3)
                        visor = new frmVisor(rutaImagen3);
                    
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
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
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

                        //setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");

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

                        //setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");

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
                else if(e.getSource() == miEliminarCategoria){
                    if(lstCategorias.getSelectedIndex() > -1){
                        DefaultListModel modelo = (DefaultListModel) lstCategorias.getModel();
                        modelo.remove(lstCategorias.getSelectedIndex());
                        lstCategorias.setModel(modelo);
                    }
                    
                }
        }
            
        
    }
    
    public void llenarArbol(String padre, DefaultMutableTreeNode nodoPadre) throws SQLException, ClassNotFoundException{
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorías disponibles");
        if(padre == ""){
            ArrayList<DataCategoria> categoriasPadres = iccat.getCategoriasPadres();
            for(int i = 0; i < categoriasPadres.size(); i++){
                DefaultMutableTreeNode nodosSuperiores = new DefaultMutableTreeNode(categoriasPadres.get(i).getNombre());
                root.add(nodosSuperiores);
                llenarArbol((String) categoriasPadres.get(i).getNombre(), nodosSuperiores);
            }
        }
        else{
            ArrayList<DataCategoria> categoriasHijas = iccat.getCategoriasHijas(padre);
            for(int i = 0; i < categoriasHijas.size(); i++){
                DefaultMutableTreeNode nodosSuperiores = new DefaultMutableTreeNode(categoriasHijas.get(i).getNombre());
                nodoPadre.add(nodosSuperiores);
                llenarArbol(categoriasHijas.get(i).getNombre(), nodosSuperiores);
            }
        }
        
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        treeCategorias.setModel(treeModel);
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
        txtPrecio = new javax.swing.JTextField();
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
        treeCategorias = new javax.swing.JTree();
        panelBotones = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelImagenes = new javax.swing.JPanel();
        lblEmpresa1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        lblAgregarCategoria = new javax.swing.JLabel();
        lblSitioWeb3 = new javax.swing.JLabel();
        txtNombreServicio = new javax.swing.JTextField();

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
        setIconifiable(true);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nombre del servicio:");

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmpresa.setText("Imágenes:");

        lblSitioWeb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSitioWeb.setText("Ciudad orígen:");

        areaDescripcion.setColumns(20);
        areaDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setRows(5);
        areaDescripcion.setWrapStyleWord(true);
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

        treeCategorias.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeCategoriasValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(treeCategorias);

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
                .addGap(256, 256, 256)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelImagenesLayout.setVerticalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        lblEmpresa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmpresa1.setText("Categorías seleccionadas:");

        lstCategorias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(lstCategorias);

        lblAgregarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarCategoriaMouseClicked(evt);
            }
        });

        lblSitioWeb3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSitioWeb3.setText("Precio (En U$S):");

        txtNombreServicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSitioWeb)
                            .addComponent(lblSitioWeb3))
                        .addGap(81, 81, 81)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(cmbCiudadOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblSitioWeb2)
                                .addGap(112, 112, 112)
                                .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(lblSitioWeb1)
                                .addGap(83, 83, 83)
                                .addComponent(cmbCiudadDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelImagenes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpresa1)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(lblAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
            .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(txtNombreServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lblEmpresa)
                        .addGap(18, 18, 18)
                        .addComponent(panelImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblEmpresa1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSitioWeb3)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSitioWeb)
                            .addComponent(cmbCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSitioWeb1)
                            .addComponent(cmbCiudadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSitioWeb2)
                            .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelDatos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cmbProveedor.getModel().getSize() == 0){
            JOptionPane.showMessageDialog(this, "No hay proveedores cargados en el sistema", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else if(cmbCiudadOrigen.getModel().getSize() == 0){
            JOptionPane.showMessageDialog(this, "No hay ciudades cargadas en el sistema", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            DefaultListModel modelo = (DefaultListModel) lstCategorias.getModel();
            if(txtNombreServicio.getText().equals("")){
                JOptionPane.showMessageDialog(this, "No se ha ingresado el nombre del nuevo servicio", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                txtNombreServicio.requestFocus();
            }
            else if(areaDescripcion.getText().equals("")){
                JOptionPane.showMessageDialog(this, "No se ha ingresado la descripción del nuevo servicio", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                areaDescripcion.requestFocus();
            }
            else if(txtPrecio.getText().equals("")){
                JOptionPane.showMessageDialog(this, "No se ha ingresado el precio del nuevo servicio", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                txtPrecio.requestFocus();
            }
            else if(!esNumerico(txtPrecio.getText())){
                JOptionPane.showMessageDialog(this, "El precio ingresado para el nuevo servicio presenta un formato no válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                txtPrecio.requestFocus();
            }
            else if(Integer.parseInt(txtPrecio.getText()) < 0){
                JOptionPane.showMessageDialog(this, "El precio ingresado no puede ser negativo", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                txtPrecio.requestFocus();
            }
            else if(cmbCiudadOrigen.getSelectedItem().equals(cmbCiudadDestino.getSelectedItem())){
                JOptionPane.showMessageDialog(this, "La ciudad de orígen no puede ser la misma que la ciudad destino", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                cmbCiudadOrigen.requestFocus();
            }
            else{

                if(modelo.getSize() == 0){
                   JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna categoría para el nuevo servicio", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE); 
                }
                else{
                    try {
                        if(icprov.existeNombreServicio(txtNombreServicio.getText(), getNickProveedor())){
                            JOptionPane.showMessageDialog(this, "El nombre de servicio ingresado ya se encuentra en uso por el proveedor", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                            txtNombreServicio.requestFocus();
                        }
                        else{
                            String cOrigen = (String) cmbCiudadOrigen.getSelectedItem();
                            String[] ciudad = cOrigen.split(",");
                            String ciudadOrigen = ciudad[0].trim();

                            ArrayList<String> imagenes = new ArrayList<String>();
                            if(rutaImagen1 != ""){
                                imagenes.add(rutaImagen1);

                                if(rutaImagen2 != ""){
                                    imagenes.add(rutaImagen2);

                                    if(rutaImagen3 != ""){
                                        imagenes.add(rutaImagen3);
                                    }
                                }
                            }

                            ArrayList<String> categorias = obtenerCategorias(modelo);

                            //String proveedor = (String) cmbProveedor.getSelectedItem();

                            boolean tieneDestino = false;

                            String ciudadDestino;

                            if((String) cmbCiudadDestino.getSelectedItem() != "No corresponde"){
                                String cDestino = (String) cmbCiudadDestino.getSelectedItem();
                                String[] ciudadD = cDestino.split(",");

                                ciudadDestino = ciudadD[0].trim();

                                tieneDestino = true;
                            }
                            else{
                                ciudadDestino = "";
                            }

                            for(int i = 0; i < imagenes.size(); i++){
                                int numero = i + 1;
                                icprov.copiarImagenServicio(imagenes.get(i), txtNombreServicio.getText() + "-" + getNickProveedor() + "-" + numero);
                                imagenes.set(i, "src/Logica/ImagenesServicios/" + txtNombreServicio.getText() + "-" + getNickProveedor()+ "-" + numero + ".jpg");
                            }

                            int precio = Integer.parseInt(txtPrecio.getText());

                            icprov.agregarServicio(txtNombreServicio.getText(), areaDescripcion.getText(), precio, getNickProveedor(), imagenes, categorias, ciudadOrigen, ciudadDestino, tieneDestino);

                            limpiar();
                            JOptionPane.showMessageDialog(this, "El nuevo servicio ha sido agregado de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    catch(SQLException ex){
                        //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    catch(ClassNotFoundException ex){
                        JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Problema con las imágenes del servicio", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } 
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public String getNickProveedor(){
        String combo = cmbProveedor.getSelectedItem().toString();
        String[] partesCombo = combo.split("<");
        
        return partesCombo[0].toString().trim();
    }
    
    public ArrayList<String> obtenerCategorias(DefaultListModel modelo){
        ArrayList<String> categorias = new ArrayList();
        for(int i = 0; i < modelo.getSize(); i++){
            String cat = (String) modelo.getElementAt(i);
            categorias.add((String) cat);
        }
        
        return categorias;
    }
    
    public boolean esNumerico(String txt){
        try{
            Integer.parseInt(txt);
            return true;
        }
        catch(NumberFormatException ex){
            return false;
        }
    }
    
    public boolean categoriaRepetida(DefaultListModel modelo, String categoria){
        boolean repetido = false;
        for(int i = 0; i < modelo.getSize(); i++){
            if(modelo.getElementAt(i).equals(rutaCategoria))
                repetido = true;
        }
        return repetido;
    }
    
    private void lblAgregarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarCategoriaMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1){
            DefaultListModel modelo = (DefaultListModel) lstCategorias.getModel();
            if(categoriaRepetida(modelo, rutaCategoria)){
                JOptionPane.showMessageDialog(this, "La categoría ya se encuentra agregada para el servicio", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
            else{
                modelo.addElement(rutaCategoria);                
            }
            lstCategorias.setModel(modelo);
            
            
        }
    }//GEN-LAST:event_lblAgregarCategoriaMouseClicked

    private void treeCategoriasValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeCategoriasValueChanged
        rutaCategoria = "";
        TreePath path = evt.getPath();
        Object[] nodos = path.getPath();
        for(int i = 0; i < nodos.length; i++){
            if(i != 0)
                rutaCategoria = rutaCategoria + nodos[i].toString();
            if(i < nodos.length-1 && i != 0)            
                rutaCategoria = rutaCategoria + " > ";
            
        }
        
        //System.out.println(rutaCategoria);
    }//GEN-LAST:event_treeCategoriasValueChanged


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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAgregarCategoria;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEmpresa1;
    private javax.swing.JLabel lblSitioWeb;
    private javax.swing.JLabel lblSitioWeb1;
    private javax.swing.JLabel lblSitioWeb2;
    private javax.swing.JLabel lblSitioWeb3;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JTree treeCategorias;
    private javax.swing.JTextField txtNombreServicio;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
