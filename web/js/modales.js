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
       // position : "center",
        modal : "true"
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

function venContRegDep() {
    $(document).ready(function(){
          $('#divRegDep').load('util/formularios.jsp?var=contRegDep');
    });	
    $("#divRegDep").dialog({
        width : 500,
        height : 600,
//        show:{
//            //effect :"fold",
//            duration:1
//        },
//        hide:{
//            //effect :"fold",
//            duration:1
//        },
        resizable : "false",
        modal : "true"
    });
}

function hiddenThis($ventana){
    $($ventana).dialog("close");
}

