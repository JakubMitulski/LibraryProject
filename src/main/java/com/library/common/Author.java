/**
 * Author.java
 * Purpose: pattern to creating Author instances for Books objects.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.common;

import java.io.Serializable;

public class Author implements Serializable {

    public String firstName;
    public String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}