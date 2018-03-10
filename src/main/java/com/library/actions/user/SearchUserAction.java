/**
 * SearchUserAction.java
 * Purpose: searching for a specific user who is placed on a list in users base file.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.actions.user;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.ReadUserInputUtil;
import com.library.utilities.SearchUserUtil;

import java.util.List;

public class SearchUserAction implements Action {

    public void doAction(List<Book> booksBase, List<User> usersBase) {
        System.out.println("Type user ID: ");
        Integer searchedUserId = ReadUserInputUtil.userInt();

        User user = SearchUserUtil.searchUser(usersBase, searchedUserId);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Wrong ID!");
        }
    }
}