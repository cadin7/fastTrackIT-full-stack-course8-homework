package ro.fasttrackit.homework8.hotelrooms.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.Review;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findAllByRoomId(String roomId);
}
