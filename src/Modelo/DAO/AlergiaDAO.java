/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Alergia;
import java.sql.*;
/**
 *
 * @author apnil
 */
public class AlergiaDAO {
    public int agregarAlergia(Alergia alergia) throws SQLException {
        String sql = "INSERT INTO Alergia (NombreAlergia, TipoAlergia, Severidad) VALUES (?, ?, ?)";
        int idGenerado = -1;
        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, alergia.getNombreAlergia());
            stmt.setString(2, alergia.getTipoAlergia());
            stmt.setString(3, alergia.getSeveridad());
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGenerado = rs.getInt(1);
                    }
                }
            } else {
                throw new SQLException("No se pudo insertar la alergia.");
            }
        }
        return idGenerado;
    }
    public void agregarRelacionPacienteAlergia(int pacienteID, int alergiaID) throws SQLException {
        String sql = "INSERT INTO Paciente_Alergia (PacienteID, AlergiaID) VALUES (?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, pacienteID);
            stmt.setInt(2, alergiaID);
            int filas = stmt.executeUpdate();
            if (filas == 0) {
                throw new SQLException("No se pudo asociar la alergia al paciente.");
            }
        }
    }
}
