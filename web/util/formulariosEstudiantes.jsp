<%@page import="com.umariana.contratacionmonitores.logica.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="../js/modales.js" type="text/javascript"></script>
<link rel="stylesheet" href="../css/estilos.css" type="text/css" media="all">

<%String var=request.getParameter("var");
String mensaje = (String)session.getAttribute("mensaje");
if(var!=null){
    if(var.equals("registrarEstudiante")){
        Estudiante estudiante = (Estudiante)session.getAttribute("estudiante");
        %>
        <fieldset id="fls_mostrar">
            <legend>Registrar Estudiante</legend>  
            <table id="tbl_reg_est">
                <th colspan="4">¿Se desea registrar para aplicar como aspirante a una monitoria?</th>
                <tr>
                    <td>Identificacion:</td>
                    <td><%=estudiante.darIdentificacion()%></td>
                    <td rowspan="4" colspan="2" style="background: green; width: 70px; height: 50px;">Foto</td>
                </tr>
                <tr>
                    <td>Nombres:</td>
                    <td ><%=estudiante.darPrimerNombre() %><%if(estudiante.darSegundoNombre()!=null){%> <%=estudiante.darSegundoNombre() %><%}%> </td>
                    <td></td><td></td>
                </tr>
                <tr>
                    <td>Apellidos:</td>
                    <td ><%=estudiante.darPrimerApellido() %><%if(estudiante.darSegundoApellido()!=null){%> <%=estudiante.darSegundoApellido() %><%}%> </td>
                    <td></td><td></td>
                </tr>
                <tr>
                    <td>Semestre:</td>
                    <td><%=estudiante.darSemestreActual() %> </td>
                    <td></td>
                </tr>              
            </table>
            <form action="GestionEstudiantes" id="formRegDep" name="formRegDep" method="post" style="display: inline-block;">
              <input type="submit"  id="btnForm" name="btnregDep"  value="Postularme">
              <input id="accion" name="accion" type="hidden" value="regEst"/>
          </form>
           <form action="" id="formRegDep" name="formRegDep" method="post" style="display: inline-block;">
              <input type="button" onclick="javascript:hiddenThis(divRegEst)" id="btnForm" name="btnregDep"  value="Cancelar">
          </form>
        </fieldset>
        <%
    }
    if(var.equals("ingresar")){%>
        <fieldset id="fls_mostrar">
         <legend>Ingreso para Estudiantes</legend> 
         <form action="GestionSesionDeEstudiantes" id="formRegDep" name="formRegDep" method="post" style="display: inline-block; width: 250px; height: 80px;">
              <input type="hidden" id="accion" name="accion" value="ingreso">   
              <table id="tbl_ingreso">   
                  <tr style="height: auto;">
                   <td>  <label>Identificacion</label></td>
                   <td><input style="width: 120px;" type="text" id="txt_identificacion" name="txt_identificacion" required></td>
               </tr>
               <tr>
                   <td>
                       <input style="width: 120px;" type="submit" id="btnForm" name="btnregDep" value="Entrar">
                   </td>
                   <td>
                     <input style="width: 120px; margin-left: 5px;" type="button" onclick="javascript:hiddenThis(divIngreso)" id="btnForm" name="btnregDep"  value="Cancelar">
                   </td>
               </tr>
            </table>
        </form>
        </fieldset>
   <%} 
}%>
