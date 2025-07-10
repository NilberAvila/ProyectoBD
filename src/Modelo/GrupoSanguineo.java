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
public class GrupoSanguineo {
    private int grupoSanguineoID;
    private String tipo;
    private String nombre;
    private String descripcion;

    public GrupoSanguineo() {
    }

    public GrupoSanguineo(int grupoSanguineoID, String tipo, String nombre, String descripcion) {
        this.grupoSanguineoID = grupoSanguineoID;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public GrupoSanguineo(int grupoSanguineoID, String tipo) {
        this.grupoSanguineoID = grupoSanguineoID;
        this.tipo = tipo;
    }

    public int getGrupoSanguineoID() {
        return grupoSanguineoID;
    }

    public void setGrupoSanguineoID(int grupoSanguineoID) {
        this.grupoSanguineoID = grupoSanguineoID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = Validador.validarTexto(tipo, "El tipo sanguineo");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Validador.validarTexto(nombre, "El nombre");
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = Validador.validarTexto(descripcion,"La descripcion");
    }

    @Override
    public String toString() {
        return  nombre;
    }

}
