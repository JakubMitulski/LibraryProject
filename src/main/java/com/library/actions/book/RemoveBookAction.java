package com.library.actions.book;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utils.SearchBookUtil;

import java.util.List;
import java.util.Scanner;

public class RemoveBookAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) throws NullPointerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the book title to remove from books base: ");
        String searchedTitle = sc.nextLine();
        Book book = SearchBookUtil.searchBook(booksBase, searchedTitle);
        if (book != null) {
            booksBase.remove(book);
            System.out.println(book.getTitle() + " removed from the database.");
            new SaveBooksBaseAction().doAction(booksBase, usersBase);
        } else{
            System.out.println("Wrong title!");
        }
    }
}