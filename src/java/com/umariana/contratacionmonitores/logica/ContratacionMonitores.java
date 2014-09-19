package com.umariana.contratacionmonitores.logica;

import com.umariana.contratacionmonitores.datos.ContratacionMonitoresDAO;
import com.umariana.contratacionmonitores.excepciones.ExcepcionNoExiste;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
/**
* Es la clase principal del sistema Contratacion de Monitores
* @author CocoSoft
*/
public class ContratacionMonitores {
    //
    //ATRIBUTOS
    //
    /**
     * Es la lista de dependencias existentes en el sistema
     */
    private ArrayList<Dependencia> dependencias;
    /**
     * Es la lista de monitores existentes en el sistema
     */
    private ArrayList<Monitor> monitores;
    /**
     * Es la lista de resultados existentes en el sistema
     */
    private ArrayList<Resultado> resultados;
    /**
     * Es la lista de aspirantes al cargo de monitor
     */
    private ArrayList<Aspirante> aspirantes;

    /**
     * Es la comunicacion con la clase que controla la base de datos
     */
    private ContratacionMonitoresDAO  cmDAO;
    //
    //CONSTRUCTOR
    //
    /**
     * Es el constructor de la clase Principal
     */
    public ContratacionMonitores() 
    {             
        
        cmDAO = new ContratacionMonitoresDAO();
        aspirantes   =  cmDAO.darAspirantesRegistrados();
        resultados   =  cmDAO.darResultadosRegistrados();
        monitores    =  cmDAO.darMonitoresRegistrados();
        dependencias =  cmDAO.darDependenciasRegistrados();   
    }           
    //
    //METODOS
    //
    /**
     * Retorna la lista de monitores
     * @return monitores
     */
    public ArrayList<Monitor> darMonitores() 
    {
        return monitores;
    }

    /**
     * Cambia la lista de monitores por la nueva lista
     * @param monitores ArrayList<Monitor>
     */
    public void cambiarMonitores(ArrayList<Monitor> monitores) 
    {
        this.monitores = monitores;
    }

    /**
     * Retorna la lista de dependencias
     * @return dependencias
     */
    public ArrayList<Dependencia> darDependencias() 
    {
        return dependencias;
    }

    /**
     * Cambia la lista de dependencias por la nueva lista
     * @param dependencias ArrayList<Dependencia>
     */
    public void cambiarDependencias(ArrayList<Dependencia> dependencias) 
    {
        this.dependencias = dependencias;
    }

    /**
     * Retorna la lista de resultados
     * @return  resultados
     */
    public ArrayList<Resultado> darResultados() 
    {
        return resultados;
    }

    /**
     * Cambia la lista de resultados por la nueva lista
     * @param resultados ArrayList<Resultado>
     */
    public void cambiarResultados(ArrayList<Resultado> resultados) 
    {
        this.resultados = resultados;
    }

    /**
     * Retorna la lista de aspirantes
     * @return aspirantes ArrayList<Aspirante>
     */
    public ArrayList<Aspirante> darAspirantes() 
    {
        return aspirantes;
    }

    /**
     * Cambia la lista de aspirantes por la lista nueva
     * @param aspirantes ArrayList<Aspirante>
     */
    public void cambiarAspirantes(ArrayList<Aspirante> aspirantes) 
    {
        this.aspirantes = aspirantes;
    }

    /**
     * El metodo se encarga de registrar un aspirante en el sistema
     * <PostCondiciones> Se registro correctamente el aspirante al sistema 
     * @param primerNombre != null && != ""
     * @param segundoNombre
     * @param primerApellido != null && != ""
     * @param segundoApellido 
     * @param codigo != null && != ""
     * @param estadoMatricula != null && != ""
     * @param foto 
     * @param promedioAcumulado > 0 && <=5
     * @param semestreActual > 0 && <=10
     * @param identificacion != null && != ""
     * @throws Exception 
     */
    public void registrarAspirante(String primerNombre,String segundoNombre , String primerApellido, String segundoApellido, int codigo, String estadoMatricula, File foto, double promedioAcumulado, int semestreActual, String identificacion)throws Exception
    {
            Aspirante nuevo = buscarAspirante(identificacion );
            if( nuevo != null )
            {
                //throw new Exception("El Estudiante que desea registrar ya existe !!");
            }
            else{      
                nuevo= new Aspirante(primerNombre, segundoNombre, primerApellido, segundoApellido, codigo, estadoMatricula, foto, promedioAcumulado, semestreActual, identificacion);
                aspirantes.add( nuevo );
            }
    }
    
     /**
     * El metodo se encarga de modificar un aspirante en el sistema
     * <PostCondiciones> Se modifico correctamente el usuario al sistema 
     * @param primerNombre!= null && != ""
     * @param segundoNombre
     * @param primerApellido != null && != ""
     * @param segundoApellido
     * @param identificacion != null && != ""
     * @param foto
     * @param semestre > 0 && <=10
     * @param promedioAcum > 0 && <= 5
     * @throws Exception 
     */
    public void modificarAspirante(String primerNombre,String segundoNombre , String primerApellido, String segundoApellido, String identificacion, File foto, int semestre, double promedioAcum  ) throws Exception
    {
        Aspirante modificar = buscarAspirante(identificacion );
        if( modificar == null )
        {
            throw new Exception("El Estudiante que desea modificar no existe");
        }
        else
        {
            modificar.cambiarPrimerNombre(primerNombre);
            modificar.cambiarSegundoNombre(segundoNombre);
            modificar.cambiarPrimerApellido(primerApellido);  
            modificar.cambiarSegundoApellido(segundoApellido);  
            modificar.cambiarFoto(foto);
            modificar.cambiarPromedioAcumulado(promedioAcum);
            modificar.cambiarSemestreActual(semestre);                    

        }
    }
     /**
     * El metodo se encarga de modificar un Monitor en el sistema
     * <PostCondiciones> Se modifico correctamente el usuario en el sistema 
     * @param primerNombre!= null && != ""
     * @param segundoNombre
     * @param primerApellido != null && != ""
     * @param segundoApellido
     * @param identificacion != null && != ""
     * @param foto
     * @param semestre > 0 && <=10
     * @param promedioAcum > 0 && <= 5
     * @throws Exception 
     */
    public void modificarMonitor(String primerNombre,String segundoNombre , String primerApellido, String segundoApellido, String identificacion, File foto, int semestre, double promedioAcum  ) throws Exception
    {
        Monitor modificar = buscarMonitor(identificacion );
        if( modificar == null )
        {
            throw new Exception("El Estudiante que desea modificar no existe");
        }
        else
        {
            modificar.cambiarPrimerNombre(primerNombre);
            modificar.cambiarSegundoNombre(segundoNombre);
            modificar.cambiarPrimerApellido(primerApellido);  
            modificar.cambiarSegundoApellido(segundoApellido);  
            modificar.cambiarFoto(foto);
            modificar.cambiarPromedioAcumulado(promedioAcum);
            modificar.cambiarSemestreActual(semestre);                    

        }
    }
     /**
     * El metodo se encarga de registrar un monitor en el sistema
     * <PostCondiciones> Se registro correctamente el monitor al sistema 
     * @param primerNombre != null && != ""
     * @param segundoNombre
     * @param primerApellido != null && != ""
     * @param segundoApellido 
     * @param codigo != null && != ""
     * @param estadoMatricula != null && != ""
     * @param foto 
     * @param promedioAcumulado > 0 && <=5
     * @param semestreActual > 0 && <=10
     * @param identificacion != null && != ""
     * @throws Exception 
     */
    public void registrarMonitor(String primerNombre,String segundoNombre , String primerApellido, String segundoApellido, int codigo, String estadoMatricula, File foto, double promedioAcumulado, int semestreActual, String identificacion)throws Exception
    {
            Monitor nuevo = buscarMonitor(identificacion );
            if( nuevo != null )
            {
                //throw new Exception("El Estudiante que desea registrar ya existe !!");
            }
            else{      
                nuevo= new Monitor(primerNombre, segundoNombre, primerApellido, segundoApellido, codigo, estadoMatricula, foto, promedioAcumulado, semestreActual, identificacion);
                monitores.add( nuevo );
            }
    }
    /**
     * El metodo elimina un aspirante registrado en el sistema
     * @param identificacion != null && != ""
     */
    public void eliminarAspirante(String identificacion) throws Exception
    {
        Aspirante eliminar = buscarAspirante(identificacion );
            if( eliminar != null )
            {                   
                aspirantes.remove(eliminar);
            }
            else
            {
                throw new Exception("El Estudiante que desea eliminar no existe!!!");
            }		
    }
    /**
     * El metodo elimina un monitor registrado en el sistema
     * @param identificacion != null && != ""
     */
    public void eliminarMonitor(String identificacion) throws Exception
    {
        Monitor eliminar = buscarMonitor(identificacion );
            if( eliminar != null )
            {                   
                monitores.remove(eliminar);
            }
            else
            {
                throw new Exception("El Estudiante que desea eliminar no existe!!!");
            }		
    }
    
    /**
     * El metodo busca un aspirante dado su identificacion
     * @param identificacion != null && != ""
     * @return Aspirante
     */
    public Aspirante buscarAspirante(String identificacion)
    {
        Aspirante aspiranteBuscado = null;
        for (int i=0;i < aspirantes.size() ;i++ ) {
            aspiranteBuscado = aspirantes.get(i);
            if(aspiranteBuscado.darIdentificacion().equals(identificacion))
            {              
                return aspiranteBuscado;
            }
        }

        return null;
    }    
    
    
    /**
     * El metodo busca un monitor dado su identificacion
     * @param identificacion != null && != ""
     * @return Monitor
     */
    public Monitor buscarMonitor(String identificacion)
    {
        Monitor monitorBuscado = null;
        for (int i=0;i < monitores.size() ;i++ ) {
            monitorBuscado = monitores.get(i);
            if(monitorBuscado.darIdentificacion().equals(identificacion))
            {              
                return monitorBuscado;
            }
        }

        return null;
    }    

    /**
     * El metodo se encarga de agregar una Dependencia en el sistema
     * <PostCondiciones> Se agrego correctamente la Dependencia en el sistema 
     * @param nombre != null && != ""e
     * @param apellido != null && != ""
     * @param identificacion != null && != ""
     * @param foto != null
     * @param semestre > 0 && <=10
     * @param promedioAcum > 0 && <= 5
     */
    public void agregarDependencia(String nId, String nNombre, String nDescripcion, String nHorario)throws Exception
    {
            Dependencia buscarDep = buscarDependencia(nId);
            if( buscarDep != null )
            {
                //throw new Exception("La Dependencia que desea agregar ya existe !!");
            }
            else
            {
                Dependencia nuevaDependencia = new Dependencia( nId, nNombre, nDescripcion, nHorario);
                dependencias.add( nuevaDependencia );
            }
    }
    /**
     * Metodo que se encarga de eliminar una dependencia del sistema
     * @param codigo != null && !=""
     * @throws Exception 
     */
    public void eliminarDependencia(String codigo) throws Exception{
        
        Dependencia dependenciaEliminar= buscarDependencia(codigo);
        
        if(dependenciaEliminar==null){
            //throw new Exception("La Dependencia que desea buscar no existe !!");
        }
        else
            dependencias.remove(dependenciaEliminar);      
    }

    /**
    * Metodo que se encarga de buscar una dependencia segun su codigo si la encuentra la retorna 
    * en caso contrario retorna null
    * @param nId != null && != ""
    * @return Dependencia 
    */
    public Dependencia buscarDependencia(String nId)
    {       
        for(Dependencia dependenciaBuscada: dependencias ){
            if(dependenciaBuscada.darId().equals(nId)){
                return dependenciaBuscada;
            }
        }     
        return null;
    }  

    public void modificarDependencia(String nId, String nNombre, String nDescripcion, String nHorario) throws ExcepcionNoExiste{
        Dependencia dependenciaModificar= buscarDependencia(nId);
        if(dependenciaModificar==null){
            //throw  new ExcepcionNoExiste("La dependencia que desea");
        }
        else
        {
            dependenciaModificar.cambiarNombre(nNombre);
            dependenciaModificar.cambiarDescripcion(nDescripcion);
            dependenciaModificar.cambiarHorario(nHorario);
        }
    }
    
    
    public void agregarResultado(String id, String idEstudiante, int resultadoPrueba, int resultadoEntrevista){
        Resultado resultadoBuscado = buscarResultado(id);
       // if(resultadoBuscado=)
    }
    public Resultado buscarResultado(String identificacion){
        for(Resultado resultadoBuscado: resultados){
            if(resultadoBuscado.darIdEstudiante().equals(identificacion))
                return resultadoBuscado;
        }
        return null;
    }
    /**
     * Metodo para hacer pruebas
     * @param args 
     */
    public static void main(String[] args) 
    {                
        try {
            ContratacionMonitores cm = new ContratacionMonitores();   
            
            
            //Pruebas para Aspirante
            Aspirante a1 = new Aspirante("primerNombre","segundoNombre", "primerApellido","segundoApellido", 1, "estadoMatricula", null,1.0,1,"101");
            
            System.out.println(a1.toString());
            
            Aspirante a2 = new Aspirante("primerNombre2","segundoNombre2", "primerApellido2","segundoApellido2", 2, "estadoMatricula2", null,2.0,2,"102");
            System.out.println(a2.toString());
            
            //Pruebas para Monitor
            Monitor m1 = new Monitor("primerNombreM1","segundoNombreM1", "primerApellidoM1","segundoApellidoM1", 1, "estadoMatriculaM1", null,1.0,1,"101");
            System.out.println(m1.toString());
            Monitor m2 = new Monitor("primerNombreM2","segundoNombreM2", "primerApellidoM2","segundoApellidoM2", 2, "estadoMatriculaM2", null,1.0,1,"102");
            System.out.println(m2.toString());

            cm.registrarAspirante("primerNombre","segundoNombre", "primerApellido","segundoApellido", 1, "estadoMatricula", null,1.0,1,"101");
            cm.registrarAspirante("primerNombre2","segundoNombre2", "primerApellido2","segundoApellido2", 2, "estadoMatricula2", null,2.0,2,"102");
            cm.registrarAspirante("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"103");
            cm.registrarAspirante("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"103");
            
            

            //Pruebas para Dependencia
            cm.agregarDependencia("Cod1 ", "Dependencia 1", "Esta es la Dependencia 1", "Tarde");
            cm.agregarDependencia("Cod2 ", "Dependencia 2", "Esta es la Dependencia 2", "Mañana");
            cm.agregarDependencia("Cod3 ", "Dependencia 3", "Esta es la Dependencia 3", "Tarde");
            cm.agregarDependencia("Cod4 ", "Dependencia 4", "Esta es la Dependencia 4", "Mañana");
            for (Dependencia d : cm.darDependencias()) {                
                System.out.println("Dependencia: "+d.toString());
            }
            System.out.println("Numero Dependencias: "+cm.darDependencias().size());

            
        } catch (Exception ex) {          
            System.out.println("Error: "+ex.getMessage());
        }


    }

}
