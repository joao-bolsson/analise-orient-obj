package br.com.jvmarques.manager;

import br.com.jvmarques.controller.ListController;
import br.com.jvmarques.entity.Item;

/**
 * A singleton class that stores all the items.
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 21.
 */
public class ItemsManager extends ListController<Item> {

    private ItemsManager() {
        // empty
    }

    /**
     * @return The single instance of this manager.
     */
    public static ItemsManager getInstance() {
        return BooksManagerHolder.INSTANCE;
    }

    private static class BooksManagerHolder {

        private static final ItemsManager INSTANCE = new ItemsManager();
    }

}
