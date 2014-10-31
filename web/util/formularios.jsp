<%@page import="com.umariana.contratacionmonitores.logica.Dependencia"%>
<!--<script src="../js/modales.js" type="text/javascript"></script>-->
<!--<script src="../js/validaciones.js" type="text/javascript"></script>-->
<%String var=request.getParameter("var");
String mensaje = (String)session.getAttribute("mensaje");
Dependencia nuevaD=(Dependencia)session.getAttribute("continuarRegDep");
Dependencia existeD=(Dependencia)session.getAttribute("depExiste");
if(var!=null)
{
    if(var.equals("regDep"))
    {%>
    <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post"> 
            <%if(mensaje!=null){%>
                     <h4 style="color: black;"><%=mensaje%></h4>
                    <%session.removeAttribute("mensaje");
            }%>
            <input id="accion" name="accion" type="hidden" value="regDep"/>
            <label>Nombre</label>
            <input type="text" name="txt_nombre" id="txt_nombre"  maxlength="25" required>
            <br>
            <br>
            <label>Descripción</label>
            <textarea type="text" name="txt_descripcion" id="txt_descripcion"  maxlength="50" required><%if(existeD!=null){ %><%=existeD.darDescripcion()%><%}%></textarea> 
            <br>
            <br>
            <input  type="submit"  id="btnregDep" name="btnregDep"  value="Enviar">
    </form>

   <%
            session.removeAttribute("depExiste");
    } if(var.equals("contRegDep"))
   {%>
       <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post">
           <%if(mensaje!=null){%>
                     <h4 style="color: red; font-size: 10px;"><%=mensaje%></h4>
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
            <input  type="submit"  id="btnregDep" name="btnregDep"  value="Enviar">
    </form>
   <%
           session.removeAttribute("continuarRegDep");
   }
}%>




