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
public class PacienteDetalleDTO {
    private String nombreCompleto;
    private int edad;
    private String genero;
    private String grupoSanguineo;
    private ArrayList<Alergia> alergias;

    public PacienteDetalleDTO() {
        this.alergias = new ArrayList();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public ArrayList<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<Alergia> alergias) {
        this.alergias = alergias;
    }
}
