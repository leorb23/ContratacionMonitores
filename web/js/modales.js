function venRegDep() {
    $(document).ready(function(){
        $(this.remove);
          $('#divRegDep').load('util/formularios.jsp?var=regDep');
    });	
    $("#divRegDep").dialog({
        width : 260,
        height : 320,
        //autOpen:false,
        //show : "fold",
//        show:{
//            //effect :"fold",
//            duration:0
//        },
//        hide:{
//            //effect :"fold",
//            duration:0
//        },
        
        //hide : "pulsate",
        resizable : "false",
        modal : "true"
    });
}

function venContRegDep() {
    $(document).ready(function(){
          $('#divRegDep').load('util/formularios.jsp?var=contRegDep');
    });	
    $("#divRegDep").dialog({
        width : 500,
        height : 600,
        resizable : "false",
        modal : "true"
    });
}

function hiddenThis($ventana){
    $($ventana).dialog("close");
}

function venDeleteDep(){
     $(document).ready(function(){
          $('#divDelDep').load('util/formularios.jsp?var=eliminarDep');
    });	
    $("#divDelDep").dialog({
        width : 500,
        height : 320,
        resizable : "false",
        modal : "true"
    });
}
function venUpdateDep(){
     $(document).ready(function(){
          $('#divUpdDep').load('util/formularios.jsp?var=actualizarDep');
    });	
    $("#divUpdDep").dialog({
        width : 500,
        height : 600,
        resizable : "false",
        modal : "true"
    });
}
function venVerDep($idDependencia){
    $(document).ready(function(){
          $('#divVerDep').load('util/formularios.jsp?var=verDependencia&idDependencia='+$idDependencia);
    });	
    $("#divVerDep").dialog({
        width : 500,
        height : 350,
        resizable : "false",
        modal : "true"
    });
}
function venRegEst(){
    $(document).ready(function(){
          $('#divRegEst').load('util/formulariosEstudiantes.jsp?var=registrarEstudiante');
    });	
    $("#divRegEst").dialog({
        width : 500,
        height : 350,
        resizable : "false",
        modal : "true"
    });
}
function venIngresoEstudiantes(){
    $(document).ready(function(){
          $('#divIngreso').load('util/formulariosEstudiantes.jsp?var=ingresar');
    });	
    $("#divIngreso").dialog({
        width : 300,
        height : 190,
        resizable : "false",
        modal : "true"
    });
}

function cambiarHorarioCbx($idJornada){
    $('#slc_horario').load('util/formularios.jsp?var=cambiarHorario&idJornada='+$idJornada);
    cambiarCuposCbx("0");
}
function cambiarCuposCbx($idHorario){
    $('#tdCupos').load('util/formularios.jsp?var=cambiarHorario&idHorario='+$idHorario);
}


$(document).ready(function(){
    $('#slc_jornada').change(function(){
        var idJornada=$('#slc_jornada').val();
        $('#slc_horario').load('util/formularios.jsp?var=cambiarHorario&idJornada='+idJornada);
    });    
});