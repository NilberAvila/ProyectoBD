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
public class Atencion {// ay no va
    private int IdAtencion;
    private Diagnostico diagnostico;
    private Receta receta;
    private LocalDate fecha;

    public Atencion() {
        fecha = LocalDate.now();
    }
    
    public int getIdAtencion() {
        return IdAtencion;
    }
    
    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico)throws Exception{
        if (diagnostico == null) {
            throw new Exception("Ocurrio un error inesperado con el Diagnostico");
        }
        this.diagnostico = diagnostico;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) throws Exception {
        if (receta == null) {
            throw new Exception("Ocurrio un error inesperado con la Receta");
        }
        this.receta = receta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) throws Exception {
        this.fecha = Validador.validarFecha(fecha);
    } 
}
