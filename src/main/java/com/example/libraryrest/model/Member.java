package com.example.libraryrest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer memberId;
    private String name;
    private String lastName;
    @OneToMany(mappedBy = "member")
    private List<Book> books;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", library=" + library.getNameLibrary() +
                '}';
    }
}
