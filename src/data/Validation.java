/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Scanner;

/**
 *
 * @author vinhphat
 */
public class Validation {

    public static int isInteger(String msg, String numberException, String numberGreaterThanZeroErr) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int number;
            System.out.printf(msg);
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number <= 0) {
                    System.out.println(numberGreaterThanZeroErr);
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println(numberException);
            }
        }
    }

//    public static int isMixMaxDesciption(String enterMinNum, String enterMaxNum, String numberException, String minNumberGreaterThanZeroErr, int maxNumber, int minNumber) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.printf(enterMinNum);//using regular expression
//            String regix="^[a-zA-Z]{"+minNumber+","+maxNumber+"}$";
//            try {
//                minNumber = Integer.parseInt(sc.nextLine());
//                System.out.println(enterMaxNum);
//                maxNumber = Integer.parseInt(sc.nextLine());
//                if (minNumber < 0) {
//                    System.out.println(minNumberGreaterThanZeroErr);
//                }
//                return maxNumber;
//            } catch (NumberFormatException e) {
//                System.out.println(numberException);
//            }
//        }
//    }

    public static String isString(String msg, String errNotEmpty) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.printf(msg);
            try {
                String str = "";
                str = sc.nextLine().trim();
                if (str.isEmpty()) {
                    System.out.println(errNotEmpty);
                } else {
                    return str;
                }
            } catch (Exception e) {
            }
        }
    }

    public static boolean isContinue() {
        String check;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Do u want to continue? y/n: ");
        check = sc.nextLine().trim().toUpperCase();
        if (check.equalsIgnoreCase("Y")) {
            return true;
        }
        System.out.println("\n");
        return false;
    }

    public static Double isDoubleNumber(String msgEnterDoubleNumber, String errNotEmpty, String errMustBeDoubleNumber) {
        Scanner sc = new Scanner(System.in);
        double numberDouble;
        while (true) {
            System.out.printf(msgEnterDoubleNumber);
            try {
                numberDouble = Double.parseDouble(sc.nextLine());
                return numberDouble;
            } catch (NumberFormatException e) {
                System.out.println(errMustBeDoubleNumber);
            }
        }
    }

}
