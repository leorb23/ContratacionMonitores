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
<%  Aspirante aspirante =(Aspirante) session.getAttribute("aspirante");
    //Monitor monitor=monitor =(Monitor) session.getAttribute("monitor");
    //Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");
    Administrador admin = (Administrador)session.getAttribute("admin");
    String mensaje = (String)session.getAttribute("mensaje");
    Estudiante eliminar = (Estudiante)session.getAttribute("eliminar");
%>
<!DOCTYPE html5>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css" media="all">
        <title>Contratacion Monitores</title>
    </head>
    <body>
        <header>
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
                        <li><a href="#">Pruebas</a></li> 
                        <li><a href="admin.jsp" style="background:#56a2ff;height: 32px;"><%if(admin==null) {%>Entrar<%} else{%>Admin<%}%></a></li>  
                    </ul>
                </nav>
            </div>
            <div id="barraSecundaria">
                <nav id="barraNavSecundaria">
                    <ul>
                        <li><a href="dependencia.jsp" >Dependencias</a></li>
                        <li><a href="aspirante.jsp">Aspirantes</a></li> 
                        <li><a href="monitor.jsp" style="background:#56a2ff;height: 32px;">Monitores</a></li>                       
                    </ul>
                </nav>
            </div>          
        </header>
        <%if(admin!=null) {%> 
         <section>
             <div id="contenedor">
                 <%if(mensaje!=null){%>
                     <h4 style="color: black;"><%=mensaje%></h4>
                <%}%>
                <%if(eliminar!= null ){%>
                <div id="div_eliminar">
                    <form action="ContratacionMonitoresServlet" method="POST">
                        <h2>Seguro que desea eliminar el registro del estudiante:</h2>
                        <p>Nombre: <%=eliminar.darPrimerNombre() %> <%=eliminar.darPrimerApellido() %></p>
                        <p>Identificado: <%=eliminar.darIdentificacion() %></p>
                        <select id="select_eliminar" name="select_eliminar">
                        <option value="si">Si</option>
                        <option value="no">No</option>
                        </select>
                        <input type="submit" id="btn_enviar" value="Aceptar">
                        <input type="hidden" id="accion" name="accion" value="confirmarEliminar">
                    </form>
                </div>
                <%}%>
                <table align="center" border="1">
                <th  colspan="10"><h3>Lista de Monitores</h3></th>  
                <tr style="background: black; color: white;">     
                    <td>Identificación</td>
                    <td>Codigo</td>
                    <td>Nombres</td>
                    <td>Apellidos</td>
                    <td>Semestre</td>
                    <td>E.M</td>
                    <td>Promedio Acum.</td>
                    <td>Dependencia</td>
                </tr>
                <%
                ArrayList<Monitor> monitores = ContratacionMonitoresServlet.cm.darMonitores();
                for(Monitor mon: monitores){%>
                   <tr>
                    <td><%=mon.darIdentificacion() %></td>
                    <td><%=mon.darCodigo() %></td>
                    <td><%=mon.darPrimerNombre() %> <%=mon.darSegundoNombre() %> </td>
                    <td><%=mon.darPrimerApellido() %> <%=mon.darSegundoApellido() %></td>                 
                    <td><%=mon.darSemestreActual() %></td>
                    <td><%=mon.darEstadoMatricula() %></td>
                    <td><%=mon.darPromedioAcumulado() %></td>
                    <td><%=mon.darDependencia().darNombre() %></td>
                    <form action="ContratacionMonitoresServlet" method="post">
                        <td><input type="submit" value="Eliminar"></td>
                        <input type="hidden" id="identificacion" name="identificacion" value="<%=mon.darIdentificacion() %>">
                        <input type="hidden" id="accion" name="accion" value="eliminarM">
                    </form>
                    <td><a href="#">Modificar</a></td>
                </tr>
               <%}%>
                </table>
             </div>  
         </section>
         <%} else{ response.sendRedirect("admin.jsp"); }%>
    </body>
</html>
