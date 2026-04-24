package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.AmcReportResponse;
import com.toshaniFintech.user_service.entity.AmcReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AmcReportMapper {
    AmcReportResponse toResponse(AmcReportEntity entity);
}
