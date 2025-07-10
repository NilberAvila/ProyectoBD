/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Util.Validador;
import java.time.LocalDateTime;

/**
 *
 * @author apnil
 */
public class Cita {
    private int idCita;
    private Paciente pacienteSolicitante;
    private Doctor doctorSolicitado;
    private LocalDateTime FechaHora;
    private String EspecialidadSolicitada;
    private String Motivo;
    private boolean Antendida;

    public Cita(int idCita, LocalDateTime FechaHora) {
        this.idCita = idCita;
        this.FechaHora = FechaHora;
        this.pacienteSolicitante = new Paciente();
        this.doctorSolicitado = new Doctor();
    }

    public Cita() {
        this.pacienteSolicitante = new Paciente();
        this.doctorSolicitado = new Doctor();
    }
    
    public Cita(LocalDateTime FechaHora, Paciente pacienteSolicitante, Doctor doctorSolicitado, String EspecialidadSolicitada, boolean Antendida) {
        this.FechaHora = FechaHora;
        this.pacienteSolicitante = pacienteSolicitante;
        this.doctorSolicitado = doctorSolicitado;
        this.EspecialidadSolicitada = EspecialidadSolicitada;
        this.Antendida = Antendida;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDateTime getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(LocalDateTime FechaHora) {
        this.FechaHora = Validador.validarFechaHoraNoPasada(FechaHora);
    }

    public Paciente getPacienteSolicitante() {
        return pacienteSolicitante;
    }

    public void setPacienteSolicitante(Paciente pacienteSolicitante)throws Exception {
        if (pacienteSolicitante == null) {
            throw new Exception("Ocurrio un error inesperado con el paciente");
        }
        this.pacienteSolicitante = pacienteSolicitante;
    }

    public Doctor getDoctorSolicitado() {
        return doctorSolicitado;
    }

    public void setDoctorSolicitado(Doctor doctorSolicitado)throws Exception {
        if (doctorSolicitado == null) {
            throw new Exception("Ocurrio un error inesperado con el paciente");
        }
        this.doctorSolicitado = doctorSolicitado;
    }

    public String getEspecialidadSolicitada() {
        return EspecialidadSolicitada;
    }

    public void setEspecialidadSolicitada(String EspecialidadSolicitada) {
        this.EspecialidadSolicitada = Validador.validarTexto(EspecialidadSolicitada, "La especialidad solicitada");
    }

    public boolean isAntendida() {
        return Antendida;
    }
    
    public String isAntendidaTexto() {
        return Antendida? "Atendida" : "Pendiente";
    }

    public void setAntendida(boolean Antendida) {
        this.Antendida = Antendida;
    }

    @Override
    public String toString() {
        return Integer.toString(idCita);
    }
    
    
}
