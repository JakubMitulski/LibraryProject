package com.library.actions.user;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utils.PrintListUtil;
import com.library.utils.ReadListFromFileUtil;
import com.library.utils.SearchUserUtil;

import java.util.List;
import java.util.Scanner;

public class PrintUserBooksAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type user ID: ");
        Integer userId = sc.nextInt();
        User user = SearchUserUtil.searchUser(usersBase, userId);
        if (user != null) {
            String fileName = user.getUserFirstName() + "-" + user.getUserLastName() + "-" + user.getUserId() + ".tmp";
            List userBookList = ReadListFromFileUtil.readFromFile(fileName);
            PrintListUtil.printList(userBookList);
        } else {
            System.out.println("Wrong ID number!");
        }
    }
}
