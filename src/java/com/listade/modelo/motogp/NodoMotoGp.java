/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listade.modelo.motogp;

/**
 *
 * @author c@rlo@iz@
 */
public class NodoMotoGp {
    private CorredoresMotoGp dato;
    private NodoMotoGp siguiente;
    private NodoMotoGp anterior;
    
    //constructor vacio

    public NodoMotoGp(CorredoresMotoGp dato) {
        this.dato = dato;
    }
    //get y set

    public CorredoresMotoGp getDato() {
        return dato;
    }

    public void setDato(CorredoresMotoGp dato) {
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