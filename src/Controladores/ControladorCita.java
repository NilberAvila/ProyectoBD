/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Cita;
import Modelo.DAO.CitaDAO;
import Modelo.Emergencia;
import java.sql.*;
import java.util.ArrayList;

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
    
    public ArrayList<Cita> obtenerCitasPendientesPorDoctor(int doctorID) throws Exception{
        return citaDAO.obtenerCitasPendientesPorDoctor(doctorID);
    }
    public int registraEmergencia(Emergencia emergencia) throws SQLException{
        return citaDAO.registraEmergencia(emergencia);
    }
    public ArrayList<Emergencia> obtenerEmergenciasPendientesPorDoctor(int doctorID) throws SQLException{
        return citaDAO.obtenerEmergenciasPendientesPorDoctor(doctorID);
    }
}
