<%-- 
    Document   : admin
    Created on : 24/09/2014, 11:21:07 AM
    Author     : CocoSoft
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
                        <li><a href="pruebas.jsp">Pruebas</a></li> 
                        <%if(admin==null) {%>
                        <li><a href="dependenciaView.jsp">Dependencias</a></li>
                        <li><a href="estudiante.jsp">Estudiantes</a></li>
                        <%}%>
                        <li><a href="admin.jsp" style="background:#56a2ff;height: 32px;"><%if(admin==null) {%>Entrar<%} else{%>Admin<%}%></a></li>  
                    </ul>
                </nav>
            </div>
            <%if(admin!=null) {%>
            <div id="barraSecundaria">
                <nav id="barraNavSecundaria">
                    <ul>
                        <li><a href="dependencia.jsp" >Dependencias</a></li>
                        <li><a href="aspirante.jsp">Aspirantes</a></li> 
                        <li><a href="monitor.jsp">Monitores</a></li>                       
                    </ul>
                </nav>
            </div>   
            <%}%>
        </header>      
        <section>
            <div id="contenedor">
            <%if(mensaje!=null){%>
                <div id="div_mensaje">
                    <label><%=mensaje%></label>
                </div>
                <%}%>    
            <%if(admin==null) {%>
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
            <%}else if(admin!=null) {%>           
            <label>Administrador : <%=admin.darNombre() %></label><br>  
            <form action="ContratacionMonitoresServlet" method="POST">
                <input type="submit"  value="Cerrar Sesion">
                <input type="hidden" id="accion" name="accion" value="cerrar">
            </form><br>   
            <div>      
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
                    <tr>
                        <td>
                            <label>Buscar Estudiantes</label>
                            <form action="ContratacionMonitoresServlet" method="POST">
                                <label>Identificacion</label>
                                <input type="text" id="txt_identificacion" name="txt_identificacion">
                                <input type="submit" id="btn_enviar" value="Enviar">
                                <input type="hidden" id="accion" name="accion" value="buscar">
                            </form>
                        </td>
                    </tr>
                </table>
            </div><br>      
            <%}%> 
        </div>
        </section>  
        <footer>
            <a href="#">CocoSoft</a>
        </footer>
    </body>
</html>

