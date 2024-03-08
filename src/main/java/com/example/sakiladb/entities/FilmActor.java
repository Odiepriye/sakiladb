package com.example.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "film_actor")
public class FilmActor {
    @Id
    @Column(name = "film_id")
    private short filmId;
    @Column(name = "actor_id")
    private short actorId;

}
