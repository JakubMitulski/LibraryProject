package com.library.actions.user;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.ReadUserInputUtil;
import com.library.utilities.SaveListToFileUtil;
import com.library.utilities.SearchUserUtil;

import java.util.List;

public class RemoveUserAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        System.out.println("Type user's ID to remove from base: ");
        Integer searchedUserId = ReadUserInputUtil.userInt();
        User searchedUser = SearchUserUtil.searchUser(usersBase, searchedUserId);
        if (searchedUser != null) {
            usersBase.remove(searchedUser);
            System.out.println(" that item has been removed from the database.");
            SaveListToFileUtil.saveToFile(usersBase, "usersBase.tmp");
        }
    }
}
