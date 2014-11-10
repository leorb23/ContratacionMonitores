<%@page import="com.umariana.contratacionmonitores.controladores.GestionDependencias"%>
<%@page import="com.umariana.contratacionmonitores.logica.dependencia.Horario"%>
<%@page import="java.util.List"%>
<%@page import="com.umariana.contratacionmonitores.logica.dependencia.Jornada"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.contratacionmonitores.logica.Dependencia"%>
<!--<script src="../js/modales.js" type="text/javascript"></script>-->
<!--<script src="../js/validaciones.js" type="text/javascript"></script>-->
<link rel="stylesheet" href="../css/estilos.css" type="text/css" media="all">

<%String var=request.getParameter("var");
String mensaje = (String)session.getAttribute("mensaje");
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
            <textarea type="text" name="txt_descripcion" id="txt_descripcion"  maxlength="100" required><%if(regDep1!=null){ %><%=regDep1.darDescripcion()%><%}%><%if(existeD!=null){ %><%=existeD.darDescripcion()%><%}%></textarea> 
            <br>
            <br>
            <input  type="submit"  id="btnForm" name="btnregDep"  value="Enviar">
    </form>

   <%     
    } if(var.equals("contRegDep"))
   {
       Dependencia regDep2=(Dependencia)session.getAttribute("regDep2");
   %>
           <%if(mensaje!=null){%>
                     <h4><%=mensaje%></h4>
                    <%session.removeAttribute("mensaje");
             }%>      
            <fieldset id="fls_mostrar">
                <legend>Datos de la Nueva Dependencia</legend>
                <table>
                    <tr>
                        <td><p style="color: black;">Dependencia:</p></td>
                        <td style="height: auto; text-align: left; padding-left: 5px;"><p><%if(regDep2!=null){ %><%=regDep2.darNombre() %><%}%></p></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="height: auto; text-align: left; padding-left: 5px;"><p><%if(regDep2!=null){ %><%=regDep2.darDescripcion()%><%}%></p></td>
                    </tr>
                </table>
                
                         
                <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post">
                    <input type="submit"  id="btnForm" name="btnregDep"  value="Editar">
                    <input id="accion" name="accion" type="hidden" value="volverRegDep"/>                 
                </form>
            </fieldset>
            <fieldset id="fls_mostrar">
                <legend>Registro de Horarios</legend>
                <%if(mensaje!=null){%>
                <h4 style="color: red; font-size: 13px;"><%=mensaje%></h4>
                        <%session.removeAttribute("mensaje");
                }%>
                <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post">
                    <table style="text-align: left;">
                        <tr>
                            <td><label>Jornada</label>
                                <select id="slc_jornada" name="slc_jornada" required>
                                    <option value="manana">Mañana</option>
                                    <option value="Tarde">Tarde</option>
                                    <option value="Noche">Noche</option>
                                </select>
                            </td>
                            <td>
                                <label>Número de Cupos</label>
                                <input type="number" id="txtCupos" name="txtCupos" min="1" max="10" required>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Hora de Inicio</label>
                                <input type="number" id="txtHoraInicio" name="txtHoraInicio" min="0" max="23" required>
                            </td>
                            <td>
                                <label>Finalización</label>
                                <input type="number" id="txtHoraFin" name="txtHoraFin" min="0" max="23" required>
                            </td>
                        </tr>
                    </table>
                    <input type="submit"  id="btnForm" name="btnregDep"  value="Agregar">
                    <input id="accion" name="accion" type="hidden" value="agregarHorario"/>
                    <input id="atras" name="atras" type="hidden" value="si"/>
                </form>
            </fieldset>
            <fieldset id="fls_mostrar">
                <legend>Horarios</legend>
                <table>
                    <tr style="height: 30px;" id="tr_rows">
                        <td>Jornada</td><td>Inicio</td><td>Fin</td><td>Cupos</td>
                    </tr>
                <%List<Jornada> jornadas =regDep2.darJornadas(); 
                if(jornadas.isEmpty()){
                %>
                    <tr>
                        <td colspan="4">No hay datos</td>
                    </tr>
                <%
                }
                else{
                    int color=0;
                    for(Jornada j :regDep2.darJornadas()){
                        
                        for(Horario h:j.getHorarios()){
                        
                        %>
                            <tr class="tr_list"  <%if(color==0){%> style="background: white;" <%}else{%>style="background: #aad4ff;"<%}%>>
                                <td ><%=j.getJornada() %></td><td><%=h.getDesde() %> </td><td><%=h.getHasta() %></td><td><%=h.getTotalCupos() %></td>
                           </tr>
                        <%
                        }
                       if(color==0){color=1;}else{color=0;}
                    }
                } 
                
                %>
                </table>
                <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post">
                    <input type="submit"  id="btnForm" name="btnregDep"  value="Terminar">
                    <input id="accion" name="accion" type="hidden" value="finalizarRegDep"/>
                </form>
            </fieldset>
                
            <!--<a id="regDep" href="javascript:hiddenThis(divRegDep);venRegDep();"><input type="button" id="btnregDep" name="btnregDep"  value="Atras"></a>-->
   <%         
   }
    if(var.equals("eliminarDep"))
   {
   Dependencia eliminarD=(Dependencia)session.getAttribute("eliminarDep");
   %>
         <fieldset id="fls_mostrar">
            <legend>Eliminar Dependencia</legend>  
            <table>
                <th style="font-size: 15px;" colspan="2">¿ Esta seguro que desea eliminar la dependencia ?</th>
                <tr>
                    <td><p style="color: black;">Dependencia:</p></td>
                    <td style="height: auto; text-align: left; padding-left: 5px;"><p><%if(eliminarD!=null){ %><%=eliminarD.darNombre() %><%}%></p></td>
                </tr>
                <tr>
                    <td></td>
                    <td style="height: auto; text-align: left; padding-left: 5px;"><p><%if(eliminarD!=null){ %><%=eliminarD.darDescripcion()%><%}%></p></td>
                </tr>
            </table>
            <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post" style="display: inline-block;">
              <input type="submit"  id="btnForm" name="btnregDep"  value="Eliminar">
              <input id="accion" name="accion" type="hidden" value="aceptarDelDep"/>
          </form>
           <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post" style="display: inline-block;">
              <input type="submit"  id="btnForm" name="btnregDep"  value="Cancelar">
              <input id="accion" name="accion" type="hidden" value="cancelar"/>
          </form>
        </fieldset>
   <%}
    if(var.equals("actualizarDep")){
        Dependencia actualizarDep=(Dependencia)session.getAttribute("actualizarDep"); %>
         <fieldset id="fls_mostrar">
                <legend>Datos de la Dependencia</legend>
                <table>
                    <tr>
                        <td><p style="color: black;">Nombre:</p></td>
                        <td style="height: auto; text-align: left; padding-left: 5px;"><input type="text" name="txt_nombre" id="txt_nombre"  maxlength="25" value="<%if(actualizarDep!=null){ %><%=actualizarDep.darNombre() %><%}%>" required></td>
                    </tr>
                    <tr>
                        <td>Descripción:</td>
                        <td style="height: auto; text-align: left; padding-left: 5px;"><textarea type="text" name="txt_descripcion" id="txt_descripcion"  maxlength="100" required><%if(actualizarDep!=null){ %><%=actualizarDep.darDescripcion()%><%}%></textarea> </td>
                    </tr>
                </table>
            </fieldset>
                    
            <fieldset id="fls_mostrar">
                <legend>Horarios</legend>
                <table>
                    <tr style="height: 30px;" id="tr_rows">
                        <td>Jornada</td><td>Inicio</td><td>Fin</td><td>Cupos</td><td colspan="2"></td>
                    </tr>
                <%List<Jornada> jornadas =actualizarDep.darJornadas(); 
                if(jornadas.isEmpty()){
                %>
                    <tr>
                        <td colspan="4">No hay datos</td>
                    </tr>
                <%
                }
                else{
                    int color=0;
                    for(Jornada j :actualizarDep.darJornadas()){
                        
                        for(Horario h:j.getHorarios()){
                        
                        %>
                            <tr class="tr_list"  <%if(color==0){%> style="background: white;" <%}else{%>style="background: #aad4ff;"<%}%>>
                                <td ><%=j.getJornada() %></td><td><%=h.getDesde() %> </td><td><%=h.getHasta() %></td><td><%=h.getTotalCupos() %></td>
                                <form action="GestionDependencias" method="post">
                                    <td class="icono"><input type="image"  id="btn_img" src="img/icon_delete.png"></td>
                                    <input type="hidden" id="idDependencia" name="idDependencia" value="<%=h.getId() %>">
                                    <input type="hidden" id="accion" name="accion" value="eliminarHorarioDep">
                                </form>
                                <form action="ContratacionMonitoresServlet" method="post">
                                    <td class="icono" id="td_padd"><input type="image"  id="btn_img"  src="img/icon_update.png"></td>
                                    <input type="hidden" id="idDependencia" name="idDependencia" value="<%=h.getId()%>">
                                    <input type="hidden" id="accion" name="accion" value="actualizarHorarioDep">
                                </form>
                           </tr>
                        <%
                        }
                       if(color==0){color=1;}else{color=0;}
                    }
                } 
                
                %>
                </table>
                <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post" style="display: inline-block;">
                    <input  type="submit"  id="btnForm" name="btnregDep"  value="Guardar Cambios">
                    <input id="accion" name="accion" type="hidden" value="finalizarActDep"/>
                </form>
                <form action="GestionDependencias" id="formRegDep" name="formRegDep" method="post" style="display: inline-block;">
                    <input type="submit"  id="btnForm" name="btnregDep"  value="Cancelar">
                    <input id="accion" name="accion" type="hidden" value="cancelar"/>
                </form>
            </fieldset>
   <%}
    if(var.equals("cambiarHorario")){
        String idJornada=request.getParameter("idJornada");
        ArrayList<Horario> horarios = GestionDependencias.darHorariosJornada(idJornada);
        for(Horario h:horarios)
        {%>
            <option value="<%=h.getId() %>"><%=h.getDesde() %> - <%=h.getHasta() %></option>
        <%}
    }
}%>




