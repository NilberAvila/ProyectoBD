/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.DAO.HabitacionDAO;
import Modelo.DTO.HabitacionPacienteDTO;
import Modelo.Habitaciones;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class ControladorHabitacion {
   
    HabitacionDAO habitacionDAO;


    public ControladorHabitacion() {
        habitacionDAO = new HabitacionDAO();
    }
    
    public ArrayList<Habitaciones> HabitacionesDisponibles() throws Exception{
         return  habitacionDAO.obtenerHabitacionesDisponibles();
    }
    
//    public ArrayList<HabitacionPacienteDTO> obtenerPacientesEnHabitaciones() throws Exception{
//         return  habitacionDAO.obtenerPacientesEnHabitaciones();
//    }
    public void asignarEmergenciaAHabitacion(int HabitacionID, int EmergenciaID, LocalDateTime fechaingreso)throws Exception{
        habitacionDAO.asignarEmergenciaAHabitacion(HabitacionID, EmergenciaID, fechaingreso);
    }
    
    public void darAltaEmergencia(int emergenciaID, int habitacionID) throws Exception{
        habitacionDAO.darAltaEmergencia(emergenciaID, habitacionID);
    }
    
    public ArrayList<HabitacionPacienteDTO> obtenerHabitacionesConPacientesActivos() throws Exception{
        return habitacionDAO.obtenerHabitacionesConPacientesActivos();
    }
}
