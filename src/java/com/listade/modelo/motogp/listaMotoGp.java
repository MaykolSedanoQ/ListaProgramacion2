/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listade.modelo.motogp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maykol Sedano
 */
public class listaMotoGp implements Serializable {

    private nodoMotoGp cabeza;

    //constructor
    public listaMotoGp() {
    }

    public listaMotoGp(nodoMotoGp cabeza) {
        this.cabeza = cabeza;
    }
    
    //get y set

    public nodoMotoGp getCabeza() {
        return cabeza;
    }

    public void setCabeza(nodoMotoGp cabeza) {
        this.cabeza = cabeza;
    }
    

    //metodo adiccionar el piloto
    public void adicionarPiloto(corredoresMotoGp corredor) {

        if (cabeza == null) {
            cabeza = new nodoMotoGp(corredor);
        } else {
            nodoMotoGp temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(new nodoMotoGp(corredor));
            temp.getSiguiente().setAnterior(temp);
        }
    }
    //fin del metodo de adiccionar piloto

    //metodo adiccionar un piloto al inicio
    public void adiccionarPilotoAlInicio(corredoresMotoGp corredor) {

        if (cabeza == null) {
            cabeza = new nodoMotoGp(corredor);
        } else {
            nodoMotoGp temp = new nodoMotoGp(corredor);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;
        }
    }
    //fin del metodo adiccionar el piloto al inicio

    //inicio metodo de contar pilotos
    public short contarPilotos() {

        if (cabeza == null) {
            return 0;
        } else {
            nodoMotoGp temp = cabeza;
            short cont = 1;
            while (temp.getSiguiente() != null) {

                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    // fin del contar nodos

    public String obtenerListadoPilotos() {

        return listaPilotos("");
    }

    //lista de los pilotos
    public String listaPilotos(String listado) {
        if (cabeza != null) {
            nodoMotoGp temp = cabeza;
            while (temp != null) {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();
            }
            return listado;
        }
        return "No hay pilotos";
    }
    
    public List obtenerListaPilotos(){
        List<corredoresMotoGp> listado = new ArrayList<>();
        
        listaPilotos(listado);
        return listado;
    }
    
public void listaPilotos (List listado){

    if(cabeza!=null){
        nodoMotoGp temp= cabeza;
        while(temp!=null){
            listado.add(temp.getDato());
            temp=temp.getSiguiente();
        }
    }
}
//fin de listas de los pilotos

public void invertirPosicionesPilitos(){
    if(cabeza!=null){
        listaMotoGp listaMotoGp= new listaMotoGp();
        nodoMotoGp temp=cabeza;
        while(temp!=null){
            listaMotoGp.adiccionarPilotoAlInicio(temp.getDato());
            temp=temp.getSiguiente();
        }
        cabeza= listaMotoGp.getCabeza();
    }
}

//preguntar metodo por equipo
//public  short contarPilotosXEquipo(String equipo){
//    if(cabeza==null)
//}
   

}




