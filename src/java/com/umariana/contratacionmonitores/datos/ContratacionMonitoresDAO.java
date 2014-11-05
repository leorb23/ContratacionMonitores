package com.umariana.contratacionmonitores.datos;

import com.umariana.contratacionmonitores.excepciones.ConnectionException;
import com.umariana.contratacionmonitores.excepciones.ExcepcionNoExiste;
import com.umariana.contratacionmonitores.excepciones.ExcepcionYaExiste;
import com.umariana.contratacionmonitores.logica.Administrador;
import com.umariana.contratacionmonitores.logica.Aspirante;
import com.umariana.contratacionmonitores.logica.Dependencia;
import com.umariana.contratacionmonitores.logica.Estudiante;
import com.umariana.contratacionmonitores.logica.Monitor;
import com.umariana.contratacionmonitores.logica.Resultado;
import com.umariana.contratacionmonitores.logica.dependencia.Horario;
import com.umariana.contratacionmonitores.logica.dependencia.Jornada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Es la clase principal del paquete DATOS que se encarga de manejar de manejar las Bases de Datos del Sistema
 * @author Andres
 */
public class ContratacionMonitoresDAO {
    
    // -----------------------------------------------------------------
    // ATRIBUTOS
    // -----------------------------------------------------------------   
    /**
     * Es la conexion con la Base de datos de estudiantes de la Univerisidad
     */
    private Connection conexionUniversidad;
    /**
     * Es la conexion con la Base de datos del Sistema Contratacion de Monitores
     */
    private Connection conexionContratacionMonitores;
    /**
     * Es el Statement que conecta con la Base de datos de estudiantes de la Univerisidad
     */
    private static Statement stBdUniversidad;
    /**
     * Es el Statement que conecta con la Base de datos del Sistema Contratacion de Monitores
     */
    private static Statement stBdContratacionMonitores;

    private AspiranteDAO aspiranteDAO;
    private MonitorDAO monitorDAO;
    private ResultadoDAO resultadoDAO;
    private DependenciaDAO dependenciaDAO;   
    private EstudianteUniversidadDAO estudianteUDAO;
    private AdministradorDAO adminDAO;
    private JornadaDAO jornadaDAO;
    private HorarioDAO horarioDAO;
    
    public boolean conectado;

    
    public ContratacionMonitoresDAO() {      
        aspiranteDAO = new AspiranteDAO();
        monitorDAO = new MonitorDAO();
        resultadoDAO = new ResultadoDAO();
        dependenciaDAO = new DependenciaDAO();
        adminDAO = new AdministradorDAO();
        estudianteUDAO = new EstudianteUniversidadDAO();  
        jornadaDAO = new  JornadaDAO();
        horarioDAO = new HorarioDAO();  
        conectado=false;
    }
    /**
     * Metodo que se encarga de realizar la conexion con la Base de Datos
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void conectarBdSistema() throws ConnectionException {
              
        try {
            String driver="org.postgresql.Driver";
            String conectionString="jdbc:postgresql";
            String bd="ContratacionMonitores";
            String usuario="postgres";
            String password="123";
            String servidor="localhost";//"192.168.0.13";//192.168.0.11
            int puerto=5432;
            //stBdSistema = null ;
            
            Class.forName(driver).newInstance();
            
            this.conexionContratacionMonitores = DriverManager.getConnection(conectionString+":"+"//"+servidor+":"+puerto+"/"+bd,usuario,password);
            
            this.stBdContratacionMonitores=(Statement)conexionContratacionMonitores.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            System.out.println("Conectado con la base de datos del sistema contratacion de monitores...");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            throw new ConnectionException("Error en la conexion "+ex);
        } 
    }
    /**
     * Metodo que se encarga de realizar la conexion con la Base de Datos
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void conectarBdUniversidad() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
              
        String driver="org.postgresql.Driver";
        String conectionString="jdbc:postgresql";
        String bd="EstudiantesUniversidad";
        String usuario="postgres";
        String password="123";
        String servidor="localhost";//"192.168.0.13";//192.168.0.11
        int puerto=5432;   
        
        Class.forName(driver).newInstance();

        this.conexionUniversidad = DriverManager.getConnection(conectionString+":"+"//"+servidor+":"+puerto+"/"+bd,usuario,password);

        this.stBdUniversidad=(Statement) conexionUniversidad.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        System.out.println("Conectado con la base de datos de estudiantes de la Universidad...");
    }
    
    
    /**
     * Metodo que se encarga de desconectar el sistema con la base de datos
     */
    public void desconectarBdContratacionMonitores(){
        try 
        {
            this.conexionContratacionMonitores.close();

            System.out.println("Desconectado con base de datos Contratacion Monitores...");
        } 
        catch (SQLException e) 
        {		
            System.out.println("Error al cerrar la conexion + "+e.toString());
        }
    }
    
    /**
     * Metodo que se encarga de desconectar el sistema con la base de datos
     */
    public void desconectarBdUniversidad(){
        try 
        {
            this.conexionUniversidad.close();

            System.out.println("Desconectado con base de datos estudiantes universidad...");
        } 
        catch (SQLException e) 
        {		
            System.out.println("Error al cerrar la conexion + "+e.toString());
        }
    }
    
    public Aspirante registrarAspiranteEnBD(String identificacion) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, ExcepcionYaExiste{
        
        //conectarBdUniversidad();
        
        Estudiante estudiante = estudianteUDAO.buscarEstudiante(identificacion);
        Aspirante encontrado = null;
        if(estudiante==null)
            throw new ExcepcionYaExiste("La identificacion no scorresponde a ningun estudiante");
        else
            encontrado = aspiranteDAO.resgistrarAspiranteEnBD(estudiante);           
        
        //desconectarBdUniversidad();

        return encontrado;    
    }
    
    public void actualizarAspiranteEnBD(Aspirante aspirante) throws SQLException{
        aspiranteDAO.actualizarAspirante(aspirante);
    }    
    public void eliminarAspiranteEnBD(String identificacion) throws SQLException{
        aspiranteDAO.eliminarAspirante(identificacion);
    }
    
    
    public Monitor registrarMonitorEnBD(Monitor monitor) throws SQLException, ExcepcionNoExiste, ExcepcionYaExiste{
        //conectarBdUniversidad();
        
        Aspirante aspirante = aspiranteDAO.buscarAspirante(monitor.darIdentificacion());
        Monitor encontrado = null;
        if(aspirante==null){
            encontrado=monitorDAO.buscarMonitor(monitor.darIdentificacion());
            if(encontrado!=null){
                throw new ExcepcionYaExiste("El estudiante ya ha sido registrado como monitor anteriormente");
            }
            else{
                throw new ExcepcionNoExiste("El estudiante no ha sido registrado como aspirante anteriormente");
            }
        }
        else{
            encontrado = monitorDAO.resgistrarMonitorEnBD(monitor);   
            aspiranteDAO.eliminarAspirante(aspirante.darIdentificacion());
        }
        
        //desconectarBdUniversidad();

        return encontrado;    
    }
    public void eliminarMonitorEnBD(String identificacion) throws SQLException{
        monitorDAO.eliminarMonitor(identificacion);
    }
    private void actualizarMonitorEnBD(Monitor monitor) throws SQLException {
        monitorDAO.actualizarMonitor(monitor);
    }
    
    
    public void registrarResultadoEnBD(){
        
    }
    
    
    
    
    public void eliminarResultadoEnBD(){
        
    }
    public boolean existeDependencia(String nombre) throws SQLException{
        return dependenciaDAO.existeDependencia(nombre);
    }
    public ArrayList<Jornada> darJornadasDependencia(int idDependencia) throws SQLException{
        ArrayList<Jornada> jornadas= jornadaDAO.listarJornadas(idDependencia);
        for(Jornada j :jornadas){
                ArrayList<Horario> horarios= darHorariosJornada(j.getId());
                j.setHorarios(horarios);
            }     
        return jornadas;
    }
    
    public ArrayList<Horario> darHorariosJornada(int idJornada) throws SQLException{
        return horarioDAO.listarHorarios(idJornada);
    }
    
    
    public Dependencia buscarDependencia(String nombre) throws SQLException{
        Dependencia buscada= dependenciaDAO.buscarDependencia(nombre);
        if(buscada!=null){
            buscada.cambiarJornadas(darJornadasDependencia(buscada.darId()));       
        }
        return buscada;
    }
    public void registrarDependenciaEnBD(Dependencia dependencia) throws  SQLException, ExcepcionYaExiste, ConnectionException{
        if(!dependenciaDAO.existeDependencia(dependencia.darNombre())){
            int idDependencia=dependenciaDAO.resgistrarDependenciaEnBD(dependencia);
            dependencia.cambiarId(idDependencia);
            /*for(Jornada jornada:dependencia.darJornadas()){
                jornada.setIdDependencia(idDependencia);
                int idJornada=jornadaDAO.resgistrarJornadaEnBD(jornada);
                for(Horario horario:jornada.getHorarios()){
                    horario.setIdJornada(idJornada);
                    horarioDAO.resgistrarHorarioEnBD(horario);              
                }     
            }  */
        }
        else
            throw  new ExcepcionYaExiste("La dependencia ( "+dependencia.darNombre()+" ) que desea agregar ya existe !!");
    }
    public void eliminarDependenciaEnBD( String nombre) throws SQLException{
        dependenciaDAO.eliminarDependencia(nombre);
    }
    public void actualizarDependenciaEnBd(Dependencia dependencia) throws SQLException, ExcepcionYaExiste{
        if(!dependenciaDAO.existeNombreDependencia(dependencia.darId(), dependencia.darNombre())){           
            dependenciaDAO.actualizarDependencia(dependencia);
            for(Jornada jornada:dependencia.darJornadas()){
                jornada.setIdDependencia(dependencia.darId());//temp
                jornadaDAO.actualizarJornadaEnBd(jornada);
                for(Horario horario:jornada.getHorarios()){
                   horario.setIdJornada(jornada.getId());//temp
                   horarioDAO.actualizarHorarioEnBd(horario);
                }     
            }  
        }
        else{
            throw  new ExcepcionYaExiste("El nombre de la dependencia ( "+dependencia.darNombre()+" ), que desea agregar ya existe!!");
        }
        
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
    
        return new ArrayList<Monitor>();
    }
    /**
     * Metodo que retorna la lista de Resultados que estan registrados en la base de datos del sistema
     * @return ArrayList<Resultado>
     */
    public ArrayList<Resultado> darResultadosRegistrados(){
    
        return new ArrayList<Resultado>();
    }
    /**
     * Metodo que retorna la lista de Dependenciaa que estan registradas en la base de datos del sistema
     * @return ArrayList<Dependencia>
     * @throws java.sql.SQLException
     * @throws com.umariana.contratacionmonitores.excepciones.ConnectionException
     */
    public ArrayList<Dependencia> darDependenciasRegistrados() throws SQLException, ConnectionException{
        ArrayList<Dependencia> dependencias = dependenciaDAO.listarDependencias();  
        for(Dependencia d:dependencias){
            d.cambiarJornadas(darJornadasDependencia(d.darId()));
//            ArrayList<Jornada> jornadas= jornadaDAO.listarJornadas(d.darId());
//            for(Jornada j :jornadas){
//                ArrayList<Horario> horarios= horarioDAO.listarHorarios(j.getId());
//                j.setHorarios(horarios);
//            }          
//            d.cambiarJornadas(jornadas);
        }
        return dependencias;
    }

    public Estudiante buscarEstudiante(String identificacion) throws SQLException {
        return estudianteUDAO.buscarEstudiante(identificacion); 
        
    }
    
    public Aspirante buscarAspirante(String identificacion) throws  SQLException {
        Aspirante aspirante = aspiranteDAO.buscarAspirante(identificacion); 
        if(aspirante!=null)
            return  aspirante;   
        /*else
            throw  new ExcepcionNoExiste("La identificación: "+ identificacion+" no corresponde a ningun aspirante");*/
        return null;
    }
    private Monitor buscarMonitor(String identificacion) throws SQLException {
         Monitor monitor = monitorDAO.buscarMonitor(identificacion); 
        if(monitor!=null)
            return  monitor;   
        /*else
            throw  new ExcepcionNoExiste("La identificación: "+ identificacion+" no corresponde a ningun aspirante");*/
        return null;
    }

    public Administrador buscarAdministrador(String usuario, String password) throws ExcepcionNoExiste {
        return adminDAO.buscarAdministrador(usuario, password);
    }
    
    public static Statement getStBdUniversidad() {
        return stBdUniversidad;
    }

    public static void setStBdUniversidad(Statement stBdUniversidad) {
        ContratacionMonitoresDAO.stBdUniversidad = stBdUniversidad;
    }

    public static Statement getStBdContratacionMonitores() {
        return stBdContratacionMonitores;
    }

    public static void setStBdContratacionMonitores(Statement stBdContratacionMonitores) {
        ContratacionMonitoresDAO.stBdContratacionMonitores = stBdContratacionMonitores;
    }

    public static void main(String[] args) 
    {
        try {
            ContratacionMonitoresDAO cm = new ContratacionMonitoresDAO();
            cm.conectarBdSistema();
            cm.conectarBdUniversidad();
 
           
 //           Estudiante estudiante1= new Estudiante("primerN", "segundoN", "pirmerA", "segundoA", 1, "1", null, 1.0, 8, "105");
//            Estudiante estudiante2= new Estudiante("primerN", "segundoN", "pirmerA", "segundoA", 2, "1", null, 5.0, 1, "102");
//            Estudiante estudiante3= new Estudiante("primerN", "segundoN", "pirmerA", "segundoA", 3, "1", null, 5.0, 8, "103");
//            Estudiante estudiante4= new Estudiante("primerN", "segundoN", "pirmerA", "segundoA", 4, "0", null, 2.0, 2, "104");

 //           cm.estudianteUDAO.registrarEstudiante(estudiante1);

//            Estudiante  estu=cm.buscarEstudiante("101");
//            System.out.println(estu.toString());
            
            
            
 //              Aspirante aspi = cm.registrarAspiranteEnBD("101");
//            System.out.println(aspi.toString());
            
//            Aspirante aspi= cm.buscarAspirante("102");
//            if(aspi!=null)
//                System.out.println(aspi.toString());
//            
//            aspi.cambiarPrimerNombre("nombreActualizado");
//            aspi.cambiarPrimerApellido("apellidoActualizado");
//            cm.actualizarAspiranteEnBD(aspi);
//            aspi= cm.buscarAspirante("102");
//            
//            if(aspi!=null)
//                System.out.println(aspi.toString());
            
//                Monitor nuevo = new Monitor("monitor4","segundoNombre3", "primerApellido3","segundoApellido3", 3, "1", null,3.0,3,"102",null,1);  
//                Monitor moni =cm.registrarMonitorEnBD( nuevo);
////
////            //cm.eliminarMonitorEnBD(nuevo.darIdentificacion());
////            
//           
//                moni   = cm.buscarMonitor("102");
//                moni.cambiarPrimerNombre("nombreActualizado2");
//                moni.cambiarPrimerApellido("apellidoActualizado2");
//                cm.actualizarMonitorEnBD(moni);
////            if(moni!=null)
//                System.out.println(moni.toString());
            
            //Dependencias
//            Dependencia nuevaDependencia = new Dependencia("NuevaActualizada ", "Es una nueva dependenciaActualizada");
//
//            List<Jornada> jornadas= new ArrayList();
//            List<Horario> horarios= new ArrayList();
//            Jornada nuevaJornada= new Jornada("Mañana1", 0, 15);
//                Horario nuevoHorario= new Horario(1, 1, 0, 2, 3,20);
//                horarios.add(nuevoHorario);
//                nuevoHorario= new Horario(1, 1, 0, 2, 2,21);
//                horarios.add(nuevoHorario);
//                nuevaJornada.setHorarios(horarios);
//                jornadas.add(nuevaJornada);
//            horarios= new ArrayList();
//            nuevaJornada= new Jornada("Tarde1", 0, 16);
//                nuevoHorario= new Horario(1, 1, 0, 1,1,22);
//                horarios.add(nuevoHorario);
//                nuevoHorario= new Horario(1, 1, 0, 1, 1,23);
//                horarios.add(nuevoHorario);
//                nuevaJornada.setHorarios(horarios);
//                jornadas.add(nuevaJornada);
//
//            nuevaDependencia.cambiarJornadas(jornadas);
//            nuevaDependencia.cambiarId(11);
//            
//            //cm.registrarDependenciaEnBD(nuevaDependencia);
//            //cm.eliminarDependenciaEnBD("Nueva");
//            //boolean n =cm.dependenciaDAO.existeDependencia("nuevaActualizada ");
//            cm.actualizarDependenciaEnBd(nuevaDependencia);
            
//            List<Dependencia> lista=cm.darDependenciasRegistrados();
//            for(Dependencia d:lista){
//                System.out.println(d.toString());
//                List<Jornada> jornadas= d.darJornadas();
//                for(Jornada j :jornadas){
//                    System.out.println("-----"+j.toString());
//                    List<Horario> horarios= j.getHorarios();
//                    for(Horario h:horarios){
//                         System.out.println("--------------"+h.toString());
//                    }
//                    
//                }          
//            }
//            
            
            //cerrar conexion
            cm.desconectarBdContratacionMonitores();
            cm.desconectarBdUniversidad();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Error : "+ex.getMessage());
        } catch (ConnectionException ex) {
            Logger.getLogger(ContratacionMonitoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    
}
