package ro.fasttrackit.homework8.hotelrooms.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.CleaningProcedure;
import ro.fasttrackit.homework8.hotelrooms.server.repository.CleaningProcedureRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CleaningProcedureService {
    private final CleaningProcedureRepository repository;

    public List<CleaningProcedure> getRoomCleanups(Long roomId) {
        return repository.findAllByCleanup_RoomId(roomId);
    }
}
