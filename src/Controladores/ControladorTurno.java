/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.DAO.TurnoDAO;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author William
 */
public class ControladorTurno {
    private final TurnoDAO turnoDAO;

    public ControladorTurno() {
        turnoDAO = new TurnoDAO();
    }

   
    
    public boolean ExisteTurnoDoctor(int IdDoctor,LocalTime HoraInicio,LocalTime HoraFin, List<DayOfWeek> DiaSelecionado)throws Exception{
         return turnoDAO.ExisteTurnoDoctor(IdDoctor, HoraInicio, HoraFin, DiaSelecionado);
    }
    
}
