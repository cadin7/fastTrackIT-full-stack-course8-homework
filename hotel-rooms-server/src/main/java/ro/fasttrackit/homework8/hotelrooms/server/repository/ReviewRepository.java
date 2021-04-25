package ro.fasttrackit.homework8.hotelrooms.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByRoomId(Long roomId);
}
