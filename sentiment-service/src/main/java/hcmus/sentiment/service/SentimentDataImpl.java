package hcmus.sentiment.service;

import hcmus.sentiment.dto.SentimentDataDTO;
import hcmus.sentiment.entity.SentimentDataEntity;
import hcmus.sentiment.exception.ResourceNotFoundException;
import hcmus.sentiment.mapper.SentimentDataMapper;
import hcmus.sentiment.repository.SentimentDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class SentimentDataImpl implements SentimentDataService {
    private final SentimentDataRepository sentimentDataRepository;
    private final SentimentDataMapper sentimentDataMapper;
    private final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Override
    public List<SentimentDataDTO> getAllSentimentData(Pageable pageable) {
        return sentimentDataRepository
                .findAllBy(pageable)
                .getContent()
                .stream()
                .map(sentimentDataMapper::toDTO)
                .toList();

    }

    @Override
    public SentimentDataDTO getSentimentData(UUID id) {
        return sentimentDataMapper.toDTO(
                sentimentDataRepository
                          .findById(id)
                          .orElseThrow(() -> new ResourceNotFoundException(
                                  String.format("Sentiment data with id %s not found", id)))
        );
    }

    @Override
    public SentimentDataDTO createSentimentData(SentimentDataDTO sentimentDataDTO) {
        SentimentDataEntity entity = sentimentDataMapper.toEntity(sentimentDataDTO);
        sentimentDataRepository.save(entity);
        return sentimentDataMapper.toDTO(entity);
    }

    @Override
    public SentimentDataDTO updateSentimentData(UUID id, SentimentDataDTO sentimentDataDTO) {
        SentimentDataEntity newSentimentData = sentimentDataMapper.toEntity(sentimentDataDTO);
        newSentimentData.setId(id);
        sentimentDataRepository.save(newSentimentData);
        return sentimentDataMapper.toDTO(newSentimentData);
    }

    @Override
    public void deleteSentimentData(UUID id) {
       sentimentDataRepository.deleteById(id);
    }

    @Override
    public SentimentDataDTO uploadSentimentData(SentimentDataDTO sentimentDataDTO) {
        return null;
    }

    @Override
    public List<SentimentDataDTO> getAllSentimentDataByReview(String review, Pageable pageable) {
        List<SentimentDataEntity> entities = sentimentDataRepository
                .findAllByReviewContaining(review, pageable)
                .getContent();
        return sentimentDataMapper.toDTO(entities);
    }

    @Override
    public List<SentimentDataDTO> getAllSentimentDataBySentiment(String keyword, Pageable pageable) {
        List<SentimentDataEntity> entities = sentimentDataRepository
                .findAllBySentimentContaining(keyword, pageable)
                .getContent();
        return sentimentDataMapper.toDTO(entities);
    }
}
