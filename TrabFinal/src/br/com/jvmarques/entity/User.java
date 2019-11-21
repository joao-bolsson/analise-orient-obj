package br.com.jvmarques.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: documentação
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class User {

    private final String login, password;

    private final List<Book> books = new ArrayList<>();

    public User(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
