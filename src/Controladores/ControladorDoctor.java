/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;


import Modelo.Doctor;
import Modelo.Turno;
import Modelo.DAO.DoctorDAO;
import Modelo.DAO.PacienteDAO;
import Modelo.DTO.DoctorDTO;
import Modelo.DTO.DoctorSimpleDTO;
import Modelo.DTO.TurnoDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class ControladorDoctor {
    private final DoctorDAO doctorDAO;
    private final PacienteDAO pacienteDAO;
    
    public int Agregar_Doctor(Doctor doctor) throws Exception{
        return doctorDAO.Agregar_Doctor(doctor);
    }
    
    public ControladorDoctor() {
        this.doctorDAO = new DoctorDAO();
        this.pacienteDAO = new PacienteDAO();
    }

    public int obtenerCantidadCitasPendientes(int idDoctor) throws Exception {
        return doctorDAO.obtenerCantidadCitasPendientes(idDoctor);
    }

    public TurnoDTO obtenerTurnoActual(int idDoctor) throws Exception {
        return doctorDAO.obtenerTurnoActual(idDoctor);
    }

    public String obtenerNombreDoctor(int idDoctor) throws Exception {
        return doctorDAO.obtenerNombreDoctor(idDoctor);
    }

    public String obtenerNombreProximoPaciente(int idDoctor) throws Exception {
        return pacienteDAO.obtenerNombreProximoPaciente(idDoctor);
    }
    
    public DoctorDTO buscarDatosBasicosPorId(int idDoctor)throws Exception {
        return doctorDAO.buscarDatosBasicosPorId(idDoctor);
    }
    
    public void actualizarDatosDoctor(String correo, String telefono, String direccion, int idDoctor) throws Exception {
        doctorDAO.actualizarDatos(idDoctor, correo, telefono, direccion);
    }
    
    public ArrayList<DoctorSimpleDTO> DoctoresPorFechaHora(LocalDateTime fechaHora, String Especialidad)throws Exception{
        return doctorDAO.DoctoresPorFechaHora(fechaHora, Especialidad);
    }
    
    public void AsignarEspecialidad(int DoctorID,int EspecialidadID)throws Exception {
        doctorDAO.AsignarEspecialidad(DoctorID, EspecialidadID);
    }
    
    public void Asignar_Turnos(Turno turno, int DoctorID)throws Exception {
        doctorDAO.Asignar_Turnos(turno, DoctorID);
    }
    
    public ArrayList<DoctorSimpleDTO> ObtenerDoctor() throws Exception{
        return doctorDAO.ObtenerDoctor();
    }
}
