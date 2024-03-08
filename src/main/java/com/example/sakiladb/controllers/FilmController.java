package com.example.sakiladb.controllers;

import com.example.sakiladb.entities.Actor;
import com.example.sakiladb.entities.Film;
import com.example.sakiladb.input.ActorInput;
import com.example.sakiladb.input.FilmInput;
import com.example.sakiladb.repositories.FilmActorRepository;
import com.example.sakiladb.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    FilmRepository filmActorRepository;
    @GetMapping("/film")
    public List<Film> getFilms(){
        return filmRepository.findAll();
    }
    @GetMapping("/film/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable Short id){
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/film")
    public Film postFilm(@Validated @RequestBody  FilmInput data){
        final var film = new Film();
        film.setTitle(data.getTitle());
        film.setLId(data.getLId());
        film.setActor(data.getActor());
        return filmRepository.save(film);
    }
    @DeleteMapping("/film/{id}")
    public ResponseEntity<Film> removeFilm(@PathVariable Short id){
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
//            filmActorRepository.deleteByFId(id);
            filmRepository.deleteById(id);

            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/film/{id}")
    public ResponseEntity<Void> updateFilm(@PathVariable Short id, @RequestBody FilmInput data) {
        Film film = filmRepository.findById(id).orElse(null);
        if (film != null) {
            if (data.getTitle() != null) {
                film.setTitle(data.getTitle());
            }
            if (data.getLId() != 0) {
                film.setLId(data.getLId());
            }
            if (data.getActor() != null) {
                film.setActor(data.getActor());
            }
            filmRepository.save(film);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
