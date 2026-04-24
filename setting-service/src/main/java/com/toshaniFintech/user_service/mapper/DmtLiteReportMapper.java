package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.DmtLiteReportResponseDTO;
import com.toshaniFintech.user_service.entity.DmtLiteReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DmtLiteReportMapper {

    DmtLiteReportResponseDTO toResponseDto(DmtLiteReportEntity entity);
}