package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Ago 31.
 * @param <E> List object.
 */
public class ListModel<E> {

    protected final List<E> list;

    public ListModel() {
        list = new ArrayList<>();
    }

    public void add(final E item) {
        if (!list.contains(item)) {
            list.add(item);
        }
    }

    public void remove(final E item) {
        remove(list.indexOf(item));
    }

    public void remove(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }

}
