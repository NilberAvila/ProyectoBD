/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Controladores.ControladorAlergia;
import Modelo.Alergia;
import javax.swing.JOptionPane;
import util.Placeholders;


/**
 *
 * @author apnil
 */
public class JDialogAgregarAleriga extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JDialogAgregarAleriga.class.getName());
    
    public JDialogAgregarAleriga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarPlaceholders();
    }
    
    private void inicializarPlaceholders(){
        Placeholders.configurarPlaceholder(txtNombreal, "Ingrese nombre");
        Placeholders.configurarPlaceholder(txtDescripcion, "Ingrese descripcion");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtNombreal = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        Descripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        tbnAgregarAlergia = new javax.swing.JButton();
        cbtipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Alergia");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 30));

        txtNombreal.setBackground(new java.awt.Color(63, 154, 154));
        txtNombreal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreal.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreal.setBorder(null);
        jPanel1.add(txtNombreal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 280, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Tipo de alergia:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, 30));

        Descripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Descripcion.setForeground(new java.awt.Color(255, 255, 255));
        Descripcion.setText("Descripcion");
        jPanel1.add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, 30));

        txtDescripcion.setBackground(new java.awt.Color(63, 154, 154));
        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setBorder(null);
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 280, 30));

        tbnAgregarAlergia.setText("Agregar Alergia");
        tbnAgregarAlergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnAgregarAlergiaActionPerformed(evt);
            }
        });
        jPanel1.add(tbnAgregarAlergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 150, 40));

        cbtipo.setBackground(new java.awt.Color(63, 154, 154));
        cbtipo.setForeground(new java.awt.Color(255, 255, 255));
        cbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Respiratoria", "Alimentarias", "Medicamentos", "Insectos" }));
        cbtipo.setSelectedIndex(-1);
        jPanel1.add(cbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 102, 280, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void tbnAgregarAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnAgregarAlergiaActionPerformed
        try {
            Alergia alergia = new Alergia();
            alergia.setTipoAlergia((String)cbtipo.getSelectedItem());
            alergia.setNombreAlergia(txtNombreal.getText());
            alergia.setDescripcion(txtDescripcion.getText());
            
            ControladorAlergia controladorAlergia = new ControladorAlergia();
            controladorAlergia.agregarAlergia(alergia);
            JOptionPane.showMessageDialog(this, "Registro exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
            txtNombreal.setText("");
            txtDescripcion.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbnAgregarAlergiaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descripcion;
    private javax.swing.JComboBox<String> cbtipo;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton tbnAgregarAlergia;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombreal;
    // End of variables declaration//GEN-END:variables
}
