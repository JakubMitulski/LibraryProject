package com.library.utils;

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
