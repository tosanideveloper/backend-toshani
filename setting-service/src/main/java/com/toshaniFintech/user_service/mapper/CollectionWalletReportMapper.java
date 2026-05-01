package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.CollectionWalletReportResponse;
import com.toshaniFintech.user_service.entity.CollectionWalletReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CollectionWalletReportMapper {
    CollectionWalletReportResponse toResponse(CollectionWalletReportEntity entity);
}
