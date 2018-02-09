package com.library.actions;

import com.library.other.Book;
import com.library.other.FileCreator;
import com.library.other.User;

import java.util.List;
import java.util.Scanner;


public class AddUserAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type user first name: ");
        String userFirstName = sc.nextLine();
        System.out.print("Type user last name: ");
        String userLastName = sc.nextLine();
        System.out.print("Type user ID: ");
        Integer userId = sc.nextInt();

        User newUser = new User(userFirstName, userLastName, userId);
        usersBase.add(newUser);
        System.out.println("User: " + newUser + " - has been added to database");
        new SaveUsersBaseAction().doAction(booksBase, usersBase);
        new FileCreator().createFile(userFirstName + "-" + userLastName + "-" + userId + ".tmp");

    }
}
//