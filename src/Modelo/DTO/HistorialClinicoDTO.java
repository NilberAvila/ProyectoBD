/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

/**
 *
 * @author apnil
 */
public class HistorialClinicoDTO {
    private int consultaMedicaID;

    // Paciente
    private int pacienteID;
    private String nombreCompletoPaciente;
    private String telefono;
    private int edad;
    private String tipoSangre;

    // Atención
    private String tipoAtencion;
    private String especialidadSolicitada;

    // Doctor
    private int doctorID;
    private String nombreDoctor;

    // Consulta
    private java.sql.Timestamp fechaHoraAtencion;
    private String diagnostico;

    // Tratamiento
    private Integer tratamientoID;
    private String tipoTratamiento;
    private java.sql.Date fechaInicio;
    private java.sql.Date fechaFin;
    private String indicaciones;

    // Receta
    private Integer recetaID;
    private java.sql.Date fechEmision;
    private String observaciones;

    // Medicamentos (agrupados en cadena)
    private String medicamentos;

    // Getters y Setters

    public int getConsultaMedicaID() {
        return consultaMedicaID;
    }

    public void setConsultaMedicaID(int consultaMedicaID) {
        this.consultaMedicaID = consultaMedicaID;
    }

    public int getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    public String getNombreCompletoPaciente() {
        return nombreCompletoPaciente;
    }

    public void setNombreCompletoPaciente(String nombreCompletoPaciente) {
        this.nombreCompletoPaciente = nombreCompletoPaciente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getTipoAtencion() {
        return tipoAtencion;
    }

    public void setTipoAtencion(String tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    public String getEspecialidadSolicitada() {
        return especialidadSolicitada;
    }

    public void setEspecialidadSolicitada(String especialidadSolicitada) {
        this.especialidadSolicitada = especialidadSolicitada;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public java.sql.Timestamp getFechaHoraAtencion() {
        return fechaHoraAtencion;
    }

    public void setFechaHoraAtencion(java.sql.Timestamp fechaHoraAtencion) {
        this.fechaHoraAtencion = fechaHoraAtencion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Integer getTratamientoID() {
        return tratamientoID;
    }

    public void setTratamientoID(Integer tratamientoID) {
        this.tratamientoID = tratamientoID;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public java.sql.Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(java.sql.Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public java.sql.Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(java.sql.Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public Integer getRecetaID() {
        return recetaID;
    }

    public void setRecetaID(Integer recetaID) {
        this.recetaID = recetaID;
    }

    public java.sql.Date getFechEmision() {
        return fechEmision;
    }

    public void setFechEmision(java.sql.Date fechEmision) {
        this.fechEmision = fechEmision;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
}

