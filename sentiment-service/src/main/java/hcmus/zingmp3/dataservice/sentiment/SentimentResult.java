package hcmus.zingmp3.dataservice.sentiment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SentimentResult {
    private double sentimentScore;
    private String sentimentType;
    private SentimentClassification sentimentClass;
}
