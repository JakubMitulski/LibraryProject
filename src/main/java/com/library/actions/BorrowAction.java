/**
 * BorrowAction.java
 * Purpose: allows user to borrow book from library by creating a new Book instance which is later saved on a list in specific user base file.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.actions;

import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.*;

import java.util.List;


public class BorrowAction implements Action {
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
            Book book = SearchBookUtil.searchBook(booksBase, bookTitle);

            if (book != null && book.getAmount() > 0) {
                book.setAmount(book.getAmount() - 1);
                userBookList.add(new Book(book));
                System.out.println(" added to user booklist, " + DateAndTimeUtil.currDateAndTime());
                SaveListToFileUtil.saveToFile(userBookList, fileName);
                SaveListToFileUtil.saveToFile(booksBase, "booksBase.tmp");
            } else {
                System.out.println("Wrong title or book not available on stock!");
            }
        } else {
            System.out.println("Wrong ID number!");
        }
    }
}
