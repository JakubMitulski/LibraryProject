package com.library.actions;

import com.library.other.Book;
import com.library.other.User;

import java.util.List;


public class BorrowOrReturnAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {

//TODO implement
        /*
        User user = new SearchUserAction().doAction(booksBase, usersBase);
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
                System.out.println(book + " has been removed from user booklist");
                break;
            case 2:
                userBookList.add(book);
                System.out.println(book + " has been added to user booklist");
                break;
        }
        */
    }
}
//