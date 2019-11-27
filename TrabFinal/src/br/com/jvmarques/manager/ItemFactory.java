package br.com.jvmarques.manager;

import br.com.jvmarques.entity.Book;
import br.com.jvmarques.entity.Item;
import br.com.jvmarques.entity.Magazine;
import br.com.jvmarques.entity.Paper;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 27.
 */
public class ItemFactory {

    /**
     * Enumerating available types for items.
     */
    public enum ItemId {

        BOOK("Livro"), MAGAZINE("Revista"), PAPER("Jornal");

        private final String name;

        private ItemId(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    /**
     * Creates an item accordingly with the given id.
     *
     * @param id Given id to create item.
     * @param name Item name.
     * @return Created item.
     */
    public static Item createItem(final ItemId id, final String name) {
        if (id != null) {
            switch (id) {
                case BOOK:
                    return new Book(name);
                case MAGAZINE:
                    return new Magazine(name);
                case PAPER:
                    return new Paper(name);
                default:
                    break;
            }
        }
        return null;
    }

}
