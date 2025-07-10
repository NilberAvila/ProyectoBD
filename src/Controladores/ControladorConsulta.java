/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.ConsultaMedica;
import Modelo.DAO.ConsultaDAO;

/**
 *
 * @author apnil
 */
public class ControladorConsulta {
    private ConsultaDAO consultaDAO;

    public ControladorConsulta() {
        this.consultaDAO = new ConsultaDAO();
    }
    
    public int registrarConsulta(ConsultaMedica consulta) throws Exception{
        return consultaDAO.registrarConsulta(consulta);
    }
}
