/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controladores.ControladorCita;
import Controladores.ControladorDoctor;
import Modelo.Emergencia;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author apnil
 */
public class PanelAtenderEmergencias extends javax.swing.JPanel {

    /**
     * Creates new form PanelAtenderEmergencias
     */
    
    private ArrayList<Emergencia> emergenciasPendientes;
    public PanelAtenderEmergencias(int idDoctor) {
        initComponents();
        cargarDatos(idDoctor);
    }
    
    
    private void cargarDatos(int idDoctor) {
        try {
            ControladorCita controladorCita = new ControladorCita();
            emergenciasPendientes = controladorCita.obtenerEmergenciasPendientesPorDoctor(idDoctor);
            actualizarTabla();
            actualizarLabels(idDoctor);
            eventoTabla(idDoctor);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) TablaAtencion.getModel();
        model.setRowCount(0);
        for (Emergencia emergencia : emergenciasPendientes) {
            model.addRow(new Object[]{ emergencia, emergencia.getPacienteSolicitante().getNombre(), emergencia.getPrioridadString()});
        }
    }
    
    private void actualizarLabels(int IdDoctor)throws Exception{
        ControladorDoctor controladorDoctor = new ControladorDoctor();
        lblNombreDoc.setText(controladorDoctor.obtenerNombreDoctor(IdDoctor));
        LocalDate hoy = LocalDate.now();
        String fechaFormateada = "Hoy es " + hoy.getDayOfMonth() + " de " +
            hoy.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")) +
            " del " + hoy.getYear();
        lblFecha.setText(fechaFormateada);
    }
    
    private void eventoTabla(int idDoctor){
        TablaAtencion.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender("Atender"));
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void Action(int row, String texto) {
                Emergencia emergenciaTemp = (Emergencia)TablaAtencion.getValueAt(row, 0);
                emergenciaTemp.getDoctorSolicitado().setIdDoctor(idDoctor);
                JDialogAtencion a = new JDialogAtencion((JFrame)SwingUtilities.getWindowAncestor(PanelAtenderEmergencias.this), true, null, emergenciaTemp);
                a.setLocationRelativeTo(null);
                a.setVisible(true); 
                try {
                    emergenciasPendientes = new ControladorCita().obtenerEmergenciasPendientesPorDoctor(idDoctor);
                    actualizarTabla();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        };
        TablaAtencion.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event, "Atender"));
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        TablaAtencion.getColumnModel().getColumn(0).setCellRenderer(centrado);
        TablaAtencion.getColumnModel().getColumn(1).setCellRenderer(centrado);
        TablaAtencion.getColumnModel().getColumn(2).setCellRenderer(centrado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAtencion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblNombreDoc = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        TablaAtencion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TablaAtencion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "IDEmergencia", "Paciente", "Prioridad", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaAtencion.setRowHeight(30);
        TablaAtencion.setSelectionBackground(new java.awt.Color(0, 204, 255));
        jScrollPane1.setViewportView(TablaAtencion);
        if (TablaAtencion.getColumnModel().getColumnCount() > 0) {
            TablaAtencion.getColumnModel().getColumn(0).setResizable(false);
            TablaAtencion.getColumnModel().getColumn(1).setResizable(false);
            TablaAtencion.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Pacientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 910, 460));

        lblNombreDoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreDoc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreDoc.setText("Dr. Nombre Apellido");
        jPanel1.add(lblNombreDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 210, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Male User.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        lblFecha.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        lblFecha.setText("Hoy es 0 de Mes de 0000");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 680, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAtencion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombreDoc;
    // End of variables declaration//GEN-END:variables
}
