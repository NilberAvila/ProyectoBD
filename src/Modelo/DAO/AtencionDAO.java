/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Estructuras.ListaCircularDoble;
import Modelo.DTO.HistorialClinicoDTO;
import java.sql.*;
/**
 *
 * @author apnil
 */
public class AtencionDAO {
    
    public ListaCircularDoble<HistorialClinicoDTO> obtenerHistorialPorPaciente(int pacienteID) throws SQLException {
        ListaCircularDoble<HistorialClinicoDTO> lista = new ListaCircularDoble<>();

        String sql = "SELECT * FROM HistorialClinicoAgrupado WHERE PacienteID = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pacienteID);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    HistorialClinicoDTO dto = new HistorialClinicoDTO();

                    dto.setConsultaMedicaID(rs.getInt("ConsultaMedicaID"));

                    // Paciente
                    dto.setPacienteID(rs.getInt("PacienteID"));
                    dto.setNombreCompletoPaciente(rs.getString("NombreCompletoPaciente"));
                    dto.setTelefono(rs.getString("Telefono"));
                    dto.setEdad(rs.getInt("Edad"));
                    dto.setTipoSangre(rs.getString("TipoSangre"));

                    // Atención
                    dto.setTipoAtencion(rs.getString("TipoAtencion"));
                    dto.setEspecialidadSolicitada(rs.getString("EspecialidadSolicitada"));

                    // Doctor
                    dto.setDoctorID(rs.getInt("DoctorID"));
                    dto.setNombreDoctor(rs.getString("NombreDoctor"));

                    // Consulta
                    dto.setFechaHoraAtencion(rs.getTimestamp("FechaHoraAtencion"));
                    dto.setDiagnostico(rs.getString("Diagnostico"));

                    // Tratamiento
                    dto.setTratamientoID(rs.getObject("TratamientoID") != null ? rs.getInt("TratamientoID") : null);
                    dto.setTipoTratamiento(rs.getString("TipoTratamiento"));
                    dto.setFechaInicio(rs.getDate("FechaInicio"));
                    dto.setFechaFin(rs.getDate("FechaFin"));
                    dto.setIndicaciones(rs.getString("Indicaciones"));

                    // Receta
                    dto.setRecetaID(rs.getObject("RecetaID") != null ? rs.getInt("RecetaID") : null);
                    dto.setFechEmision(rs.getDate("FechEmision"));
                    dto.setObservaciones(rs.getString("Observaciones"));

                    // Medicamentos
                    dto.setMedicamentos(rs.getString("Medicamentos"));

                    lista.agregarFinal(dto);
                }
            }

        } catch (SQLException ex) {
            throw new SQLException("Error al obtener historial del paciente ID " + pacienteID + ": " + ex.getMessage(), ex);
        }
        return lista;
    }
}
