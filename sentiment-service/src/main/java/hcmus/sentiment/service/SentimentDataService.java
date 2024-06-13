package hcmus.sentiment.service;

import hcmus.sentiment.dto.SentimentDataDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SentimentDataService {
    List<SentimentDataDTO> getAllSentimentData(Pageable pageable);
    SentimentDataDTO getSentimentData(UUID id);
    SentimentDataDTO createSentimentData(SentimentDataDTO sentimentDataDTO);
    SentimentDataDTO updateSentimentData(UUID id, SentimentDataDTO sentimentDataDTO);
    void deleteSentimentData(UUID id);

    SentimentDataDTO uploadSentimentData(SentimentDataDTO sentimentDataDTO);

    List<SentimentDataDTO> getAllSentimentDataByReview(String review, Pageable pageable);

    List<SentimentDataDTO> getAllSentimentDataBySentiment(String keyword, Pageable pageable);
}
