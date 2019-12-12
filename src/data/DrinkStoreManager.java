package data;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author vinhphat
 */
public class DrinkStoreManager {

    int minOfDesLength = 100, maxOfDesLength = 500;

    int minOfPrice, maxOfPrice;
    
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

    public String defaultSizeOfDescription() {
        String tempString = "";
        int minLength = 0, maxLength = 0;
        minLength = Input.inputNumber("Enter min of length: ");
        maxLength = Input.inputNumber("Enter max of length: ");
        
        do {
            try {
                System.out.println("Enter desciption from " + minLength + " to " + maxLength);
                String des = sc.nextLine();
                if (des.length() < minLength || des.length() > maxLength) {
                    System.out.println("length ur description not between " + minLength + " and " + maxLength);
                    tempString += des;
                }
            } catch (Exception e) {
            }
        } while (tempString.length() < minLength || tempString.length() > maxLength);
        return tempString;
    }


//    public String getDes() {
//        String temp = "";
//        do {
//            String des = sc.nextLine();
//            if (des.length() < 20 - temp.length()) {
//                temp += des;
//            }
//        } while (temp.length() < 10 || temp.length() > 20);
//        return temp;
//
//    }

    public void setDomainOfPrice(){
        
    }

}
