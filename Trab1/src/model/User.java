package model;

import java.util.Objects;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Ago 31.
 */
public class User extends ListModel<Request> {

    private final String id, email;

    private String name, password, phone;

    public User(final String id, final String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        User other = (User) obj;
        return other.id.equals(id) && other.email.equals(email);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public String toString() {
        return id + " - " + email;
    }

}
