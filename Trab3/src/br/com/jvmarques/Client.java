package br.com.jvmarques;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 21.
 */
public class Client {

    /**
     * Main function.
     *
     * @param args Command line arguments (ignored).
     */
    public static void main(final String[] args) {
        System.out.println("Simulação Soma");
        Variable a = new Variable("5");
        Variable b = new Variable("4");

        Adder exp = new Adder(a, b);

        int interpret = exp.interpret(null);
        System.out.println("result: " + interpret);

        System.out.println("-----------------------------");
        System.out.println("Simulação Subtração");
        Subtractor subtractor = new Subtractor(a, b);

        interpret = subtractor.interpret(null);
        System.out.println("result: " + interpret);

        System.out.println("Simulação Soma de duas Expressões");
        System.out.println("result: " + new Adder(exp, subtractor).interpret(null));
    }
}
