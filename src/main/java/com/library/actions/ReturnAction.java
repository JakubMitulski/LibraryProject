/**
 * ReturnAction.java
 * Purpose: allows to return book by specific user by removing Book instance from his own user base file.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.actions;

import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.*;

import java.util.List;


public class ReturnAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        System.out.println("Type user ID: ");
        Integer userId = ReadUserInputUtil.userInt();
        User user = SearchUserUtil.searchUser(usersBase, userId);
        if (user != null) {
            String fileName = user.getUserFirstName() + "-" + user.getUserLastName() + "-" + user.getUserId() + ".tmp";
            List userBookList = ReadListFromFileUtil.readFromFile(fileName);
            System.out.println("Type book title: ");
            String bookTitle = ReadUserInputUtil.userString();
            Book book = SearchBookUtil.searchBook(userBookList, bookTitle);

            if (book != null) {
                userBookList.remove(book);
                Book returnedBook = SearchBookUtil.searchBook(booksBase, bookTitle);
                returnedBook.setAmount(returnedBook.getAmount() + 1);
                System.out.println("book returned ");
                SaveListToFileUtil.saveToFile(userBookList, fileName);
                SaveListToFileUtil.saveToFile(booksBase, "booksBase.tmp");
            } else {
                System.out.println("User do not have that book on his list!");
            }
        }

    }
}
