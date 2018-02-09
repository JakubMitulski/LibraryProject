package Library.actions;


import com.library.other.Book;
import com.library.other.User;

import java.util.List;

public class PrintBooksBaseAction implements Action {
    @Override
    public void doAction(List<Book> booksBase, List<User> usersBase) {
        if (!booksBase.isEmpty()) {
            System.out.println("Here is your list: ");
            for (Book index : booksBase) {
                System.out.println(index);
            }
        } else {
            System.out.println("Your base is empty!");
        }
    }
}

//