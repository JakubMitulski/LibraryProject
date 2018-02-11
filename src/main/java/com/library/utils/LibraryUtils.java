package com.library.utils;

import com.library.common.Book;

import java.util.List;

public class LibraryUtils {
    private LibraryUtils(){
        // empty
    }

    public static Book searchBook(List<Book> books,String searchedTitle){
        for (Book book : books) {
            String title = book.getTitle();
            if (title.equals(searchedTitle)) {
                return book;
            }
        }
        return null;
    }
}
