package com.example.libraryrest.repository;

import com.example.libraryrest.model.Library;
import com.example.libraryrest.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Integer> {
    Library findLibraryByAddressLibrary(String addresLibrary);
    List<Library> findAll();
}
