package model;

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

}
