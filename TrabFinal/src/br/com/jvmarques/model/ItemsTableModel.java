package br.com.jvmarques.model;

import br.com.jvmarques.entity.Item;
import java.util.List;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class ItemsTableModel extends CustomTableModel<Item> {

    private final static String[] COLUMNS = new String[]{
        "Nome", "Tipo", "Opções"};

    /**
     * Default construct.
     */
    public ItemsTableModel() {
        super(COLUMNS);
    }

    /**
     * Creates a model with the given list of books.
     *
     * @param books Items to add on this model.
     */
    public ItemsTableModel(final List<Item> books) {
        super(COLUMNS, books);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < list.size()) {
            Item item = list.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return item.getName();

                case 1:
                    return item.getType();

                default:
                    return null;
            }
        }
        return null;
    }

}
