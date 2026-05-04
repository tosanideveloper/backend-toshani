package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.RemittanceChargeCommissionResponse;
import com.toshaniFintech.user_service.entity.RemittanceChargeCommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface RemittanceChargeCommissionMapper {
    RemittanceChargeCommissionResponse toResponse(RemittanceChargeCommissionEntity entity);
}
