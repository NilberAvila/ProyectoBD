/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.DAO.TratamientoDAO;
import Modelo.Tratamiento;
import java.sql.SQLException;

/**
 *
 * @author apnil
 */
public class ControladorTratamiento {
    private TratamientoDAO tratamientoDAO;

    public ControladorTratamiento() {
        tratamientoDAO = new TratamientoDAO();
    }
    
    public int registrarTratamiento(Tratamiento tratamiento) throws SQLException{
        return tratamientoDAO.registrarTratamiento(tratamiento);
    }
}
