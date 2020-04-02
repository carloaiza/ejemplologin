/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplologin.controlador;

import ejemplologin.excepciones.UniversidadExcepcion;
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
        if(materias == null || materias.isEmpty())
        {
            materias = LeerArchivoPlano.cargarMaterias();
        }
    }
    
    public void adicionarMateria(Materia materia) throws UniversidadExcepcion
    {
        if(validarExistenciaMateria(materia))
        {
            ///gritar que esa materia ya existe
            throw new UniversidadExcepcion("La materia "+materia.getCodigo() + 
                    " ya existe");
        }
        else
        {            //agrego a la lista
            if(materia.getCapacidadAlumnos()<=0)
            {
                throw new UniversidadExcepcion("La capacidad de la materia debe ser mayor a cero");
            }
            materias.add(materia);
            // agregarla en el archivo
        }
    }
    
    private boolean validarExistenciaMateria(Materia materia)
    {
        for(Materia mat: this.materias)
        {
            if(mat.getCodigo().compareTo(materia.getCodigo())==0)
            {
                return true;
            }
        }        
        return false;
    }
    
}
