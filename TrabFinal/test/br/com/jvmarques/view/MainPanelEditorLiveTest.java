/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jvmarques.view;

import br.com.jvmarques.controller.ItemsOptionsController;
import br.com.jvmarques.controller.ListController;
import br.com.jvmarques.controller.UserItemsOptionsController;
import br.com.jvmarques.entity.Book;
import br.com.jvmarques.entity.User;
import javax.swing.JDialog;

/**
 *
 * @author joaobolsson
 */
public class MainPanelEditorLiveTest {

    public MainPanelEditorLiveTest() {
    }

    public static void main(final String[] args) {
        Book book = new Book("Livro A");

        ListController controller = new ListController();
        controller.add(book);

        ItemsOptionsController optController = new ItemsOptionsController(controller);
        BooksTableEditor editor = new BooksTableEditor(controller, optController);

        User user = new User("joao", "123");
        user.getController().add(book);

        UserItemsOptionsController userBooksOptionsController = new UserItemsOptionsController(user.getController());

        BooksTableEditor userBooksEditor = new BooksTableEditor(user.getController(), userBooksOptionsController);

        MainPanelEditor main = new MainPanelEditor(editor, userBooksEditor);

        JDialog dialog = new JDialog();
        dialog.setTitle("Books Table Live Test");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);

        dialog.setContentPane(main.createPanel());

        dialog.pack();
        dialog.setVisible(true);
    }

}
