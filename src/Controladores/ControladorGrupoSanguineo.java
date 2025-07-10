/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.DAO.GrupoSanguienoDAO;
import Modelo.GrupoSanguineo;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class ControladorGrupoSanguineo {
    
    GrupoSanguienoDAO grupoSanguienoDAO;

    public ControladorGrupoSanguineo() {
        grupoSanguienoDAO =  new GrupoSanguienoDAO();
    }
    
    public ArrayList<GrupoSanguineo> obtenerGruposSanguineos() throws Exception{
        return grupoSanguienoDAO.obtenerGruposSanguineos();
    }
}
