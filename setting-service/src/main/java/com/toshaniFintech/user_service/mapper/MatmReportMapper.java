package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.MatmReportResponseDTO;
import com.toshaniFintech.user_service.entity.MatmReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MatmReportMapper {
    MatmReportResponseDTO toResponseDto(MatmReportEntity entity);

}
