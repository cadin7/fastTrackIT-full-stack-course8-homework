package ro.fasttrackit.homework8.hotelrooms.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
