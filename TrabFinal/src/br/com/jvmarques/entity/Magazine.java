package br.com.jvmarques.entity;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 26.
 */
public class Magazine extends Item {

    /**
     * Creates a magazine with the given name.
     *
     * @param name Magazine name (title).
     */
    public Magazine(final String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Revista";
    }

}
