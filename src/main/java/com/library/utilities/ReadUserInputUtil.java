/**
 * ReadUserInputUtil.java
 * Purpose: getting user string or integer input from the keyboard.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadUserInputUtil {

    public static String userString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static Integer userInt() {
        Integer userInput;
        Scanner sc = new Scanner(System.in);
        try {
            userInput = sc.nextInt();
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Incorrect input!");
            return null;
        }
        return userInput;
    }
}