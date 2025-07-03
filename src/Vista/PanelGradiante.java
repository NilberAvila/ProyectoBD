/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author apnil
 */
public class PanelGradiante extends JPanel{
    private Color color1;
    private Color color2;
    private int borderRadius;

    public PanelGradiante(){
        this(Color.CYAN, Color.BLUE, 30);
    }
    public PanelGradiante(Color color1, Color color2, int borderRadius) {
        this.color1 = color1;
        this.color2 = color2;
        this.borderRadius = borderRadius;
        setOpaque(false);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Crear objeto Graphics2D para mejor control
        Graphics2D g2d = (Graphics2D) g.create();

        // Activar antialiasing para bordes suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Crear gradiente vertical
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);

        // Pintar fondo con gradiente en forma redondeada
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);

        g2d.dispose();
    }
     public void setGradientColorsAndRadius(Color color1, Color color2, int borderRadius) {
        this.color1 = color1;
        this.color2 = color2;
        this.borderRadius = borderRadius;
        repaint();  // Repintar el panel para aplicar cambios
    }

    // Clase para el borde redondeado
    private static class RoundedBorder extends AbstractBorder {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK); 
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);

            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius / 2, radius / 2, radius / 2, radius / 2);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = radius / 2;
            return insets;
        }
    }

}
