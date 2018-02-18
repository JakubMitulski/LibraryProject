package com.library.actions.user;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utils.SearchUserUtil;

import java.util.List;
import java.util.Scanner;

public class SearchUserAction implements Action {

    public void doAction(List<Book> booksBase, List<User> usersBase) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type user ID: ");
        Integer searchedUserId = sc.nextInt();

        User user = SearchUserUtil.searchUser(usersBase, searchedUserId);
        if (user != null){
            System.out.println(user);
        } else {
            System.out.println("Wrong ID!");
        }
    }
}