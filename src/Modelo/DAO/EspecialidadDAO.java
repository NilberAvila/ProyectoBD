/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Especialidad;
import Modelo.DTO.EspecialidadBasicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author apnil
 */
public class EspecialidadDAO {
    public ArrayList<EspecialidadBasicoDTO> obtnerEspecialides()throws SQLException{
        ArrayList<EspecialidadBasicoDTO> especialidades = new ArrayList();
        String consulta = """
                          SELECT EspecialidadID, nombre
                          FROM Especialidad E
                          """;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                EspecialidadBasicoDTO esp = new EspecialidadBasicoDTO(rs.getInt("EspecialidadID"), rs.getString("nombre"));
                especialidades.add(esp);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener las especialidades: " + e.getMessage());
        }
        return especialidades;
    }
    public ArrayList<Especialidad> obtnerEspecialidesC()throws SQLException{
        ArrayList<Especialidad> especialidades = new ArrayList();
        String consulta = """
                          SELECT * FROM Especialidad E
                          """;
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Especialidad esp = new Especialidad(rs.getInt("EspecialidadID"), rs.getString("nombre"), rs.getString("descripcion"));
                especialidades.add(esp);
            }
        }catch(SQLException e){
            throw new SQLException("No se cargaron las especialdiades correctamente: " + e.getMessage());
        }
        return especialidades;
    }
    
    public void Agregar_Especialidades(Especialidad Especialidades)throws SQLException{
        String sql = "INSERT INTO Especialidad(nombre,descripcion) VALUES(?,?)";
        try {Connection conn = Conexion.getConexion();
            PreparedStatement Estmt = conn.prepareStatement(sql);
            Estmt.setString(1, Especialidades.getNombre());
            Estmt.setString(2, Especialidades.getDescripcion());
            Estmt.executeUpdate();       
        }
        catch(SQLException e){
            throw new SQLException("Error la insertar datos: "+e.getMessage());      
        }      
    } 
    
    public Especialidad BuscarEspecialidad(String nombreBuscado) throws SQLException{
         String sql = "SELECT * FROM Especialidad WHERE Nombre = ?";
        try {
            Connection conn = Conexion.getConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombreBuscado);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Especialidad esp = new Especialidad(rs.getInt("EspecialidadID"), rs.getString("nombre"), rs.getString("descripcion"));        
                return esp;
            } else {
                return null; // No se encontró
            }
        } catch (SQLException e) {
            throw new SQLException("Error al buscar especialidad: " + e.getMessage());
        }
    } 
    
    public void ActualizarEspecialidad(String Buscar, String NewNombre, String NewDescripcion) throws SQLException{
            try {
                String sql = "UPDATE Especialidad SET nombre = ?, descripcion = ? WHERE nombre = ?";
                Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, NewNombre);
                stmt.setString(2, NewDescripcion);
                stmt.setString(3, Buscar);
          
                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Especialidad actualizada correctamente.");
                } 
            } catch (SQLException e) {
                throw new SQLException("Error al actualizar especialidad: " + e.getMessage());
            }
    }
    
    public void EliminarEspecialidad(int IDEspecialdiad) throws SQLException{
            try {
                String sql = "DELETE FROM Especialidad WHERE EspecialidadID = ?";
                Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, IDEspecialdiad);         
                stmt.executeUpdate();      
                JOptionPane.showMessageDialog(null, "Especialidad eliminada correctamente.");
            
            } catch (SQLException e) {
                throw new SQLException("Error al actualizar especialidad: " + e.getMessage());
            }
    }
}
