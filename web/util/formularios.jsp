<!--<script src="../js/modales.js" type="text/javascript"></script>-->
<!--<script src="../js/validaciones.js" type="text/javascript"></script>-->
<%String var=request.getParameter("var");
if(var!=null)
{
    if(var.equals("regDep"))
    {%>
    <form action="../ContratacionMonitoresServlet" id="formRegDep" name="formRegDep" method="post">
            <input id="accion" name="accion" type="hidden" value="regDep"/>
            <label>Nombre</label>
            <input type="text" name="txt_nombre" id="txt_nombre"  maxlength="25"  required>
            <br>
            <br>
            <label>Descripci�n</label>
            <textarea type="text" name="txt_descripcion" id="txt_descripcion"  maxlength="50" required></textarea> 
            <br>
            <br>
            <input type="submit"  id="btn_hidden" name="btn_hidden"  value="Enviar">
    </form>

   <%}
}%>



