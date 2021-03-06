/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listade.modelo.motogp.CorredorMotoGp;
import com.listade.modelo.motogp.ListaMotoGp;
import com.listade.modelo.motogp.NodoMotoGp;
import com.listase.excepciones.PilotosExcepcion;
import com.listase.utilidades.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
@Named(value = "sesionMotoGp")
@SessionScoped
public class SesionMotoGp implements Serializable {

    private ListaMotoGp listaPilotos;
    private CorredorMotoGp corredor;
    private String alInicio = "1";
    private boolean desahabilitarFormulario = true;
    private NodoMotoGp ayudante;
    private String textoVista = "Grafico";
    private List listadoPilotos;
    private DefaultDiagramModel model;
    private short numeroDelPilotoAEliminar;
    private short pilotoSeleccionado;
    private CorredorMotoGp pilotoDiagrama;
    private int numeroPosiciones=0;
    private CorredorMotoGp posicionPiloto;
    private int pos1;
    private int pos2;
    
    private int posPiloto;
    private String opcionElegida="1";
    private  int  numeroPosicion=1;
    private short posicionBuscar;
    private short codPiloto;

    /**
     * Creates a new instance of SesionMotoGp
     */
    public SesionMotoGp() {
    }

    @PostConstruct
    private void inicializar() {

        listaPilotos = new ListaMotoGp();
        //llenar
        listaPilotos.adicionarPiloto(new CorredorMotoGp("Maykoll", (byte) 30, (short) 16, "Colombia", "Yamaha"));
        listaPilotos.adicionarPiloto(new CorredorMotoGp("Luis", (byte) 31, (short)35, "Argentina", "Ducati"));
        ayudante=listaPilotos.getCabeza();
        corredor= ayudante.getDato();
        listadoPilotos= listaPilotos.obtenerListaPilotos();
        pintarLista();
    }
    
    public int getNumeroPosiciones() {
        return numeroPosiciones;
    }

    public int getPosPiloto() {
        return posPiloto;
    }

    public void setPosPiloto(int posPiloto) {
        this.posPiloto = posPiloto;
    }

    public String getOpcionElegida() {
        return opcionElegida;
    }

    public void setOpcionElegida(String opcionElegida) {
        this.opcionElegida = opcionElegida;
    }

    public int getNumeroPosicion() {
        return numeroPosicion;
    }

    public void setNumeroPosicion(int numeroPosicion) {
        this.numeroPosicion = numeroPosicion;
    }

    public short getPosicionBuscar() {
        return posicionBuscar;
    }

    public void setPosicionBuscar(short posicionBuscar) {
        this.posicionBuscar = posicionBuscar;
    }

    public short getCodPiloto() {
        return codPiloto;
    }

    public void setCodPiloto(short codPiloto) {
        this.codPiloto = codPiloto;
    }

    public CorredorMotoGp getPosicionPiloto() {
        return posicionPiloto;
    }

    public void setPosicionPiloto(CorredorMotoGp posicionPiloto) {
        this.posicionPiloto = posicionPiloto;
    }

    public int getPos1() {
        return pos1;
    }

    public void setPos1(int pos1) {
        this.pos1 = pos1;
    }

    public int getPos2() {
        return pos2;
    }

    public void setPos2(int pos2) {
        this.pos2 = pos2;
    }
    
    public ListaMotoGp getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(ListaMotoGp listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public CorredorMotoGp getCorredor() {
        return corredor;
    }

    public void setCorredor(CorredorMotoGp corredor) {
        this.corredor = corredor;
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

    public NodoMotoGp getAyudante() {
        return ayudante;
    }

    public void setAyudante(NodoMotoGp ayudante) {
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

    public short getNumeroDelPilotoAEliminar() {
        return numeroDelPilotoAEliminar;
    }

    public void setNumeroDelPilotoAEliminar(short numeroDelPilotoAEliminar) {
        this.numeroDelPilotoAEliminar = numeroDelPilotoAEliminar;
    }

    public short getPilotoSeleccionado() {
        return pilotoSeleccionado;
    }

    public void setPilotoSeleccionado(short pilotoSeleccionado) {
        this.pilotoSeleccionado = pilotoSeleccionado;
    }

    public CorredorMotoGp getPilotoDiagrama() {
        return pilotoDiagrama;
    }

    //get y set
    public void setPilotoDiagrama(CorredorMotoGp pilotoDiagrama) {    
        this.pilotoDiagrama = pilotoDiagrama;
    }

    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));

        if (label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }

        return conn;
    }

    //metodos
    //guardar un piloto nuevo
    public void guardarPilotos() {
        //corredor.setNumeroPiloto((short) (listaPilotos.contarPilotos() + 1));
        if (alInicio.compareTo("1") == 0) {
            listaPilotos.adiccionarPilotoAlInicio(corredor);
        } else {
            listaPilotos.adicionarPiloto(corredor);
        }
        listadoPilotos = listaPilotos.obtenerListaPilotos();
        pintarLista();
        desahabilitarFormulario = true;
        JsfUtil.addSuccessMessage("El piloto se ha guardado correctamente");
    }
    //--------------------------------------------------------------------------------------------  
    
    //Habilitar el formulario para los pilotos
    public void hablitarFormularioPiloto() 
    {
        desahabilitarFormulario = false;
        corredor = new CorredorMotoGp();
       
    }
    //--------------------------------------------------------------------------------------------

    //ir al siguiente piloto
    public void irAlSiguientePiloto() {
        if (ayudante.getSiguiente() != null) {
            ayudante = ayudante.getSiguiente();
            corredor = ayudante.getDato();
        }
    }
    //------------------------------------------------------------------------------------------ 

    //ir al anterior piloto
    public void irAlAnteriorPiloto() {
        if (ayudante.getAnterior() != null) {
            ayudante = ayudante.getAnterior();
            corredor = ayudante.getDato();
        }
    }
    //--------------------------------------------------------------------------------------------

    public void irAlPrimerPiloto() {
        if (listaPilotos.getCabeza() != null) {
            ayudante = listaPilotos.getCabeza();
            corredor = ayudante.getDato();
        } else {
            corredor = new CorredorMotoGp();
        }
        listadoPilotos = listaPilotos.obtenerListaPilotos();
        pintarLista();
    }
//-----------------------------------------------------------------------------------------

    public void irAlUltimoPiloto() {
        if (listaPilotos.getCabeza() != null) {
            while (ayudante.getSiguiente() != null) {
                ayudante = ayudante.getSiguiente();
            }
            corredor = ayudante.getDato();
        }
    }
    //-------------------------------------------------------------------------

     public void cambiarVistaPiloto()
    {
        if(textoVista.compareTo("Tabla")==0)
        {
            textoVista = "Gráfico";
        }
        else
        {
            textoVista = "Tabla";
        }
    }
    //----------------------------------------------
    
    
    
    
    
      public void invertirLista(){
        //Invierte la lista
        listaPilotos.invertirPosicionesPilitos();
        irAlPrimerPiloto();
    }
    
    
    
    public void pintarLista() {
        //Instancia el modelo
        model = new DefaultDiagramModel();
        //Se establece para que el diagrama pueda tener infinitas flechas
        model.setMaxConnections(-1);

        StateMachineConnector connector = new StateMachineConnector();
        connector.setOrientation(StateMachineConnector.Orientation.ANTICLOCKWISE);
        connector.setPaintStyle("{strokeStyle:'#7D7463',lineWidth:3}");
        model.setDefaultConnector(connector);

        ///Adicionar los elementos
        if (listaPilotos.getCabeza() != null) {
            //llamo a mi ayudante
            NodoMotoGp temp = listaPilotos.getCabeza();
            int posX = 2;
            int posY = 2;
            //recorro la lista de principio a fin
            while (temp != null) {
                //Parado en un elemento
                //Crea el cuadrito y lo adiciona al modelo
                Element ele = new Element(temp.getDato().getNumeroPiloto() + " "
                        + temp.getDato().getNombre(),
                        posX + "em", posY + "em");
                ele.setId(String.valueOf(temp.getDato().getNumeroPiloto()));
                //adiciona un conector al cuadrito
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));

                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM));
                model.addElement(ele);
                temp = temp.getSiguiente();
                posX = posX + 5;
                posY = posY + 6;
            }

            //pintar flechas
            for (int i = 0; i < model.getElements().size() - 1; i++) {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1),
                        model.getElements().get(i + 1).getEndPoints().get(0), "Sig"));

                model.connect(createConnection(model.getElements().get(i + 1).getEndPoints().get(2),
                        model.getElements().get(i).getEndPoints().get(3), "Ant"));
            }

        }
    }
    //------------------------------------------------------------------------

    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");

        pilotoSeleccionado = Short.valueOf(id.replaceAll("frmMotoGp:diagrama-", ""));

    }
    //----------------------------------------------------------------------------------------------

    //eliminar un piloto
    public void eliminarPiloto() {
        if (numeroDelPilotoAEliminar >= 0) {
            try {
                listaPilotos.eliminarPiloto(numeroDelPilotoAEliminar);
                irAlPrimerPiloto();
                JsfUtil.addSuccessMessage("Piloto" + numeroDelPilotoAEliminar + "Eliminado");
            } catch (PilotosExcepcion e) {
                JsfUtil.addErrorMessage(e.getMessage());
            }
        } else {
            JsfUtil.addErrorMessage("El numero del piloto" + numeroDelPilotoAEliminar + "No es valido");
        }
    }
//-----------------------------------------------------------------------------------
    
    //obetener el diagrama de los pilotos
    public  void obtenerDiagramaPilotos(){
        try{
            pilotoDiagrama= listaPilotos.obtenerPiloto(pilotoSeleccionado);
            
        }catch(PilotosExcepcion ex){
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    //------------------------------------------------------------------
    
    // envir piloto al inicio
   public void enviarPilotoUltimaPos(){
       try{
           CorredorMotoGp corredorTemp = listaPilotos.obtenerPiloto(pilotoSeleccionado);
           listaPilotos.eliminarPiloto(pilotoSeleccionado);
           listaPilotos.adicionarPiloto(corredorTemp);
           pintarLista();
       }catch(PilotosExcepcion ex){
           JsfUtil.addErrorMessage(ex.getMessage());
       }
   }
   //--------------------------------------------------------
   //piloto primera posicion
   public  void  enviarPilotoPrimeraPos(){
       try{
           CorredorMotoGp corredorTemp = listaPilotos.obtenerPiloto(pilotoSeleccionado);
        listaPilotos.eliminarPiloto(pilotoSeleccionado);
        listaPilotos.adiccionarPilotoAlInicio(corredorTemp);
        pintarLista();
       }catch(PilotosExcepcion ex){
           JsfUtil.addErrorMessage(ex.getMessage());
       }
   }
   
   //--------------------------------------------------
 
     
     public void obtenerPosicionPiloto()
    {
        try {
            posPiloto = listaPilotos.obtenerPosicionPiloto(pilotoSeleccionado);
        } catch (PilotosExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
     
     public void cambiarPosicion()
    {
        boolean bandera=false;
        int posicionFinal=0;
        switch(opcionElegida)
        {
            //Ganar
            case "1":
                if(numeroPosicion <= (posPiloto-1) )
                {
                    bandera=true;
                    posicionFinal = posPiloto - numeroPosicion;
                }
                break;
            //Perder
            case "0":
                if(numeroPosicion <= (listaPilotos.contarPilotos()-posPiloto))
                {
                    bandera=true;
                    posicionFinal = posPiloto + numeroPosicion;
                }
                break;
        }
        
        if(bandera)
        {
            try {
                //Realizaria la función de insertar
                CorredorMotoGp datosPiloto = listaPilotos.obtenerPiloto(pilotoSeleccionado);
                // cambia la cantidad de infantes
                listaPilotos.eliminarPiloto(pilotoSeleccionado);
                listaPilotos.adicionarNodoPosicion(posicionFinal, datosPiloto);
                irAlPrimerPiloto();
                JsfUtil.addSuccessMessage("Se ha realizado el cambio");
                
                
            } catch (PilotosExcepcion ex) {
               JsfUtil.addErrorMessage(ex.getMessage());
            }
            
        }
        else
        {
            JsfUtil.addErrorMessage("El número de posiciones no es válido para el Piloto dado");
        }
    }
    
   
   
}
