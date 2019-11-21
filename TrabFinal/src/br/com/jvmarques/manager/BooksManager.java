package br.com.jvmarques.manager;

import br.com.jvmarques.controller.ListController;
import br.com.jvmarques.entity.Book;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Nov 21.
 */
public class BooksManager extends ListController<Book> {

    private BooksManager() {
        // empty
    }

    /**
     * @return The single instance of this manager.
     */
    public static BooksManager getInstance() {
        return BooksManagerHolder.INSTANCE;
    }

    private static class BooksManagerHolder {

        private static final BooksManager INSTANCE = new BooksManager();
    }

}
