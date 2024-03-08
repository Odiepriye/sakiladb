package com.example.sakiladb.controllers;

import com.example.sakiladb.entities.Actor;
import com.example.sakiladb.entities.PartialActor;
import com.example.sakiladb.input.ActorInput;
import com.example.sakiladb.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    public Controller(ActorService actorService) {
        this.actorService = actorService;
    }
    @Autowired
    private ActorService actorService;
    @GetMapping("/actors")
    public List<Actor> getActors() {
        return actorService.getActors();
    }
    @GetMapping("/actors/{id}")
    public Actor getActor(@PathVariable Short id) {
        return actorService.getActor(id);
    }
    @GetMapping("/actors/lastName/{lastName}")
    public List<Actor> getActorByLastName(@PathVariable String lastName) {
        return actorService.getActorsByLastName(lastName);
    }
    @GetMapping("/actors/fullName/{fullName}")
    public List<Actor> getActorByFullName(@PathVariable String fullName) {
        return actorService.getActorsByFullName(fullName);
    }
    @PostMapping("/actors")
    public Actor createActor(@Validated @RequestBody ActorInput data) {
        return actorService.createActor(data);
    }
    @DeleteMapping("/actors/{id}")
    public PartialActor removeActor(@PathVariable Short id) {
        return actorService.removeActor(id);
    }
    @DeleteMapping("/actors/remove/{fullName}")
    public ResponseEntity<Optional> removeActorByName(@PathVariable String fullName) {
        return actorService.removeActorByName(fullName);
    }
    @PatchMapping("/actors/{id}")
    public Actor updateActor(@PathVariable Short id, @RequestBody ActorInput data) {
        return actorService.updateActor(id, data);
    }
}