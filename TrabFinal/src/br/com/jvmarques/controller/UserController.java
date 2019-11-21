package br.com.jvmarques.controller;

import br.com.jvmarques.entity.User;
import java.awt.Window;

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

            // TODO: open window to show books
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
