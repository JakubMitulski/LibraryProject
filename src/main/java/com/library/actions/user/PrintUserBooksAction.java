package com.library.actions.user;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.ReadListFromFileUtil;
import com.library.utilities.ReadUserInputUtil;
import com.library.utilities.SearchUserUtil;

import java.util.List;

public class PrintUserBooksAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        System.out.println("Type user ID: ");
        Integer userId = ReadUserInputUtil.userInt();
        User user = SearchUserUtil.searchUser(usersBase, userId);
        if (user != null) {
            String fileName = user.getUserFirstName() + "-" + user.getUserLastName() + "-" + user.getUserId() + ".tmp";
            List<Book> userBookList = ReadListFromFileUtil.readFromFile(fileName);
            if (!userBookList.isEmpty()) {
                for (Book book : userBookList) {
                    System.out.println(book + "; Borrowed on: " + book.getCurrDateAndTime());
                }
            } else {
                System.out.println("Base is empty!");
            }
        } else {
            System.out.println("Wrong user ID!");
        }
    }
}
