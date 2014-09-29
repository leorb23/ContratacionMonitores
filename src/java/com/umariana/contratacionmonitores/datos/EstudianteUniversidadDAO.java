/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.umariana.contratacionmonitores.datos;

import com.umariana.contratacionmonitores.logica.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class EstudianteUniversidadDAO {

    public Estudiante buscarEstudiante(String identificacion) {
        ArrayList<Estudiante> estudiantes = new ArrayList();
        
        Estudiante estudiante1= new Estudiante("primerN", "segundoN", "pirmerA", "segundoA", 1, "estadoMaatricula", null, 1.0, 8, "201");
        Estudiante estudiante2= new Estudiante("primerN", "segundoN", "pirmerA", "segundoA", 2, "estadoMaatricula", null, 5.0, 1, "202");
        Estudiante estudiante3= new Estudiante("primerN", "segundoN", "pirmerA", "segundoA", 3, "estadoMaatricula", null, 5.0, 8, "203");
        Estudiante estudiante4= new Estudiante("primerN", "segundoN", "pirmerA", "segundoA", 4, "estadoMaatricula", null, 2.0, 2, "204");
        
        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);
        estudiantes.add(estudiante4);
        
        for(Estudiante est: estudiantes){
            if(est.darIdentificacion().equals(identificacion))
                return est;
        }
        
        return null;
    }
    
}
