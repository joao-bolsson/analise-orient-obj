package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
            System.out.println("Elemento Adicionado!");
        } else {
            System.out.println("Elemento já inserido");
        }
    }

    public void remove(final E item) {
        remove(list.indexOf(item));
    }

    public void remove(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            System.out.println("Elemento Removido!");
        } else {
            System.out.println("Elemento Inválido");
        }
    }

    public List<E> getList() {
        return list;
    }

    @Override
    public String toString() {
        return Arrays.toString(list.toArray());
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof ListModel)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        ListModel other = (ListModel) obj;
        return other.list.containsAll(list) && list.containsAll(other.list);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.list);
        return hash;
    }

}
