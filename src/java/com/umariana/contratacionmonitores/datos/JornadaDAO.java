package com.umariana.contratacionmonitores.datos;

import com.umariana.contratacionmonitores.logica.Aspirante;
import com.umariana.contratacionmonitores.logica.dependencia.Jornada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class JornadaDAO {
    private ResultSet rs;
    private final String tabla="jornada_dependencia";
    
    public int resgistrarJornadaEnBD(Jornada jornada) throws  SQLException  {
      
        rs = ContratacionMonitoresDAO.getStBdContratacionMonitores().executeQuery("insert into "+tabla+" (jornada,id_dependencia )values ('"+jornada.getJornada()+"','"+jornada.getIdDependencia()+"') returning id");
        int idJornada=0;
        while(rs.next()){
            idJornada=rs.getInt("id");
            return idJornada;
        }
        rs.close();
        return idJornada;
    }
    
    public void eliminarAspirante(String identificacion) throws SQLException{
        ContratacionMonitoresDAO.getStBdContratacionMonitores().executeUpdate("delete from "+tabla+" where identificacion ="+identificacion);
    }

    public Aspirante buscarAspirante(String identificacion) throws SQLException {
        rs=ContratacionMonitoresDAO.getStBdContratacionMonitores().
                executeQuery(" select * from "+tabla+" where identificacion ='"+identificacion+"'");       
        Aspirante buscado = null;
        while (rs.next())
        { 
            buscado = new Aspirante();
            buscado.cambiarIdentificacion(identificacion);
            buscado.cambiarPrimerNombre(rs.getString("nombre1"));
            buscado.cambiarSegundoNombre(rs.getString("nombre2"));
            buscado.cambiarPrimerApellido(rs.getString("apellido1"));
            buscado.cambiarSegundoApellido(rs.getString("apellido2"));
            buscado.cambiarSemestreActual(Integer.parseInt(rs.getString("semestre_actual")));
            buscado.cambiarEstadoMatricula(rs.getString("estado_matricula"));
            buscado.cambiarPromedioAcumulado(Double.parseDouble(rs.getString("promedio_acumulado")));	
            buscado.cambiarPromedioAcumulado(Integer.parseInt(rs.getString("puntaje_prueba")));
            buscado.cambiarPromedioAcumulado(Integer.parseInt(rs.getString("puntaje_entrevista")));	
            buscado.cambiarPromedioAcumulado(Double.parseDouble(rs.getString("puntaje_total")));
            buscado.cambiarFoto(null);
        }
        rs.close();
        return buscado;
    }

    void actualizarJornadaEnBd(Jornada jornada) throws SQLException {
       
         ContratacionMonitoresDAO.getStBdContratacionMonitores().executeUpdate("update "+tabla+" set jornada ='"+jornada.getJornada()+"' where id ="+jornada.getId());       
        
    }

    ArrayList<Jornada> listarJornadas(int idDependencia) throws SQLException {
        ArrayList<Jornada> jornadas= new ArrayList<>();
        rs = ContratacionMonitoresDAO.getStBdContratacionMonitores().executeQuery("select * from "+tabla+" where id_dependencia="+idDependencia);
        while(rs.next()){
            Jornada j=new Jornada();
            j.setId(rs.getInt("id"));
            j.setJornada(rs.getString("jornada"));
            j.setIdDependencia(rs.getInt("id_dependencia"));
            jornadas.add(j);
        }
        return jornadas;
    }

    
}
