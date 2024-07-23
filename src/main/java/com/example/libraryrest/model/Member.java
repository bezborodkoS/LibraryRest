package com.example.libraryrest.model;

import java.util.ArrayList;

public class Member {
    private String name;
    private String memberId;
    private ArrayList<Integer> bookISBNList;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.bookISBNList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public ArrayList<Integer> getBookISBNList() {
        return bookISBNList;
    }

    public void setBookISBNList(ArrayList<Integer> bookISBNList) {
        this.bookISBNList = bookISBNList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberId='" + memberId + '\'' +
                ", bookISBNList=" + bookISBNList +
                '}';
    }
}
