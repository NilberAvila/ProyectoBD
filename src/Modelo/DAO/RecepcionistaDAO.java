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
        String sql = "EXEC RegistrarRecepcionistaUsuario @NombreUsuario = ?, @Contraseña = ?, @Nombre = ?, @ApellidoPaterno = ?, @ApellidoMaterno = ?, @NumeroDocumento = ?, @TipoDocumento = ?, @FechaNacimiento = ?, @Genero = ?, @Telefono = ?, @Correo = ?, @Direccion = ?";
        try {
            Connection conn = Conexion.getConexion();
            PreparedStatement Dstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Dstmt.setString(1, recepcionista.getUser().getNombreUsuario());
            Dstmt.setString(2, recepcionista.getUser().getContraseña());
            Dstmt.setString(3, recepcionista.getNombre());
            Dstmt.setString(4, recepcionista.getApellidoPaterno());
            Dstmt.setString(5, recepcionista.getApellidoMaterno());
            Dstmt.setString(6, recepcionista.getNumDoc());
            Dstmt.setString(7, recepcionista.getTipoDoc());
            Dstmt.setDate(8, java.sql.Date.valueOf(recepcionista.getFechaNacimiento()));
            Dstmt.setString(9, recepcionista.getGenero());
            Dstmt.setString(10, recepcionista.getTelefono());
            Dstmt.setString(11, recepcionista.getCorreo());
            Dstmt.setString(12, recepcionista.getDireccion());                    
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
