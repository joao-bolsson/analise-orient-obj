package br.com.jvmarques.controller;

import br.com.jvmarques.manager.ButtonsOptExtFactory;
import br.com.jvmarques.view.util.TableWithOptions;
import java.awt.Window;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 * Interface for options controller witch is used on each row of a {@link TableWithOptions}.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 20.
 * @param <E> Object type to manage on this controller.
 */
public interface OptionsController<E> {

    /**
     * Method called to edit the given item.
     *
     * @param parent Parent window to open possible panels to edit.
     * @param item Item to edit.
     */
    void edit(Window parent, E item);

    /**
     * Method called to delete the given item.
     *
     * @param item Item to delete.
     */
    void delete(E item);

    /**
     * Method called to add an item.
     *
     * @param parent Parent window to open possible panels to add.
     */
    default void add(Window parent) {
        // empty
    }

    /**
     * @return The factory for show buttons.
     */
    ButtonsOptExtFactory getOptFactory();

    /**
     * @return Extra buttons options on the table. Default: null.
     */
    default List<JButton> getExtOptions() {
        return null;
    }

    /**
     * Sets the table for this controller.
     *
     * @param table Table to set.
     */
    default void setTable(JTable table) {
        // empty
    }

}
