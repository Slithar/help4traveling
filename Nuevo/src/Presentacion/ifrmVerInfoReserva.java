/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;


/**
 *
 * @author usuario
 */
public class ifrmVerInfoReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmVerInfoReserva
     */
    
    private IControladorClientes iccli;
    private IControladorProveedores icprov;
    
        private String[] columnas = {"Nombre", "Proveedor", "Empresa", "Cantidad", "Precio unitario", "Total línea","Fecha inicio", "Fecha fin", "Tipo"};
        private DefaultTableModel datosPromocionServ = new DefaultTableModel(null, columnas) {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    
    public ifrmVerInfoReserva() {
        initComponents();
    }
    
    public ifrmVerInfoReserva(IControladorClientes iccli, IControladorProveedores icprov) {
        initComponents();
        setTitle("Ver información de reservas");
        Dimension tamanioVentana = this.getSize();
        setLocation((1400 - tamanioVentana.width)/2, (675 - tamanioVentana.height)/2);
        
        this.iccli = iccli;
        this.icprov = icprov;
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Número", "Fecha", "Cliente"});
        
        try{
            ArrayList<String> numRes= this.iccli.verInfoReserva(); 
            
            for(int i =0;i<numRes.size();i++){
                DataReserva dr = this.iccli.getReserva(numRes.get(i));
                model.addRow(new Object[]{numRes.get(i), String.valueOf(dr.getFecha().getDayOfMonth()) + "/" + String.valueOf(dr.getFecha().getMonthValue()) + "/" + String.valueOf(dr.getFecha().getYear()), dr.getCliente()});
            }
            
            tblReservas.setModel(model);
         
        }catch(Exception e){}
        
        tblReservas.getSelectionModel().addListSelectionListener(new OyenteSeleccion());
        tblReservas.changeSelection(0, 0, false, false);
        
        
        
        /*listRes.setModel(model);
        listRes.getSelectionModel().addListSelectionListener(new OyenteSeleccion());
        listRes.setSelectedIndex(0);*/
        
        //panelInfo.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos = new javax.swing.JPanel();
        panelBuscar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        panelInfo = new javax.swing.JPanel();
        jlabel2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jnickCliente = new javax.swing.JLabel();
        jPrecio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jEstado = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jlabel3 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        jNumero = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione reserva:");

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Fecha", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblReservas);

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel2.setText("Nickname del cliente: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Precio:");

        jnickCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jnickCliente.setText("nick");

        jPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPrecio.setText("precio");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Fecha:");

        jFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFecha.setText("fecha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Estado: ");

        jEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jEstado.setText("estado");

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Proveedor", "Empresa", "Cantidad", "Precio unitario", "Total línea", "Fecha Inicio", "Fecha Fin", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable);

        jlabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel3.setText("Productos:");

        jlabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabel4.setText("Número:");

        jNumero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jNumero.setText("numero");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jnickCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jlabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jnickCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPrecio)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFecha)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jlabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        getContentPane().add(panelDatos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void verInformacionReserva(){
        if(tblReservas.getSelectedRow() > -1){
            String selected =tblReservas.getValueAt(tblReservas.getSelectedRow(), 0).toString();
            //String selected = "";
            
            try{
                datosPromocionServ = new DefaultTableModel(null, columnas);
                DataReserva dtcant =this.iccli.getReserva(selected);
                this.jNumero.setText(selected);
                this.jnickCliente.setText(dtcant.getCliente());
                this.jPrecio.setText("U$S " + dtcant.getPrecio());
                this.jFecha.setText(dtcant.getFecha().getDayOfMonth() + "/" + dtcant.getFecha().getMonthValue() + "/" + dtcant.getFecha().getYear());
                this.jEstado.setText(dtcant.getEstado().toString());

                ArrayList <DataCantidadReservasPromociones>  listProm=this.iccli.getReservasPromo(selected);
                ArrayList<DataCantidadReservasServicios>listServ=this.iccli.getReservasServ(selected);
                if(listProm.size()>0){
                    for(int i=0;i<listProm.size();i++){
                        DataCantidadReservasPromociones promAux=listProm.get(i);
                        Object[] fila = {promAux.getPromocion(), promAux.getProveedor(), icprov.getNombreEmpresa(promAux.getProveedor()).getNombreEmpresa(), promAux.getCantidad(), promAux.getTotalLinea() / promAux.getCantidad(), promAux.getTotalLinea(), promAux.getFechaInicio().getDayOfMonth() + "/" + promAux.getFechaInicio().getMonthValue() + "/" + promAux.getFechaInicio().getYear(),promAux.getFechaFin().getDayOfMonth() + "/" + promAux.getFechaFin().getMonthValue()+ "/" + promAux.getFechaFin().getYear(),"PROMOCIÓN"};

                        datosPromocionServ.addRow(fila);
                    }
                    jTable.setModel(datosPromocionServ);
                }

                if(listServ.size()>0){
                    for(int i=0;i<listServ.size();i++){
                        DataCantidadReservasServicios promAux=listServ.get(i);
                        Object[] fila = {promAux.getServicio(), promAux.getProveedor(), icprov.getNombreEmpresa(promAux.getProveedor()).getNombreEmpresa(), promAux.getCantidad(), promAux.getTotalLinea() / promAux.getCantidad(), promAux.getTotalLinea(), promAux.getFechaInicio().getDayOfMonth() + "/" + promAux.getFechaInicio().getMonthValue() + "/" + promAux.getFechaInicio().getYear(),promAux.getFechaFin().getDayOfMonth() + "/" + promAux.getFechaFin().getMonthValue()+ "/" + promAux.getFechaFin().getYear(),"SERVICIO"};

                        datosPromocionServ.addRow(fila);
                    }
                    jTable.setModel(datosPromocionServ);
                }
                panelInfo.setVisible(true);
            }catch(Exception e){}
        }
    }
    
    private class OyenteSeleccion implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            verInformacionReserva();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jEstado;
    private javax.swing.JLabel jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jNumero;
    private javax.swing.JLabel jPrecio;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel jnickCliente;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JTable tblReservas;
    // End of variables declaration//GEN-END:variables
}
