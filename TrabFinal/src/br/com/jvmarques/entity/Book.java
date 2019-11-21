package br.com.jvmarques.entity;

import java.util.Objects;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class Book {

    private String name;

    /**
     * Default construct.
     *
     * @param name Book name.
     */
    public Book(final String name) {
        this.name = name;
    }

    /**
     * @return Books name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the book.
     *
     * @param name New name to set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }

        final Book other = (Book) obj;
        return Objects.equals(this.name, other.name);
    }

}
