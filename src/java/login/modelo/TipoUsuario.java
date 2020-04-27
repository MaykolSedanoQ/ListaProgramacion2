/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.modelo;

import java.io.Serializable;

/**
 *
 * @author Maykol Sedano
 */
public class TipoUsuario implements Serializable{
    
    //atributos
    private int codigo;
    private String descripcion;
    
    
    //constructores

    public TipoUsuario() {
    }

    public TipoUsuario(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

     
//get y set

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
