package br.com.joao.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 06.
 */
public class BuyMediator implements Mediator {

    private final List<Buyer> buyers = new ArrayList<>();

    private Seller seller;

    private Converter converter;

    /**
     * Default construct.
     */
    public BuyMediator() {
        // nothing
    }

    @Override
    public boolean proposeOffer(float value) {
        float val = converter.convert(value);

        System.out.println("Valor do produto: U$ " + seller.getValue() + " Oferta: U$: " + val);
        return seller.acceptOffer(val);
    }

    @Override
    public void addBuyer(final Buyer buyer) {
        if (!buyers.contains(buyer)) {
            buyers.add(buyer);
        }
    }

    @Override
    public void setSeller(final Seller seller) {
        this.seller = seller;
    }

    @Override
    public void setConverter(final Converter converter) {
        this.converter = converter;
    }

}
