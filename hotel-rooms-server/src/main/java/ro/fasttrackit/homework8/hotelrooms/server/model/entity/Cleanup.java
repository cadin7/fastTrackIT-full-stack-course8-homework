package ro.fasttrackit.homework8.hotelrooms.server.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Cleanup {
    @Id
    private String id;

    private LocalDate date;

    private String roomId;
}
