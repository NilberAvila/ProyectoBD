/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Alergia;
import Modelo.Paciente;
import Modelo.DAO.PacienteDAO;
import Modelo.DTO.PacienteDetalleDTO;
import Modelo.DTO.PacienteDniDTO;
import Modelo.DTO.PacienteResumenDTO;
import java.util.ArrayList;
/**
 *
 * @author apnil
 */
public class ControladorPaciente {
    private final PacienteDAO pacienteDAO;
    public ArrayList<Paciente> listaPacientes = new ArrayList();
    private ArrayList<PacienteDniDTO> pacientesDniDTO = new ArrayList();
    
    public ControladorPaciente() {
        this.pacienteDAO = new PacienteDAO();
    }
    
    public ArrayList<PacienteResumenDTO> obtenerPacientesEnEspera(int idDoctor) throws Exception {
        return pacienteDAO.obtenerPacientesEnEspera(idDoctor);
    }
    
    public PacienteDetalleDTO pacientePorIdBasico(int idPaciente) throws Exception{
        return pacienteDAO.pacientePorIdBasico(idPaciente);
    }
    
    public ArrayList<Alergia> obtenerAlergiasPaciente(int IdPaciente)throws Exception {
        return pacienteDAO.obtenerAlergiasPaciente(IdPaciente);
    }
    
    public void citaAtendida(int idPaciente)throws Exception {
        pacienteDAO.citaAtendida(idPaciente);
    }
    
    public String obtenerNombrePaciente(int idPaciente)throws Exception{
        return pacienteDAO.obtenerNombrePaciente(idPaciente);
    }
    public void ObternerPacientes()throws Exception{
        pacientesDniDTO = pacienteDAO.ObtenerPacientes();
    }
    public PacienteDniDTO buscarPorDniDTO(String docIdentidad) {
        for (PacienteDniDTO p : pacientesDniDTO) {
            if (p.getDocIdentidad().equals(docIdentidad)) {
                return p;
            }
        }
        return null;
    }
    
    public void obtenerPacientesDni()throws Exception{
        listaPacientes = pacienteDAO.obtenerPacientesDni();
    }
    
    public ArrayList<Paciente> FiltrarPacientes(String filtro) {
        ArrayList<Paciente> resultados = new ArrayList<>();
        for (Paciente p : listaPacientes) {
            if (p.getNumDoc().contains(filtro)) {
                resultados.add(p);
            }
        }
        return resultados;
    }
    
    public int registrar_paciente(Paciente paciente) throws Exception{
        return pacienteDAO.registrar_paciente(paciente);
    }

    public int contarPacientes() throws Exception {
        return pacienteDAO.contarPacientes();
    }
    
    public void EliminarPaciente(int idPaciente) throws Exception{//mas q eliminar poner inactivo xd
        pacienteDAO.Eliminar(idPaciente);
    }
    
    public void ActualizarDatos(int idPaciente, String correo, String telefono, String direccion)throws Exception{
        pacienteDAO.ActualizarDatos(idPaciente, correo, telefono, direccion);
    }
    
    public void AgregarAlergia(int idPaciente, Alergia alergia)throws Exception{
        pacienteDAO.AgregarAlergia(idPaciente, alergia);
    } 
    public int obtenerCantidadPacientes()throws Exception{
        return pacienteDAO.obtenerCantidadPacientes();
    }
    public double obtenerEdadPromedioPacientes()throws Exception{
        return pacienteDAO.obtenerEdadPromedioPacientes();
    }
    public int[] obtenerPacientesActivosInactivos()throws Exception{
        return  pacienteDAO.obtenerPacientesActivosInactivos();
    }

}
