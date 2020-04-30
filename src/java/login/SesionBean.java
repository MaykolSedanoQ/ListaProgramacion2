/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.listase.utilidades.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import login.controlador.ControladorUsuarios;
import login.modelo.Usuario;

/**
 *
 * @author Maykol Sedano
 */
@Named(value = "sesionBean")
@SessionScoped
public class SesionBean implements Serializable {

    //atributo para ocultar o visualizar el login
    private boolean verPanelDelLogin = false;

    //atributo correo
    private String correo = "maykol-1.6@outlook.com";
    //atributo contrasenia
    private String contrasenia = "1234567";
    private ControladorUsuarios controlUsuarios;
    private Usuario usuarioAutenticado;

    public SesionBean() {
        controlUsuarios = new ControladorUsuarios();
    }

    public boolean isVerPanelDelLogin() {
        return verPanelDelLogin;
    }

    public void setVerPanelDelLogin(boolean verPanelDelLogin) {
        this.verPanelDelLogin = verPanelDelLogin;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ControladorUsuarios getControlUsuarios() {
        return controlUsuarios;
    }

    public void setControlUsuarios(ControladorUsuarios controlUsuarios) {
        this.controlUsuarios = controlUsuarios;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    //Metodo para ocultar el login
    public void habilitarOdeshabilitarLogin() {
        verPanelDelLogin = !verPanelDelLogin;
    }

    public String ingresar() {

        //buscamos el usuarios en el controlador
        Usuario usuarioEncontrado = controlUsuarios.encontrarUsuarioxCorreo(correo);
        if (usuarioEncontrado != null) {
            //encontro el usuario y compara
            if (usuarioEncontrado.getContrasenia().equals(contrasenia)) {
                usuarioAutenticado = usuarioEncontrado;
                return "inicioListas.xhtml";
            }
        }
        JsfUtil.addErrorMessage("Los datos ingresados no son validos");
        return null;
    }

}

