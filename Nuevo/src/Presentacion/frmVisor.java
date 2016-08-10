/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.*;

/**
 *
 * @author usuario
 */
public class frmVisor extends javax.swing.JFrame {
    
    private String ruta = "";
    /**
     * Creates new form frmVisor
     */
    public frmVisor() {
        initComponents();
    }
    
    public frmVisor(String ruta){
        //System.out.println("constructor");
        initComponents();
        this.ruta = ruta;
        
        setTitle("Visualizador de imágenes");
        
        //this.setUndecorated(true);
        
        //System.out.println(ruta);
        
        PanelVisor panel = new PanelVisor();
        
        //System.out.println("hi");
        
        setContentPane(panel);
        
        //System.out.println("nuevo hola");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmVisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVisor().setVisible(true);
            }
        });
    }
    
    private class PanelVisor extends JPanel{
        
        public PanelVisor(){
            
        }
        
        @Override
        public void paint(Graphics g){
            //System.out.println("hola");
            super.paintComponent(g);
            
            ImageIcon imagen = new ImageIcon(ruta);
            
            if(imagen.getIconHeight() < 600 && imagen.getIconWidth() < 900){
                g.drawImage(imagen.getImage(), (900 - imagen.getIconWidth()) / 2, (550 - imagen.getIconHeight()) /2, imagen.getIconWidth(), imagen.getIconHeight(), null);
            }
            else if(imagen.getIconWidth() < imagen.getIconHeight()){
                //System.out.println("entre aca");
                if(imagen.getIconWidth() < 600 && imagen.getIconHeight() > 900){
                    //System.out.println("1");
                    g.drawImage(imagen.getImage(), (900 - imagen.getIconWidth()) / 2, (550 - imagen.getIconHeight()) /2, imagen.getIconWidth(), 600, null);
                }
                else{
                    //System.out.println("2");
                    g.drawImage(imagen.getImage(), (750 - 300) / 2, 0, 450, 600, null);
                }
            }
            else{
                g.drawImage(imagen.getImage(), 0, 0, 900, 600, null);
            }            
            
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}