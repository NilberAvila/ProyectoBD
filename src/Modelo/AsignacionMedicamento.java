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
public class AsignacionMedicamento {
    private int asignacionMedicamentosID;
    private Receta receta;
    private Medicamento medicamento;
    private String dosis;
    private String frecuencia;
    private String duracion;
    
    public AsignacionMedicamento() {
        this.medicamento = new Medicamento();
        this.receta = new Receta();
    }

    public AsignacionMedicamento(int asignacionMedicamentosID, Receta receta, Medicamento medicamento, String dosis, String frecuencia, String duracion) {
        this.asignacionMedicamentosID = asignacionMedicamentosID;
        this.receta = receta;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
    }

    public int getAsignacionMedicamentosID() {
        return asignacionMedicamentosID;
    }

    public void setAsignacionMedicamentosID(int asignacionMedicamentosID) {
        this.asignacionMedicamentosID = asignacionMedicamentosID;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = Validador.validarTextoPlaceHolder(dosis, "Ejm: 500mg" , "La dosis");
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = Validador.validarTextoPlaceHolder(frecuencia, "Ejm: Cada 8 horas", "La frecuencia");
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = Validador.validarTextoPlaceHolder(duracion, "Ejm: 5 dias","La duracion");
    }

    @Override
    public String toString() {
        return medicamento.getNombreMedicamento()+ "  |  " + dosis + "  |  " + frecuencia + "  |  " + duracion;
    }
    
}
