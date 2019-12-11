/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vinhphat
 */
public class Menu {

    ArrayList<String> menu;

    public Menu() {
        menu = new ArrayList<>();
    }

    public void addOption(String option) {
        menu.add(option);
    }

    public void showMenu() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + "." + menu.get(i));
        }
    }

    public int getUserChoice() {
        int result;
        return result=Validation.isInteger("Enter choice: ", "Must be integer number","");
    }
}
