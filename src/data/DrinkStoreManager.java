/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author vinhphat
 */
public class DrinkStoreManager {

    int maxOfPrice, minOfPrice;
    static Scanner sc = new Scanner(System.in);
    HashMap<String, Double> optionsAndPrice = new HashMap<>();
    Map<String, Drink> list = new HashMap<>();
    Menu menu = new Menu();

    //func 1:
    public void sortMenuByAlphabet() {
        if (list.isEmpty()) {
            System.out.println("Menu is empty");
            return;
        } else {
            ArrayList<Drink> listSort = new ArrayList<>(list.values()); // Lấy hết các giá trị trong map-Drink

            Comparator c = new Comparator() {
                @Override
                public int compare(Object d1, Object d2) {
                    String n1 = ((Drink) d1).getName();
                    String n2 = ((Drink) d2).getName();
                    return n1.compareTo(n2);
                }
            };
            listSort.sort(c);
            int count = 1;
            for (Drink drink : listSort) {
                System.out.printf(count++ + "." + drink.getName() + " - ");
                formatMoney(drink.getPrice());
            }

        }

    }

    //func 2:
    public void addMoreDrinkToMenu() {
        String drinkName;
        double price;
        do {
            do {
                drinkName = Validation.isString("Enter drink name to add (Name to add not duplicate of name in menu): ", "Not empty!");
            } while (findNameofDrink(drinkName));
            price = Validation.isDoubleNumber("Enter price: ", "Not empty!", "Must be double number");
            formatMoney(price);
            list.put(drinkName, new Drink(drinkName, price));
            System.out.println("Add drink to menu success!");
        } while (Validation.isContinue());
    }

    //func 3: 
    public void order() {
        String nameOfDrink;
        int quantity;
        do {
            do {
                nameOfDrink = Validation.isString("Enter name of drink: ", "Not empty!");
                if (findNameofDrink(nameOfDrink) != true) {
                    System.out.println("Name of drink not exist in menu. Enter again!");
                }
            } while (!findNameofDrink(nameOfDrink));
            quantity = Validation.isInteger("Enter quantity: ", "Quantity must be integer number", "Quantity must be greater 0");

            int oldQuantity = list.get(nameOfDrink).getQuantity(); // Lấy quantity cũ
            list.get(nameOfDrink).setQuantity(quantity + oldQuantity); // Set lại quantity mới=Quantity cũ+quantity mới mua
        } while (Validation.isContinue());
    }

    public boolean findNameofDrink(String nameOfDrink) {
        return list.containsKey(nameOfDrink);
    }

    //func 4:
    public void rankOfDrink() {

        ArrayList<Drink> listSortDescending = new ArrayList<>(list.values());
        System.out.println("List Of Rank");
        Comparator c = new Comparator() {
            @Override
            public int compare(Object d1, Object d2) {
                int r1 = ((Drink) d1).getQuantity();
                int r2 = ((Drink) d2).getQuantity();
                return r2 - r1;
            }
        };
        listSortDescending.sort(c);

        for (Drink drink : listSortDescending) {
            System.out.println(drink);
        }

    }

    public static void formatMoney(double money) {
        DecimalFormat df = new DecimalFormat("###,###,###,###(VND)");
        System.out.println(df.format(money));
    }

    public static int countChars(String str) {
        int count = 0;
        return str.length();
    }

    public String defaultSizeOfDescription(String des) {
        int min = 10;
        int max = 15;

        do {
            System.out.println("Enter description: ");
            des = sc.nextLine();
            if (countChars(des) < min || countChars(des) > max) {
                System.out.println("words description must from " + min + " to " + max + "chars");
            }
            return des;
        } while (countChars(des) < min || countChars(des) > max);
    }

    public void setNewMinMaxChars(int newMin, int newMax) {
        newMin = Validation.isInteger("Enter min of length description: ", "Must be integer number", "Number must be greater than 0");
    }

}
