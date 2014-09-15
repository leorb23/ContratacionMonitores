package com.umariana.contratacionmonitores.logica;

import java.io.File;

/**
 *
 * @author CocoSoft
 */
public class IUsuario  {
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
}
