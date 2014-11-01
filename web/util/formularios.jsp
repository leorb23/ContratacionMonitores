<%@page import="com.umariana.contratacionmonitores.logica.Dependencia"%>
<!--<script src="../js/modales.js" type="text/javascript"></script>-->
<!--<script src="../js/validaciones.js" type="text/javascript"></script>-->
<link rel="stylesheet" href="../css/estilos.css" type="text/css" media="all">

<%String var=request.getParameter("var");
String mensaje = (String)session.getAttribute("mensaje");

Dependencia nuevaD=(Dependencia)session.getAttribute("continuarRegDep");
Dependencia existeD=(Dependencia)session.getAttribute("depExiste");;
if(nuevaD!=null){
   // session.removeAttribute("continuarRegDep");
}
if(existeD!=null){
    session.removeAttribute("continuarRegDep");
    nuevaD=null;
    session.removeAttribute("depExiste");
}

if(var!=null)
{
    if(var.equals("regDep"))
    {%>
    <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post"> 
            <%if(mensaje!=null){%>
            <h4 style="color: red; font-size: 13px;"><%=mensaje%></h4>
                    <%session.removeAttribute("mensaje");
            }%>
            <input id="accion" name="accion" type="hidden" value="regDep"/>
            <label>Nombre</label>
            <input type="text" name="txt_nombre" id="txt_nombre"  maxlength="25" value="<%if(nuevaD!=null){ %><%=nuevaD.darNombre() %><%}%>" required>
            <br>
            <br>
            <label>Descripción</label>
            <textarea type="text" name="txt_descripcion" id="txt_descripcion"  maxlength="50" required><%if(nuevaD!=null){ %><%=nuevaD.darDescripcion()%><%}%><%if(existeD!=null){ %><%=existeD.darDescripcion()%><%}%></textarea> 
            <br>
            <br>
            <input  type="submit"  id="btnregDep" name="btnregDep"  value="Enviar">
    </form>

   <%     
    } if(var.equals("contRegDep"))
   {%>
       <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post">
           <%if(mensaje!=null){%>
                     <h4><%=mensaje%></h4>
                    <%session.removeAttribute("mensaje");
             }%>
             <h4>Nombre Dep:<%if(nuevaD!=null){ %><%=nuevaD.darNombre() %><%}%></h4>
            <input id="accion" name="accion" type="hidden" value="regDep"/>
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
            <a id="regDep" href="javascript:hiddenThis(divRegDep);venRegDep();"><input type="button" id="btnregDep" name="btnregDep"  value="Atras"></a>
            <input  type="submit"  id="btnregDep" name="btnregDep"  value="Enviar">
    </form>
   <%         
   }
}%>




