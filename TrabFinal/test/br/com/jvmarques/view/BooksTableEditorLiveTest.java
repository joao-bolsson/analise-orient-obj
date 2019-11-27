package br.com.jvmarques.view;

import br.com.jvmarques.controller.ItemsOptionsController;
import br.com.jvmarques.controller.ListController;
import br.com.jvmarques.entity.Book;
import java.awt.Dimension;
import javax.swing.JDialog;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class BooksTableEditorLiveTest {

    private BooksTableEditorLiveTest() {
        // empty
    }

    /**
     * Method to show this panel.
     *
     * @param args Command line arguments (ignore).
     */
    public static void main(final String[] args) {
        Book book = new Book("Livro A");

        ListController controller = new ListController();
        controller.add(book);

        ItemsOptionsController optController = new ItemsOptionsController(controller);
        BooksTableEditor editor = new BooksTableEditor(controller, optController);

        JDialog dialog = new JDialog();
        dialog.setTitle("Books Table Live Test");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);

        dialog.setContentPane(editor.createPanel());

        dialog.setPreferredSize(new Dimension(700, 300));
        dialog.pack();
        dialog.setVisible(true);
    }

}
