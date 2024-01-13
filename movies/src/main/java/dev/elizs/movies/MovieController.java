package dev.elizs.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {
  
  // call the service in the controller
  @Autowired
  private MovieService movieService;

  // @CrossOrigin(origins = "*")
  @GetMapping
  public ResponseEntity<Page<Movie>> getAllMovies(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(required = false) List<String> genres) {
    if(genres != null && !genres.isEmpty()) {
      return new ResponseEntity<Page<Movie>>(movieService.getMoviesByGenres(genres, page, size), HttpStatus.OK);
    } else {
      return new ResponseEntity<Page<Movie>>(movieService.allMovies(page, size), HttpStatus.OK);
    }
  }

  // @CrossOrigin(origins = "*")
  @GetMapping("/{id}")
  public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id) {
    return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
  }

  //  @CrossOrigin(origins = "*")
  @GetMapping("/imdb/{imdbId}")
  public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String imdbId) {
    return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(imdbId), HttpStatus.OK);
  }
}
