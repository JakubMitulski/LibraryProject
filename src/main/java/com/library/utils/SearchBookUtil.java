package com.library.utils;

import com.library.common.Book;

import java.util.List;

public class SearchBookUtil {

    public static Book searchBook(List<Book> booksBase, String searchedTitle) {
        if (!booksBase.isEmpty()) {
            for (Book book : booksBase) {
                if (book.getTitle().equals(searchedTitle)) {
                    return book;
                }
            }
        } else {
            System.out.println("Base is empty!");
        }
        return null;
    }
}
