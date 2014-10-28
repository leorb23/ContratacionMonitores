<%-- 
    Document   : header
    Created on : 25/10/2014, 07:47:05 PM
    Author     : Andres
--%>
<%@page import="com.umariana.contratacionmonitores.logica.Administrador"%>
<%@page import="com.umariana.contratacionmonitores.logica.Estudiante"%>
<%@page import="com.umariana.contratacionmonitores.logica.Monitor"%>
<%@page import="com.umariana.contratacionmonitores.logica.Aspirante"%>
<%  Aspirante aspirante =(Aspirante) session.getAttribute("aspirante");
    Monitor monitor=monitor =(Monitor) session.getAttribute("monitor");
    Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");
    Administrador admin = (Administrador)session.getAttribute("admin");
    String mensaje = (String)session.getAttribute("mensaje");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/estilos.css" type="text/css" media="all">
<header>
    <div id="cabecera">
        <div>
            <a href="../index.jsp"><img src="../img/logo.png"></a>
        </div>
        <div>
            <h1>Contratacion de Monitores</h1>
        </div>
    </div>
    <div id="barraNavegacion">
        <nav id="barraNavPrincipal">
            <ul>
                <li><a href="../index.jsp" style="background:#56a2ff; height: 32px;">Inicio</a></li>
                <li><a href="../pruebas.jsp">Pruebas</a></li> 
                <%if(admin==null){%>
                <li><a href="../dependenciaView.jsp">Dependencias</a></li>
                <li><a href="../estudiante.jsp">Estudiantes</a></li>
                <%}%>
                <li><a href="../GestionAdmin/admin.jsp"><%if(admin==null) {%>Entrar<%} else{%>Admin<%}%></a></li>  
            </ul>
        </nav>
    </div>   
     <%if(admin!=null){ %>             
    <div id="barraSecundaria">
        <nav id="barraNavSecundaria">
            <ul>
                <li><a href="../GestionAdmin/dependencia.jsp">Dependencias</a></li>
                <li><a href="../GestionAdmin/aspirante.jsp">Aspirantes</a></li> 
                <li><a href="../GestionAdmin/monitor.jsp" >Monitores</a></li>                       
            </ul>
        </nav>
   </div>      
     <%}%>     
</header>   
