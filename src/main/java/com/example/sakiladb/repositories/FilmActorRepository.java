package com.example.sakiladb.repositories;

import com.example.sakiladb.entities.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmActorRepository extends JpaRepository<FilmActor, Short> {
}
