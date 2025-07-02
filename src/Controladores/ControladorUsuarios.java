/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Usuario;
import Modelo.DAO.UsuarioDAO;
import Modelo.DTO.IdentidadUsuarioDTO;
import Modelo.DTO.UsuarioDTO;
import java.sql.*;
/**
 *
 * @author apnil
 */
public class ControladorUsuarios {

    private final UsuarioDAO usuarioDAO;
    public ControladorUsuarios() {
        usuarioDAO = new UsuarioDAO();
    }
    
    public IdentidadUsuarioDTO validarLogin(UsuarioDTO usuario)throws SQLException{
        return usuarioDAO.validarLogin(usuario);
    }
    
    public int obtenerIdDoctor(int idUsuario)throws SQLException {
        return usuarioDAO.obtenerIdDoctor(idUsuario);
    }
    
    public int RegistrarUser(Usuario usuario) throws SQLException{
        return usuarioDAO.RegistrarUser(usuario);
    }
}
