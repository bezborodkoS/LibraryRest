package com.example.libraryrest.model;

import java.util.Arrays;

public class MemberMass {
    private String name;
    private String memberId;
    private BookMass[] bookMass;

    public MemberMass(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.bookMass = new BookMass[5];
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

    public BookMass[] getBookMass() {
        return bookMass;
    }

    public void setBookMass(BookMass[] bookMass) {
        this.bookMass = bookMass;
    }

    @Override
    public String toString() {
        return "MemberMass{" +
                "name='" + name + '\'' +
                ", memberId='" + memberId + '\'' +
                ", bookMass=" + Arrays.toString(bookMass) +
                '}';
    }

    public int countBooksWhatMemberTook(){
        int count=0;
        for (BookMass book : bookMass) {
            if (book!=null){
                count++;
            }
        }
        return count;
    }

    public int indexBookInMemberListBooks(int ISBN){
        int index=0;
        for (BookMass book : bookMass) {
            if (book.getISBN()==ISBN){
                return index;
            }
            index++;
        }
        return -1;
    }


}
