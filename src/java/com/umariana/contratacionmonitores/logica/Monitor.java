package com.umariana.contratacionmonitores.logica;

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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEstadoMatricula() {
        return estadoMatricula;
    }

    public void setEstadoMatricula(String estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public double getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public int getSemestreActual() {
        return semestreActual;
    }

    public void setSemestreActual(int semestreActual) {
        this.semestreActual = semestreActual;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getPuntajePrueba() {
        return puntajePrueba;
    }

    public void setPuntajePrueba(int puntajePrueba) {
        this.puntajePrueba = puntajePrueba;
    }

    public int getPuntajeEntrevista() {
        return puntajeEntrevista;
    }

    public void setPuntajeEntrevista(int puntajeEntrevista) {
        this.puntajeEntrevista = puntajeEntrevista;
    }

    public double getPuntajePromedio() {
        return puntajePromedio;
    }

    public void setPuntajePromedio(double puntajePromedio) {
        this.puntajePromedio = puntajePromedio;
    }

}
