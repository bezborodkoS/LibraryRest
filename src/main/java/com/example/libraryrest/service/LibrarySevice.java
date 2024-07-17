package com.example.libraryrest.service;

import com.example.libraryrest.model.Library;
import com.example.libraryrest.model.Member;
import com.example.libraryrest.repository.LibraryRepository;
import com.example.libraryrest.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarySevice {
    private final LibraryRepository libraryRepository;

    public LibrarySevice(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public boolean isLibraryInBD(String addressLibrary){
        if (libraryRepository.findLibraryByAddressLibrary(addressLibrary)==null){
            return false;
        }
        return true;
    }

    public boolean addLibrary(Library library) {
        if (isLibraryInBD(library.getAddressLibrary())) {
            return false;
        }
        libraryRepository.save(library);
        return true;
    }

    public Library foundLibrary(String addressLibrary){
        return libraryRepository.findLibraryByAddressLibrary(addressLibrary);
    }

    public List<Library> allLibrary(){
        return libraryRepository.findAll();
    }
}
