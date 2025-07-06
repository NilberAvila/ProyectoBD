/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Modelo.Alergia;
import Controladores.ControladorPaciente;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import util.Placeholders;


/**
 *
 * @author apnil
 */
public class JDialogAgregarAleriga extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JDialogAgregarAleriga.class.getName());

    private final ButtonGroup btgAlergias = new ButtonGroup();
    private final int idPaciente;
    
    public JDialogAgregarAleriga(java.awt.Dialog parent, boolean modal, int idPaciente) {
        super(parent, modal);
        initComponents();
        inicializarPlaceholders();
        this.idPaciente = idPaciente;
        btgAlergias.add(rbAlergiaAlimentos);
        btgAlergias.add(rbAlergiaMedicamentos);
    }
    
    private void inicializarPlaceholders(){
        Placeholders.configurarPlaceholder(txtDescripciònAlergia, "Ingrese descripción");
        Placeholders.configurarPlaceholder(txtSeveridadAlerg, "Ingrese severidad");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtDescripciònAlergia = new javax.swing.JTextField();
        rbAlergiaAlimentos = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        rbAlergiaMedicamentos = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        txtSeveridadAlerg = new javax.swing.JTextField();
        tbnAgregarAlergia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Descripción:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 30));

        txtDescripciònAlergia.setBackground(new java.awt.Color(63, 154, 154));
        txtDescripciònAlergia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescripciònAlergia.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripciònAlergia.setText("Ingrese descripción");
        txtDescripciònAlergia.setBorder(null);
        jPanel1.add(txtDescripciònAlergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 280, 30));

        rbAlergiaAlimentos.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbAlergiaAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        rbAlergiaAlimentos.setText("Alimentos");
        rbAlergiaAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAlergiaAlimentosActionPerformed(evt);
            }
        });
        jPanel1.add(rbAlergiaAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Tipo de alergia:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 30));

        rbAlergiaMedicamentos.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbAlergiaMedicamentos.setForeground(new java.awt.Color(255, 255, 255));
        rbAlergiaMedicamentos.setText("Medicamentos");
        rbAlergiaMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAlergiaMedicamentosActionPerformed(evt);
            }
        });
        jPanel1.add(rbAlergiaMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Severidad");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, 30));

        txtSeveridadAlerg.setBackground(new java.awt.Color(63, 154, 154));
        txtSeveridadAlerg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSeveridadAlerg.setForeground(new java.awt.Color(255, 255, 255));
        txtSeveridadAlerg.setText("Ingrese severidad");
        txtSeveridadAlerg.setBorder(null);
        jPanel1.add(txtSeveridadAlerg, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 280, 30));

        tbnAgregarAlergia.setText("Agregar Alergia");
        tbnAgregarAlergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnAgregarAlergiaActionPerformed(evt);
            }
        });
        jPanel1.add(tbnAgregarAlergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbAlergiaAlimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAlergiaAlimentosActionPerformed
        txtDescripciònAlergia.setEnabled(true);
        txtSeveridadAlerg.setEnabled(true);
    }//GEN-LAST:event_rbAlergiaAlimentosActionPerformed

    private void rbAlergiaMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAlergiaMedicamentosActionPerformed
        txtDescripciònAlergia.setEnabled(true);
        txtSeveridadAlerg.setEnabled(true);
    }//GEN-LAST:event_rbAlergiaMedicamentosActionPerformed

    private void tbnAgregarAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnAgregarAlergiaActionPerformed
        try {
            ButtonModel selectedModel = btgAlergias.getSelection();
            if (selectedModel != null) {
                String tipoAlergia = "";
                if (rbAlergiaAlimentos.isSelected()) {
                    tipoAlergia = "Alimentos";
                } else if (rbAlergiaMedicamentos.isSelected()) {
                    tipoAlergia = "Medicamentos";
                }
                Alergia alergia = new Alergia();
                alergia.setTipoAlergia(tipoAlergia);
                alergia.setNombreAlergia(txtDescripciònAlergia.getText());
                alergia.setSeveridad(txtSeveridadAlerg.getText());
                ControladorPaciente controladorPaciente = new ControladorPaciente();
                controladorPaciente.AgregarAlergia(idPaciente, alergia);
                JOptionPane.showMessageDialog(this, "Registro exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
                txtDescripciònAlergia.setText("");
                txtSeveridadAlerg.setText("");
                txtDescripciònAlergia.setEnabled(true);
                txtSeveridadAlerg.setEnabled(true);
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un tipo de alergia.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbnAgregarAlergiaActionPerformed
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbAlergiaAlimentos;
    private javax.swing.JRadioButton rbAlergiaMedicamentos;
    private javax.swing.JButton tbnAgregarAlergia;
    private javax.swing.JTextField txtDescripciònAlergia;
    private javax.swing.JTextField txtSeveridadAlerg;
    // End of variables declaration//GEN-END:variables
}
