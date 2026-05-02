package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.ApiWalletReportResponse;
import com.toshaniFintech.user_service.entity.ApiWalletReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ApiWalletReportMapper {
    ApiWalletReportResponse toResponse(ApiWalletReportEntity entity);
}
