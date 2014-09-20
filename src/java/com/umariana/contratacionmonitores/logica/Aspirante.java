package com.umariana.contratacionmonitores.logica;

import com.umariana.contratacionmonitores.excepciones.ExcepcionNoExiste;
import com.umariana.contratacionmonitores.excepciones.ExcepcionYaExiste;
import java.io.File;
import java.util.ArrayList;

public class Aspirante extends Estudiante{
    /**
     * Es la lista de postulaciones a las que se ha inscrito el estudiante
     */
    private ArrayList<Dependencia> postulaciones;
    
    /**
     * Es el constructor de la clase Aspirante
     * @param primerNombre != null && != ""
     * @param segundoNombre
     * @param primerApellido != null && != ""
     * @param segundoApellido
     * @param codigo != null && != ""
     * @param estadoMatricula != null && != ""
     * @param foto 
     * @param promedioAcumulado > 0  && <= 5
     * @param semestreActual > 0  && <= 10
     * @param identificacion != null && != ""
     */
    public Aspirante(String primerNombre,String segundoNombre , String primerApellido, String segundoApellido, int codigo, String estadoMatricula, File foto, double promedioAcumulado, int semestreActual, String identificacion)
    {
        super(primerNombre, segundoNombre, primerApellido, segundoApellido, codigo, estadoMatricula, foto, promedioAcumulado, semestreActual, identificacion);
        postulaciones = new ArrayList<Dependencia>();
    }  

    /**
     * 
     * @return 
     */
    public ArrayList<Dependencia> darPostulaciones() 
    {
        return postulaciones;
    }
    /**
     * 
     * @param postulaciones 
     */
    public void cambiarPostulaciones(ArrayList<Dependencia> postulaciones) 
    {
        this.postulaciones = postulaciones;
    }
    /**
     * 
     * @param eliminarPostulacion
     * @throws ExcepcionNoExiste 
     */
    public void quitarPostulacion(Dependencia eliminarPostulacion) throws ExcepcionNoExiste
    {    
        if(buscarPostulacion(eliminarPostulacion.darId())!=null)
            postulaciones.remove(eliminarPostulacion);
        else
            throw  new ExcepcionNoExiste("La postulacion que desea eliminar no existe!!");
    } 
    /**
     * 
     * @param agregarPostulacion
     * @throws ExcepcionYaExiste 
     */
    public void agregarPostulacion(Dependencia agregarPostulacion) throws ExcepcionYaExiste
    {
        if(buscarPostulacion(agregarPostulacion.darId())==null)
            postulaciones.add(agregarPostulacion);
        else
            throw  new ExcepcionYaExiste("Ya se ha postulado a esta dependencia anteriormente!!");
    }
    /**
     * 
     * @param idPostulacion
     * @return 
     */
    public Dependencia buscarPostulacion(String idPostulacion){
        
        for(Dependencia buscarDependencia: postulaciones ){
            if(buscarDependencia.darId().equals(idPostulacion))
                return buscarDependencia;
        }
        return null;
    }
    
}
