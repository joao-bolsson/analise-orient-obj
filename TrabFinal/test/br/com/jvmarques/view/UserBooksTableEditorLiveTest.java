/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jvmarques.view;

import br.com.jvmarques.controller.ListController;
import br.com.jvmarques.controller.UserItemsOptionsController;
import br.com.jvmarques.entity.Book;
import br.com.jvmarques.entity.User;
import javax.swing.JDialog;

/**
 *
 * @author joaobolsson
 */
public class UserBooksTableEditorLiveTest {

    public UserBooksTableEditorLiveTest() {
    }

    public static void main(String[] args) {
        Book book = new Book("Livro A");

        ListController controller = new ListController();
        controller.add(book);

        User user = new User("joao", "123");
        user.getController().add(book);

        UserItemsOptionsController optController = new UserItemsOptionsController(controller);
        BooksTableEditor editor = new BooksTableEditor(controller, optController);

        JDialog dialog = new JDialog();
        dialog.setTitle("Books Table Live Test");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);

        dialog.setContentPane(editor.createPanel());

        dialog.pack();
        dialog.setVisible(true);
    }

}
