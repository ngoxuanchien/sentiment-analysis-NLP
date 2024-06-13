package hcmus.zingmp3.dataservice.repository;

import hcmus.zingmp3.dataservice.entity.SentimentDataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SentimentDataRepository extends JpaRepository<SentimentDataEntity, UUID> {
    Page<SentimentDataEntity> findAllBy(Pageable pageable);
    Page<SentimentDataEntity> findAllByReviewContaining(String review, Pageable pageable);
    Page<SentimentDataEntity> findAllBySentimentContaining(String sentiment, Pageable pageable);
}
