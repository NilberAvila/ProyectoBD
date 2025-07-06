/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author apnil
 */
public class Validador {
    
    public static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor;
    }
    
    public static String validarTextoPlaceHolder(String valor, String placeholder, String campo) {
        if (valor == null || valor.trim().isEmpty() || valor.equals(placeholder)) {
            throw new IllegalArgumentException( campo + " no puede estar vacío.");
        }
        return valor;
    }
    public static String validardocIdentidad(String doc, String placeholder) {
        if (doc.equals(placeholder)) {
            throw new IllegalArgumentException("El documento de indentidad no puede ir vacio");
        }
        if (doc.length() != 8 && doc.length() != 12) {
            throw new IllegalArgumentException("El documento de indentidad debe tener 8 o 20 digitos digitos.");
        }
        return doc;
    }
    public static String validarCorreo(String correo) {
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("Correo inválido.");
        }
        return correo;
    }
    public static LocalDate validarFecha(LocalDate fecha) {
        if (fecha == null || fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha inválida");
        }
        return fecha;
    }
    
    public static LocalDateTime validarFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null || fechaHora.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Fecha y hora inválida.");
        }
        return fechaHora;
    }
    public static LocalDateTime validarFechaHoraNoPasada(LocalDateTime fechaHora) {
        if (fechaHora == null || fechaHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se permiten fechas y horas pasadas.");
        }
    return fechaHora;
}
}
