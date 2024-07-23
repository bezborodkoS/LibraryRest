package com.example.libraryrest.service;

import com.example.libraryrest.model.BookMass;
import com.example.libraryrest.model.LibraryMass;
import com.example.libraryrest.model.MemberMass;

public class LibraryManagementMass {
    private LibraryMass libraryMass;

    public LibraryManagementMass(LibraryMass libraryMass) {
        this.libraryMass = libraryMass;
    }

    public void addMember(MemberMass member) {
        if (libraryMass.sizeMembersInMass() < libraryMass.getMembersList().length) {
            System.out.println("add member " + member.getName());
            libraryMass.getMembersList()[libraryMass.sizeMembersInMass()] = member;
        }
    }

    public void addBook(BookMass book) {
        if (libraryMass.sizeBooksInMass() < libraryMass.getBooksList().length) {
            System.out.println("add book " + book.getTitle());
            libraryMass.getBooksList()[libraryMass.sizeBooksInMass()] = book;
        }
    }

    public void memberTakeBookInLibrary(int ISBN, String memberId) {
        BookMass book = libraryMass.getBookByISBNAndAvailableIsTrue(ISBN);
        MemberMass member = libraryMass.getMemberById(memberId);
        if (member == null) {
            System.out.println("!!!!!!!!!! Check member Id");
        } else if (book == null) {
            System.out.println("!!!!!!!!!! Check book ISBN");
        } else if (member.countBooksWhatMemberTook() >= member.getBookMass().length) {
            System.out.println(member.getName() + " cant take more book");
        }
        if (member.countBooksWhatMemberTook() < member.getBookMass().length && book != null && libraryMass.foundBookIndexInLibraryMass(ISBN) != -1) {
            book.setAvailableInLibrary(false);
            libraryMass.getBooksList()[libraryMass.foundBookIndexInLibraryMass(ISBN)] = book;
            member.getBookMass()[member.countBooksWhatMemberTook()] = book;
            System.out.println(member.getName() + " take " + book.getTitle());
        }
    }

    public void memberReturnBookInLibrary(int ISBN, String memberId) {
        BookMass book = libraryMass.getBookByISBNAndAvailableIsFalse(ISBN);
        MemberMass member = libraryMass.getMemberById(memberId);
        if (member == null) {
            System.out.println("!!!!!!!!!! Check member Id        Return");
        } else if (book == null) {
            System.out.println("!!!!!!!!!! Check book ISBN          Return");
        }
        if (book != null && libraryMass.foundBookIndexInLibraryMass(ISBN) != -1) {
            book.setAvailableInLibrary(true);
            libraryMass.getBooksList()[libraryMass.foundBookIndexInLibraryMass(ISBN)] = book;
            member.getBookMass()[member.indexBookInMemberListBooks(ISBN)] = null;
            System.out.println(member.getName() + " return " + book.getTitle());
        }
    }

    public int howManyBooksInLibrary(){
        int count = 0;
        for (BookMass book : libraryMass.getBooksList()) {
            if (book!=null&&book.isAvailableInLibrary()){
                count++;
            }
        }
        return count;
    }

    public int howManyBooksTakesFromLibrary(){
        int count = 0;
        for (BookMass book : libraryMass.getBooksList()) {
            if (book!=null&&!book.isAvailableInLibrary()){
                count++;
            }
        }
        return count;
    }

}
