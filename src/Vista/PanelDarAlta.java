/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controladores.ControladorHabitacion;
import Modelo.DTO.HabitacionPacienteDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apnil
 */
public class PanelDarAlta extends javax.swing.JPanel {

    /**
     * Creates new form PanelDarAlta
     */
    public PanelDarAlta() {
        try {
            initComponents();
            CargarHabitacionesDiponibles();
            eventoTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error:  " + ex.getMessage());
        }
    }

    private void CargarHabitacionesDiponibles() throws Exception{
        try{
            ControladorHabitacion controladorHabitacion = new ControladorHabitacion();
            ArrayList<HabitacionPacienteDTO> lista = controladorHabitacion.obtenerHabitacionesConPacientesActivos();
            
            DefaultTableModel modelo = (DefaultTableModel)tablaHabitacionesOcupadas.getModel();
            modelo.setRowCount(0); 
            for (HabitacionPacienteDTO a : lista) {
                modelo.addRow(new Object[]{
                    a.getHabitacionID(),
                    a,
                    a.getNombrePaciente()
                });
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar habitaciones: "+ex.getMessage());
        }
    }
    private void eventoTabla(){
        tablaHabitacionesOcupadas.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender("Dar Alta"));
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void Action(int row, String texto) {
                try {
                    ControladorHabitacion controladorHabitacion = new ControladorHabitacion();
                    HabitacionPacienteDTO habitacion =  (HabitacionPacienteDTO)tablaHabitacionesOcupadas.getValueAt(row, 1);
                    int idhabitacion = (int)tablaHabitacionesOcupadas.getValueAt(row, 0);
                    controladorHabitacion.darAltaEmergencia(habitacion.getEmergenciaID(), idhabitacion);
                    JOptionPane.showMessageDialog(null, "El paciente salio con vida", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    CargarHabitacionesDiponibles();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al dar de alta: "+ex.getMessage());
                }
            }
        };
        tablaHabitacionesOcupadas.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event, "Dar Alta"));
        
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        tablaHabitacionesOcupadas.getColumnModel().getColumn(0).setCellRenderer(centrado);
        tablaHabitacionesOcupadas.getColumnModel().getColumn(1).setCellRenderer(centrado);
        tablaHabitacionesOcupadas.getColumnModel().getColumn(2).setCellRenderer(centrado);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHabitacionesOcupadas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        tablaHabitacionesOcupadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NombreHabitacion", "Paciente", "Alta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaHabitacionesOcupadas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 129, 930, 470));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAR DE ALTA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 930, 70));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaHabitacionesOcupadas;
    // End of variables declaration//GEN-END:variables
}
