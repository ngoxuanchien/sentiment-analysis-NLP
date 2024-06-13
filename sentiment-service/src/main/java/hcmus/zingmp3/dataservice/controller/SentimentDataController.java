package hcmus.zingmp3.dataservice.controller;

import hcmus.zingmp3.dataservice.dto.SentimentDataDTO;
import hcmus.zingmp3.dataservice.service.SentimentDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sentiment-data")
public class SentimentDataController {
    private final SentimentDataService sentimentDataService;

    @GetMapping
    public ResponseEntity<List<SentimentDataDTO>> getAllSentimentData(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sort));
        return ResponseEntity.ok(sentimentDataService
                .getAllSentimentData(pageable));
    }

    @GetMapping("/sentiment/{keyword}")
    public ResponseEntity<List<SentimentDataDTO>> getAllSentimentDataByReview(
            @PathVariable String keyword,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sort));
        return ResponseEntity.ok(sentimentDataService
                .getAllSentimentDataBySentiment(keyword, pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<List<SentimentDataDTO>> searchSentimentData(
            @RequestParam String review,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sort));
        return ResponseEntity.ok(sentimentDataService
                .getAllSentimentDataByReview(review, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SentimentDataDTO> getSentimentData(@PathVariable UUID id) {
        return ResponseEntity.ok(sentimentDataService
                .getSentimentData(id));
    }

    @PostMapping
    public ResponseEntity<SentimentDataDTO> createSentimentData(@RequestBody SentimentDataDTO sentimentDataDTO) {
        return ResponseEntity.ok(sentimentDataService
                .createSentimentData(sentimentDataDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SentimentDataDTO> updateSentimentData(
            @PathVariable UUID id,
            @RequestBody SentimentDataDTO sentimentDataDTO
    ) {
        return ResponseEntity.ok(sentimentDataService
                .updateSentimentData(id, sentimentDataDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSentimentData(@PathVariable UUID id) {
        sentimentDataService
                .deleteSentimentData(id);
        return ResponseEntity.noContent().build();
    }
}
