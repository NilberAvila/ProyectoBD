/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;


import Util.Colores;
import Util.MostrarPanelHijo;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author apnil
 */
public class FormMenuRecep extends javax.swing.JFrame {
    /**
     * Creates new form FormMenuRecep
     */
    int xMouse, yMouse;
    private Color colorTemp;
    private Colores colores = new Colores(new Color(0,125,118));
    public FormMenuRecep() {
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        PanelMenu = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAgendarCita = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscarPaciente = new javax.swing.JButton();
        btnRegistrarEmergencia = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        PanelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        PanelHijo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelSuperior.setBackground(new java.awt.Color(51, 75, 73));
        PanelSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelSuperiorMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelSuperiorMouseMoved(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 75, 73));
        jButton1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        jButton1.setText("x");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSuperiorLayout = new javax.swing.GroupLayout(PanelSuperior);
        PanelSuperior.setLayout(PanelSuperiorLayout);
        PanelSuperiorLayout.setHorizontalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSuperiorLayout.createSequentialGroup()
                .addGap(0, 1240, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelSuperiorLayout.setVerticalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(PanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 40));

        PanelMenu.setBackground(new java.awt.Color(0, 125, 118));
        PanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 75, 73));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        PanelMenu.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 110));

        btnAgendarCita.setBackground(new java.awt.Color(0, 125, 118));
        btnAgendarCita.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        btnAgendarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Task Planning50px.png"))); // NOI18N
        btnAgendarCita.setText("Agendar Cita");
        btnAgendarCita.setBorder(null);
        btnAgendarCita.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgendarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarCitaActionPerformed(evt);
            }
        });
        PanelMenu.add(btnAgendarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 310, 80));

        btnRegistrar.setBackground(new java.awt.Color(0, 125, 118));
        btnRegistrar.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/SickInverted.png"))); // NOI18N
        btnRegistrar.setText("Registar Paciente");
        btnRegistrar.setBorder(null);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        PanelMenu.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 310, 80));

        btnBuscarPaciente.setBackground(new java.awt.Color(0, 125, 118));
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
        PanelMenu.add(btnBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 310, 80));

        btnRegistrarEmergencia.setBackground(new java.awt.Color(0, 125, 118));
        btnRegistrarEmergencia.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnRegistrarEmergencia.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarEmergencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/IconoRegistro.png"))); // NOI18N
        btnRegistrarEmergencia.setText("Registrar Emergencia");
        btnRegistrarEmergencia.setBorder(null);
        btnRegistrarEmergencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarEmergencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmergenciaActionPerformed(evt);
            }
        });
        PanelMenu.add(btnRegistrarEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 310, 80));

        jPanel1.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 310, 730));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 970, -1));

        PanelTitulo.setBackground(new java.awt.Color(150, 177, 173));

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LogRes a = new LogRes();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        EstablecerColor(btnRegistrar); 
        cambiarVistaPanel(btnRegistrar, "Registrar Paciente", new PanelRegistrarPaciente(colorTemp));
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        EstablecerColor(btnBuscarPaciente);
        cambiarVistaPanel(btnBuscarPaciente, "Pacientes", new PanelPacientes());
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarCitaActionPerformed
        EstablecerColor(btnAgendarCita);
        cambiarVistaPanel(btnAgendarCita, "Agendar Cita", new PanelAgendarCita(colorTemp));
    }//GEN-LAST:event_btnAgendarCitaActionPerformed

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

    private void btnRegistrarEmergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmergenciaActionPerformed
        EstablecerColor(btnRegistrarEmergencia);
        cambiarVistaPanel(btnRegistrarEmergencia, "Registrar Emergencia", new JPanelRegistroEmergencia(colorTemp));
    }//GEN-LAST:event_btnRegistrarEmergenciaActionPerformed
    
    private void EstablecerColor(JButton btn){
        colorTemp = colores.generarColorAleatorio();
        btn.setBackground(colorTemp);
        PanelTitulo.setBackground(colorTemp);
    }
    
    private void cambiarVistaPanel(JButton botonSeleccionado, String titulo, JPanel panelMostrar) {
        btnRegistrar.setBackground(colores.colorPrincipal);
        btnAgendarCita.setBackground(colores.colorPrincipal);
        btnBuscarPaciente.setBackground(colores.colorPrincipal);
        btnRegistrarEmergencia.setBackground(colores.colorPrincipal);
        botonSeleccionado.setBackground(colorTemp);
        lblTitulo.setText(titulo);
        MostrarPanelHijo.Mostrar(panelMostrar, PanelHijo, 970, 620);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHijo;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnAgendarCita;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarEmergencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
