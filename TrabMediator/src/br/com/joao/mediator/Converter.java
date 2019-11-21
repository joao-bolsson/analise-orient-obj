package br.com.joao.mediator;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 06.
 */
public class Converter {

    public static final float REAL_TO_DOLLAR_FACTOR = 0.24f;

    public static final float EURO_TO_DOLLAR_FACTOR = 0.9f;

    private float factor;

    /**
     * Default construct.
     *
     * @param factor Factor.
     */
    public Converter(float factor) {
        this.factor = factor;
    }

    /**
     * Converts the value to dollar.
     *
     * @param value Value to convert
     * @return
     */
    public float convert(float value) {
        return value * factor;
    }

    /**
     * Sets the conversion factor.
     *
     * @param factor Factor to set.
     */
    public void setFactor(float factor) {
        this.factor = factor;
    }

}
