package com.library.actions;

import com.library.common.Book;
import com.library.common.User;

import java.util.List;

import static com.library.Main.*;

public class PrintCommandsAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        System.out.println(EXIT_COMMAND + "\n \n" +
                ADD_BOOK_COMMAND + "\n" +
                REMOVE_BOOK_COMMAND + "\n" +
                SEARCH_BOOK_COMMAND + "\n" +
                PRINT_BOOKS_BASE_COMMAND + "\n \n" +
                ADD_USER_COMMAND + "\n" +
                REMOVE_USER_COMMAND + "\n" +
                SEARCH_USER_COMMAND + "\n" +
                PRINT_USERS_BASE_COMMAND + "\n" +
                PRINT_USER_BOOKS_COMMAND + "\n \n" +
                BORROW_BOOK_COMMAND + "\n" +
                RETURN_BOOK_COMMAND);
    }
}
