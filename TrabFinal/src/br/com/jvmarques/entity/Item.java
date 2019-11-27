package br.com.jvmarques.entity;

import java.util.Objects;

/**
 * Abstract object representing any item in a library.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 26.
 */
public abstract class Item {

    /**
     * Item name.
     */
    protected String name;

    /**
     * Default construct.
     *
     * @param name Item name.
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * @return Item name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the item.
     *
     * @param name New name to set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return The item type.
     */
    public abstract String getType();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(getType());
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }

        final Item other = (Item) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(getType(), other.getType());
    }

}
