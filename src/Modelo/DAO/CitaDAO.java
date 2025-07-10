/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Cita;
import Modelo.Emergencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class CitaDAO {
    
    public void registrarCitaSinConflicto(Cita cita) throws SQLException {
        String sqlVerificar = """
                              SELECT 1
                              FROM Citas
                              WHERE DoctorID = ?
                                AND Estado = 0
                                AND DATEADD(MINUTE, 10, FechaHora) > ?
                                AND FechaHora < DATEADD(MINUTE, 10, ?)
                              """;

        String sqlInsertar = """
                             INSERT INTO Citas (DoctorID, PacienteID, FechaHora, EspecialidadSolicitada, Estado)
                             VALUES (?, ?, ?, ?, ?)
                             """;

        try (Connection con = Conexion.getConexion();
             PreparedStatement verificarStmt = con.prepareStatement(sqlVerificar)) {

            verificarStmt.setInt(1, cita.getDoctorSolicitado().getIdDoctor());
            verificarStmt.setTimestamp(2, Timestamp.valueOf(cita.getFechaHora()));
            verificarStmt.setTimestamp(3, Timestamp.valueOf(cita.getFechaHora()));

            ResultSet rs = verificarStmt.executeQuery();

            if (!rs.next()) {
                try (PreparedStatement insertarStmt = con.prepareStatement(sqlInsertar)) {
                    insertarStmt.setInt(1, cita.getDoctorSolicitado().getIdDoctor());
                    insertarStmt.setInt(2, cita.getPacienteSolicitante().getIdPaciente());
                    insertarStmt.setTimestamp(3, Timestamp.valueOf(cita.getFechaHora()));
                    insertarStmt.setString(4, cita.getEspecialidadSolicitada());
                    insertarStmt.setBoolean(5, false); // Estado 0 = pendiente
                    insertarStmt.executeUpdate();
                }
            } else {
                throw new SQLException("Cita ya registrada en ese bloque, intente en otra hora.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al registrar la cita: " + e.getMessage(), e);
        }
    }
    public ArrayList<Cita> obtenerCitasPendientesPorDoctor(int doctorID)throws SQLException {
        ArrayList<Cita> listaCitas = new ArrayList();

        String sql = """
                     SELECT C.CitaID, P.PacienteID,
                            CONCAT(P.Nombre, ' ', P.ApellidoPaterno, ' ', P.ApellidoMaterno) AS NombreCompletoPaciente,
                            C.FechaHora
                     FROM Citas C
                     JOIN Pacientes P ON C.PacienteID = P.PacienteID
                     WHERE C.Estado = 0 AND C.DoctorID = ?
                     ORDER BY C.FechaHora ASC
                    """;

        try (Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, doctorID);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int citaID = rs.getInt("CitaID");
                    int pacienteID = rs.getInt("PacienteID");
                    String nombreCompleto = rs.getString("NombreCompletoPaciente");
                    LocalDateTime fechaHora = rs.getTimestamp("FechaHora").toLocalDateTime();

                    Cita cita = new Cita(citaID, fechaHora);
                    cita.getPacienteSolicitante().setIdPaciente(pacienteID);
                    cita.getPacienteSolicitante().setNombre(nombreCompleto);
                    listaCitas.add(cita);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener las citas: " + e.getMessage());
        }
        return listaCitas;
    }
    public int registraEmergencia(Emergencia emergencia) throws SQLException {
        String sql = "INSERT INTO Emergencias (DoctorID, PacienteID, FechaEmergencia, EspecialidadSolicitada, Prioridad) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, emergencia.getDoctorSolicitado().getIdDoctor());
            pstmt.setInt(2, emergencia.getPacienteSolicitante().getIdPaciente());
            pstmt.setTimestamp(3, Timestamp.valueOf(emergencia.getFechaEmergencia()));
            pstmt.setString(4, emergencia.getEspecialidadSolicitada());
            pstmt.setInt(5, emergencia.getPrioridad());

            int filasInsertadas = pstmt.executeUpdate();

            if (filasInsertadas > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        return idGenerado;
                    }
                }
            }
            throw new SQLException("No se pudo obtener el ID generado de la emergencia.");
        } catch (SQLException e) {
            throw new SQLException("Error al registrar la Emergencia: " + e.getMessage());
        }
    }
    public ArrayList<Emergencia> obtenerEmergenciasPendientesPorDoctor(int doctorID) throws SQLException {
        ArrayList<Emergencia> listaEmergencias = new ArrayList<>();

        String sql = """
                     SELECT E.EmergenciaID, P.PacienteID,
                            CONCAT(P.Nombre, ' ', P.ApellidoPaterno, ' ', P.ApellidoMaterno) AS NombreCompletoPaciente,
                            E.FechaEmergencia, E.EspecialidadSolicitada, E.Prioridad
                     FROM Emergencias E
                     JOIN Pacientes P ON E.PacienteID = P.PacienteID
                     WHERE E.Estado = 0 AND E.DoctorID = ?
                     ORDER BY E.Prioridad ASC, E.FechaEmergencia ASC
                     """;

        try (Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, doctorID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int emergenciaID = rs.getInt("EmergenciaID");
                int pacienteID = rs.getInt("PacienteID");
                String nombreCompleto = rs.getString("NombreCompletoPaciente");
                LocalDateTime fechaEmergencia = rs.getTimestamp("FechaEmergencia").toLocalDateTime();
                String especialidad = rs.getString("EspecialidadSolicitada");
                int prioridad = rs.getInt("Prioridad");
                Emergencia emergencia = new Emergencia();
                emergencia.setIdEmergencia(emergenciaID);
                emergencia.getPacienteSolicitante().setIdPaciente(pacienteID);
                emergencia.getPacienteSolicitante().setNombre(nombreCompleto);
                emergencia.setFechaEmergencia(fechaEmergencia);
                emergencia.setEspecialidadSolicitada(especialidad);
                emergencia.setPrioridad(prioridad);
                listaEmergencias.add(emergencia);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener las emergencias: " + e.getMessage());
        }

        return listaEmergencias;
    }
}
