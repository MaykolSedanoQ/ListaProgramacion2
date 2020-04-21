/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listade.modelo.motogp;

/**
 *
 * @author Maykol Sedano
 */
public class nodoMotoGp {
    private corredoresMotoGp dato;
    private nodoMotoGp siguiente;
    private nodoMotoGp anterior;
    
    //constructor vacio

    public nodoMotoGp(corredoresMotoGp dato) {
        this.dato = dato;
    }
    //get y set

    public corredoresMotoGp getDato() {
        return dato;
    }

    public void setDato(corredoresMotoGp dato) {
        this.dato = dato;
    }

    public nodoMotoGp getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoMotoGp siguiente) {
        this.siguiente = siguiente;
    }

    public nodoMotoGp getAnterior() {
        return anterior;
    }

    public void setAnterior(nodoMotoGp anterior) {
        this.anterior = anterior;
    }
    
}
