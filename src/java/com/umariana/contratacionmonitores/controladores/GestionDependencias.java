/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.umariana.contratacionmonitores.controladores;

import static com.umariana.contratacionmonitores.controladores.ContratacionMonitoresServlet.instance;
import com.umariana.contratacionmonitores.excepciones.ConnectionException;
import com.umariana.contratacionmonitores.excepciones.ExcepcionYaExiste;
import com.umariana.contratacionmonitores.logica.Dependencia;
import java.io.IOException;
import java.sql.SQLException;
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
        switch (accion){
            case"regDep":
                String nom = request.getParameter("txt_nombre");
                String des = request.getParameter("txt_descripcion");
                //instance.agregarDependencia(0, nom,des);
                Dependencia dependencia = new Dependencia();
                dependencia.cambiarId(1);
                dependencia.cambiarNombre(nom);
                dependencia.cambiarDescripcion(des);
                if("existe".equalsIgnoreCase(nom)){
                    sesion.setAttribute("depExiste", dependencia);
                    sesion.setAttribute("mensaje", "La dependencia ya existe.");
                    sesion.removeAttribute("continuarRegDep");

                }
                else
                    sesion.setAttribute("continuarRegDep", dependencia);
                response.sendRedirect("dependencia.jsp");
                break;
        }
        ContratacionMonitoresServlet.setearSesion(sesion);
        //response.sendRedirect("dependencia.jsp");
    }
}
