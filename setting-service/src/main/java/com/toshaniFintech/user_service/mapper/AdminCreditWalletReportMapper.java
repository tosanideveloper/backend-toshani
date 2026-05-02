package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.AdminCreditWalletReportResponse;
import com.toshaniFintech.user_service.entity.AdminCreditWalletReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AdminCreditWalletReportMapper {
    AdminCreditWalletReportResponse toResponse(AdminCreditWalletReportEntity entity);
}
