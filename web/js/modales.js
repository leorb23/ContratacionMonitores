function venRegDep() {
    $(document).ready(function(){
          $('#divRegDep').load('../util/formularios.jsp?var=regDep');
    });	
    $("#divRegDep").dialog({
        width : 300,
        height : 260,
        show : "fold",
        //hide : "explode",
        resizable : "false",
        position : "center",
        modal : "true",
//    buttons : {
//        "Entrar" : function() {
//            
//            if(validarRegDep()){
//                var forma = document.getElementById("formRegDep");
//                forma.action = "../ContratacionMonitoresServlet";
//                forma.method="post";
//                forma.submit();
//                return true;
//            }
//            else
//                return false;    
//        },
//        "Cancelar" : function() {
//                $(this).dialog("close");
//        }
//    }
    });
}

