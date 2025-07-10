/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Util.Validador;
import java.time.LocalDate;
/**
 *
 * @author apnil
 */
public class Receta {
    private int recetaID;
    private ConsultaMedica consulta;
    private LocalDate fechEmision;
    private String observaciones;

    public Receta() {
        this.consulta = new ConsultaMedica();
    }

    public Receta(int recetaID, ConsultaMedica consulta, LocalDate fechEmision, String observaciones) {
        this.recetaID = recetaID;
        this.consulta = consulta;
        this.fechEmision = fechEmision;
        this.observaciones = observaciones;
    }

    public int getRecetaID() {
        return recetaID;
    }

    public void setRecetaID(int recetaID) {
        this.recetaID = recetaID;
    }

    public ConsultaMedica getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaMedica consulta) {
        this.consulta = consulta;
    }

    public LocalDate getFechEmision() {
        return fechEmision;
    }

    public void setFechEmision(LocalDate fechEmision) {
        this.fechEmision = fechEmision;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = Validador.validarTexto(observaciones, "Las observaciones");
    }
    
}
