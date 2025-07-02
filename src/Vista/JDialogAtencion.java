/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Modelo.Alergia;
import Modelo.Diagnostico;
import Modelo.Receta;
import Controladores.ControladorAtencion;
import Controladores.ControladorDiagnostico;
import Controladores.ControladorDoctor;
import Controladores.ControladorPaciente;
import Controladores.ControladorReceta;
import Modelo.DTO.PacienteDetalleDTO;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JOptionPane;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
/**
 *
 * @author apnil
 */
public class JDialogAtencion extends javax.swing.JDialog {
    /**
     * Creates new form JDialogAtencion
     */
    int xMouse, yMouse;
    private int idPaciente;
    private int idDoctor;
    private final ControladorPaciente controladorPaciente= new ControladorPaciente();
    private final ControladorDoctor controladorDoctor = new ControladorDoctor();
    
    public JDialogAtencion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JDialogAtencion(java.awt.Frame parent, boolean modal, int idPaciente, int IdDoctor) {
        this(parent, modal);
        this.idPaciente = idPaciente;
        this.idDoctor = IdDoctor;
        AplicarEstilos();
        MostrarDatosPaciente();
        
    }
    
    private void AplicarEstilos(){
        jPanel1.putClientProperty(FlatClientProperties.STYLE, "arc: 30");
        jPanel2.putClientProperty(FlatClientProperties.STYLE, "arc: 30"); 
        jPanel3.putClientProperty(FlatClientProperties.STYLE, "arc: 30");
        btnTerminar.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
    }
    
    private void MostrarDatosPaciente(){
        try {
            PacienteDetalleDTO pac = controladorPaciente.pacientePorIdBasico(idPaciente);
            txtNombre.setText(pac.getNombreCompleto());
            txtGenero.setText(pac.getGenero());
            txtEdad.setText(Integer.toString(pac.getEdad()));
            txtTipoSangre.setText(pac.getGrupoSanguineo());
            String aler = "";
            for (Alergia a : pac.getAlergias()) {
                aler += a.verAlergia()+ "\n";
            }
            txtAlergias.setText(aler);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void Atendida(){
        try {
            controladorPaciente.citaAtendida(idPaciente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void GenerarReceta(){
        try {
            String doc = controladorDoctor.obtenerNombreDoctor(idDoctor);
            String pac = controladorPaciente.obtenerNombrePaciente(idPaciente);
            String fechaHora = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
            String nombreArchivo = "recetas/receta_paciente_" + idPaciente + "_" + fechaHora + ".pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph titulo = new Paragraph("Receta Médica", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            PdfPCell cell;

            cell = new PdfPCell(new Phrase(" ", headFont));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Resultados", headFont));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            table.addCell("Nombre del Doctor");
            table.addCell(doc);

            table.addCell("Nombre del Paciente");
            table.addCell(pac);

            table.addCell("Síntomas");
            table.addCell(txtSintomas.getText());

            table.addCell("Enfermedad Diagnosticada");
            table.addCell(txtEnfermedadDiagnosticada.getText());

            table.addCell("Medicamentos y Dosis");
            table.addCell(txtMedicamentosDosis.getText());

            table.addCell("Recomendaciones");
            table.addCell(txtRecomendaciones.getText());

            document.add(table);
            document.close();

            JOptionPane.showMessageDialog(this, "Receta PDF generada exitosamente:\n" + nombreArchivo, "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el PDF:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEnfermedadDiagnosticada = new javax.swing.JTextArea();
        Diagnostico = new javax.swing.JLabel();
        Diagnostico1 = new javax.swing.JLabel();
        Diagnostico2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMedicamentosDosis = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSintomas = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAlergias = new javax.swing.JTextArea();
        txtNombre = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtTipoSangre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAgregarAlergia = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnTerminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRecomendaciones = new javax.swing.JTextArea();
        Diagnostico3 = new javax.swing.JLabel();
        btnVerHistorial = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtEnfermedadDiagnosticada.setColumns(20);
        txtEnfermedadDiagnosticada.setRows(5);
        jScrollPane1.setViewportView(txtEnfermedadDiagnosticada);

        Diagnostico.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Diagnostico.setText("Sintomas");

        Diagnostico1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Diagnostico1.setText("Enfermedad Diagnosticada");

        Diagnostico2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Diagnostico2.setText("Medicamentos - Dosis");

        txtMedicamentosDosis.setColumns(20);
        txtMedicamentosDosis.setRows(5);
        jScrollPane3.setViewportView(txtMedicamentosDosis);

        txtSintomas.setColumns(20);
        txtSintomas.setRows(5);
        jScrollPane4.setViewportView(txtSintomas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Diagnostico)
                    .addComponent(Diagnostico1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Diagnostico2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Diagnostico)
                    .addComponent(Diagnostico2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Diagnostico1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/hombre.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 43, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 26));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Edad:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 26));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Genero:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, 26));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tipo de Sangre:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 26));

        txtAlergias.setColumns(20);
        txtAlergias.setRows(5);
        txtAlergias.setEnabled(false);
        jScrollPane5.setViewportView(txtAlergias);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 268, 60));

        txtNombre.setEnabled(false);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 200, 26));

        txtGenero.setEnabled(false);
        jPanel2.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 90, 25));

        txtTipoSangre.setEnabled(false);
        jPanel2.add(txtTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 150, 25));

        txtEdad.setEnabled(false);
        jPanel2.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 50, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Alergias:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 66, 26));

        txtAgregarAlergia.setText("Nueva Alergia");
        txtAgregarAlergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarAlergiaActionPerformed(evt);
            }
        });
        jPanel2.add(txtAgregarAlergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 270, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnTerminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTerminar.setText("Terminar Consulta");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        txtRecomendaciones.setColumns(20);
        txtRecomendaciones.setRows(5);
        jScrollPane2.setViewportView(txtRecomendaciones);

        Diagnostico3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Diagnostico3.setText("Recomendaciones");

        btnVerHistorial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerHistorial.setText("Ver Historial Medico");
        btnVerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Diagnostico3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnVerHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Diagnostico3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel4MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseMoved
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel4MouseMoved

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        try {
            int opcion = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de terminar la consulta?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                Receta recetanueva = new Receta();
                recetanueva.setMedicamentosDosis(txtMedicamentosDosis.getText());
                recetanueva.setRecomendaciones(txtRecomendaciones.getText());
                Diagnostico diag = new Diagnostico();
                diag.setSintomas(txtSintomas.getText());
                diag.setEnfermedadDiagnosticada(txtEnfermedadDiagnosticada.getText());
                ControladorReceta controladorReceta =  new ControladorReceta();
                ControladorDiagnostico controladorDiagnostico = new ControladorDiagnostico();
                ControladorAtencion controladorAtencion = new ControladorAtencion();
                int idReceta = controladorReceta.RegistrarReceta(recetanueva, idDoctor, idPaciente);
                int idDiagnostico = controladorDiagnostico.RegistrarDiagnostico(diag, idDoctor, idPaciente);
                controladorAtencion.Registrar(idPaciente, idDiagnostico, idReceta);
                GenerarReceta();
                Atendida();
                JOptionPane.showMessageDialog(rootPane, "Receta generada, atencion terminada", "Exito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else if(opcion == JOptionPane.NO_OPTION){
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnVerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHistorialActionPerformed
        JDialogHistorialMedico a = new JDialogHistorialMedico(this, true, idPaciente);
        a.setLocationRelativeTo(null);
        a.setVisible(true); 
    }//GEN-LAST:event_btnVerHistorialActionPerformed

    private void txtAgregarAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarAlergiaActionPerformed
        JDialogAgregarAleriga a = new JDialogAgregarAleriga(this, true, idPaciente);
        a.setLocationRelativeTo(null);
        a.setVisible(true); 
        MostrarDatosPaciente();
    }//GEN-LAST:event_txtAgregarAlergiaActionPerformed
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Diagnostico;
    private javax.swing.JLabel Diagnostico1;
    private javax.swing.JLabel Diagnostico2;
    private javax.swing.JLabel Diagnostico3;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnVerHistorial;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton txtAgregarAlergia;
    private javax.swing.JTextArea txtAlergias;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextArea txtEnfermedadDiagnosticada;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextArea txtMedicamentosDosis;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtRecomendaciones;
    private javax.swing.JTextArea txtSintomas;
    private javax.swing.JTextField txtTipoSangre;
    // End of variables declaration//GEN-END:variables
}
