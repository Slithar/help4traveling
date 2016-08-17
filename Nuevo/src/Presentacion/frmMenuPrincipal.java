/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 *
 * @author usuario
 */
public class frmMenuPrincipal extends javax.swing.JFrame {
   // private ifrmAltaUsuarios altaUsuarios = new ifrmAltaUsuarios();
    //private ifrmAltaUsuarios vAltaUsuarios = new ifrmAltaUsuarios();
    Panel nuevoPanel = new Panel();
    private IControladorClientes iccli;
    private IControladorProveedores icprov;
    private IControladorCategorias iccat;
    private IControladorPromociones icprom;
    /**
     * Creates new form frmMenuPrincipal
     */
    public frmMenuPrincipal() {
        initComponents();
        //add(altaUsuarios);
        //aca el comentario de mi rama
        //add(new Panel());
        //hola otro comentario de master
        
        setContentPane(nuevoPanel);
        Fabrica fab = new Fabrica();
        iccli = fab.getIControladorClientes();
        icprov = fab.getIControladorProveedores();
        iccat = fab.getIControladorCategorias();
        icprom = fab.getIControladorPromociones();
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
        mbBarra = new javax.swing.JMenuBar();
        mInicio = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();
        mRegistros = new javax.swing.JMenu();
        miRegUsuarios = new javax.swing.JMenuItem();
        miCategorias = new javax.swing.JMenuItem();
        mRegServicios = new javax.swing.JMenu();
        miRegServiciosNuevo = new javax.swing.JMenuItem();
        miRegServiciosActualizar = new javax.swing.JMenuItem();
        miRegPromociones = new javax.swing.JMenuItem();
        mReservas = new javax.swing.JMenu();
        miNuevaReserva = new javax.swing.JMenuItem();
        miCancelarReserva = new javax.swing.JMenuItem();
        miActualizarReserva = new javax.swing.JMenuItem();
        mConsultas = new javax.swing.JMenu();
        miConsClientes = new javax.swing.JMenuItem();
        miConsProveedores = new javax.swing.JMenuItem();
        miConsServicios = new javax.swing.JMenuItem();
        miConsPromociones = new javax.swing.JMenuItem();
        miConsReservas = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

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

        miRegUsuarios.setText("Usuarios");
        miRegUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegUsuariosActionPerformed(evt);
            }
        });
        mRegistros.add(miRegUsuarios);

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
        mRegServicios.add(miRegServiciosActualizar);

        mRegistros.add(mRegServicios);

        miRegPromociones.setText("Promociones");
        mRegistros.add(miRegPromociones);

        mbBarra.add(mRegistros);

        mReservas.setText("Reservas");

        miNuevaReserva.setText("Nueva reserva");
        mReservas.add(miNuevaReserva);

        miCancelarReserva.setText("Cancelar reserva");
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
        mConsultas.add(miConsClientes);

        miConsProveedores.setText("Proveedores");
        mConsultas.add(miConsProveedores);

        miConsServicios.setText("Servicios");
        mConsultas.add(miConsServicios);

        miConsPromociones.setText("Promociones");
        mConsultas.add(miConsPromociones);

        miConsReservas.setText("Reservas");
        miConsReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsReservasActionPerformed(evt);
            }
        });
        mConsultas.add(miConsReservas);

        mbBarra.add(mConsultas);

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
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_miSalirActionPerformed

    private void miActualizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miActualizarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miActualizarReservaActionPerformed

    private void NuevaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaCatActionPerformed
        // TODO add your handling code here:
        /*Acá creo la instancia de agregar Categoría.
        Tampoco anda acá.*/
        nuevaCateFrame agregar = new nuevaCateFrame();
        add(agregar);
        agregar.setVisible(true);
    }//GEN-LAST:event_NuevaCatActionPerformed

    private void miRegUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegUsuariosActionPerformed
        // TODO add your handling code here:
        //System.out.println("click!");
       // altaUsuarios.setVisible(true);
       ifrmAltaUsuarios vAltaUsuarios = new ifrmAltaUsuarios(this.iccli, this.icprov);
       nuevoPanel.add(vAltaUsuarios);
       vAltaUsuarios.show();
        
    }//GEN-LAST:event_miRegUsuariosActionPerformed

    private void miRegServiciosNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegServiciosNuevoActionPerformed
        
        //System.out.println("1");
        ifrmAltaServicio vAltaServicio = new ifrmAltaServicio(icprov, iccat);
        //System.out.println("1");
        nuevoPanel.add(vAltaServicio);
        //System.out.println("1");
        vAltaServicio.show();
        //System.out.println("1");
        
    }//GEN-LAST:event_miRegServiciosNuevoActionPerformed

    private void miCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriasActionPerformed
        // TODO add your handling code here:
        nuevaCateFrame agregar = new nuevaCateFrame(this.iccat);
        add(agregar);
        agregar.setVisible(true);
    }//GEN-LAST:event_miCategoriasActionPerformed

    private void miConsReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsReservasActionPerformed
        // TODO add your handling code here:
        VerInfoReserva agregar = new VerInfoReserva(this.iccli);
       //add(agregar);  
      agregar.setVisible(true);
        
    }//GEN-LAST:event_miConsReservasActionPerformed
    
        
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
    private javax.swing.JMenu mConsultas;
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
    private javax.swing.JMenuItem miNuevaReserva;
    private javax.swing.JMenuItem miRegPromociones;
    private javax.swing.JMenuItem miRegServiciosActualizar;
    private javax.swing.JMenuItem miRegServiciosNuevo;
    private javax.swing.JMenuItem miRegUsuarios;
    private javax.swing.JMenuItem miSalir;
    // End of variables declaration//GEN-END:variables
}

class Panel extends JDesktopPane{
    
    public Panel(){
              
    }
    
    /*public Panel(ifrmAltaUsuarios vUsuarios){
        add(vUsuarios);
    }*/
    
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


