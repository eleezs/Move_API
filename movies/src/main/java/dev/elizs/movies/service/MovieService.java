package dev.elizs.movies.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.elizs.movies.Movie;
import dev.elizs.movies.respository.MovieRepository;
  
@Service
public class MovieService {

  @Autowired //This instantiates the class Movie Repository
  private MovieRepository movieRepository;

  public List<Movie> allMovies() {
    return movieRepository.findAll();
  }

  // get by id
  public Optional<Movie> singleMovie(ObjectId id) {
    return movieRepository.findById(id);
  }

  public Optional<Movie> singleMovieByImdbId(String imdbId) {
    return movieRepository.findMovieByImdbId(imdbId);
  }

}
