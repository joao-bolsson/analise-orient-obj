package br.com.joao.mediator;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 06.
 */
public class Seller {

    private final Mediator mediator;

    private final float value;

    /**
     * Default construct.
     *
     * @param mediator Referenced mediator.
     * @param value Value to start the offers.
     */
    public Seller(final Mediator mediator, float value) {
        this.mediator = mediator;
        this.value = value;

        init();
    }

    private void init() {
        mediator.setSeller(this);
    }

    /**
     * @return The product value.
     */
    public float getValue() {
        return value;
    }

    /**
     * Propose an offer to this buyer.
     *
     * @param value Value to propose.
     * @return If the buyer accepted - true, else - false.
     */
    public boolean acceptOffer(float value) {
        return value >= this.value;
    }
}
