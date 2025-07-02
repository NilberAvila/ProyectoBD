/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.DAO.AtencionDAO;
import Modelo.DTO.HistorialMedicoDTO;
import Estructuras.ListaCircularDoble;
/**
 *
 * @author apnil
 */
public class ControladorAtencion {
    private final AtencionDAO atencionDAO;

    public ControladorAtencion() {
        this.atencionDAO = new AtencionDAO();
    }
    
    public void Registrar( int idPaciente, int idDiagnostico, int idReceta)throws Exception{
        atencionDAO.Registrar(idPaciente, idDiagnostico, idReceta);
    }
    
    public ListaCircularDoble<HistorialMedicoDTO> ObtenerHistorial(int idPaciente)throws Exception{
        return atencionDAO.ObtenerHistorial(idPaciente);
    }
}
