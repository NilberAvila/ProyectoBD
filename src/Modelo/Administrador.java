/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author apnil
 */
public class Administrador extends Persona{
    private int IdAdministrador;
    private Usuario user;

    public Administrador() {
    }

    public void setIdAdministrador(int IdAdministrador) {
        this.IdAdministrador = IdAdministrador;
    }
    
    public Usuario getUser() {
        return user;
    }
}
