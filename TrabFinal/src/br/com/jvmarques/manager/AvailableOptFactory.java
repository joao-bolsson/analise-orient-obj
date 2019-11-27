package br.com.jvmarques.manager;

/**
 * Factory used by the table that shows the available items on the system.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 27.
 */
public class AvailableOptFactory implements ButtonsOptExtFactory {

    @Override
    public boolean showEdit() {
        return true;
    }

    @Override
    public boolean showDelete() {
        return true;
    }

    @Override
    public boolean showAdd() {
        return true;
    }

}
