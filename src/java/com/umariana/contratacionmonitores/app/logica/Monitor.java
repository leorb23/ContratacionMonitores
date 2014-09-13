package com.umariana.contratacionmonitores.app.logica;

import java.io.File;

public class Monitor 
{
    //
    //ATRIBUTOS
    //
    
        /**
	 * Es el monitor 
	 */
        private String nombres;
         /**
	 * Es la dependencia
	 */
        private String apellidos;
	/**
	 * Es la lista de dependencias existentes en el sistema
	 */
	private int codigo;
	/**
	 * Es la lista de monitores existentes en el sistema
	 */
	private String estadoMatricula;
	/**
	 * Es la lista de resultados existentes en el sistema
	 */
	private File foto;
        /**
         * Es la lista de aspirantes al cargo de monitor
         */
        private double promedioAcumulado;
        /**
	 * Es la lista de monitores existentes en el sistema
	 */
	private int semestreActual;
	/**
	 * Es la lista de resultados existentes en el sistema
	 */
	private String identificacion;
        /**
         * Es la lista de aspirantes al cargo de monitor
         */
        private int puntajePrueba;
        /**
	 * Es la lista de resultados existentes en el sistema
	 */
	private int puntajeEntrevista;
        /**
         * Es la lista de aspirantes al cargo de monitor
         */
        private double puntajePromedio;
    //
    //CONSTRUCTOR
    //
    /**
    * Es el constructor de la clase Monitor
    */
    public Monitor( String nNomb, String nAPe, int nCod, String nEstado, File nFoto, double nPromAcum, int nSemActual, String nIdenti, int puntPrueba, int puntEntrev, double nPuntProm)
    {
        nombres = nNomb;
        apellidos = nAPe;
        codigo = nCod;
        estadoMatricula = nEstado;
        foto = nFoto;
        promedioAcumulado = nPromAcum;
        semestreActual = nSemActual;
        identificacion = nIdenti;
        puntajePrueba = puntPrueba;
        puntajeEntrevista = puntEntrev;
        puntajePromedio = nPuntProm;
    }

}
