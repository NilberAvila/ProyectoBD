/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

/**
 *
 * @author apnil
 */
public class EspecialidadBasicoDTO {
    private int idEspecialidad;
    private String Nombre;

    public EspecialidadBasicoDTO(int idEspecialidad, String Nombre) {
        this.idEspecialidad = idEspecialidad;
        this.Nombre = Nombre;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
