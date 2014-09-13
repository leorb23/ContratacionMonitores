package com.umariana.contratacionmonitores.app.logica;

import java.io.File;

public class Dependencia 
{
        //
    //ATRIBUTOS
    //
    
        /**
	 * Es el monitor 
	 */
        private String id;
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
	
    //
    //CONSTRUCTOR
    //
    /**
    * Es el constructor de la clase Monitor
    */
    public Dependencia( String nId, String nNombre, String nDescripcion, String nHorario)
    {
        id = nId;
        nombre = nNombre;
        descripcion = nDescripcion;
        horario = nHorario;
    }

}
