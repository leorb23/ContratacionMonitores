/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umariana.contratacionmonitores.pruebas;

import com.umariana.contratacionmonitores.logica.Aspirante;
import com.umariana.contratacionmonitores.logica.ContratacionMonitores;
import com.umariana.contratacionmonitores.logica.Dependencia;
import com.umariana.contratacionmonitores.logica.Monitor;
import java.io.File;
import java.sql.SQLException;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


/**
 *
 * @author SERVIDOR
 */
public class ContratacionMonitoresTest {
    
    ContratacionMonitores contratacionMonitores;
    
    public ContratacionMonitoresTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        contratacionMonitores = new ContratacionMonitores();
    }
    /**
     * Test of registrarAspirante method, of class ContratacionMonitores.
     */

    public void testRegistrarAspirante() throws Exception {
        System.out.println("registrarAspirante");
        String primerNombre = "";
        String segundoNombre = "";
        String primerApellido = "";
        String segundoApellido = "";
        int codigo = 0;
        String estadoMatricula = "";
        File foto = null;
        double promedioAcumulado = 0.0;
        int semestreActual = 0;
        String identificacion = "";
        
        contratacionMonitores.registrarAspirante(primerNombre, segundoNombre, primerApellido, segundoApellido, codigo, estadoMatricula, foto, promedioAcumulado, semestreActual, identificacion);
        assertTrue(contratacionMonitores.darAspirantes().size()==1);
        contratacionMonitores.registrarAspirante(primerNombre, segundoNombre, primerApellido, segundoApellido, codigo, estadoMatricula, foto, promedioAcumulado, semestreActual, identificacion);
        assertTrue(contratacionMonitores.darAspirantes().size()==1);
       
    }

    /**
     * Test of modificarAspirante method, of class ContratacionMonitores.
     */

    public void testModificarAspirante() throws Exception {
        System.out.println("modificarAspirante");
        String primerNombre = "";
        String segundoNombre = "";
        String primerApellido = "";
        String segundoApellido = "";
        String identificacion = "";
        File foto = null;
        int semestre = 0;
        double promedioAcum = 0.0;
        ContratacionMonitores instance = new ContratacionMonitores();
        instance.modificarAspirante(primerNombre, segundoNombre, primerApellido, segundoApellido, identificacion, foto, semestre, promedioAcum);

        
     
    }

    /**
     * Test of eliminarAspirante method, of class ContratacionMonitores.
     */

    public void testEliminarAspirante() throws Exception {
        System.out.println("eliminarAspirante");
        String identificacion = "";
        ContratacionMonitores instance = new ContratacionMonitores();
        instance.eliminarAspirante(identificacion);

    }

    /**
     * Test of eliminarMonitor method, of class ContratacionMonitores.
     */

    public void testEliminarMonitor() throws Exception {
        System.out.println("eliminarMonitor");
        String identificacion = "";
        ContratacionMonitores instance = new ContratacionMonitores();
        instance.eliminarMonitor(identificacion);

    }

    /**
     * Test of buscarAspirante method, of class ContratacionMonitores.
     */

    public void testBuscarAspirante() {
        System.out.println("buscarAspirante");
        String identificacion = "123";
        Aspirante expResult = null;
        Aspirante result = contratacionMonitores.buscarAspirante(identificacion);
        assertEquals(expResult, result);
        assertTrue(expResult == result);

    }

    /**
     * Test of buscarMonitor method, of class ContratacionMonitores.
     */

    public void testBuscarMonitor() {
        System.out.println("buscarMonitor");
        String identificacion = "";
        Monitor expResult = null;
        Monitor result = contratacionMonitores.buscarMonitor(identificacion);
        assertEquals(expResult, result);

    }

    /**
     * Test of agregarDependencia method, of class ContratacionMonitores.
     */

    public void testAgregarDependencia() throws Exception {
        System.out.println("agregarDependencia");
        String nId = "id";
        String nNombre = "nombre";
        String nDescripcion = "descripcion";
        String nHorario = "mañana";
        contratacionMonitores.agregarDependencia(nId, nNombre, nDescripcion, nHorario);
        assertTrue(contratacionMonitores.darDependencias().size()== 1);
        assertFalse(contratacionMonitores.darDependencias().size()!= 1);
    }

    /**
     * Test of buscarDependencia method, of class ContratacionMonitores.
     */

    public void testBuscarDependencia() {
        System.out.println("buscarDependencia");
        String nId = "";
        Dependencia expResult = null;
        Dependencia result = contratacionMonitores.buscarDependencia(nId);
        assertEquals(expResult, result);

    }    
    
}
