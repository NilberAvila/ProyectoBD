/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Util.Validador;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class Paciente extends Persona{
    private int IdPaciente;
    private String grupoSanguineo;
    private ArrayList<Alergia> alergias;
    private ArrayList<Atencion> HistorialMedico;

    public Paciente()
    { 
        this.alergias = new ArrayList();
        this.HistorialMedico = new ArrayList();
    }

    public Paciente(String grupoSanguineo, String nombre, String apellidoPaterno, String apellidoMaterno, String numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        super(nombre, apellidoPaterno, apellidoMaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
        this.grupoSanguineo = grupoSanguineo;
        this.alergias = new ArrayList<>();
        this.HistorialMedico = new ArrayList<>();
    }
    
    public int getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(int IdPaciente) {
        this.IdPaciente = IdPaciente;
    }

    public ArrayList<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<Alergia> alergias) {
        this.alergias = alergias;
    }

    public ArrayList<Atencion> getHistorialMedico() {
        return HistorialMedico;
    }

    public void setHistorialMedico(ArrayList<Atencion> HistorialMedico) {
        this.HistorialMedico = HistorialMedico;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = Validador.validarTextoPlaceHolder(grupoSanguineo, "Ingrese el tipo de sangre", "El tipo de sangre");
    }    
    
    public void agregarAlergia(Alergia alergia) throws Exception {
        this.alergias.add(alergia);
    }
    
    public void agregarHistoriaMedico(Atencion atencion) throws Exception {
        this.HistorialMedico.add(atencion);
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
    }
    
}
