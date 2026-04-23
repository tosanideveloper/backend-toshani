package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps2ReportResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps2ReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AePSTwoReportMapper {
    Aeps2ReportResponseDTO toResponseDto(Aeps2ReportEntity entity);

}
