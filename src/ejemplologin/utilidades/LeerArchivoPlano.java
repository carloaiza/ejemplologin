/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplologin.utilidades;

import ejemplologin.modelo.Materia;
import ejemplologin.modelo.TipoUsuario;
import ejemplologin.modelo.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carloaiza
 */
public class LeerArchivoPlano {

    public static List<Usuario> cargarUsuarios(TipoUsuario[] tipos) {
        List<Usuario> listado= new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("src/usuariosProg1.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;            
            br.readLine();
            while ((linea = br.readLine()) != null) {
               
               String[] datos= linea.split(";");
               
               Usuario usuario= new Usuario(
                       datos[3], 
                       datos[4], 
                       tipos[Integer.parseInt(datos[5])-1] , 
                       datos[0], datos[1],Byte.parseByte(datos[2]));               
               listado.add(usuario);
                       
            }
        } catch (Exception e) {
            System.out.println("El archivo no existe = " + e.getMessage());
        } finally {            
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return listado;
    }

    
     public static List<Materia> cargarMaterias() {
        List<Materia> listado= new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("src/materias.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;            
            //br.readLine();
            while ((linea = br.readLine()) != null) {
               
               String[] datos= linea.split(";");
               
               Materia materia = new Materia(datos[0], datos[1], 
                       Byte.parseByte(datos[2]));
               listado.add(materia);
                       
            }
        } catch (Exception e) {
            System.out.println("El archivo no existe = " + e.getMessage());
        } finally {            
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return listado;
    }
    
    
}
