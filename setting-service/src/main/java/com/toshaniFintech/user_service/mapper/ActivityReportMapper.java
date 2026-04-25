package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.ActivityReportResponse;
import com.toshaniFintech.user_service.entity.ActivityReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ActivityReportMapper {
    ActivityReportResponse toResponse(ActivityReportEntity entity);

}
