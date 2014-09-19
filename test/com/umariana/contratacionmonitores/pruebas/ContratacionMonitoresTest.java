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
     * Test of registrarAspirante method, of class ContratacionMonitores.
     */
    @Test
    public void testRegistrarAspirante() throws Exception  {
        System.out.println("registrarAspirante");     
        
        cm.registrarAspirante("primerNombre","segundoNombre", "primerApellido","segundoApellido", 1, "estadoMatricula", null,1.0,1,"101");
        assertTrue(cm.darAspirantes().size()==1);
        cm.registrarAspirante("primerNombre2","segundoNombre2", "primerApellido2","segundoApellido2", 2, "estadoMatricula2", null,2.0,2,"102");
        assertTrue(cm.darAspirantes().size()==2);
        cm.registrarAspirante("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"103");
        assertTrue(cm.darAspirantes().size()==3);
        cm.registrarAspirante("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"104");
        assertTrue(cm.darAspirantes().size()==4);
        cm.registrarAspirante("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"104");     
        assertTrue(cm.darAspirantes().size()==4);
        
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
        cm.eliminarMonitor(identificacion);
    }
    
     /**
     * Test of registrarMonitor method, of class ContratacionMonitores.
     */
    @Test
    public void testRegistrarMonitor() throws Exception  {
        System.out.println("registrarMonitor");     
        
        cm.registrarMonitor("primerNombre","segundoNombre", "primerApellido","segundoApellido", 1, "estadoMatricula", null,1.0,1,"101");
        assertTrue(cm.darMonitores().size()==1);
        cm.registrarMonitor("primerNombre2","segundoNombre2", "primerApellido2","segundoApellido2", 2, "estadoMatricula2", null,2.0,2,"102");
        assertTrue(cm.darMonitores().size()==2);
        cm.registrarMonitor("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"103");
        assertTrue(cm.darMonitores().size()==3);
        cm.registrarMonitor("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"104");
        assertTrue(cm.darMonitores().size()==4);
        cm.registrarMonitor("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"104");     
        assertTrue(cm.darMonitores().size()==4);
        
    }

    /**
     * Test of modificarAspirante method, of class ContratacionMonitores.
     */
    @Test
    public void testModificarMonitor() throws Exception {
        
        System.out.println("modificarMonitor");
        String primerNombre = "";
        String segundoNombre = "";
        String primerApellido = "";
        String segundoApellido = "";
        String identificacion = "";
        File foto = null;
        int semestre = 0;
        double promedioAcum = 0.0;      
        cm.modificarAspirante(primerNombre, segundoNombre, primerApellido, segundoApellido, identificacion, foto, semestre, promedioAcum);

        
    }

    /**
     * Test of buscarAspirante method, of class ContratacionMonitores.
     */
    @Test
    public void testBuscarAspirante() throws Exception {
        System.out.println("buscarAspirante");

        cm.registrarAspirante("primerNombre","segundoNombre", "primerApellido","segundoApellido", 1, "estadoMatricula", null,1.0,1,"101");
        cm.registrarAspirante("primerNombre2","segundoNombre2", "primerApellido2","segundoApellido2", 2, "estadoMatricula2", null,2.0,2,"102");
        cm.registrarAspirante("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"103");
        cm.registrarAspirante("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"104");        
            
        Aspirante result = cm.buscarAspirante("103");
        Aspirante expResult = null;
        
        assertTrue(expResult != result);
        result = cm.buscarAspirante("105");
        assertTrue(expResult == result);
    }

    /**
     * Test of buscarMonitor method, of class ContratacionMonitores.
     */
    @Test
    public void testBuscarMonitor() throws Exception {
        System.out.println("buscarAspirante");

        cm.registrarMonitor("primerNombre","segundoNombre", "primerApellido","segundoApellido", 1, "estadoMatricula", null,1.0,1,"101");
        cm.registrarMonitor("primerNombre2","segundoNombre2", "primerApellido2","segundoApellido2", 2, "estadoMatricula2", null,2.0,2,"102");
        cm.registrarMonitor("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"103");
        cm.registrarMonitor("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"104");        
            
        Monitor result = cm.buscarMonitor("103");
        Monitor expResult = null;
        
        assertTrue(expResult != result);
        result = cm.buscarMonitor("105");
        assertTrue(expResult == result);
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
