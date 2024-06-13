package hcmus.zingmp3.dataservice.mapper;

import hcmus.zingmp3.dataservice.dto.SentimentDataDTO;
import hcmus.zingmp3.dataservice.entity.SentimentDataEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SentimentDataMapper {
    public SentimentDataDTO toDTO(SentimentDataEntity entity) {
        SentimentDataDTO dto = new SentimentDataDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public SentimentDataEntity toEntity(SentimentDataDTO dto) {
        SentimentDataEntity entity = new SentimentDataEntity();
        BeanUtils.copyProperties(dto, entity, "id");
        return entity;
    }

    public List<SentimentDataDTO> toDTO(List<SentimentDataEntity> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
}
