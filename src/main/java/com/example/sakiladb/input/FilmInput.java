package com.example.sakiladb.input;

import com.example.sakiladb.entities.PartialActor;
import lombok.Data;

import java.util.List;

@Data
public class FilmInput {
    private String title;
    private byte lId;
    private List<PartialActor> actor;
}
