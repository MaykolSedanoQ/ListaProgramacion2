/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

/**
 *
 * @author Maykol Sedano
 */
public class NodoDePirinola {
    
    
    private JugadoresPirinola dato;
    private NodoDePirinola siguiente;
    private NodoDePirinola anterior;
    
    //constructor

    public NodoDePirinola(JugadoresPirinola dato) {
        this.dato= dato;
    }

    public JugadoresPirinola getDato() {
        return dato;
    }

    public void setDato(JugadoresPirinola dato) {
        this.dato = dato;
    }

    public NodoDePirinola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDePirinola siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDePirinola getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDePirinola anterior) {
        this.anterior = anterior;
    }
    
}
