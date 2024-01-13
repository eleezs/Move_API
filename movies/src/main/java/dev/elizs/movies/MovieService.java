package dev.elizs.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired //This instantiates the class MovieRepository
  private MovieRepository movieRepository;

  public Page<Movie> allMovies(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return movieRepository.findAll(pageable);
  }

  public Page<Movie> getMoviesByGenres(List<String> genres, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    String genresString = String.join(",", genres);
    return movieRepository.findByGenresIn(genresString, pageable);
  }

  // get by id
  public Optional<Movie> singleMovie(ObjectId id) {
    return movieRepository.findById(id);
  }

  public Optional<Movie> singleMovieByImdbId(String imdbId) {
    return movieRepository.findMovieByImdbId(imdbId);
  }

}
