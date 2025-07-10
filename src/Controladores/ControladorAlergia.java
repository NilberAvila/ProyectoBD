/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelo.Alergia;
import Modelo.DAO.AlergiaDAO;
import java.util.ArrayList;

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
    
    public ArrayList<Alergia> ObtenerAlergias()throws Exception{
        return alergiaDAO.ObtenerAlergias();
    }
    public ArrayList<Alergia> filtrarAlergiasPorTexto(ArrayList<Alergia> listaOriginal, String texto) {
        ArrayList<Alergia> listaFiltrada = new ArrayList<>();
        String textoLower = texto.toLowerCase();
        for (Alergia a : listaOriginal) {
            if (a.getNombreAlergia().toLowerCase().contains(textoLower)){
                listaFiltrada.add(a);
            }
        }
        return listaFiltrada;
    }
}
