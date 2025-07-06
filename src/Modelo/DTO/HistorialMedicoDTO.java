/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

import Modelo.Alergia;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class HistorialMedicoDTO {
    private String nombreDoctor;
    private String nombrePaciente;
    private ArrayList<Alergia> alergias;
    private int AtencionID;
    private String Fecha;
    private String Sintomas;
    private String EnfermedadDiagnosticada;
    private String Recomendaciones;
    private String MedicamentosDosis;

    public HistorialMedicoDTO() {
        this.alergias = new ArrayList();
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getAtencionID() {
        return AtencionID;
    }

    public void setAtencionID(int AtencionID) {
        this.AtencionID = AtencionID;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getSintomas() {
        return Sintomas;
    }

    public void setSintomas(String Sintomas) {
        this.Sintomas = Sintomas;
    }

    public String getEnfermedadDiagnosticada() {
        return EnfermedadDiagnosticada;
    }

    public void setEnfermedadDiagnosticada(String EnfermedadDiagnosticada) {
        this.EnfermedadDiagnosticada = EnfermedadDiagnosticada;
    }

    public String getRecomendaciones() {
        return Recomendaciones;
    }

    public void setRecomendaciones(String Recomendaciones) {
        this.Recomendaciones = Recomendaciones;
    }

    public String getMedicamentosDosis() {
        return MedicamentosDosis;
    }

    public void setMedicamentosDosis(String MedicamentosDosis) {
        this.MedicamentosDosis = MedicamentosDosis;
    }
    
    
    
}
