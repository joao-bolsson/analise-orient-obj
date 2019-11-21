package br.com.jvmarques;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 21.
 */
public class Adder extends Expression {

    private final Expression expr1, expr2;

    /**
     * Creates an add expression interpreter.
     *
     * @param expr1 Expression 1.
     * @param expr2 Expression 2.
     */
    public Adder(final Expression expr1, final Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public int interpret(final Context context) {
        return expr1.interpret(context) + expr2.interpret(context);
    }

}
