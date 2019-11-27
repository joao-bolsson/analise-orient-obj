package br.com.jvmarques.entity;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 26.
 */
public class Paper extends Item {

    /**
     * Creates a paper.
     *
     * @param name Paper name.
     */
    public Paper(final String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Jornal";
    }

}
