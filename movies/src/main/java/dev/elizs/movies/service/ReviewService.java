package dev.elizs.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.elizs.movies.Movie;
import dev.elizs.movies.Review;
import dev.elizs.movies.respository.ReviewRepository;

@Service
public class ReviewService {
  
  @Autowired
  private ReviewRepository reviewRepository;

  // create template: This is another way to communicate with the db. here you can write the query the way you want it to work
  @Autowired
  private MongoTemplate mongoTemplate;

  public Review createReview(String reviewBody, String imdbId) {

    // create a new review and save
    Review review = reviewRepository.insert(new Review(reviewBody));

    //associate it to one of the movie
    mongoTemplate.update(Movie.class)
      .matching(Criteria.where("imdbId").is(imdbId))
      .apply(new Update().push("reviews").value(review))
      .first(); 

      return review;
  }
}
