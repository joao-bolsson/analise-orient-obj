package br.com.jvmarques.view.util;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 20.
 */
public class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {

    private final ButtonsPanel panel;

    /**
     * Creates a panel with buttons to edit a table cell.
     *
     * @param panel Panel to add on table cell to edit.
     */
    public ButtonsEditor(final ButtonsPanel panel) {
        super();
        this.panel = panel;
    }

    @Override
    public Component getTableCellEditorComponent(final JTable tbl, final Object value, boolean isSelected, int row,
            int column) {
        panel.setBackground(tbl.getSelectionBackground());
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}
