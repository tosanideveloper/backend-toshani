package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.BbpsReportResponseDTO;
import com.toshaniFintech.user_service.entity.BbpsReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface BbpsReportMapper {
    BbpsReportResponseDTO toResponseDto(BbpsReportEntity entity);

}
