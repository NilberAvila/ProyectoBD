/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.AsignacionMedicamento;
import Modelo.Medicamento;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author apnil
 */
public class MedicamentoDAO {
    
    public ArrayList<Medicamento> obtenerMedicamentos() throws SQLException {
        ArrayList<Medicamento> lista = new ArrayList<>();
        String sql = "SELECT MedicamentosID, NombreMedicamento, Concentracion, Descripcion FROM Medicamentos";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Medicamento m = new Medicamento(
                    rs.getInt("MedicamentosID"),
                    rs.getString("NombreMedicamento"),
                    rs.getString("Concentracion"),
                    rs.getString("Descripcion")
                );
                lista.add(m);
            }

        } catch (SQLException e) {
            throw new SQLException("Error al obtener los medicamentos: " + e.getMessage(), e);
        }
        return lista;
    }
    
    public int registrarAsignacionMedicamento(AsignacionMedicamento asignacion) throws SQLException {
        String sql = "INSERT INTO AsignacionMedicamentos (RecetaID, MedicamentosID, Dosis, Frecuencia, Duracion) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, asignacion.getReceta().getRecetaID());
            stmt.setInt(2, asignacion.getMedicamento().getMedicamentosID());
            stmt.setString(3, asignacion.getDosis());
            stmt.setString(4, asignacion.getFrecuencia());
            stmt.setString(5, asignacion.getDuracion());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al registrar la consulta");
        }
        return -1;
    }
    public int Agregar_Medicamento(Medicamento Medicamentos)throws SQLException{
        String sql = "{call CrearMedicamento (?,?,?,?)}";
        int IdMedicamento = -1;
        try {Connection conn = Conexion.getConexion();
            CallableStatement Estmt = conn.prepareCall(sql);
            Estmt.registerOutParameter(1, java.sql.Types.INTEGER);
            Estmt.setString(2, Medicamentos.getNombreMedicamento());
            Estmt.setString(3, Medicamentos.getDescripcion());
            Estmt.setString(4, Medicamentos.getConcentracion());
            Estmt.execute(); 
            IdMedicamento = Estmt.getInt(1);
        }
        catch(SQLException e){
            throw new SQLException("Error la insertar Medicamentos: "+e.getMessage());      
        }      
        return IdMedicamento;
    } 
}
