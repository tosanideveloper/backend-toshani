package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.SettlementReportResponseDTO;
import com.toshaniFintech.user_service.entity.SettlementReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SettlementReportMapper {
    SettlementReportResponseDTO toResponseDto(SettlementReportEntity entity);
}
