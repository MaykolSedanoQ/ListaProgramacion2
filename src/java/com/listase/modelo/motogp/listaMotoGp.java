/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo.motogp;

/**
 *
 * @author Maykol Sedano
 */
public class listaMotoGp {
    
    private nodoMotoGp cabeza;
    
    //constructor

    public listaMotoGp() {
    }

    public listaMotoGp(nodoMotoGp cabeza) {
        this.cabeza = cabeza;
    }
    
    //metodo adiccionar el piloto
    public void adicionarPiloto(corredoresMotoGp corredor){
        
        if(cabeza== null){
            cabeza = new nodoMotoGp(corredor);
        }
        else{
             nodoMotoGp temp= cabeza;
             while(temp.getSiguiente()!=null){
                 temp= temp.getSiguiente();
             }
            temp.setSiguiente(new nodoMotoGp(corredor));
            temp.getSiguiente().setAnterior(temp);
        }
    }
    //fin del metodo de adiccionar piloto
    
    //metodo adiccionar un piloto al inicio
    public void adiccionarPilotoAlInicio(corredoresMotoGp corredor ){
        
        if(cabeza== null){
            cabeza = new nodoMotoGp(corredor);
        }
        else{
            nodoMotoGp temp= new nodoMotoGp(corredor);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza= temp;
        }
    }
    //fin del metodo adiccionar el piloto al inicio
    
}
