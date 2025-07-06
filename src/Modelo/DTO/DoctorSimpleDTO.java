/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

/**
 *
 * @author apnil
 */
public class DoctorSimpleDTO {
    private int idDoctor;
    private String Nombres;

    public DoctorSimpleDTO(int idDoctor, String Nombres) {
        this.idDoctor = idDoctor;
        this.Nombres = Nombres;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    @Override
    public String toString() {
        return Nombres;
    }
    
    
}
