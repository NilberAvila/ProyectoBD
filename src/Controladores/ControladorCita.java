/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Cita;
import Modelo.DAO.CitaDAO;
import java.sql.*;

/**
 *
 * @author USUARIO
 */
public class ControladorCita {
    //corregir
     private CitaDAO citaDAO;
    public ControladorCita() {
        citaDAO = new CitaDAO();
    }
    
    public void registrarCitaSinConflicto(Cita cita) throws SQLException {
        citaDAO.registrarCitaSinConflicto(cita);
    } 
}
