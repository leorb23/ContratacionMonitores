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
        show:{
            effect :"fold",
            duration:100
        },
        hide:{
            effect :"fold",
            duration:100
        },
        
        //hide : "pulsate",
        resizable : "false",
       // position : "center",
       // modal : "true"
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
          $('#divConRegDep').load('util/formularios.jsp?var=contRegDep');
    });	
    $("#divConRegDep").dialog({
        width : 250,
        height : 300,
        show : "fold",
        hide : "pulsate",
        resizable : "false",
        modal : "true"
    });
}

