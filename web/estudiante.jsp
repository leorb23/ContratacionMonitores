<%-- 
    Document   : estudiante
    Created on : 25/09/2014, 10:21:17 AM
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
    Monitor monitor = monitor =(Monitor) session.getAttribute("monitor");
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
                        <li><a href="dependenciaView.jsp">Dependencias</a></li>
                        <li><a href="estudiante.jsp" style="background:#56a2ff;height: 32px;">Estudiantes</a></li>
                        <li><a href="admin.jsp">Entrar</a></li>
                    </ul>
                </nav>
            </div>     
        </header>
        <section>
            <div id="contenedor">  
                <%if(mensaje!=null){%>
                <div id="div_mensaje">
                    <label><%=mensaje%></label>
                </div>
                    <%session.removeAttribute("mensaje");
                }%>
                 <%if(aspirante!= null){%>
                        <label>Aspirante : <%=aspirante.darPrimerNombre() %></label><br>
                        <label>Identificado : <%=aspirante.darIdentificacion() %></label><br>
                        <label>Semestre : <%=aspirante.darSemestreActual() %></label>  <br>
                        <label>Estado Matricula : <%=aspirante.darEstadoMatricula() %></label>  <br>
                        <label>Promedio Acumulado : <%=aspirante.darPromedioAcumulado() %></label>  <br>
                        <label>Postulaciones : 
                            <%if(aspirante.darPostulaciones().size()>0){%>
                                <select>
                                    <%for(Postulacion post: aspirante.darPostulaciones()){%>
                                        <option value="<%=post.darIdDependencia() %>"><%=post.darIdDependencia() %></option>
                                    <% }%>
                                </select>        
                          <%}else{%>
                                N/A
                            <%}%>
                        </label>    
                    <%}
                    else if(monitor!= null){%>
                        <label>Monitor :<%=monitor.darPrimerNombre() %> <%=monitor.darPrimerApellido() %></label><br>
                        <label>Identificado : <%=monitor.darIdentificacion() %></label><br>
                        <label>Semestre : <%=monitor.darSemestreActual() %></label>  <br>
                        <label>Estado Matricula : <%=monitor.darEstadoMatricula() %></label>  <br>
                        <label>Promedio Acumulado : <%=monitor.darPromedioAcumulado() %></label>  <br>
                        <label>Dependencia: <%=monitor.darDependencia().darNombre() %></label>  <br>  
                    <%}
                    else if(estudiante!= null){%>  
                        <label>Estudiante :<%=estudiante.darPrimerNombre() %> <%=estudiante.darPrimerApellido() %></label><br>
                        <label>Identificado : <%=estudiante.darIdentificacion() %></label><br>
                        <label>Semestre : <%=estudiante.darSemestreActual() %></label>  <br>
                        <label>Estado Matricula : <%=estudiante.darEstadoMatricula() %></label>  <br>
                        <label>Promedio Acumulado : <%=estudiante.darPromedioAcumulado() %></label>  <br>
                        <%if(estudiante.darSemestreActual()>= 3){
                            if(estudiante.darPromedioAcumulado()>=3.5){%>
                            <label>Desea registrarse en el Sistema de Contratacion de Monitores ?</label>  
                                <form action="ContratacionMonitoresServlet" method="POST">
                                    <select id="select_registrar" name="select_registrar">
                                        <option value="si">Si</option>
                                        <option value="no">No</option>
                                    </select>
                                    <input type="hidden" id="accion" name="accion" value="reg_estu">
                                    <input type="submit"  value="Registrar">
                                </form>
                            <%}else{%>
                            <h4>No puedes postularte como aspirante porque tiene un promedio de notas menor a 3.5</h4>
                        <%}}else{%>
                            <h4>Para registrarte como aspirante debes estar en tercer semestre o superior</h4>
                        <%}%>    
                    <%}
                    else if(admin!=null) {
                        response.sendRedirect("admin.jsp");
                    } %>        
                <%if(aspirante==null && monitor==null && estudiante==null){%>
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
               <%}else { %>
                <form action="ContratacionMonitoresServlet" method="POST">
                    <input type="submit"  value="Cerrar Sesion">
                    <input type="hidden" id="accion" name="accion" value="cerrar">
                </form>
               <%}%>
            </div>
        </section>
        <footer>
            <a href="#">CocoSoft</a>
        </footer>
    </body>
</html>

