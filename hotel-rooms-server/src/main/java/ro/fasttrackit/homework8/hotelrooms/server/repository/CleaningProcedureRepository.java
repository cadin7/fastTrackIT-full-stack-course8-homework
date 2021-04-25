package ro.fasttrackit.homework8.hotelrooms.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.CleaningProcedure;

import java.util.List;

public interface CleaningProcedureRepository extends JpaRepository<CleaningProcedure, Long> {
    List<CleaningProcedure> findAllByCleanup_RoomId(Long roomId);
}
