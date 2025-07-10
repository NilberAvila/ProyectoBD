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
    private String Descripcion;
    private String TipoAlergia;

    public Alergia() {
    }
    
    public Alergia(int idAlergia) {
        this.IdAlergia = idAlergia;
    }

    public Alergia(int IdAlergia, String NombreAlergia, String Descripcion, String TipoAlergia) {
        this.IdAlergia = IdAlergia;
        this.NombreAlergia = NombreAlergia;
        this.Descripcion = Descripcion;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Validador.validarTexto(Descripcion, "El nombre de la alergia");;
    }

    public String getTipoAlergia() {
        return TipoAlergia;
    }

    public void setTipoAlergia(String TipoAlergia) {
        this.TipoAlergia = Validador.validarTextoPlaceHolder(TipoAlergia, "Ingrese severidad", "La severidad");
    }
    
    public String verAlergia(){
        return this.NombreAlergia + "->  Descripcion: " + this.Descripcion + "|  Tipo: "  + this.TipoAlergia;
    }

    @Override
    public String toString() {
        return NombreAlergia;
    }
}
