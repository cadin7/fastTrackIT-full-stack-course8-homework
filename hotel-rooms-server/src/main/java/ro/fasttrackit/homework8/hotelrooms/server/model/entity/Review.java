package ro.fasttrackit.homework8.hotelrooms.server.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private String id;

    private String message;
    private int rating;
    private String touristName;

    private String roomId;
}
