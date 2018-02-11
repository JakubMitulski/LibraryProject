package com.library.actions;


import com.library.common.Book;
import com.library.common.User;

import java.util.List;

public class PrintBooksBaseAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        if (!booksBase.isEmpty()) {
            System.out.println("Here is your list: ");
            for (Book index : booksBase) {
                System.out.println(index);
            }
        } else {
            System.out.println("Your base is empty!");
        }
    }
}

//