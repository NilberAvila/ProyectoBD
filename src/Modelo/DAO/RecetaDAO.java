/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Receta;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class RecetaDAO {
    public int registrarReceta(Receta receta) throws SQLException {
        String sql = "INSERT INTO Recetas (ConsultaID, FechEmision, Observaciones) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, receta.getConsulta().getConsultaMedicaID());
            stmt.setDate(2, Date.valueOf(receta.getFechEmision()));
            stmt.setString(3, receta.getObservaciones());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al registrar la receta: " + e.getMessage());
        }
        return -1;
    }
}
