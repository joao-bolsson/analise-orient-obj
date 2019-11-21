/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jvmarques.controller;

import br.com.jvmarques.entity.Book;
import java.awt.Window;

/**
 *
 * @author joaobolsson
 */
public class UserBooksOptionsController implements OptionsController<Book> {

    private final ListController listController;

    public UserBooksOptionsController(ListController listController) {
        this.listController = listController;
    }

    @Override
    public void edit(Window parent, Book item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Book item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
