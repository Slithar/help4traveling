/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.io.*;
/**
 *
 * @author usuario
 */
public class fchImagenes extends javax.swing.JFrame {

    /**
     * Creates new form fchImagenes
     */
    private ifrmAltaUsuarios iAltaUsuario;
    private ifrmAltaProveedores iAltaProveedores;
    private ifrmAltaServicio iAltaServicio;
    private ifrmActualizarServicio iActualizarServicio;
    
    public fchImagenes() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public fchImagenes(ifrmAltaUsuarios i){
        initComponents();
        iAltaUsuario = i;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FileNameExtensionFilter filtroTipo = new FileNameExtensionFilter("JPG, PNG, GIF", "jpg", "png", "gif");
        fchImagen.setFileFilter(filtroTipo);
        Dimension tamanioVentana = this.getSize();
        setLocation((1900 - tamanioVentana.width)/2, (900 - tamanioVentana.height)/2);
        
        
    }
    
    public fchImagenes(ifrmAltaProveedores i){
        initComponents();
        iAltaProveedores = i;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FileNameExtensionFilter filtroTipo = new FileNameExtensionFilter("JPG, PNG, GIF", "jpg", "png", "gif");
        fchImagen.setFileFilter(filtroTipo);
        Dimension tamanioVentana = this.getSize();
        setLocation((1900 - tamanioVentana.width)/2, (900 - tamanioVentana.height)/2);       
    }
    
    public fchImagenes(ifrmAltaServicio i){
        initComponents();
        iAltaServicio = i;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FileNameExtensionFilter filtroTipo = new FileNameExtensionFilter("JPG, PNG, GIF", "jpg", "png", "gif");
        fchImagen.setFileFilter(filtroTipo);
        Dimension tamanioVentana = this.getSize();
        setLocation((1900 - tamanioVentana.width)/2, (900 - tamanioVentana.height)/2);       
    }
    
    public fchImagenes(ifrmActualizarServicio i){
        initComponents();
        iActualizarServicio = i;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FileNameExtensionFilter filtroTipo = new FileNameExtensionFilter("JPG, PNG, GIF", "jpg", "png", "gif");
        fchImagen.setFileFilter(filtroTipo);
        Dimension tamanioVentana = this.getSize();
        setLocation((1900 - tamanioVentana.width)/2, (900 - tamanioVentana.height)/2);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fchImagen = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fchImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fchImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fchImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fchImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fchImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fchImagenActionPerformed
        
        JFileChooser imagen = (JFileChooser) evt.getSource();
        String comando = evt.getActionCommand();
        
        if(comando == JFileChooser.APPROVE_SELECTION){
            File archivoSeleccionado = imagen.getSelectedFile();
            String extension = (String) archivoSeleccionado.getPath().substring(archivoSeleccionado.getPath().length() - 3, archivoSeleccionado.getPath().length()).toUpperCase();
            if(extension.equals("GIF") || extension.equals("JPG") || extension.equals("PNG")){
                String ruta = (String) archivoSeleccionado.getPath();
                if(iAltaUsuario != null){
                    iAltaUsuario.setImagenPerfil(ruta, "absoluta");
                    iAltaUsuario.setRutaImagen(ruta);
                }
                else if(iAltaProveedores != null){                    
                    iAltaProveedores.agregarImagenPerfil(ruta);
                }
                else if(iAltaServicio != null){
                    iAltaServicio.setImagenLabel(ruta, "absoluta");
                }
                else if(iActualizarServicio != null){
                    iActualizarServicio.setImagenLabel(ruta, "absoluta");
                }
                    
                
                this.setVisible(false);
            }
            else{
                if(iAltaUsuario != null)
                    JOptionPane.showMessageDialog(iAltaUsuario, "El archivo seleccionado no es una imagen", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                else if(iAltaServicio != null)
                    JOptionPane.showMessageDialog(iAltaServicio, "El archivo seleccionado no es una imagen", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                else if(iAltaProveedores != null)
                    JOptionPane.showMessageDialog(iAltaProveedores, "El archivo seleccionado no es una imagen", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                else if(iActualizarServicio != null)
                    JOptionPane.showMessageDialog(iActualizarServicio, "El archivo seleccionado no es una imagen", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }   
        }
        else{
            this.dispose();
        }
    }//GEN-LAST:event_fchImagenActionPerformed

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
            java.util.logging.Logger.getLogger(fchImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fchImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fchImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fchImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fchImagenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fchImagen;
    // End of variables declaration//GEN-END:variables
}
