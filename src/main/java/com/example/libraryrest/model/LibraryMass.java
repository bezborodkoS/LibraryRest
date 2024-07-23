package com.example.libraryrest.model;

import java.util.Arrays;

public class LibraryMass {
    private String nameLibrary;
    private String addressLibrary;

    private BookMass[] booksList;
    private MemberMass[] membersList;

    public LibraryMass(String nameLibrary, String addressLibrary) {
        this.nameLibrary = nameLibrary;
        this.addressLibrary = addressLibrary;
        this.booksList = new BookMass[100];
        this.membersList = new MemberMass[20];
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

    public BookMass[] getBooksList() {
        return booksList;
    }

    public void setBooksList(BookMass[] booksList) {
        this.booksList = booksList;
    }

    public MemberMass[] getMembersList() {
        return membersList;
    }

    public void setMembersList(MemberMass[] membersList) {
        this.membersList = membersList;
    }

    @Override
    public String toString() {
        return "LibraryMass{" +
                "nameLibrary='" + nameLibrary + '\'' +
                ", addressLibrary='" + addressLibrary + '\'' +
                ", booksList=" + Arrays.toString(booksList) +
                ", membersList=" + Arrays.toString(membersList) +
                '}';
    }

    public int sizeMembersInMass(){
        int count=0;
        for (MemberMass member: membersList) {
            if (member!=null){
                count++;
            }
        }
        return count;
    }

    public int sizeBooksInMass(){
        int count=0;
        for (BookMass book: booksList) {
            if (book!=null){
                count++;
            }
        }
        return count;
    }

    public MemberMass getMemberById(String memberId){
        for (MemberMass member :membersList) {
            if (member!=null&&member.getMemberId().equals(memberId)){
                return member;
            }
        }
        return null;
    }

    public int foundBookIndexInLibraryMass(int ISBN){
        int index = 0;
        for (BookMass book :booksList) {
            if (book.getISBN()==ISBN){
                return index;
            }
            index++;
        }
        return -1;
    }

    public BookMass getBookByISBNAndAvailableIsTrue(int ISBN){
        for (BookMass book :booksList) {
            if (book!=null&&book.getISBN()==ISBN&& book.isAvailableInLibrary()){
                return book;
            }
        }
        return null;
    }

    public BookMass getBookByISBNAndAvailableIsFalse(int ISBN){
        for (BookMass book :booksList) {
            if (book!=null&&book.getISBN()==ISBN&& !book.isAvailableInLibrary()){
                return book;
            }
        }
        return null;
    }
}
