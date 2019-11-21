package br.com.joao.mediator;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 06.
 */
public interface Mediator {

    /**
     * It proposes an offer to the buyer.
     *
     * @param value Offer to propose.
     * @return If the buyer accepted the offer - true, else - false.
     */
    boolean proposeOffer(float value);

    /**
     * Add a buyer to the mediation.
     *
     * @param buyer Buyer to add.
     */
    void addBuyer(Buyer buyer);

    /**
     * Add a seller to the mediation.
     *
     * @param seller Seller to add.
     */
    void setSeller(Seller seller);

    /**
     * Money converter for the mediation.
     *
     * @param converter Converter to use.
     */
    void setConverter(Converter converter);

}
