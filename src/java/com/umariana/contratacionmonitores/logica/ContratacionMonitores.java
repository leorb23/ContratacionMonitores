package com.umariana.contratacionmonitores.logica;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
* Es la clase principal del sistema Contratacion de Monitores
* @author CocoSoft
*
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

    //
    //CONSTRUCTOR
    //
    /**
     * Es el constructor de la clase Principal
     */
    public ContratacionMonitores()
    {
            aspirantes = new ArrayList<>();
            resultados = new ArrayList<Resultado>();
            monitores = new ArrayList<Monitor>();
            dependencias = new ArrayList<Dependencia>();                      
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
     * El metodo se encarga de registrar un estudiate en el sistema
     * <PostCondiciones> Se registro correctamente el estudiante al sistema 
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
    public void registrarEstudiante(String primerNombre,String segundoNombre , String primerApellido, String segundoApellido, int codigo, String estadoMatricula, File foto, double promedioAcumulado, int semestreActual, String identificacion)throws Exception
    {
            Monitor buscar = buscarEstudiante(identificacion );
            if( buscar != null )
            {
                throw new Exception("El Estudiante que desea registrar ya existe !!");
            }
            else
            {
                Monitor nuevoMonitor = new Monitor(primerNombre, segundoNombre, primerApellido, segundoApellido, codigo, estadoMatricula, foto, promedioAcumulado, semestreActual, identificacion);
                monitores.add( nuevoMonitor );
            }
    }
    
    /**
     * El metodo se encarga de modificar un monitor en el sistema
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
    public void modificarEstudiante(String primerNombre,String segundoNombre , String primerApellido, String segundoApellido, String identificacion, File foto, int semestre, double promedioAcum  ) throws Exception
    {
        Monitor buscado = buscarEstudiante(identificacion );
        if( buscado == null )
        {
            throw new Exception("El Estudiante que desea modificar no existe");
        }
        else
        {
            buscado.cambiarPrimerNombre(primerNombre);
            buscado.cambiarSegundoNombre(segundoNombre);
            buscado.cambiarPrimerApellido(primerApellido);  
            buscado.cambiarSegundoApellido(segundoApellido);  
            buscado.cambiarFoto(foto);
            buscado.cambiarPromedioAcumulado(promedioAcum);
            buscado.cambiarSemestreActual(semestre);                    

        }
    }

    /**
     * El metodo elimina un monitor registrado en el sistema
     * @param identificacion != null && != ""
     */
    public void eliminarEstudiante(String identificacion) throws Exception
    {
        Monitor buscar = buscarEstudiante(identificacion );
            if( buscar != null )
            {                   
                monitores.remove(buscar);
            }
            else
            {
                throw new Exception("El Estudiante que desea eliminar no existe!!!");
            }		
    }

    /**
     * El metodo busca un monitor dado su identificacion
     * @param identificacion != null && != ""
     */
    public Monitor buscarEstudiante(String identificacion)
    {
        Monitor monitorBuscado = null;
        for (int i=0;i < monitores.size() ;i++ ) {
            monitorBuscado = monitores.get(i);
            if(monitorBuscado.darIdentificacion().equals(identificacion))
            {
                i = monitores.size();
            }
        }

        return monitorBuscado;
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
                throw new Exception("La Dependencia que desea agregar ya existe !!");
            }
            else
            {
                Dependencia nuevaDependencia = new Dependencia( nId, nNombre, nDescripcion, nHorario);
                dependencias.add( nuevaDependencia );
            }
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

    /**
     * Metodo para hacer pruebas
     * @param args 
     */
    public static void main(String[] args) 
    {
        
           
        try {
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
            
            
            
            ContratacionMonitores cm = new ContratacionMonitores();   

            //Pruebas para Dependencia
            cm.agregarDependencia("Cod1 ", "Dependencia 1", "Esta es la Dependencia 1", "Tarde");
            cm.agregarDependencia("Cod2 ", "Dependencia 2", "Esta es la Dependencia 2", "Mañana");
            cm.agregarDependencia("Cod3 ", "Dependencia 3", "Esta es la Dependencia 3", "Tarde");
            cm.agregarDependencia("Cod4 ", "Dependencia 4", "Esta es la Dependencia 4", "Mañana");
            for (Dependencia d : cm.darDependencias()) {                
                System.out.println("Dependencia: "+d.toString());
            }
            System.out.println("Numero Dependencias: "+cm.darDependencias().size());

            //Pruebas para Monitor
            cm.registrarEstudiante("primerNombre","segundoNombre", "primerApellido","segundoApellido", 1, "estadoMatricula", null,1.0,1,"101");
            cm.registrarEstudiante("primerNombre2","segundoNombre2", "primerApellido2","segundoApellido2", 2, "estadoMatricula2", null,2.0,2,"102");
            cm.registrarEstudiante("primerNombre3","segundoNombre3", "primerApellido3","segundoApellido3", 3, "estadoMatricula3", null,3.0,3,"103");
        } catch (Exception ex) {          
            System.out.println("Error: "+ex.getMessage());
        }


    }

}
