package br.com.jvmarques;

/**
 * Coin slot using the pattern chain of responsability.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Oct 14.
 */
public abstract class CoinSlot {

    private CoinSlot next;

    private final float value;

    /**
     * Creates a coin slot.
     *
     * @param value Value to receive. For example: 0.01, 0.05, 0.10, etc.
     */
    public CoinSlot(float value) {
        this.value = value;
    }

    /**
     * Sets the next slot on the chain.
     *
     * @param next Next slot to set on the chain.
     */
    public void setNext(final CoinSlot next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.setNext(next);
        }
    }

    /**
     * Tries to receive a coin on this slot, if this couldn't happen then the value will follows the chain.
     *
     * @param value Value to receive.
     * @return The value received.
     * @throws Exception In case the value isn't allowed on the chain.
     */
    public float receive(float value) throws Exception {
        if (this.value == value) {
            receive();
            return value;
        }

        if (next == null) {
            System.out.println("Esse valor não é suportado");
            return 0;
        }
        return next.receive(value);
    }

    /**
     * Receives a coin on the slot.
     */
    protected abstract void receive();

}
