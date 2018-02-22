package com.library.actions.book;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.ReadUserInputUtil;
import com.library.utilities.SaveListToFileUtil;
import com.library.utilities.SearchBookUtil;

import java.util.List;

public class RemoveBookAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) throws NullPointerException {
        System.out.println("Type the book title to remove from books base: ");
        String searchedTitle = ReadUserInputUtil.userString();
        Book book = SearchBookUtil.searchBook(booksBase, searchedTitle);
        if (book != null) {
            booksBase.remove(book);
            System.out.println(book.getTitle() + " removed from the database.");
            SaveListToFileUtil.saveToFile(booksBase, "booksBase.tmp");
        } else {
            System.out.println("Wrong title!");
        }
    }
}