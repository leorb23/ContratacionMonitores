<%-- 
    Document   : dependencias
    Created on : 29/09/2014, 09:21:18 AM
    Author     : SERVIDOR
--%>

<%@page import="com.umariana.contratacionmonitores.logica.dependencia.Jornada"%>
<%@page import="com.umariana.contratacionmonitores.logica.Dependencia"%>
<%@page import="com.umariana.contratacionmonitores.logica.Dependencia"%>
<%@page import="com.umariana.contratacionmonitores.controladores.ContratacionMonitoresServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.contratacionmonitores.logica.Monitor"%>
<%@page import="com.umariana.contratacionmonitores.logica.Administrador"%>
<%@page import="com.umariana.contratacionmonitores.logica.Estudiante"%>
<%@page import="com.umariana.contratacionmonitores.logica.Aspirante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    
    session.setAttribute("ubicacionPage", "dependencia.jsp");
    
    Administrador admin = (Administrador)session.getAttribute("admin");
    String mensaje = (String)session.getAttribute("mensaje");
    Dependencia eliminarD = (Dependencia)session.getAttribute("eliminarDependencia");
    session.removeAttribute("eliminarMonitor");     
    session.removeAttribute("eliminarAspirante");     
    session.removeAttribute("eliminarString");

%>
<!DOCTYPE html5>
<html>
    <head>      
        <jsp:include page="head.jsp" />
        <title>Dependencias</title>
    </head>
    <body>
        <jsp:include page="header.jsp" /> 
        
        <jsp:include page="divModal.jsp" /> 

         <section>
            <%if(admin!=null){%> 
            <div id="contenedor">
                <%if(eliminarD!= null ){%>
                <div id="div_eliminar">
                    <form action="ContratacionMonitoresServlet" method="POST">
                        <h2>Seguro que desea eliminar la dependencia:</h2>
                        <p>Id: <%=eliminarD.darId() %></p>
                        <p>Nombre: <%=eliminarD.darNombre() %></p>
                        <p>Horario: <%=eliminarD.darHorario() %></p>                
                        <p>Descripción: <%=eliminarD.darDescripcion() %></p>
                        
                        <select id="select_eliminar" name="select_eliminar">
                        <option value="si">Si</option>
                        <option value="no">No</option>
                        </select>
                        <input type="submit" id="btn_enviar" value="Aceptar">
                        <input type="hidden" id="accion" name="accion" value="confirmarEliminar">
                    </form>
                </div>
                <%}%>
                <%if(mensaje!=null){%>
                     <h4 style="color: black;"><%=mensaje%></h4>
                     <%//session.removeAttribute("mensaje");
                }%>
                
                

                
                <table>
<!--                    <tr id="tr_link_new_dep">
                        <td>
                            <a id="regDep" href="javascript:venRegDep();"><img class="icono" src="img/icon_add.png"/></a>
                            
                        </td>
                    </tr>-->
                    <th  colspan="8">Lista de Dependencias</th> 
                    <tr id="tr_rows" style="background: black; color: white;">                   
                        <td>Nombre</td>
                        <td>Descripcion</td>
                        <td>Cupos Tot.</td>
                        <td>Jornada</td>
                        <td>Horario</td>
                        <td>Cupos Disp.</td>
                        <td colspan="2"><a class="icono" id="regDep" href="javascript:venRegDep();"><img src="img/icon_add.png"/></a></td>
                    </tr>
                    <%
                    ArrayList<Dependencia> dependencias = ContratacionMonitoresServlet.darComunicacionLogica().darDependencias();
                    int color=0;
                    for(Dependencia dep: dependencias){%>
                    <tr class="tr_list"  <%if(color==0){%> style="background: white;" <%}else{%>style="background: #aad4ff;"<%}%>>
                        <td id="td_padd" style="text-align: left;"><%=dep.darNombre()%></td>
                        <td style="text-align: left;"><%=dep.darDescripcion()%></td>
                        <td>0</td>
                        <td>
                            <select id="slc_jornada" name="slc_jornada">
                                <%for(Jornada j: dep.darJornadas() ) {%>
                                <option id="<%= j.getId() %>"><%=j.getJornada() %></option>
                                <%}%>
                            </select>
                        </td>
                        <td>
                            <select id="slc_horario" name="slc_horario">
                                <option id="">Seleccione...</option>
                            </select>
                        </td>
                        <td>0</td>
                        <form action="GestionDependencias" method="post">
                            <td class="icono"><input type="image"  id="btn_img" src="img/icon_delete.png"></td>
                            <input type="hidden" id="idDependencia" name="idDependencia" value="<%=dep.darId()%>">
                            <input type="hidden" id="accion" name="accion" value="eliminarD">
                        </form>
                        <form action="ContratacionMonitoresServlet" method="post">
                            <td class="icono" id="td_padd"><input type="image"  id="btn_img"  src="img/icon_update.png"></td>
                            <input type="hidden" id="idDependencia" name="idDependencia" value="<%=dep.darId()%>">
                            <input type="hidden" id="accion" name="accion" value="actualizarD">
                        </form>
                    </tr>
                   <% if(color==0){color=1;}else{color=0;}
                    }%>
                </table>  
            </div>
         </section>
         <%} else{ response.sendRedirect("admin.jsp"); }%>
         
         
<!--       VERIFICA SI EL ADMIN ESTA EN UN PROCESO DE GESTION DE UNA DEPENDENCIA  -->
       <%
            Dependencia existeD=(Dependencia)session.getAttribute("depExiste");            
            Dependencia regDep2=(Dependencia)session.getAttribute("regDep2");
            Dependencia regDep1=(Dependencia)session.getAttribute("regDep1");
            Dependencia eliminarDep=(Dependencia)session.getAttribute("eliminarDep");

            if(existeD!=null || regDep1!=null){%>
                <script> 
                    venRegDep();
                </script>
            <%
            }        
           if(regDep2!=null){%>
               <script>           
                    venContRegDep();
             </script>
           <%
            }
           if(eliminarDep!=null){%>
                <script> 
                    venRegDep();
                </script>
            <%
            }
           %>
    </body>
</html>
