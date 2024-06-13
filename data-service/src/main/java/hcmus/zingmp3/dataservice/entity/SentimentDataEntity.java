package hcmus.zingmp3.dataservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "sentiment_data")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SentimentDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String review;
    private String sentiment;
    private String language;

}
