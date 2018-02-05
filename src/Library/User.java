package Library;

import java.io.Serializable;

public class User implements Serializable {

    private String userFirstName;
    private String userLastName;
    private Integer userId;

    public User(String userName, String userLastName, Integer userId) {
        this.userFirstName = userName;
        this.userLastName = userLastName;
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User " + userFirstName + ", " + userLastName + ", Id: " + userId;
    }
}





