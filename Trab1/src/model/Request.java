package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Ago 31.
 */
public class Request {

    private final List<ItemRequest> items;

    public Request() {
        this(new ArrayList<>());
    }

    public Request(final List<ItemRequest> items) {
        this.items = items;
    }

    public void addItem(final ItemRequest item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public void remove(final ItemRequest item) {
        remove(items.indexOf(item));
    }

    public void remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

}
