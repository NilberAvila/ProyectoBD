/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author apnil
 */
public class Placeholders {

    public static void configurarPlaceholder(JTextField campo, String textoPorDefecto) {
    campo.setForeground(Color.GRAY);
    campo.setText(textoPorDefecto);

    campo.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent e) {
            if (campo.getText().equals(textoPorDefecto)) {
                campo.setText("");
                campo.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            if (campo.getText().isEmpty()) {
                campo.setText(textoPorDefecto);
                campo.setForeground(Color.GRAY);
            }
        }
    });
    }
}
    
