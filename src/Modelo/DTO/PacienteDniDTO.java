/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

/**
 *
 * @author apnil
 */
public class PacienteDniDTO {
    private int idPaciente;
    private String docIdentidad;
    private String nombreCompleto;

    public PacienteDniDTO(int idPaciente, String docIdentidad, String nombreCompleto) {
        this.idPaciente = idPaciente;
        this.docIdentidad = docIdentidad;
        this.nombreCompleto = nombreCompleto;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDocIdentidad() {
        return docIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
}
