package ro.fasttrackit.homework8.hotelrooms.server.controller;

import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homework8.hotelrooms.server.exception.ResourceNotFoundException;
import ro.fasttrackit.homework8.hotelrooms.server.model.RoomFilters;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.CleaningProcedure;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.Review;
import ro.fasttrackit.homework8.hotelrooms.server.model.entity.Room;
import ro.fasttrackit.homework8.hotelrooms.server.service.CleaningProcedureService;
import ro.fasttrackit.homework8.hotelrooms.server.service.ReviewService;
import ro.fasttrackit.homework8.hotelrooms.server.service.RoomService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rooms")
public class RoomController {
    private final RoomService service;
    private final ReviewService reviewService;
    private final CleaningProcedureService cleaningProcedureService;

    @GetMapping
    List<Room> getAll(RoomFilters filters) {
        return service.getAll(filters);
    }

    @GetMapping("{roomId}")
    Room getRoom(@PathVariable String roomId) {
        return service.getRoom(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find room with ID: " + roomId));
    }

    @GetMapping("{roomId}/cleanups")
    List<CleaningProcedure> getRoomCleanups(@PathVariable String roomId) {
        return cleaningProcedureService.getRoomCleanups(roomId);
    }

    @GetMapping("{roomId}/reviews")
    List<Review> getRoomReviews(@PathVariable String roomId) {
        return reviewService.getRoomReviews(roomId);
    }

    @PatchMapping("{roomId}")
    Room patchRoom(@RequestBody JsonPatch patch, @PathVariable String roomId) {
        return service.patchRoom(roomId, patch);
    }

    @DeleteMapping("{roomId}")
    Room deleteRoom(@PathVariable String roomId) {
        return service.deleteRoom(roomId);
    }
}
