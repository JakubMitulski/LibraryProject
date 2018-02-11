package com.library.actions;

import com.library.common.Book;
import com.library.common.User;

import java.util.List;
import java.util.Scanner;

public class SearchBookAction implements Action {

    public void doAction(List<Book> booksBase, List<User> usersBase) {
        Scanner sc = new Scanner(System.in);
        Book result = null;

        if (!booksBase.isEmpty()) {
            System.out.println("Type a title: ");
            String searchedTitle = sc.nextLine();

            for (Book item : booksBase) {
                if (item.getTitle().equals(searchedTitle)) {
                    result = item;
                    System.out.println(result);
                }
            }
            if (result == null) {
                System.out.println("Sorry, cannot find item: " + searchedTitle);
            }
        } else {
            System.out.println("Your base is empty!");
        }
    }
}
//
