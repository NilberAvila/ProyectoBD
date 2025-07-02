/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.DTO.HistorialMedicoDTO;
import Estructuras.ListaCircularDoble;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class AtencionDAO {
    
    public void Registrar( int idPaciente, int idDiagnostico, int idReceta)throws Exception{
        try {
            Connection con = Conexion.getConexion();
            String consulta = """
                INSERT INTO Atencion (PacienteID, DiagnosticoID, RecetaID, Fecha)
                VALUES (?, ?, ?, CAST(GETDATE() AS DATE))
            """;
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.setInt(1, idPaciente);
            pstmt.setInt(2, idDiagnostico);
            pstmt.setInt(3, idReceta);

            pstmt.executeUpdate();

            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al registrar los datos: " + e.getMessage());
        }
    }
    
    public ListaCircularDoble<HistorialMedicoDTO> ObtenerHistorial(int idPaciente) throws SQLException{
        ListaCircularDoble<HistorialMedicoDTO> historial = new ListaCircularDoble();
        String consulta = """
                          EXEC GenerarHistorialMedico @idPaciente = ?
                          """;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.setInt(1, idPaciente);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                HistorialMedicoDTO hist = new HistorialMedicoDTO();
                hist.setAtencionID(rs.getInt("AtencionID"));
                hist.setNombrePaciente(rs.getString("NombrePaciente"));
                hist.setNombreDoctor(rs.getString("NombreDoctor"));
                hist.setSintomas(rs.getString("Sintomas"));
                hist.setEnfermedadDiagnosticada(rs.getString("EnfermedadDiagnostica"));
                hist.setRecomendaciones(rs.getString("Recomendaciones"));
                hist.setMedicamentosDosis(rs.getString("MedicamentosDosis"));
                hist.setFecha(rs.getString("Fecha"));
                historial.agregarFinal(hist);
            }            
        } catch (SQLException e) {
            throw new SQLException("Error al obtener los datos del historial: " + e.getMessage());
        }
        return historial;
    }
}
