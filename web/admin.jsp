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

<%  //Aspirante aspirante =(Aspirante) session.getAttribute("aspirante");
    //Monitor monitor=monitor =(Monitor) session.getAttribute("monitor");
    //Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");
    session.setAttribute("ubicacionPage", "admin.jsp");
    Administrador admin = (Administrador)session.getAttribute("admin");
    String mensaje = (String)session.getAttribute("mensaje");
    Estudiante eliminar = (Estudiante)session.getAttribute("eliminar");
%>
<!DOCTYPE html5>
<html>
    <head>
        <jsp:include page="head.jsp" />
        <title>Administrador</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
<!--        <header>
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
                        <li><a href="../index.jsp" >Inicio</a></li>
                        <li><a href="../pruebas.jsp">Pruebas</a></li> 
                        <%if(admin==null) {%>
                        <li><a href="../dependenciaView.jsp">Dependencias</a></li>
                        <li><a href="../estudiante.jsp">Estudiantes</a></li>
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
        </header>      -->
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
                                <form action="GestionAdministrador" method="POST">
                                    <label>Usuario</label>
                                    <input type="text" id="txt_usuario" name="txt_usuario" required>
                                    <label>Contraseña</label>
                                    <input type="password" id="txt_contrasena" name="txt_contrasena" required>
                                    <input type="submit" id="btn_enviar" value="Entrar">
                                    <input type="hidden" id="accion" name="accion" value="entrar">                       
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>  
            <%}else if(admin!=null) {%>           
            <label>Administrador : <%=admin.darNombre() %></label><br>  
            <form action="GestionAdministrador" method="POST">
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
                                <input type="hidden" id="accion" name="accion" value="buscarPorAdmin">
                            </form>
                        </td>
                    </tr>
                </table>
                <%
                Aspirante aspiBusc=(Aspirante)session.getAttribute("aspiranteBuscado");
                Monitor monitorBusc=(Monitor) session.getAttribute("monitorBuscado");
                Estudiante estudianteBusc = (Estudiante)session.getAttribute("estudianteBuscado");
                if(aspiBusc!=null || monitorBusc!=null || estudianteBusc!=null){%>
                     <%if(aspiBusc!=null){%>
                            <div id="div_datos">
                     <table class="table_datos_est" id="table_datos_est">
                         <th colspan="2" style="text-align: center;" cellpadding="0" cellspacing="0">Datos del Aspirante</th>
                         <tr style="background: #8bbbfd;">
                             <td>Nombres</td>
                             <td><%=aspiBusc.darPrimerNombre() %> <%=aspiBusc.darSegundoNombre()%></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Apellidos</td>
                             <td><%=aspiBusc.darPrimerApellido() %> <%=aspiBusc.darSegundoApellido() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Identicacion</td>
                             <td><%=aspiBusc.darIdentificacion() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Semestre</td>
                             <td><%=aspiBusc.darSemestreActual() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Estado Matricula</td>
                             <td><%=aspiBusc.darEstadoMatricula() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Promedio Acumulado</td>
                             <td><%=aspiBusc.darPromedioAcumulado() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Postulaciones</td>
                             <td>
                                 <%if(aspiBusc.darPostulaciones().size()>0){%>
                                 <div>
                                     <ul style="list-style: none;">
                                 <%for(Postulacion post: aspiBusc.darPostulaciones()){%>       
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
                    <%}else if(monitorBusc!=null){%>
                        <div id="div_datos">
                     <table class="table_datos_est" id="table_datos_est">
                         <th colspan="2" style="text-align: center;" cellpadding="0" cellspacing="0">Datos del Monitor</th>
                         <tr style="background: #8bbbfd;">
                             <td>Nombres</td>
                             <td><%=monitorBusc.darPrimerNombre() %> <%=monitorBusc.darSegundoNombre()%></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Apellidos</td>
                             <td><%=monitorBusc.darPrimerApellido() %> <%=monitorBusc.darSegundoApellido() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Identicacion</td>
                             <td><%=monitorBusc.darIdentificacion() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Semestre</td>
                             <td><%=monitorBusc.darSemestreActual() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Estado Matricula</td>
                             <td><%=monitorBusc.darEstadoMatricula() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Promedio Acumulado</td>
                             <td><%=monitorBusc.darPromedioAcumulado() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Monitoria en</td>
                             <td><%=monitorBusc.darDependencia().darNombre() %></td>
                         </tr>
                     </table>                 
                    </div>
                    <%}else if(estudianteBusc!=null){%>
                        <div id="div_datos">
                     <table class="table_datos_est" id="table_datos_est">
                         <th colspan="2" style="text-align: center;" cellpadding="0" cellspacing="0">Datos del Estudiante</th>
                         <tr style="background: #8bbbfd;">
                             <td>Nombres</td>
                             <td><%=estudianteBusc.darPrimerNombre() %> <%=estudianteBusc.darSegundoNombre()%></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Apellidos</td>
                             <td><%=estudianteBusc.darPrimerApellido() %> <%=estudianteBusc.darSegundoApellido() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Identicacion</td>
                             <td><%=estudianteBusc.darIdentificacion() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Semestre</td>
                             <td><%=estudianteBusc.darSemestreActual() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td>Estado Matricula</td>
                             <td><%=estudianteBusc.darEstadoMatricula() %></td>
                         </tr>
                         <tr style="background: #bfdef8;">
                             <td>Promedio Acumulado</td>
                             <td><%=estudianteBusc.darPromedioAcumulado() %></td>
                         </tr>
                         <tr style="background: #8bbbfd;">
                             <td></td>
                             <td><%if(estudianteBusc.darSemestreActual()>= 3){
                            if(estudianteBusc.darPromedioAcumulado()>=3.5){%>
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
                        <%}%>  </td>
                         </tr>
                     </table>                 
                    </div> 
                    <%}%>
                     </table>
                <%}%>
            </div><br>      
            <%}%> 
        </div>
        </section>  
        <footer>
            <a href="#">CocoSoft</a>
        </footer>
    </body>
</html>

