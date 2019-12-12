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
public class Input {

    public static int inputNumber(String inputMsg) {

        Scanner sc = new Scanner(System.in);
        int numInteger;

        do {
            try {
                System.out.printf(inputMsg);
                numInteger = Integer.parseInt(sc.nextLine());
                return numInteger;
            } catch (Exception e) {
            }
        } while (true);

    }
}
