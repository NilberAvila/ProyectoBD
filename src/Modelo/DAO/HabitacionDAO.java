/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;
import Modelo.DTO.HabitacionPacienteDTO;
import Modelo.Habitaciones;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;



/**
 *
 * @author William
 */
public class HabitacionDAO {

    public ArrayList<Habitaciones> obtenerHabitacionesDisponibles() throws SQLException {
        ArrayList<Habitaciones> lista = new ArrayList<>();

        String sql = "SELECT HabitacionID, Nombre, Piso, Tipo, Estado FROM Habitaciones WHERE Estado = 0";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Habitaciones hab = new Habitaciones();
                hab.setHabitacionID(rs.getInt("HabitacionID"));
                hab.setNombre(rs.getString("Nombre"));
                hab.setPiso(rs.getInt("Piso")); // corregido
                hab.setTipo(rs.getString("Tipo"));
                hab.setEstado(rs.getInt("Estado"));
                lista.add(hab);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener habitaciones disponibles: " + e.getMessage());
        }

        return lista;
    }
    
//    public ArrayList<HabitacionPacienteDTO> obtenerPacientesEnHabitaciones() throws SQLException {
//        String sql = """
//            SELECT 
//                h.HabitacionID,
//                h.Nombre AS NombreHabitacion,
//                e.EmergenciaID,
//                p.Nombre + ' ' + p.ApellidoPaterno + ' ' + p.ApellidoMaterno AS NombrePaciente
//            FROM Habitaciones h
//            INNER JOIN AsignarHabitacion ah ON h.HabitacionID = ah.HabitacionID
//            INNER JOIN Emergencias e ON ah.EmergenciaID = e.EmergenciaID
//            INNER JOIN Pacientes p ON e.PacienteID = p.PacienteID
//            """;
//
//        ArrayList<HabitacionPacienteDTO> lista = new ArrayList<>();
//
//        try (Connection conn = Conexion.getConexion();
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                int idHab = rs.getInt("HabitacionID");
//                String nombreHab = rs.getString("NombreHabitacion");
//                int emergenciaID = rs.getInt("EmergenciaID");
//                String nombrePaciente = rs.getString("NombrePaciente");
//
//                lista.add(new HabitacionPacienteDTO(idHab, nombreHab, emergenciaID, nombrePaciente));
//            }
//
//        } catch (SQLException e) {
//            throw new SQLException("Error al obtener pacientes en habitaciones: " + e.getMessage());
//        }
//
//        return lista;
//    }

    public void asignarEmergenciaAHabitacion(int habitacionID, int emergenciaID, LocalDateTime fechaIngreso) throws SQLException {
        String sql = "{call AsignarEmergenciaAHabitacion(?, ?, ?, ?)}";

        try (Connection conn = Conexion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, habitacionID);
            stmt.setInt(2, emergenciaID);
            stmt.setTimestamp(3, Timestamp.valueOf(fechaIngreso));
            stmt.setNull(4, Types.TIMESTAMP);

            stmt.execute();

        } catch (SQLException e) {
            throw new SQLException("Error al asignar emergencia: " + e.getMessage());
        }
    }
    
    public void darAltaEmergencia(int emergenciaID, int habitacionID) throws SQLException {
        String sql = "{CALL DarAltaEmergencia(?, ?)}";

        try (Connection conn = Conexion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, emergenciaID);
            stmt.setInt(2, habitacionID);
            stmt.execute();

        } catch (SQLException e) {
            throw  new SQLException("Error al dar de alta la emergencia: " + e.getMessage());
        }
    }
    
    public ArrayList<HabitacionPacienteDTO> obtenerHabitacionesConPacientesActivos() throws SQLException {
        ArrayList<HabitacionPacienteDTO> lista = new ArrayList<>();

        String sql = """
            SELECT 
                h.HabitacionID,
                h.Nombre AS NombreHabitacion,
                e.EmergenciaID,
                p.Nombre + ' ' + p.ApellidoPaterno + ' ' + p.ApellidoMaterno AS NombrePaciente
            FROM Habitaciones h
            INNER JOIN AsignarHabitacion ah ON h.HabitacionID = ah.HabitacionID
            INNER JOIN Emergencias e ON ah.EmergenciaID = e.EmergenciaID
            INNER JOIN Pacientes p ON e.PacienteID = p.PacienteID
            WHERE ah.FechaSalida IS NULL
            ORDER BY h.HabitacionID;
        """;

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HabitacionPacienteDTO dto = new HabitacionPacienteDTO();
                dto.setHabitacionID(rs.getInt("HabitacionID"));
                dto.setNombreHabitacion(rs.getString("NombreHabitacion"));
                dto.setEmergenciaID(rs.getInt("EmergenciaID"));
                dto.setNombrePaciente(rs.getString("NombrePaciente"));
                lista.add(dto);
            }
        }

        return lista;
    }
}
