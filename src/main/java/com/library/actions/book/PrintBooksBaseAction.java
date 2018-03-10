/**
 * PrintBooksBaseAction.java
 * Purpose: saving books in a base file, which are able to be borrowed from library.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.actions.book;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.PrintListUtil;

import java.util.List;

public class PrintBooksBaseAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        PrintListUtil.printList(booksBase);
    }
}