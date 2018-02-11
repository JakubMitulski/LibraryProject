package com.library.actions;

import com.library.common.Book;
import com.library.common.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveUsersBaseAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        try {
            FileOutputStream fout = new FileOutputStream("usersBase.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(usersBase);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//