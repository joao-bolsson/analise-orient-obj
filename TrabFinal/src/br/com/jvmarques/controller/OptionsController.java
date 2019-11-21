package br.com.jvmarques.controller;

import java.awt.Window;

/**
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

}
