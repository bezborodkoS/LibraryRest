package com.example.libraryrest.repository;

import com.example.libraryrest.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
Member findMemberByNameAndLastName(String name,String lastName);
List<Member> findMembersByLastName(String lastName);

Member findMemberByNameAndLastNameAndLibrary_AddressLibrary(String name,String lastName,String addressLibrary);

}
