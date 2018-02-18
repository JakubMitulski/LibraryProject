package com.library.actions;

import com.library.common.Book;
import com.library.common.User;
import com.library.utils.ReadListFromFileUtil;
import com.library.utils.SaveListToFileUtil;
import com.library.utils.SearchBookUtil;
import com.library.utils.SearchUserUtil;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ReturnAction implements Action {
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
            Book book = SearchBookUtil.searchBook(userBookList, bookTitle);

            if (userBookList.contains(book)) {
                userBookList.remove(book);
                Book returnedBook = SearchBookUtil.searchBook(booksBase, bookTitle);
                returnedBook.setAmount(returnedBook.getAmount() + 1);
                System.out.println("book returned");
                SaveListToFileUtil.saveToFile(userBookList, fileName);
                SaveListToFileUtil.saveToFile(booksBase, "booksBase.tmp");
            } else {
                System.out.println("User do not have that book on his list!");
            }
        }

    }
}
