/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.DAO.AtencionDAO;
import Estructuras.ListaCircularDoble;
import Modelo.DTO.HistorialClinicoDTO;
/**
 *
 * @author apnil
 */
public class ControladorAtencion {
    
    private AtencionDAO atencionDAO;

    public ControladorAtencion() {
        this.atencionDAO = new AtencionDAO();
    }
    
    public ListaCircularDoble<HistorialClinicoDTO> ObtenerHistorobtenerHistorialPorPacienteial(int idPaciente)throws Exception{
        return atencionDAO.obtenerHistorialPorPaciente(idPaciente);
    }
}
