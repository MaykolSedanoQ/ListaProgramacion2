/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjsf.controlador;

import java.util.ArrayList;
import java.util.List;
import loginjsf.modelo.TipoUsuario;
import loginjsf.modelo.Usuario;

/**
 *
 * @author carloaiza
 */
public class ControladorUsuarios {

    private List<TipoUsuario> tiposUsuario;
    private static List<Usuario> usuarios;

    public ControladorUsuarios() {
        this.iniciarListados();
    }

    public List<TipoUsuario> getTiposUsuario() {
        return tiposUsuario;
    }

    public void setTiposUsuario(List<TipoUsuario> tiposUsuario) {
        this.tiposUsuario = tiposUsuario;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        ControladorUsuarios.usuarios = usuarios;
    }

    private void iniciarListados() {
        //Simula la conexion a bds o archivos planos
        tiposUsuario = new ArrayList<>();
        tiposUsuario.add(new TipoUsuario(1, "Administrador"));
        tiposUsuario.add(new TipoUsuario(2, "Jugador"));
   

usuarios = new ArrayList<>();
        usuarios.add(new Usuario("maykol-1.6@outlook.com", "oncecaldas2004", "Maykol Sedano",
                tiposUsuario.get(0)));
        usuarios.add(new Usuario("mseedanoquintero@umanizales.co", "123456789", "Maykoll Quintero",
                tiposUsuario.get(1)));
        usuarios.add(new Usuario("maykol-16@outlook.com", "123456789", "Maykoll",
                tiposUsuario.get(1)));
        usuarios.add(new Usuario("maykolsed16@gmail.com", "123456789", "Maykoll Sed",
                tiposUsuario.get(1)));
        
    }

    public Usuario encontrarUsuarioxCorreo(String correo) {
        Usuario usuarioEncontrado = null;
        //Recorre la lista de principio a fin 
        for (Usuario usu : ControladorUsuarios.usuarios) {
            if (usu.getCorreo().equals(correo)) {
                return usu;
            }
        }

        return usuarioEncontrado;
    }

}
