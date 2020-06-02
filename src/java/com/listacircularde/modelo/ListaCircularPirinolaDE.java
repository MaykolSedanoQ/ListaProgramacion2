/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listacircularde.modelo;

import com.listase.excepciones.JugadorException;
import com.listase.modelo.JugadorPirinola;
import com.listase.modelo.NodoDePirinola;
import java.io.Serializable;

/**
 *
 * @author Maykol Sedano
 */
public class ListaCircularPirinolaDE implements Serializable {

    private NodoDePirinola cabeza;

    public ListaCircularPirinolaDE() {
    }

    public ListaCircularPirinolaDE(NodoDePirinola cabeza) {
        this.cabeza = cabeza;
    }

    public NodoDePirinola getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDePirinola cabeza) {
        this.cabeza = cabeza;
    }

       public void adicionarNodo(JugadorPirinola jugador) {
        if (cabeza == null) {
            cabeza = new NodoDePirinola(jugador);
            ///Hago los enlaces circulares
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);

        } else {
            //Lamo a mi ayudante
            NodoDePirinola temp = cabeza.getAnterior();
            //temp= temp.getAnterior();
            NodoDePirinola nodoInsertar = new NodoDePirinola(jugador);
            temp.setSiguiente(nodoInsertar);
            nodoInsertar.setAnterior(temp);
            nodoInsertar.setSiguiente(cabeza);
            cabeza.setAnterior(nodoInsertar);
        }
    }

    public void adicionarNodoAlInicio(JugadorPirinola jugador) {
        if (cabeza == null) {
            cabeza = new NodoDePirinola(jugador);
            ///Hago los enlaces circulares
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoDePirinola temp = cabeza.getAnterior();
            //temp= temp.getAnterior();
            NodoDePirinola nodoInsertar = new NodoDePirinola(jugador);
            temp.setSiguiente(nodoInsertar);
            nodoInsertar.setAnterior(temp);
            nodoInsertar.setSiguiente(cabeza);
            cabeza.setAnterior(nodoInsertar);
            cabeza = cabeza.getAnterior();
        }
    }

    public short contarNodos() {
        if (cabeza == null) {
            return 0;
        } else {
            //llamar a mi ayudante
            NodoDePirinola temp = cabeza;
            short cont = 1;
            while (temp.getSiguiente() != cabeza) {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }

    public String listarJugadores(String listado) throws JugadorException {
        if (cabeza != null) {
            NodoDePirinola temp = cabeza;
//            while (temp.getSiguiente() != cabeza) {
//                listado += temp.getDato() + "\n";
//                temp = temp.getSiguiente();
//            }
//            listado += temp.getDato() + "\n";
            do {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();
            } while (temp != cabeza);

            return listado;
        }
        throw new JugadorException(("No existen jugadors en la lista"));
    }

    //Eliminar NOdo
    public void eliminarNodo(String nombre) throws JugadorException {
        if (cabeza != null) {
            if (cabeza.getSiguiente() == cabeza) {
                if (cabeza.getDato().getNombre().equals(nombre)) {
                    cabeza = null;
                    return;
                }
            } else {
                NodoDePirinola temp = cabeza;
                do {
                    if (temp.getDato().getNombre().equals(nombre)) {
                        //estamos parados en el que hay que eliminar
                        temp.getAnterior().setSiguiente(temp.getSiguiente());
                        temp.getSiguiente().setAnterior(temp.getAnterior());
                        return;
                    }
                    temp = temp.getSiguiente();
                } while (temp != cabeza);
            }
            throw new JugadorException(("El Jugador no se encuentra en la lista"));
        } else {
            throw new JugadorException(("No existen jugadors en la lista"));
        }
    }
    
    public int obtenerMayoresFichas() throws JugadorException {
        if (cabeza == null) {
            throw new JugadorException("La lista de pilotos está vacía");
        } else {
            NodoDePirinola temp = cabeza;
            int max = temp.getDato().getFichas();
            do {
                if (temp.getDato().getFichas() > max) {
                    max = temp.getDato().getFichas();
                }
                temp = temp.getSiguiente();
            } while (temp != cabeza);
            return max;
        }
    }
    
    public String obtenerGanadores()throws JugadorException{
        int numFichas = obtenerMayoresFichas();
        NodoDePirinola temp = cabeza;
        String ganadores="";
        do{
            if (temp.getDato().getFichas() == numFichas)
                ganadores += temp.getDato().getNombre() + ", ";
            temp=temp.getSiguiente();
        }while(temp!=cabeza);
        return ganadores;
    }
}
