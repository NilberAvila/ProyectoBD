/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Recepcionista;
import Modelo.DAO.RecepcionistaDAO;
import java.sql.SQLException;

/**
 *
 * @author apnil
 */
public class ControladorRecepcionista {
    
    private final RecepcionistaDAO recepcionistaDAO;

    public ControladorRecepcionista() {
        recepcionistaDAO = new RecepcionistaDAO();
    }
    
    public void Agregar_Repcionista(Recepcionista recepcionista) throws SQLException{
        recepcionistaDAO.Agregar_Repcionista(recepcionista);
    }    
}
