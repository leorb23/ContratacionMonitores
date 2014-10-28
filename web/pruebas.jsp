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

<%  Aspirante aspirante =(Aspirante) session.getAttribute("aspirante");
    Monitor monitor=monitor =(Monitor) session.getAttribute("monitor");
    Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");
    Administrador admin = (Administrador)session.getAttribute("admin");
    String mensaje = (String)session.getAttribute("mensaje");
%>

<!DOCTYPE html5>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css" media="all">
        <title>Contratacion Monitores</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
<!--        <header>
            <div id="cabecera">
                <div>
                    <a href="index.jsp"><img src="img/logo.png"></a>
                </div>
                <div>
                    <h1>Contratacion de Monitores</h1>
                </div>
            </div>
            <div id="barraNavegacion">
                <nav id="barraNavPrincipal">
                    <ul>
                        <li><a href="index.jsp" >Inicio</a></li>
                        <li><a href="pruebas.jsp" style="background:#56a2ff; height: 32px;">Pruebas</a></li> 
                        <%if(admin==null){%>
                        <li><a href="dependenciaView.jsp">Dependencias</a></li>
                        <li><a href="estudiante.jsp">Estudiantes</a></li>
                        <%}%>
                        <li><a href="GestionAdmin/admin.jsp"><%if(admin==null) {%>Entrar<%} else{%>Admin<%}%></a></li>  
                    </ul>
                </nav>
            </div>     
        </header> -->
        <section>
            <div id="contenedor">
                Pruebas
            </div>     
        </section>
        <footer>
            <a href="#">CocoSoft</a>
        </footer>
    </body>
</html>
