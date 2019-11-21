package br.com.jvmarques;

import java.util.Arrays;

/**
 * Main class to run the program.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 14.
 */
public class Main {

    private static final String LINE_SEPARATOR = "--------------------------------";

    /**
     * Default construct.
     */
    public Main() {
        // empty
    }

    private void start() {
        Machine machine = new Machine();

        System.out.println("SIMULAÇÕES\n");
        System.out.println("Valor insuficiente para a compra");
        System.out.println(LINE_SEPARATOR);
        try {
            machine.chooseProduct(Machine.PRODUCT.DOCE);
            machine.insertCoins(Arrays.asList(0.5f, 0.1f, 0.1f, 0.05f));
            machine.run();
        } catch (final Exception ex) {
            System.out.println(ex);
        }

        System.out.println(LINE_SEPARATOR);

        System.out.println("Devolução de troco");
        System.out.println(LINE_SEPARATOR);
        try {
            machine.chooseProduct(Machine.PRODUCT.BALA);
            machine.insertCoins(Arrays.asList(0.25f, 0.1f, 0.1f));
            machine.run();
        } catch (final Exception ex) {
            System.out.println(ex);
        }

        System.out.println(LINE_SEPARATOR);

        System.out.println("Com moeda não suportada (será apenas descartada)");
        System.out.println(LINE_SEPARATOR);
        try {
            machine.chooseProduct(Machine.PRODUCT.DOCE);
            machine.insertCoins(Arrays.asList(0.13f, 0.25f, 0.25f, 0.05f, 0.5f));
            machine.run();
        } catch (final Exception ex) {
            System.out.println(ex);
        }

        System.out.println(LINE_SEPARATOR);

        System.out.println("Valor exato ao do produto");
        System.out.println(LINE_SEPARATOR);
        try {
            machine.chooseProduct(Machine.PRODUCT.REFRI);
            machine.insertCoins(Arrays.asList(0.5f, 0.25f, 0.25f, 0.01f, 0.01f, 0.01f, 0.01f, 0.01f, 0.25f, 0.1f, 0.1f,
                    1f));
            machine.run();
        } catch (final Exception ex) {
            System.out.println(ex);
        }

        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Starts the program
     *
     * @param args Command line arguments (ignored).
     */
    public static void main(final String[] args) {
        Main main = new Main();
        main.start();
    }

}
