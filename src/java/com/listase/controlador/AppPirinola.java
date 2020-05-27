/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listacircularde.modelo.ListaCircularDE;
import com.listacircularde.modelo.ListaCircularPirinolaDE;
import com.listase.modelo.JugadoresPirinola;
import com.listase.modelo.NodoDePirinola;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Maykol Sedano
 */
@Named(value = "sesionPirinola")
@ApplicationScoped
public class AppPirinola {

    JugadoresPirinola jugador;

    ListaCircularPirinolaDE jugadores;

    JugadoresPirinola jugadorActual;
    JugadoresPirinola ayudante;
    NodoDePirinola jugadoresVarios;

    int banco;

    /**
     * Creates a new instance of SesionPirinola
     */
    public AppPirinola() {

    }

    private void inicializar() {

        jugadores = new ListaCircularPirinolaDE();
        //llenar
        jugadores.adiccionarNodo(new JugadoresPirinola("Maykoll", 20));
        jugadores.adiccionarNodo(new JugadoresPirinola("Pedro", 20));
        jugadores.adiccionarNodo(new JugadoresPirinola("Carlos", 20));
        jugadores.adiccionarNodo(new JugadoresPirinola("Juan", 20));
    }

    public void girarPirinola() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 6 + 1;
        int randomInt = (int) randomDouble;

        switch (randomInt) {
            case 1:
                ponerUno();
                break;
            case 2:
                ponerDos();
                break;
            case 3:
                tomarUno();
                break;
            case 4:
                tomarDos();
                break;
            case 5:
                tomarTodo();
                break;
            case 6:
                todosPonenUno();
                break;
        }

    }

    public void ponerUno() {
        jugadorActual.setFichas(jugadorActual.getFichas() - 1);
        this.banco++;
        if (jugadorActual.getFichas() == 0) {

        }

    }

    public void ponerDos() {
        jugadorActual.setFichas(jugadorActual.getFichas() - 2);
        banco = banco + 2;
        if (jugadorActual.getFichas() == 0) {

        }

    }

    public void tomarUno() {
        jugadorActual.setFichas(jugadorActual.getFichas() + 1);
        this.banco--;
    }

    public void tomarDos() {
        jugadorActual.setFichas(jugadorActual.getFichas() + 2);
        banco = banco - 2;

    }

    public void tomarTodo() {
        jugadorActual.setFichas(jugadorActual.getFichas() + banco);
        banco = (banco - banco);
    }

    public void todosPonenUno() {

        NodoDePirinola temp= jugadoresVarios;
        while (temp.getSiguiente() != jugadoresVarios) {
            jugadoresVarios.getDato().setFichas(jugadoresVarios.getDato().getFichas()-1);
            temp = temp.getSiguiente();
            banco++;
        }

    }
}
