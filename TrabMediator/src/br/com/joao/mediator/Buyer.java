package br.com.joao.mediator;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 06.
 */
public class Buyer {

    private final Mediator mediator;

    private float value;

    private final float increment;

    private final String name;

    /**
     * Creates a buyer.
     *
     * @param mediator Referenced mediator.
     * @param value Value to
     * @param increment Increment value to the offer.
     * @param name Buyer's name.
     */
    public Buyer(final Mediator mediator, float value, float increment, final String name) {
        this.mediator = mediator;
        this.value = value;
        this.increment = increment;
        this.name = name;

        init();
    }

    private void init() {
        mediator.addBuyer(this);
    }

    /**
     * Propose an offer to the seller.
     *
     * @return If the seller accepted the offer - true, else - false.
     */
    public boolean proposeOffer() {
        System.out.println("Comprador " + name + " vai propor...");
        boolean accepted = mediator.proposeOffer(value);
        if (accepted) {
            System.out.println("Aceitou a oferta!");
        } else {
            System.out.println("Não aceitou");
            value += increment;
        }

        return accepted;
    }

}
