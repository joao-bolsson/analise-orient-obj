package br.com.jvmarques.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 27.
 * @param <E> Object to iterate.
 */
public class ListIterator<E> implements CustomIterator<E> {

    private int index = -1;

    private final List<E> list = new ArrayList<>();

    /**
     * Creates an iterator for the given list.
     *
     * @param list List to iterate.
     */
    public ListIterator(final List<E> list) {
        this.list.addAll(list);
    }

    @Override
    public E next() {
        return list.get(index);
    }

    @Override
    public boolean hasNext() {
        return ++index < list.size();
    }

}
