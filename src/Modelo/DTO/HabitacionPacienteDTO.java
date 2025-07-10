/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

/**
 *
 * @author apnil
 */
public class HabitacionPacienteDTO {
    private int habitacionID;
    private String nombreHabitacion;
    private int emergenciaID;
    private String nombrePaciente;

    public HabitacionPacienteDTO(int habitacionID, String nombreHabitacion, int emergenciaID, String nombrePaciente) {
        this.habitacionID = habitacionID;
        this.nombreHabitacion = nombreHabitacion;
        this.emergenciaID = emergenciaID;
        this.nombrePaciente = nombrePaciente;
    }

    public HabitacionPacienteDTO() {
    }

    public int getHabitacionID() {
        return habitacionID;
    }

    public void setHabitacionID(int habitacionID) {
        this.habitacionID = habitacionID;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public int getEmergenciaID() {
        return emergenciaID;
    }

    public void setEmergenciaID(int emergenciaID) {
        this.emergenciaID = emergenciaID;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @Override
    public String toString() {
        return nombreHabitacion;
    }
    
    
}
