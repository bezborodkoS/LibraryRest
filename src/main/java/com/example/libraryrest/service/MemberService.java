package com.example.libraryrest.service;

import com.example.libraryrest.model.Book;
import com.example.libraryrest.model.Member;
import com.example.libraryrest.repository.BookRepository;
import com.example.libraryrest.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public MemberService(MemberRepository memberRepository, BookRepository bookRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public boolean addMember(Member member) {
        if (memberRepository.findMemberByNameAndLastName(member.getName(), member.getLastName()) != null) {
            return false;
        }
        memberRepository.save(member);
        return true;
    }

    public Member showInformationAboutMember(String name, String lastName) {
        return memberRepository.findMemberByNameAndLastName(name, lastName);
    }

    public Member isMemberInLibrary(String name, String lastName, String addressLibrary) {
        return memberRepository.findMemberByNameAndLastNameAndLibrary_AddressLibrary(name, lastName, addressLibrary);
    }

    public Book returnBookInLibrary(String title,String author){
        Book book=null;
        for (Book bookFor : bookRepository.findBooksByTitleAndAuthor(title, author)) {
            if (bookFor.getIsAvailableInLibrary()) {
                System.out.println("true");
                book=bookFor;
            }
        }
//        System.out.println("check "+book.getBookId());
        return book;
    }

    public boolean memberTakeBook(String name, String lastName, String title, String author) {
        Member member = memberRepository.findMemberByNameAndLastName(name, lastName);
        Book book = returnBookInLibrary(title, author);
//        for (Book bookFor : bookRepository.findBooksByTitleAndAuthor(title, author)) {
//            if (bookFor.isAvailableInLibrary()) {
//                System.out.println("true");
//                book = bookFor;
//            }
//        }
        if (book==null){
            return false;
        }

//        System.out.println(book.getBookId());
//        System.out.println(member.getMemberId() + " id");
//        System.out.println(member.getBooks().toString()+ "ID book "+ book.getBookId());
        System.out.println(book.getBookId());
        book.setIsAvailableInLibrary(false);
        book.setMember(member);
        bookRepository.save(book);
        return true;

    }

    public boolean memberReturnBook(String name, String lastName, String title, String author) {
        Member member = memberRepository.findMemberByNameAndLastName(name, lastName);
        Book book = bookRepository.findBookByTitleAndAuthorAndMember_MemberId(title,author, member.getMemberId());
//        for (Book bookFor : bookRepository.findBooksByTitleAndAuthor(title, author)) {
//            if (bookFor.isAvailableInLibrary()) {
//                System.out.println("true");
//                book = bookFor;
//            }
//        }
        if (book==null){
            return false;
        }

//        System.out.println(book.getBookId());
//        System.out.println(member.getMemberId() + " id");
//        System.out.println(member.getBooks().toString()+ "ID book "+ book.getBookId());
        System.out.println(book.getBookId());
        book.setIsAvailableInLibrary(true);
        book.setMember(null);
        bookRepository.save(book);
        return true;

    }

}
