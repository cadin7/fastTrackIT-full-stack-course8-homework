package ro.fasttrackit.homework8.hotelrooms.server.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.homework8.hotelrooms.server.repository.CleaningProcedureRepository;
import ro.fasttrackit.homework8.hotelrooms.server.repository.ReviewRepository;
import ro.fasttrackit.homework8.hotelrooms.server.repository.RoomRepository;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RoomRepository roomRepository;
    private final ReviewRepository reviewRepository;
    private final CleaningProcedureRepository cleaningProcedureRepository;

    @Override
    public void run(String... args) throws Exception {
//        final var rooms = getRooms();
//        roomRepository.saveAll(rooms);

//        final var cleanups = getCleanups(rooms);
//        cleaningProcedureRepository.saveAll(cleanups);

//        final var reviews = getReviews(rooms);
//        reviewRepository.saveAll(reviews);
    }


}
