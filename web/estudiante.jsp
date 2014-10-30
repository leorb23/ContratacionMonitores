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

<%  
    session.setAttribute("ubicacionPage", "estudiante.jsp");
    
    Aspirante aspirante =(Aspirante) session.getAttribute("aspirante");
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
                        <li><a href="pruebas.jsp">Pruebas</a></li> 
                        <li><a href="dependenciaView.jsp">Dependencias</a></li>
                        <li><a href="estudiante.jsp" style="background:#56a2ff;height: 32px;">Estudiantes</a></li>
                        <%if(estudiante==null && monitor==null && aspirante==null) {%>
                        <li><a href="GestionAdmin/admin.jsp">Entrar</a></li>
                        <%}%>
                    </ul>
                </nav>
            </div>     
        </header>-->
        <section>
            <div id="contenedor">  
                <%if(mensaje!=null){%>
                <div id="div_mensaje">
                    <label><%=mensaje%></label>
                </div>
                    <%session.removeAttribute("mensaje");
                }%>
                 <%if(aspirante!= null){%>
                 <div id="div_datos">
                     <table class="table_datos_est" id="table_datos_est">
                         <th colspan="2" style="text-align: center;" cellpadding="0" cellspacing="0">Datos del Aspirante</th>
                         <tr style="background: #8bbbfd;">
                             <td>Nombres</td>
                             <td><%=aspirante.darPrimerNombre() %> <%=aspirante.darSegundoNombre()%></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Apellidos</td>
                             <td><%=aspirante.darPrimerApellido() %> <%=aspirante.darSegundoApellido() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Identicacion</td>
                             <td><%=aspirante.darIdentificacion() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Semestre</td>
                             <td><%=aspirante.darSemestreActual() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Estado Matricula</td>
                             <td><%=aspirante.darEstadoMatricula() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Promedio Acumulado</td>
                             <td><%=aspirante.darPromedioAcumulado() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Postulaciones</td>
                             <td>
                                 <%if(aspirante.darPostulaciones().size()>0){%>
                                 <div>
                                     <ul style="list-style: none;">
                                 <%for(Postulacion post: aspirante.darPostulaciones()){%>       
                                     <li>► <%=post.darIdDependencia() %></li>  
                                 <% }%>
                                     </ul>  
                                 </div>    
                                <%}else{%>
                                 N/A
                                <%}%>
                             </td>
                         </tr>
                     </table>                 
                 </div>   
                 <div id="div_opciones">
                     <%if(aspirante.darPostulaciones().size()>0){%>
                     <div>Postulaciones</div>
                     <div>
                         <div>
                             <ul style="list-style: none;">
                         <%for(Postulacion post: aspirante.darPostulaciones()){%>       
                             <li>► <%=post.darIdDependencia() %></li>  
                         <% }%>
                             </ul>  
                         </div>    
                        <%}else{%>
                         N/A
                        <%}%>
                    </div>
                 </div>    
                    <%}
                    else if(monitor!= null){%>
                    <div id="div_datos">
                     <table class="table_datos_est" id="table_datos_est">
                         <th colspan="2" style="text-align: center;" cellpadding="0" cellspacing="0">Datos del Monitor</th>
                         <tr style="background: #8bbbfd;">
                             <td>Nombres</td>
                             <td><%=monitor.darPrimerNombre() %> <%=monitor.darSegundoNombre()%></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Apellidos</td>
                             <td><%=monitor.darPrimerApellido() %> <%=monitor.darSegundoApellido() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Identicacion</td>
                             <td><%=monitor.darIdentificacion() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Semestre</td>
                             <td><%=monitor.darSemestreActual() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Estado Matricula</td>
                             <td><%=monitor.darEstadoMatricula() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Promedio Acumulado</td>
                             <td><%=monitor.darPromedioAcumulado() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Monitoria en</td>
                             <td><%=monitor.darDependencia().darNombre() %></td>
                         </tr>
                     </table>                 
                    </div>
                         
                    <%}
                    else if(estudiante!= null){%>  
                    <div id="div_datos">
                     <table class="table_datos_est" id="table_datos_est">
                         <th colspan="2" style="text-align: center;" cellpadding="0" cellspacing="0">Datos del Estudiante</th>
                         <tr style="background: #8bbbfd;">
                             <td>Nombres</td>
                             <td><%=estudiante.darPrimerNombre() %> <%=estudiante.darSegundoNombre()%></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Apellidos</td>
                             <td><%=estudiante.darPrimerApellido() %> <%=estudiante.darSegundoApellido() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Identicacion</td>
                             <td><%=estudiante.darIdentificacion() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Semestre</td>
                             <td><%=estudiante.darSemestreActual() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Estado Matricula</td>
                             <td><%=estudiante.darEstadoMatricula() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Promedio Acumulado</td>
                             <td><%=estudiante.darPromedioAcumulado() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td></td>
                             <td><%if(estudiante.darSemestreActual()>= 3){
                            if(estudiante.darPromedioAcumulado()>=3.5){%>
                            <label>Desea registrarse en el Sistema de Contratacion de Monitores ?</label>  
                                <form action="GestionSesionDeEstudiantes" method="POST">
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
                        <%}%>  </td>
                         </tr>
                     </table>                 
                    </div>             
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
                                <form action="GestionSesionDeEstudiantes" method="POST">
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
                <form action="GestionSesionDeEstudiantes" method="POST">
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

