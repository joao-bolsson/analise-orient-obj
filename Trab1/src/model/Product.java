package model;

import java.util.Objects;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Ago 31.
 */
public class Product {

    private final String name;
    private float value;

    public Product(final String name) {
        this(name, 0);
    }

    public Product(final String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name + " - R$ " + value;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Product)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Product other = (Product) obj;
        return other.name.equals(name) && other.value == value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Float.floatToIntBits(this.value);
        return hash;
    }

}
