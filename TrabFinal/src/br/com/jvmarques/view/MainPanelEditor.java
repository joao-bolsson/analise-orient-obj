package br.com.jvmarques.view;

import br.com.jvmarques.view.util.TableWithOptions;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * TODO: documentação.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class MainPanelEditor {

    private final BooksTableEditor availableBooksPanel;

    private final TableWithOptions userBooks;

    public MainPanelEditor(BooksTableEditor availableBooksPanel, TableWithOptions userBooks) {
        this.availableBooksPanel = availableBooksPanel;
        this.userBooks = userBooks;
    }

    public JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(availableBooksPanel.createPanel(), BorderLayout.CENTER);
        panel.add(userBooks, BorderLayout.PAGE_END);

        return panel;
    }

}
