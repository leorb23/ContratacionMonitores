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
import com.umariana.contratacionmonitores.logica.Resultado;
import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SERVIDOR
 */
public class ContratacionMonitoresTest {
    
    ContratacionMonitores contratacionMonitores;
    
    public ContratacionMonitoresTest() {
        contratacionMonitores = new ContratacionMonitores();
    }
    /**
     * Test of registrarAspirante method, of class ContratacionMonitores.
     */
    @Test
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
    @Test
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
     
    }

    /**
     * Test of eliminarAspirante method, of class ContratacionMonitores.
     */
    @Test
    public void testEliminarAspirante() throws Exception {
        System.out.println("eliminarAspirante");
        String identificacion = "";
        ContratacionMonitores instance = new ContratacionMonitores();
        instance.eliminarAspirante(identificacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarMonitor method, of class ContratacionMonitores.
     */
    @Test
    public void testEliminarMonitor() throws Exception {
        System.out.println("eliminarMonitor");
        String identificacion = "";
        ContratacionMonitores instance = new ContratacionMonitores();
        instance.eliminarMonitor(identificacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAspirante method, of class ContratacionMonitores.
     */
    @Test
    public void testBuscarAspirante() {
        System.out.println("buscarAspirante");
        String identificacion = "";
        ContratacionMonitores instance = new ContratacionMonitores();
        Aspirante expResult = null;
        Aspirante result = instance.buscarAspirante(identificacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarMonitor method, of class ContratacionMonitores.
     */
    @Test
    public void testBuscarMonitor() {
        System.out.println("buscarMonitor");
        String identificacion = "";
        ContratacionMonitores instance = new ContratacionMonitores();
        Monitor expResult = null;
        Monitor result = instance.buscarMonitor(identificacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarDependencia method, of class ContratacionMonitores.
     */
    @Test
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
    @Test
    public void testBuscarDependencia() {
        System.out.println("buscarDependencia");
        String nId = "";
        ContratacionMonitores instance = new ContratacionMonitores();
        Dependencia expResult = null;
        Dependencia result = instance.buscarDependencia(nId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }    
    
}
