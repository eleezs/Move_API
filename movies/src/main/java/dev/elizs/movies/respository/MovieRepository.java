package dev.elizs.movies.respository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.elizs.movies.Movie;


@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
  Optional<Movie> findMovieByImdbId(String imdbId); 
}