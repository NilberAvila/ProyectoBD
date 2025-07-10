/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.GrupoSanguineo;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author apnil
 */
public class GrupoSanguienoDAO {
    public ArrayList<GrupoSanguineo> obtenerGruposSanguineos() throws SQLException {
    ArrayList<GrupoSanguineo> lista = new ArrayList<>();
    String sql = "SELECT * FROM GrupoSanguineo";

    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            GrupoSanguineo grupo = new GrupoSanguineo(
                rs.getInt("GrupoSanguineoID"),
                rs.getString("Tipo"),
                rs.getString("Nombre"),
                rs.getString("Descripcion")
            );
            lista.add(grupo);
        }

    } catch (SQLException e) {
        throw new SQLException("Error al obtener los grupos sanguíneos: " + e.getMessage(), e);
    }

    return lista;
}
}
