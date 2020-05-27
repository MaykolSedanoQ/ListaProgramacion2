/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listacircularde.modelo;

import com.listase.modelo.JugadoresPirinola;
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

    public void adiccionarNodo(JugadoresPirinola jugador) {

        if (cabeza == null) {
            cabeza = new NodoDePirinola(jugador);
            //aqui se hacen los enlaces circulares
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            //llamar a mi ayudante
            NodoDePirinola temp = cabeza.getAnterior();
            NodoDePirinola nodoInsetar = new NodoDePirinola(jugador);
            temp.setSiguiente(nodoInsetar);
            nodoInsetar.setAnterior(temp);
            nodoInsetar.setSiguiente(cabeza);
            cabeza.setAnterior(nodoInsetar);
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

    public void eliminarJugador(short fichas) {

        if (cabeza != null) {
            if (cabeza.getDato().getFichas() == 0) {
                cabeza = cabeza.getSiguiente();
                cabeza.setAnterior(null);
                return;
            } else {
                NodoDePirinola temp = cabeza;
                while (temp.getSiguiente() != null) {
                    if (temp.getSiguiente().getDato().getFichas() == 0) {
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                        if (temp.getSiguiente() != null) {
                            temp.getSiguiente().setAnterior(temp);
                        }
                        return;
                    }
                    temp = temp.getSiguiente();
                }

            }
        }
    }
}
