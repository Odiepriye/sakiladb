package com.example.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "film")
public class PartialFilm {
    @Id
    @Column(name = "film_id")
    private short id;
    @Column(name = "title")
    private String title;
}
