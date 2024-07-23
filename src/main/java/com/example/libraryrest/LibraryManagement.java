package com.example.libraryrest;


import com.example.libraryrest.model.Book;
import com.example.libraryrest.model.Library;
import com.example.libraryrest.model.Member;

import java.util.ArrayList;

public class LibraryManagement {
    private Library library;

    public LibraryManagement(Library library) {
        this.library = library;
    }

    public void addBookToLibrary(Book book) {
        if (library.getBooksList() == null) {
            ArrayList<Book> arrayList = new ArrayList<>();
            arrayList.add(book);
            library.setBooksList(arrayList);
        } else {
            library.getBooksList().add(book);
        }
        System.out.println("Book add to library");
    }

    public void addBookToLibrary(ArrayList<Book> books) {
        if (library.getBooksList() == null) {
            ArrayList<Book> arrayList = new ArrayList<>();
            library.setBooksList(arrayList);
        }
        for (Book book : books) {
            library.getBooksList().add(book);
        }
//            library.setBooksList(arrayList);

        System.out.println(books.size() + " book add to library");
    }

    public void addBookToLibrary(Book[] books) {
        ArrayList<Book> arrayList = new ArrayList<>(library.getBooksList());
        for (Book book : books) {
            arrayList.add(book);
        }
        library.setBooksList(arrayList);
        System.out.println(books.length + " book add to library");
    }


    public boolean addMemberToLibrary(Member member) {

        if (library.getMembersList() != null) {
            if (findMemberInLibrary(member)) {
                System.out.println("\n!!!!!!!!!find member in library!!!!!!!!!!!\n");
                return false;
            }
            library.getMembersList().add(member);
        } else {
            ArrayList<Member> arrayList = new ArrayList<>();
            arrayList.add(member);
            library.setMembersList(arrayList);
        }
        System.out.println("New member: " + member.getName() + " add to library");
        return true;
    }

    //    Check Member in library
    private boolean findMemberInLibrary(Member member) {
        if (library.getMembersList().contains(member)) {
            return true;
        }
        return false;
    }

    private int findIndexMemberInLibraryByMemberId(String memberId) {
        for (int i = 0; i < library.getMembersList().size(); i++) {
            if (library.getMembersList().get(i).getMemberId().equals(memberId)) {
                return i;
            }
        }
        return -1;
    }

    private boolean memberCanTakeMax4Book(String memberId) {
        for (int i = 0; i < library.getMembersList().size(); i++) {
            if (library.getMembersList().get(i).getMemberId().equals(memberId)) {
                if (library.getMembersList().get(i).getBookISBNList().size() < 4) {
                    return true;
                } else {
                    System.out.println("!!!!Member cant take more book!!!!!!! He or she take 4 book, return one book or all books");
                    return false;
                }
            }
        }

        return false;
    }

    //    Check Book is available in library
//    private boolean checkBookIsAvailableInLibrary(Books books) {
//        ArrayList<Books> booksArrayList = new ArrayList<>();
//        for (Books bookFromLibrary : library.getBooksList()) {
//            if (bookFromLibrary.getAuthor().equals(books.getAuthor())
//                    && bookFromLibrary.getTitle().equals(books.getTitle())
//                    && !bookFromLibrary.isAvailableInLibrary()) {
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean checkBookIsAvailableInLibrary(int ISBN) {
        for (int i = 0; i < library.getBooksList().size(); i++) {
            if (library.getBooksList().get(i).getISBN() == ISBN && library.getBooksList().get(i).isAvailableInLibrary()) {
                return library.getBooksList().get(i).isAvailableInLibrary();
            }
        }
        System.out.println("All book");
        return false;
    }


    // Take and return book

    private int findIndexBookInLibraryByISBNAndIsAvailableFalse(int ISBN) {
        for (int i = 0; i < library.getBooksList().size(); i++) {
            if (library.getBooksList().get(i).getISBN() == ISBN && !library.getBooksList().get(i).isAvailableInLibrary()) {
                return i;
            }
        }
        return -1;
    }

    private int findIndexBookInLibraryByISBNAndIsAvailable(int ISBN) {
        for (int i = 0; i < library.getBooksList().size(); i++) {
            if (library.getBooksList().get(i).getISBN() == ISBN && library.getBooksList().get(i).isAvailableInLibrary()) {
                return i;
            }
        }
        return -1;
    }

    //    Member take book in Library
    public boolean memberTakeBookInLibrary(String memberId, int ISBN) {
        if (findIndexMemberInLibraryByMemberId(memberId) == -1 && findIndexBookInLibraryByISBNAndIsAvailable(ISBN) == -1) {
            System.out.println("ERROR!!!!!! Check memberId or ISBN");
            return false;
        }
        int indexMember = findIndexMemberInLibraryByMemberId(memberId);
        int indexBook = findIndexBookInLibraryByISBNAndIsAvailable(ISBN);
        Member findMember = library.getMembersList().get(findIndexMemberInLibraryByMemberId(memberId));
        Book findBook = library.getBooksList().get(findIndexBookInLibraryByISBNAndIsAvailable(ISBN));
        if (memberCanTakeMax4Book(memberId) && checkBookIsAvailableInLibrary(ISBN)) {
            findMember.getBookISBNList().add(ISBN);
            findBook.setAvailableInLibrary(false);
            library.getBooksList().set(indexBook, findBook);
            library.getMembersList().set(indexMember, findMember);
            System.out.println(findMember.getName() + " take " + findBook.getTitle() + " author " + findBook.getAuthor());
            return true;
        }

        return false;
    }

    public boolean memberReturnBookInLibrary(String memberId, int ISBN) {
        System.out.println("REtuuuuuuurn");
        if (findIndexMemberInLibraryByMemberId(memberId) == -1 && findIndexBookInLibraryByISBNAndIsAvailable(ISBN) == -1) {
            System.out.println("ERROR!!!!!! Check memberId or ISBN");
            return false;
        }
        int indexISBNBookinMemberListBooks = 0;

        int indexMember = findIndexMemberInLibraryByMemberId(memberId);
        int indexBook = findIndexBookInLibraryByISBNAndIsAvailableFalse(ISBN);
        Member findMember = library.getMembersList().get(findIndexMemberInLibraryByMemberId(memberId));
        Book findBook = library.getBooksList().get(findIndexBookInLibraryByISBNAndIsAvailableFalse(ISBN));
        for (int i = 0; i < findMember.getBookISBNList().size(); i++) {
            if (findMember.getBookISBNList().get(i).equals(ISBN)) {
                indexISBNBookinMemberListBooks = i;
            }
        }
        findMember.getBookISBNList().remove(indexISBNBookinMemberListBooks);
//            findMember.getBookISBNList().add(ISBN);
        findBook.setAvailableInLibrary(true);
        library.getBooksList().set(indexBook, findBook);
        library.getMembersList().set(indexMember, findMember);
        System.out.println(findMember.getName() + " return " + findBook.getTitle() + " author " + findBook.getAuthor());
        return true;


    }

}
