package br.com.jvmarques.controller;

import br.com.jvmarques.entity.Book;
import br.com.jvmarques.entity.User;
import br.com.jvmarques.view.BooksTableEditor;
import br.com.jvmarques.view.MainPanelEditor;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JDialog;

/**
 * TODO: documentação
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 21.
 */
public class UserController {

    public UserController() {
        // empty
    }

    public boolean login(final Window parent, final User user) {
        if (UserManager.getInstance().login(user)) {
            parent.dispose();

            ListController<Book> controller = new ListController<>();

            BooksTableEditor availableBooksPanel = new BooksTableEditor(controller, new BooksOptionsController(controller));

            BooksTableEditor userBooksPanel = new BooksTableEditor(user.getController(), new UserBooksOptionsController(user.getController()));

            MainPanelEditor main = new MainPanelEditor(availableBooksPanel, userBooksPanel);

            JDialog dialog = new JDialog();
            dialog.setTitle("Main Panel");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setLocationRelativeTo(null);

            dialog.setContentPane(main.createPanel());

            dialog.setPreferredSize(new Dimension(700, 500));
            dialog.pack();
            dialog.setVisible(true);
            return true;
        }
        return false;
    }

    public boolean singUp(final Window parent, final User user) {
        if (!UserManager.getInstance().loginExists(user)) {
            UserManager.getInstance().addUser(user);

            return login(parent, user);
        }
        return false;
    }

}
