package ro.fasttrackit.homework8.hotelrooms.server.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.PERSIST;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    private String number;
    private int floor;
    private String hotelName;

    @OneToOne(cascade = PERSIST)
    private RoomFacilities roomFacilities;
}
