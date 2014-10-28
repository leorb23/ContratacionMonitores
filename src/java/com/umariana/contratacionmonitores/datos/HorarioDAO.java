package com.umariana.contratacionmonitores.datos;

import com.umariana.contratacionmonitores.logica.dependencia.Horario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class HorarioDAO {

    private ResultSet rs;
    private final String tabla="dependencia_horario";
    
    public int resgistrarHorarioEnBD(Horario horario) throws  SQLException  {
      
        rs = ContratacionMonitoresDAO.getStBdContratacionMonitores().executeQuery("insert into "+tabla+" (desde,hasta,id_jornada,cupos_disponibles,total_cupos)values ("+horario.getDesde()+","+horario.getHasta()+","+horario.getIdJornada()+","+horario.getCuposDisponibles()+","+horario.getTotalCupos()+") returning id");
        int idHorario=0;
        while(rs.next()){
            idHorario=rs.getInt("id");
            return idHorario;
        }
        rs.close();
        return idHorario;
    }

    void actualizarHorarioEnBd(Horario horario) throws SQLException {
        ContratacionMonitoresDAO.getStBdContratacionMonitores().executeUpdate("update "+tabla+" set desde="+horario.getDesde()+",hasta="+horario.getHasta()+",cupos_disponibles="+horario.getCuposDisponibles()+",total_cupos="+horario.getTotalCupos()+"where id ="+horario.getId());       
    }

    ArrayList<Horario> listarHorarios(int idJornada) throws SQLException {
        ArrayList<Horario> jornadas= new ArrayList<>();
        rs = ContratacionMonitoresDAO.getStBdContratacionMonitores().executeQuery("select * from "+tabla+" where id_jornada="+idJornada);
        while(rs.next()){
            Horario h=new Horario();
            h.setId(rs.getInt("id"));
            h.setHasta(rs.getInt("hasta"));
            h.setDesde(rs.getInt("desde"));
            h.setCuposDisponibles(rs.getInt("cupos_disponibles"));
            h.setTotalCupos(rs.getInt("total_cupos"));
            h.setIdJornada(rs.getInt("id_jornada"));
            jornadas.add(h);
        }
        return jornadas;
    }
}
