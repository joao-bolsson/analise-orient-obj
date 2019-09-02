package model;

import java.util.Objects;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Ago 31.
 */
public class ItemRequest {

    private final Product product;

    private int qtd;

    public ItemRequest(final Product product, int qtd) {
        if (qtd <= 0) {
            throw new IllegalArgumentException("An item request must has a qtd greater than zero");
        }
        this.product = product;
        this.qtd = qtd;
    }

    public void setQtd(int qtd) {
        if (qtd > 0) {
            this.qtd = qtd;
        }
    }

    public Product getProduct() {
        return product;
    }

    public int getQtd() {
        return qtd;
    }

    @Override
    public String toString() {
        return product + " qtd: " + qtd;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof ItemRequest)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        ItemRequest other = (ItemRequest) obj;
        return other.product.equals(product) && other.qtd == qtd;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.product);
        hash = 23 * hash + this.qtd;
        return hash;
    }

}
