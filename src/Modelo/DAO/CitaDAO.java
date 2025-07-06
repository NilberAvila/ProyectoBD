/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class CitaDAO {
    
    public void registrarCitaSinConflicto(Cita cita) throws SQLException {
        String sqlVerificar = """
            SELECT 1
            FROM Cita
            WHERE DoctorID = ?
              AND Estado = 'Pendiente'
              AND DATEADD(MINUTE, 10, FechaHora) > ?
              AND FechaHora < DATEADD(MINUTE, 10, ?)
        """;

        String sqlInsertar = """
            INSERT INTO Cita (DoctorID, PacienteID, FechaHora, EspecialidadSolicitada, Estado)
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
                    insertarStmt.setString(5, cita.isAntendidaTexto());
                    insertarStmt.executeUpdate();
                }
            }
            else{
                throw new SQLException("Cita ya registrada en ese bloque, intente en otra hora: ");
            }
        }
        catch (SQLException e){
            throw new SQLException("Error al registrar la cita: " + e.getMessage());
        }
    } 
}
