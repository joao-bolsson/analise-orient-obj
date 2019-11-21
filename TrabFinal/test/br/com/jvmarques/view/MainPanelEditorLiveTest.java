/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jvmarques.view;

import br.com.jvmarques.controller.BooksOptionsController;
import br.com.jvmarques.controller.ListController;
import br.com.jvmarques.controller.UserBooksOptionsController;
import br.com.jvmarques.entity.Book;
import br.com.jvmarques.entity.User;
import br.com.jvmarques.model.BooksTableModel;
import br.com.jvmarques.view.util.TableWithOptions;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
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

        BooksOptionsController optController = new BooksOptionsController(controller);
        BooksTableEditor editor = new BooksTableEditor(controller, optController);

        User user = new User("joao", "123");
        user.getController().add(book);

        BooksTableModel tableModel = new BooksTableModel(user.getBooks());

        UserBooksOptionsController userBooksOptionsController = new UserBooksOptionsController(user.getController());
        TableWithOptions table = new TableWithOptions(tableModel, 1, userBooksOptionsController);

        JButton btnBack = new JButton("Devolver");
        table.init(false, false, new ArrayList<>(Arrays.asList(btnBack)));

        MainPanelEditor main = new MainPanelEditor(editor, table);

        JDialog dialog = new JDialog();
        dialog.setTitle("Books Table Live Test");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);

        dialog.setContentPane(main.createPanel());

        dialog.pack();
        dialog.setVisible(true);
    }

}
