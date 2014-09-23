/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.umariana.contratacionmonitores.datos;

import com.umariana.contratacionmonitores.logica.Aspirante;

/**
 *
 * @author Andres
 */
public class EstudianteUniversidadDAO {

    Aspirante buscarEstudiante(String identificacion) {
        System.out.println("Estudiante encontrado!! -->>  /n");
        Aspirante nuevo= new Aspirante("primerNombre","segundoNombre", "primerApellido","segundoApellido", 1, "estadoMatricula", null,1.0,1,identificacion);
        return nuevo;
    }
    
}
