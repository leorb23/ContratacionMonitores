package com.umariana.contratacionmonitores.logica;

import com.umariana.contratacionmonitores.logica.dependencia.Jornada;
import java.util.ArrayList;
import java.util.List;

public class Dependencia 
{
        //
    //ATRIBUTOS
    //
    
        /**
	 * Es el monitor 
	 */
        private int id;
         /**
	 * Es la dependencia
	 */
        private String nombre;
	/**
	 * Es la lista de dependencias existentes en el sistema
	 */
	private String descripcion;
	/**
	 * Es la lista de monitores existentes en el sistema
	 */
	private String horario;
        /**
         * Son los cupos disponibles que tiene la dependencia
         */
        private int cuposDisponibles;
         /**
         * Son los cupos que tiene la dependencia
         */
        private int cupos;
        /**
         * 
         */
        private List<Jornada> jornadas;
	
    //
    //CONSTRUCTOR
    //
    /**
    * Es el constructor de la clase Monitor
    */
    public Dependencia( int nId, String nNombre, String nDescripcion, String nHorario, int cupos)
    {
        id = nId;
        nombre = nNombre;
        descripcion = nDescripcion;
        horario = nHorario;
        this.cupos = cupos;
        jornadas= new ArrayList<>();
    }
    
    public Dependencia(String nombre,String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Dependencia(){
        jornadas= new ArrayList<>();
    }

    public int darId() {
        return id;
    }

    public void cambiarId(int id) {
        this.id = id;
    }

    public String darNombre() {
        return nombre;
    }

    public void cambiarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String darDescripcion() {
        return descripcion;
    }

    public void cambiarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String darHorario() {
        return horario;
    }

    public void cambiarHorario(String horario) {
        this.horario = horario;
    }

    /**
     * 
     * @return 
     */
    public int darCuposDisponibles() {
        return cuposDisponibles;
    }
    /**
     * 
     * @param cuposDisponibles 
     */
    public void cambiarCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }
    /**
     * 
     * @return 
     */
    public int darCupos() {
        return cupos;
    }
    /**
     * 
     * @param cupos 
     */
    public void cambiarCupos(int cupos) {
        this.cupos = cupos;
    }
    /**
     * 
     * @return 
     */
    public List<Jornada> darJornadas() {
        return jornadas;
    }
    /**
     * 
     * @param jornadas 
     */
    public void cambiarJornadas(List<Jornada> jornadas) {
        this.jornadas = jornadas;
    }

    @Override
    public String toString() {
        return "Dependencia{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", jornadas=" + jornadas + '}';
    }

    public void agregarJornada(Jornada jornada) {
        jornadas.add(jornada);
    }
    
    
    
}
