/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo.motogp;

import java.io.Serializable;

/**
 *
 * @author Maykol Sedano
 */
public class corredoresMotoGp implements Serializable{
    private String nombre;
    private  byte edad;
    private short numeroPiloto;
    private String ciudadNacimiento;
    
    //constructor vacio

    public corredoresMotoGp() {
        this.edad=1;
    }
    
    //constructor lleno

    public corredoresMotoGp(String nombre, byte edad, short numeroPiloto, String ciudadNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroPiloto = numeroPiloto;
        this.ciudadNacimiento = ciudadNacimiento;
    }
    
    //get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public short getNumeroPiloto() {
        return numeroPiloto;
    }

    public void setNumeroPiloto(short numeroPiloto) {
        this.numeroPiloto = numeroPiloto;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }
    
    //to string

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
    
    
}
