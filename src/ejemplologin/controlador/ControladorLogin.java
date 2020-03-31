/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplologin.controlador;

import ejemplologin.modelo.TipoUsuario;
import ejemplologin.modelo.Usuario;
import ejemplologin.utilidades.LeerArchivoPlano;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carloaiza
 */
public class ControladorLogin {
    
    private TipoUsuario[] tipoUsuarios;
    //Cambiar por una collección java.util
    // Set, List, HashTable 
    //ArrayList - Polimorfismo
    private List<Usuario> usuarios;    
    

    public ControladorLogin() {
        llenarTiposUsuario();
        llenarUsuarios();
    }
    
    private void llenarTiposUsuario()
    {
        tipoUsuarios = new TipoUsuario[3]; 
        tipoUsuarios[0] = new TipoUsuario((byte)1, "Administrador");
        tipoUsuarios[1] = new TipoUsuario((byte)2, "Consulta");
        tipoUsuarios[2] = new TipoUsuario((byte)3, "Secretaria");
    }
    
    private void llenarUsuarios()
    {
//        usuarios = new ArrayList<>();           
//        usuarios.add(new Usuario("carloaiza@umanizales.edu.co", "123456", tipoUsuarios[0],"Carlos", "Loaiza Guerrero",(byte) 54));
//        usuarios.add(new Usuario("consulta@umanizales.edu.co", "654321", tipoUsuarios[1],"Pedro", "Pérez Osa",(byte) 24));
//        usuarios.add(new Usuario("secretaria@umanizales.edu.co", "13579", tipoUsuarios[2],"Juanita", "Juárez Jaramillo",(byte) 18));       
//        
        //cargar el csv
        usuarios=LeerArchivoPlano.cargarUsuarios(tipoUsuarios);
        
    }
    
    public Usuario encontrarUsuario(String correo, String password)
    {
        for(Usuario usuarioEncontrado: usuarios)
        {
            if(usuarioEncontrado.getCorreoElectronico().compareTo(correo)==0 &&
                    usuarioEncontrado.getPassword().compareTo(password)==0)
            {
                return usuarioEncontrado;
            }
        }
        
        return null;
    }
    
}
