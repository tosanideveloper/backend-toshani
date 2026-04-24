package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.RechargeReportResponseDTO;
import com.toshaniFintech.user_service.entity.RechargeReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface RechargeReportMapper {
    RechargeReportResponseDTO toResponseDto(RechargeReportEntity entity);

}
