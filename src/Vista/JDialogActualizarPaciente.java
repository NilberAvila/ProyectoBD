/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Modelo.Alergia;
import Modelo.Paciente;
import Controladores.ControladorPaciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import util.Placeholders;

/**
 *
 * @author apnil
 */
public class JDialogActualizarPaciente extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JDialogActualizarPaciente.class.getName());
    
    private ArrayList<Alergia> alergias =  new ArrayList();
    private Paciente pac;
    JDialogActualizarPaciente(java.awt.Frame parent, boolean modal, Paciente paciente) {
        super(parent, modal);
        initComponents();
        pac = paciente;
        ObtenerDatosMostrar();
    }
    
    private void ObtenerDatosMostrar(){
        try {
            ControladorPaciente controladorPaciente = new ControladorPaciente();
            alergias =  controladorPaciente.obtenerAlergiasPaciente(pac.getIdPaciente());
            String aler = "";
            for (Alergia a : alergias) {
                aler += a.verAlergia()+ "\n";
            }
            txtAlergias.setText(aler);
            txtNombres.setText(pac.getNombre() + " " + pac.getApellidoPaterno() + " " + pac.getApellidoMaterno());
            txtCorreo.setText(pac.getCorreo());
            txtDireccion.setText(pac.getDireccion());
            txtDocIdentidad.setText(pac.getNumDoc());
            txtEdad.setText(Integer.toString(pac.verEdad()));
            txtTelefono.setText(pac.getTelefono());
            txtGenero.setText(pac.getGenero());
            txtTipoSangre.setText(pac.getGrupoSanguineo());
            inicializarPlaceholders(pac.getCorreo(), pac.getDireccion(), pac.getTelefono());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    
    private void inicializarPlaceholders(String correo, String direccion, String telefono){
        Placeholders.configurarPlaceholder(txtCorreo, correo);
        Placeholders.configurarPlaceholder(txtDireccion, direccion);
        Placeholders.configurarPlaceholder(txtTelefono, telefono);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        txtNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        txtGenero = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtDocIdentidad = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        txtEdad = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        txtTelefono = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtTipoSangre = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtEspecialidades = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlergias = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();
        txtHistorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pacienteimg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 500));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 350, 10));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 490, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombres y Apellidos");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 30));
        jPanel3.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 490, 10));

        txtNombres.setBackground(new java.awt.Color(242, 242, 242));
        txtNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombres.setBorder(null);
        txtNombres.setEnabled(false);
        jPanel3.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 490, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Documento de Identidad");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 190, 30));
        jPanel3.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 260, 10));

        txtGenero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtGenero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGenero.setText("00");
        txtGenero.setEnabled(false);
        jPanel3.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 80, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Edad");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 50, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Genero");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 70, 30));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 80, 10));

        txtDocIdentidad.setBackground(new java.awt.Color(242, 242, 242));
        txtDocIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDocIdentidad.setBorder(null);
        txtDocIdentidad.setEnabled(false);
        jPanel3.add(txtDocIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 260, 30));
        jPanel3.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 260, 10));
        jPanel3.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 50, 10));

        txtEdad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEdad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEdad.setText("00");
        txtEdad.setEnabled(false);
        jPanel3.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 50, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Telefono");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 130, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Correo");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 170, 30));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 250, 10));
        jPanel3.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 210, 10));

        txtDireccion.setBackground(new java.awt.Color(242, 242, 242));
        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion.setBorder(null);
        jPanel3.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 210, 30));

        txtCorreo.setBackground(new java.awt.Color(242, 242, 242));
        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(153, 153, 153));
        txtCorreo.setBorder(null);
        jPanel3.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 210, 30));
        jPanel3.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 250, 10));

        txtTelefono.setBackground(new java.awt.Color(242, 242, 242));
        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefono.setBorder(null);
        jPanel3.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 250, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Direccion");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 130, 30));
        jPanel3.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 210, 10));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel4.setText("*Puede actualizar sus datos solo si asi lo requiera");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 270, -1));

        txtTipoSangre.setBackground(new java.awt.Color(242, 242, 242));
        txtTipoSangre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTipoSangre.setForeground(new java.awt.Color(153, 153, 153));
        txtTipoSangre.setBorder(null);
        txtTipoSangre.setEnabled(false);
        jPanel3.add(txtTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 250, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Tipo de Sangre");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, 30));

        txtEspecialidades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEspecialidades.setText("Alergias");
        jPanel3.add(txtEspecialidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 130, 30));

        txtAlergias.setBackground(new java.awt.Color(242, 242, 242));
        txtAlergias.setColumns(20);
        txtAlergias.setRows(5);
        txtAlergias.setEnabled(false);
        jScrollPane1.setViewportView(txtAlergias);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 490, 110));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 560, 500));

        btnActualizar.setText("Actualizar Datos");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 540, 560, 50));

        txtHistorial.setText("Ver Historial");
        txtHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(txtHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 540, 350, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            ControladorPaciente controladorPaciente = new ControladorPaciente();
            controladorPaciente.ActualizarDatos(pac.getIdPaciente(), txtCorreo.getText(), txtDireccion.getText() ,txtDireccion.getText());
            JOptionPane.showMessageDialog(this, "Se actualizaron los datos correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        ObtenerDatosMostrar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHistorialActionPerformed
        JDialogHistorialMedico a = new JDialogHistorialMedico(this, true, pac.getIdPaciente());
        a.setLocationRelativeTo(null);
        a.setVisible(true); 
    }//GEN-LAST:event_txtHistorialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea txtAlergias;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocIdentidad;
    private javax.swing.JLabel txtEdad;
    private javax.swing.JLabel txtEspecialidades;
    private javax.swing.JLabel txtGenero;
    private javax.swing.JButton txtHistorial;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoSangre;
    // End of variables declaration//GEN-END:variables
}
