/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Tratamiento;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class TratamientoDAO {
    public int registrarTratamiento(Tratamiento tratamiento)throws SQLException{
        String sql = "INSERT INTO Tratamientos (ConsultaID, Tipo, FechaInicio, FechaFin, Indicaciones) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, tratamiento.getConsulta().getConsultaMedicaID());
            stmt.setString(2, tratamiento.getTipo());
            stmt.setDate(3, Date.valueOf(tratamiento.getFechaInicio()));
            stmt.setDate(4, Date.valueOf(tratamiento.getFechaFin()));
            stmt.setString(5, tratamiento.getIndicaciones());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // ID generado del tratamiento
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al registrar el tratamiento: " + e.getMessage());
        }
        return -1;
    }
}
