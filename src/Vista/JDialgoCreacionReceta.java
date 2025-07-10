/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Controladores.ControladorMedicamentos;
import Modelo.AsignacionMedicamento;
import Modelo.Medicamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import util.Placeholders;

/**
 *
 * @author apnil
 */
public class JDialgoCreacionReceta extends javax.swing.JDialog {
    
    private Medicamento medicamentoTemp = new Medicamento();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JDialgoCreacionReceta.class.getName());

    private ArrayList<Medicamento> medicamentos;
    private ArrayList<AsignacionMedicamento> asigMedicamentos;
    
    public JDialgoCreacionReceta(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        asigMedicamentos = new ArrayList();
        InicializarPlaceholders();
        obtenerMedicamentos();
        mostrarDatos();
        eventoTxt();
        eventoJTable();
    }

    private void obtenerMedicamentos(){
        try {
            ControladorMedicamentos controladorMedicamentos = new ControladorMedicamentos();
            medicamentos = controladorMedicamentos.obtenerMedicamentos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eventoTxt(){
        txtBuscarMedicamento.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrarDatos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrarDatos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    private void eventoJTable(){
        JTMedicamentos.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender("Asignar"));
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void Action(int row, String texto) {
                try {
                    medicamentoTemp = (Medicamento)JTMedicamentos.getValueAt(row, 0);
                    txtMedicamento.setText(medicamentoTemp.getNombreMedicamento());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        JTMedicamentos.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event, "Asignar"));
    }
    
    private void mostrarDatos(){
        if (txtBuscarMedicamento.getText().trim().isEmpty() || txtBuscarMedicamento.getText().equals("Ingrese el nombre del medicamento a buscar")) {
            llenarTabla(medicamentos);
        }
        else{
            ControladorMedicamentos controladorMedicamentos = new ControladorMedicamentos();
            ArrayList<Medicamento> medicamentosFiltrados = controladorMedicamentos.filtrarMedicamentosPorNombre(medicamentos, txtBuscarMedicamento.getText());
            llenarTabla(medicamentosFiltrados);
        }
    }
    
    private void llenarTabla(ArrayList<Medicamento> medicamentos){
        DefaultTableModel modelo = (DefaultTableModel)JTMedicamentos.getModel();
        modelo.setRowCount(0); 
        for (Medicamento a : medicamentos) {
            modelo.addRow(new Object[]{
                a,
                a.getConcentracion(),
                a.getDescripcion()
            });
        }
    }
    
    private void verReceta(){
        String detalleReceta = "";
        for (AsignacionMedicamento a : asigMedicamentos) {
            detalleReceta += a.getMedicamento().getNombreMedicamento() + "      "+ a.getDosis()  + "      " +  a.getFrecuencia()  + "      " + a.getDuracion() + "\n";
        }
        txtDetallerReceta.setText(detalleReceta);
    }
    
    private void Limpiar(){
        medicamentoTemp = null;
        txtDosis.setText("");
        txtDuracion.setText("");
        txtFrecuencia.setText("");
        txtMedicamento.setText("");
        InicializarPlaceholders();
    }
    
    private void InicializarPlaceholders(){
        Placeholders.configurarPlaceholder(txtBuscarMedicamento, "Ingrese el nombre del medicamento a buscar");
        Placeholders.configurarPlaceholder(txtDosis, "Ejm: 500mg");
        Placeholders.configurarPlaceholder(txtDuracion, "Ejm: 5 dias");
        Placeholders.configurarPlaceholder(txtFrecuencia, "Ejm: Cada 8 horas");
    }
    
    public ArrayList<AsignacionMedicamento> getAsignacionMedicamentos(){
        return asigMedicamentos;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTMedicamentos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetallerReceta = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtMedicamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDosis = new javax.swing.JTextField();
        txtFrecuencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarMedicamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Medicamento", "Concentracion", "Descripcion", "Asignar"
            }
        ));
        jScrollPane1.setViewportView(JTMedicamentos);
        if (JTMedicamentos.getColumnModel().getColumnCount() > 0) {
            JTMedicamentos.getColumnModel().getColumn(0).setResizable(false);
            JTMedicamentos.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 700, 660));

        jPanel2.setBackground(new java.awt.Color(32, 178, 170));

        txtDetallerReceta.setColumns(20);
        txtDetallerReceta.setRows(5);
        jScrollPane2.setViewportView(txtDetallerReceta);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Medicamento");

        txtMedicamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMedicamento.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Dosis");

        txtDosis.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDosis.setForeground(new java.awt.Color(153, 153, 153));
        txtDosis.setText("Ejm: 500mg");

        txtFrecuencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFrecuencia.setForeground(new java.awt.Color(153, 153, 153));
        txtFrecuencia.setText("Ejm: Cada 8 horas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Frecuencia");

        txtDuracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDuracion.setForeground(new java.awt.Color(153, 153, 153));
        txtDuracion.setText("Ejm: 5 dias");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Duracion");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar a la Receta");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("RECETA:");

        jButton1.setText("Registar Receta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(txtMedicamento)
                    .addComponent(txtDosis)
                    .addComponent(txtFrecuencia)
                    .addComponent(txtDuracion)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 510, 720));

        jPanel3.setBackground(new java.awt.Color(32, 178, 170));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Medicamentos para la Receta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(366, 366, 366))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 50));

        txtBuscarMedicamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBuscarMedicamento.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscarMedicamento.setText("Ingrese el nombre del medicamento a buscar");
        txtBuscarMedicamento.setBorder(null);
        jPanel1.add(txtBuscarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 640, 50));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Search.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 60, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1211, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AsignacionMedicamento asigAsignacionMedicamento = new AsignacionMedicamento();
        asigAsignacionMedicamento.setMedicamento(medicamentoTemp);
        asigAsignacionMedicamento.setDosis(txtDosis.getText());
        asigAsignacionMedicamento.setFrecuencia(txtFrecuencia.getText());
        asigAsignacionMedicamento.setDuracion(txtDuracion.getText());
        asigMedicamentos.add(asigAsignacionMedicamento);
        verReceta();
        Limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTMedicamentos;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBuscarMedicamento;
    private javax.swing.JTextArea txtDetallerReceta;
    private javax.swing.JTextField txtDosis;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtFrecuencia;
    private javax.swing.JTextField txtMedicamento;
    // End of variables declaration//GEN-END:variables
}
