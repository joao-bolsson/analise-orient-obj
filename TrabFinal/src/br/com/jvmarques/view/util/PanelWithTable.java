package br.com.jvmarques.view.util;

import br.com.jvmarques.controller.OptionsController;
import br.com.jvmarques.model.CustomTableModel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 20.
 */
public class PanelWithTable extends JPanel {

    private final TableWithOptions table;

    /**
     * Button to add a new item on the table.
     */
    protected final JButton btnAdd;

    /**
     * Options controller.
     */
    protected final OptionsController optController;

    /**
     * Table model.
     */
    protected final CustomTableModel model;

    private boolean initialized = false;

    /**
     * Creates a panel with table associated with the given model.
     *
     * @param model Model to create the table.
     * @param columnOpt Column on the table for options.
     * @param optController Controller for options controller.
     */
    public PanelWithTable(final CustomTableModel model, int columnOpt, final OptionsController optController) {
        super(new BorderLayout(5, 5));

        btnAdd = new JButton("Adicionar");

        this.model = model;
        this.optController = optController;
        this.table = new TableWithOptions(model, columnOpt, optController);
    }

    /**
     * Add the listeners for buttons on this component.
     */
    protected void addListeners() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Container parent = getParent();
                while (!(parent instanceof Window) && parent != null) {
                    parent = parent.getParent();
                }

                optController.add((Window) parent);
            }
        });
    }

    /**
     * Initialize this component.
     */
    public void init() {
        if (!initialized) {
            table.init(true, true, null);

            addListeners();

            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            JPanel northPanel = new JPanel(new BorderLayout());

            JPanel btnPanel = buildButtonsPanel();
            if (btnPanel != null) {
                northPanel.add(btnPanel, BorderLayout.WEST);
            }

            add(northPanel, BorderLayout.NORTH);

            JScrollPane scroll = new JScrollPane(table);
            scroll.setColumnHeader(new JViewport() {
                @Override
                public Dimension getPreferredSize() {
                    Dimension d = super.getPreferredSize();
                    d.height = table.getRowHeight();
                    return d;
                }
            });

            add(scroll, BorderLayout.CENTER);

            initialized = true;
        }
    }

    /**
     * Creates the panel with buttons to add on the table's top.
     *
     * @return The panel with buttons.
     */
    protected JPanel buildButtonsPanel() {
        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.insets = new Insets(2, 5, 2, 5);
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.fill = GridBagConstraints.BOTH;

        JPanel btnPanel = new JPanel(new GridBagLayout());
        btnPanel.add(btnAdd, cons);

        return btnPanel;
    }

}
