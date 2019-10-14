package br.com.jvmarques;

import java.util.ArrayList;
import java.util.List;

/**
 * Machine to receives coins and delivery products.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 14.
 */
public class Machine {

    public enum PRODUCT {
        REFRI(2.5f), DOCE(1.5f), BALA(0.1f);

        private final float value;

        PRODUCT(float value) {
            this.value = value;
        }

    }

    private PRODUCT product;

    private final List<Float> coins = new ArrayList<>();

    private final CoinSlot coinsChain;

    /**
     * Default construct.
     */
    public Machine() {
        coinsChain = new CoinSlot(0.01f) {
            @Override
            protected void receive() {
                System.out.println("Recebido R$ 0.01");
            }
        };

        coinsChain.setNext(new CoinSlot(0.05f) {
            @Override
            protected void receive() {
                System.out.println("Recebido R$ 0.05");
            }
        });

        coinsChain.setNext(new CoinSlot(0.1f) {
            @Override
            protected void receive() {
                System.out.println("Recebido R$ 0.1");
            }
        });

        coinsChain.setNext(new CoinSlot(0.25f) {
            @Override
            protected void receive() {
                System.out.println("Recebido R$ 0.25");
            }
        });

        coinsChain.setNext(new CoinSlot(0.5f) {
            @Override
            protected void receive() {
                System.out.println("Recebido R$ 0.5");
            }
        });

        coinsChain.setNext(new CoinSlot(1) {
            @Override
            protected void receive() {
                System.out.println("Recebido R$ 1");
            }
        });
    }

    /**
     * Choose a product on the machine.
     *
     * @param prod Product.
     */
    public void chooseProduct(final PRODUCT prod) {
        product = prod;
    }

    /**
     * Insert coins on the machine
     *
     * @param coins Coins to pay for the product.
     */
    public void insertCoins(final List<Float> coins) {
        this.coins.clear();
        this.coins.addAll(coins);
    }

    /**
     * Run the option.
     *
     * @throws java.lang.Exception General errors.
     */
    public void run() throws Exception {
        float required = product.value;

        float valueInserted = 0;

        for (float c : coins) {
            valueInserted += c;
        }

        System.out.printf("Valor do produto: R$ %.2f\n", required);
        System.out.printf("Valor inserido: R$ %.2f\n", valueInserted);

        if (valueInserted < required) {
            throw new Exception("Valor inserido não é suficiente para a compra");
        }

        float received = 0;
        for (float c : coins) {
            received += coinsChain.receive(c);

            if (received >= required) {
                break;
            }
        }

        System.out.printf("Compra efetivada, troco: R$ %.2f\n", (valueInserted - required));
    }

}
