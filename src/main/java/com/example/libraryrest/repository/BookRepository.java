package com.example.libraryrest.repository;

import com.example.libraryrest.model.Book;
import com.example.libraryrest.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findBooksByTitleAndAuthor(String title,String author);
//    List<Book> findBooksByTitleAndAuthorAndAvailableInLibrary(String title,String author,boolean isAvailableInLibrary);
//    Book findBookByTitleAndAuthorAndAvailableInLibrary(String title,String author,boolean isAvailableInLibrary);
//    Book findBookByTitleAndAuthorAndAvailableInLibraryTrue(String title,String author);
    List<Book> findBookByTitleAndAuthorAndIsAvailableInLibraryIsTrue(String title,String author);
    Book findBookByTitleAndAuthorAndMember_MemberId(String title,String author,Integer memberId);
}
