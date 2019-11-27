package br.com.jvmarques.entity;

import br.com.jvmarques.controller.ListController;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class User {

    private final String login, password;

    private final ListController<Item> controller;

    /**
     * Creates a new user.
     *
     * @param login User login.
     * @param password User password.
     */
    public User(final String login, final String password) {
        if (login == null || password == null) {
            throw new IllegalArgumentException("User must contain a non null login and password.");
        }
        this.login = login;
        this.password = password;
        controller = new ListController();
    }

    /**
     * The controller for the user books.
     *
     * @return
     */
    public ListController<Item> getController() {
        return controller;
    }

    /**
     * @return A list with the user books.
     */
    public List<Item> getBooks() {
        return controller.getAll();
    }

    /**
     * @return User login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return User password.
     */
    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.login);
        hash = 37 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }

        final User other = (User) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

}
