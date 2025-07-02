/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author apnil
 */
public class Especialidad {
    private int IdEspecialidad;
    private String Nombre;
    private String Descripcion;

    public Especialidad() {
    }

    public Especialidad(int IdEspecialidad, String Nombre, String Descripcion) {
        this.IdEspecialidad = IdEspecialidad;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public Especialidad(String Nombre, String Descripcion) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public Especialidad(int IdEspecialidad, String Nombre) {
        this.IdEspecialidad = IdEspecialidad;
        this.Nombre = Nombre;
    }

    public void setIdEspecialidad(int IdEspecialidad) {
        this.IdEspecialidad = IdEspecialidad;
    }

    public int getIdEspecialidad() {
        return IdEspecialidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre)throws Exception {
        if (Nombre == null || Nombre.isBlank()) {
            throw new Exception("El nombre de la especialidad no puede estar vacío.");
        }
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) throws Exception {
        if (Descripcion == null || Descripcion.isBlank()) {
            throw new Exception("La descripción de la especialidad no puede estar vacía.");
        }
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return  Nombre;
    }
    
    
}
