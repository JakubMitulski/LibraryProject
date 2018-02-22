package com.library.actions.book;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;
import com.library.utilities.PrintListUtil;

import java.util.List;

public class PrintBooksBaseAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        PrintListUtil.printList(booksBase);
    }
}