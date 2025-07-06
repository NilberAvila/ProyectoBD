/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.time.LocalDateTime;

/**
 *
 * @author apnil
 */
public class Emergencia {
    private int idCita;
    private LocalDateTime FechaEmergencia;
    private Paciente pacienteSolicitante;
    private Doctor doctorSolicitado;
    private String EspecialidadSolicitada;
    private String Motivo; //Agregar stters y gettesr y modficar la implementeacion 
    private int Prioridad;
    private boolean Estado;
    
}
