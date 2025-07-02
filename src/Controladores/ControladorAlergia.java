/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Alergia;
import Modelo.DAO.AlergiaDAO;

/**
 *
 * @author apnil
 */
public class ControladorAlergia {
    
    private AlergiaDAO alergiaDAO;

    public ControladorAlergia() {
        alergiaDAO = new AlergiaDAO();
    }

    public int agregarAlergia(Alergia alergia)throws Exception{
        return alergiaDAO.agregarAlergia(alergia);
    }
    
    public void agregarRelacionPacienteAlergia(int pacienteID, int alergiaID)throws Exception{
        alergiaDAO.agregarRelacionPacienteAlergia(pacienteID, alergiaID);
    }
}
