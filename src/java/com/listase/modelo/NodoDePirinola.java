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
    
    
    private JugadorPirinola dato;
    private NodoDePirinola siguiente;
    private NodoDePirinola anterior;
    
    //constructor

    public NodoDePirinola() {
    }

    public NodoDePirinola(JugadorPirinola dato, NodoDePirinola siguiente, NodoDePirinola anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public NodoDePirinola(JugadorPirinola dato) {
        this.dato= dato;
    }

    public JugadorPirinola getDato() {
        return dato;
    }

    public void setDato(JugadorPirinola dato) {
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
