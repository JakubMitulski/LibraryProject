package com.library.actions.book;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;

import java.util.List;
import java.util.Scanner;

public class AddBookAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Type book's title: ");
            String title = sc.nextLine();
            System.out.print("Type author's first name: ");
            String firstName = sc.nextLine();
            System.out.print("Type author's last name: ");
            String lastName = sc.nextLine();
            System.out.print("Type amount of items: ");
            Integer amount = sc.nextInt();

            Book newItem = new Book(title, firstName, lastName, amount);
            booksBase.add(newItem);
            System.out.println("Item: " + newItem + " - has been added");

            new SaveBooksBaseAction().doAction(booksBase, usersBase);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Wrong input!");
        }
    }
}