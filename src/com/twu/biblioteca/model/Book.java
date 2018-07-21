package com.twu.biblioteca.model;

public class Book {
    private String name;
    private String author;
    private int publishedYear;
    public boolean isCheckedOut;

    public Book(String name, String author, int publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        isCheckedOut = false;
    }

    public void setCheckedStatus(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-30s\n", name, author, publishedYear);
    }

    public boolean getCheckedStatus(){
        return isCheckedOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}
