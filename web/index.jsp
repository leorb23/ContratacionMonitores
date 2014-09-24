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
    Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");
    String mensaje = (String)session.getAttribute("mensaje");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contratacion Monitores</title>
    </head>
    <body>
        <h1>Contratacion de Monitores</h1>
        <% if(aspirante==null && monitor==null && estudiante==null){%>
            <%if(mensaje!=null){%>
                 <h4 style="color: red;"><%=mensaje%></h4>
            <%}%>
           
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
            <br>
            <br>
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
            
        <%}
        if(aspirante!= null){%>
             <%if(mensaje!=null){%>
                 <h4 style="color: red;"><%=mensaje%></h4>
            <%}%>
            <label>Aspirante :<%=aspirante.darPrimerNombre() %></label><br>
            <label>Identificado : <%=aspirante.darIdentificacion() %></label><br>
            <label>Datos Personales : <%=aspirante.toString() %></label>  
            <form action="ContratacionMonitoresServlet" method="POST">
                <input type="submit"  value="Cerrar Sesion">
                <input type="hidden" id="accion" name="accion" value="cerrar">
            </form>
        <%}
        else if(monitor!= null){%>
             <%if(mensaje!=null){%>
                 <h4 style="color: red;"><%=mensaje%></h4>
            <%}%>
            <label>Monitor :<%=monitor.darPrimerNombre() %></label><br>
            <label>Identificado : <%=monitor.darIdentificacion() %></label><br>
            <label>Datos Personales : <%=monitor.toString() %></label>  
            <form action="ContratacionMonitoresServlet" method="POST">
                <input type="submit"  value="Cerrar Sesion">
                <input type="hidden" id="accion" name="accion" value="cerrar">
            </form>
        <%}
        else if(estudiante!= null){%>
            <%if(mensaje!=null){%>
                 <h4 style="color: red;"><%=mensaje%></h4>
            <%}%>
            <label>Estudiante :<%=estudiante.darPrimerNombre() %></label><br>
            <label>Identificado : <%=estudiante.darIdentificacion() %></label><br>
            <label>Datos Personales : <%=estudiante.toString() %></label>  <br>
            <label>Desea registrarse en el Sistema de Contratacion de Monitores ?</label>  
            <form action="ContratacionMonitoresServlet" method="POST">
                <select id="select_registrar" name="select_registrar">
                    <option value="si">Si</option>
                    <option value="no">No</option>
                </select>
                <input type="hidden" id="accion" name="accion" value="reg_estu">
                <input type="submit"  value="Registrar">
            </form>
        <%}%>
           
    </body>
</html>
