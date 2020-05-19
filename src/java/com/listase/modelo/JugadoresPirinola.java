/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import java.io.Serializable;

/**
 *
 * @author Maykol Sedano
 */
public class JugadoresPirinola implements Serializable {

private String nombre;


//constructores

    public JugadoresPirinola() {
    }

    public JugadoresPirinola(String nombre) {
        this.nombre = nombre;
    }

//get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    //to string

    @Override
    public String toString() {
        return "JugadoresPirinola{" + "nombre=" + nombre + '}';
    }
    
}
