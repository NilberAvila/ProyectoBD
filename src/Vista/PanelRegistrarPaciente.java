/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.Alergia;
import Modelo.Paciente;
import Controladores.ControladorAlergia;
import Controladores.ControladorPaciente;
import Modelo.Especialidad;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import util.Placeholders;
/**
 *
 * @author apnil
 */
public class PanelRegistrarPaciente extends javax.swing.JPanel {

    /**
     * Creates new form PanelRegistrarPaciente
     */
    private Color col;
    private int idPacientetemp = 0;
    private Paciente paciente = new Paciente();
    private ArrayList<Alergia> alergias = new ArrayList();
    private ArrayList<Integer> indicestemporales = new ArrayList();
    public PanelRegistrarPaciente(Color col) {
        initComponents();
        inicializarPlaceholders();
        lblFecha.setText(EstablecerFecha());
        this.col = col;
        cbGenero.setSelectedIndex(-1);
        EstablecerColor();
        btnRegistrar.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
    }
    private String EstablecerFecha(){
        LocalDate fecha = LocalDate.now();
        int dia = fecha.getDayOfMonth();
        int mesint = fecha.getMonthValue();
        int año = fecha.getYear();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return "Hoy es " + dia + " del " + meses[mesint-1] + " de " + año;
    }
    private void EstablecerColor(){
        jSeparator1.setForeground(col);
        jSeparator4.setForeground(col);
        jSeparator5.setForeground(col);
        jSeparator6.setForeground(col);
        jSeparator7.setForeground(col);
        jSeparator8.setForeground(col);
        jSeparator9.setForeground(col);
        btnRegistrar.setBackground(col);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgAlergias = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        dpFechaNac = new org.jdesktop.swingx.JXDatePicker();
        txtDocIdentidad = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtAPaterno = new javax.swing.JTextField();
        txtAMaterno = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        cbTipoSangre = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cbAlergia = new javax.swing.JComboBox<>();
        btnNuevaAlergia = new javax.swing.JButton();
        txtAgregarAlergia = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(970, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel2.setText("Registar nuevo Paciente");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        lblFecha.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(51, 51, 51));
        lblFecha.setText("Hoy es 0 de Mes de 0000");
        add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 860, 50));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 10, 410));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombres");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 130, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Apellido Paterno");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 130, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Documento de Identidad");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 190, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Fecha Nacimiento");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 130, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Genero");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 80, 30));

        cbGenero.setBackground(new java.awt.Color(242, 242, 242));
        cbGenero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        cbGenero.setOpaque(true);
        add(cbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, 30));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 160, 10));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Apellido Materno");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 130, 30));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 160, 10));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Telefono");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 130, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Correo");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 130, 30));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 180, 10));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 150, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Alergia");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 130, 30));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 370, 10));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 350, 10));
        add(dpFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 130, 30));

        txtDocIdentidad.setBackground(new java.awt.Color(242, 242, 242));
        txtDocIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDocIdentidad.setForeground(new java.awt.Color(153, 153, 153));
        txtDocIdentidad.setText("Ingrese el numero de su documento de indentidad (DNI / CE)");
        txtDocIdentidad.setBorder(null);
        add(txtDocIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 350, 30));

        txtDireccion.setBackground(new java.awt.Color(242, 242, 242));
        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion.setText("Ingrese su Direccion");
        txtDireccion.setBorder(null);
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 350, 30));

        txtAPaterno.setBackground(new java.awt.Color(242, 242, 242));
        txtAPaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAPaterno.setForeground(new java.awt.Color(153, 153, 153));
        txtAPaterno.setText("Ingrese su Apellido Paterno");
        txtAPaterno.setBorder(null);
        add(txtAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 160, 30));

        txtAMaterno.setBackground(new java.awt.Color(242, 242, 242));
        txtAMaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAMaterno.setForeground(new java.awt.Color(153, 153, 153));
        txtAMaterno.setText("Ingrese su Apellido Materno");
        txtAMaterno.setBorder(null);
        add(txtAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 160, 30));

        txtNombres.setBackground(new java.awt.Color(242, 242, 242));
        txtNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(153, 153, 153));
        txtNombres.setText("Ingrese sus nombres");
        txtNombres.setBorder(null);
        add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 350, 30));

        txtTelefono.setBackground(new java.awt.Color(242, 242, 242));
        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefono.setText("Ingrese su Numero de Telefono");
        txtTelefono.setBorder(null);
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 190, 30));

        txtCorreo.setBackground(new java.awt.Color(242, 242, 242));
        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(153, 153, 153));
        txtCorreo.setText("Ingrese su Correo");
        txtCorreo.setBorder(null);
        add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 170, 30));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 370, 60));

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Tipo de sangre:");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, -1, 30));
        add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 350, 10));

        cbTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A−", "B+", "B−", "AB+", "AB−", "O+", "O−" }));
        add(cbTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 110, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Direccion");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 130, 30));

        add(cbAlergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 170, 40));

        btnNuevaAlergia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevaAlergia.setText("¿Nueva Alergia?");
        btnNuevaAlergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaAlergiaActionPerformed(evt);
            }
        });
        add(btnNuevaAlergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 170, 40));

        txtAgregarAlergia.setText("Agregar Alergia");
        txtAgregarAlergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarAlergiaActionPerformed(evt);
            }
        });
        add(txtAgregarAlergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            ControladorPaciente consPa = new ControladorPaciente();
            ControladorAlergia controladorAlergia = new ControladorAlergia();
            // Datos del paciente
            paciente.setNombre(txtNombres.getText());
            paciente.setApellidoPaterno(txtAPaterno.getText());
            paciente.setApellidoMaterno(txtAMaterno.getText());
            paciente.setGenero(cbGenero.getSelectedItem().toString());
            paciente.setNumDoc(txtDocIdentidad.getText());
            paciente.setTipoDoc("DNI");
            paciente.setTelefono(txtTelefono.getText());
            paciente.setCorreo(txtCorreo.getText());
            paciente.setDireccion(txtDireccion.getText());
            paciente.setGrupoSanguineo((String)cbTipoSangre.getSelectedItem());
            Date fecha = dpFechaNac.getDate();
            LocalDate FechaNacimiento = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            paciente.setFechaNacimiento(FechaNacimiento);
            idPacientetemp = consPa.registrar_paciente(paciente);
            for (Alergia al : alergias) {
                
                indicestemporales.add(controladorAlergia.agregarAlergia(al));
            }
            for(int indice : indicestemporales){
                controladorAlergia.agregarRelacionPacienteAlergia(idPacientetemp, indice);
            }
            JOptionPane.showMessageDialog(this, "Paciente registrado correctamente",  "Exito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar: " + e.getMessage(),  "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevaAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaAlergiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaAlergiaActionPerformed

    private void txtAgregarAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarAlergiaActionPerformed
        int Index = cbAlergia.getSelectedIndex();
        Especialidad EspecialidadesSleccionada = lista.get(Index);
        if (ListaEspecialidadDoctor.contains(EspecialidadesSleccionada)) {
        JOptionPane.showMessageDialog(this, "Esta especialidad ya ha sido agregada.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
        }
    }//GEN-LAST:event_txtAgregarAlergiaActionPerformed
      
    private void inicializarPlaceholders(){
        Placeholders.configurarPlaceholder(txtNombres, "Ingrese sus nombres");
        Placeholders.configurarPlaceholder(txtAPaterno, "Ingrese su Apellido Paterno");
        Placeholders.configurarPlaceholder(txtAMaterno, "Ingrese su Apellido Materno");
        Placeholders.configurarPlaceholder(txtTelefono, "Ingrese su Numero de Telefono");
        Placeholders.configurarPlaceholder(txtCorreo, "Ingrese su Correo");
        Placeholders.configurarPlaceholder(txtDireccion, "Ingrese su Direccion");
        Placeholders.configurarPlaceholder(txtDocIdentidad, "Ingrese su doc. de indentidad");;
    }
    
    private void limpiarCampos() {
        txtNombres.setText("");
        txtAPaterno.setText("");
        txtAMaterno.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtDocIdentidad.setText("");
        inicializarPlaceholders();
        cbGenero.setSelectedIndex(-1);
        dpFechaNac.setDate(null);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgAlergias;
    private javax.swing.JButton btnNuevaAlergia;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbAlergia;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbTipoSangre;
    private org.jdesktop.swingx.JXDatePicker dpFechaNac;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JTextField txtAMaterno;
    private javax.swing.JTextField txtAPaterno;
    private javax.swing.JButton txtAgregarAlergia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocIdentidad;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
