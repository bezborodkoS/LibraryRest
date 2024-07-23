package com.example.libraryrest.model;



import java.util.ArrayList;

public class Library {
    private String nameLibrary;
    private String addressLibrary;

    private ArrayList<Book> bookList;
    private ArrayList<Member> membersList;

    public Library(String nameLibrary, String addressLibrary) {
        this.nameLibrary = nameLibrary;
        this.addressLibrary = addressLibrary;
    }

    public String getNameLibrary() {
        return nameLibrary;
    }

    public void setNameLibrary(String nameLibrary) {
        this.nameLibrary = nameLibrary;
    }

    public String getAddressLibrary() {
        return addressLibrary;
    }

    public void setAddressLibrary(String addressLibrary) {
        this.addressLibrary = addressLibrary;
    }

    public ArrayList<Book> getBooksList() {
        return bookList;
    }

    public void setBooksList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Member> getMembersList() {
        return membersList;
    }

    public void setMembersList(ArrayList<Member> membersList) {
        this.membersList = membersList;
    }
}
