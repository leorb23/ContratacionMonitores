<%--
    Document   : index
    Created on : 11/09/2014, 09:20:24 PM
    Author     : Cocosoft
--%>
<%
Object instance=ContratacionMonitoresServlet.darComunicacionLogica();
ContratacionMonitoresServlet.conectarBD();

if(instance==null){
    ContratacionMonitoresServlet cm = new ContratacionMonitoresServlet();
}
%>


<%@page import="com.umariana.contratacionmonitores.logica.Dependencia"%>
<%@page import="com.umariana.contratacionmonitores.logica.Postulacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.contratacionmonitores.controladores.ContratacionMonitoresServlet"%>
<%@page import="com.umariana.contratacionmonitores.logica.Administrador"%>
<%@page import="com.umariana.contratacionmonitores.logica.Estudiante"%>
<%@page import="com.umariana.contratacionmonitores.logica.Monitor"%>
<%@page import="com.umariana.contratacionmonitores.logica.Aspirante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  
    session.setAttribute("ubicacionPage", "index.jsp");
    Aspirante aspirante =(Aspirante) session.getAttribute("aspirante");
    Monitor monitor=monitor =(Monitor) session.getAttribute("monitor");
    Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");
    Administrador admin = (Administrador)session.getAttribute("admin");
    String mensaje = (String)session.getAttribute("mensaje");
%>

<!DOCTYPE html5>
<html>
    <head>
        <jsp:include page="head.jsp" />
        <title>Contratacion Monitores</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <% if(aspirante==null && monitor==null && estudiante==null && admin==null){%>
        <section>
            <div id="contenedor">
                <%if(mensaje!=null){%>
                     <h4 style="color: black;"><%=mensaje%></h4>
                    <%session.removeAttribute("mensaje");
                }%>
                <div>
                    <table border="1">
                        <tr>
                            <td>
                                <label>Ingreso Para Estudiantes</label>
                                <form action="ContratacionMonitoresServlet" method="POST">
                                    <label>Identificacion</label>
                                    <input type="text" id="txt_identificacion" name="txt_identificacion">
                                    <input type="submit" id="btn_enviar" value="Enviar">
                                    <input type="hidden" id="accion" name="accion" value="ingreso">
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>      
            <br>
            <br>            
                <div>
                    <table border="1">
                        <tr>
                            <td>
                                <label>Ingreso Para Administrador</label>
                                <form action="ContratacionMonitoresServlet" method="POST">
                                    <label>Usuario</label>
                                    <input type="text" id="txt_usuario" name="txt_usuario">
                                    <label>Contraseña</label>
                                    <input type="password" id="txt_contrasena" name="txt_contrasena">
                                    <input type="submit" id="btn_enviar" value="Entrar">
                                    <input type="hidden" id="accion" name="accion" value="admin">                       
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>   
            </div>
        </section>
        <%}%>
        <footer>
            <a href="#">CocoSoft</a>
        </footer>
    </body>
</html>
