package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.DebitWalletReportResponse;
import com.toshaniFintech.user_service.entity.DebitWalletReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DebitWalletReportMapper {
    DebitWalletReportResponse toResponse(DebitWalletReportEntity entity);

}
