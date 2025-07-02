/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author apnil
 */
public class MostrarPanelHijo {
    public static void Mostrar(JPanel p, JPanel PanelHijo, int sizex, int sizey){
        p.setSize(sizex, sizey);
        p.setLocation(0,0);
        PanelHijo.removeAll();
        PanelHijo.add(p, BorderLayout.CENTER);
        PanelHijo.revalidate();
        PanelHijo.repaint();
    }
}
