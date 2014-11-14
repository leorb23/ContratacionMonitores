<%-- 
    Document   : formulariosMonitores
    Created on : 13/11/2014, 04:29:32 PM
    Author     : Andres
--%>

<%@page import="com.umariana.contratacionmonitores.controladores.GestionMonitores"%>
<%@page import="com.umariana.contratacionmonitores.logica.Monitor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="../js/modales.js" type="text/javascript"></script>
<link rel="stylesheet" href="../css/estilos.css" type="text/css" media="all">

<%String var=request.getParameter("var");
String mensaje = (String)session.getAttribute("mensaje");
if(var!=null){
    if(var.equals("verDependenciaM")){
        String identificacion=request.getParameter("identificacion");
        Monitor buscar=GestionMonitores.buscarMonitor(identificacion);%>
        <fieldset id="fls_mostrar">
            <legend>Informacion Dependencia</legend>  
            <br>
            <div><%=buscar.darDependencia().darNombre() %>, <p><%=buscar.darDependencia().darDescripcion() %></p></div>  
            <div>Jornada:     <%=buscar.darDependencia().darJornadas().get(0).getJornada() %></div>  
            <div>Horario:     <%=buscar.darDependencia().darJornadas().get(0).getHorarios().get(0).getDesde() %> - 
                              <%=buscar.darDependencia().darJornadas().get(0).getHorarios().get(0).getHasta() %></div>
                              <br>
            <div>Cupos Disponibles: <%=buscar.darDependencia().getTotalCuposDisponibles() %></div>                           
            <br>
            <div style="text-align: center;">           
                 <form action="" id="formRegDep" name="formRegDep" method="post" style="display: inline-block; ">
                     <input style="width: 100px;" type="button" onclick="javascript:hiddenThis(divVerDepMon);" id="btnForm" name="btnregDep"  value="Aceptar">
                </form>
            </div>
        </fieldset>
    <%}
}%>
