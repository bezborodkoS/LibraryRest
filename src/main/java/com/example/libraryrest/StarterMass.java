package com.example.libraryrest;

import com.example.libraryrest.model.BookMass;
import com.example.libraryrest.model.LibraryMass;
import com.example.libraryrest.model.MemberMass;
import com.example.libraryrest.service.LibraryManagementMass;

public class StarterMass {
    public static void main(String[] args) {
        BookMass book1 = new BookMass("Железное пламя", "Ребекка Яррос", 1);
        BookMass book2 = new BookMass("Слишком поздно", "Колин Гувер", 2);
        BookMass book3 = new BookMass("Черные холмы", "Дэна Симмонса", 3);
        BookMass book4 = new BookMass("Я?", "Петера Фламма", 4);
        BookMass book5 = new BookMass("Поймать Тень", "Кира Стрельникова", 5);
        MemberMass member1 = new MemberMass("Ivan", "c1");
        MemberMass member2 = new MemberMass("Max", "c2");
        MemberMass member3 = new MemberMass("Anna", "c3");
        MemberMass member4 = new MemberMass("Irina", "c4");
        MemberMass member5 = new MemberMass("Alex", "c5");
        LibraryMass library = new LibraryMass("BookLibrary", "Ivanova 29a");

        LibraryManagementMass libraryManagementMass = new LibraryManagementMass(library);
        libraryManagementMass.addMember(member1);
        libraryManagementMass.addMember(member2);


        for (MemberMass member : library.getMembersList()) {
            if (member!=null) {
                System.out.println(member.toString());
            }
        }

        libraryManagementMass.addBook(book1);
        libraryManagementMass.addBook(book2);
        libraryManagementMass.addBook(book3);
        libraryManagementMass.addBook(book4);
        libraryManagementMass.addBook(book5);

        for (BookMass book : library.getBooksList()) {
            if (book!=null) {
                System.out.println(book.toString());
            }
        }
        System.out.println("Books takes from library: "+libraryManagementMass.howManyBooksTakesFromLibrary());
        libraryManagementMass.memberTakeBookInLibrary(1,"c1");
        System.out.println("Books takes from library: "+libraryManagementMass.howManyBooksTakesFromLibrary());
        System.out.println("Books in library: "+libraryManagementMass.howManyBooksInLibrary());
        libraryManagementMass.memberReturnBookInLibrary(1,"c1");
        for (MemberMass member : library.getMembersList()) {
            if (member!=null) {
                System.out.println(member.toString());
            }
        }

        System.out.println("Books in library: "+libraryManagementMass.howManyBooksInLibrary());
    }
}
