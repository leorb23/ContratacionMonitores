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
     * @param nombre != null && != ""
     * @param apellido != null && != ""
     * @param codigo != null && != ""
     * @param estadoMatri != null && != ""
     * @param foto != null
     * @param promedioAcum != null && != ""
     * @param semestreAct != null && != ""
     * @param identifi != null && != ""
     * @param puntajePru > 0 && <=10
     * @param puntajeEntre > 0 && <=10
     * @param puntajeProm > 0 && <=10
     */
    public void registrarEstudiante(String nombre, String apellido, int codigo, String estadoMatri, File foto, double promedioAcum, int semestreAct, String identifi, int puntajePru, int puntajeEntre, double puntajeProm )throws Exception
    {
            Monitor buscar = buscarEstudiante(identifi );
            if( buscar != null )
            {
                throw new Exception("El Estudiante que desea registrar ya existe !!");
            }
            else
            {
                Monitor nuevoMonitor = new Monitor( nombre, apellido, codigo, estadoMatri, foto, promedioAcum, semestreAct, identifi, puntajePru, puntajeEntre, puntajeProm);
                monitores.add( nuevoMonitor );
            }
    }


    /**
     * El metodo se encarga de modificar un monitor en el sistema
     * <PostCondiciones> Se modifico correctamente el usuario al sistema 
     * @param nombre != null && != ""
     * @param apellido != null && != ""
     * @param identificacion != null && != ""
     * @param foto != null
     * @param semestre > 0 && <=10
     * @param promedioAcum > 0 && <= 5
     */
    public void modificarEstudiante(String nombre, String apellido, String identificacion, File foto, int semestre, double promedioAcum  ) throws Exception
    {
            Monitor buscado = buscarEstudiante(identificacion );
            if( buscado == null )
            {
                throw new Exception("El Estudiante que desea modificar no existe");
            }
            else
            {
                buscado.setNombres(nombre);
                buscado.setApellidos(apellido);                    
                buscado.setFoto(foto);
                buscado.setPromedioAcumulado(promedioAcum);
                buscado.setSemestreActual(semestre);                    

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
            if(monitorBuscado.getIdentificacion().equals(identificacion))
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
            if(dependenciaBuscada.getId().equals(nId)){
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

            //Pruebas para Estudiante
            cm.registrarEstudiante("nombre", "apellido", 1, "estadoMatricula", null,4.5,5,"10853034",5  ,5 ,5.0);
            cm.registrarEstudiante("nombre", "apellido", 1, "estadoMatricula", null,4.5,5,"10853034",5  ,5 ,5.0);
        } catch (Exception ex) {          
            System.out.println("Error: "+ex.getMessage());
        }


    }

}
