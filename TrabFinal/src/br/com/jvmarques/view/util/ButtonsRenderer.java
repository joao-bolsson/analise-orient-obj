package br.com.jvmarques.view.util;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 20.
 */
public class ButtonsRenderer extends ButtonsPanel implements TableCellRenderer {

    /**
     * Creates a button renderer to a table cell.
     *
     * @param buttons Buttons to show on the cell.
     */
    public ButtonsRenderer(final List<JButton> buttons) {
        super(buttons);
    }

    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Color background = table.getBackground();
        if (isSelected) {
            background = table.getSelectionBackground();
        }
        setBackground(background);
        return this;
    }

}
