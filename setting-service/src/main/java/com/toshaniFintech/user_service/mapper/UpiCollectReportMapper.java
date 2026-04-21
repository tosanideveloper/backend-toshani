package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.UpiCollectReportResponseDTO;
import com.toshaniFintech.user_service.entity.UpiCollectReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UpiCollectReportMapper {

    UpiCollectReportResponseDTO toResponseDto(UpiCollectReportEntity entity);
}