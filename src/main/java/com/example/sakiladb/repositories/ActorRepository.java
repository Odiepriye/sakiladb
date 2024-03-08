package com.example.sakiladb.repositories;

import com.example.sakiladb.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Short> {
//    Actor findById(Short id);
    List<Actor> findByLastNameIgnoreCase(String lastName);
    List<Actor> findByFullNameIgnoreCase(String fullName);
    Optional<Actor> deleteFirstByFullNameIgnoreCase(String fullName);
}
