/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author William
 */
public class TurnoDAO {
    public boolean ExisteTurnoDoctor(int IdDoctor,LocalTime HoraInicio,LocalTime HoraFin, List<DayOfWeek> DiaSelecionado) throws Exception{
         try {
            Connection con = Conexion.getConexion();
            
            String consulta = """
                              SELECT COUNT(*) 
                              FROM AsignacionTurno TD 
                              JOIN Turnos T ON T.TurnoID = TD.TurnoID 
                              WHERE TD.DoctorID = ? 
                                AND TD.NombreDia = ? 
                                AND (T.HoraInicio < CAST(? AS TIME) AND T.HoraFin > CAST(? AS TIME));
                              """;
            PreparedStatement pstmt = con.prepareStatement(consulta);
            for(DayOfWeek dia :DiaSelecionado){
                pstmt.setInt(1, IdDoctor);
                pstmt.setString(2, dia.name());
                pstmt.setTime(3, Time.valueOf(HoraFin));
                pstmt.setTime(4, Time.valueOf(HoraInicio));
                
                ResultSet rs = pstmt.executeQuery();
                if(rs.next() && rs.getInt(1)>0){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
             throw new Exception("Error al verificar los turnos del doctor: "+e.getMessage());
        }
       
    }
    
}
