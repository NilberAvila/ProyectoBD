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
public class Receta {
    private int IdReceta;
    private Paciente paciente;
    private Doctor doctor;
    private String medicamentosDosis;
    private String recomendaciones;

    public Receta() {
        this.paciente = new Paciente();
        this.doctor = new Doctor();
    }
    
    public int getIdReceta() {
        return IdReceta;
    }

    public void setIdReceta(int idReceta) {
        this.IdReceta = idReceta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente)throws Exception{
        if (paciente == null) {
            throw new Exception("Ingrese correctamente el paciente");
        }
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor)throws Exception {
        if (paciente == null) {
            throw new Exception("Ingrese correctamente el doctor");
        }
        this.doctor = doctor;
    }

    public String getMedicamentosDosis() {
        return medicamentosDosis;
    }

    public void setMedicamentosDosis(String medicamentosDosis) {
        this.medicamentosDosis = Validador.validarTexto(medicamentosDosis, "Los mediamentos y dosis");
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = Validador.validarTexto(recomendaciones, "Las recomendaciones");
    }
}
