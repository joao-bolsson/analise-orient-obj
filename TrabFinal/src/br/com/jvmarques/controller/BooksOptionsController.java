package br.com.jvmarques.controller;

import br.com.jvmarques.entity.Book;
import br.com.jvmarques.entity.User;
import br.com.jvmarques.model.CustomTableModel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class BooksOptionsController implements OptionsController<Book> {

    private final ListController listController;

    private JTable table;

    /**
     * Creates a options controller for table to show books.
     *
     * @param listController Referenced list controller.
     */
    public BooksOptionsController(final ListController listController) {
        this.listController = listController;
    }

    @Override
    public void edit(final Window parent, final Book item) {
        String string = JOptionPane.showInputDialog(parent, "Novo nome: ");
        if (string != null && !string.isEmpty()) {
            item.setName(string);
            listController.fireContentsChanged();
        }
    }

    @Override
    public void delete(final Book item) {
        listController.remove(item);
    }

    @Override
    public void add(final Window parent) {
        String string = JOptionPane.showInputDialog(parent, "Livro para adicionar: ");
        if (string != null && !string.isEmpty()) {
            listController.add(new Book(string));
        }
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
                        user.getController().add((Book) obj);
                    }
                }
            }
        });
        return Arrays.asList(btn);
    }

}
