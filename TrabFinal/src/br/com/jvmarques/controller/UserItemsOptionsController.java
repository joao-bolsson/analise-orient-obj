package br.com.jvmarques.controller;

import br.com.jvmarques.entity.Item;
import br.com.jvmarques.manager.ButtonsOptExtFactory;
import br.com.jvmarques.manager.UserOptFactory;
import br.com.jvmarques.model.CustomTableModel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 * Options controller for the table that shows the user items (books, magazines, etc).
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 22.
 */
public class UserItemsOptionsController implements OptionsController<Item> {

    private final ButtonsOptExtFactory factory;

    private final ListController listController;

    private JTable table;

    /**
     * Creates an options controller based on the given list controller.
     *
     * @param listController List controller containing predefined items.
     */
    public UserItemsOptionsController(ListController listController) {
        this.listController = listController;
        factory = new UserOptFactory();
    }

    @Override
    public void edit(Window parent, Item item) {
        // nothing
    }

    @Override
    public void delete(Item item) {
        // nothing
    }

    @Override
    public void setTable(final JTable table) {
        this.table = table;
    }

    @Override
    public List<JButton> getExtOptions() {
        JButton btnBack = new JButton("Devolver");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());

                Object mod = table.getModel();
                if (mod instanceof CustomTableModel) {
                    Object obj = ((CustomTableModel) mod).getList().get(row);

                    ((CustomTableModel) mod).remove(obj);

                    listController.remove(obj);
                }
            }
        });
        return Arrays.asList(btnBack);
    }

    @Override
    public ButtonsOptExtFactory getOptFactory() {
        return factory;
    }

}
