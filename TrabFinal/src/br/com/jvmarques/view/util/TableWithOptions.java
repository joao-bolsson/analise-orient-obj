package br.com.jvmarques.view.util;

import br.com.jvmarques.controller.OptionsController;
import br.com.jvmarques.model.CustomTableModel;
import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 20.
 */
public class TableWithOptions extends JTable {

    private static final byte DEFAULT_LINE_HEIGHT = 36;

    private final List<JButton> options = new ArrayList<>();

    protected final CustomTableModel model;

    private final OptionsController controller;

    private final int columnOpt;

    private boolean initialized = false;

    /**
     * Creates a table with a column with options (buttons) for each row.
     *
     * @param model Table model.
     * @param columnOpt Column index on table to show the options.
     * @param controller Swing controller for options.
     */
    public TableWithOptions(final CustomTableModel model, int columnOpt, final OptionsController controller) {
        super(model);

        this.model = model;
        this.controller = controller;

        this.columnOpt = columnOpt;
    }

    private void buildOptions() {
        if (controller.showEdit()) {
            JButton btnEdit = new JButton(new AbstractAction("Editar") {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    int row = TableWithOptions.this.convertRowIndexToModel(TableWithOptions.this.getEditingRow());

                    Object get = model.getList().get(row);

                    Container parent = getParent();
                    while (!(parent instanceof Window) && parent != null) {
                        parent = parent.getParent();
                    }

                    controller.edit((Window) parent, get);
                }
            });
            addOption(btnEdit);
        }

        if (controller.showDelete()) {
            JButton btnDelete = new JButton(new AbstractAction("Deletar") {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    int row = TableWithOptions.this.convertRowIndexToModel(TableWithOptions.this.getEditingRow());

                    Object obj = model.getList().get(row);

                    int confirm = JOptionPane.showConfirmDialog(TableWithOptions.this,
                            "Você tem certeza que deseja excluir este item?",
                            "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        model.remove(obj);

                        controller.delete(obj);
                    }
                }
            });
            addOption(btnDelete);
        }

        List<JButton> extOptions = controller.getExtOptions();
        if (extOptions != null) {
            for (JButton btn : extOptions) {
                addOption(btn);
            }
        }
    }

    /**
     * Adds a button as option for each row on the table.
     *
     * @param opt Option to add.
     */
    public void addOption(final JButton opt) {
        if (!options.contains(opt)) {
            options.add(opt);
        }
    }

    /**
     * Initialize this component.
     */
    public void init() {
        if (!initialized) {
            controller.setTable(this);
            buildOptions();

            setRowHeight(DEFAULT_LINE_HEIGHT);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            setDefaultRenderer(String.class, centerRenderer);

            // adding the options on the editable cell
            TableColumn column = getColumnModel().getColumn(columnOpt);

            List<JButton> list = new ArrayList<>();
            for (JButton btn : options) {
                list.add(new JButton(btn.getText(), btn.getIcon()));
            }

            // this only shows the options, it isn't editable/clickable
            column.setCellRenderer(new ButtonsRenderer(list));

            // this show the editable/clickable options when a cell is selected
            column.setCellEditor(new ButtonsEditor(new ButtonsPanel(options)));
            initialized = true;
        }
    }

}
