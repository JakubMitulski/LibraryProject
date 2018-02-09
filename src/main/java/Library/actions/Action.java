package Library.actions;

import com.library.other.Book;
import com.library.other.User;

import java.util.List;

public interface Action {

    void doAction(List<Book> booksBase, List<User> usersBase);

}
//