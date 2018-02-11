package com.library.actions;

import com.library.common.Book;
import com.library.common.User;

import java.util.List;

public interface Action {

    void doAction(List<Book> booksBase, List<User> usersBase);

}
//