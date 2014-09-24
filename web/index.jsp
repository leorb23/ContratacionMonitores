<%-- 
    Document   : index
    Created on : 11/09/2014, 09:20:24 PM
    Author     : Cocosoft
--%>

<%@page import="com.umariana.contratacionmonitores.logica.Estudiante"%>
<%@page import="com.umariana.contratacionmonitores.logica.Monitor"%>
<%@page import="com.umariana.contratacionmonitores.logica.Aspirante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  Aspirante aspirante =(Aspirante) session.getAttribute("aspirante");
    Monitor monitor=monitor =(Monitor) session.getAttribute("monitor");
    Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contratacion Monitores</title>
    </head>
    <body>
        <h1>Contratacion de Monitores</h1>
        <% if(aspirante==null && monitor==null && estudiante==null){%>
            <form action="ContratacionMonitoresServlet" method="POST">
                <label>Identificacion</label>
                <input type="text" id="txt_identificacion" name="txt_identificacion">
                <input type="submit" id="btn_enviar" value="Enviar">
                <input type="hidden" id="accion" name="accion" value="ingreso">
            </form>
        <%}
        if(aspirante!= null){%>
            <label>Aspirante :<%=aspirante.darPrimerNombre() %></label><br>
            <label>Identificado : <%=aspirante.darIdentificacion() %></label><br>
            <label>Datos Personales : <%=aspirante.toString() %></label>  
            <form action="ContratacionMonitoresServlet" method="POST">
                <input type="submit"  value="Cerrar Sesion">
                <input type="hidden" id="accion" name="accion" value="cerrar">
            </form>
        <%}
        else if(monitor!= null){%>
            <label>Monitor :<%=monitor.darPrimerNombre() %></label><br>
            <label>Identificado : <%=monitor.darIdentificacion() %></label><br>
            <label>Datos Personales : <%=monitor.toString() %></label>  
            <form action="ContratacionMonitoresServlet" method="POST">
                <input type="submit"  value="Cerrar Sesion">
                <input type="hidden" id="accion" name="accion" value="cerrar">
            </form>
        <%}
        else if(estudiante!= null){%>
            <label>Estudiante :<%=estudiante.darPrimerNombre() %></label><br>
            <label>Identificado : <%=estudiante.darIdentificacion() %></label><br>
            <label>Datos Personales : <%=estudiante.toString() %></label>  <br>
            <label>Desea registrarse en el Sistema de Contratacion de Monitores ?</label>  
            <form action="ContratacionMonitoresServlet" method="POST">
                <select id="select_registrar">
                    <option>si</option>
                    <option>no</option>
                </select>
                <input type="hidden" id="accion" name="accion" value="reg_estu">
                <input type="submit"  value="Registrar">
            </form>
        <%}%>
           
    </body>
</html>
