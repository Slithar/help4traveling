/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;

/**
 *
 * @author usuario
 */
public class frmMenuPrincipal extends javax.swing.JFrame {
    public static Panel nuevoPanel = new Panel();
    private IControladorClientes iccli;
    private IControladorProveedores icprov;
    private IControladorCategorias iccat;
    private IControladorPromociones icprom;
    private IControladorLogs iclog;
    
    private frmProgresoDatos vProgreso;
    /**
     * Creates new form frmMenuPrincipal
     */
    public frmMenuPrincipal() {
        initComponents();
        setContentPane(nuevoPanel);
        Fabrica fab = new Fabrica();
        iccat = fab.getIControladorCategorias();
        iccli = fab.getIControladorClientes();
        icprov = fab.getIControladorProveedores();
        icprom = fab.getIControladorPromociones();
        iclog = fab.getIControladorLogs();
        Toolkit pc = Toolkit.getDefaultToolkit();
        Image icono = pc.getImage("src/Presentacion/Imagenes/iconoHelp4Traveling.png");
        
        this.setIconImage(icono);
        
       
        try {
            /*byte[] bytes = iccli.imagenLogueado("ewatson");
            JOptionPane.showMessageDialog(null, bytes.length);*/
            /*BufferedImage img = iccli.imagenLogueado("BruceS");
            File outputfile = new File("src/Logica/");
            File outputfile2 = new File(outputfile.getAbsolutePath() + "/saved.jpg");
            ImageIO.write(img, "png", outputfile2); // Write the Buffered Image into an output file

            JOptionPane.showMessageDialog(null, "LISTO!");*/
            /*try{
            iccat.actualizarCategorias();
            icprov.setListaCategorias(iccat.getListaCategorias());
            icprov.actualizarProveedores();
            icprov.actualizarCiudades();
            icprom.setListaProveedores(icprov.getListaProveedores());
            icprom.actualizarPromociones();
            iccli.setListaPromociones(icprom.getListaPromociones());
            iccli.setListaProveedores(icprov.getListaProveedores());            
            iccli.actualizarClientes();
            }
            catch(SQLException ex){
            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            System.out.println("CATEGORÍAS: " + iccat.getCantCategorias());
            System.out.println("PROVEEDORES: " + icprov.getCantProveedores());
            System.out.println("CIUDADES: " + icprov.getCantCiudades());
            System.out.println("PROMOCIONES: " + icprom.getCantPromociones());
            System.out.println("CLIENTES: " + iccli.getCantClientes());*/
           /* ArrayList<DataServicio> serviciosPrecio = icprov.getServiciosPorCategoriaOrdenPrecio("Alojamiento");
            for(int i = 0; i< serviciosPrecio.size(); i++){
                JOptionPane.showMessageDialog(null, serviciosPrecio.get(i).getNombreServicio());
            }*/
           
           ArrayList<DataPromocion> promociones = icprom.getMaxPromociones();
           //JOptionPane.showMessageDialog(null, promociones.get(1).getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(frmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } /*catch (IOException ex) {
            Logger.getLogger(frmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void setCursorFrame(Cursor c){
        this.setCursor(c);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mbBarra = new javax.swing.JMenuBar();
        mInicio = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();
        mRegistros = new javax.swing.JMenu();
        miRegClientes = new javax.swing.JMenuItem();
        miRegProveedores = new javax.swing.JMenuItem();
        miCategorias = new javax.swing.JMenuItem();
        mRegServicios = new javax.swing.JMenu();
        miRegServiciosNuevo = new javax.swing.JMenuItem();
        miRegServiciosActualizar = new javax.swing.JMenuItem();
        miRegPromociones = new javax.swing.JMenuItem();
        mReservas = new javax.swing.JMenu();
        miCancelarReserva = new javax.swing.JMenuItem();
        miActualizarReserva = new javax.swing.JMenuItem();
        mConsultas = new javax.swing.JMenu();
        miConsClientes = new javax.swing.JMenuItem();
        miConsProveedores = new javax.swing.JMenuItem();
        miConsServicios = new javax.swing.JMenuItem();
        miConsPromociones = new javax.swing.JMenuItem();
        miConsReservas = new javax.swing.JMenuItem();
        mAccesos = new javax.swing.JMenu();
        miRegistros = new javax.swing.JMenuItem();
        miEstadisticasServicios = new javax.swing.JMenuItem();
        mDatos = new javax.swing.JMenu();
        miDatosDePrueba = new javax.swing.JMenuItem();
        mEliminarDatos = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mInicio.setText("Inicio");

        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        mInicio.add(miSalir);

        mbBarra.add(mInicio);

        mRegistros.setText("Registros");

        miRegClientes.setText("Clientes");
        miRegClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegClientesActionPerformed(evt);
            }
        });
        mRegistros.add(miRegClientes);

        miRegProveedores.setText("Proveedores");
        miRegProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegProveedoresActionPerformed(evt);
            }
        });
        mRegistros.add(miRegProveedores);

        miCategorias.setText("Categorias");
        miCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoriasActionPerformed(evt);
            }
        });
        mRegistros.add(miCategorias);

        mRegServicios.setText("Servicios");

        miRegServiciosNuevo.setText("Nuevo");
        miRegServiciosNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegServiciosNuevoActionPerformed(evt);
            }
        });
        mRegServicios.add(miRegServiciosNuevo);

        miRegServiciosActualizar.setText("Actualizar");
        miRegServiciosActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegServiciosActualizarActionPerformed(evt);
            }
        });
        mRegServicios.add(miRegServiciosActualizar);

        mRegistros.add(mRegServicios);

        miRegPromociones.setText("Promociones");
        miRegPromociones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegPromocionesActionPerformed(evt);
            }
        });
        mRegistros.add(miRegPromociones);

        mbBarra.add(mRegistros);

        mReservas.setText("Reservas");

        miCancelarReserva.setText("Cancelar reserva");
        miCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCancelarReservaActionPerformed(evt);
            }
        });
        mReservas.add(miCancelarReserva);

        miActualizarReserva.setText("Actualizar reserva");
        miActualizarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miActualizarReservaActionPerformed(evt);
            }
        });
        mReservas.add(miActualizarReserva);

        mbBarra.add(mReservas);

        mConsultas.setText("Consultas");

        miConsClientes.setText("Clientes");
        miConsClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsClientesActionPerformed(evt);
            }
        });
        mConsultas.add(miConsClientes);

        miConsProveedores.setText("Proveedores");
        miConsProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsProveedoresActionPerformed(evt);
            }
        });
        mConsultas.add(miConsProveedores);

        miConsServicios.setText("Servicios");
        miConsServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsServiciosActionPerformed(evt);
            }
        });
        mConsultas.add(miConsServicios);

        miConsPromociones.setText("Promociones");
        miConsPromociones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsPromocionesActionPerformed(evt);
            }
        });
        mConsultas.add(miConsPromociones);

        miConsReservas.setText("Reservas");
        miConsReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsReservasActionPerformed(evt);
            }
        });
        mConsultas.add(miConsReservas);

        mbBarra.add(mConsultas);

        mAccesos.setText("Accesos al sitio");

        miRegistros.setText("Registros de accesos");
        miRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrosActionPerformed(evt);
            }
        });
        mAccesos.add(miRegistros);

        miEstadisticasServicios.setText("Estadísticas de servicios");
        miEstadisticasServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEstadisticasServiciosActionPerformed(evt);
            }
        });
        mAccesos.add(miEstadisticasServicios);

        mbBarra.add(mAccesos);

        mDatos.setText("Datos del sistema");

        miDatosDePrueba.setText("Cargar datos de prueba");
        miDatosDePrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDatosDePruebaActionPerformed(evt);
            }
        });
        mDatos.add(miDatosDePrueba);

        mEliminarDatos.setText("Eliminar datos");
        mEliminarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEliminarDatosActionPerformed(evt);
            }
        });
        mDatos.add(mEliminarDatos);

        mbBarra.add(mDatos);

        setJMenuBar(mbBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        if(JOptionPane.showConfirmDialog(this, "¿Esta seguro/a de que desea salir del sistema?", "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION) == 0)
            this.dispose();
    }//GEN-LAST:event_miSalirActionPerformed

    private void miActualizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miActualizarReservaActionPerformed
        ifrmActualizarEstadoReserva  agregar = new ifrmActualizarEstadoReserva(this.iccli);
        nuevoPanel.add(agregar);
        agregar.setVisible(true);
    }//GEN-LAST:event_miActualizarReservaActionPerformed

    private void NuevaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaCatActionPerformed
        nuevaCateFrame agregar = new nuevaCateFrame();
        add(agregar);
        agregar.setVisible(true);
    }//GEN-LAST:event_NuevaCatActionPerformed

    private void miRegClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegClientesActionPerformed
       ifrmAltaUsuarios vAltaUsuarios = new ifrmAltaUsuarios(this.iccli);
       nuevoPanel.add(vAltaUsuarios);
       vAltaUsuarios.show();
        
    }//GEN-LAST:event_miRegClientesActionPerformed

    private void miRegServiciosNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegServiciosNuevoActionPerformed
        ifrmAltaServicio vAltaServicio = new ifrmAltaServicio(icprov, iccat);
        nuevoPanel.add(vAltaServicio);
        vAltaServicio.setVisible(true);        
        
    }//GEN-LAST:event_miRegServiciosNuevoActionPerformed

    private void miCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriasActionPerformed
        nuevaCateFrame agregar = new nuevaCateFrame(this.iccat);
        add(agregar);
        agregar.setVisible(true);
    }//GEN-LAST:event_miCategoriasActionPerformed

    private void miRegServiciosActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegServiciosActualizarActionPerformed
        ifrmActualizarServicio vActualizarServicio = new ifrmActualizarServicio(icprov, iccat);
        nuevoPanel.add(vActualizarServicio);
        vActualizarServicio.setVisible(true);
    }//GEN-LAST:event_miRegServiciosActualizarActionPerformed

    private void miConsServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsServiciosActionPerformed
       ifrmInformacionServicios vInformacionServicio = new ifrmInformacionServicios(icprov, iccat);
       nuevoPanel.add(vInformacionServicio);
       vInformacionServicio.setVisible(true);
    }//GEN-LAST:event_miConsServiciosActionPerformed
    private void miConsReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsReservasActionPerformed
        ifrmVerInfoReserva agregar = new ifrmVerInfoReserva(this.iccli, this.icprov);
        nuevoPanel.add(agregar);
        agregar.setVisible(true);
        
    }//GEN-LAST:event_miConsReservasActionPerformed

    private void miRegProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegProveedoresActionPerformed
        ifrmAltaProveedores vProveedores = new ifrmAltaProveedores(icprov);
        nuevoPanel.add(vProveedores);
        vProveedores.setVisible(true);
    }//GEN-LAST:event_miRegProveedoresActionPerformed

    private void miConsClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsClientesActionPerformed
        ifrmVerInfoClientes vVerInfoCliente = new ifrmVerInfoClientes(this.iccli);
        nuevoPanel.add(vVerInfoCliente);
        vVerInfoCliente.setVisible(true);
    }//GEN-LAST:event_miConsClientesActionPerformed

    private void miDatosDePruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDatosDePruebaActionPerformed
        
        
        vProgreso = new frmProgresoDatos("Cargando datos de prueba");
        vProgreso.setVisible(true);
        if(JOptionPane.showConfirmDialog(this, "¿Está seguro/a de que desea cargar los datos de prueba?", "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION) == 0){
            this.setCursorFrame(new Cursor(Cursor.WAIT_CURSOR));
            try{
                
                
                this.icprov.eliminarImagenesUsuarios();
                this.icprov.eliminarImagenesServicios();

                this.iccat.deleteAllCategorias();
                this.icprov.deleteAllProveedores();
                this.icprom.deleteAllPromociones();
                this.iccli.deleteAllClientes();

                this.iccat.insertCategoriasDePrueba();
                this.icprov.insertCiudadesDePrueba();
                this.icprov.insertDatosProveedoresDePrueba();
                this.icprom.insertDatosPromocionesDePrueba();
                this.iccli.insertDatosClientesDePrueba();
                
                this.setCursorFrame(new Cursor(Cursor.DEFAULT_CURSOR));
                
                JOptionPane.showMessageDialog(this, "Se han cargado los datos de prueba de manera correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
                
                vProgreso.setVisible(false);
            }
            catch(SQLException ex){
                //JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                this.setCursorFrame(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                this.setCursorFrame(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
        else{
            vProgreso.setVisible(false);
            this.setCursorFrame(new Cursor(Cursor.DEFAULT_CURSOR));
        }       
    }//GEN-LAST:event_miDatosDePruebaActionPerformed

    private void mEliminarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEliminarDatosActionPerformed
        vProgreso = new frmProgresoDatos("Eliminando datos del sistema");
        vProgreso.setVisible(true);
        if(JOptionPane.showConfirmDialog(this, "¿Está seguro/a de que desea eliminar todos los datos del sistema?", "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION) == 0){
            
            try{
                this.setCursorFrame(new Cursor(Cursor.WAIT_CURSOR));
                
                this.icprov.eliminarImagenesUsuarios();
                this.icprov.eliminarImagenesServicios();

                this.iccat.deleteAllCategorias();
                this.icprov.deleteAllProveedores();
                this.icprom.deleteAllPromociones();
                this.iccli.deleteAllClientes();

                this.iccat.insertCategoriasDePrueba();
                this.icprov.insertCiudadesDePrueba();
                
                this.setCursorFrame(new Cursor(Cursor.DEFAULT_CURSOR));
                JOptionPane.showMessageDialog(this, "Se han eliminado los datos del sistema correcta", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
                vProgreso.setVisible(false);
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Hay un problema de conexión con la base de datos, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                this.setCursorFrame(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
                this.setCursorFrame(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
        else{
            vProgreso.setVisible(false);
            this.setCursorFrame(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_mEliminarDatosActionPerformed
    private void miRegPromocionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegPromocionesActionPerformed
        agregarPromocion promo = new agregarPromocion(icprom,icprov);
        add(promo);
        promo.setVisible(true);
    }//GEN-LAST:event_miRegPromocionesActionPerformed

    private void miCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCancelarReservaActionPerformed
        ifrmCancelarReserva vCancelarReserva = new ifrmCancelarReserva(iccli);
        nuevoPanel.add(vCancelarReserva);
        vCancelarReserva.setVisible(true);
    }//GEN-LAST:event_miCancelarReservaActionPerformed

    private void miConsPromocionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsPromocionesActionPerformed
        verInfoPromocion promo = new verInfoPromocion(this.icprom, this.icprov,this.iccat);
        add(promo);
        promo.setVisible(true);
    }//GEN-LAST:event_miConsPromocionesActionPerformed
    private void miConsProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsProveedoresActionPerformed
        ifrmVerInfoProveedores vVerInfoProveedores = new ifrmVerInfoProveedores(this.icprov);
        nuevoPanel.add(vVerInfoProveedores);
        vVerInfoProveedores.setVisible(true);
    }//GEN-LAST:event_miConsProveedoresActionPerformed

    private void miRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrosActionPerformed
        ifrmRegistrosAccesos vRegistros = new ifrmRegistrosAccesos(this.iclog);
        nuevoPanel.add(vRegistros);
        vRegistros.setVisible(true);
    }//GEN-LAST:event_miRegistrosActionPerformed

    private void miEstadisticasServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEstadisticasServiciosActionPerformed
        ifrmEstadisticas vEstadisticas = new ifrmEstadisticas(this.icprov);
        
        //JPanel panel = new JPanel();
        //vEstadisticas.getContentPane().add(panel);
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        try{
            ArrayList<DataServicio> servicios = icprov.getServiciosMasVisitados();
            for(int i = 0; i < servicios.size(); i++){
                data.addValue(servicios.get(i).getVisitas(), "Servicio", servicios.get(i).getNombreServicio() + " (" + servicios.get(i).getNombreProveedor() + ")");
            }
            
            JFreeChart grafica = ChartFactory.createBarChart("Servicios más visitados", "Servicio", "Visitas", data, PlotOrientation.HORIZONTAL, false, true, false);
            
            ChartPanel contenedor = new ChartPanel(grafica);
            vEstadisticas.setContentPane(contenedor);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "El número de la reserva indicada es incorrecto", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se ha podido encontrar librería SQL, por lo que no fue posible completar la acción", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        nuevoPanel.add(vEstadisticas);
        vEstadisticas.setVisible(true);
    }//GEN-LAST:event_miEstadisticasServiciosActionPerformed
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuPrincipal().setVisible(true);
            }
        });
        
        
    }
    
   
    

    
    //public void paintCom

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu mAccesos;
    private javax.swing.JMenu mConsultas;
    private javax.swing.JMenu mDatos;
    private javax.swing.JMenuItem mEliminarDatos;
    private javax.swing.JMenu mInicio;
    private javax.swing.JMenu mRegServicios;
    private javax.swing.JMenu mRegistros;
    private javax.swing.JMenu mReservas;
    private javax.swing.JMenuBar mbBarra;
    private javax.swing.JMenuItem miActualizarReserva;
    private javax.swing.JMenuItem miCancelarReserva;
    private javax.swing.JMenuItem miCategorias;
    private javax.swing.JMenuItem miConsClientes;
    private javax.swing.JMenuItem miConsPromociones;
    private javax.swing.JMenuItem miConsProveedores;
    private javax.swing.JMenuItem miConsReservas;
    private javax.swing.JMenuItem miConsServicios;
    private javax.swing.JMenuItem miDatosDePrueba;
    private javax.swing.JMenuItem miEstadisticasServicios;
    private javax.swing.JMenuItem miRegClientes;
    private javax.swing.JMenuItem miRegPromociones;
    private javax.swing.JMenuItem miRegProveedores;
    private javax.swing.JMenuItem miRegServiciosActualizar;
    private javax.swing.JMenuItem miRegServiciosNuevo;
    private javax.swing.JMenuItem miRegistros;
    private javax.swing.JMenuItem miSalir;
    // End of variables declaration//GEN-END:variables
}

class Panel extends JDesktopPane{
    
    public Panel(){
              
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


