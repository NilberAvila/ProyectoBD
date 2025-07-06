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
    private String TipoAlergia;
    private String Descripcion;

    public Alergia() {
    }
    
    public Alergia(int idAlergia) {
        this.IdAlergia = idAlergia;
    }

    public Alergia(String NombreAlergia, String TipoAlergia, String Descripcion) {
        this.NombreAlergia = NombreAlergia;
        this.TipoAlergia = TipoAlergia;
        this.Descripcion = Descripcion;
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

    public String getTipoAlergia() {
        return TipoAlergia;
    }

    public void setTipoAlergia(String TipoAlergia) {
        this.TipoAlergia = Validador.validarTexto(TipoAlergia, "El tipo");
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Severidad) {
        this.Descripcion = Validador.validarTextoPlaceHolder(Severidad, "Ingrese la descripcion ", "La Descripcion ");
    }
    
    public String verAlergia(){
        return this.NombreAlergia + "->  Tipo: " + this.TipoAlergia + "    |    Descripcion: "  + this.Descripcion;
    }
}
