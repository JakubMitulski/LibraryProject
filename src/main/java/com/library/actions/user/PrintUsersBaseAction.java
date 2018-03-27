/**
 * PrintUsersBaseAction.java
 * Purpose: printing user list who are able to borrow books from library.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.actions.user;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.PrintListUtil;

import java.util.List;

public class PrintUsersBaseAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        PrintListUtil.printList(usersBase);
    }
}

