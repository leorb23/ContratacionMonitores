package com.umariana.contratacionmonitores.controladores;

import com.umariana.contratacionmonitores.excepciones.ExcepcionNoExiste;
import com.umariana.contratacionmonitores.logica.Administrador;
import java.io.IOException;
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
@WebServlet(name = "GestionAdministrador", urlPatterns = {"/GestionAdministrador"})
public class GestionAdministrador extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        HttpSession sesion=ContratacionMonitoresServlet.darSession();
        sesion= request.getSession(true);
        String accion = request.getParameter("accion");
        try 
        {
            switch(accion){
                case "entrar":
                    sesion.removeAttribute("mensaje");   
                    String usuario = request.getParameter("txt_usuario");
                    String password = request.getParameter("txt_contrasena");
                    sesion.setAttribute("admin",ContratacionMonitoresServlet.darComunicacionLogica().ingresoAdmin(usuario,password)); 
                    Administrador admin =(Administrador)sesion.getAttribute("admin");
                    break;                   
                case "cerrar":
                    sesion.removeAttribute("admin");   
                    break; 
                case "actualizar":
                    break;
            }
        } 
        catch (ExcepcionNoExiste ex) 
        {
            sesion.setAttribute("mensaje", ex.getMessage());
        }
        ContratacionMonitoresServlet.setearSesion(sesion);
        response.sendRedirect("GestionAdmin/admin.jsp");
        
    }
}
