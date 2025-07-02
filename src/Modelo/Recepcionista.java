/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author apnil
 */
public class Recepcionista extends Persona{
    
    private int IdRecepcionista;
    private Usuario user;

    public Recepcionista() {
    }
   
    public Recepcionista(int IdRecepcionista, Usuario user, String nombre, String apellidoPaterno, String apellidoMaterno, String numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        super(nombre, apellidoPaterno, apellidoMaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
        this.IdRecepcionista = IdRecepcionista;
        this.user = user;
    }    

    public int getIdRecepcionista() {
        return IdRecepcionista;
    }

    public void setIdRecepcionista(int IdRecepcionista) {
        this.IdRecepcionista = IdRecepcionista;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user)throws Exception{
        if (user == null) {
            throw new Exception("Asignar usuario");
        }
        this.user = user;
    }
    
}
