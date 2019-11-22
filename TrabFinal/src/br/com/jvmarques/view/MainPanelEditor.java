package br.com.jvmarques.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class MainPanelEditor {

    private final BooksTableEditor availableBooksPanel, userBooks;

    /**
     * Creates a main panel to show available books and user books.
     *
     * @param availableBooksPanel The panel to show available books.
     * @param userBooks The panel to show user books.
     */
    public MainPanelEditor(final BooksTableEditor availableBooksPanel, final BooksTableEditor userBooks) {
        this.availableBooksPanel = availableBooksPanel;
        this.userBooks = userBooks;
    }

    /**
     * @return The panel created.
     */
    public JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(availableBooksPanel.createPanel(), BorderLayout.CENTER);
        panel.add(userBooks.createPanel(), BorderLayout.PAGE_END);

        return panel;
    }

}
