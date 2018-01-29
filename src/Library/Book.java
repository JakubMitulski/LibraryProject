package Library;

import java.io.Serializable;

public class Book implements Serializable {

    private Author author;
    private String title;
    private Integer amount;

    public Book(String title, String firstName, String lastName, Integer amount) {
        this.title = title;
        this.amount = amount;
        this.author = new Author(firstName, lastName);
    }

    public Book(String title, String firstNameOne, String lastNameOne, String firstNameTwo, String lastNameTwo, Integer amount) {
        this.title = title;
        this.amount = amount;
        this.author = new Author(firstNameOne, lastNameOne);
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

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + getAuthor() + ", Amount: " + amount;
    }
}
