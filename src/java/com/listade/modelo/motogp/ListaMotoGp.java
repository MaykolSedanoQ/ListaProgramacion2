/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listade.modelo.motogp;

import com.listase.excepciones.pilotosExepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maykol Sedano
 */
public class ListaMotoGp implements Serializable {

    private NodoMotoGp cabeza;

    //constructor
    public ListaMotoGp() {
    }

    public ListaMotoGp(NodoMotoGp cabeza) {
        this.cabeza = cabeza;
    }
    
    //get y set

    public NodoMotoGp getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoMotoGp cabeza) {
        this.cabeza = cabeza;
    }
    

    //metodo adiccionar el piloto
    public void adicionarPiloto(CorredoresMotoGp corredor) {

        if (cabeza == null) {
            cabeza = new NodoMotoGp(corredor);
        } else {
            NodoMotoGp temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(new NodoMotoGp(corredor));
            temp.getSiguiente().setAnterior(temp);
        }
    }
    //fin del metodo de adiccionar piloto

    //metodo adiccionar un piloto al inicio
    public void adiccionarPilotoAlInicio(CorredoresMotoGp corredor) {

        if (cabeza == null) {
            cabeza = new NodoMotoGp(corredor);
        } else {
            NodoMotoGp temp = new NodoMotoGp(corredor);
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
            NodoMotoGp temp = cabeza;
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
            NodoMotoGp temp = cabeza;
            while (temp != null) {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();
            }
            return listado;
        }
        return "No hay pilotos";
    }
    
    public List obtenerListaPilotos(){
        List<CorredoresMotoGp> listado = new ArrayList<>();
        
        listaPilotos(listado);
        return listado;
    }
    
public void listaPilotos (List listado){

    if(cabeza!=null){
        NodoMotoGp temp= cabeza;
        while(temp!=null){
            listado.add(temp.getDato());
            temp=temp.getSiguiente();
        }
    }
}
//fin de listas de los pilotos

public void invertirPosicionesPilitos(){
    if(cabeza!=null){
        ListaMotoGp listaMotoGp= new ListaMotoGp();
        NodoMotoGp temp=cabeza;
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
   
public  void eliminarPiloto(short numeroPiloto )throws pilotosExepcion{
   
    if(cabeza!=null){
        if(cabeza.getDato().getNumeroPiloto()== numeroPiloto){
            cabeza= cabeza.getSiguiente();
            cabeza.setAnterior(null);
            return;
        }
        else{
            NodoMotoGp temp= cabeza;
            while(temp.getSiguiente()!=null){
                if(temp.getSiguiente().getDato().getNumeroPiloto()==numeroPiloto){
                    temp.setSiguiente(temp.getSiguiente().getSiguiente());
                    if(temp.getSiguiente()!=null)
                        temp.getSiguiente().setAnterior(temp);
                    return;
                }
                temp = temp.getSiguiente();
            }
            throw new pilotosExepcion("El numero"+numeroPiloto+"no existe en los pilotos");
        }
        
    }
    throw new pilotosExepcion("La lista de los pilotos esta vacia");
}

     public CorredoresMotoGp obtenerPiloto (short numeroPiloto ) throws pilotosExepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getNumeroPiloto()==numeroPiloto)
            {                
                return cabeza.getDato();
            }
            else
            {
                NodoMotoGp temp=cabeza;
                while(temp!=null)
                {
                    if(temp.getDato().getNumeroPiloto()== numeroPiloto)
                    {                                                
                        return temp.getDato();
                    }
                    temp = temp.getSiguiente();
                }
                
                throw new pilotosExepcion("El numero del piloto "+numeroPiloto +" no existe en la lista");
            }
        }
        throw new pilotosExepcion("La lista de pilotos está vacía");
    }
    
     public void prueba (){
         
     }

}




