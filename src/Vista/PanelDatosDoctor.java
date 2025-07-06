/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import util.Placeholders;
import Modelo.Especialidad;
import Controladores.ControladorDoctor;
import Modelo.DTO.DoctorDTO;
import Modelo.DTO.EspecialidadDTO;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author apnil
 */
public class PanelDatosDoctor extends javax.swing.JPanel {
    /**
     * Creates new form PanelDatosDoctor
     */
    private DoctorDTO doc;
    private final int idDoctor;
    private final ControladorDoctor controladorDoctor = new ControladorDoctor();
    public PanelDatosDoctor(int idDoctor) {
        initComponents();
        this.idDoctor = idDoctor;
        ObtenerMostrarDatos();
        AplicarEstilos();
    }
    
    private void ObtenerMostrarDatos() {
        try {
            doc = controladorDoctor.buscarDatosBasicosPorId(idDoctor);
            txtNombres.setText(doc.getNombreCompleto());
            txtEdad.setText(Integer.toString(doc.getEdad()));
            txtGenero.setText(doc.getGenero());
            txtCMP.setText(doc.getCodigoColegiatura());
            txtDireccion.setText(doc.getDireccion());
            txtDocIdentidad.setText(doc.getDocIdentidad());
            txtTelefono.setText(doc.getTelefono());
            txtCorreo.setText(doc.getCorreo());
            String esps = "";
            for (EspecialidadDTO e : doc.getEspecialidades()) {
                esps += e.getNombre() + ": " + e.getDescripcion() + "\n";
            }
            txtaEspecialidades.setText(esps);
            inicializarPlaceholders(doc.getCorreo(), doc.getDireccion(), doc.getTelefono());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void AplicarEstilos(){
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch(Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        btnActualizar.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        jPanel2.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        jPanel3.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
    }
    
    public void inicializarPlaceholders(String correo, String direccion, String telefono){
        Placeholders.configurarPlaceholder(txtCorreo, correo);
        Placeholders.configurarPlaceholder(txtDireccion, direccion);
        Placeholders.configurarPlaceholder(txtTelefono, telefono);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
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
        txtEspecialidades = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        txtTelefono = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtCMP = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaEspecialidades = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(970, 620));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Doct.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 570));

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
        jPanel3.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 350, 10));

        txtGenero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtGenero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGenero.setText("00");
        txtGenero.setEnabled(false);
        jPanel3.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 80, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Edad");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 80, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Genero");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, 30));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 80, 10));

        txtDocIdentidad.setBackground(new java.awt.Color(242, 242, 242));
        txtDocIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDocIdentidad.setBorder(null);
        txtDocIdentidad.setEnabled(false);
        jPanel3.add(txtDocIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 350, 30));
        jPanel3.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 350, 10));
        jPanel3.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 10));

        txtEdad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEdad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEdad.setText("00");
        txtEdad.setEnabled(false);
        jPanel3.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 50, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Telefono");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Correo");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 170, 30));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 250, 10));
        jPanel3.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 220, 10));

        txtEspecialidades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEspecialidades.setText("Especialidades");
        jPanel3.add(txtEspecialidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 130, 30));

        txtDireccion.setBackground(new java.awt.Color(242, 242, 242));
        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion.setBorder(null);
        jPanel3.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 250, 30));

        txtCorreo.setBackground(new java.awt.Color(242, 242, 242));
        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(153, 153, 153));
        txtCorreo.setBorder(null);
        jPanel3.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 220, 30));
        jPanel3.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 250, 10));

        txtTelefono.setBackground(new java.awt.Color(242, 242, 242));
        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefono.setBorder(null);
        jPanel3.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Direccion");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 130, 30));

        txtCMP.setBackground(new java.awt.Color(242, 242, 242));
        txtCMP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCMP.setBorder(null);
        txtCMP.setEnabled(false);
        jPanel3.add(txtCMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 220, 30));
        jPanel3.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 220, 10));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Codigo CMP");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 130, 30));

        txtaEspecialidades.setBackground(new java.awt.Color(242, 242, 242));
        txtaEspecialidades.setColumns(20);
        txtaEspecialidades.setRows(5);
        txtaEspecialidades.setEnabled(false);
        jScrollPane1.setViewportView(txtaEspecialidades);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 490, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel4.setText("*Puede actualizar sus datos solo si asi lo requiera");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 270, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 530, 500));

        btnActualizar.setText("Actualizar Datos");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 530, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            controladorDoctor.actualizarDatosDoctor(txtCorreo.getText(), txtTelefono.getText(), txtDireccion.getText() , idDoctor);
            JOptionPane.showMessageDialog(this, "Se actualizaron los datos correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        ObtenerMostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JTextField txtCMP;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocIdentidad;
    private javax.swing.JLabel txtEdad;
    private javax.swing.JLabel txtEspecialidades;
    private javax.swing.JLabel txtGenero;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextArea txtaEspecialidades;
    // End of variables declaration//GEN-END:variables
}
