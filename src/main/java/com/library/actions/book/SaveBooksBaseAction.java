package com.library.actions.book;

import com.library.actions.Action;
import com.library.common.Book;
import com.library.common.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveBooksBaseAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        try {
            FileOutputStream fout = null;
            fout = new FileOutputStream("booksBase.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(booksBase);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}