package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.CreditWalletReportResponse;
import com.toshaniFintech.user_service.entity.CreditWalletReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CreditWalletReportMapper {
    CreditWalletReportResponse toResponse(CreditWalletReportEntity entity);
}
