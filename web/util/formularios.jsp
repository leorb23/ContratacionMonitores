<%@page import="com.umariana.contratacionmonitores.logica.Dependencia"%>
<!--<script src="../js/modales.js" type="text/javascript"></script>-->
<!--<script src="../js/validaciones.js" type="text/javascript"></script>-->
<link rel="stylesheet" href="../css/estilos.css" type="text/css" media="all">

<%String var=request.getParameter("var");
String mensaje = (String)session.getAttribute("mensaje");

Dependencia regDep2=(Dependencia)session.getAttribute("regDep2");
//Dependencia existeD=(Dependencia)session.getAttribute("depExiste");
if(regDep2!=null){
   // session.removeAttribute("continuarRegDep");
}
/*if(existeD!=null){
    session.removeAttribute("regDep2");
    nuevaD=null;
    session.removeAttribute("depExiste");
}*/

if(var!=null)
{
    if(var.equals("regDep"))
    {%>
    <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post"> 
            <%
             Dependencia regDep1=(Dependencia)session.getAttribute("regDep1");
             Dependencia existeD=(Dependencia)session.getAttribute("depExiste");

            if(mensaje!=null){%>
            <h4 style="color: red; font-size: 13px;"><%=mensaje%></h4>
                    <%session.removeAttribute("mensaje");
            }%>
            <input id="accion" name="accion" type="hidden" value="regDep"/>
            <label>Nombre</label>
            <input type="text" name="txt_nombre" id="txt_nombre"  maxlength="25" value="<%if(regDep1!=null){ %><%=regDep1.darNombre() %><%}%>" required>
            <br>
            <br>
            <label>Descripción</label>
            <textarea type="text" name="txt_descripcion" id="txt_descripcion"  maxlength="50" required><%if(regDep1!=null){ %><%=regDep1.darDescripcion()%><%}%><%if(existeD!=null){ %><%=existeD.darDescripcion()%><%}%></textarea> 
            <br>
            <br>
            <input  type="submit"  id="btnForm" name="btnregDep"  value="Enviar">
    </form>

   <%     
    } if(var.equals("contRegDep"))
   {%>
   
        <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post">
            <input  type="submit"  id="btnForm" name="btnregDep"  value="Atras">
            <input id="accion" name="accion" type="hidden" value="contRegDep"/>
            <input id="atras" name="atras" type="hidden" value="si"/>
        </form>
       <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post">
           <%if(mensaje!=null){%>
                     <h4><%=mensaje%></h4>
                    <%session.removeAttribute("mensaje");
             }%>
             Nombre Dep:<%if(regDep2!=null){ %><%=regDep2.darNombre() %><%}%>
            <input id="accion" name="accion" type="hidden" value="contRegDep"/>
            <label>Nombre</label>
            <input type="text" name="txt_nombre" id="txt_nombre"  maxlength="25" required>
            <input type="text" name="" id=""  maxlength="25" required>
            <input type="text" name="" id=""  maxlength="25" required>
            <br>
            <br>
            <label>Descripción</label>
            <textarea type="text" name="txt_descripcion" id="txt_descripcion"  maxlength="50"  required></textarea> 
            <br>
            <br>
            
            <!--<a id="regDep" href="javascript:hiddenThis(divRegDep);venRegDep();"><input type="button" id="btnregDep" name="btnregDep"  value="Atras"></a>-->
            <input  type="submit"  id="btnForm" name="btnregDep"  value="Enviar">
    </form>
   <%         
   }
    if(var.equals("eliminarDep"))
   {
   Dependencia eliminarD=(Dependencia)session.getAttribute("eliminarDep");
   %>
   
         <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post"> 
            <h3>Esta seguro que desea eliminar la dependencia</h3>
            <%=eliminarD.darNombre() %>
            <input id="accion" name="accion" type="hidden" value="regDep"/>
            <label>Nombre</label>
            <input type="text" name="txt_nombre" id="txt_nombre"  maxlength="25" value="<%if(eliminarD!=null){ %><%=eliminarD.darNombre() %><%}%>" required>
            <br>
            <br>
            <input  type="submit"  id="btnregDep" name="btnregDep"  value="Enviar">
            <input type="submit" id="btn_enviar" value="Aceptar">
            <input type="hidden" id="accion" name="accion" value="confirmarEliminar">
        </form>
   <%}
}%>




