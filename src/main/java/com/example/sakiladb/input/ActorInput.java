package com.example.sakiladb.input;

import com.example.sakiladb.entities.PartialFilm;
import lombok.Data;

import java.util.List;

@Data
public class ActorInput {
    private String firstName;
    private String lastName;
    private List<PartialFilm> film;
}
