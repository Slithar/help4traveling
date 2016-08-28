/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author ezequiel
 */
public enum Estado {
    REGISTRADA,
    CANCELADA,
    PAGADA,
    FACTURADA;

    static Estado obtenerEstado(String estado){
        if(estado.toUpperCase().equals("REGISTRADA"))
            return REGISTRADA;
        else if(estado.toUpperCase().equals("CANCELADA"))
            return CANCELADA;
        else if(estado.toUpperCase().equals("PAGADA"))
            return PAGADA;
        else 
            return FACTURADA;
    }
}
