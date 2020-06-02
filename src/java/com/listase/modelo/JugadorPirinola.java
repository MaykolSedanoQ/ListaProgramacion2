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
public class JugadorPirinola implements Serializable {

private String nombre;
private int fichas;
private String correo;

//constructores

    public JugadorPirinola() {
    }

    public JugadorPirinola(String nombre, String correo, int fichas) {
        this.nombre = nombre;
        this.fichas = fichas;
        this.correo= correo;
    }

 

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public JugadorPirinola(String nombre) {
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
        return "JugadoresPirinola{" + "nombre=" + nombre + ", fichas=" + fichas + '}';
    }


}
