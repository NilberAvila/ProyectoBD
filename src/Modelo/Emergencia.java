/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author apnil
 */
public class Emergencia {
    private int idEmergencia;
    private Paciente pacienteSolicitante;
    private Doctor doctorSolicitado;
    private LocalDateTime FechaEmergencia;
    private String EspecialidadSolicitada;
    private int Prioridad;
    private boolean Estado;

    public Emergencia() {
        this.pacienteSolicitante = new Paciente();
        this.doctorSolicitado = new Doctor();
    }
    
    

    public int getIdEmergencia() {
        return idEmergencia;
    }

    public void setIdEmergencia(int idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public Paciente getPacienteSolicitante() {
        return pacienteSolicitante;
    }

    public void setPacienteSolicitante(Paciente pacienteSolicitante) {
        this.pacienteSolicitante = pacienteSolicitante;
    }

    public Doctor getDoctorSolicitado() {
        return doctorSolicitado;
    }

    public void setDoctorSolicitado(Doctor doctorSolicitado) {
        this.doctorSolicitado = doctorSolicitado;
    }

    public LocalDateTime getFechaEmergencia() {
        return FechaEmergencia;
    }

    public void setFechaEmergencia(LocalDateTime FechaEmergencia) {
        this.FechaEmergencia = FechaEmergencia;
    }

    public String getEspecialidadSolicitada() {
        return EspecialidadSolicitada;
    }

    public void setEspecialidadSolicitada(String EspecialidadSolicitada) {
        this.EspecialidadSolicitada = EspecialidadSolicitada;
    }


    public int getPrioridad() {
        return Prioridad;
    }
    
    public String getPrioridadString(){
        switch (Prioridad) {
            case 1:
                return "Alto";
            case 2:
                return "Medio";
            case 3:
                return "Bajo";
            default:
                return "";
        }
    }

    public void setPrioridad(int Prioridad) {
        if (Prioridad < 1 || Prioridad > 3) {
            throw new IllegalArgumentException("La prioridad debe ser 1 (Alta), 2 (Media) o 3 (Baja).");
        }
        this.Prioridad = Prioridad;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return Integer.toString(idEmergencia);
    }
    
    
}
