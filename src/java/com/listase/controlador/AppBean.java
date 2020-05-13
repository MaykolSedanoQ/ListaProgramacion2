/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Maykol Sedano
 */
@Named(value = "appBean")
@ApplicationScoped
public class AppBean {
    
    private String correoTurno="maykol-1.6@outlook.com";
    private int  cont=0;

    /**
     * Creates a new instance of AppBean
     */
    public AppBean() {
    }

    public String getCorreoTurno() {
        return correoTurno;
    }

    public void setCorreoTurno(String correoTurno) {
        this.correoTurno = correoTurno;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    public  void aumentarContador (String correo){
        switch (correo){
            case "maykol-1.6@outlook.com":
                correoTurno= "mseedanoquintero@umanizales.co";
        break;
        default:
            correoTurno= "maykol-1.6@outlook.com";
        }
        
        cont ++;
    }
    
     public boolean validarTurno(String correo)
    {
        if(correo.equals(correoTurno))
        {
            return true;
        }
        return false;
    }
    
}
