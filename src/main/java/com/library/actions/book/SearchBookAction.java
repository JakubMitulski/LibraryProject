package com.library.actions.book;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utils.SearchBookUtil;

import java.util.List;
import java.util.Scanner;

public class SearchBookAction implements Action {

    public void doAction(List<Book> booksBase, List<User> usersBase) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a book title: ");
        String searchedTitle = sc.nextLine();

        Book book = SearchBookUtil.searchBook(booksBase, searchedTitle);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Wrong title!");
        }
    }
}
