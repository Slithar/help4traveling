/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;

/**
 *
 * @author usuario
 */
public class ImagenPixel {
    private BufferedImage imagen;
    
    public ImagenPixel(){
        
    }
    
    public ImagenPixel(BufferedImage imagen){
        this.imagen = imagen;
    }
    
    public void setImagen(BufferedImage imagen){
        this.imagen = imagen;
    }
    
    public BufferedImage getImagen(){
        return this.imagen;
    }
}
