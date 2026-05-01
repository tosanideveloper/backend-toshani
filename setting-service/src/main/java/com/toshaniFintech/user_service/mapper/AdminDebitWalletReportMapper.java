package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.AdminDebitWalletReportResponse;
import com.toshaniFintech.user_service.entity.AdminDebitWalletReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AdminDebitWalletReportMapper {
    AdminDebitWalletReportResponse toResponse(AdminDebitWalletReportEntity entity);

}
