package com.example.sakiladb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "actor")
public class PartialActor {
    @Id
    @Column(name = "actor_id")
    private short id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
