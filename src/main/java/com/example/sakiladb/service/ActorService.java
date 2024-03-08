package com.example.sakiladb.service;
import com.example.sakiladb.entities.Actor;
import com.example.sakiladb.entities.PartialActor;
import com.example.sakiladb.input.ActorInput;
import com.example.sakiladb.repositories.ActorRepository;
import com.example.sakiladb.repositories.PartialActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private PartialActorRepository partialActorRepository;
    public List<Actor> getActors() {
        return actorRepository.findAll();
    }
    public Actor getActor(Short id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        return optionalActor.orElse(null);
    }
    public List<Actor> getActorsByLastName(String lastName) {
        return actorRepository.findByLastNameIgnoreCase(lastName);
    }
    public List<Actor> getActorsByFullName(String fullName) {
        return actorRepository.findByFullNameIgnoreCase(fullName);
    }
    public Actor createActor(ActorInput data) {
        final var actor = new Actor();
        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());
        actor.setFilms(data.getFilm());
        return actorRepository.save(actor);
    }
    public PartialActor removeActor(Short id) {
        Optional<Actor> actor = actorRepository.findById(id);
            PartialActor partialActor = new PartialActor();
            partialActor.setId(actor.orElse(null).getId());
            partialActor.setFirstName(actor.orElse(null).getFirstName());
            partialActor.setLastName(actor.orElse(null).getLastName());
            actorRepository.deleteById(id);
            return partialActor;
    }
    public ResponseEntity<Optional> removeActorByName(String fullName) {
        List<Actor> actor = actorRepository.findByLastNameIgnoreCase(fullName);
        if(actor.size() != 1){
            return ResponseEntity.ok(actorRepository.deleteFirstByFullNameIgnoreCase(fullName));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    public Actor updateActor(Short id, ActorInput data) {
    Optional<Actor> optionalActor = actorRepository.findById(id);
    Actor actor = optionalActor.orElse(null);
    actor.setFirstName(data.getFirstName());
    actor.setLastName(data.getLastName());
    actor.setFilms(data.getFilm());
    return actorRepository.save(actor);
    }
    public Actor updateActorByName(String fullName, ActorInput data) {
        List<Actor> actor= actorRepository.findByFullNameIgnoreCase(fullName);
        //if(actor.size() == 1){}else{}//do something
        actor.getFirst().setFirstName(data.getFirstName());
        actor.getFirst().setLastName(data.getLastName());
        actor.getFirst().setFilms(data.getFilm());
        return actorRepository.save(actor.getFirst());
    }
}