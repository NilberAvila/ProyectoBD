/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.Especialidad;
import Controladores.ControladorEspecialidades;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
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
        eventoTabla();
    }
    private void cargarEspecialdiadesTabla(){
        try{
            DefaultTableModel  modelo = new DefaultTableModel ();     
            modelo.addColumn("ID");
            modelo.addColumn("Especialidad");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Eliminar");
            ControladorEspecialidades controladorEspecialidades = new ControladorEspecialidades();
            ArrayList<Especialidad> Lista = controladorEspecialidades.ObtenerEspecialidadesC();
            
            for(Especialidad esp : Lista){
                Object [] Fila = {esp.getIdEspecialidad(),esp.getNombre(),esp.getDescripcion(),""};
                modelo.addRow(Fila);
            }
            TablaEspecialidades.setModel(modelo);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void eventoTabla(){
     
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void Action(int row, String texto) {
                String Id = (String)TablaEspecialidades.getValueAt(row, 0).toString();
                int IDespecialidad = Integer.parseInt(Id);         
                try {
                    ControladorEspecialidades CE = new ControladorEspecialidades();
                    CE.EliminarEspecialidad(IDespecialidad);
                    cargarEspecialdiadesTabla();
                    eventoTabla();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        };
        TablaEspecialidades.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender("Eliminar"));
        TablaEspecialidades.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event, "Eliminar"));
        
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        TablaEspecialidades.getColumnModel().getColumn(0).setCellRenderer(centrado);
        TablaEspecialidades.getColumnModel().getColumn(1).setCellRenderer(centrado);
        TablaEspecialidades.getColumnModel().getColumn(2).setCellRenderer(centrado);
        
    }
    
    private void eventoTextFiel(){
        txtBuscarEspecialdiad.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
    }
    
    private void ObtenerDatos(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtBuscarEspecialdiad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEspecialidades = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_agregarEspecialidad1 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txt_especialidadDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ESPECIALIDAD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNewDescripcion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNewNombre = new javax.swing.JTextField();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        TablaEspecialidades.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TablaEspecialidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Especialidad", "Descripción", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaEspecialidades);
        if (TablaEspecialidades.getColumnModel().getColumnCount() > 0) {
            TablaEspecialidades.getColumnModel().getColumn(0).setResizable(false);
            TablaEspecialidades.getColumnModel().getColumn(1).setResizable(false);
            TablaEspecialidades.getColumnModel().getColumn(2).setResizable(false);
            TablaEspecialidades.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ingrese nombre de la especialidad:");

        jLabel6.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BUSCAR ESPECIALIDAD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarEspecialdiad)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarEspecialdiad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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
        jPanel4.add(btn_agregarEspecialidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel4.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, -1, -1));
        jPanel4.add(txt_especialidadDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 190, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripción:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Especialidad:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jPanel4.add(txt_ESPECIALIDAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 190, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ACTUALIZAR ESPECIALDIAD");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("AGREGAR ESPECIALIDAD");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));
        jPanel4.add(txtNewDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 190, -1));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Descripción:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Especialidad:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));
        jPanel4.add(txtNewNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 190, -1));

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
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try{
            ControladorEspecialidades controladorEspecialidades = new ControladorEspecialidades();
            controladorEspecialidades.ActualizarEsepecialidad(txtBuscarEspecialdiad.getText(), txtNewNombre.getText(), txtNewDescripcion.getText());
            cargarEspecialdiadesTabla();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEspecialidades;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btn_agregarEspecialidad1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscarEspecialdiad;
    private javax.swing.JTextField txtNewDescripcion;
    private javax.swing.JTextField txtNewNombre;
    private javax.swing.JTextField txt_ESPECIALIDAD;
    private javax.swing.JTextField txt_especialidadDescripcion;
    // End of variables declaration//GEN-END:variables
}
