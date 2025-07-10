/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Usuario;
import Modelo.DTO.IdentidadUsuarioDTO;
import Modelo.DTO.UsuarioDTO;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class UsuarioDAO {
    
    public IdentidadUsuarioDTO validarLogin(UsuarioDTO usuario)throws SQLException {
        IdentidadUsuarioDTO user = null;
        String consulta = """
                          EXEC ObtenerRol @NombreUsuario = ?, @Contraseña = ?
                          """;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContraseña());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new IdentidadUsuarioDTO();
                user.setIdUsuario(rs.getInt("UsuarioID"));
                user.setRol(rs.getString("Rol"));
            }
        } catch (SQLException e) {
            throw new SQLException("Error durante la validacion: " + e.getMessage());
        }
        return user;
    }
    
    public int obtenerIdDoctor(int idUsuario)throws SQLException{
        int idDoc = 0;
        String consulta = """
                          SELECT DoctorID FROM Doctores WHERE UsuarioID = ?;
                          """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)){
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                idDoc = rs.getInt("DoctorID");
            }
        }catch(SQLException e){
            throw new SQLException("Error al identificar al propietario de la cuenta");
        }
        return idDoc;
    }
    
    public int[] obtenerIdAdministrador(int idUsuario)throws SQLException{
        int[] datos = new int[2];
        String consulta = """
                          SELECT AdministradorID, NivelAcceso  
                          FROM Administradores
                          WHERE UsuarioID = ?;
                          """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)){
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                datos[0] = rs.getInt("AdministradorID");
                datos[1] = rs.getInt("NivelAcceso");
            }
        }catch(SQLException e){
            throw new SQLException("Error al identificar al propietario de la cuenta");
        }
        return datos;
    }
    
    public int RegistrarUser(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO Usuarios (NombreUsuario, Contraseña, Rol) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContraseña());
            pstmt.setString(3, usuario.getRol());
            
            int filas = pstmt.executeUpdate();
            
            if(filas > 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                
                if(rs.next()){
                    return rs.getInt(1);
                }           
            }                             
        } catch (SQLException e) {
            throw new SQLException("Error al validar login", e);
        }
        return -1;
    }

}
