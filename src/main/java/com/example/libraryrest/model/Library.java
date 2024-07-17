package com.example.libraryrest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Table(name = "library")
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer libraryId;

    private String nameLibrary;
    private String addressLibrary;

    @OneToMany(mappedBy = "library")
    private Set<Member> members;

    @OneToMany(mappedBy = "library")
    private List<Book> books;

    @Override
    public String toString() {
        return "Library{" +
                "nameLibrary='" + nameLibrary + '\'' +
                ", addressLibrary='" + addressLibrary + '\'' +
                '}';
    }
}
