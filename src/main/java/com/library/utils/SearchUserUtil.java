package com.library.utils;

import com.library.common.User;

import java.util.List;

public class SearchUserUtil {

    public static User searchUser(List<User> usersBase, Integer searchedUserId) {
        if (!usersBase.isEmpty()) {
            for (User user : usersBase) {
                if (user.getUserId().equals(searchedUserId)) {
                    return user;
                }
            }
        } else {
            System.out.println("Base is empty!");
        }
        return null;
    }
}
