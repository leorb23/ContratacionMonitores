/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umariana.contratacionmonitores.controladores;

import com.umariana.contratacionmonitores.excepciones.ExcepcionNoExiste;
import com.umariana.contratacionmonitores.logica.Aspirante;
import com.umariana.contratacionmonitores.logica.ContratacionMonitores;
import com.umariana.contratacionmonitores.logica.Estudiante;
import com.umariana.contratacionmonitores.logica.Monitor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SERVIDOR
 */
public class ContratacionMonitoresServlet extends HttpServlet {

    ContratacionMonitores cm = new ContratacionMonitores();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContratacionMonitoresServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContratacionMonitoresServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    public void ingreso(String identificacion){
        try {
            identificacion="101";
            int n = cm.ingreso(identificacion);
            if(n==1){
                Aspirante aspirante = cm.buscarAspirante(identificacion);
                System.out.println("------------------------------------");
                System.out.println("El ingreso del ASPIRANTE :");
                System.out.println(aspirante.toString());
                System.out.println("------------------------------------");
            } 
            else if(n==2){
                Monitor monitor = cm.buscarMonitor(identificacion);
                System.out.println("------------------------------------");
                System.out.println("El ingreso del MONITOR :");
                System.out.println(monitor.toString());
                System.out.println("------------------------------------");
            }
            else if(n==3){
                Estudiante estudiante = cm.buscarEstudiante(identificacion);
                System.out.println("------------------------------------");
                System.out.println("Preguntar al estudiante si desea registrar la cuenta como ASPIRANTE en el sistema");
                System.out.println(estudiante.toString());
                System.out.println("------------------------------------");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContratacionMonitoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContratacionMonitoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ContratacionMonitoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ContratacionMonitoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExcepcionNoExiste ex) {
            Logger.getLogger(ContratacionMonitoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
