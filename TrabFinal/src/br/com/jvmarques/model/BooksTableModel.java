package br.com.jvmarques.model;

import br.com.jvmarques.entity.Book;
import java.util.List;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.com.br)
 * @version 2019, Nov 21.
 */
public class BooksTableModel extends CustomTableModel<Book> {

    private final static String[] COLUMNS = new String[]{
        "Nome", "Opções"};

    /**
     * Default construct.
     */
    public BooksTableModel() {
        super(COLUMNS);
    }

    /**
     * Creates a model with the given list of books.
     *
     * @param books Books to add on this model.
     */
    public BooksTableModel(final List<Book> books) {
        super(COLUMNS, books);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < list.size()) {
            Book book = list.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return book.getName();

                default:
                    return null;
            }
        }
        return null;
    }

}
