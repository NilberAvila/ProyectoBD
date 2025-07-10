/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.ConsultaMedica;
import java.sql.*;
/**
 *
 * @author apnil
 */
public class ConsultaDAO {
    public int registrarConsulta(ConsultaMedica consulta) throws SQLException {
        String sql = "INSERT INTO ConsultasMedicas (CitaID, EmergenciaID, FechaHoraAtencion, Diagnostico) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            if (consulta.getCita() != null) {
                stmt.setInt(1, consulta.getCita().getIdCita());
                stmt.setNull(2, java.sql.Types.INTEGER);
            } else {
                stmt.setNull(1, java.sql.Types.INTEGER); 
                stmt.setInt(2, consulta.getEmergencia().getIdEmergencia());
            }

            stmt.setTimestamp(3, Timestamp.valueOf(consulta.getFechaHoraAtencion()));
            stmt.setString(4, consulta.getDiagnostico());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrió un error al registrar la consulta: " + e.getMessage());
        }

        return -1;
    }

}
