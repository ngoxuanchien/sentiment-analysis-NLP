package hcmus.sentiment.sentiment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sentiment/")
public class SentimentController {
    private final SentimentAnalyzer sentimentAnalyzer;

    @GetMapping("{text}")
    public SentimentResult getSentiment(@PathVariable String text) {
        return sentimentAnalyzer.getSentimentResult(text);
    }
}
