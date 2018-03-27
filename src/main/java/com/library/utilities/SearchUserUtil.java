/**
 * SearchUserUtil.java
 * Purpose: searching for specific User object in a given list.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */

package com.library.utilities;

import com.library.common.User;

import java.util.List;

public class SearchUserUtil {

    public static User searchUser(List<User> usersBase, Integer searchedUserId) {
        User result = null;
        if (!usersBase.isEmpty()) {
            for (User user : usersBase) {
                if (user.getUserId().equals(searchedUserId)) {
                    result = user;
                }
            }
        } else {
            System.out.println("Base is empty!");
        }
        return result;
    }
}
