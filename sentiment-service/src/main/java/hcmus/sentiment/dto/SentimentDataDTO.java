package hcmus.sentiment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SentimentDataDTO {
    private String id;
    private String review;
    private String sentiment;
    private String language;
}
