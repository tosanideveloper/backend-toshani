package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.PartnerBalanceReportResponse;
import com.toshaniFintech.user_service.entity.PartnerBalanceReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface PartnerBalanceReportMapper {
    PartnerBalanceReportResponse toResponse(PartnerBalanceReportEntity entity);
}
