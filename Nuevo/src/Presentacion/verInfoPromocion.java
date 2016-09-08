/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DataPromocion;
import Logica.DataServicio;
import Logica.IControladorCategorias;
import Logica.IControladorPromociones;
import Logica.IControladorProveedores;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Mauro
 */
public class verInfoPromocion extends javax.swing.JInternalFrame {

    /**
     * Creates new form verInfoPromocion
     */
    private IControladorPromociones icpromo;
    private IControladorProveedores icprov;
    private IControladorCategorias iccat;
    private int vueltas=0;
    private DefaultListModel modelo = new DefaultListModel();
    
    public verInfoPromocion(IControladorPromociones icpromo,IControladorProveedores icprov, IControladorCategorias iccat) {
        initComponents();
        
        setTitle("Ver información de promociones");
        
        Dimension tamanioVentana = this.getSize();

        setLocation((1400 - tamanioVentana.width)/2, (750 - tamanioVentana.height)/2);
        
        this.icpromo=icpromo;
        this.iccat = iccat;
        this.icprov = icprov;
        ArrayList<DataPromocion> dPromo = new ArrayList();
        panelInfoPromocion.setVisible(false);
        try {
            dPromo = icpromo.getPromociones();
            for (vueltas = 0; vueltas < dPromo.size(); vueltas ++){
                String DB = "";
                DB = dPromo.get(vueltas).getNombre() + " / " + dPromo.get(vueltas).getProveedor() + " / " + icprov.getNombreEmpresa(dPromo.get(vueltas).getProveedor()).getNombreEmpresa();  
                this.modelo.addElement(DB);               
            }
            lstPromociones.setModel(modelo);
            lstPromociones.getSelectionModel().addListSelectionListener(new OyenteSeleccion());
            lstPromociones.setSelectedIndex(0);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(verInfoPromocion.class.getName()).log(Level.SEVERE, null, ex);
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

        panelPromocion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPromociones = new javax.swing.JList<>();
        panelInfoPromocion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JLabel();
        txtPrecioPromo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        dbServicios = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione promoción:");

        lstPromociones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(lstPromociones);

        javax.swing.GroupLayout panelPromocionLayout = new javax.swing.GroupLayout(panelPromocion);
        panelPromocion.setLayout(panelPromocionLayout);
        panelPromocionLayout.setHorizontalGroup(
            panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPromocionLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        panelPromocionLayout.setVerticalGroup(
            panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPromocionLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Precio:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Descuento:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Proveedor:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setText("nombre");

        txtProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtProveedor.setText("proveedor");

        txtDescuento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescuento.setText("100");

        txtPrecioPromo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPrecioPromo.setText("100");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Servicios:");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        dbServicios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Empresa:");

        txtEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmpresa.setText("empresa");

        javax.swing.GroupLayout panelInfoPromocionLayout = new javax.swing.GroupLayout(panelInfoPromocion);
        panelInfoPromocion.setLayout(panelInfoPromocionLayout);
        panelInfoPromocionLayout.setHorizontalGroup(
            panelInfoPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoPromocionLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelInfoPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtEmpresa)
                    .addComponent(txtDescuento)
                    .addComponent(jLabel6)
                    .addComponent(txtProveedor)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecioPromo)
                    .addComponent(txtNombre)
                    .addComponent(jLabel5)
                    .addGroup(panelInfoPromocionLayout.createSequentialGroup()
                        .addComponent(dbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelInfoPromocionLayout.setVerticalGroup(
            panelInfoPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoPromocionLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre)
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProveedor)
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmpresa)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescuento)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioPromo)
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(dbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInfoPromocion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPromocion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelInfoPromocion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void verInformacionPromocion(){
        if(lstPromociones.getSelectedIndex() > -1){
            dbServicios.removeAllItems();
            String promocion = "";
            promocion = this.lstPromociones.getSelectedValue();
            String NombrePromo = "";
            String NombreProv = "";

            NombrePromo = getNombrePromo(promocion);
            NombreProv = getNombreProv(promocion);
            DataPromocion promo = new DataPromocion();
            ArrayList<DataServicio> servicios = new ArrayList<DataServicio>();
            try {
                promo = this.icpromo.getDataPromocion(NombrePromo, NombreProv);
                servicios = this.icpromo.getServiciosPromocion(NombrePromo, NombreProv);
                for(int i=0;i<servicios.size();i++){
                    dbServicios.addItem(servicios.get(i).getNombreServicio());
                }
                this.txtNombre.setText(NombrePromo);
                this.txtProveedor.setText(NombreProv);
                this.txtEmpresa.setText(getEmpresa(promocion));
                this.txtDescuento.setText(String.valueOf(promo.getDescuento()) + "%");
                this.txtPrecioPromo.setText("U$S " + String.valueOf(promo.getPrecio()));
                panelInfoPromocion.setVisible(true);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(verInfoPromocion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String servicio = "";
        servicio = this.dbServicios.getSelectedItem().toString();
        ifrmInformacionServicios info = new ifrmInformacionServicios(this.icprov,this.iccat,servicio, txtProveedor.getText(), txtEmpresa.getText());
        getParent().add(info);
        info.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed
    public String getNombrePromo(String cadena){
    
        String [] partes = new String[2];

        partes = cadena.split("/");

        String nombre;

        nombre = String.valueOf(partes[0].trim());

        return nombre;
    }
    public String getNombreProv(String cadena){
    
        String [] partes = new String[2];

        partes = cadena.split("/");

        String nombre;

        nombre = String.valueOf(partes[1].trim());

        return nombre;
        
        /*verificación*/
    }
    
    public String getEmpresa(String cadena){
    
        String [] partes = new String[3];

        partes = cadena.split("/");

        String nombre;

        nombre = String.valueOf(partes[2].trim());

        return nombre;
        
        /*verificación*/
    }
    
    private class OyenteSeleccion implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            verInformacionPromocion();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> dbServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstPromociones;
    private javax.swing.JPanel panelInfoPromocion;
    private javax.swing.JPanel panelPromocion;
    private javax.swing.JLabel txtDescuento;
    private javax.swing.JLabel txtEmpresa;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtPrecioPromo;
    private javax.swing.JLabel txtProveedor;
    // End of variables declaration//GEN-END:variables
}