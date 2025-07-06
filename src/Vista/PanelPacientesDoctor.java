/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.Paciente;
import Controladores.ControladorPaciente;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import util.Placeholders;

/**
 *
 * @author apnil
 */
public class PanelPacientesDoctor extends javax.swing.JPanel {
    private ArrayList<Paciente> pacientesOriginal = new ArrayList();
    private ControladorPaciente controlPac = new ControladorPaciente();
    
    public PanelPacientesDoctor() {
        initComponents();
        inicializarDatos();
    }
    
    private void inicializarDatos(){
        try {
            controlPac.obtenerPacientesDni();
            pacientesOriginal = controlPac.listaPacientes;
            llenarTablaPacientes(pacientesOriginal);
            Placeholders.configurarPlaceholder(txtBuscar, "Ingrese el nombre o documento de identidad del paciente a buscar");
            eventoTabla();
            eventoTabla2();
            eventoTextField();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }       
    private void eventoTabla(){
        
        tablaPacientes.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender("Ver y Actualizar"));
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void Action(int row, String texto) {
                try {
                    Paciente pac = (Paciente)tablaPacientes.getValueAt(row, 1);
                   JDialogActualizarPaciente a = new JDialogActualizarPaciente((JFrame)SwingUtilities.getWindowAncestor(PanelPacientesDoctor.this),true,pac);
                   a.setLocationRelativeTo(null);
                   a.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        tablaPacientes.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event, "Ver y Actualizar"));
    }
    
    private void eventoTabla2(){
        tablaPacientes.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender("Eliminar"));
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void Action(int row, String texto) {
                try {
                    int idPaciente = Integer.parseInt(tablaPacientes.getValueAt(row, 0).toString());
                    ControladorPaciente controladorPaciente = new ControladorPaciente();
                    controladorPaciente.EliminarPaciente(idPaciente);
                    controlPac.obtenerPacientesDni();
                    pacientesOriginal = controlPac.listaPacientes;
                    llenarTablaPacientes(pacientesOriginal);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(jPanel1, e.getMessage());
                }
            }
        };
        tablaPacientes.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event, "Eliminar"));
    }
    
    private void eventoTextField(){
        txtBuscar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                Mostrar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Mostrar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }
    
    private void Mostrar(){
        if (txtBuscar.getText().trim().isEmpty()) {
            llenarTablaPacientes(pacientesOriginal);
        }
        else{
            llenarTablaPacientes(controlPac.FiltrarPacientes(txtBuscar.getText()));
        }
    }
    
    private void llenarTablaPacientes(ArrayList<Paciente> lista) {
        DefaultTableModel modelo = (DefaultTableModel)tablaPacientes.getModel();
            modelo.setRowCount(0); 
            for (Paciente p : lista) {
                modelo.addRow(new Object[]{
                    p.getIdPaciente(),
                    p,
                    p.getNumDoc(),
                });
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtBuscar = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(970, 620));
        setRequestFocusEnabled(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(970, 620));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Tabla De Pacientes Registrados");

        jScrollPane2.setBorder(null);

        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IdPaciente", "Nombres", "Doc Identidad", "Ver Datos", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPacientes);
        if (tablaPacientes.getColumnModel().getColumnCount() > 0) {
            tablaPacientes.getColumnModel().getColumn(0).setResizable(false);
            tablaPacientes.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaPacientes.getColumnModel().getColumn(1).setResizable(false);
            tablaPacientes.getColumnModel().getColumn(2).setResizable(false);
            tablaPacientes.getColumnModel().getColumn(3).setResizable(false);
            tablaPacientes.getColumnModel().getColumn(3).setPreferredWidth(20);
            tablaPacientes.getColumnModel().getColumn(4).setResizable(false);
            tablaPacientes.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 930, 510));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Search.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 51, -1));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 840, 10));

        txtBuscar.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscar.setText("Ingrese el nombre o documento de identidad del paciente a buscar");
        txtBuscar.setBorder(null);
        jPanel4.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 6, 840, 38));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 930, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablaPacientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
