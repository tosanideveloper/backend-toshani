package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps2MerchantReportResponse;
import com.toshaniFintech.user_service.entity.Aeps2MerchantReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface Aeps2MerchantReportMapper {
    Aeps2MerchantReportResponse toResponse(Aeps2MerchantReportEntity entity);

}
