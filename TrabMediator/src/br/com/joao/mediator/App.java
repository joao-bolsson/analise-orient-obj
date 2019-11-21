package br.com.joao.mediator;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 06.
 */
public class App {

    /**
     * Main method to execute.
     *
     * @param args Command line arguments (ignored).
     */
    public static void main(final String[] args) {
        BuyMediator mediator = new BuyMediator();

        Buyer brBuyer = new Buyer(mediator, 12, 3, "BR"); // BR buyers starts offering R$ 12
        Buyer frBuyer = new Buyer(mediator, 3, 1.5f, "FR"); // FR buyers starts offering EUR$ 3

        Seller usSeller = new Seller(mediator, 10); // US seller with a product for US$ 10

        Converter converterDollar = new Converter(Converter.REAL_TO_DOLLAR_FACTOR);
        mediator.setConverter(converterDollar);

        System.out.println("-----------------------------------------------");
        while (!brBuyer.proposeOffer()) {
            // nothing
        }

        converterDollar.setFactor(Converter.EURO_TO_DOLLAR_FACTOR);
        System.out.println("-----------------------------------------------");
        while (!frBuyer.proposeOffer()) {
            // nothing
        }

    }

}
