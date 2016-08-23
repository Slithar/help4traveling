/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.ScrollPaneConstants.*;

/**
 *
 * @author usuario
 */
public class ifrmAltaProveedores extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmAltaProveedores
     */
    
    private ArrayList<LabelImagen> perfiles;
    
    private String rutaImagen = "";
    
    private IControladorProveedores icprov;
    
    public ifrmAltaProveedores() {
        initComponents();
    }
    
    public ifrmAltaProveedores(IControladorProveedores icprov) {
        initComponents();
        
        this.icprov = icprov;
        
        setTitle("Registro de proveedores");
        
        //this.setSize(780, 570);
        lblImagenPerfil.setSize(200, 200);
        
        perfiles = new ArrayList<LabelImagen>();
        
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (750 - tamanioVentana.height)/2);
        
        setImagenPerfil("../Logica/Perfiles/perfil.PNG", "defecto");
        
        lblAgregarPerfil.setSize(35, 35);
        
        ImageIcon imagenAgregarPerfil = new ImageIcon(getClass().getResource("Imagenes/iconoAgregarPerfil.png"));
        ImageIcon imagenDimensionada = new ImageIcon(imagenAgregarPerfil.getImage().getScaledInstance(lblAgregarPerfil.getWidth(), lblAgregarPerfil.getHeight(), Image.SCALE_DEFAULT));
        lblAgregarPerfil.setIcon(imagenDimensionada);
        
        panelPerfiles.setPreferredSize(new Dimension(366,100));
        
        panelPerfiles.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);       
        
        spnDia.setModel(new SpinnerNumberModel(1,1,31,1));
        spnMes.setModel(new SpinnerNumberModel(1,1,12,1));
        Calendar fecha = Calendar.getInstance();
        spnAnio.setModel(new SpinnerNumberModel(fecha.get(Calendar.YEAR), 1900, fecha.get(Calendar.YEAR), 1));       
    }
    
    public void agregarImagenPerfil(String ruta){
        if(existeImagenPerfil(ruta)){
            JOptionPane.showMessageDialog(this, "La imagen de perfil seleccionada ya se encuentra cargada", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            LabelImagen lblImagen1 = new LabelImagen();
            lblImagen1.setSize(100, 100);
            lblImagen1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            lblImagen1.addMouseListener(new OyenteLabel());
            LabelImagen imagen = new LabelImagen(ruta);
            imagen.setSize(100, 100);
            
            JPopupMenu jpmEliminar = new JPopupMenu();
            MenuItemPopup pm = new MenuItemPopup(lblImagen1, "Eliminar");
            pm.addActionListener(new OyentePopup());
            jpmEliminar.add(pm);
            
            lblImagen1.setComponentPopupMenu(jpmEliminar);

            perfiles.add(imagen);
            if(perfiles.get(0) == imagen){
                setImagenPerfil(ruta, "absoluta");
                panelImagenes.add(lblImagen1);
                /*lblImagen1.setLocation(0, 0);
                ImageIcon imagenPerfil = new ImageIcon(ruta);
                ImageIcon imagenDimensionadaPerfil = new ImageIcon(imagenPerfil.getImage().getScaledInstance(lblImagen1.getWidth(), lblImagen1.getHeight(), Image.SCALE_DEFAULT));
                lblImagen1.setIcon(imagenDimensionadaPerfil);
                lblImagen1.setRutaImagen(ruta);*/
            }
            //else{
            lblImagen1.setVisible(false);
            refrescarPerfiles();
            //}
        }
        
    }
    
    public void refrescarPerfiles(){
        int i = 0;
        for( i = 0; i < perfiles.size(); i++){
            //JOptionPane.showMessageDialog(this, perfiles.get(i).getRutaImagen());            
            ImageIcon imagenPerfil = new ImageIcon(perfiles.get(i).getRutaImagen());
            ImageIcon imagenDimensionadaPerfil = new ImageIcon(imagenPerfil.getImage().getScaledInstance(perfiles.get(i).getWidth(), perfiles.get(i).getHeight(), Image.SCALE_DEFAULT));
            perfiles.get(i).setIcon(imagenDimensionadaPerfil);       

            panelImagenes.add(perfiles.get(i));
            perfiles.get(i).setLocation(i * 135, 0);
        }      
        
        panelImagenes.setPreferredSize(new Dimension(i * 135, 100));

        if(i > 3){            
            panelPerfiles.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        }
        else{
            panelPerfiles.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        }
    }
    
    public boolean existeImagenPerfil(String ruta){
        int i = 0;
        while(i < perfiles.size()){
            if(perfiles.get(i).getRutaImagen().equals(ruta))
                return true;
            i++;
        }
        return false;
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
    
    private class LabelImagen extends JLabel{
        private String rutaImagen = "";
        public LabelImagen(String rutaImagen){
            this.setSize(100, 100);
            this.rutaImagen = rutaImagen;
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.addMouseListener(new OyenteLabel());
            
            /**** ACÁ ME QUEDE *****/
            
            JPopupMenu jpmEliminar = new JPopupMenu();
            MenuItemPopup pm = new MenuItemPopup(this, "Eliminar");
            pm.addActionListener(new OyentePopup());
            jpmEliminar.add(pm);
            
            this.setComponentPopupMenu(jpmEliminar);
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
    
    private class MenuItemPopup extends JMenuItem{
        private LabelImagen labelAsociado;
        
        public MenuItemPopup(LabelImagen l, String nombre){
            super(nombre);
            this.labelAsociado = l;
            this.setIcon(new ImageIcon(getClass().getResource("Imagenes/iconoEliminar.png")));
        }

        public LabelImagen getLabelAsociado() {
            return labelAsociado;
        }

        public void setLabelAsociado(LabelImagen labelAsociado) {
            this.labelAsociado = labelAsociado;
        }
    }
    
    private class OyenteLabel implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
                //setImagenPerfil()
                LabelImagen elemento = (LabelImagen) e.getSource();
                setImagenPerfil(elemento.getRutaImagen(), "absoluta");
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

        @Override
        public void actionPerformed(ActionEvent e) {
            MenuItemPopup objetoEvento = (MenuItemPopup) e.getSource();
            String ruta = objetoEvento.getLabelAsociado().getRutaImagen();
            
            int i = 0;
            boolean encontrado = false;
            
            while(!encontrado && i < perfiles.size()){
                if(perfiles.get(i).getRutaImagen().equals(ruta)){
                    Container parent = perfiles.get(i).getParent();
                    parent.removeAll();
                    parent.repaint();
                    String rutaEliminar = perfiles.get(i).getRutaImagen();
                    perfiles.remove(perfiles.get(i));
                    if(rutaImagen.equals(rutaEliminar) && perfiles.size() > 0)
                        setImagenPerfil(perfiles.get(0).getRutaImagen(), "absoluta");
                    refrescarPerfiles();
                    if(perfiles.size() == 0){
                        setImagenPerfil("../Logica/Perfiles/perfil.png", "defecto");
                    }
                    
                }
                
                i++;
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

        panelPrincipal = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        spnDia = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        spnMes = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spnAnio = new javax.swing.JSpinner();
        panelPerfil = new javax.swing.JPanel();
        lblImagenPerfil = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSitioWeb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        panelPerfiles = new javax.swing.JScrollPane();
        panelImagenes = new javax.swing.JPanel();
        lblAgregarPerfil = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelBotones, java.awt.BorderLayout.PAGE_END);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nickname:");

        txtNickname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Apellido:");

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Correo electrónico:");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Fecha de nacimiento:");

        spnDia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("/");

        spnMes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("/");

        spnAnio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblImagenPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        txtNombreEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEmpresaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre de empresa:");

        txtSitioWeb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Sitio web:");

        javax.swing.GroupLayout panelImagenesLayout = new javax.swing.GroupLayout(panelImagenes);
        panelImagenes.setLayout(panelImagenesLayout);
        panelImagenesLayout.setHorizontalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );
        panelImagenesLayout.setVerticalGroup(
            panelImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelPerfiles.setViewportView(panelImagenes);

        lblAgregarPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregarPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarPerfilMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Imágenes de perfil:");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAgregarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelPerfiles, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(46, 46, 46)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSitioWeb)
                            .addComponent(txtNombreEmpresa)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
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
                            .addComponent(txtCorreo))))
                .addGap(91, 91, 91)
                .addComponent(panelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(24, 24, 24)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblAgregarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelDatos, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //System.out.println(spnAnio.getValue());
        //System.out.println(cmbTipoUsuario.getSelectedIndex());
        /*boolean imagenCorrecta = false;
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
                        if(this.rutaImagen != "../Logica/perfiles/perfil.PNG")
                        imagenCorrecta = iccli.copiarPerfil(txtNickname.getText(), rutaImagen);
                        else
                        imagenCorrecta = true;
                    }
                    catch(IOException ex){
                        JOptionPane.showMessageDialog(this, "No se ha podido agregar imagen de perfil", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        lblImagenPerfil.requestFocus();
                    }
                    if(imagenCorrecta){

                        try{
                            if(iccli.existeNickname(txtNickname.getText())){
                                JOptionPane.showMessageDialog(this, "El nickname ingresado ya se encuentra en uso", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                txtNickname.requestFocus();
                            }
                            else{
                                iccli.agregarCliente(txtNickname.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), fechaNac , rutaImagen);
                                JOptionPane.showMessageDialog(this, "El nuevo cliente ha sido agregado de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
                                limpiar();
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
            /*boolean fechaValida = false;

            try{
                LocalDate.of((Integer) spnAnio.getValue(), (Integer) spnMes.getValue(), (Integer) spnDia.getValue());
                fechaValida = true;
            }
            catch(DateTimeException ex){
                JOptionPane.showMessageDialog(this, "El fomato de la fecha de nacimiento ingresada para el nuevo usuario es inválida", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                fechaValida = false;
            }

            if(fechaValida){
                fechaNac = LocalDate.of((Integer) spnAnio.getValue(), (Integer) spnMes.getValue(), (Integer) spnDia.getValue());

                else{

                    try{

                        if(this.rutaImagen != "../Logica/perfiles/perfil.PNG")
                        imagenCorrecta = icprov.copiarPerfil(txtNickname.getText(), rutaImagen);
                        else
                        imagenCorrecta = true;

                    }
                    catch(IOException ex){
                        JOptionPane.showMessageDialog(this, "No se ha podido agregar imagen de perfil", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        lblImagenPerfil.requestFocus();
                    }
                    if(imagenCorrecta){

                        try{
                            if(icprov.existeNickname(txtNickname.getText())){
                                JOptionPane.showMessageDialog(this, "El nickname ingresado ya se encuentra en uso", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                txtNickname.requestFocus();
                            }
                            else{
                                if(icprov.existeNombreEmpresa(txtEmpresa.getText())){
                                    JOptionPane.showMessageDialog(this, "El nombre de empresa ingresado ya se encuentra en uso", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                    txtEmpresa.requestFocus();
                                }
                                else{
                                    icprov.agregarProveedor(txtNickname.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), fechaNac, rutaImagen, txtEmpresa.getText(), txtSitioWeb.getText());
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
                //nuevoUsuario = new Cliente(txtNickname.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), fechaNac , rutaImagen, new ArrayList());

                if(!iccli.correoValido(txtCorreo.getText())){
                    JOptionPane.showMessageDialog(this, "El formato del correo electrónico ingresado no es válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    txtCorreo.requestFocus();
                }
                else{
                    try{
                        if(this.rutaImagen != "../Logica/perfiles/perfil.PNG")
                        imagenCorrecta = iccli.copiarPerfil(txtNickname.getText(), rutaImagen);
                        else
                        imagenCorrecta = true;
                    }
                    catch(IOException ex){
                        JOptionPane.showMessageDialog(this, "No se ha podido agregar imagen de perfil", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        lblImagenPerfil.requestFocus();
                    }
                    if(imagenCorrecta){

                        try{
                            if(iccli.existeNickname(txtNickname.getText())){
                                JOptionPane.showMessageDialog(this, "El nickname ingresado ya se encuentra en uso", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                txtNickname.requestFocus();
                            }
                            else{
                                iccli.agregarCliente(txtNickname.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), fechaNac , rutaImagen);
                                JOptionPane.showMessageDialog(this, "El nuevo usuario ha sido agregado de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
                                limpiar();
                            }
                        }
                        catch(SQLException ex){
                            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(ClassNotFoundException ex){
                            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
            }
        } 
        }*/
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void lblImagenPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenPerfilMouseClicked
        /*if(evt.getButton() == MouseEvent.BUTTON1){
            fchImagenes selectorImagen = new fchImagenes(this);
            selectorImagen.setVisible(true);
        }*/

    }//GEN-LAST:event_lblImagenPerfilMouseClicked

    private void txtNombreEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmpresaActionPerformed

    private void lblAgregarPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarPerfilMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1){
            fchImagenes fileChooser = new fchImagenes(this);
            fileChooser.setVisible(true);
        }
    }//GEN-LAST:event_lblAgregarPerfilMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAgregarPerfil;
    private javax.swing.JLabel lblImagenPerfil;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JScrollPane panelPerfiles;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JSpinner spnMes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNickname;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtSitioWeb;
    // End of variables declaration//GEN-END:variables
}
