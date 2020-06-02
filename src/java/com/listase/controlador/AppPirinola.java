/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listacircularde.modelo.ListaCircularPirinolaDE;
import com.listase.excepciones.JugadorException;
import com.listase.modelo.JugadorPirinola;
import com.listase.modelo.NodoDePirinola;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import loginjsf.controlador.ControladorUsuarios;
import loginjsf.modelo.Usuario;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author Maykol Sedano
 */
@Named(value = "AppPirinola")
@ApplicationScoped
public class AppPirinola implements Serializable {

    private String mensajeUltimaAccion;
    private String correoTurno;
    private ListaCircularPirinolaDE listaJugadores;
    private NodoDePirinola jugadorActual;
    private int banco = 10;
    private int turnosRestantes = 20;
    private boolean enElJuego = true;

    private String jugadorEliminar;
    private JugadorPirinola nuevoJugagor = new JugadorPirinola();

    private DefaultDiagramModel model;

    /**
     * Creates a new instance of SesionPirinola
     */
    public AppPirinola() {
        banco = 10;
        turnosRestantes = 20;

        listaJugadores = new ListaCircularPirinolaDE();

        cargarJugadores();

        correoTurno = ControladorUsuarios.getUsuarios().get(0).getCorreo();

        jugadorActual = listaJugadores.getCabeza();

        pintarJugadores();
    }

    //constructores
    public AppPirinola(String mensajeUltimaAccion, String correoTurno, ListaCircularPirinolaDE listaJugadores, NodoDePirinola jugadorActual, String jugadorEliminar, DefaultDiagramModel model, ListaCircularPirinolaDE jugadores) {
        this.mensajeUltimaAccion = mensajeUltimaAccion;
        this.correoTurno = correoTurno;
        this.listaJugadores = listaJugadores;
        this.jugadorActual = jugadorActual;
        this.jugadorEliminar = jugadorEliminar;
        this.model = model;
    }

//get y set
    public String getMensajeUltimaAccion() {
        return mensajeUltimaAccion;
    }

    public void setMensajeUltimaAccion(String mensajeUltimaAccion) {
        this.mensajeUltimaAccion = mensajeUltimaAccion;
    }

    public String getCorreoTurno() {
        return correoTurno;
    }

    public void setCorreoTurno(String correoTurno) {
        this.correoTurno = correoTurno;
    }

    public ListaCircularPirinolaDE getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ListaCircularPirinolaDE listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public NodoDePirinola getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(NodoDePirinola jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void setTurnosRestantes(int turnosRestantes) {
        this.turnosRestantes = turnosRestantes;
    }

    public boolean isEnElJuego() {
        return enElJuego;
    }

    public void setEnElJuego(boolean enElJuego) {
        this.enElJuego = enElJuego;
    }

    public String getJugadorEliminar() {
        return jugadorEliminar;
    }

    public void setJugadorEliminar(String jugadorEliminar) {
        this.jugadorEliminar = jugadorEliminar;
    }

    public JugadorPirinola getNuevoJugagor() {
        return nuevoJugagor;
    }

    public void setNuevoJugagor(JugadorPirinola nuevoJugagor) {
        this.nuevoJugagor = nuevoJugagor;
    }

    public DefaultDiagramModel getModel() {
        return model;
    }

    public void setModel(DefaultDiagramModel model) {
        this.model = model;
    }

    public boolean validarTurno(String correo) {

        if (this.correoTurno.equals(correo)) {
            return true;
        }
        return false;
    }

    public void pasarTurno() throws JugadorException {
        this.correoTurno = jugadorActual.getSiguiente().getDato().getCorreo();
        girarPirinola();
    }

    public void girarPirinola() throws JugadorException {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 6 + 1;
        int randomInt = (int) randomDouble;
        int fichas = jugadorActual.getDato().getFichas();
        switch (randomInt) {
            case 1:
                //ponerUno();
                mensajeUltimaAccion = jugadorActual.getDato().getNombre() + ":Pon Una Ficha";
                if (banco >= 1) {
                    jugadorActual.getDato().setFichas(fichas + 1);
                    this.banco++;

                }
                break;
            case 2:
                //ponerDos();
                mensajeUltimaAccion = jugadorActual.getDato().getNombre() + "Pon Dos Fichas";
                if (fichas >= 2) {
                    jugadorActual.getDato().setFichas(fichas - 2);
                    this.banco += 2;
                } else {
                    jugadorActual.getDato().setFichas(0);
                    this.banco += fichas;
                }

                break;
            case 3:
                //tomarUno();
                mensajeUltimaAccion = jugadorActual.getDato().getNombre() + "Tome Una ficha";
                if (banco >= 1) {
                    jugadorActual.getDato().setFichas(fichas + 1);
                    this.banco--;
                }
                break;
            case 4:
                //tomarDos();
                mensajeUltimaAccion = jugadorActual.getDato().getNombre() + "Tome Dos Fichas";
                if (banco >= 2) {
                    jugadorActual.getDato().setFichas(fichas + 2);
                    this.banco -= 2;
                } else {
                    jugadorActual.getDato().setFichas(fichas + banco);
                    this.banco = 0;
                }
                break;
            case 5:
                //tomarTodo();
                mensajeUltimaAccion = jugadorActual.getDato().getNombre() + "Tome Todas Las Fichas";
                jugadorActual.getDato().setFichas(fichas + banco);
                banco = 0;
                break;
            case 6:
                //todosPonenUno();
                mensajeUltimaAccion = jugadorActual.getDato().getNombre() + "Todos Ponen Una Ficha";
                NodoDePirinola temp = jugadorActual;
                do {
                    if (temp.getDato().getFichas() >= 1) {
                        temp.getDato().setFichas(temp.getDato().getFichas() - 1);
                        this.banco++;
                    }
                    if (temp.getDato().getFichas() <= 0) {
                        listaJugadores.eliminarNodo(temp.getDato().getNombre());
                    }
                    temp = temp.getSiguiente();

                } while (temp != jugadorActual);
                break;
        }
        if (banco <= 0) {
            banco = 0;
        }
        jugadorActual = jugadorActual.getSiguiente();
        listaJugadores.setCabeza(jugadorActual.getSiguiente());
        if (jugadorActual.getAnterior().getDato().getFichas() <= 0) {
            listaJugadores.eliminarNodo(jugadorActual.getAnterior().getDato().getNombre());
        }
        if (listaJugadores.contarNodos() == 1) {
            enElJuego = false;
        }
        pintarJugadores();
    }

    public void eliminarJugador() throws JugadorException {
        listaJugadores.eliminarNodo(jugadorEliminar);
        pintarJugadores();
    }

    public void agregarJugador() {
        if (!nuevoJugagor.getNombre().equals("")) {
            listaJugadores.adicionarNodo(nuevoJugagor);
            pintarJugadores();
        }
    }

    public void verSiguienteJugador() {
        listaJugadores.setCabeza(listaJugadores.getCabeza().getSiguiente());
        pintarJugadores();
    }

    public void verAnteriorJugador() {
        listaJugadores.setCabeza(listaJugadores.getCabeza().getAnterior());
        pintarJugadores();
    }

    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));

        if (label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }

        return conn;
    }

    public void pintarJugadores() {
        //Instancia el modelo
        model = new DefaultDiagramModel();
        //Se establece para que el diagrama pueda tener infinitas flechas
        model.setMaxConnections(-1);

        StateMachineConnector connector = new StateMachineConnector();
        connector.setOrientation(StateMachineConnector.Orientation.ANTICLOCKWISE);
        connector.setPaintStyle("{strokeStyle:'#7D7463',lineWidth:3}");
        model.setDefaultConnector(connector);

        ///Adicionar los elementos
        if (listaJugadores.getCabeza() != null) {
            //llamo a mi jugadorActual
            NodoDePirinola temp = listaJugadores.getCabeza();

            /**
             * variables para la posicion de los elementos en el diagrama:
             *
             * 'posY' y 'posX': indican el centro del circulo 'numElementos':
             * indica el total de los puntos que se van a distribuir 'angle':
             * indica el ángulo en el que se dibujará el punto 'cont': indica el
             * número
             */
            double posX;
            double posY;
            int numElementos = listaJugadores.contarNodos();
            double angle;
            int cont = 0;//

            //recorro la lista de principio a fin
            do {

                //calculando la posición del elemento:
                angle = (2 * Math.PI * cont) / numElementos;

                //para acomodar el primer jugador a 90 grados de la horizontal:
                angle += (1.5 * Math.PI);

                posX = 35 + (15 * Math.cos(angle));
                posY = 15 + (15 * Math.sin(angle));
                cont++;

                //Parado en un elemento
                //Crea el cuadrito y lo adiciona al modelo
                Element ele = new Element(temp.getDato().getNombre() + ": " + temp.getDato().getFichas(),
                        posX + "em", posY + "em");
                ele.setId(String.valueOf(temp.getDato().getNombre()));
                //adiciona un conector al cuadrito
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));

                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM));

                //si es el primer elemento, añadirlo a la clase css que lo pone morado.
                if (temp == listaJugadores.getCabeza()) {
                    ele.setStyleClass("ui-diagram-primero");
                }

                model.addElement(ele);

                temp = temp.getSiguiente();

            } while (temp != listaJugadores.getCabeza());

            //Pinta las flechas            
            for (int i = 0; i < model.getElements().size() - 1; i++) {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1),
                        model.getElements().get(i + 1).getEndPoints().get(0), "Sig"));

                model.connect(createConnection(model.getElements().get(i + 1).getEndPoints().get(2),
                        model.getElements().get(i).getEndPoints().get(3), "Ant"));
            }

            //pone un elemento en el centro del diagrama con las fichas en la caja
            model.addElement(new Element("Caja: " + this.banco, 35 + "em", 15 + "em"));
        }
    }

    private void cargarJugadores() {
        listaJugadores = new ListaCircularPirinolaDE();
        for (Usuario usuario : ControladorUsuarios.getUsuarios()) {
            listaJugadores.adicionarNodo(new JugadorPirinola(usuario.getNombreCompleto(), usuario.getCorreo(), 15));
        }
    }

    public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
