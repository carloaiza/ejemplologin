/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplologin.controlador;

import ejemplologin.modelo.Materia;
import ejemplologin.utilidades.LeerArchivoPlano;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author carloaiza
 */
public class ControladorUniversidad implements Serializable{
    private List<Materia> materias;

    public ControladorUniversidad() {
        llenarMaterias();
        //Llenar estudiantes
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }    
    
    
    public void llenarMaterias()
    {
        materias = LeerArchivoPlano.cargarMaterias();
    }
}
