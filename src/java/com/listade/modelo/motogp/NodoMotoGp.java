/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listade.modelo.motogp;

/**
 *
 * @author carloaiza
 */
public class NodoMotoGp {
    private CorredorMotoGp dato;
    private NodoMotoGp siguiente;
    private NodoMotoGp anterior;
    
    //constructor vacio

    public NodoMotoGp(CorredorMotoGp dato) {
        this.dato = dato;
    }
    //get y set

    public CorredorMotoGp getDato() {
        return dato;
    }

    public void setDato(CorredorMotoGp dato) {
        this.dato = dato;
    }

    public NodoMotoGp getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMotoGp siguiente) {
        this.siguiente = siguiente;
    }

    public NodoMotoGp getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoMotoGp anterior) {
        this.anterior = anterior;
    }
    
}
