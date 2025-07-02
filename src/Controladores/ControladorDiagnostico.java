/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Diagnostico;
import Modelo.DAO.Conexion;
import java.sql.*;
/**
 *
 * @author apnil
 */
public class ControladorDiagnostico {
    public int RegistrarDiagnostico(Diagnostico diag, int IdDoctor, int idPaciente)throws Exception{
        int diagnosticoId = -1;
        try {
            Connection con = Conexion.getConexion();
            String consulta = """
                                INSERT INTO Diagnostico (PacienteID, DoctorID, Sintomas, EnfermedadDiagnostica)
                                VALUES (?, ?, ?, ?)
                              """;
            PreparedStatement pstmt = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, idPaciente);
            pstmt.setInt(2, IdDoctor);
            pstmt.setString(3, diag.getSintomas());
            pstmt.setString(4, diag.getEnfermedadDiagnosticada());
            pstmt.executeUpdate();
            ResultSet r2 = pstmt.getGeneratedKeys();
            if (r2.next()) {
                diagnosticoId = r2.getInt(1);
            }
            r2.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al registrar los datos del diagnóstico");
        }
        return diagnosticoId;
    }
}
