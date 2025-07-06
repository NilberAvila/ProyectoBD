/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
/**
 *
 * @author apnil
 */
public class TableActionCellEditor extends DefaultCellEditor{

    private TableActionEvent event;
    private String texto;
    public TableActionCellEditor(TableActionEvent ev, String texto) {
        super(new JCheckBox());
        this.event = ev;
        this.texto = texto;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action = new PanelAction(texto);
        action.initEvent(event, row, texto);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
    
    
}
