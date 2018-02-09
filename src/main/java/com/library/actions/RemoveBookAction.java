package com.library.actions;


import com.library.other.Book;
import com.library.other.User;

import java.util.List;
import java.util.Scanner;

public class RemoveBookAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) throws NullPointerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type book title to remove: ");
        String searchedTitle = sc.nextLine();
        for (Book book : booksBase) {
            String title = book.getTitle();
            if (title.equals(searchedTitle)) {
                booksBase.remove(book);
                System.out.println(" - that item has been removed from the database.");
                new SaveBooksBaseAction().doAction(booksBase, usersBase);
                break;
            }
        }
    }
}


//