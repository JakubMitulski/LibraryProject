/**
 * SearchBookUtil.java
 * Purpose: searching for specific Book object in a given list.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */

package com.library.utilities;

import com.library.common.Book;

import java.util.List;

public class SearchBookUtil {

    public static Book searchBook(List<Book> booksBase, String searchedTitle) {
        Book result = null;
        if (!booksBase.isEmpty()) {
            for (Book book : booksBase) {
                if (book.getTitle().equals(searchedTitle)) {
                    result = book;
                }
            }
        } else {
            System.out.println("Base is empty!");
        }
        return result;
    }
}
