<%-- 
    Document   : pruebas
    Created on : 28/09/2014, 10:51:06 PM
    Author     : Andres
--%>

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
    session.setAttribute("ubicacionPage", "pruebas.jsp");

%>

<!DOCTYPE html5>
<html>
    <head>
        <jsp:include page="head.jsp" />
        <title>Pruebas</title>
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
