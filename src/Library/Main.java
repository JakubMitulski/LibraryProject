package Library;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        createFile("bookBase.tmp");
        createFile("userBase.tmp");
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

        boolean canContinue = true;

        do {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\n Choose the option: 1 - add new book; 2 - remove item; 3 - search book; " +
                    "4 - print list; 5 - change status; 6 - exit; 7 - add new user; 8 - search user; 9 - borrow/return book");

            int number = userInput.nextInt();
            switch (number) {
                case 1:
                    addBookToBase(booksBase);
                    break;
                case 2:
                    removeBookFromBase(booksBase, searchBookInBase(booksBase));
                    break;
                case 3:
                    searchBookInBase(booksBase);
                    break;
                case 4:
                    printBookBase(booksBase);
                    break;
                case 5:
                    changeStatus(booksBase);
                    break;
                case 6:
                    canContinue = false;
                    System.out.println("See you next time!");
                    break;
                case 7:
                    addUserToBase(usersBase);
                    break;
                case 8:
                    searchUserInBase(usersBase);
                    break;
                case 9:
                    borrowOrReturnBook(usersBase, booksBase);
                    break;

            }
        } while (canContinue);

    }

    private static void printEmptyBaseWaring() {
        System.out.println("Sorry, but your database is empty - add some positions first");
    }

    private static Book searchBookInBase(List<Book> list) {
        Scanner sc = new Scanner(System.in);
        Book result = null;

        if (!list.isEmpty()) {
            System.out.println("Type a title: ");
            String searchedTitle = sc.nextLine();

            for (Book item : list) {
                if (item.getTitle().equals(searchedTitle)) {
                    result = item;
                    System.out.println(result);
                }
            }
            if (result == null) {
                System.out.println("Sorry, cannot find item: " + searchedTitle);
            }
        } else {
            printEmptyBaseWaring();
        }
        return result;
    }

    private static void removeBookFromBase(List<Book> list, Book book) throws IOException {
        try {
            if (!book.getTitle().isEmpty()) {
                list.remove(book);
                System.out.println(" - that item has been removed from the database.");
                saveBookBase(list);
            }
        } catch (NullPointerException e) {
        }
    }

    private static void printBookBase(List<Book> list) {
        if (!list.isEmpty()) {
            System.out.println("Here is your list: ");
            for (Book index : list) {
                System.out.println(index);
            }
        } else {
            printEmptyBaseWaring();
        }
    }

    private static void addBookToBase(List<Book> list) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Type book's title: ");
            String title = sc.nextLine();
            System.out.print("Type author's first name: ");
            String firstName = sc.nextLine();
            System.out.print("Type author's last name: ");
            String lastName = sc.nextLine();
            System.out.print("Type amount of items: ");
            Integer amount = sc.nextInt();

            Book newItem = new Book(title, firstName, lastName, amount);
            list.add(newItem);
            System.out.println("Item: " + newItem + " - has been added");

            saveBookBase(list);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Wrong input!");
        }
    }

    private static void changeStatus(List<Book> list) throws IOException, ClassNotFoundException {
        try {
            Book book = searchBookInBase(list);
            Integer amount = book.getAmount();
            System.out.println("To hire type 1, to return type 2: ");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    amount--;
                    break;
                case 2:
                    amount++;
                    break;
            }
            if (amount >= 0) {
                book.setAmount(amount);
            } else {
                System.out.println("Sorry, item not available");
            }
            System.out.println(book);
        } catch (java.lang.NullPointerException e) {
            mainMenu();
        }
        saveBookBase(list);
    }

    private static void saveBookBase(List<Book> list) throws IOException {
        FileOutputStream fout = new FileOutputStream("bookBase.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(list);
        fout.close();
    }

    private static void saveUserBase(List<User> userList) throws IOException {
        FileOutputStream fout = new FileOutputStream("userBase.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(userList);
        fout.close();
    }

    private static void addUserToBase(List<User> userList) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Type user first name: ");
            String userFirstName = sc.nextLine();
            System.out.print("Type user last name: ");
            String userLastName = sc.nextLine();
            System.out.print("Type user ID: ");
            Integer userId = sc.nextInt();

            User newUser = new User(userFirstName, userLastName, userId);
            userList.add(newUser);
            System.out.println("User: " + newUser + " - has been added to database");
            saveUserBase(userList);
            createFile(userFirstName + "-" + userLastName + "-" + userId + ".tmp");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User searchUserInBase(List<User> list) {
        Scanner sc = new Scanner(System.in);
        User result = null;

        if (!list.isEmpty()) {
            System.out.println("Type user ID: ");
            Integer searchedUserId = sc.nextInt();

            for (User user : list) {
                if (user.getUserId().equals(searchedUserId)) {
                    result = user;
                    System.out.println(result);
                }
            }
            if (result == null) {
                System.out.println("Sorry, cannot find user: " + searchedUserId);
            }
        } else {
            printEmptyBaseWaring();
        }
        return result;
    }

    private static void borrowOrReturnBook(List<User> userBase, List<Book> bookBase) throws IOException, ClassNotFoundException {
        User user = searchUserInBase(userBase);
        Book book = searchBookInBase(bookBase);

        System.out.println("To return book type 1, to borrow type 2:");
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();

        String path = user.getUserFirstName() + "-" + user.getUserLastName() + "-" + user.getUserId() + ".tmp";
        List<Book> userBookList = new LinkedList<>();
        FileInputStream fileInputStreamUserBookList = new FileInputStream(path);
        if (fileInputStreamUserBookList.available() != 0) {
            ObjectInputStream objectInputStreamUserBookList = new ObjectInputStream(fileInputStreamUserBookList);
            userBookList = (LinkedList<Book>) objectInputStreamUserBookList.readObject();
            objectInputStreamUserBookList.close();
        }
        System.out.println(path);

        switch (number) {
            case 1:
                userBookList.remove(book);
                System.out.println(book + " has been removed from user booklist" );
                break;
            case 2:
                userBookList.add(book);
                System.out.println(book + " has been added to user booklist");
                break;
        }
    }

    private static void createFile(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




