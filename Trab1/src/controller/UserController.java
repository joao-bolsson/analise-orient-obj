package controller;

import model.ListModel;
import model.User;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Sep 01.
 */
public class UserController extends ListModel<User> {

    public UserController() {
    }

    public boolean login(final User user) {
        return list.contains(user);
    }

    public User getUser(final String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        for (User user : list) {
            if (id.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

}
