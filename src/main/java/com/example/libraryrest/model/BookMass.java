package com.example.libraryrest.model;

public class BookMass {
    private String title;
    private String author;
    private int ISBN;
    private boolean isAvailableInLibrary;

    public BookMass(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailableInLibrary = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailableInLibrary() {
        return isAvailableInLibrary;
    }

    public void setAvailableInLibrary(boolean availableInLibrary) {
        isAvailableInLibrary = availableInLibrary;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN=" + ISBN +
                ", isAvailableInLibrary=" + isAvailableInLibrary +
                '}';
    }
}
