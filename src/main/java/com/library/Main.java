package com.library;

import com.library.actions.user.*;
import com.library.actions.book.*;
import com.library.common.FileCreator;
import com.library.actions.*;
import com.library.utilities.*;

import java.util.*;

public class Main {
    private static final String PROMPT_SIGN = "> ";
    public static final String EXIT_COMMAND = "exit";
    private static final String COMMAND_NOT_RECOGNIZED = "Command not recognized";
    public static final String ADD_BOOK_COMMAND = "add book";
    public static final String REMOVE_BOOK_COMMAND = "remove book";
    public static final String SEARCH_BOOK_COMMAND = "search book";
    public static final String PRINT_BOOKS_BASE_COMMAND = "print books base";
    public static final String ADD_USER_COMMAND = "add user";
    public static final String REMOVE_USER_COMMAND = "remove user";
    public static final String SEARCH_USER_COMMAND = "search user";
    public static final String PRINT_USERS_BASE_COMMAND = "print users base";
    public static final String BORROW_BOOK_COMMAND = "borrow";
    public static final String RETURN_BOOK_COMMAND = "return";
    public static final String PRINT_USER_BOOKS_COMMAND = "print user books";
    private static final String PRINT_COMMANDS = "print commands";

    public static void main(String[] args) {
        new FileCreator().createFile("booksBase.tmp");
        new FileCreator().createFile("usersBase.tmp");
        System.out.println(DateAndTimeUtil.currDateAndTime());
        System.out.println("Type \"print commands\" to see available actions");
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
        actions.put(PRINT_COMMANDS, new PrintCommandsAction());

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


