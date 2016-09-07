/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

/**
 *
 * @author usuario
 */
public class ifrmInformacionServicios extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmInformacionServicios
     */
    
    private JLabel lblImagen1 = new JLabel();
    private JLabel lblImagen2;
    private JLabel lblImagen3;
    
    private String rutaImagen1 = "";
    private String rutaImagen2 = "";
    private String rutaImagen3 = "";
    
    private frmVisor visor;
    
    private DefaultTableModel modelo;
    
    private IControladorProveedores icprov;
    private IControladorCategorias iccat;
    
    public ifrmInformacionServicios() {
        initComponents();
    }
           
    public ifrmInformacionServicios(IControladorProveedores icprov, IControladorCategorias iccat) {
        initComponents();
        
        this.icprov = icprov;
        this.iccat = iccat;
        
        
        
        Dimension tamanioVentana = this.getSize();
        
        setLocation((1400 - tamanioVentana.width)/2, (820 - tamanioVentana.height)/2);
        
        panelDatos.setVisible(false);
        
        lstCategorias.setBackground(UIManager.getColor("Label.background"));
        lblDescripcion.setBackground(UIManager.getColor("Label.background"));
        
        
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Búsqueda rápida"));
        tbServicios.requestFocus();
        
        lblImagen1.addMouseListener(new OyenteLabel());
        lblImagen1.setSize(143, 143);
        panelImagenes.add(lblImagen1);
        lblImagen1.setLocation(0, 0);
        lblImagen1.setCursor(new Cursor(Cursor.HAND_CURSOR));    
        lblImagen1.setVisible(true);
        lblDescripcion.setEditable(false);
        
        lblDescripcion.setEditable(false);
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre del servicio", "Proveedor"});
        
        try{
            ArrayList<DataServicio> datosServicios = icprov.getServicios();
            
            for(int i = 0; i < datosServicios.size(); i++){
                modelo.addRow(new Object[]{datosServicios.get(i).getNombreServicio(), datosServicios.get(i).getNombreProveedor()});
            }
            
            tbServicios.setModel(modelo);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public ifrmInformacionServicios(IControladorProveedores icprov, IControladorCategorias iccat, String NombreDelServicio, String ProveedorDelServicio) {
        initComponents();
        
        this.icprov = icprov;
        this.iccat = iccat;
               
        Dimension tamanioVentana = this.getSize();
        
        setLocation((1400 - tamanioVentana.width)/2, (820 - tamanioVentana.height)/2);
        
        panelDatos.setVisible(false);
        
        lstCategorias.setBackground(UIManager.getColor("Label.background"));
        lblDescripcion.setBackground(UIManager.getColor("Label.background"));
        
        
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Búsqueda rápida"));
        tbServicios.requestFocus();
        
        lblImagen1.addMouseListener(new ifrmInformacionServicios.OyenteLabel());
        lblImagen1.setSize(143, 143);
        panelImagenes.add(lblImagen1);
        lblImagen1.setLocation(0, 0);
        lblImagen1.setCursor(new Cursor(Cursor.HAND_CURSOR));    
        lblImagen1.setVisible(true);
        lblDescripcion.setEditable(false);
        
        
        
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre del servicio", "Proveedor"});
        modelo.addRow(new Object[]{NombreDelServicio, ProveedorDelServicio});
        tbServicios.setModel(modelo);
        
        panelBusqueda.setVisible(false);
        panelBotonAceptar.setVisible(false);
        
        panelDatos.setVisible(true);
        
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
            
            lblNombre.setText(NombreDelServicio);
            lblProveedor.setText(ProveedorDelServicio);

            try {
                
                DataServicio datosServicio = icprov.getDatosServicio(NombreDelServicio, ProveedorDelServicio);
                if(datosServicio.getDescripcionServicio() != ""){
                    lblDescripcion.setText(datosServicio.getDescripcionServicio());
                    lblPrecio.setText("U$S " + String.valueOf(datosServicio.getPrecioServicio()));

                    DataCiudad ciudad = icprov.getCiudadOrigen(NombreDelServicio, ProveedorDelServicio);
                    lblOrigen.setText(ciudad.getNombre() + ", " + ciudad.getPais());

                    ciudad = icprov.getCiudadDestino(NombreDelServicio, ProveedorDelServicio);
                    if(ciudad.getNombre().equals("No"))
                        lblDestino.setText("No corresponde");
                    else
                        lblDestino.setText(ciudad.getNombre() + ", " + ciudad.getPais());

                    ArrayList<DataCategoria> categoriasDelServicio = icprov.getCategorias(NombreDelServicio, ProveedorDelServicio);

                    DefaultListModel modeloLista = new DefaultListModel();

                    for(int i = 0; i < categoriasDelServicio.size(); i++){
                        modeloLista.addElement(categoriasDelServicio.get(i).getRutaCategoria());
                    }

                    lstCategorias.setModel(modeloLista);

                    ArrayList<DataImagen> imagenesDelServicio = icprov.getImagenes(NombreDelServicio, ProveedorDelServicio);

                    if(imagenesDelServicio.size() == 0){

                        lblImagenes.setVisible(true);
                    }
                    else{
                        for(int i = 0; i < imagenesDelServicio.size(); i++){
                            File ficheroImagen = new File(imagenesDelServicio.get(i).getPath());
                            String rutaAbsoluta = ficheroImagen.getAbsolutePath();

                            setImagenLabel(rutaAbsoluta, "absoluta");
                        }
                        lblImagenes.setVisible(false);
                    }


                    panelDatos.setVisible(true);
                }
                else{
                    panelDatos.setVisible(false);
                    if(JOptionPane.showConfirmDialog(this, "No se han encontrado datos del servicio para el proveedor indicado,\nposiblemente se haya editado algún dato del mismo en la tabla.\n¿Desea volver a cargarla?", "CONFIRMACIÓN", JOptionPane.YES_OPTION) == 0){
                        txtBusqueda.setText("");       
                        modelo.setColumnIdentifiers(new Object[]{"Nombre del servicio", "Proveedor"});

                        try{
                            ArrayList<DataServicio> datosServicios = icprov.getServicios();

                            for(int i = 0; i < datosServicios.size(); i++){
                                modelo.addRow(new Object[]{datosServicios.get(i).getNombreServicio(), datosServicios.get(i).getNombreProveedor()});
                            }

                            tbServicios.setModel(modelo);
                        }
                        catch(SQLException ex){
                            JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                            //JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(ClassNotFoundException ex){
                            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                

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
        panelTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbServicios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        panelBusqueda = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        panelBotonAceptar = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        panelBotonAceptar1 = new javax.swing.JPanel();
        btnAceptar1 = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblDescripcion = new javax.swing.JTextArea();
        panelImagenes = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblOrigen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        lblImagenes = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("Ver información de servicios");

        tbServicios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del servicio", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbServicios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbServiciosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbServiciosKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tbServicios);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione el servicio:");

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusqueda)
                .addContainerGap())
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBusquedaLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonAceptarLayout = new javax.swing.GroupLayout(panelBotonAceptar);
        panelBotonAceptar.setLayout(panelBotonAceptarLayout);
        panelBotonAceptarLayout.setHorizontalGroup(
            panelBotonAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonAceptarLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonAceptarLayout.setVerticalGroup(
            panelBotonAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonAceptarLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAceptar)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btnAceptar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAceptar1.setText("Aceptar");
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonAceptar1Layout = new javax.swing.GroupLayout(panelBotonAceptar1);
        panelBotonAceptar1.setLayout(panelBotonAceptar1Layout);
        panelBotonAceptar1Layout.setHorizontalGroup(
            panelBotonAceptar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonAceptar1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        panelBotonAceptar1Layout.setVerticalGroup(
            panelBotonAceptar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonAceptar1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnAceptar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBotonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(panelBusqueda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(panelBotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre del servicio:");

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNombre.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Proveedor:");

        lblProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProveedor.setText("Proveedor");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descripción:");

        lblDescripcion.setColumns(20);
        lblDescripcion.setLineWrap(true);
        lblDescripcion.setRows(5);
        lblDescripcion.setWrapStyleWord(true);
        lblDescripcion.setBorder(null);
        jScrollPane3.setViewportView(lblDescripcion);

        panelImagenes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout panelImagenesLayout = new javax.swing.GroupLayout(panelImagenes);
        panelImagenes.setLayout(panelImagenesLayout);
        panelImagenesLayout.setHorizontalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        panelImagenesLayout.setVerticalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Precio:");

        lblPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPrecio.setText("Precio");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Ciudad orígen:");

        lblOrigen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblOrigen.setText("Precio");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Ciudad destino:");

        lblDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDestino.setText("Precio");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Categorías:");

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lstCategorias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(lstCategorias);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Imágenes:");

        lblImagenes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblImagenes.setText("El servicio del proveedor no presenta imágenes cargadas");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblImagenes))
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(lblProveedor)
                        .addComponent(jLabel4)
                        .addComponent(lblNombre)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane3)
                        .addComponent(panelImagenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosLayout.createSequentialGroup()
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(lblPrecio)
                                .addComponent(lblOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(lblDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(66, 66, 66)
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jScrollPane1)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProveedor)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblPrecio)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOrigen)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDestino))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblImagenes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(panelGeneral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
    
        if(tbServicios.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado servicio", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            tbServicios.requestFocus();
        } 
        else{
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
            
            lblNombre.setText((String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 0));
            lblProveedor.setText((String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 1));

            try {
                
                DataServicio datosServicio = icprov.getDatosServicio((String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 0), (String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 1));
                if(datosServicio.getDescripcionServicio() != ""){
                    lblDescripcion.setText(datosServicio.getDescripcionServicio());
                    lblPrecio.setText("U$S " + String.valueOf(datosServicio.getPrecioServicio()));

                    DataCiudad ciudad = icprov.getCiudadOrigen((String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 0), (String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 1));
                    lblOrigen.setText(ciudad.getNombre() + ", " + ciudad.getPais());

                    ciudad = icprov.getCiudadDestino((String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 0), (String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 1));
                    if(ciudad.getNombre().equals("No"))
                        lblDestino.setText("No corresponde");
                    else
                        lblDestino.setText(ciudad.getNombre() + ", " + ciudad.getPais());

                    ArrayList<DataCategoria> categoriasDelServicio = icprov.getCategorias((String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 0), (String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 1));

                    DefaultListModel modeloLista = new DefaultListModel();

                    for(int i = 0; i < categoriasDelServicio.size(); i++){
                        modeloLista.addElement(categoriasDelServicio.get(i).getRutaCategoria());
                    }

                    lstCategorias.setModel(modeloLista);

                    ArrayList<DataImagen> imagenesDelServicio = icprov.getImagenes((String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 0), (String) tbServicios.getValueAt(tbServicios.getSelectedRow(), 1));

                    if(imagenesDelServicio.size() == 0){
                        lblImagen1.setVisible(false);
                        lblImagenes.setVisible(true);
                    }
                    else{
                        lblImagen1.setVisible(true);
                        for(int i = 0; i < imagenesDelServicio.size(); i++){
                            File ficheroImagen = new File(imagenesDelServicio.get(i).getPath());
                            String rutaAbsoluta = ficheroImagen.getAbsolutePath();

                            setImagenLabel(rutaAbsoluta, "absoluta");
                        }
                        lblImagenes.setVisible(false);
                    }


                    panelDatos.setVisible(true);
                }
                else{
                    panelDatos.setVisible(false);
                    if(JOptionPane.showConfirmDialog(this, "No se han encontrado datos del servicio para el proveedor indicado,\nposiblemente se haya editado algún dato del mismo en la tabla.\n¿Desea volver a cargarla?", "CONFIRMACIÓN", JOptionPane.YES_OPTION) == 0){
                        txtBusqueda.setText("");                        
                        modelo = new DefaultTableModel();
                        modelo.setColumnIdentifiers(new Object[]{"Nombre del servicio", "Proveedor"});

                        try{
                            ArrayList<DataServicio> datosServicios = icprov.getServicios();

                            for(int i = 0; i < datosServicios.size(); i++){
                                modelo.addRow(new Object[]{datosServicios.get(i).getNombreServicio(), datosServicios.get(i).getNombreProveedor()});
                            }

                            tbServicios.setModel(modelo);
                        }
                        catch(SQLException ex){
                            JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                            //JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(ClassNotFoundException ex){
                            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                

            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }//GEN-LAST:event_btnAceptarActionPerformed

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
                lblImagen2.addMouseListener(new OyenteLabel());
            }
            else if(lblImagen == lblImagen2){
                rutaImagen2 = ruta;
                lblImagen3 = new JLabel();
                lblImagen3.setSize(143, 143);
                panelImagenes.add(lblImagen3);
                lblImagen3.setLocation(380, 0);
                lblImagen3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblImagen3.addMouseListener(new OyenteLabel());
            }
            else{
                rutaImagen3 = ruta;
            }
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
        
        public OyenteLabel(){
            
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
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
    
    public void eventoBusqueda(String buscar){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre del servicio", "Proveedor"});
        
        try{
            ArrayList<DataServicio> datosServicios = icprov.getServiciosPorBusqueda(buscar);
            
            for(int i = 0; i < datosServicios.size(); i++){
                modelo.addRow(new Object[]{datosServicios.get(i).getNombreServicio(), datosServicios.get(i).getNombreProveedor()});
            }
            
            tbServicios.setModel(modelo);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        eventoBusqueda(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaKeyTyped
    
    private void tbServiciosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbServiciosKeyTyped
        
    }//GEN-LAST:event_tbServiciosKeyTyped

    private void tbServiciosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbServiciosKeyPressed
        
    }//GEN-LAST:event_tbServiciosKeyPressed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        
    }//GEN-LAST:event_txtBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea lblDescripcion;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblImagenes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOrigen;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JPanel panelBotonAceptar;
    private javax.swing.JPanel panelBotonAceptar1;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tbServicios;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
