/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Receta;
import Modelo.DAO.RecetaDAO;


/**
 *
 * @author apnil
 */
public class ControladorReceta {
    private final RecetaDAO recetaDAO;

    public ControladorReceta() {
        recetaDAO = new RecetaDAO();
    }
    
    public int RegistrarReceta(Receta res, int IdDoctor, int idPaciente)throws Exception{
        return recetaDAO.RegistrarReceta(res, IdDoctor, idPaciente);
    }
}
