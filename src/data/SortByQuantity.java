/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Comparator;

/**
 *
 * @author vinhphat
 */
class SortByQuantity implements Comparator<Drink> {

    @Override
    public int compare(Drink drink1, Drink drink2) {
        return drink1.getQuantity() - drink2.getQuantity();
    }

}
