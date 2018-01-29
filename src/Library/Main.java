package Library;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        mainMenu();
    }

    private static void mainMenu() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("bookList.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        LinkedList<Book> dataBase = (LinkedList<Book>) ois.readObject();
        ois.close();
        boolean canContinue = true;
        Scanner userInput = new Scanner(System.in);

        do {
            System.out.println("\n Choose the option: 1 - new item; 2 - remove item; 3 - search item; 4 - print list; 5 - change status; 6 - exit");

            int number = userInput.nextInt();
            switch (number) {
                case 1:
                    addItem(dataBase);
                    break;
                case 2:
                    removeItem(dataBase);
                    break;
                case 3:
                    searchItem(dataBase);
                    break;
                case 4:
                    printList(dataBase);
                    break;
                case 5:
                    changeStatus(dataBase);
                    break;
                case 6:
                    canContinue = false;
                    System.out.println("See you next time!");
                    break;
            }
        } while (canContinue);
    }

    private static void printWarning() {
        System.out.println("Sorry, but your database is empty - add some book first");
    }

    private static Book searchItem(List<Book> list) {
        Scanner sc = new Scanner(System.in);
        Book result = null;

        if (!list.isEmpty()) {
            System.out.println("Type a title: ");
            String searchedTitle = sc.nextLine();
            for (Book aList : list) {
                String title = aList.getTitle();
                if (title.equals(searchedTitle)) {
                    result = aList;
                    System.out.println(result);
                } else {
                    System.out.println("Sorry, cannot find item: " + searchedTitle);
                }
            }
        } else {
            printWarning();
        }
        return result;
    }

    private static void removeItem(List<Book> list) {
        Scanner sc = new Scanner(System.in);
        if (!list.isEmpty()) {
            System.out.println("Type a title to remove: ");
            String searchTitle = sc.nextLine();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getTitle().equals(searchTitle)) {
                    System.out.println("Item: " + list.get(i) + " - has been removed");
                    list.remove(i);
                }
            }
        } else {
            printWarning();
        }
    }

    private static void printList(List<Book> list) {
        if (!list.isEmpty()) {
            System.out.println("Here is your list: ");
            for (Book index : list) {
                System.out.println(index);
            }
        }
    }

    private static void addItem(List<Book> list) throws IOException {
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

        saveList(list);
    }

    private static void changeStatus(List<Book> list) throws IOException, ClassNotFoundException {
        try {
            Book book = searchItem(list);
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
    }

    private static void saveList(List<Book> list) throws IOException {
        FileOutputStream fout = new FileOutputStream ("bookList.txt");
        ObjectOutputStream oos  = new ObjectOutputStream(fout);
        oos.writeObject(list);
        fout.close();
    }

}

