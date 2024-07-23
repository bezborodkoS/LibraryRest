package com.example.libraryrest;



import com.example.libraryrest.model.Book;
import com.example.libraryrest.model.Library;
import com.example.libraryrest.model.Member;

import java.util.ArrayList;

public class Starter {
    public static void main(String[] args) {
        Book book1 = new Book("Железное пламя", "Ребекка Яррос", 1);
        Book book2 = new Book("Слишком поздно", "Колин Гувер", 2);
        Book book3 = new Book("Черные холмы", "Дэна Симмонса", 3);
        Book book4 = new Book("Я?", "Петера Фламма", 4);
        Book book5 = new Book("Поймать Тень", "Кира Стрельникова", 5);
        Member member1 = new Member("Ivan", "c1");
        Member member2 = new Member("Max", "c2");
        Member member3 = new Member("Anna", "c3");
        Member member4 = new Member("Irina", "c4");
        Member member5 = new Member("Alex", "c5");
        Library library = new Library("BookLibrary", "Ivanova 29a");

        LibraryManagement libraryManagement = new LibraryManagement(library);
        libraryManagement.addMemberToLibrary(member1);
        libraryManagement.addMemberToLibrary(member2);
        libraryManagement.addMemberToLibrary(member3);
//        Add Member who registrated in Library
        libraryManagement.addMemberToLibrary(member1);

        libraryManagement.addBookToLibrary(book1);
        libraryManagement.addBookToLibrary(book2);
        libraryManagement.addBookToLibrary(book3);
        libraryManagement.addBookToLibrary(book4);
        libraryManagement.addBookToLibrary(book5);

//        add books in library by List
        ArrayList<Book> arrayList = new ArrayList<>();
        arrayList.add(book1);
        arrayList.add(book2);
        libraryManagement.addBookToLibrary(arrayList);

        System.out.println("Show all Members");
        for (Member member : library.getMembersList()) {
            System.out.println(member.toString());
        }

        System.out.println("Show all Books");
        for (Book book : library.getBooksList()) {
            System.out.println(book.toString());
        }

        libraryManagement.memberTakeBookInLibrary("c1", 1);
        libraryManagement.memberTakeBookInLibrary("c1", 2);
        libraryManagement.memberTakeBookInLibrary("c1", 3);
        libraryManagement.memberTakeBookInLibrary("c1", 4);
        libraryManagement.memberTakeBookInLibrary("c1", 5);
        libraryManagement.memberTakeBookInLibrary("c2", 5);
        System.out.println("Show all Members");
        for (Member member : library.getMembersList()) {
            System.out.println(member.toString());
        }

        libraryManagement.memberReturnBookInLibrary("c1", 4);

        System.out.println("Show all Members");
        for (Member member : library.getMembersList()) {
            System.out.println(member.toString());
        }
    }


}