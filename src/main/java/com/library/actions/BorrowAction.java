package com.library.actions;

import com.library.common.Book;
import com.library.common.User;
import com.library.utils.ReadListFromFileUtil;
import com.library.utils.SaveListToFileUtil;
import com.library.utils.SearchBookUtil;
import com.library.utils.SearchUserUtil;

import java.util.List;
import java.util.Scanner;


public class BorrowAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type user ID: ");
        Integer userId = sc.nextInt();
        User user = SearchUserUtil.searchUser(usersBase, userId);
        if (user != null) {
            String fileName = user.getUserFirstName() + "-" + user.getUserLastName() + "-" + user.getUserId() + ".tmp";
            List userBookList = ReadListFromFileUtil.readFromFile(fileName);

            sc.nextLine();
            System.out.println("Type book title: ");
            String bookTitle = sc.nextLine();
            Book book = SearchBookUtil.searchBook(booksBase, bookTitle);

            if (book != null && book.getAmount() > 0) {
                book.setAmount(book.getAmount() - 1);
                userBookList.add(book);
                System.out.println(book.getTitle() + " added to user booklist");
                SaveListToFileUtil.saveToFile(userBookList, fileName);
                SaveListToFileUtil.saveToFile(booksBase, "booksBase.tmp");
            } else {
                System.out.println("Wrong title or book not available on stock!");
            }
        } else {
            System.out.println("Wrong ID number!");
        }
    }
}
