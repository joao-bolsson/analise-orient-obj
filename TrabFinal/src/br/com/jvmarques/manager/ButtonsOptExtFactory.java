package br.com.jvmarques.manager;

/**
 * Interface to decide if the buttons: edit, delete and add must or not be enabled on its referenced options controller.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 27.
 */
public interface ButtonsOptExtFactory {

    boolean showEdit();

    boolean showDelete();

    boolean showAdd();

}
