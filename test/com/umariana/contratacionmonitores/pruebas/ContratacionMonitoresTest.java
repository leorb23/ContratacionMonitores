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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andres
 */
public class ContratacionMonitoresTest {
    
    ContratacionMonitores cm;
    
    public ContratacionMonitoresTest() {
        cm = new ContratacionMonitores();
    }

    /**
     * Test of darMonitores method, of class ContratacionMonitores.
     */
    @Test
    public void testDarMonitores() {
    }

    /**
     * Test of cambiarMonitores method, of class ContratacionMonitores.
     */
    @Test
    public void testCambiarMonitores() {
    }

    /**
     * Test of darDependencias method, of class ContratacionMonitores.
     */
    @Test
    public void testDarDependencias() {
    }

    /**
     * Test of cambiarDependencias method, of class ContratacionMonitores.
     */
    @Test
    public void testCambiarDependencias() {
    }

    /**
     * Test of darResultados method, of class ContratacionMonitores.
     */
    @Test
    public void testDarResultados() {
    }

    /**
     * Test of cambiarResultados method, of class ContratacionMonitores.
     */
    @Test
    public void testCambiarResultados() {
    }

    /**
     * Test of darAspirantes method, of class ContratacionMonitores.
     */
    @Test
    public void testDarAspirantes() {
    }

    /**
     * Test of cambiarAspirantes method, of class ContratacionMonitores.
     */
    @Test
    public void testCambiarAspirantes() {
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
        
        cm.registrarAspirante(primerNombre, segundoNombre, primerApellido, segundoApellido, codigo, estadoMatricula, foto, promedioAcumulado, semestreActual, identificacion);
        assertTrue(cm.darAspirantes().size()==1);
        cm.registrarAspirante(primerNombre, segundoNombre, primerApellido, segundoApellido, codigo, estadoMatricula, foto, promedioAcumulado, semestreActual, identificacion);
        assertTrue(cm.darAspirantes().size()==1);
       
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
    }

    /**
     * Test of buscarAspirante method, of class ContratacionMonitores.
     */
    @Test
    public void testBuscarAspirante() {
        System.out.println("buscarAspirante");
        String identificacion = "123";
        Aspirante expResult = null;
        Aspirante result = cm.buscarAspirante(identificacion);
        assertEquals(expResult, result);
        assertTrue(expResult == result);
    }

    /**
     * Test of buscarMonitor method, of class ContratacionMonitores.
     */
    @Test
    public void testBuscarMonitor() {
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
        cm.agregarDependencia(nId, nNombre, nDescripcion, nHorario);
        assertTrue(cm.darDependencias().size()== 1);
        assertFalse(cm.darDependencias().size()!= 1);
    }

    /**
     * Test of buscarDependencia method, of class ContratacionMonitores.
     */
    @Test
    public void testBuscarDependencia() {
        System.out.println("buscarDependencia");
        String nId = "";
        Dependencia expResult = null;
        Dependencia result = cm.buscarDependencia(nId);
        assertEquals(expResult, result);
    }

}
