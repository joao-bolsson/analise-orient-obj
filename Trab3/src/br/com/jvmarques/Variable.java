package br.com.jvmarques;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 21.
 */
public class Variable extends Expression {

    private final String data;

    /**
     * Creates a variable.
     *
     * @param data Data associated.
     */
    public Variable(final String data) {
        this.data = data;
    }

    @Override
    public int interpret(final Context context) {
        try {
            int parseInt = Integer.parseInt(data);
            return parseInt;
        } catch (final NumberFormatException e) {
            System.out.println("Given data ins't an integer: " + e);
        }
        return 0;
    }

}
