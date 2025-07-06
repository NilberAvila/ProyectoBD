/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author apnil
 */
public class RecetaDAO {
    public int RegistrarReceta(Receta res, int IdDoctor, int idPaciente)throws Exception{
        int recetaId = -1;
        try {
            Connection con = Conexion.getConexion();
            String consulta = """
                                INSERT INTO Receta (PacienteID, DoctorID, MedicamentosDosis, Recomendaciones)
                                VALUES (?, ?, ?, ?)
                              """;
            PreparedStatement pstmt = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, idPaciente);
            pstmt.setInt(2, IdDoctor);
            pstmt.setString(3, res.getMedicamentosDosis());
            pstmt.setString(4, res.getRecomendaciones());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                recetaId = rs.getInt(1);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al registrar los datos de la receta");
        }
        return recetaId;
    }
}
