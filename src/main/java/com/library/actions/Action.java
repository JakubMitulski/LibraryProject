/**
 * Action.java
 * Purpose: interface which allows it's implemented classes to be placed in a actions map operated by a Main method.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.actions;

import com.library.common.Book;
import com.library.common.User;

import java.util.List;

public interface Action {

    void doAction(List<Book> booksBase, List<User> usersBase);

}
