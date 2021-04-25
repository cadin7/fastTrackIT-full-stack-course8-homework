package ro.fasttrackit.homework8.hotelrooms.server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework8.hotelrooms.server.exception.ResourceNotFoundException;
import ro.fasttrackit.homework8.hotelrooms.server.model.RoomFilters;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.Room;
import ro.fasttrackit.homework8.hotelrooms.server.repository.RoomRepository;
import ro.fasttrackit.homework8.hotelrooms.server.repository.dao.RoomDao;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomDao dao;
    private final RoomRepository repository;
    private final ObjectMapper mapper;

    public List<Room> getAll(RoomFilters filters) {
        return dao.getAll(filters);
    }

    public Optional<Room> getRoom(Long roomId) {
        return repository.findById(roomId);
    }

    public Room deleteRoom(Long roomId) {
        var roomToDelete = getOrThrow(roomId);
        repository.deleteById(roomId);

        return roomToDelete;
    }

    private Room getOrThrow(Long roomId) {
        return repository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find room with ID: " + roomId));
    }

    @SneakyThrows
    public Room patchRoom(Long roomId, JsonPatch patch) {
        Room roomToPatch = getOrThrow(roomId);
        JsonNode patchedRoomJson = patch.apply(mapper.valueToTree(roomToPatch));
        Room patchedRoom = mapper.treeToValue(patchedRoomJson, Room.class);
        return replaceRoom(roomId, patchedRoom);
    }

    private Room replaceRoom(Long roomId, Room newRoom) {
        newRoom.setId(roomId);
        Room roomToUpdate = getOrThrow(roomId);
        copyRoom(newRoom, roomToUpdate);
        return repository.save(roomToUpdate);
    }

    private void copyRoom(Room newRoom, Room dbRoom) {
        dbRoom.setRoomFacilities(newRoom.getRoomFacilities());
        dbRoom.setFloor(newRoom.getFloor());
        dbRoom.setHotelName(newRoom.getHotelName());
        dbRoom.setNumber(newRoom.getNumber());
    }
}
