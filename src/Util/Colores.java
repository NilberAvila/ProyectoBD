/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author apnil
 */
public class Colores {

    public Color colorPrincipal;

    public Colores(Color colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public Color generarColorAleatorio() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
