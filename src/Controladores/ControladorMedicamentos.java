/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.AsignacionMedicamento;
import Modelo.DAO.MedicamentoDAO;
import Modelo.Medicamento;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class ControladorMedicamentos {
    MedicamentoDAO medicamentoDAO;

    public ControladorMedicamentos() {
        this.medicamentoDAO = new MedicamentoDAO();
    }
    
    public ArrayList<Medicamento> obtenerMedicamentos() throws Exception{
        return medicamentoDAO.obtenerMedicamentos();
    }
    
    public ArrayList<Medicamento> filtrarMedicamentosPorNombre(ArrayList<Medicamento> listaOriginal, String texto) {
        ArrayList<Medicamento> filtrados = new ArrayList<>();
        for (Medicamento med : listaOriginal) {
            if (med.getNombreMedicamento().toLowerCase().contains(texto.toLowerCase())) {
                filtrados.add(med);
            }
        }
        return filtrados;
    }
    
    public int registrarAsignacionMedicamento(AsignacionMedicamento asignacion) throws Exception{
        return medicamentoDAO.registrarAsignacionMedicamento(asignacion);
    }
    
    public int Agregar_Medicamento(Medicamento medicamento)throws Exception{
        return medicamentoDAO.Agregar_Medicamento(medicamento);
    }
    
}
