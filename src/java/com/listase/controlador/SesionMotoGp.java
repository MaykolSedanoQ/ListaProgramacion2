/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listade.modelo.motogp.corredoresMotoGp;
import com.listade.modelo.motogp.listaMotoGp;
import com.listade.modelo.motogp.nodoMotoGp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import org.primefaces.model.diagram.DefaultDiagramModel;

/**
 *
 * @author Maykol Sedano
 */
@Named(value = "sesionMotoGp")
@Dependent
public class SesionMotoGp  implements Serializable{
    private listaMotoGp listaPilotos;
    private corredoresMotoGp corredores;
    private String alInicio="1";
    private boolean desahabilitarFormulario=true;
    private nodoMotoGp ayudante;
    private String textoVista="Grafico";
    private List listadoPilotos;
    private  DefaultDiagramModel model;
    private short codigoEliminar;
    private short pilotoSeleccionado;
    private corredoresMotoGp pilotoDiagrama;
    

    /**
     * Creates a new instance of SesionMotoGp
     */
    public SesionMotoGp() {
    }
    @PostConstruct
    private void inicializar(){
        
        listaPilotos = new listaMotoGp();
        //llenar
        listaPilotos.adicionarPiloto(new corredoresMotoGp("Maykoll",(byte)30 , (short)16, "Manizales", "Yamaha"));
    }
    
    //get y set

    public listaMotoGp getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(listaMotoGp listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public corredoresMotoGp getCorredores() {
        return corredores;
    }

    public void setCorredores(corredoresMotoGp corredores) {
        this.corredores = corredores;
    }

    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }

    public boolean isDesahabilitarFormulario() {
        return desahabilitarFormulario;
    }

    public void setDesahabilitarFormulario(boolean desahabilitarFormulario) {
        this.desahabilitarFormulario = desahabilitarFormulario;
    }

    public nodoMotoGp getAyudante() {
        return ayudante;
    }

    public void setAyudante(nodoMotoGp ayudante) {
        this.ayudante = ayudante;
    }

    public String getTextoVista() {
        return textoVista;
    }

    public void setTextoVista(String textoVista) {
        this.textoVista = textoVista;
    }

    public List getListadoPilotos() {
        return listadoPilotos;
    }

    public void setListadoPilotos(List listadoPilotos) {
        this.listadoPilotos = listadoPilotos;
    }

    public DefaultDiagramModel getModel() {
        return model;
    }

    public void setModel(DefaultDiagramModel model) {
        this.model = model;
    }

    public short getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setCodigoEliminar(short codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    public short getPilotoSeleccionado() {
        return pilotoSeleccionado;
    }

    public void setPilotoSeleccionado(short pilotoSeleccionado) {
        this.pilotoSeleccionado = pilotoSeleccionado;
    }

    public corredoresMotoGp getPilotoDiagrama() {
        return pilotoDiagrama;
    }

    public void setPilotoDiagrama(corredoresMotoGp pilotoDiagrama) {
        this.pilotoDiagrama = pilotoDiagrama;
    }
    
    
}
