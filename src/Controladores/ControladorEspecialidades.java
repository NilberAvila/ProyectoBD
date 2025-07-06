/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Especialidad;
import Modelo.DAO.EspecialidadDAO;
import Modelo.DTO.EspecialidadBasicoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class ControladorEspecialidades {
    public ArrayList<EspecialidadBasicoDTO> especialidadBasicoDTOs = new ArrayList();
    private final EspecialidadDAO especialidadDAO;

    public ControladorEspecialidades() {
        especialidadDAO = new EspecialidadDAO();
    }
    
    public void ObtenerEspecialidadesBasicas()throws SQLException {
        especialidadBasicoDTOs = especialidadDAO.obtnerEspecialides();
    }
    
    public ArrayList<Especialidad> ObtenerEspecialidadesC()throws Exception {
        return especialidadDAO.obtnerEspecialidesC();
    }
    
    public void Agregar_Especialidades(Especialidad Especialidades)throws Exception{
        especialidadDAO.Agregar_Especialidades(Especialidades);
    }
    
    public Especialidad BuscarEspecialidad(String nombreBuscado) throws  Exception{
        return especialidadDAO.BuscarEspecialidad(nombreBuscado);
    }
    public void ActualizarEsepecialidad(String buscar,String NewNobmre, String NewDescripcion) throws Exception{
         especialidadDAO.ActualizarEspecialidad(buscar, NewNobmre, NewDescripcion);
    }
    
    public void EliminarEspecialidad(int idespecialdiad) throws Exception{
         especialidadDAO.EliminarEspecialidad(idespecialdiad);
    }
}
