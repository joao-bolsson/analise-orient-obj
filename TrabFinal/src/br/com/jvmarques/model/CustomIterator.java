package br.com.jvmarques.model;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 20.
 * @param <E> Object to iterate.
 */
public interface CustomIterator<E> {

    /**
     * @return The next object on the sequence.
     */
    E next();

    /**
     * @return True only if has more elements to iterate.
     */
    boolean hasNext();
}
