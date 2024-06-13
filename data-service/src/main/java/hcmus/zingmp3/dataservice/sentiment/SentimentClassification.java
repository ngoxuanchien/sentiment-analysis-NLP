package hcmus.zingmp3.dataservice.sentiment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SentimentClassification {
    private double veryPositive;
    private double positive;
    private double neutral;
    private double negative;
    private double veryNegative;
}
