package com.library;


import com.library.actions.user.*;
import com.library.actions.book.AddBookAction;
import com.library.actions.book.PrintBooksBaseAction;
import com.library.actions.book.RemoveBookAction;
import com.library.actions.book.SearchBookAction;
import com.library.common.Book;
import com.library.common.FileCreator;
import com.library.common.User;
import com.library.actions.*;
import com.library.utils.ReadListFromFileUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Main {
    private static final String PROMPT_SIGN = "> ";
    private static final String EXIT_COMMAND = "exit";
    private static final String COMMAND_NOT_RECOGNIZED = "Command not recognized";
    private static final String ADD_BOOK_COMMAND = "add book";
    private static final String REMOVE_BOOK_COMMAND = "remove book";
    private static final String SEARCH_BOOK_COMMAND = "search book";
    private static final String PRINT_BOOKS_BASE_COMMAND = "print books base";
    private static final String ADD_USER_COMMAND = "add user";
    private static final String REMOVE_USER_COMMAND = "remove user";
    private static final String SEARCH_USER_COMMAND = "search user";
    private static final String PRINT_USERS_BASE_COMMAND = "print users base";
    private static final String BORROW_BOOK_COMMAND = "borrow";
    private static final String RETURN_BOOK_COMMAND = "return";
    private static final String PRINT_USER_BOOKS_COMMAND = "print user books";


    public static void main(String[] args) {
        new FileCreator().createFile("booksBase.tmp");
        new FileCreator().createFile("usersBase.tmp");
        mainMenu();
    }


    private static void mainMenu() {
        List booksBase = ReadListFromFileUtil.readFromFile("booksBase.tmp");
        List usersBase = ReadListFromFileUtil.readFromFile("usersBase.tmp");

        Map<String, Action> actions = new HashMap<>();
        actions.put(ADD_BOOK_COMMAND, new AddBookAction());
        actions.put(REMOVE_BOOK_COMMAND, new RemoveBookAction());
        actions.put(SEARCH_BOOK_COMMAND, new SearchBookAction());
        actions.put(PRINT_BOOKS_BASE_COMMAND, new PrintBooksBaseAction());
        actions.put(ADD_USER_COMMAND, new AddUserAction());
        actions.put(REMOVE_USER_COMMAND, new RemoveUserAction());
        actions.put(SEARCH_USER_COMMAND, new SearchUserAction());
        actions.put(PRINT_USERS_BASE_COMMAND, new PrintUsersBaseAction());
        actions.put(BORROW_BOOK_COMMAND, new BorrowAction());
        actions.put(RETURN_BOOK_COMMAND, new ReturnAction());
        actions.put(PRINT_USER_BOOKS_COMMAND, new PrintUserBooksAction());

        Scanner scanner = new Scanner(System.in);
        String command = " ";
        while (!command.equalsIgnoreCase(EXIT_COMMAND)) {
            System.out.print(PROMPT_SIGN);
            command = scanner.nextLine();
            Action currentAction = actions.get(command);
            if (currentAction == null) {
                System.out.println(COMMAND_NOT_RECOGNIZED);
            } else {
                currentAction.doAction(booksBase, usersBase);
            }
        }
    }
}


