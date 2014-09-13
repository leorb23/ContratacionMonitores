package com.umariana.contratacionmonitores.app.logica;

import java.io.File;
import java.util.ArrayList;
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
	 * Es el monitor 
	 */
        private Monitor monitor;
         /**
	 * Es la dependencia
	 */
        private Dependencia dependencia;
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
		
	}
        
	//
	//METODOS
	//
	/**
	 * Retorna la lista de monitores
	 * @return monitores
	 */
	public ArrayList<Monitor> getMonitores() 
        {
            return monitores;
	}
        
	/**
	 * Cambia la lista de monitores por la nueva lista
	 * @param monitores ArrayList<Monitor>
	 */
	public void setMonitores(ArrayList<Monitor> monitores) 
        {
            this.monitores = monitores;
	}
        
	/**
	 * Retorna la lista de dependencias
	 * @return dependencias
	 */
	public ArrayList<Dependencia> getDependencias() 
        {
            return dependencias;
	}
        
	/**
	 * Cambia la lista de dependencias por la nueva lista
	 * @param dependencias ArrayList<Dependencia>
	 */
	public void setDependencias(ArrayList<Dependencia> dependencias) 
        {
            this.dependencias = dependencias;
	}
        
	/**
	 * Retorna la lista de resultados
	 * @return  resultados
	 */
	public ArrayList<Resultado> getResultados() 
        {
            return resultados;
	}
        
	/**
	 * Cambia la lista de resultados por la nueva lista
	 * @param resultados ArrayList<Resultado>
	 */
	public void setResultados(ArrayList<Resultado> resultados) 
        {
            this.resultados = resultados;
	}
        
        /**
         * Retorna la lista de aspirantes
         * @return aspirantes ArrayList<Aspirante>
         */
        public ArrayList<Aspirante> getAspirantes() 
        {
            return aspirantes;
        }
        
        /**
         * Cambia la lista de aspirantes por la lista nueva
         * @param aspirantes ArrayList<Aspirante>
         */
        public void setAspirantes(ArrayList<Aspirante> aspirantes) 
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
	public void modificarEstudiante(String nombre, String apellido, String identificacion, File foto, int semestre, double promedioAcum  )
        {
		
	}
        
        /**
         * El metodo elimina un monitor registrado en el sistema
         * @param identificacion != null && != ""
         */
        public void eliminarEstudiante(String identificacion)
        {
		
	}
        
        /**
         * El metodo busca un monitor dado su identificacion
         * @param identificacion != null && != ""
         */
        public Monitor buscarEstudiante(String identificacion)
        {
				Monitor monitorBuscado = null;
				for (int i=0;i<monitores.size() ;i++ ) {
					monitorBuscado=monitores.getIndex(i);
					if(monitorBuscado.getIdentificacion().equals(identificacion))
					{
						return monitorBuscado
					}
					monitorBuscado = null;
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
         * El metodo busca una Dependencia dado su id
         * @param id != null && != ""
         */
        public Dependencia buscarDependencia(String nId)
        {
		return null;
	}  
        
        /**
         * Metodo para hacer pruebas
         * @param args 
         */
	public static void main(String[] args) 
        {
		// TODO Auto-generated method stub

	}

}
