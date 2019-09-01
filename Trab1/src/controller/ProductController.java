/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ListModel;
import model.Product;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Sep 01.
 */
public class ProductController extends ListModel<Product> {

    public ProductController() {
    }

    public Product getProduct(final String name) {
        if (name != null && name.isEmpty()) {
            for (Product prod : list) {
                if (name.equals(prod.getName())) {
                    return prod;
                }
            }
        }

        return null;
    }

}
