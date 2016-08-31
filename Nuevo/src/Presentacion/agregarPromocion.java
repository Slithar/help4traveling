/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
/**
 *
 * @author SysAdmin
 */
public class agregarPromocion extends javax.swing.JInternalFrame {

    /**
     * Creates new form agregarPromocion
     */
    private DefaultListModel modelo;
    private DefaultListModel modelo2;
    private IControladorPromociones icpromo;
    private IControladorProveedores icprov;
    private ArrayList<Integer> precioTotal = new ArrayList();
    private int vueltas = 0;
    private int descuento = 0;
    private int precio = 0;
    public agregarPromocion(IControladorPromociones icopromo, IControladorProveedores icprov) {
        initComponents();
        SpinnerNumberModel modelospn = new SpinnerNumberModel(0,0,100,1);
        spnDescuento.setModel(modelospn);
        modelo = new DefaultListModel();
        modelo2 = new DefaultListModel();
        //this.txtPrecioPromo.setEditable(false);
        panelServicios.setBorder(BorderFactory.createTitledBorder("Servicios del proveedor"));
        setTitle("Registro de promociones");
        listaServicios.setModel(modelo);
        listaServiciosElegidos.setModel(modelo2);
        this.txtPrecioPromo.setText("0");
        this.icpromo = icopromo;
        this.icprov = icprov;
        lblSeleccionarServicio.setSize(38, 38);
        ImageIcon iconoServicio = 
        new ImageIcon(getClass().getResource("Imagenes/iconoAgregarCategoria.png"));
        ImageIcon iconoDimensionado = new ImageIcon(iconoServicio.getImage().getScaledInstance(lblSeleccionarServicio.getWidth(), lblSeleccionarServicio.getHeight(), Image.SCALE_DEFAULT));
        lblSeleccionarServicio.setIcon(iconoDimensionado);
        JPopupMenu popupEliminar = new JPopupMenu();
        JMenuItem miEliminar = new JMenuItem("Eliminar");
        miEliminar.setIcon(new ImageIcon(getClass().getResource("Imagenes/iconoEliminar.png")));
        miEliminar.addActionListener(new OyentePopup());
        popupEliminar.add(miEliminar);        
        listaServiciosElegidos.setComponentPopupMenu(popupEliminar);
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (750 - tamanioVentana.height)/2);
        filldb();
        fillLista();
    }
    
    
    
    
    
    public void filldb(){
        int tamProve= 0;
        int inicio=0;
        ArrayList<DataProveedor> prove = new ArrayList();
        try {
            prove = icprov.getProveedores();
        } catch (SQLException ex) {
            Logger.getLogger(agregarPromocion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregarPromocion.class.getName()).log(Level.SEVERE, null, ex);
        }
        tamProve = prove.size();
        for(inicio=0;inicio<tamProve;inicio++){
            this.dbProveedores.addItem(prove.get(inicio).getNombreEmpresa());
        }
    }
    
    
    public void fillLista(){
        modelo.removeAllElements();
        modelo2.removeAllElements();
        ArrayList<DataServicio> servicios = new ArrayList();
        try {
            servicios = this.icprov.getServiciosProveedor(this.dbProveedores.getItemAt(dbProveedores.getSelectedIndex()));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(agregarPromocion.class.getName()).log(Level.SEVERE, null, ex);
        }
        int tamanio = servicios.size();
        int inicio = 0;
        for(inicio=0;inicio<tamanio;inicio++){
            String NombreS;
            NombreS = servicios.get(inicio).getNombreServicio();
            int precioS = servicios.get(inicio).getPrecioServicio();
            String componente = NombreS + " / " + String.valueOf(precioS);
            modelo.addElement(componente);
        }
    }
    
    public void precioPromo(){
        
        //JOptionPane.showMessageDialog(this, precioTotal);
        
        descuento = (Integer) this.spnDescuento.getValue();
        
        precio = icpromo.calcularPrecio(precioTotal, descuento);
        
        this.txtPrecioPromo.setText(String.valueOf(precio));
    }
    public void clearCamps(){
        precio = 0;
        precioTotal = new ArrayList();
        
        dbProveedores.setSelectedIndex(0);
        filldb();
        fillLista();
        this.txtNombrePromo.setText("");
        this.txtPrecioPromo.setText("0");
        modelo2.removeAllElements();
        this.spnDescuento.setValue(0);
        fillLista();
    }
    
    private class OyentePopup implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(listaServiciosElegidos.getSelectedValue()==null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio de la lista de servicios elegidos", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
            else{
                int precioAQuitar = 0;

                precioAQuitar = icpromo.getPrecio(listaServiciosElegidos.getSelectedValue());

                precioTotal.remove(precioTotal.indexOf(precioAQuitar));

                precioPromo();

                modelo.addElement(listaServiciosElegidos.getSelectedValue());

                modelo2.removeElement(listaServiciosElegidos.getSelectedValue());
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

        seleccionarProveedorPanel = new javax.swing.JPanel();
        dbProveedores = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        agregarPromocionPanel = new javax.swing.JPanel();
        txtNombrePromo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spnDescuento = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioPromo = new javax.swing.JLabel();
        panelServicios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaServicios = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaServiciosElegidos = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblSeleccionarServicio = new javax.swing.JLabel();
        agregarPromo = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setToolTipText("");

        dbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbProveedoresActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Proveedor de la promoción:");

        javax.swing.GroupLayout seleccionarProveedorPanelLayout = new javax.swing.GroupLayout(seleccionarProveedorPanel);
        seleccionarProveedorPanel.setLayout(seleccionarProveedorPanelLayout);
        seleccionarProveedorPanelLayout.setHorizontalGroup(
            seleccionarProveedorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seleccionarProveedorPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(seleccionarProveedorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        seleccionarProveedorPanelLayout.setVerticalGroup(
            seleccionarProveedorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seleccionarProveedorPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        txtNombrePromo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre de la promoción:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Precio:");

        spnDescuento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spnDescuento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnDescuentoStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Descuento:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("%");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("U$S");

        txtPrecioPromo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrecioPromo.setText("0");

        javax.swing.GroupLayout agregarPromocionPanelLayout = new javax.swing.GroupLayout(agregarPromocionPanel);
        agregarPromocionPanel.setLayout(agregarPromocionPanelLayout);
        agregarPromocionPanelLayout.setHorizontalGroup(
            agregarPromocionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarPromocionPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(agregarPromocionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombrePromo)
                    .addGroup(agregarPromocionPanelLayout.createSequentialGroup()
                        .addGroup(agregarPromocionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(agregarPromocionPanelLayout.createSequentialGroup()
                                .addComponent(spnDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(0, 165, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(agregarPromocionPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(agregarPromocionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(agregarPromocionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioPromo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        agregarPromocionPanelLayout.setVerticalGroup(
            agregarPromocionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarPromocionPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombrePromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(agregarPromocionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(agregarPromocionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecioPromo))
                .addGap(98, 98, 98))
        );

        listaServicios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(listaServicios);

        listaServiciosElegidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(listaServiciosElegidos);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nombre / Precio (En U$S)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Servicios seleccionados:");

        lblSeleccionarServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSeleccionarServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSeleccionarServicioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelServiciosLayout = new javax.swing.GroupLayout(panelServicios);
        panelServicios.setLayout(panelServiciosLayout);
        panelServiciosLayout.setHorizontalGroup(
            panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServiciosLayout.createSequentialGroup()
                .addGroup(panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServiciosLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(panelServiciosLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(lblSeleccionarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelServiciosLayout.setVerticalGroup(
            panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServiciosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(lblSeleccionarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        agregarPromo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        agregarPromo.setText("Aceptar");
        agregarPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPromoActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seleccionarProveedorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregarPromocionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(agregarPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seleccionarProveedorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(agregarPromocionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 95, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(panelServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarPromo)
                    .addComponent(cancelar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbProveedoresActionPerformed
        
        this.spnDescuento.setValue(0);
        
        this.txtPrecioPromo.setText("0");
        
        fillLista();
    }//GEN-LAST:event_dbProveedoresActionPerformed

    private void spnDescuentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnDescuentoStateChanged
        // TODO add your handling code here:
        precioPromo();
    }//GEN-LAST:event_spnDescuentoStateChanged

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void agregarPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPromoActionPerformed
        // TODO add your handling code here:
        boolean errores = false;
        int resultadoPromocion = 0;
        int resultadoServiciosPromocion = 0;
        if(this.txtNombrePromo.getText().isEmpty() && errores == false){
            JOptionPane.showMessageDialog(null, "No se ha ingresado el nombre de la promoción", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            errores = true;
        }
        if(this.listaServiciosElegidos.getModel().getSize()==0 && errores == false ){
            JOptionPane.showMessageDialog(null, "Una promocion debe contener al menos un servicio", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            errores = true;
        }
        if(errores == false){            
            try {
                //JOptionPane.showMessageDialog(this, this.precio);
                resultadoPromocion = this.icpromo.agregarPromocion(this.precio, this.txtNombrePromo.getText(), this.descuento, String.valueOf(this.dbProveedores.getSelectedItem()));
                for(vueltas = 0; vueltas < this.listaServiciosElegidos.getModel().getSize(); vueltas ++){
                    String servicio = this.icpromo.getNombreServicio(this.listaServiciosElegidos.getModel().getElementAt(vueltas));
                    resultadoServiciosPromocion = this.icpromo.agregarServiciosPromocion(this.txtNombrePromo.getText(),servicio,this.dbProveedores.getSelectedItem().toString());   
                }
                /*if(resultadoPromocion == 1 && resultadoServiciosPromocion == this.listaServiciosElegidos.getModel().getSize()-1){
                    JOptionPane.showMessageDialog(null, "La promoción ha sido agregada de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
                }*/
                JOptionPane.showMessageDialog(this, "La promoción ha sido agregada de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
                clearCamps();
            } catch (SQLException | ClassNotFoundException ex) {
                //if(ex.getMessage().substring(0, 15))
                //JOptionPane.showMessageDialog(null, "Ha ocurrido un error con la base de datos. Por favor intente denuevo mas tarde.", "ERROR", JOptionPane.ERROR_MESSAGE);
                
                if(ex.getMessage().substring(0, 15).equals("Duplicate entry")){
                    JOptionPane.showMessageDialog(this, "El nombre de la promoción ya existe para el proveedor indicado", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    txtNombrePromo.requestFocus();
                }
                else
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error con la base de datos. Por favor intente denuevo mas tarde.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_agregarPromoActionPerformed

    private void lblSeleccionarServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSeleccionarServicioMouseClicked
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
        if(this.listaServicios.getSelectedValue()==null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio de la lsita de servicios", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            precio = icpromo.getPrecio(listaServicios.getSelectedValue());

            precioTotal.add(precio);

            precioPromo();

            modelo2.addElement(listaServicios.getSelectedValue());

            modelo.removeElement(listaServicios.getSelectedValue());
        }
    }//GEN-LAST:event_lblSeleccionarServicioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarPromo;
    private javax.swing.JPanel agregarPromocionPanel;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> dbProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSeleccionarServicio;
    private javax.swing.JList<String> listaServicios;
    private javax.swing.JList<String> listaServiciosElegidos;
    private javax.swing.JPanel panelServicios;
    private javax.swing.JPanel seleccionarProveedorPanel;
    private javax.swing.JSpinner spnDescuento;
    private javax.swing.JTextField txtNombrePromo;
    private javax.swing.JLabel txtPrecioPromo;
    // End of variables declaration//GEN-END:variables
}
