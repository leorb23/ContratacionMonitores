<%@page import="com.umariana.contratacionmonitores.controladores.GestionAspirantes"%>
<%@page import="com.umariana.contratacionmonitores.logica.Aspirante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="../js/modales.js" type="text/javascript"></script>
<link rel="stylesheet" href="../css/estilos.css" type="text/css" media="all">

<%String var=request.getParameter("var");
String mensaje = (String)session.getAttribute("mensaje");
if(var!=null){
    if(var.equals("eliminarAspirante")){
        String identificacion=request.getParameter("identificacion");
        Aspirante eliminar=GestionAspirantes.buscarAspirante(identificacion);%>
        <fieldset id="fls_mostrar">
            <legend>Eliminar Aspirante</legend>  
            <div style="text-align: center;">¿Desea eliminar el aspirante?</div>
            <br>
            <table id="tbl_ven">
                <tr>
                    <td>Identificación:</td><td><%=eliminar.darIdentificacion() %></td>
                </tr>
                <tr>
                    <td>Nombres:</td><td><%=eliminar.darPrimerNombre()%><%if(eliminar.darSegundoNombre()!=null){%> <%=eliminar.darSegundoNombre() %><%}%></td>
                </tr>
                <tr>
                    <td></td><td><%=eliminar.darPrimerApellido() %><%if(eliminar.darSegundoApellido()!=null){%> <%=eliminar.darSegundoApellido() %><%}%></td>
                </tr>
            </table>
            <br>
            <div style="text-align: center;">
                <form action="GestionAspirantes" id="formRegDep" name="formRegDep" method="post" style="display: inline-block;">
                  <input style="width: 100px;" type="submit"  id="btnForm" name="btnregDep"  value="Eliminar">
                  <input  id="accion" name="accion" type="hidden" value="eliminarAspirante"/>
                  <input  id="accion" name="identificacion" type="hidden" value="<%=eliminar.darIdentificacion() %>"/>
                </form>
                 <form action="" id="formRegDep" name="formRegDep" method="post" style="display: inline-block; ">
                     <input style="width: 100px;" type="button" onclick="javascript:hiddenThis(divDelAsp);" id="btnForm" name="btnregDep"  value="Cancelar">
                </form>
            </div>
        </fieldset>
    <%}
}%>

