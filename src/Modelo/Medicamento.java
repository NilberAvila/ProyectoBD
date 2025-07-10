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
public class Medicamento {
    private int medicamentosID;
    private String nombreMedicamento;
    private String concentracion;
    private String descripcion;

    public Medicamento() {
    }

    public Medicamento(int medicamentosID, String nombreMedicamento, String concentracion, String descripcion) {
        this.medicamentosID = medicamentosID;
        this.nombreMedicamento = nombreMedicamento;
        this.concentracion = concentracion;
        this.descripcion = descripcion;
    }
    
    public int getMedicamentosID() {
        return medicamentosID;
    }

    public void setMedicamentosID(int medicamentosID) {
        this.medicamentosID = medicamentosID;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = Validador.validarTextoPlaceHolder(nombreMedicamento, "Ingrese nombre del medicamento","El nombre del medicamento");
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = Validador.validarTextoPlaceHolder(concentracion,"Ingrese concentracion" ,"La concentración");
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = Validador.validarTextoPlaceHolder(descripcion,"Ingrese descripcion", "La descripcion");
    }

    @Override
    public String toString() {
        return nombreMedicamento;
    }
}
