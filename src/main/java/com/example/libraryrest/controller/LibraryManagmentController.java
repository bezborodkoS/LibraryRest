package com.example.libraryrest.controller;

import com.example.libraryrest.model.Book;
import com.example.libraryrest.model.Library;
import com.example.libraryrest.model.Member;
import com.example.libraryrest.service.BookService;
import com.example.libraryrest.service.LibrarySevice;
import com.example.libraryrest.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryManagmentController {
    private final BookService bookService;
    private final MemberService memberService;
    private final LibrarySevice librarySevice;

    public LibraryManagmentController(BookService bookService, MemberService memberService, LibrarySevice librarySevice) {
        this.bookService = bookService;
        this.memberService = memberService;
        this.librarySevice = librarySevice;
    }

    @GetMapping("/library")
    public ResponseEntity<List<Library>>getLibrary(){
        return new ResponseEntity(librarySevice.allLibrary(),HttpStatus.OK);
    }

    @PostMapping("/addMember/{addressLibrary}")
    public ResponseEntity<String>addMember(@RequestBody Member member,@PathVariable("addressLibrary") String addressLibrary){
        System.out.println(member.getName());
        System.out.println(member.getLastName());
        if (!librarySevice.isLibraryInBD(addressLibrary)||addressLibrary==null){
            return new ResponseEntity<>("Cant found library with this address: "+addressLibrary,HttpStatus.NOT_FOUND);
        }
        if (memberService.isMemberInLibrary(member.getName(), member.getLastName(), addressLibrary)!=null){
            return new ResponseEntity<>("Member found in this library ",HttpStatus.FOUND);
        }
        member.setLibrary(librarySevice.foundLibrary(addressLibrary));
        memberService.addMember(member);
        return new ResponseEntity<>("Add new : "+ member.toString(),HttpStatus.CREATED);
    }

    @PostMapping("/addLibrary")
    public ResponseEntity<String>addLibrary(@RequestBody Library library){
        if (librarySevice.isLibraryInBD(library.getAddressLibrary())){
            return new ResponseEntity<>("Found "+library.toString(),HttpStatus.FOUND);
        }
        librarySevice.addLibrary(library);
        return new ResponseEntity<>(library.toString(),HttpStatus.CREATED);
    }

    @PostMapping("/addBook/{addressLibrary}")
    public ResponseEntity<String>addBook(@RequestBody Book book,@PathVariable("addressLibrary")String addressLibrary){
        if (!librarySevice.isLibraryInBD(addressLibrary)||addressLibrary==null){
            return new ResponseEntity<>("Cant found library with this address: "+addressLibrary,HttpStatus.NOT_FOUND);
        }
        book.setLibrary(librarySevice.foundLibrary(addressLibrary));
        bookService.addBook(book);
        return new ResponseEntity<>("Add "+book.toString()+" to Library",HttpStatus.CREATED);
    }

    @PutMapping("/takeBook")
    public ResponseEntity<String>takeBook(@RequestParam("nameMember")String nameMember,
                                          @RequestParam("lastNameMember")String lastNameMember,
                                          @RequestParam("titleBook")String titleBook,
                                          @RequestParam("authorBook")String authorBook){
        if (!memberService.memberTakeBook(nameMember,lastNameMember,titleBook,authorBook)){
            return new ResponseEntity<>(" no ",HttpStatus.BAD_REQUEST);
        }
        memberService.memberTakeBook(nameMember,lastNameMember,titleBook,authorBook);
        return new ResponseEntity<>(nameMember+" "+ lastNameMember+" take" +titleBook,HttpStatus.OK);
    }

    @PutMapping("/returnBook")
    public ResponseEntity<String>returnBook(@RequestParam("nameMember")String nameMember,
                                          @RequestParam("lastNameMember")String lastNameMember,
                                          @RequestParam("titleBook")String titleBook,
                                          @RequestParam("authorBook")String authorBook){
        if (!memberService.memberReturnBook(nameMember,lastNameMember,titleBook,authorBook)){
            return new ResponseEntity<>(" no ",HttpStatus.BAD_REQUEST);
        }
        memberService.memberReturnBook(nameMember,lastNameMember,titleBook,authorBook);
        return new ResponseEntity<>(nameMember+" "+ lastNameMember+" return " +titleBook,HttpStatus.OK);
    }
}
