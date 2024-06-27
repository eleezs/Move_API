package dev.elizs.movies.respository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.elizs.movies.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {  
}
