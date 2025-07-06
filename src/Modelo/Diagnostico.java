/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Util.Validador;

/**
 *
 * @author apnil
 */
public class Diagnostico {
    private int IdDiagnostico;
    private Paciente paciente;
    private Doctor doctor;
    private String sintomas;
    private String enfermedadDiagnosticada;
    
    public Diagnostico() {
    }

    public int getIdDiagnostico() {
        return IdDiagnostico;
    }

    public void setIdDiagnostico(int IdDiagnostico) {
        this.IdDiagnostico = IdDiagnostico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente)throws Exception{
        if (paciente == null) {
            throw new Exception("Debe asignar un Paciente");
        }
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor)throws Exception{
        if (doctor == null) {
            throw new Exception("Debe asignar un Doctor");
        }
        this.doctor = doctor;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = Validador.validarTexto(sintomas, "El sintoma");
    }

    public String getEnfermedadDiagnosticada() {
        return enfermedadDiagnosticada;
    }

    public void setEnfermedadDiagnosticada(String enfermedadDiagnosticada) {
        this.enfermedadDiagnosticada = Validador.validarTexto(enfermedadDiagnosticada, "La enfermedad diagnosticada");
    }
}
