/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author vinhphat
 */
public class main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        DrinkStoreManager drinkManager = new DrinkStoreManager();
        int choice;

        menu.addOption("Print menu of list sort by alphabet");
        menu.addOption("Add more drink to menu");
        menu.addOption("Buy drink by quantity");
        menu.addOption("Rank list drink");
        menu.addOption("Update validate range");
        menu.addOption("Exit\n");

        do {
            System.out.println("\n");
            menu.showMenu();
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    drinkManager.sortMenuByAlphabet();
                    break;
                case 2:
                    drinkManager.addMoreDrinkToMenu();
                    break;
                case 3:
                    drinkManager.order();
                    break;
                case 4:
                    drinkManager.rankOfDrink();
                    break;
                case 5:
                    String des = "";
                    
                    System.out.println(drinkManager.defaultSizeOfDescription(des));
            }
        } while (choice != 6);

    }

}
