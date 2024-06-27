package dev.elizs.movies.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.elizs.movies.Movie;
import dev.elizs.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
  
  // call the service in the controller
  @Autowired
  private MovieService movieService;

  @CrossOrigin(origins = "*")
  @GetMapping("")
  public ResponseEntity<List<Movie>> getAllMovies() {
    return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
  }

  @CrossOrigin(origins = "*")
  @GetMapping("/{id}")
  public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id) {
    return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
  }

  @CrossOrigin(origins = "*")
  @GetMapping("/imdb/{imdbId}")
  public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String imdbId) {
    return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(imdbId), HttpStatus.OK);
  }
}
