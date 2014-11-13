<%--
    Document   : monitor
    Created on : 29/09/2014, 09:07:12 AM
    Author     : CocoSoft
--%>
<%@page import="com.umariana.contratacionmonitores.controladores.ContratacionMonitoresServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.contratacionmonitores.logica.Monitor"%>
<%@page import="com.umariana.contratacionmonitores.logica.Administrador"%>
<%@page import="com.umariana.contratacionmonitores.logica.Estudiante"%>
<%@page import="com.umariana.contratacionmonitores.logica.Aspirante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    session.setAttribute("ubicacionPage", "monitor.jsp");
    
    Aspirante aspirante =(Aspirante) session.getAttribute("aspirante");
    //Monitor monitor=monitor =(Monitor) session.getAttribute("monitor");
    //Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");
    Administrador admin = (Administrador)session.getAttribute("admin");
    String mensaje = (String)session.getAttribute("mensaje");
    Estudiante eliminar = (Estudiante)session.getAttribute("eliminar");
    Monitor eliminarMonitor = (Monitor)session.getAttribute("eliminarMonitor");
    session.removeAttribute("eliminarDependencia");     
    session.removeAttribute("eliminarAspirante");
    session.removeAttribute("eliminarString");
%>
<!DOCTYPE html5>
<html>
    <head>
        <jsp:include page="head.jsp" />
        <title>Monitores</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <section>
            <div id="contenedor">      
            </div>
        </section>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
