/**
 * PrintListUtil.java
 * Purpose: Printing all elements from given list.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.utilities;

import java.util.List;

public class PrintListUtil {
    public static void printList(List list) {
        if (!list.isEmpty()) {
            for (Object item : list) {
                System.out.println(item);
            }
        } else {
            System.out.println("Base is empty!");
        }
    }
}
