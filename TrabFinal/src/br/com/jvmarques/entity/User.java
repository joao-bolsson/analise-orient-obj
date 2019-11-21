package br.com.jvmarques.entity;

import br.com.jvmarques.controller.ListController;
import java.util.List;

/**
 * TODO: documentação
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class User {

    private final String login, password;

    private final ListController<Book> controller;

    public User(final String login, final String password) {
        if (login == null || password == null) {
            throw new IllegalArgumentException("User must contain a non null login and password.");
        }
        this.login = login;
        this.password = password;
        controller = new ListController();
    }

    public ListController<Book> getController() {
        return controller;
    }

    public List<Book> getBooks() {
        return controller.getAll();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
