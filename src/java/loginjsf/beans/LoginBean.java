/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjsf.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import loginjsf.controlador.ControladorUsuarios;
import loginjsf.modelo.Usuario;
import com.listase.utilidades.JsfUtil;

/**
 *
 * @author carloaiza
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    //Atributo para ocultar o visualizar el panel del login
    private boolean verPanelLogin=false;
    
    //Atributo para capturar el texto para mostrar en el saludo
    private String textoSaludo="";
    
    //Atributo contador para los saludos
    private short contadorSaludos=0;
    
    //Atributo String correo
    private String correo="maykol-1.6@outlook.com";
    
    private String contrasenia="oncecaldas2004";
    
    //atributo controlador para gestionar usuarios y tipos
    private ControladorUsuarios controlUsuarios;
    /**
     * Creates a new instance of loginBean
     */
    private Usuario usuarioAutenticado;
    
    public LoginBean() {
        controlUsuarios = new ControladorUsuarios();
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
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
    
    

    public boolean isVerPanelLogin() {
        return verPanelLogin;
    }

    public void setVerPanelLogin(boolean verPanelLogin) {
        this.verPanelLogin = verPanelLogin;
    }

    public String getTextoSaludo() {
        return textoSaludo;
    }

    public void setTextoSaludo(String textoSaludo) {
        this.textoSaludo = textoSaludo;
    }

    public short getContadorSaludos() {
        return contadorSaludos;
    }

    public void setContadorSaludos(short contadorSaludos) {
        this.contadorSaludos = contadorSaludos;
    }
    
    public void aumentarContadorSaludos()
    {
        contadorSaludos ++;
    }
    
    
    //Método para cambiar el valor de la variable y ocultar o mostrar el panel
    public void habilitarOdeshabilitarLogin()
    {
        verPanelLogin = !verPanelLogin;
    }
    
    public String ingresar()
    {
        //Vamos al controlador y buscamos el usuario segun el correo ingresado
        Usuario usuarioEncontrado=controlUsuarios.encontrarUsuarioxCorreo(correo);
        if(usuarioEncontrado !=null)
        {
            //Encontro el usuario y comparar las contraseñas
            if(usuarioEncontrado.getContrasenia().equals(contrasenia))
            {                
                usuarioAutenticado= usuarioEncontrado;
                return "inicio";
            }           
        }
        JsfUtil.addErrorMessage("Los datos ingresados son errados");
        
        return null;
    }
    
}
