package br.com.jvmarques.controller;

import br.com.jvmarques.entity.Book;
import java.awt.Window;
import javax.swing.JOptionPane;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class BooksOptionsController implements OptionsController<Book> {

    private final ListController listController;

    /**
     * Creates a options controller for table to show books.
     *
     * @param listController Referenced list controller.
     */
    public BooksOptionsController(final ListController listController) {
        this.listController = listController;
    }

    @Override
    public void edit(final Window parent, final Book item) {
        String string = JOptionPane.showInputDialog(parent, "Novo nome: ");
        if (string != null && !string.isEmpty()) {
            item.setName(string);
            listController.fireContentsChanged();
        }
    }

    @Override
    public void delete(final Book item) {
        listController.remove(item);
    }

    @Override
    public void add(final Window parent) {
        String string = JOptionPane.showInputDialog(parent, "Livro para adicionar: ");
        if (string != null && !string.isEmpty()) {
            listController.add(new Book(string));
        }
    }

}
