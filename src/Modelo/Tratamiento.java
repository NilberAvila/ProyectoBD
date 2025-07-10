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
public class Tratamiento {
    private int tratamientoID;
    private ConsultaMedica consulta;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String indicaciones;

    public Tratamiento() {
        consulta = new ConsultaMedica();
    }

    public int getTratamientoID() {
        return tratamientoID;
    }

    public void setTratamientoID(int tratamientoID) {
        this.tratamientoID = tratamientoID;
    }

    public ConsultaMedica getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaMedica consulta) {
        this.consulta = consulta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = Validador.validarTexto(tipo, "El tipo de Tratamiento");
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = Validador.validarFechaNoPasada(fechaInicio);
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = Validador.validarFechaNoPasada(fechaFin);
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = Validador.validarTexto(indicaciones, "Las indicaciones");
    }
    
    
}
