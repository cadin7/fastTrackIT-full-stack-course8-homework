package ro.fasttrackit.homework8.hotelrooms.server.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.*;
import ro.fasttrackit.homework8.hotelrooms.server.repository.CleaningProcedureRepository;
import ro.fasttrackit.homework8.hotelrooms.server.repository.ReviewRepository;
import ro.fasttrackit.homework8.hotelrooms.server.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RoomRepository roomRepository;
    private final ReviewRepository reviewRepository;
    private final CleaningProcedureRepository cleaningProcedureRepository;

    @Override
    public void run(String... args) throws Exception {
        final var rooms = getRooms();
        roomRepository.saveAll(rooms);

        final var cleanups = getCleanups(rooms);
        cleaningProcedureRepository.saveAll(cleanups);

        final var reviews = getReviews(rooms);
        reviewRepository.saveAll(reviews);
    }

    private List<Review> getReviews(List<Room> rooms) {
        return List.of(
                Review.builder()
                        .rating(5)
                        .message("Coolest")
                        .touristName("Zsombor")
                        .room(rooms.get(0))
                .build(),
                Review.builder()
                        .rating(5)
                        .message("Lux")
                        .touristName("Dezso")
                        .room(rooms.get(0))
                        .build()
        );
    }

    private List<CleaningProcedure> getCleanups(List<Room> rooms) {
        return List.of(
                CleaningProcedure.builder()
                        .name("Procedure1")
                        .outcome(19)
                        .cleanup(Cleanup.builder()
                                .date(LocalDate.now())
                                .room(rooms.get(0))
                                .build())
                        .build(),
                CleaningProcedure.builder()
                        .name("Procedure2")
                        .outcome(23)
                        .cleanup(Cleanup.builder()
                                .date(LocalDate.now().minusDays(1))
                                .room(rooms.get(0))
                                .build())
                        .build(),
                CleaningProcedure.builder()
                        .name("Procedure3")
                        .outcome(120)
                        .cleanup(Cleanup.builder()
                                .date(LocalDate.now().minusDays(2))
                                .room(rooms.get(0))
                                .build())
                        .build()
        );
    }

    private List<Room> getRooms() {
        return List.of(
                Room.builder()
                        .number("10")
                        .floor(1)
                        .hotelName("HungarianSpaceHotel")
                        .roomFacilities(RoomFacilities.builder()
                                .tv(true)
                                .doubleBed(true)
                                .build())
                        .build(),
                Room.builder()
                        .number("11")
                        .floor(1)
                        .hotelName("HungarianSpaceHotel")
                        .roomFacilities(RoomFacilities.builder()
                                .tv(true)
                                .doubleBed(false)
                                .build())
                        .build(),
                Room.builder()
                        .number("12")
                        .floor(1)
                        .hotelName("HungarianSpaceHotel")
                        .roomFacilities(RoomFacilities.builder()
                                .tv(false)
                                .doubleBed(true)
                                .build())
                        .build(),
                Room.builder()
                        .number("20")
                        .floor(2)
                        .hotelName("HungarianSpaceHotel")
                        .roomFacilities(RoomFacilities.builder()
                                .tv(true)
                                .doubleBed(true)
                                .build())
                        .build(),
                Room.builder()
                        .number("21")
                        .floor(2)
                        .hotelName("HungarianSpaceHotel")
                        .roomFacilities(RoomFacilities.builder()
                                .tv(true)
                                .doubleBed(false)
                                .build())
                        .build(),
                Room.builder()
                        .number("30")
                        .floor(3)
                        .hotelName("HungarianSpaceHotel")
                        .roomFacilities(RoomFacilities.builder()
                                .tv(true)
                                .doubleBed(true)
                                .build())
                        .build()
        );
    }
}
