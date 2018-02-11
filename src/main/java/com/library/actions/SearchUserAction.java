package com.library.actions;

import com.library.common.Book;
import com.library.common.User;

import java.util.List;
import java.util.Scanner;

public class SearchUserAction implements Action {
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        Scanner sc = new Scanner(System.in);
        User result = null;

        if (!usersBase.isEmpty()) {
            System.out.println("Type user ID: ");
            Integer searchedUserId = sc.nextInt();

            for (User user : usersBase) {
                if (user.getUserId().equals(searchedUserId)) {
                    result = user;
                    System.out.println(result);
                }
            }
            if (result == null) {
                System.out.println("Sorry, cannot find user: " + searchedUserId);
            }
        } else {
            System.out.println("Your base is empty!");
        }
    }
}
//