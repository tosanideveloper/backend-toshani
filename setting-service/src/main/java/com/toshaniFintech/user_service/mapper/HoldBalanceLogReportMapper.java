package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.HoldBalanceLogReportResponse;
import com.toshaniFintech.user_service.entity.HoldBalanceLogReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface HoldBalanceLogReportMapper {
    HoldBalanceLogReportResponse toResponse(HoldBalanceLogReportEntity entity);
}
