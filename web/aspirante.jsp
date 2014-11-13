<%-- 
    Document   : aspirante
    Created on : 29/09/2014, 09:07:00 AM
    Author     : CocoSoft
--%>

<%@page import="com.umariana.contratacionmonitores.logica.Postulacion"%>
<%@page import="com.umariana.contratacionmonitores.controladores.ContratacionMonitoresServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.contratacionmonitores.logica.Monitor"%>
<%@page import="com.umariana.contratacionmonitores.logica.Administrador"%>
<%@page import="com.umariana.contratacionmonitores.logica.Estudiante"%>
<%@page import="com.umariana.contratacionmonitores.logica.Aspirante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    session.setAttribute("ubicacionPage", "aspirante.jsp");
    
    Aspirante aspirante =(Aspirante) session.getAttribute("aspirante");
    //Monitor monitor=monitor =(Monitor) session.getAttribute("monitor");
    //Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");
    Administrador admin = (Administrador)session.getAttribute("admin");
    String mensaje = (String)session.getAttribute("mensaje");
    Estudiante eliminar = (Estudiante)session.getAttribute("eliminar");
    Aspirante eliminarAspirante=(Aspirante)session.getAttribute("eliminarAspirante");
    session.removeAttribute("eliminarMonitor");     
    session.removeAttribute("eliminarDependencia");
    session.removeAttribute("eliminarString");
%>
<!DOCTYPE html5>
<html>
    <head>
        <jsp:include page="head.jsp" />
        <title>Aspirantes</title>
    </head>
    <body>
        <jsp:include page="header.jsp" /> 
        <jsp:include page="divModal.jsp" /> 
        <%if(admin!=null) {%> 
         <section>
            <div id="contenedor">
                
                <%if(mensaje!=null){%>
                     <h4 style="color: black;"><%=mensaje%></h4>
                    <%session.removeAttribute("mensaje");
                }%>
                <%if(eliminarAspirante!= null ){%>
                <div id="div_eliminar">
                    <form action="ContratacionMonitoresServlet" method="POST">
                        <h2>Seguro que desea eliminar el aspirante:</h2>
                        <p>Nombre: <%=eliminarAspirante.darPrimerNombre() %> <%=eliminarAspirante.darPrimerApellido() %></p>
                        <p>Identificado: <%=eliminarAspirante.darIdentificacion() %></p>
                        <select id="select_eliminar" name="select_eliminar">
                        <option value="si">Si</option>
                        <option value="no">No</option>
                        </select>
                        <input type="submit" id="btn_enviar" value="Aceptar">
                        <input type="hidden" id="accion" name="accion" value="confirmarEliminar">
                    </form>
                </div>
                <%}%>      
               <%ArrayList<Aspirante> aspirantes = ContratacionMonitoresServlet.darComunicacionLogica().darAspirantes(); %>
                <table>
                    <th  colspan="10"><h3>Lista de Aspirantes</h3></th>  
                    <tr id="tr_rows">     
                        <td>Identificación</td>
                        <td>Nombres</td>
                        <td>Apellidos</td>
                        <td>Semestre</td>
                        <td>Promedio Acum.</td>
                        <td>Postulaciones</td>
                        <td colspan="4"></td>
                    </tr>
                    <%
               if(!aspirantes.isEmpty()){
                    int color=0;
                    for(Aspirante asp: aspirantes){%>
                    <tr class="tr_list" <%if(color==0){%> style="background: white;" <%}else{%> style="background: #aad4ff;"<%}%>>
                        <td><%=asp.darIdentificacion() %></td>
                        <td><%=asp.darPrimerNombre()%><%if(asp.darSegundoNombre()!=null){%> <%=asp.darSegundoNombre() %><%}%></td>
                        <td><%=asp.darPrimerApellido() %><%if(asp.darSegundoApellido()!=null){%> <%=asp.darSegundoApellido() %><%}%></td>                 
                        <td><%=asp.darSemestreActual() %></td>
                        <td><%=asp.darPromedioAcumulado()%></td>                  
                        <%if(asp.darPostulaciones().size()>0){%>
                        <td><a href="#"><%=asp.darPostulaciones().size()%></a></td>  
                        <%}else{%>
                        <td>N/A</td>
                        <%}%>
                        <td ><a class="icono_small" href="#" onclick="javascript:venRevPru('<%=asp.darIdentificacion()%>');"><img src="img/icon_pruebas.png" title="Revizar pruebas"/></a></td>
                        <td><a class="icono_small"  href="#" onclick="javascript:venDelAsp('<%=asp.darIdentificacion()%>');"><img src="img/icon_delete.png" title="Eliminar"/></a></td>
                        <td><a class="icono_small"  href="#" onclick="javascript:venActAsp('<%=asp.darIdentificacion()%>');"><img src="img/icon_update.png" title="Actualizar"/></a></td>
                        <td><a class="icono_small"  href="#" onclick="javascript:venSelAsp('<%=asp.darIdentificacion()%>');"><img src="img/icon_select.png" title="Escoger"/></a></td> 
                    </tr>
                   <% if(color==0){color=1;}else{color=0;}
                    }%>
                    <tr style="text-align: left; font-size: 10px; font-family: cursive;"><td>N° Aspirantes <%=aspirantes.size() %></td></tr>
               <%}
               else{%>
               <tr><td colspan="10" style="text-align: center;">No hay registros de aspirantes en el sistema</td></tr>
                <%}%>
               </table> 
            </div>
         </section>
         <jsp:include page="footer.jsp"/>      
         <%} else{ response.sendRedirect("admin.jsp"); }%>
        
    </body>
</html>
