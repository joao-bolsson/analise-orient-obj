package br.com.jvmarques.controller;

import br.com.jvmarques.manager.UserManager;
import br.com.jvmarques.entity.Item;
import br.com.jvmarques.entity.User;
import br.com.jvmarques.manager.ItemFactory;
import br.com.jvmarques.model.CustomTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class ItemsOptionsController implements OptionsController<Item> {

    private final ListController listController;

    private JDialog dialog;

    private JTable table;

    /**
     * Creates a options controller for table to show books.
     *
     * @param listController Referenced list controller.
     */
    public ItemsOptionsController(final ListController listController) {
        this.listController = listController;
    }

    @Override
    public void edit(final Window parent, final Item item) {
        showDialog(item);
    }

    @Override
    public void delete(final Item item) {
        listController.remove(item);
    }

    @Override
    public void add(final Window parent) {
        showDialog(null);
    }

    private void showDialog(final Item item) {
        ItemPanel panel = new ItemPanel();
        panel.init(item);

        dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);

        dialog.setContentPane(panel);

        dialog.setPreferredSize(new Dimension(400, 200));
        dialog.pack();
        dialog.setVisible(true);
    }

    @Override
    public void setTable(final JTable table) {
        this.table = table;
    }

    @Override
    public List<JButton> getExtOptions() {
        JButton btn = new JButton("Reservar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());

                Object mod = table.getModel();
                if (mod instanceof CustomTableModel) {
                    Object obj = ((CustomTableModel) mod).getList().get(row);

                    User user = UserManager.getInstance().getActiveUser();
                    if (user != null) {
                        user.getController().add((Item) obj);
                    }
                }
            }
        });
        return Arrays.asList(btn);
    }

    private class ItemPanel extends JPanel {

        private final JTextField nameField = new JTextField(20);
        private final JComboBox<ItemFactory.ItemId> typeCombo = new JComboBox<>(ItemFactory.ItemId.values());

        private final JButton btnSave, btnCancel;

        private Item item;

        ItemPanel() {
            super(new GridBagLayout());

            btnSave = new JButton(new AbstractAction("Salvar") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    if (name != null && !name.isEmpty()) {
                        ItemFactory.ItemId type = (ItemFactory.ItemId) typeCombo.getSelectedItem();

                        if (item != null) {
                            item.setName(name);
                            listController.fireContentsChanged();
                        } else {
                            listController.add(ItemFactory.createItem(type, name));
                        }
                        item = null;
                    }
                }
            });

            btnCancel = new JButton(new AbstractAction("Cancelar") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    item = null;
                    dialog.dispose();
                }
            });
        }

        void init(final Item item) {
            this.item = item;

            if (item != null) {
                nameField.setText(item.getName());
                typeCombo.setSelectedItem(item.getType());
                typeCombo.setEnabled(false);
            }

            GridBagConstraints cons = new GridBagConstraints();
            cons.gridx = 0;
            cons.gridy = 0;
            cons.insets = new Insets(5, 5, 5, 5);
            cons.anchor = GridBagConstraints.NORTHWEST;
            cons.fill = GridBagConstraints.BOTH;

            add(new JLabel("Nome:"), cons);

            cons.gridx++;
            add(nameField, cons);

            cons.gridx = 0;
            cons.gridy++;
            add(new JLabel("Tipo:"), cons);

            cons.gridx++;
            add(typeCombo, cons);

            cons.gridx = 0;
            cons.gridy++;
            cons.gridwidth = 2;

            JPanel btnPanel = new JPanel(new BorderLayout());
            btnPanel.add(btnCancel, BorderLayout.WEST);
            btnPanel.add(btnSave, BorderLayout.EAST);

            add(btnPanel, cons);
        }

    }

}
