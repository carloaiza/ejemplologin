/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplologin.modelo;

import java.io.Serializable;

/**
 *
 * @author carloaiza
 */
public class TipoUsuario implements Serializable {
    private byte codigo;
    private String descripcion;

    public TipoUsuario(byte codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }    
    
    public byte getCodigo() {
        return codigo;
    }

    public void setCodigo(byte codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
    
    
    
    
}
