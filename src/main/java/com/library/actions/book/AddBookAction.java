package com.library.actions.book;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.ReadUserInputUtil;
import com.library.utilities.SaveListToFileUtil;

import java.util.List;

public class AddBookAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        System.out.print("Type book's title: ");
        String title = ReadUserInputUtil.userString();
        System.out.print("Type author's first name: ");
        String firstName = ReadUserInputUtil.userString();
        System.out.print("Type author's last name: ");
        String lastName = ReadUserInputUtil.userString();
        System.out.print("Type amount of items: ");
        Integer amount = ReadUserInputUtil.userInt();

        if (amount != null) {
            Book newItem = new Book(title, firstName, lastName, amount);
            booksBase.add(newItem);
            System.out.println("Item: " + newItem + " - has been added");
            SaveListToFileUtil.saveToFile(booksBase, "booksBase.tmp");
        }
    }
}