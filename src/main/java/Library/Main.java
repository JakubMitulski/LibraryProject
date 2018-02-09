package Library;


import com.library.actions.*;
import com.library.other.Book;
import com.library.other.FileCreator;
import com.library.other.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Main {
    public static final String PROMPT_SIGN = "> ";
    public static final String EXIT_COMMAND = "exit";
    public static final String COMMAND_NOT_RECOGNIZED = "Command not recognized";
    public static final String ADD_BOOK_COMMAND = "add book";
    public static final String REMOVE_BOOK_COMMAND = "remove book";
    public static final String SEARCH_BOOK_COMMAND = "search book";
    public static final String SAVE_BOOKS_BASE_COMMAND = "save books base";
    public static final String PRINT_BOOKS_BASE_COMMAND = "print books base";


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new FileCreator().createFile("bookBase.tmp");
        new FileCreator().createFile("userBase.tmp");
        mainMenu();
    }


    private static void mainMenu() throws IOException, ClassNotFoundException {
        List<Book> booksBase = new LinkedList<>();
        List<User> usersBase = new LinkedList<>();

        FileInputStream fileInputStreamBookList = new FileInputStream("bookBase.tmp");
        if (fileInputStreamBookList.available() != 0) {
            ObjectInputStream objectInputStreamBookList = new ObjectInputStream(fileInputStreamBookList);
            booksBase = (LinkedList<Book>) objectInputStreamBookList.readObject();
            objectInputStreamBookList.close();
        }

        FileInputStream fileInputStreamUserList = new FileInputStream("userBase.tmp");
        if (fileInputStreamUserList.available() != 0) {
            ObjectInputStream objectInputStreamUserList = new ObjectInputStream(fileInputStreamUserList);
            usersBase = (LinkedList<User>) objectInputStreamUserList.readObject();
            objectInputStreamUserList.close();
        }

        Map<String, Action> actions = new HashMap<>();
        actions.put(ADD_BOOK_COMMAND, new AddBookAction());
        actions.put(REMOVE_BOOK_COMMAND, new RemoveBookAction());
        actions.put(SEARCH_BOOK_COMMAND, new SearchBookAction());
        actions.put(SAVE_BOOKS_BASE_COMMAND, new SaveBooksBaseAction());
        actions.put(PRINT_BOOKS_BASE_COMMAND, new PrintBooksBaseAction());

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

//TODO verify this code



