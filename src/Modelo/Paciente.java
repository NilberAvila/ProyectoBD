/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class Paciente extends Persona{
    private int IdPaciente;
    private GrupoSanguineo grupoSanguineo;
    private ArrayList<Alergia> alergias;

    public Paciente()
    { 
        this.alergias = new ArrayList();
    }
    public Paciente(int idPaciente, String nombre, String apellidoPaterno, String apellidoMaterno,
                    String numDoc, String tipoDoc, String telefono,
                    LocalDate fechaNacimiento, String genero,
                    String correo, String direccion,
                    GrupoSanguineo grupoSanguineo) {
        super(nombre, apellidoPaterno, apellidoMaterno, numDoc, tipoDoc, telefono,
              fechaNacimiento, genero, correo, direccion);
        this.IdPaciente = idPaciente;
        this.grupoSanguineo = grupoSanguineo;
        this.alergias = new ArrayList<>(); // Inicializa lista vacía por defecto
    }
    
    public Paciente(String grupoSanguineo, String nombre, String apellidoPaterno, String apellidoMaterno, String numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        super(nombre, apellidoPaterno, apellidoMaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
        this.grupoSanguineo = new GrupoSanguineo();
        this.alergias = new ArrayList<>();
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

    public GrupoSanguineo getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(GrupoSanguineo grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    
    public void agregarAlergia(Alergia alergia) throws Exception {
        this.alergias.add(alergia);
    }
    

    @Override
    public String toString() {
        return this.nombre + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
    }
    
}
