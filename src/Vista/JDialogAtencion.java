/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Modelo.Alergia;
import Modelo.Receta;
import Controladores.ControladorConsulta;
import Controladores.ControladorDoctor;
import Controladores.ControladorMedicamentos;
import Controladores.ControladorPaciente;
import Controladores.ControladorReceta;
import Controladores.ControladorTratamiento;
import Modelo.AsignacionMedicamento;
import Modelo.Cita;
import Modelo.ConsultaMedica;
import Modelo.DTO.PacienteDetalleDTO;
import Modelo.Emergencia;
import Modelo.Tratamiento;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JOptionPane;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author apnil
 */
public class JDialogAtencion extends javax.swing.JDialog {
    /**
     * Creates new form JDialogAtencion
     */
    int xMouse, yMouse;
    private int idDoctor;
    private final ControladorPaciente controladorPaciente= new ControladorPaciente();
    private final ControladorDoctor controladorDoctor = new ControladorDoctor();
    private Cita citaAtender;
    private Emergencia emergenciaAtender;
    private int idPaciente;
    ArrayList<AsignacionMedicamento> asignacionMedicamentos;
    public JDialogAtencion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JDialogAtencion(java.awt.Frame parent, boolean modal, Cita citaAtender, Emergencia emergenciaAtender) {
        this(parent, modal);
        this.citaAtender = citaAtender;
        this.emergenciaAtender = emergenciaAtender;

        if (citaAtender != null) {
            this.idDoctor = citaAtender.getDoctorSolicitado().getIdDoctor();
            this.idPaciente = citaAtender.getPacienteSolicitante().getIdPaciente();
        } else if (emergenciaAtender != null) {
            this.idDoctor = emergenciaAtender.getDoctorSolicitado().getIdDoctor();
            this.idPaciente = emergenciaAtender.getPacienteSolicitante().getIdPaciente(); // Asegúrate que este método exista
        }
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
            PacienteDetalleDTO pac;
            if (citaAtender != null) {
                pac = controladorPaciente.pacientePorIdBasico(citaAtender.getPacienteSolicitante().getIdPaciente());
            }
            else{
                pac = controladorPaciente.pacientePorIdBasico(emergenciaAtender.getPacienteSolicitante().getIdPaciente());
            }
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
            if (citaAtender != null) {
                controladorPaciente.citaAtendida(citaAtender.getPacienteSolicitante().getIdPaciente());
            }
            else{
                controladorPaciente.emergenciaAtendida(emergenciaAtender.getPacienteSolicitante().getIdPaciente());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void GenerarReceta(){
        try {
            String medicamentosReceta = "";
            for (AsignacionMedicamento asmed : asignacionMedicamentos) {
                medicamentosReceta += asmed.toString() + "\n";
            }
            
            String doc = controladorDoctor.obtenerNombreDoctor(idDoctor);
            String pac = controladorPaciente.obtenerNombrePaciente(idPaciente);
            String fechaHora = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
            String fechaMostrada = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
            String nombreArchivo = "recetas/receta_paciente_" + idPaciente + "_" + fechaHora + ".pdf";
            
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph titulo = new Paragraph("Receta Médica", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10);
            document.add(titulo);
            
            Font fechaFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Paragraph fecha = new Paragraph("Fecha de emisión: " + fechaMostrada, fechaFont);
            fecha.setAlignment(Element.ALIGN_CENTER);
            fecha.setSpacingAfter(20);
            document.add(fecha);

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

            table.addCell("Diagnostico");
            table.addCell(txtDiagnostico.getText());

            table.addCell("Medicamentos y Dosis");
            table.addCell(medicamentosReceta);

            table.addCell("Observaciones");
            table.addCell(txtObservaciones.getText());
            
            table.addCell("Tipo tratamiento");
            table.addCell(txtTipoTratamiento.getText());
            
            table.addCell("Indicaciones");
            table.addCell(txtIndicaciones.getText());

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
        Diagnostico1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        Diagnostico2 = new javax.swing.JLabel();
        btnHabilitar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtTipoTratamiento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dtpInicio = new com.github.lgooddatepicker.components.DatePicker();
        dtpFin = new com.github.lgooddatepicker.components.DatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIndicaciones = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        Diagnostico3 = new javax.swing.JLabel();
        txtReceta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnVerHistorial = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Diagnostico1.setText("Diagnostico");
        Diagnostico1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setRows(5);
        jScrollPane4.setViewportView(txtDiagnostico);

        Diagnostico2.setText("Tratamiento: En caso ser necesario");
        Diagnostico2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnHabilitar.setText("Disabled");
        btnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarActionPerformed(evt);
            }
        });

        txtTipoTratamiento.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("Tipo:");

        jLabel2.setText("Inicio:");

        jLabel4.setText("Fin:");

        txtIndicaciones.setColumns(20);
        txtIndicaciones.setRows(5);
        jScrollPane1.setViewportView(txtIndicaciones);

        jLabel9.setText("Indicaciones:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtpInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(dtpInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(dtpFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Diagnostico1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Diagnostico2)
                        .addGap(18, 18, 18)
                        .addComponent(btnHabilitar))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Diagnostico1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Diagnostico2)
                    .addComponent(btnHabilitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        Diagnostico3.setText("Observaciones");
        Diagnostico3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtReceta.setText("Elaborar Receta");
        txtReceta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Diagnostico3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(txtReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Diagnostico3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnVerHistorial.setText("Ver Historial Medico");
        btnVerHistorial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerHistorialActionPerformed(evt);
            }
        });

        btnTerminar.setText("Terminar Consulta");
        btnTerminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVerHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
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
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel4MouseMoved

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        try {
            if (asignacionMedicamentos.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No puede continuasr sin asignar una receta", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int opcion = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de terminar la consulta?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                ConsultaMedica consultaMedica = new ConsultaMedica();
                consultaMedica.setCita(citaAtender);
                consultaMedica.setEmergencia(emergenciaAtender);
                consultaMedica.setFechaHoraAtencion(LocalDateTime.now());
                consultaMedica.setDiagnostico(txtDiagnostico.getText());
                Receta recetanueva = new Receta();
                //recetanueva.getConsulta().setConsultaMedicaID();          obtener codconsulta para receta y tratamiento
                recetanueva.setFechEmision(LocalDate.now());
                recetanueva.setObservaciones(txtObservaciones.getText());
                // obtener recepta para asigmendicamtos

                //registrar consulta primero
                ControladorConsulta controladorConsulta = new ControladorConsulta();
                ControladorReceta controladorReceta = new ControladorReceta();
                ControladorTratamiento controladorTratamiento = new ControladorTratamiento();
                ControladorMedicamentos controladorMedicamentos = new ControladorMedicamentos();
                int idConsulta = controladorConsulta.registrarConsulta(consultaMedica);
                recetanueva.getConsulta().setConsultaMedicaID(idConsulta);
                
                if (btnHabilitar.getText().equals("Disabled")) {
                    Tratamiento nuevoTratamiento = new Tratamiento();
                    nuevoTratamiento.setTipo(txtTipoTratamiento.getText());
                    nuevoTratamiento.setFechaInicio(dtpInicio.getDate());
                    nuevoTratamiento.setFechaFin(dtpFin.getDate());
                    nuevoTratamiento.setIndicaciones(txtIndicaciones.getText());
                    nuevoTratamiento.getConsulta().setConsultaMedicaID(idConsulta);
                    controladorTratamiento.registrarTratamiento(nuevoTratamiento);
                }
                int idReceta = controladorReceta.RegistrarReceta(recetanueva);
                for (AsignacionMedicamento asmed : asignacionMedicamentos) {
                    asmed.getReceta().setRecetaID(idReceta);
                    controladorMedicamentos.registrarAsignacionMedicamento(asmed);
                }
                GenerarReceta();
                Atendida();
                JOptionPane.showMessageDialog(rootPane, "Se culmino la atencion y se genero receta", "Exito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else if(opcion == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(rootPane, "No se genero la receta", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnVerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHistorialActionPerformed
        JDialogHistorialMedico a = new JDialogHistorialMedico(this, true, citaAtender.getPacienteSolicitante().getIdPaciente());
        a.setLocationRelativeTo(null);
        a.setVisible(true); 
    }//GEN-LAST:event_btnVerHistorialActionPerformed

    private void txtAgregarAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarAlergiaActionPerformed
        JDialogAgregarAleriga a = new JDialogAgregarAleriga((JFrame)SwingUtilities.getWindowAncestor(JDialogAtencion.this), true);
        a.setLocationRelativeTo(null);
        a.setVisible(true); 
        MostrarDatosPaciente();
    }//GEN-LAST:event_txtAgregarAlergiaActionPerformed

    private void txtRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecetaActionPerformed
        JDialgoCreacionReceta b = new JDialgoCreacionReceta(this, true);
        b.setLocationRelativeTo(null);
        b.setVisible(true); 
        asignacionMedicamentos = b.getAsignacionMedicamentos();
    }//GEN-LAST:event_txtRecetaActionPerformed

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        if (btnHabilitar.getText().equals("Disabled")) {
            btnHabilitar.setText("Enabled");
            txtTipoTratamiento.setEnabled(false);
            dtpInicio.setEnabled(false);
            dtpFin.setEnabled(false);
            txtIndicaciones.setEnabled(false);
        }
        else{
            btnHabilitar.setText("Disabled");
            txtTipoTratamiento.setEnabled(true);
            dtpInicio.setEnabled(true);
            dtpFin.setEnabled(true);
            txtIndicaciones.setEnabled(true);
        }
    }//GEN-LAST:event_btnHabilitarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Diagnostico1;
    private javax.swing.JLabel Diagnostico2;
    private javax.swing.JLabel Diagnostico3;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnVerHistorial;
    private com.github.lgooddatepicker.components.DatePicker dtpFin;
    private com.github.lgooddatepicker.components.DatePicker dtpInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton txtAgregarAlergia;
    private javax.swing.JTextArea txtAlergias;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextArea txtIndicaciones;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JButton txtReceta;
    private javax.swing.JTextField txtTipoSangre;
    private javax.swing.JTextField txtTipoTratamiento;
    // End of variables declaration//GEN-END:variables
}
