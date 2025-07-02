/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Util.Validador;

/**
 *
 * @author apnil
 */
public class Alergia {
    private int IdAlergia;
    private String NombreAlergia;
    private String Severidad;
    private String TipoAlergia;

    public Alergia() {
    }
    
    public Alergia(int idAlergia) {
        this.IdAlergia = idAlergia;
    }

    public Alergia(String NombreAlergia, String Severidad, String TipoAlergia) {
        this.NombreAlergia = NombreAlergia;
        this.Severidad = Severidad;
        this.TipoAlergia = TipoAlergia;
    }

    public void setIdAlergia(int IdAlergia) {
        this.IdAlergia = IdAlergia;
    }

    public int getIdAlergia() {
        return IdAlergia;
    }
    
    public String getNombreAlergia() {
        return NombreAlergia;
    }
    
    public void setNombreAlergia(String NombreAlergia) {
        this.NombreAlergia = Validador.validarTexto(NombreAlergia, "El nombre de la alergia");
    }

    public String getSeveridad() {
        return Severidad;
    }

    public void setSeveridad(String severidad){
        this.Severidad = Validador.validarTextoPlaceHolder(severidad, "Ingrese descripción", "La severidad");
    }

    public String getTipoAlergia() {
        return TipoAlergia;
    }

    public void setTipoAlergia(String TipoAlergia) {
        this.TipoAlergia = Validador.validarTextoPlaceHolder(TipoAlergia, "Ingrese severidad", "La severidad");
    }
    
    public String verAlergia(){
        return this.NombreAlergia + "->  Severidad: " + this.Severidad + "|  Tipo: "  + this.TipoAlergia;
    }
}
