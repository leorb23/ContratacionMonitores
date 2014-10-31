<%-- 
    Document   : dependencias
    Created on : 29/09/2014, 09:21:18 AM
    Author     : SERVIDOR
--%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" type="text/css" media="all">
<!--<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">-->
<!--<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>-->
        <link rel="stylesheet" href="js/tm3/jquery-ui.css">
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/tm3/jquery-ui.js"></script>
        <script src="js/modales.js" type="text/javascript"></script>
        <title>Contratacion Monitores</title>    
    </head>
    <body>
        <jsp:include page="header.jsp" />     
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
                
                <a id="regDep" href="javascript:venRegDep();">Nueva</a>
                <div id="divRegDep" name="divRegDep" class="ventana" class="ui-widget-content" title="Nueva Dependencia...">
			  
		</div>
                
                <div id="divConRegDep" name="divConRegDep" class="ventana" class="ui-widget-content" title="Nueva Dependencia...">
			  
		</div>
                <table align="center" border="1">
                    <th  colspan="8"><h3>Lista de Dependencias</h3></th> 
                    <tr style="background: black; color: white;">                   
                        <td>Codigo</td>
                        <td>Nombre</td>
                        <td>Descripcion</td>
                        <td>Horario</td>
                        <td>Cupos</td>
                    </tr>
                    <tr>
<!--                        <form action="ContratacionMonitoresServlet" method="POST">
                            <td> <input type="text" id="txt_codigo" name="txt_codigo" placeholder="Codigo" required></td>
                            <td><input type="text" id="txt_nombre" name="txt_nombre" placeholder="Nombre" required></td>
                            <td><input type="text" id="txt_descripcion" name="txt_descripcion" placeholder="Descripcion" required></td>
                            <td><select id="slc_jornadaD" name="slc_jornadaD">
                                    <option value="mañana">Mañana</option>
                                    <option value="tarde">Tarde</option>
                                    <option value="diurno">Diurno</option>
                                </select></td>
                            <td><input type="number" id="txt_cupos" name="txt_cupos" placeholder="No de Cupos" required></td>
                            <td><input type="submit" id="btn_enviar" value="Agregar">
                                <input type="hidden" id="accion" name="accion" value="agregarDependencia">
                            </td>                   
                        </form>-->
                    </tr>
                    <%
                    ArrayList<Dependencia> dependencias = new ArrayList();//ContratacionMonitoresServlet.darComunicacionLogica().darDependencias();
                    for(Dependencia dep: dependencias){%>
                       <tr>
                        <td><%=dep.darId()%></td>
                        <td><%=dep.darNombre()%></td>
                        <td><%=dep.darDescripcion()%></td>
                        <form action="ContratacionMonitoresServlet" method="post">
                            <td><input type="submit" value="Eliminar"></td>
                            <input type="hidden" id="idDependencia" name="idDependencia" value="<%=dep.darId()%>">
                            <input type="hidden" id="accion" name="accion" value="eliminarD">
                        </form>
                        <td><a href="#">Modificar</a></td>
                    </tr>
                   <%}%>
                </table>  
                <a id="regDep" href="javascript:venvenContRegDep();">Nueva</a>
            </div>
         </section>
         <%} else{ response.sendRedirect("admin.jsp"); }%>
         
       <%
    Dependencia existeD=(Dependencia)session.getAttribute("depExiste");        
     
    Dependencia d=(Dependencia)session.getAttribute("continuarRegDep");
    //d=null;
    if(existeD!=null){%>
        <script> 
            venRegDep();
        </script>
    <%
        //session.removeAttribute("depExiste");
    }
   if(d!=null){%>
       <script>           
            venContRegDep();
     </script>
   <%
        //session.removeAttribute("continuarRegDep");
   }%>
    </body>
</html>
