package com.example.sakiladb;

import com.example.sakiladb.controllers.Controller;
import com.example.sakiladb.entities.Actor;
import com.example.sakiladb.service.ActorService;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ActorControllerStepDef {
    private ActorService actorService;
    private final short expectedId = 1;
    private final Actor actor = new Actor();
    private Actor actualActor;
    @Before
    public void setUp(){
        actorService = mock(ActorService.class);
        actor.setId(expectedId);
        actor.setFirstName("John");
        actor.setLastName("Doe");
        actor.setFilms(new ArrayList<>());
    }
    @Given("the actor with id {short} exists")
    public void givenActorOneExists(Short id){
        doReturn(actor).when(actorService).getActor(id);
    }
    @When("get request is made for actor {short}")
    public void whenRequestWithId(Short id){
        final Controller actorController = new Controller(actorService);
        try{
            actualActor = actorController.getActor(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(actorController.getActor(id).getId());
        System.out.println(actualActor.getFirstName());
    }
    @Then("an actor is returned")
    public void thenActorIsReturned(){
        assertNotNull(actualActor);
        assertEquals("John", actualActor.getFirstName());
        assertEquals("Doe", actualActor.getLastName());
    }
}
