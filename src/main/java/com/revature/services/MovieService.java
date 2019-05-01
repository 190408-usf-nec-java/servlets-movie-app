package com.revature.services;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.revature.beans.Movie;

public class MovieService {

	Map<Integer, Movie> movies = new HashMap<Integer, Movie>();
	int counter;
	{
		movies.put(1, 
				new Movie(1, "Avengers: Endgame",
				Duration.ofMinutes(181), "Action"));
		movies.put(2, new Movie(2, "Blade Runner 2049",
				Duration.ofMinutes(164), "Sci-Fi"));
		movies.put(3, new Movie(3, "Detective Pikachu",
				Duration.ofMinutes(90), "'kids'"));
		counter = 4;
	}
	
	
	public Optional<Movie> getMovie(int id) {
		return Optional.ofNullable(movies.get(id));
	}


	public void createMovie(Movie movie) {
		movie.setId(counter++);
		movies.put(movie.getId(), movie);
	}
}
