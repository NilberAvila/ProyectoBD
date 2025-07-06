/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Util.Validador;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class Doctor extends Persona{
    private int IdDoctor;
    private String CodigoColegiatura;
    private ArrayList<Especialidad> Especialidades;
    private ArrayList<Turno> Turnos;
    private Usuario user;

    public Doctor() {
        Especialidades = new ArrayList();
        Turnos = new ArrayList();
    }
    
//    public Doctor(int IdDoctor, String nombre, String apellidoPaterno, String apellidoMaterno, String numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion, String CodigoColegiatura) {
//        super(nombre, apellidoPaterno, apellidoMaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
//        this.IdDoctor = IdDoctor;
//        this.CodigoColegiatura = CodigoColegiatura;
//    }
   
    @Override
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, hoy);
        if (edad.getYears() < 25) {
            throw new IllegalArgumentException("Un doctor debe tener al menos 24 años de edad");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdDoctor() {
        return IdDoctor;
    }

    public void setIdDoctor(int IdDoctor) {
        this.IdDoctor = IdDoctor;
    }

    public String getCodigoColegiatura() {
        return CodigoColegiatura;
    }

    public void setCodigoColegiatura(String CodigoColegiatura) {
        this.CodigoColegiatura = Validador.validarTextoPlaceHolder(CodigoColegiatura,"Ingrese CMP" , "El codigo de colegiatura");
    }

    public ArrayList<Especialidad> getEspecialidades() {
        return Especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> Especialidades) {
        this.Especialidades = Especialidades;
    }

    public ArrayList<Turno> getTurnos() {
        return Turnos;
    }

    public void setTurnos(ArrayList<Turno> Turnos) {
        this.Turnos = Turnos;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void AgregarTuno(Turno turno) throws Exception {
        if (turno == null) throw new Exception("El turno no puede ser nulo.");
        this.Turnos.add(turno);
    }
}
