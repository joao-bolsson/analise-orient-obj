package br.com.jvmarques.controller;

import br.com.jvmarques.manager.UserManager;
import br.com.jvmarques.entity.Book;
import br.com.jvmarques.entity.User;
import br.com.jvmarques.manager.BooksManager;
import br.com.jvmarques.view.BooksTableEditor;
import br.com.jvmarques.view.MainPanelEditor;
import br.com.jvmarques.view.UserPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JPanel;

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

    public boolean login(final Window parent, final User u) {
        if (UserManager.getInstance().login(u)) {
            User user = UserManager.getInstance().getActiveUser();
            parent.dispose();

            ListController<Book> controller = BooksManager.getInstance();

            BooksTableEditor availableBooksPanel = new BooksTableEditor(controller, new BooksOptionsController(controller));

            BooksTableEditor userBooksPanel = new BooksTableEditor(user.getController(),
                    new UserBooksOptionsController(user.getController()));

            MainPanelEditor main = new MainPanelEditor(availableBooksPanel, userBooksPanel);

            JPanel panel = main.createPanel();
            panel.add(new UserPanel(user), BorderLayout.PAGE_START);

            JDialog dialog = new JDialog();
            dialog.setTitle("Main Panel");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setLocationRelativeTo(null);

            dialog.setContentPane(panel);

            dialog.setPreferredSize(new Dimension(700, 800));
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
