package br.com.jvmarques.manager;

/**
 * Factory used by the table that shows the user reserved books.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 27.
 */
public class UserOptFactory implements ButtonsOptExtFactory {

    @Override
    public boolean showEdit() {
        return false;
    }

    @Override
    public boolean showDelete() {
        return false;
    }

    @Override
    public boolean showAdd() {
        return false;
    }

}
