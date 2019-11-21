package br.com.jvmarques.controller;

import br.com.jvmarques.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Manager for actions involving users, like login.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 21.
 */
public class UserManager {

    private final List<User> users = new ArrayList<>();

    private User activeUser;

    private UserManager() {
        // empty
    }

    /**
     * Adds a new user.
     *
     * @param user User to add.
     */
    public void addUser(final User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    /**
     * Validates the user login.
     *
     * @param user User to validate.
     * @return True if the login is valid.
     */
    public boolean login(final User user) {
        if (users.contains(user)) {
            activeUser = user;
            return true;
        }
        return false;
    }

    /**
     * @return The logged in user.
     */
    public User getActiveUser() {
        return activeUser;
    }

    /**
     * @param user User to check.
     * @return If the user login already exists - true, otherwise - false.
     */
    public boolean loginExists(final User user) {
        if (user != null) {
            for (User u : users) {
                if (u.getLogin().equals(user.getLogin())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return The single instance of this manager.
     */
    public static UserManager getInstance() {
        return UserManagerHolder.INSTANCE;
    }

    private static class UserManagerHolder {

        private static final UserManager INSTANCE = new UserManager();
    }

}
