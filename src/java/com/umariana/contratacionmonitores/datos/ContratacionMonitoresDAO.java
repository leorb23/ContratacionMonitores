package com.umariana.contratacionmonitores.datos;

import com.umariana.contratacionmonitores.logica.Aspirante;
import com.umariana.contratacionmonitores.logica.Dependencia;
import com.umariana.contratacionmonitores.logica.Monitor;
import com.umariana.contratacionmonitores.logica.Resultado;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Es la clase principal del paquete DATOS que se encarga de manejar de manejar las Bases de Datos del Sistema
 * @author Andres
 */
public class ContratacionMonitoresDAO {
    
    // -----------------------------------------------------------------
    // ATRIBUTOS
    // -----------------------------------------------------------------
    /**
     * Es la base de datos
     */
    private String bd;
    /**
     * Modo de conexion
     */
    private String conectionString;
    /**
     * Es la conexion
     */
    private Connection conexion;
    /**
     * Es el driver de postgres
     */
    private String driver;
    /**
     * Es el usuario de la BD
     */
    private String usuario;
    /**
     * Es el password del usuario de la BD
     */
    private String password;
    /**
     * Es el puerto por el cual el servidor acepta las peticiones
     */
    private int puerto;
    /**
     * Es el servidor donde se alojan los datos
     */
    private String servidor;
    /**
     * Es el Statement
     */
    private Statement st;
    
    private AspiranteDAO aspiranteDAO;
    private MonitorDAO monitorDAO;
    private ResultadoDAO resultadoDAO;
    private DependenciaDAO dependenciaDAO;

    
    public ContratacionMonitoresDAO() {
        
        driver="org.postgresql.Driver";

        conectionString="jdbc:postgresql";

        bd="contratacionMonitores";

        usuario="postgres";

        password="123";

        servidor="";//"192.168.0.13";//192.168.0.11

        puerto=5432;   

        st = null ;

       // conectar();
        
        aspiranteDAO = new AspiranteDAO();
        monitorDAO = new MonitorDAO();
        resultadoDAO = new ResultadoDAO();
        dependenciaDAO = new DependenciaDAO();
        
    }
    /**
     * Metodo que se encarga de realizar la conexion con la Base de Datos
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void conectar() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        
        Class.forName(driver).newInstance();

        this.conexion = DriverManager.getConnection(conectionString+":"+"//"+servidor+":"+puerto+"/"+bd,usuario,password);

        this.st=(Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        System.out.println("Conectado...");
    }
    
    
    /**
     * Metodo que se encarga de desconectar el sistema con la base de datos
     */
    public void desconectar(){
        try 
        {
            this.conexion.close();

            System.out.println("Desconectado...");
        } 
        catch (SQLException e) 
        {		
            System.out.println("Error al cerrar la conexion + "+e.toString());
        }
    }
    
    public void registrarAspiranteEnBD(){
              
        //aD.resgistrarAspiranteEnBD();
        
    }
    public void actualizarAspiranteEnBD(){
        
    }    
    public void eliminarAspiranteEnBD(){
        
    }
    
    
    public void registrarMonitorEnBD(){
        
    }
    public void eliminarMonitorEnBD(){
        
    }
    public void registrarResultadoEnBD(){
        
    }
     public void eliminarResultadoEnBD(){
        
    }
    public void registrarDependenciaEnBD(){
        
    }
    public void eliminarDependenciaEnBD(){
        
    }
    
    /**
     * Metodo que retorna la lista de aspirantes que estan registrados en la base de datos del sistema
     * @return ArrayList<Aspirante>
     */
    public ArrayList<Aspirante> darAspirantesRegistrados(){
    
        return new ArrayList<Aspirante>();
    }
    /**
     * Metodo que retorna la lista de Monitores que estan registrados en la base de datos del sistema
     * @return ArrayList<Monitor>
     */
    public ArrayList<Monitor> darMonitoresRegistrados(){
    
        return null;
    }
    /**
     * Metodo que retorna la lista de Resultados que estan registrados en la base de datos del sistema
     * @return ArrayList<Resultado>
     */
    public ArrayList<Resultado> darResultadosRegistrados(){
    
        return null;
    }
    /**
     * Metodo que retorna la lista de Dependenciaa que estan registradas en la base de datos del sistema
     * @return ArrayList<Dependencia>
     */
    public ArrayList<Dependencia> darDependenciasRegistrados(){  
        return new ArrayList<Dependencia>();
    }
    
}
