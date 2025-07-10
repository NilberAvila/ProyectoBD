/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controladores.ControladorAlergia;
import Modelo.Alergia;
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
public class PanelRegistrarAlergias extends javax.swing.JPanel {


    private ArrayList<Alergia> alergias;
    public PanelRegistrarAlergias() {
        initComponents();
        Placeholders.configurarPlaceholder(txtBuscar, "Ingrese el nombre de la especialidad a buscar");
        
        obtenerDatos();
        mostrarDatos();
      
        eventotxt();
    }

    private void obtenerDatos(){
        try {
            ControladorAlergia controladorAlergia = new ControladorAlergia();
            alergias = controladorAlergia.ObtenerAlergias();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eventotxt(){
        txtBuscar.getDocument().addDocumentListener(new DocumentListener(){
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
    
    private void mostrarDatos(){
        if (txtBuscar.getText().trim().isEmpty()|| txtBuscar.getText().trim().equals("Ingrese el nombre de la especialidad a buscar"))
            llenarTabla(alergias);             
        else{
            ControladorAlergia controladorAlergia = new ControladorAlergia();
            ArrayList<Alergia> alergiasFiltrada = controladorAlergia.filtrarAlergiasPorTexto(alergias, txtBuscar.getText());
            llenarTabla(alergiasFiltrada);
        }
    }

    private void llenarTabla(ArrayList<Alergia> aler ){
        DefaultTableModel modelo = (DefaultTableModel)JTAlergias.getModel();
        modelo.setRowCount(0); 
        for (Alergia a : aler) {
            modelo.addRow(new Object[]{
                a.getNombreAlergia(),
                a.getDescripcion(),
                a.getTipoAlergia()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAlergias = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        fsdfs = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtAlergia = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscar.setText("Ingrese el nombre de la especialidad a buscar");
        txtBuscar.setBorder(null);
        jPanel2.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 520, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Search.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        JTAlergias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(JTAlergias);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 580, 570));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 620));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("AGREGAR ALERGIA");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Tipo de alergia:");

        cbTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Respiratoria", "Alimentarias", "Medicamentos", "Insectos" }));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Alergia:");

        fsdfs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fsdfs.setForeground(new java.awt.Color(255, 255, 255));
        fsdfs.setText("Descripcion:");

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtAlergia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fsdfs, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, 274, Short.MAX_VALUE)
                            .addComponent(txtAlergia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion))
                        .addGap(50, 50, 50)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fsdfs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 390, 620));

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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            ControladorAlergia controladorAlergia = new ControladorAlergia();
            Alergia alergia = new Alergia();
            alergia.setTipoAlergia(cbTipo.getSelectedItem().toString());
            alergia.setNombreAlergia(txtAlergia.getText());
            alergia.setDescripcion(txtDescripcion.getText());
            controladorAlergia.agregarAlergia(alergia);                    
            obtenerDatos();
            mostrarDatos();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTAlergias;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel fsdfs;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlergia;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
