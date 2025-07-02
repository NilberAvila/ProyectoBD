/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.Especialidad;
import Controladores.ControladorEspecialidades;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author USUARIO
 */
public class PanelEspecialidades extends javax.swing.JPanel {
    /**
     * Creates new form PanelEspecialidades
     */
    public PanelEspecialidades() {
        initComponents();
        cargarEspecialdiadesTabla();
    }
    private void cargarEspecialdiadesTabla(){
        try{
            DefaultTableModel  modelo = new DefaultTableModel ();              
            modelo.addColumn("Nombre");
            modelo.addColumn("Descripcion");

            ControladorEspecialidades controladorEspecialidades = new ControladorEspecialidades();
            ArrayList<Especialidad> Lista = controladorEspecialidades.ObtenerEspecialidadesC();

            for(Especialidad esp : Lista){
                Object [] Fila = {esp.getNombre(),esp.getDescripcion()};
                modelo.addRow(Fila);
            }
            TablaEspecialidades.setModel(modelo);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtBuscarEspecialdiad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEspecialidades = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_agregarEspecialidad1 = new javax.swing.JButton();
        btn_agregarEspecialidad = new javax.swing.JButton();
        txt_especialidadDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ESPECIALIDAD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TEXTDESCRIPCION = new javax.swing.JTextArea();
        labelNombre = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        TablaEspecialidades.setBackground(new java.awt.Color(153, 204, 255));
        TablaEspecialidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Especialidad", "Descripción", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaEspecialidades);

        btnBuscar.setText("Buscar Especialidad");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ingrese nombre de la especialidad:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BUSCAR ESPECIALIDAD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarEspecialdiad, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(231, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(197, 197, 197)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarEspecialdiad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnBuscar))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jLabel6)
                    .addContainerGap(549, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 620));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_agregarEspecialidad1.setText("Agregar");
        btn_agregarEspecialidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarEspecialidad1ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_agregarEspecialidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        btn_agregarEspecialidad.setText("Actualizar");
        btn_agregarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarEspecialidadActionPerformed(evt);
            }
        });
        jPanel4.add(btn_agregarEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, -1));
        jPanel4.add(txt_especialidadDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 210, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripción");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Especialidad");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));
        jPanel4.add(txt_ESPECIALIDAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 210, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AGREGAR ESPECIALIDAD");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        TEXTDESCRIPCION.setColumns(20);
        TEXTDESCRIPCION.setRows(5);
        jScrollPane3.setViewportView(TEXTDESCRIPCION);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        labelNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("....");
        jPanel4.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 320, 620));

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

    private void btn_agregarEspecialidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarEspecialidad1ActionPerformed
        try{
            String Nombre = txt_ESPECIALIDAD.getText();
            String Descripcion = txt_especialidadDescripcion.getText();
            Especialidad RegistrarEspecialdiad = new Especialidad();
            RegistrarEspecialdiad.setNombre(Nombre);
            RegistrarEspecialdiad.setDescripcion(Descripcion);
            ControladorEspecialidades controladorEspecialidades = new ControladorEspecialidades();
            controladorEspecialidades.Agregar_Especialidades(RegistrarEspecialdiad);
            cargarEspecialdiadesTabla();
            JOptionPane.showMessageDialog(this, "Se registro la especialidad Correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }     
    }//GEN-LAST:event_btn_agregarEspecialidad1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{
            ControladorEspecialidades controladorEspecialidades = new ControladorEspecialidades();
            Especialidad esp = controladorEspecialidades.BuscarEspecialidad(txtBuscarEspecialdiad.getText());
            if(esp != null){
                labelNombre.setText(esp.getNombre());
                TEXTDESCRIPCION.setText(esp.getDescripcion());
                JOptionPane.showMessageDialog(this, "Especialdiad Encontrada","Exito", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Especialdiad no Encontrada","Exito", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btn_agregarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarEspecialidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TEXTDESCRIPCION;
    private javax.swing.JTable TablaEspecialidades;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btn_agregarEspecialidad;
    private javax.swing.JButton btn_agregarEspecialidad1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTextField txtBuscarEspecialdiad;
    private javax.swing.JTextField txt_ESPECIALIDAD;
    private javax.swing.JTextField txt_especialidadDescripcion;
    // End of variables declaration//GEN-END:variables
}
