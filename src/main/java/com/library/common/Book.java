/**
 * Book.java
 * Purpose: pattern to creating Book objects.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.common;

import com.library.utilities.DateAndTimeUtil;

import java.io.Serializable;

public class Book implements Serializable {

    private Author author;
    private String title;
    private Integer amount;
    private String currDateAndTime;

    public Book(String title, String firstName, String lastName, Integer amount) {
        this.title = title;
        this.amount = amount;
        this.author = new Author(firstName, lastName);
    }

    public Book(Book book) {
        this.title = book.getTitle();
        this.amount = book.getAmount();
        this.author = new Author(book.getAuthorFirstName(), book.getAuthorLastName());
        this.currDateAndTime = DateAndTimeUtil.currDateAndTime();
    }

    public String getTitle() {
        return title;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAuthor() {
        return author.firstName + " " + author.lastName;
    }

    public String getAuthorFirstName() {
        return author.firstName;
    }

    public String getAuthorLastName() {
        return author.lastName;
    }

    public String getCurrDateAndTime() {
        return currDateAndTime;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + getAuthor() + ", Amount on stock: " + amount;
    }
}
