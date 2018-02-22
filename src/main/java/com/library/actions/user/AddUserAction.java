package com.library.actions.user;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.FileCreator;
import com.library.common.User;
import com.library.utilities.ReadUserInputUtil;
import com.library.utilities.SaveListToFileUtil;

import java.util.List;

public class AddUserAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        System.out.print("Type user first name: ");
        String userFirstName = ReadUserInputUtil.userString();
        System.out.print("Type user last name: ");
        String userLastName = ReadUserInputUtil.userString();
        System.out.println("Type unique user ID: ");
        Integer userId = ReadUserInputUtil.userInt();
        User newUser = new User(userFirstName, userLastName, userId);
        usersBase.add(newUser);
        System.out.println(newUser + " added to database");
        SaveListToFileUtil.saveToFile(usersBase, "usersBase.tmp");
        new FileCreator().createFile(userFirstName + "-" + userLastName + "-" + newUser.getUserId() + ".tmp");
    }
}