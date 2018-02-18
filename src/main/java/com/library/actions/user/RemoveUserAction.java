package com.library.actions.user;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utils.SearchUserUtil;

import java.util.List;
import java.util.Scanner;

public class RemoveUserAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type user's ID to remove from base: ");
        Integer searchedUserId = sc.nextInt();
        User searchedUser = SearchUserUtil.searchUser(usersBase, searchedUserId);
        if (searchedUser != null){
            usersBase.remove(searchedUser);
            System.out.println(" that item has been removed from the database.");
            new SaveUsersBaseAction().doAction(booksBase, usersBase);
        }
    }
}
