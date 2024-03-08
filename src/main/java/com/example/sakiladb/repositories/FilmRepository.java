package com.example.sakiladb.repositories;

import com.example.sakiladb.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Short> {
}
