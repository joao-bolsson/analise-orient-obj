/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jvmarques.controller;

import br.com.jvmarques.entity.Book;
import br.com.jvmarques.model.CustomTableModel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author joaobolsson
 */
public class UserBooksOptionsController implements OptionsController<Book> {

    private final ListController listController;

    private JTable table;

    public UserBooksOptionsController(ListController listController) {
        this.listController = listController;
    }

    @Override
    public void edit(Window parent, Book item) {
        // nothing
    }

    @Override
    public void delete(Book item) {
        // nothing
    }

    @Override
    public boolean showAdd() {
        return false;
    }

    @Override
    public boolean showDelete() {
        return false;
    }

    @Override
    public boolean showEdit() {
        return false;
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

}
