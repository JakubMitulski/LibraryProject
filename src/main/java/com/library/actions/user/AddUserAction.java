package com.library.actions.user;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.FileCreator;
import com.library.common.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddUserAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        Integer userId = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Type user first name: ");
        String userFirstName = sc.nextLine();
        System.out.print("Type user last name: ");
        String userLastName = sc.nextLine();
        System.out.print("Type user ID: ");
        try {
            userId = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("User ID contains only digits!");
        }

        if (userId != null) {
            User newUser = new User(userFirstName, userLastName, userId);
            usersBase.add(newUser);
            System.out.println("User: " + newUser + " added to database");
            new SaveUsersBaseAction().doAction(booksBase, usersBase);
            new FileCreator().createFile(userFirstName + "-" + userLastName + "-" + userId + ".tmp");
        }
    }
}