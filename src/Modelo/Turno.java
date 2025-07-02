/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class Turno {
    private int idTurno;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private ArrayList<DayOfWeek> DiasPorSemana;

    public Turno() {
        DiasPorSemana = new ArrayList();
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio)throws Exception {
        if (horaInicio == null) {
            throw new Exception("La hora de inicio no puede ser nula.");
        }
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin)throws Exception {
        if (horaInicio == null) {
            throw new Exception("La hora de fin no puede ser nula.");
        }
        this.horaFin = horaFin;
    }

    public ArrayList<DayOfWeek> getDiasPorSemana() {
        return DiasPorSemana;
    }

    public void setDiasPorSemana(ArrayList<DayOfWeek> DiasPorSemana) {
        this.DiasPorSemana = DiasPorSemana;
    }

    public void agregarDia(DayOfWeek dia) throws Exception {
        if (dia == null){
            throw new Exception("El día no puede ser nulo.");
        }
        if (!DiasPorSemana.contains(dia)) {
            DiasPorSemana.add(dia);
        }
        else{
            throw new Exception("Turno del dia ya registrado");
        }
    }
}
