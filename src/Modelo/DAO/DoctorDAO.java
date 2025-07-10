/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Doctor;
import Modelo.Turno;
import java.sql.*;
import Modelo.DTO.DoctorDTO;
import Modelo.DTO.DoctorSimpleDTO;
import Modelo.DTO.EspecialidadDTO;
import Modelo.DTO.TurnoDTO;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
/**
 *
 * @author apnil
 */
public class DoctorDAO {
    public int obtenerCantidadCitasPendientes(int idDoctor) throws SQLException {
        String consulta = """
                       SELECT COUNT(*) AS Total
                       FROM Citas
                       WHERE Estado = 0 AND DoctorID = ?
                       """;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.setInt(1, idDoctor);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener la cantidad de citas pendientes: " + e.getMessage());
        }
    }

    public TurnoDTO obtenerTurnoActual(int idDoctor) throws SQLException {
        String consulta = """
                       SELECT 
                           T.HoraInicio,
                           T.HoraFin
                       FROM Doctores D
                       JOIN AsignacionTurno AT ON D.DoctorID = AT.DoctorID
                       JOIN Turnos T ON AT.TurnoID = T.TurnoID
                       WHERE D.DoctorID = ?
                         AND UPPER(AT.NombreDia) = UPPER(DATENAME(WEEKDAY, DATEADD(HOUR, -5, GETUTCDATE())))
                         AND CONVERT(TIME, DATEADD(HOUR, -5, GETUTCDATE())) 
                             BETWEEN T.HoraInicio AND T.HoraFin;
                       """;

        try (Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)) {
            pstmt.setInt(1, idDoctor);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                String inicio = sdf.format(rs.getTime("HoraInicio"));
                String fin = sdf.format(rs.getTime("HoraFin"));
                return new TurnoDTO(inicio, fin);
            } else {
                return new TurnoDTO("N/A", "N/A");
            }
        }
        catch (SQLException e) {
            throw new SQLException("Error al obtener el turno actual: " + e.getMessage());
        }
    }

    public String obtenerNombreDoctor(int idDoctor) throws SQLException {
        String consulta = """
                       SELECT 
                           Nombre + ' ' + ApellidoPaterno + ' ' + ApellidoMaterno AS Nombre
                       FROM Doctores
                       WHERE DoctorID = ?
                       """;
        try (Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)) {
            pstmt.setInt(1, idDoctor);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("Nombre");
            } else {
                return "Desconocido";
            }
        }
        catch(SQLException e) {
            throw new SQLException("Error al obtener los datos: " + e.getMessage());
        }
    }
    
    public DoctorDTO buscarDatosBasicosPorId(int idDoctor) throws SQLException {
        String consulta = """
                          SELECT D.DoctorID, D.Nombre, D.ApellidoPaterno, D.ApellidoMaterno, D.Genero, D.FechaNacimiento, D.Telefono, D.Correo, D.Direccion, D.CodigoColegiatura, D.NumeroDocumento
                          FROM Doctores D
                          WHERE D.DoctorID = ?
                          """;
        try (Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement(consulta)) {
            stmt.setInt(1, idDoctor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombreCompleto = rs.getString("Nombre") + " " + rs.getString("ApellidoPaterno") + " " + rs.getString("ApellidoMaterno");
                LocalDate fechaNac = rs.getDate("FechaNacimiento").toLocalDate();
                int edad = Period.between(fechaNac, LocalDate.now()).getYears();
                String genero = rs.getString("Genero");
                String correo = rs.getString("Correo");
                String direccion = rs.getString("Direccion");
                String telefono = rs.getString("Telefono");
                String codColegiatura = rs.getString("CodigoColegiatura");
                String numdoc = rs.getString("NumeroDocumento");
                ArrayList<EspecialidadDTO> especialidades = obtenerEspecialidadesNombres(idDoctor, con);
                
                DoctorDTO doc =  new DoctorDTO();
                doc.setNombreCompleto(nombreCompleto);
                doc.setEdad(edad);
                doc.setGenero(genero);
                doc.setCorreo(correo);
                doc.setDireccion(direccion);
                doc.setTelefono(telefono);
                doc.setCodigoColegiatura(codColegiatura);
                doc.setDocIdentidad(numdoc);
                doc.setEspecialidades(especialidades);
                return doc;
            }
        }catch (SQLException e) {
            throw new SQLException("Error al buscar los datos del doctor" + e.getMessage());
        }
        return null;
    }
    
    private ArrayList<EspecialidadDTO> obtenerEspecialidadesNombres(int idDoctor, Connection con) throws SQLException {
        ArrayList<EspecialidadDTO> especialidades = new ArrayList<>();
        String consulta = """
                     SELECT 
                         E.Nombre, 
                         E.Descripcion
                     FROM Especialidades E
                     JOIN AsigarEspecialidad AE ON AE.EspecialidadID = E.EspecialidadID
                     WHERE AE.DoctorID = ?
                     """;
        try (PreparedStatement stmt = con.prepareStatement(consulta)) {
            stmt.setInt(1, idDoctor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                especialidades.add(new EspecialidadDTO(nombre, descripcion));
            }
        }catch (SQLException e) {
            throw new SQLException("Error al obtener las especialidades: " + e.getMessage());
        }
        return especialidades;
    }

    public void actualizarDatos(int id, String correo, String telefono, String direccion) throws SQLException {
        String consulta = """
            UPDATE Doctores
            SET Telefono = ?, Correo = ?, Direccion = ?
            WHERE DoctorID = ?
        """;
        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(consulta)) {
            stmt.setString(1, telefono);
            stmt.setString(2, correo);
            stmt.setString(3, direccion);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new SQLException("Error al actualizar los datos: " + e.getMessage());
        }
    }
    
    public ArrayList<DoctorSimpleDTO> DoctoresPorFechaHora(LocalDateTime fechaHora, String Especialidad)throws SQLException{
        ArrayList<DoctorSimpleDTO> doctores = new ArrayList<>();
        String procedimiento = "EXEC ObtenerDoctoresPorFechaHoraYEspecialidad ?, ?, ?";
        try (Connection con = Conexion.getConexion();
            CallableStatement stmt = con.prepareCall(procedimiento)) {
            stmt.setDate(1, Date.valueOf(fechaHora.toLocalDate()));
            stmt.setTime(2, Time.valueOf(fechaHora.toLocalTime()));
            stmt.setString(3, Especialidad);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DoctorSimpleDTO doc = new DoctorSimpleDTO(rs.getInt("DoctorID"), rs.getString("nombres"));
                doctores.add(doc);
            }
        }catch (SQLException e){
            throw new SQLException("Error al mostrar los doctore" + e.getMessage());
        }
        return doctores;
    }
    
    public int Agregar_Doctor(Doctor doctor) throws SQLException {
        String sql = "{CALL RegistrarDoctorUsuario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Conexion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, doctor.getUser().getNombreUsuario());
            stmt.setString(2, doctor.getUser().getContraseña());
            stmt.setString(3, doctor.getNombre());
            stmt.setString(4, doctor.getApellidoPaterno());
            stmt.setString(5, doctor.getApellidoMaterno());
            stmt.setString(6, doctor.getNumDoc());
            stmt.setString(7, doctor.getTipoDoc());
            stmt.setDate(8, Date.valueOf(doctor.getFechaNacimiento()));
            stmt.setString(9, doctor.getGenero());
            stmt.setString(10, doctor.getTelefono());
            stmt.setString(11, doctor.getCorreo());
            stmt.setString(12, doctor.getDireccion());
            stmt.setString(13, doctor.getCodigoColegiatura());
            stmt.registerOutParameter(14, java.sql.Types.INTEGER); // DoctorID OUTPUT

            stmt.execute();

            return stmt.getInt(14); // Devolver el ID generado del doctor
        } catch (SQLException e) {
            if (e.getErrorCode() == 2627) {
                throw new SQLException("Error: El documento de identidad ya está registrado");
            } else {
                throw new SQLException("Error al registrar un nuevo Doctor: " + e.getMessage());
            }
        }
    }

    
    public void AsignarEspecialidad(int DoctorID,int EspecialidadID)throws Exception{
        String sql = "INSERT INTO AsigarEspecialidad (DoctorID, EspecialidadID) VALUES (?, ?)";
         try {Connection conn = Conexion.getConexion();
            PreparedStatement Estmt = conn.prepareStatement(sql);
            Estmt.setInt(1, DoctorID);
            Estmt.setInt(2, EspecialidadID);
            Estmt.executeUpdate();       
        }
        catch(SQLException e){
            throw new Exception("Error al relacionar ID: "+e.getMessage());      
        }      
    }
    
    public void Asignar_Turnos(Turno turno, int DoctorID)throws SQLException{
        String sql = "INSERT INTO Turnos (HoraInicio, HoraFin) VALUES (?, ?)";
        String SqlRelacion = "INSERT INTO AsignacionTurno (DoctorID, TurnoID, NombreDia) VALUES (?, ?, ?)";
        
        try {
            Connection conn = Conexion.getConexion();
            PreparedStatement Tstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            Tstmt.setTime(1, Time.valueOf(turno.getHoraInicio()));
            Tstmt.setTime(2, Time.valueOf(turno.getHoraFin()));                 
            Tstmt.executeUpdate();    
            ResultSet rs = Tstmt.getGeneratedKeys();
            int turnoID = -1;
            if(rs.next()){
                turnoID = rs.getInt(1);
            }

            for(DayOfWeek dia : turno.getDiasPorSemana()){
                PreparedStatement PsRelacion = conn.prepareStatement(SqlRelacion);
                PsRelacion.setInt(1, DoctorID);
                PsRelacion.setInt(2, turnoID);
                PsRelacion.setString(3, dia.toString());
                PsRelacion.executeUpdate();
            }
        }
        catch(SQLException e){
            throw new SQLException("Error al registrar turno de doctor: " + e.getMessage());      
        }    
    }
    public ArrayList<DoctorSimpleDTO> ObtenerDoctor() throws SQLException{
        ArrayList<DoctorSimpleDTO> ListaDoctor = new ArrayList();
        
        String sql = "SELECT DoctorID, Nombre + ' ' + ApellidoPaterno + ' ' + ApellidoMaterno AS Nombre FROM Doctores;";
        try {
            Connection conn = Conexion.getConexion();
            PreparedStatement Astmt = conn.prepareStatement(sql);
            ResultSet rs = Astmt.executeQuery();

            while(rs.next()){
                DoctorSimpleDTO doc = new DoctorSimpleDTO(rs.getInt("DoctorID"), rs.getString("Nombre"));
                ListaDoctor.add(doc);                                   
            }                                                                               
        }
        catch(SQLException e){
            throw  new SQLException("Error al obtener doctores:"+e.getMessage());
        }     
        return ListaDoctor;
    }
}
