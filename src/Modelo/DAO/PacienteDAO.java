/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Alergia;
import Modelo.Paciente;
import java.sql.*;
import Modelo.DTO.PacienteDetalleDTO;
import Modelo.DTO.PacienteDniDTO;
import Modelo.GrupoSanguineo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author apnil
 */
public class PacienteDAO {
    
    public String obtenerNombreProximoPaciente(int idDoctor) throws SQLException {
        String query = """
                       SELECT TOP 1 
                           CONCAT(P.Nombre, ' ', P.ApellidoPaterno, ' ', P.ApellidoMaterno) AS Nombre
                       FROM Pacientes P
                       JOIN Citas C ON C.PacienteID = P.PacienteID
                       WHERE C.Estado = 0 AND C.DoctorID = ?
                       ORDER BY C.FechaHora ASC;
                       """;
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idDoctor);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("Nombre");
            } else {
                return "Sin pacientes";
            }
        }catch(SQLException e){
            throw new SQLException("No se pudo cargar el paciente en espera: " + e.getMessage());
        }
    }
//    public ArrayList<PacienteResumenDTO> obtenerPacientesEnEspera(int idDoctor) throws SQLException {
//        ArrayList<PacienteResumenDTO> pacientes = new ArrayList<>();
//        String sql = """
//                     SELECT 
//                         P.PacienteID,
//                         P.Nombre + ' ' + P.ApellidoPaterno + ' ' + P.ApellidoMaterno AS Nombre
//                     FROM Pacientes P
//                     JOIN Citas C ON P.PacienteID = C.PacienteID
//                     WHERE C.Estado = 0 AND C.DoctorID = ?
//                     """;
//        try {
//            Connection con = Conexion.getConexion();
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            pstmt.setInt(1, idDoctor);
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                pacientes.add(new PacienteResumenDTO(rs.getInt("PacienteID"), rs.getString("Nombre")));
//            }
//        } catch (SQLException e) {
//            throw new SQLException("Error al cargar los pacientes: " + e.getMessage());
//        }
//        return pacientes;
//    }
    
    public PacienteDetalleDTO pacientePorIdBasico(int idPaciente) throws Exception{
        JOptionPane.showMessageDialog(null, idPaciente);
        PacienteDetalleDTO pac = null;
        String sql = """
                     SELECT 
                         P.Nombre + ' ' + P.ApellidoPaterno + ' ' + P.ApellidoMaterno AS Paciente,
                         P.FechaNacimiento,
                         P.Genero,
                         GS.Nombre AS GrupoSanguineo
                     FROM Pacientes P
                     JOIN GrupoSanguineo GS ON GS.GrupoSanguineoID = P.GrupoSanguineo
                     WHERE P.PacienteID = ?
                     """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, idPaciente);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pac = new PacienteDetalleDTO();
                pac.setNombreCompleto(rs.getString("Paciente"));
                pac.setGrupoSanguineo(rs.getString("GrupoSanguineo"));
                LocalDate fechaNac = rs.getDate("FechaNacimiento").toLocalDate();
                pac.setEdad(Period.between(fechaNac, LocalDate.now()).getYears());
                pac.setGenero(rs.getString("Genero"));
                pac.setAlergias(obtenerAlergiasPaciente(idPaciente));
            }else {
                JOptionPane.showMessageDialog(null, "No se encontró el paciente con ID: " + idPaciente);
            }
        }
        return pac;
    }
    
    public ArrayList<Alergia> obtenerAlergiasPaciente(int idPaciente)throws Exception {
        ArrayList<Alergia> obAlergias = new ArrayList();
        String sql = """
                     SELECT A.AlergiaID, A.Nombre, A.TipoAlergia, A.Descripcion
                     FROM Alergias A
                     JOIN Paciente_Alergia PA ON PA.AlergiaID = A.AlergiaID
                     WHERE PA.PacienteID = ?
                     """;
        try (Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idPaciente);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Alergia alergia = new Alergia(rs.getInt("AlergiaID"));
                alergia.setNombreAlergia(rs.getString("Nombre"));
                alergia.setTipoAlergia(rs.getString("TipoAlergia"));
                alergia.setDescripcion(rs.getString("Descripcion"));
                obAlergias.add(alergia);
            }
        }
        return obAlergias;
    }
    
    public void citaAtendida(int idPaciente)throws Exception {
        String sql = """
                     UPDATE Citas
                     SET Estado = 1
                     WHERE PacienteID = ?
                     """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, idPaciente);
            pstmt.executeUpdate();
        }
    }
    
    public void emergenciaAtendida(int idPaciente) throws SQLException{
        String sql = """
                     UPDATE Emergencias
                     SET Estado = 1
                     WHERE EmergenciaID = ?;
                     """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, idPaciente);
            pstmt.executeUpdate();
        }
    }
    
    public String obtenerNombrePaciente(int IdPaciente)throws Exception{
        String doctor = "";
        String sql = """
                     SELECT 
                         P.Nombre + ' ' + P.ApellidoPaterno + ' ' + P.ApellidoMaterno AS Nombre
                     FROM Pacientes P
                     WHERE P.PacienteID = ?;
                     """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, IdPaciente);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                doctor = rs.getString("Nombre");
            }
        }
        return doctor;
    }
    
    public ArrayList<PacienteDniDTO> ObtenerPacientes()throws SQLException{
        ArrayList<PacienteDniDTO> pacientes = new ArrayList();
        String constulta = """
                        SELECT 
                            PacienteID, 
                            NumeroDocumento, 
                            Nombre + ' ' + ApellidoPaterno + ' ' + ApellidoMaterno AS Nombre
                        FROM Pacientes;
                        """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(constulta)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PacienteDniDTO pac = new PacienteDniDTO(rs.getInt("PacienteID"), rs.getString("NumeroDocumento") ,rs.getString("Nombre"));
                pacientes.add(pac);
            }
        }
        return pacientes;
    }
    
    public ArrayList<Paciente> obtenerPacientesDni() throws SQLException {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        String sql = """
                     SELECT 
                         p.PacienteID, 
                         p.Nombre, 
                         p.ApellidoPaterno, 
                         p.ApellidoMaterno, 
                         p.NumeroDocumento, 
                         p.TipoDocumento, 
                         p.FechaNacimiento, 
                         p.Genero, 
                         p.Telefono, 
                         p.Correo, 
                         p.Direccion, 
                         gs.GrupoSanguineoID,
                         gs.Tipo AS TipoSanguineo
                     FROM Pacientes p
                     INNER JOIN GrupoSanguineo gs ON p.GrupoSanguineo = gs.GrupoSanguineoID
                     WHERE p.Activo = 1;
                     """;

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                GrupoSanguineo grupo = new GrupoSanguineo(
                    rs.getInt("GrupoSanguineoID"),
                    rs.getString("TipoSanguineo")
                );
                Paciente paciente = new Paciente(
                    rs.getInt("PacienteID"),
                    rs.getString("Nombre"),
                    rs.getString("ApellidoPaterno"),
                    rs.getString("ApellidoMaterno"),
                    rs.getString("NumeroDocumento"),
                    rs.getString("TipoDocumento"),
                    rs.getString("Telefono"),
                    rs.getDate("FechaNacimiento").toLocalDate(),
                    rs.getString("Genero"),
                    rs.getString("Correo"),
                    rs.getString("Direccion"),
                    grupo
                );

                pacientes.add(paciente);
            }
        }

        return pacientes;
    }

    public int registrar_paciente(Paciente paciente) throws Exception {
        String sql = "{CALL RegistrarPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        int idPaciente;
        try (Connection con = Conexion.getConexion();
             CallableStatement stmt = con.prepareCall(sql)) {

            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellidoPaterno());
            stmt.setString(3, paciente.getApellidoMaterno());
            stmt.setString(4, paciente.getNumDoc());
            stmt.setString(5, paciente.getTipoDoc());
            stmt.setDate(6, Date.valueOf(paciente.getFechaNacimiento()));
            stmt.setString(7, paciente.getGenero());
            stmt.setString(8, paciente.getTelefono());
            stmt.setString(9, paciente.getCorreo());
            stmt.setString(10, paciente.getDireccion());
            stmt.setInt(11, paciente.getGrupoSanguineo().getGrupoSanguineoID());
            stmt.registerOutParameter(12, java.sql.Types.INTEGER);
            stmt.execute();
            idPaciente = stmt.getInt(12);
            return idPaciente;
        } catch (SQLException e) {
            if (e.getErrorCode() == 2627) {
                throw new SQLException("Error: El documento de identidad o el correo ya está registrado");
            } else {
                throw new SQLException("Error al registrar paciente: " + e.getMessage(), e);
            }
        }
    }
    
    
//    public int contarPacientes() throws Exception {
//        String sql = "SELECT COUNT(*) FROM Paciente";
//        try (Connection con = Conexion.getConexion();
//             PreparedStatement stmt = con.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//
//            if (rs.next()) {
//                return rs.getInt(1);
//            } else {
//                throw new Exception("No se pudo contar los pacientes.");
//            }
//        } catch (SQLException e) {
//            throw new Exception("Error al contar pacientes: " + e.getMessage());
//        }
//    }
    
    public void Eliminar(int idPaciente) throws SQLException{
        String consulta = """
                          UPDATE Pacientes SET Activo = 0 WHERE PacienteID = ?
                          """;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement(consulta);
            stmt.setInt(1, idPaciente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al establece inactivo al paciente: " + e.getMessage());
        }
    }
    
    public void ActualizarDatos(int idPaciente, String correo, String telefono, String direccion)throws SQLException {
        String consulta = """
                            UPDATE Pacientes
                            SET Telefono = ?, Correo = ?, Direccion = ?
                            WHERE PacienteID = ?
                          """;
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement(consulta);
            stmt.setString(1, telefono);
            stmt.setString(2, correo);
            stmt.setString(3, direccion);
            stmt.setInt(4, idPaciente);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new SQLException("Error al actualizar datos: " + e.getMessage());
        }
    }
//    public void AgregarAlergia(int idPaciente, Alergia alergia)throws SQLException {
//        String sql = "{CALL AgregarAlergiaAPaciente(?, ?, ?, ?)}";
//        try (Connection con = Conexion.getConexion();
//             PreparedStatement pstmt = con.prepareCall(sql)) {
//            pstmt.setInt(1, idPaciente);
//            pstmt.setString(2, alergia.getNombreAlergia());
//            pstmt.setString(3, alergia.getTipoAlergia());
//            pstmt.setString(4, alergia.getSeveridad());
//            pstmt.execute();
//        } catch (SQLException e) {
//            throw new SQLException("Error al agregar alergia al paciente: " + e.getMessage());
//        }
//    }
    public int obtenerCantidadPacientes()throws SQLException {
        String sql = "SELECT COUNT(*) AS TotalPacientes FROM Pacientes;";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("TotalPacientes");
            }

        } catch (SQLException e) {
            throw new SQLException("Error al obtener el total de pacientes: " + e.getMessage());
        }
        return 0;
    }
    public double obtenerEdadPromedioPacientes()throws SQLException {
        String sql = "SELECT AVG(DATEDIFF(YEAR, FechaNacimiento, GETDATE())) AS EdadPromedio FROM Pacientes";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble("EdadPromedio");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener el promedio de edad de pacientes: " + e.getMessage());
        }
        return 0.0;
    }
    
    public int[] obtenerPacientesActivosInactivos()throws SQLException {
        String sql = """
                     SELECT 
                         SUM(CASE WHEN Activo = 1 THEN 1 ELSE 0 END) AS Activos,
                         SUM(CASE WHEN Activo = 0 THEN 1 ELSE 0 END) AS Inactivos
                     FROM Pacientes;
                     """;

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int activos = rs.getInt("Activos");
                int inactivos = rs.getInt("Inactivos");
                return new int[]{activos, inactivos};
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener los pacientes activos: " + e.getMessage());
        }

        return new int[]{0, 0};
    }
    
}
