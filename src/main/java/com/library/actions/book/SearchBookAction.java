/**
 * SearchBookAction.java
 * Purpose: searching for specific book-position in a books base file.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.actions.book;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.ReadUserInputUtil;
import com.library.utilities.SearchBookUtil;

import java.util.List;

public class SearchBookAction implements Action {

    public void doAction(List<Book> booksBase, List<User> usersBase) {
        System.out.println("Type a book title: ");
        String searchedTitle = ReadUserInputUtil.userString();

        Book book = SearchBookUtil.searchBook(booksBase, searchedTitle);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Wrong title!");
        }
    }
}
