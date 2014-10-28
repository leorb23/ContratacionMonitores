/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.umariana.contratacionmonitores.controladores;

import static com.umariana.contratacionmonitores.controladores.ContratacionMonitoresServlet.instance;
import com.umariana.contratacionmonitores.excepciones.ExcepcionYaExiste;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andres
 */
@WebServlet(name = "GestionDependencias", urlPatterns = {"/GestionDependencias"})
public class GestionDependencias extends HttpServlet {

   private static HttpSession sesion;
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
        sesion=ContratacionMonitoresServlet.darSession();
        sesion= request.getSession(true);
        String accion = request.getParameter("accion");
        try {
        switch (accion){
            case"regDep":
                String nom = request.getParameter("txt_nombre");
                String des = request.getParameter("txt_descripcion");
                instance.agregarDependencia(0, nom, des, nom, 0);
                break;
        } 
                
        }
        catch (ExcepcionYaExiste ex) {
            Logger.getLogger(GestionDependencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        ContratacionMonitoresServlet.setearSesion(sesion);
        response.sendRedirect("estudiante.jsp");
    }
}
