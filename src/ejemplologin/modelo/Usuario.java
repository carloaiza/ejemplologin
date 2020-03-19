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
public class Usuario extends Tercero implements Serializable{    
    private String correoElectronico;
    private String password;
    private TipoUsuario tipoUsuario;

    
    public Usuario(String correoElectronico, String password, TipoUsuario tipoUsuario, String nombre, String apellidos, byte edad) {
        super(nombre, apellidos, edad);
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
}
