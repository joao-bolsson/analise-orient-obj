package br.com.jvmarques.view;

import br.com.jvmarques.controller.BooksOptionsController;
import br.com.jvmarques.controller.ListController;
import br.com.jvmarques.model.BooksTableModel;
import br.com.jvmarques.model.CustomTableModel;
import br.com.jvmarques.view.util.PanelWithTable;
import javax.swing.JPanel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class BooksTableEditor implements ListDataListener {

    private final ListController controller;

    private final CustomTableModel model;

    /**
     * Creates a editor to show the table with books.
     *
     * @param controller Controller to manage the books.
     */
    public BooksTableEditor(final ListController controller) {
        this.controller = controller;
        model = new BooksTableModel(controller.getAll());
    }

    /**
     * @return The panel to show the table with books.
     */
    public JPanel createPanel() {
        BooksOptionsController optController = new BooksOptionsController(controller);
        PanelWithTable panel = new PanelWithTable(model, 1, optController);

        panel.init();
        controller.addListDataListener(this);

        return panel;
    }

    @Override
    public void intervalAdded(final ListDataEvent evt) {
    }

    @Override
    public void intervalRemoved(final ListDataEvent evt) {
    }

    @Override
    public void contentsChanged(final ListDataEvent evt) {
        if (evt != null && evt.getSource() instanceof ListController) {
            ListController prots = (ListController) evt.getSource();
            model.addAll(prots.getAll());
        }
    }

}
