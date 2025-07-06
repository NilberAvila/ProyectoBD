/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.Turno;
import Controladores.ControladorDoctor;
import Controladores.ControladorTurno;
import Modelo.DTO.DoctorSimpleDTO;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author apnil
 */
public class PanelRegistrarTurnos extends javax.swing.JPanel {

    /**
     * Creates new form PanelRegistrarTurnos
     */
    ArrayList<DoctorSimpleDTO>  ListaDoctor;
    public PanelRegistrarTurnos() {
        initComponents();
        LlenarCombobox();
    }

    private void LlenarCombobox(){
        try{  
       
            ControladorDoctor CD = new ControladorDoctor();
            ListaDoctor = CD.ObtenerDoctor();
            cbDoctor.removeAllItems();
            

            for(DoctorSimpleDTO D : ListaDoctor){
                cbDoctor.addItem(D.getNombres());
            }
          
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error al cargar combobox"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        checkMiercoles = new javax.swing.JCheckBox();
        checkDomingo = new javax.swing.JCheckBox();
        checkMartes = new javax.swing.JCheckBox();
        checkLunes = new javax.swing.JCheckBox();
        checkJueves = new javax.swing.JCheckBox();
        checkViernes = new javax.swing.JCheckBox();
        checkSabado = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        cbDoctor = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        btnRegistrarTurnos = new javax.swing.JButton();
        cbHoraFinal = new javax.swing.JComboBox<>();
        cbHoraInicio = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Myanmar Text", 3, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("REGISTRAR TURNOS");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 560, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Hospital.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 390, 130));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Myanmar Text", 1, 12)); // NOI18N
        jLabel13.setText("Dias:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Myanmar Text", 1, 12)); // NOI18N
        jLabel18.setText("Hora de Salida:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        checkMiercoles.setBackground(new java.awt.Color(255, 255, 255));
        checkMiercoles.setText("Miercoles");
        add(checkMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, -1));

        checkDomingo.setBackground(new java.awt.Color(255, 255, 255));
        checkDomingo.setText("Domingo");
        add(checkDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        checkMartes.setBackground(new java.awt.Color(255, 255, 255));
        checkMartes.setText("Martes");
        add(checkMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

        checkLunes.setBackground(new java.awt.Color(255, 255, 255));
        checkLunes.setText("Lunes");
        add(checkLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        checkJueves.setBackground(new java.awt.Color(255, 255, 255));
        checkJueves.setText("Jueves");
        add(checkJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        checkViernes.setBackground(new java.awt.Color(255, 255, 255));
        checkViernes.setText("Viernes");
        add(checkViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, -1));

        checkSabado.setBackground(new java.awt.Color(255, 255, 255));
        checkSabado.setText("Sabado");
        add(checkSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Myanmar Text", 1, 12)); // NOI18N
        jLabel19.setText("Hora de Ingreso:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        add(cbDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 220, -1));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Myanmar Text", 1, 12)); // NOI18N
        jLabel20.setText("Seleccion Doctor:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        btnRegistrarTurnos.setBackground(new java.awt.Color(0, 153, 153));
        btnRegistrarTurnos.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        btnRegistrarTurnos.setText("Registrar Turno");
        btnRegistrarTurnos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 51, 51), new java.awt.Color(0, 51, 51), new java.awt.Color(0, 51, 51)));
        btnRegistrarTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTurnosActionPerformed(evt);
            }
        });
        add(btnRegistrarTurnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 160, 50));

        cbHoraFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "16:00", "23:59" }));
        add(cbHoraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 90, -1));

        cbHoraInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00:00", "08:00", "16:00" }));
        add(cbHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTurnosActionPerformed
        try{
            int index = cbDoctor.getSelectedIndex();
            DoctorSimpleDTO DocSelecionado = ListaDoctor.get(index);
            int IdDoctor = DocSelecionado.getIdDoctor();
            DateTimeFormatter Formato = DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH);
            LocalTime HoraInicio = LocalTime.parse(cbHoraInicio.getSelectedItem().toString(),Formato);
            LocalTime HoraFin = LocalTime.parse(cbHoraFinal.getSelectedItem().toString(),Formato);

            ArrayList<DayOfWeek> DiasSeleccionado = new ArrayList<>();
            if(checkLunes.isSelected())DiasSeleccionado.add(DayOfWeek.MONDAY);
            if(checkMartes.isSelected())DiasSeleccionado.add(DayOfWeek.TUESDAY);
            if(checkMiercoles.isSelected())DiasSeleccionado.add(DayOfWeek.WEDNESDAY);
            if(checkJueves.isSelected())DiasSeleccionado.add(DayOfWeek.THURSDAY);
            if(checkViernes.isSelected())DiasSeleccionado.add(DayOfWeek.FRIDAY);
            if(checkSabado.isSelected())DiasSeleccionado.add(DayOfWeek.SATURDAY);
            if(checkDomingo.isSelected())DiasSeleccionado.add(DayOfWeek.SUNDAY);
            
            if (DiasSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un día para asignar el turno.", "Días no seleccionados", JOptionPane.WARNING_MESSAGE);
            return; 
            }
            
            ControladorTurno CT = new ControladorTurno();
            boolean conflicto = CT.ExisteTurnoDoctor(IdDoctor, HoraInicio, HoraFin, DiasSeleccionado);
            
            if(conflicto){
                JOptionPane.showMessageDialog(this, "El doctor ya tiene un turno que se cruza con este horario en uno de los dias selecionados","ConflictoHorario",JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Turno nuevoturno = new Turno();
            nuevoturno.setHoraInicio(HoraInicio);
            nuevoturno.setHoraFin(HoraFin);
            nuevoturno.setDiasPorSemana(DiasSeleccionado);

            ControladorDoctor controladorDoctor = new ControladorDoctor();
            controladorDoctor.Asignar_Turnos(nuevoturno, IdDoctor);
            JOptionPane.showMessageDialog(this, "Turno Registrado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarTurnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarTurnos;
    private javax.swing.JComboBox<String> cbDoctor;
    private javax.swing.JComboBox<String> cbHoraFinal;
    private javax.swing.JComboBox<String> cbHoraInicio;
    private javax.swing.JCheckBox checkDomingo;
    private javax.swing.JCheckBox checkJueves;
    private javax.swing.JCheckBox checkLunes;
    private javax.swing.JCheckBox checkMartes;
    private javax.swing.JCheckBox checkMiercoles;
    private javax.swing.JCheckBox checkSabado;
    private javax.swing.JCheckBox checkViernes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    // End of variables declaration//GEN-END:variables
}
