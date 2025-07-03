/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Util.Validador;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author USUARIO
 */
public abstract class Persona {
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String numDoc;
    protected String tipoDoc;
    protected String telefono;
    protected LocalDate fechaNacimiento;
    protected String genero;
    protected String correo;
    protected String direccion;

    public Persona() {
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numDoc = numDoc;
        this.tipoDoc = tipoDoc;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.correo = correo;
        this.direccion = direccion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Validador.validarTextoPlaceHolder(nombre, "Ingrese sus nombres", "El nombre");
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = Validador.validarTextoPlaceHolder(apellidoPaterno, "Ingrese su Apellido Paterno" ,"El apellido Paterno");
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = Validador.validarTextoPlaceHolder(apellidoMaterno, "Ingrese su Apellido Materno" ,"El apellido Paterno");
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = Validador.validardocIdentidad(numDoc, "Ingrese su doc. de indentidad");
        if (!numDoc.matches("\\d+")) {
            throw new IllegalArgumentException("El número de documento debe contener solo dígitos");
        }
        if (numDoc.matches("\\d{8}")) {
            this.tipoDoc = "DNI";
        } else if (numDoc.matches("\\d{20}")) {
            this.tipoDoc = "CE";
        } else {
            throw new IllegalArgumentException("Número de documento inválido: debe tener 8 dígitos (DNI) o 20 dígitos (CE)");
        }
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (!telefono.trim().matches("\\d+")) {
            throw new IllegalArgumentException("El número de teléfono debe contener solo numeros");
        }
        this.telefono = Validador.validarTextoPlaceHolder(telefono.trim(), "Ingrese su Numero de Telefono", "El numero de telefono");
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = Validador.validarFecha(fechaNacimiento);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = Validador.validarTexto(genero, "El genero");
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = Validador.validarCorreo(correo);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = Validador.validarTextoPlaceHolder(direccion, "Ingrese su Direccion" ,"La direccion");
    }
   
    public int verEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    
    public String verNombreCompleto(){
        return this.nombre + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
    }
}