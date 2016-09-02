/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

/**
 *
 * @author usuario
 */
public class ifrmVerInfoProveedores extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmVerInfoProveedores
     * 
     */
    /*private JLabel lblImagen1 = new JLabel();
    private JLabel lblImagen2;
    private JLabel lblImagen3;
    
    private String rutaImagen1 = "";
    private String rutaImagen2 = "";
    private String rutaImagen3 = "";*/
    
    private frmVisor visor;
    
    private ArrayList<LabelImagen> perfiles = new ArrayList<LabelImagen>();
    
    private String rutaImagen = "";
    
    private String proveedor = ""; 
    private String servicio = "";
    Panel nuevoPanel = new Panel();
    private IControladorProveedores icprov;
    private IControladorCategorias iccat;
    
    public ifrmVerInfoProveedores() {
        initComponents();
        
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (750 - tamanioVentana.height)/2);
        
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Búsqueda rápida"));
    }
    
    public ifrmVerInfoProveedores(IControladorProveedores icprov) {
        initComponents();
        lblImagenes.setVisible(false);
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (750 - tamanioVentana.height)/2);
        panelDatos.setVisible(false);
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Búsqueda rápida"));
        
        setTitle("Ver información de proveedores");
        
        this.icprov = icprov;
        
        /*comentario*/
        
        /*lblImagen1.addMouseListener(new ifrmVerInfoProveedores.OyenteLabel());
        lblImagen1.setSize(105, 105);
        panelImagenes.add(lblImagen1);
        lblImagen1.setLocation(0, 0);
        lblImagen1.setCursor(new Cursor(Cursor.HAND_CURSOR));    
        lblImagen1.setVisible(true);*/
        
        
        lblImagenPerfil.setSize(200, 200); 
        lblImagenPerfil.setVisible(true);
        //setImagenPerfil("src/Logica/perfiles/perfil.png", "defecto");
        File directorio = new File("src/Logica/perfiles/perfil.png");
        setImagenPerfil(directorio.getAbsolutePath(), "absoluta");
        jScrollPane3.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        
        try{
            DefaultListModel modelo = new DefaultListModel();
            ArrayList<DataProveedor> listDtProv =new ArrayList();
            listDtProv=icprov.getInfoProveedores();
            //JOptionPane.showMessageDialog(this, listDtCli.size());
            for(int i=0;i<listDtProv.size(); i++){
               modelo.addElement(listDtProv.get(i).getNickname());
            }
            
            lstProv.setModel(modelo);
        }
        catch(SQLException ex){
            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
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
        
        this.rutaImagen = ruta;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelClientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProv = new javax.swing.JList<>();
        btnBuscarCliente = new javax.swing.JButton();
        panelBusqueda = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        panelDatos = new javax.swing.JPanel();
        lblImagenPerfil = new javax.swing.JLabel();
        jlabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JLabel();
        jlabel5 = new javax.swing.JLabel();
        jlabel6 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        txtSitioWeb = new javax.swing.JLabel();
        jlabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelImagenes = new javax.swing.JPanel();
        cmbServicios = new javax.swing.JComboBox<>();
        btnBuscarServicio = new javax.swing.JButton();
        lblImagenes = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione proveedor:");

        lstProv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(lstProv);

        btnBuscarCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarCliente.setText("Aceptar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
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

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClientesLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnBuscarCliente)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        lblImagenPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblImagenPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenPerfilMouseClicked(evt);
            }
        });

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel2.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setText("nombre");

        jlabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel3.setText("Apellido:");

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellido.setText("apellido");

        jlabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel4.setText("Correo electrónico:");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCorreo.setText("correo");

        txtFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFechaNacimiento.setText("fechaNacimiento");

        jlabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel5.setText("Fecha de nacimiento:");

        jlabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel6.setText("Nombre de empresa:");

        txtNombreEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreEmpresa.setText("nombreEmpresa");

        jlabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel7.setText("Sitio web:");

        txtSitioWeb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSitioWeb.setText("sitioWeb");
        txtSitioWeb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSitioWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSitioWebMouseClicked(evt);
            }
        });

        jlabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel8.setText("Imágenes de Proveedor:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Servicios del proveedor:");

        javax.swing.GroupLayout panelImagenesLayout = new javax.swing.GroupLayout(panelImagenes);
        panelImagenes.setLayout(panelImagenesLayout);
        panelImagenesLayout.setHorizontalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );
        panelImagenesLayout.setVerticalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(panelImagenes);

        cmbServicios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnBuscarServicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarServicio.setText("Buscar");
        btnBuscarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarServicioActionPerformed(evt);
            }
        });

        lblImagenes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblImagenes.setText("El proveedor no presenta imágenes cargadas");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabel6)
                            .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jlabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lblImagenes))
                            .addComponent(jlabel7)
                            .addComponent(txtSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(btnBuscarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlabel2)
                                    .addComponent(jlabel3)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlabel4)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlabel5)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblImagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(29, 29, 29))))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jlabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jlabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jlabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagenes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarServicio))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        if(lstProv.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "No se seleccionado ningún proveedor", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            lstProv.requestFocus();
        }
        else{
            try {                
                limpiar();
                //JOptionPane.showMessageDialog(this, lstProv.getSelectedValue());
                DataProveedor dtProv = icprov.verInfoProveedor(lstProv.getSelectedValue());
                //JOptionPane.showMessageDialog(this, dtProv.getNombre());
                txtNombre.setText(dtProv.getNombre());
                txtApellido.setText(dtProv.getApellido());
                txtCorreo.setText(dtProv.getEmail());
                txtFechaNacimiento.setText(String.valueOf(dtProv.getFechaNac().getDayOfMonth()) + "/"+String.valueOf(dtProv.getFechaNac().getMonthValue())+"/"+String.valueOf(dtProv.getFechaNac().getYear()) );
                txtNombreEmpresa.setText(dtProv.getNombreEmpresa());
                txtSitioWeb.setText("<html><a href = '" + dtProv.getLink() + "'>" + dtProv.getLink() + "</a><html>");
                
                ArrayList<DataServicio> servicios = new ArrayList();
                servicios = icprov.getServiciosProveedor(dtProv.getNombreEmpresa());
                if(servicios.size() == 0){
                    cmbServicios.addItem("No corresponde");
                    btnBuscarServicio.setVisible(false);
                } 
                else{
                    for(int i = 0; i < servicios.size(); i++){
                        cmbServicios.addItem(servicios.get(i).getNombreServicio());
                    }
                    btnBuscarServicio.setVisible(true);
                }
                
                
                ArrayList<String> imagenesProv = dtProv.getRutaImagen();
                
                if(imagenesProv.size() == 0){
                    File directorio = new File("src/Logica/perfiles/perfil.png");
                    setImagenPerfil(directorio.getAbsolutePath(), "absoluta");
                    //lblImagenes.setVisible(true);
                }
                else{
                    for(int i = 0; i < imagenesProv.size(); i++){                        
                        perfiles.add(new LabelImagen(imagenesProv.get(i)));                                                      
                    }
                    int cant = 0;
                    for(int i = 0; i < perfiles.size(); i++){
                        if(i == 0){
                            setImagenPerfil(perfiles.get(i).getRutaImagen(), "absoluta");
                        }
                        ImageIcon icono = new ImageIcon(perfiles.get(i).getRutaImagen());
                        ImageIcon iconoDimensionado = new ImageIcon(icono.getImage().getScaledInstance(124, 124, Image.SCALE_DEFAULT));
                        panelImagenes.add((LabelImagen) perfiles.get(i));
                        perfiles.get(i).setIcon(iconoDimensionado);
                        perfiles.get(i).setLocation(i * 150, 0);
                        perfiles.get(i).addMouseListener(new OyenteLabel());
                        
                        cant = i;
                    }

                    int largo = cant + 1;
                    panelImagenes.setPreferredSize(new Dimension(largo * 147, 124));

                    if(cant > 3){
                        jScrollPane3.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
                    }
                    else{
                        jScrollPane3.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
                    }
                }
                
                
                panelDatos.setVisible(true);
            } catch(SQLException ex){
                //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped

        try{
            DefaultListModel modelo = new DefaultListModel();
            ArrayList<DataProveedor> listDtProv =new ArrayList();
            listDtProv=icprov.verInfoProveedorBusqueda(txtBusqueda.getText());
            //JOptionPane.showMessageDialog(this, listDtCli.size());
            for(int i=0;i<listDtProv.size(); i++){
                modelo.addElement(listDtProv.get(i).getNickname());
            }

            lstProv.setModel(modelo);
        }
        catch(SQLException ex){
            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void lblImagenPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenPerfilMouseClicked
        /*if(evt.getButton() == MouseEvent.BUTTON1){
            fchImagenes selectorImagen = new fchImagenes(this);
            selectorImagen.setVisible(true);
        }*/
    }//GEN-LAST:event_lblImagenPerfilMouseClicked

    private void btnBuscarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarServicioActionPerformed
        // TODO add your handling code here:
        
        servicio = (String) cmbServicios.getSelectedItem();
        proveedor = txtNombreEmpresa.getText();
        ifrmInformacionServicios vInformacionServicio = new ifrmInformacionServicios(icprov, iccat, servicio, proveedor);
        frmMenuPrincipal.nuevoPanel.add(vInformacionServicio);
        
        vInformacionServicio.setVisible(true);
        
        
    }//GEN-LAST:event_btnBuscarServicioActionPerformed

    private void txtSitioWebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSitioWebMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1){
            Desktop dsk = Desktop.getDesktop();
            try {
                dsk.browse(new URI(txtSitioWeb.getText()));
            } catch (IOException |  URISyntaxException ex) {
                JOptionPane.showMessageDialog(this, "Problema para redirigirse a la URL", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtSitioWebMouseClicked

    private void limpiar() {
            cmbServicios.removeAllItems();
            
            if(perfiles.size() > 0){
                Container parent = perfiles.get(0).getParent();
                while(perfiles.size() > 0){
                    perfiles.remove(0);
                }
                parent.removeAll();
                parent.repaint();

            }
            perfiles.clear();
           /* lblImagen1 = new JLabel();
            lblImagen2 = new JLabel();
            lblImagen3 = new JLabel();
            rutaImagen1 = "";
            rutaImagen2 = "";
            rutaImagen3 = "";*/
    }
    
    private class LabelImagen extends JLabel{
        private String rutaImagen = "";
        public LabelImagen(String rutaImagen){
            this.setSize(124, 124);
            this.rutaImagen = rutaImagen;
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            //this.addMouseListener(new ifrmVerInfoProveedores.OyenteLabel());
            
            /**** ACÁ ME QUEDE *****/
            
            //JPopupMenu jpmEliminar = new JPopupMenu();
            //ifrmAltaProveedores.MenuItemPopup pm = new ifrmAltaProveedores.MenuItemPopup(this, "Eliminar");
            //pm.addActionListener(new ifrmAltaProveedores.OyentePopup());
            //jpmEliminar.add(pm);
            
            //this.setComponentPopupMenu(jpmEliminar);
        }

        private LabelImagen() {
            
        }

        public String getRutaImagen() {
            return rutaImagen;
        }

        public void setRutaImagen(String rutaImagen) {
            this.rutaImagen = rutaImagen;
        }
    }

    public void setImagenLabel(String ruta, String tipo){
        //System.out.println("entre");
        //JLabel lblImagen = labelActual();
        if(tipo.equals("defecto")){
            //System.out.println("hola");
            ImageIcon imagenPerfil = new ImageIcon(getClass().getResource(ruta));
            ImageIcon imagenDimensionada = new ImageIcon(imagenPerfil.getImage().getScaledInstance(lblImagenPerfil.getWidth(), lblImagenPerfil.getHeight(), Image.SCALE_DEFAULT));
            lblImagenPerfil.setIcon(imagenDimensionada);
        }
        else{
            ImageIcon imagenPerfil = new ImageIcon(ruta);
            ImageIcon imagenDimensionada = new ImageIcon(imagenPerfil.getImage().getScaledInstance(lblImagenPerfil.getWidth(), lblImagenPerfil.getHeight(), Image.SCALE_DEFAULT));
            lblImagenPerfil.setIcon(imagenDimensionada);
            
            /*if(lblImagen == lblImagen1){
                //System.out.println("2");
                rutaImagen1 = ruta;
                lblImagen2 = new JLabel();
                lblImagen2.setSize(105, 105);
                panelImagenes.add(lblImagen2);
                lblImagen2.setLocation(135, 0);
                lblImagen2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblImagen2.addMouseListener(new ifrmVerInfoProveedores.OyenteLabel());
                //setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                //lblImagen2.setComponentPopupMenu(eliminarImagen1);
                //agregarPopup(2);
            }
            else if(lblImagen == lblImagen2){
                //System.out.println("3");
                rutaImagen2 = ruta;
                lblImagen3 = new JLabel();
                lblImagen3.setSize(105,105);
                panelImagenes.add(lblImagen3);
                lblImagen3.setLocation(240, 0);
                lblImagen3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblImagen3.addMouseListener(new ifrmVerInfoProveedores.OyenteLabel());
                //setImagenLabel("../Logica/ImagenesServicios/agregarImagenServicio.png", "defecto");
                //lblImagen3.setComponentPopupMenu(eliminarImagen2);
                //agregarPopup(3);
            }
            else{
                rutaImagen3 = ruta;
            }*/
        }       
    }
    
    /*public JLabel labelActual(){
        
        if(lblImagen2 == null){
            return lblImagen1;
        }
        else if(lblImagen3 == null)
            return lblImagen2;
        else
            return lblImagen3;
    }*/
       
    private class OyenteLabel implements MouseListener{

        /*@Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
                //setImagenPerfil()
                ifrmVerInfoProveedores.LabelImagen elemento = (ifrmVerInfoProveedores.LabelImagen) e.getSource();
                setImagenPerfil(elemento.getRutaImagen(), "absoluta");
            }
        }*/
        @Override
            public void mouseClicked(MouseEvent e) {
                //JOptionPane.showMessageDialog(null, "entre");
                if(e.getButton() == MouseEvent.BUTTON1){
                    /*if((JLabel) e.getSource() == perfiles.get(0))
                        JOptionPane.showMessageDialog(null, "anduvo!!");*/
                    //JOptionPane.showMessageDialog(null, e.getSource());
                    //LabelImagen imagen = (LabelImagen) e.getSource();
                    /*boolean ok = false;
                    while(!ok){
                        try{*/
                            JLabel img = (JLabel) e.getSource();
                            LabelImagen imagen = (LabelImagen) img;
                            setImagenPerfil(imagen.getRutaImagen(), "absoluta");
                            //ok = true;
                        /*}
                        catch(ClassCastException ex){
                            ok = false;
                        }
                    }*/
                    
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarServicio;
    private javax.swing.JComboBox<String> cmbServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel jlabel5;
    private javax.swing.JLabel jlabel6;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JLabel jlabel8;
    private javax.swing.JLabel lblImagenPerfil;
    private javax.swing.JLabel lblImagenes;
    private javax.swing.JList<String> lstProv;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JLabel txtApellido;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JLabel txtCorreo;
    private javax.swing.JLabel txtFechaNacimiento;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombreEmpresa;
    private javax.swing.JLabel txtSitioWeb;
    // End of variables declaration//GEN-END:variables
/*class Panel extends JDesktopPane{
    
    public Panel(){
              
    }
    
    public Panel(ifrmAltaUsuarios vUsuarios){
        add(vUsuarios);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanio = getSize();
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("imagenes/aficheMenuPrincipal.png"));
        
        g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        
        setOpaque(false);
       
        super.paintComponent(g);
        }
    }
*/
}

