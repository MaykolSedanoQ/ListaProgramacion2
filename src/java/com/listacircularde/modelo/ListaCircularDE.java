/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listacircularde.modelo;

import com.listase.modelo.Infante;
import com.listase.modelo.NodoDE;
import java.io.Serializable;

/**
 *
 * @author Maykol Sedano
 */
public class ListaCircularDE  implements Serializable{
    private NodoDE cabeza;
    
    public  void adiccionarNodo (Infante infante){
        
        if(cabeza== null){
            cabeza = new NodoDE(infante);
            //aqui se hacen los enlaces circulares
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        }else{
            //llamar a mi ayudante
            NodoDE temp= cabeza.getAnterior();
            NodoDE nodoInsetar = new NodoDE(infante);
            temp.setSiguiente(nodoInsetar);
            nodoInsetar.setAnterior(temp);
            nodoInsetar.setSiguiente(cabeza);
            cabeza.setAnterior(nodoInsetar);
        }
    }
    
}
