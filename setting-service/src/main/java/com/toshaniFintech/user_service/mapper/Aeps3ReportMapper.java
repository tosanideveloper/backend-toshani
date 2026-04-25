package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps3ReportResponse;
import com.toshaniFintech.user_service.entity.Aeps3ReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))

public interface Aeps3ReportMapper {
    Aeps3ReportResponse toResponse(Aeps3ReportEntity entity);

}
