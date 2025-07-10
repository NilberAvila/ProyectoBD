/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Alergia;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author apnil
 */
public class AlergiaDAO {
    public int agregarAlergia(Alergia alergia) throws SQLException {
        String sql = "INSERT INTO Alergias (TipoAlergia, Nombre, Descripcion) VALUES (?, ?, ?)";
        int idGenerado = -1;
        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(2, alergia.getNombreAlergia());
            stmt.setString(1, alergia.getTipoAlergia());
            stmt.setString(3, alergia.getDescripcion());
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
    public ArrayList<Alergia> ObtenerAlergias() throws SQLException {
        ArrayList<Alergia> lista = new ArrayList<>();
        String sql = "SELECT AlergiaID, Nombre, Descripcion, TipoAlergia FROM Alergias";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int IdAlergia = rs.getInt("AlergiaID");
                String nombre = rs.getString("Nombre");
                String descripcion = rs.getString("Descripcion");
                String tipo = rs.getString("TipoAlergia");

                Alergia alergia = new Alergia(IdAlergia, nombre, descripcion, tipo);
                lista.add(alergia);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener las alergias: " + e.getMessage());
        }

        return lista;
    }
}
