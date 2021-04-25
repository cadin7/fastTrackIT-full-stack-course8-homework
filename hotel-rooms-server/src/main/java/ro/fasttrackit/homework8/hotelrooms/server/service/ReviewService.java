package ro.fasttrackit.homework8.hotelrooms.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.Review;
import ro.fasttrackit.homework8.hotelrooms.server.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repository;

    public List<Review> getRoomReviews(Long roomId) {
        return repository.findAllByRoomId(roomId);
    }
}
