/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author apnil
 */
public class Conexion {
 
    private static final String url = "jdbc:sqlserver://serverbdandtpoo.database.windows.net:1433;"
            + "database=SistemaHospitalario;user=AdminBD@serverbdandtpoo;password=TPOO108254.;"
            + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
   
    public static Connection getConexion(){
        try {
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo al conectar con el servidor, intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}

