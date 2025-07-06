/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author apnil
 */
public class GrupoSanguineo {
    private int idAlergia;
    private String TipoSanguineo;
    private String Descripcion;

    public GrupoSanguineo(String TipoSanguineo, String Descripcion) {
        this.TipoSanguineo = TipoSanguineo;
        this.Descripcion = Descripcion;
    }
    
    //validar

    public int getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    public String getTipoSanguineo() {
        return TipoSanguineo;
    }

    public void setTipoSanguineo(String TipoSanguineo) {
        this.TipoSanguineo = TipoSanguineo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
