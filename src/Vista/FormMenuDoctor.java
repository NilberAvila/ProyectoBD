/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Util.MostrarPanelHijo;
import Util.Colores;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author apnil
 */
public class FormMenuDoctor extends javax.swing.JFrame {

    /**
     * Creates new form FormMenuDoctor
     */
    private int idDoctor;
    int xMouse, yMouse;
    private Color colorTemp;
    private Colores colores = new Colores(new Color(25, 118, 210));
    
    public FormMenuDoctor(int idDoctor) {
        initComponents();
        setLocationRelativeTo(null);
        this.idDoctor = idDoctor;
        MostrarPanelHijo.Mostrar(new PanelInicioDoc(idDoctor), PanelHijo, 970, 620);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        PanelMenu1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnAtender = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnBuscarPaciente = new javax.swing.JButton();
        PanelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        PanelHijo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelSuperior.setBackground(new java.awt.Color(25, 85, 215));
        PanelSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelSuperiorMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelSuperiorMouseMoved(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(25, 85, 215));
        btnCerrar.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        btnCerrar.setText("x");
        btnCerrar.setBorder(null);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSuperiorLayout = new javax.swing.GroupLayout(PanelSuperior);
        PanelSuperior.setLayout(PanelSuperiorLayout);
        PanelSuperiorLayout.setHorizontalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSuperiorLayout.createSequentialGroup()
                .addGap(0, 1240, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelSuperiorLayout.setVerticalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(PanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 40));

        PanelMenu1.setBackground(new java.awt.Color(25, 118, 210));
        PanelMenu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(25, 85, 215));

        btnInicio.setBackground(new java.awt.Color(25, 85, 215));
        btnInicio.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setText("Inicio");
        btnInicio.setBorder(null);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelMenu1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 110));

        btnAtender.setBackground(new java.awt.Color(25, 118, 210));
        btnAtender.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        btnAtender.setForeground(new java.awt.Color(255, 255, 255));
        btnAtender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/SickInverted.png"))); // NOI18N
        btnAtender.setText("Atender Pacientes");
        btnAtender.setBorder(null);
        btnAtender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderActionPerformed(evt);
            }
        });
        PanelMenu1.add(btnAtender, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 310, 80));

        btnPerfil.setBackground(new java.awt.Color(25, 118, 210));
        btnPerfil.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        btnPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/User.png"))); // NOI18N
        btnPerfil.setText("Perfil");
        btnPerfil.setBorder(null);
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        PanelMenu1.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 310, 80));

        btnBuscarPaciente.setBackground(new java.awt.Color(25, 118, 210));
        btnBuscarPaciente.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        btnBuscarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Search More.png"))); // NOI18N
        btnBuscarPaciente.setText("Pacientes");
        btnBuscarPaciente.setBorder(null);
        btnBuscarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });
        PanelMenu1.add(btnBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 310, 80));

        jPanel1.add(PanelMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 310, 730));

        PanelTitulo.setBackground(new java.awt.Color(66, 165, 245));

        lblTitulo.setBackground(new java.awt.Color(227, 242, 253));
        lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("MENU");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
            .addGroup(PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTituloLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTituloLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(PanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 970, 60));

        PanelHijo.setLayout(new java.awt.BorderLayout());
        jPanel1.add(PanelHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 970, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        LogRes a = new LogRes();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void PanelSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSuperiorMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse , y - yMouse);
    }//GEN-LAST:event_PanelSuperiorMouseDragged

    private void PanelSuperiorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSuperiorMouseMoved
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_PanelSuperiorMouseMoved

    private void btnAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderActionPerformed
        cambiarVistaPanel(btnAtender, "AtenderPacientes", new PanelAtenderPacientes(idDoctor));
    }//GEN-LAST:event_btnAtenderActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        cambiarVistaPanel(btnPerfil, "Perfil", new PanelDatosDoctor(idDoctor));
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        cambiarVistaPanel(btnInicio, "Inicio", new PanelInicioDoc(idDoctor));
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        cambiarVistaPanel(btnBuscarPaciente, "Pacientes", new PanelPacientesDoctor());
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void EstablecerColor(JButton btn){
        colorTemp = colores.generarColorAleatorio();
        btn.setBackground(colorTemp);
        PanelTitulo.setBackground(colorTemp);
    }
    private void cambiarVistaPanel(JButton botonSeleccionado, String titulo, JPanel panelMostrar) {
        btnAtender.setBackground(colores.colorPrincipal);
        btnPerfil.setBackground(colores.colorPrincipal);
        btnBuscarPaciente.setBackground(colores.colorPrincipal);
        btnInicio.setBackground(new Color(25,85,215));
        EstablecerColor(botonSeleccionado);
        lblTitulo.setText(titulo);
        MostrarPanelHijo.Mostrar(panelMostrar, PanelHijo, 970, 620);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHijo;
    private javax.swing.JPanel PanelMenu1;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnAtender;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
