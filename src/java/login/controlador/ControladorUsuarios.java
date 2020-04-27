/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.controlador;

import java.util.ArrayList;
import java.util.List;
import login.modelo.TipoUsuario;
import login.modelo.Usuario;

/**
 *
 * @author Maykol Sedano
 */
public class ControladorUsuarios {
    private List<TipoUsuario> tiposUsuario;
    private List<Usuario> usuarios;
    
    public ControladorUsuarios(){
        
    }

    public List<TipoUsuario> getTiposUsuario() {
        return tiposUsuario;
    }

    public void setTiposUsuario(List<TipoUsuario> tiposUsuario) {
        this.tiposUsuario = tiposUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
   public void  iniciarListados(){
       //simula la conexion a bases de datos o archivos planos
       tiposUsuario= new ArrayList<>();
       tiposUsuario.add(new TipoUsuario(1,"Jugador"));
       
       usuarios= new ArrayList<>();
       usuarios.add(new Usuario("maykol-1.6@outlook.com", "1234567", "Maykoll Sedano", tiposUsuario.get(0)));   
   }
    
   //-----------------------------------------------------------
   
   public Usuario encontrarUsuarioxCorreo(String correo){
        Usuario usuarioEncontrado= null;
        //recorre la lista de principio a fin
        for(Usuario usu: this.usuarios){
            if(usu.getCorreo().equals(correo)){
                return usu;
            }
        }
        return usuarioEncontrado;
       
   }
}
