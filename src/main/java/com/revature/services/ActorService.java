package com.revature.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.revature.beans.Actor;

public class ActorService {

	Map<Integer, Actor> actors = new HashMap<Integer, Actor>();
	int counter;
	{
		actors.put(1, new Actor(1, "Scarlet Johansson", LocalDate.of(1984, 11, 22), "?"));
		actors.put(2, new Actor(2, "Emilia Clarke", LocalDate.of(1986, 10, 23), "?"));
		actors.put(3, new Actor(3, "Ashton Kutcher", LocalDate.of(1978, 2, 7), "?"));
		counter = 4;
	}

	public Optional<Actor> getActor(int id) {
		return Optional.ofNullable(actors.get(id));
	}

	public void createActor(Actor actor) {
		actor.setId(counter++);
		actors.put(actor.getId(), actor);
	}
}
