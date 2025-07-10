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
public class ConsultaMedica {
    private int consultaMedicaID;
    private Cita cita;
    private Emergencia emergencia;
    private LocalDateTime fechaHoraAtencion;
    private String diagnostico;

    public ConsultaMedica() {
        this.cita = new Cita();
        this.emergencia = new Emergencia();
    }

    public int getConsultaMedicaID() {
        return consultaMedicaID;
    }

    public void setConsultaMedicaID(int consultaMedicaID) {
        this.consultaMedicaID = consultaMedicaID;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Emergencia getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(Emergencia emergencia) {
        this.emergencia = emergencia;
    }

    public LocalDateTime getFechaHoraAtencion() {
        return fechaHoraAtencion;
    }

    public void setFechaHoraAtencion(LocalDateTime fechaHoraAtencion) {
        this.fechaHoraAtencion = fechaHoraAtencion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
}

