package br.com.jvmarques;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 21.
 */
public abstract class Expression {

    /**
     * Defines the method to interpret an expression.
     *
     * @param context Given context to interpret.
     * @return The result of the interpretation.
     */
    public abstract int interpret(Context context);

}
