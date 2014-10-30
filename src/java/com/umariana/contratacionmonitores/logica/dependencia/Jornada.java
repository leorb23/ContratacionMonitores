package com.umariana.contratacionmonitores.logica.dependencia;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Jornada {
    private String jornada;
    private int idDependencia;
    private ArrayList<Horario> horarios;
    private int id;

    public Jornada(String jornada, int idDependencia, int id) {
        this.jornada = jornada;
        this.idDependencia = idDependencia;
        this.id=id;
    }
    
    public Jornada(){
        
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public int getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(int idDependencia) {
        this.idDependencia = idDependencia;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Jornada{" + "jornada=" + jornada + ", idDependencia=" + idDependencia + ", id=" + id + '}';
    }
    
    
    
}

