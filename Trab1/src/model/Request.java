package model;

import java.util.Objects;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Ago 31.
 */
public class Request extends ListModel<ItemRequest> {

    private final String id;

    public Request(final String id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Request)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Request other = (Request) obj;
        return other.id.equals(id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

}
