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
public class Usuario{
    private int IdUsuario;
    private String nombreUsuario;
    private String contraseña;
    private String rol;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseña, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Usuario(int IdUsuario, String nombreUsuario, String contraseña, String rol) {
        this.IdUsuario = IdUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = Validador.validarTexto(nombreUsuario, "El nombre de usuario");
    }
    
    public void setRol(String rol) {
        this.rol = Validador.validarTexto(rol, "El rol");
    }

    public void setContraseña(String contraseña) throws Exception {
        if (contraseña.length() < 8) {
            throw new Exception("La contraseña debe tener al menos 8 caracteres.");
        }
        this.contraseña = Validador.validarTextoPlaceHolder(contraseña,"Contraseña" , "La contraseña");
    }
}

