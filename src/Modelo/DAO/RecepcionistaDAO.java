/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Recepcionista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author apnil
 */
public class RecepcionistaDAO {
    public void Agregar_Repcionista(Recepcionista recepcionista) throws SQLException{
        String sql = "INSERT INTO Recepcionista(Nombre,ApellidoPaterno,ApellidoMaterno,NumeroDocumento,TipoDocumento,FechaNacimiento,Genero,Telefono,Correo,Direccion,UsuarioID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = Conexion.getConexion();
            PreparedStatement Dstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Dstmt.setString(1, recepcionista.getNombre());
            Dstmt.setString(2, recepcionista.getApellidoPaterno());
            Dstmt.setString(3, recepcionista.getApellidoMaterno());
            Dstmt.setString(4, recepcionista.getNumDoc());
            Dstmt.setString(5, recepcionista.getTipoDoc());
            Dstmt.setDate(6, java.sql.Date.valueOf(recepcionista.getFechaNacimiento()));
            Dstmt.setString(7, recepcionista.getGenero());
            Dstmt.setString(8, recepcionista.getTelefono());
            Dstmt.setString(9, recepcionista.getCorreo());
            Dstmt.setString(10, recepcionista.getDireccion());                    
            Dstmt.setInt(11, recepcionista.getUser().getIdUsuario()); 
            Dstmt.executeUpdate();    
        }
        catch(SQLException e){
            if (e.getErrorCode() == 2627) {
                throw new SQLException("Error: El documento de indentidad ya está registrado");
            } else {
                throw new SQLException("Error al registrar al/a la recepcionista: " + e.getMessage());
            }     
        }    
    }   
}
