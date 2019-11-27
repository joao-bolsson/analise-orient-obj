package br.com.jvmarques.entity;

/**
 * Representing a book.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class Book extends Item {

    /**
     * Default construct.
     *
     * @param name Book name.
     */
    public Book(final String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Livro";
    }

}
