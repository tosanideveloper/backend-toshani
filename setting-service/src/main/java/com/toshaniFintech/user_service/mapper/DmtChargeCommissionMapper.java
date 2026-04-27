package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.DmtChargeCommissionResponse;
import com.toshaniFintech.user_service.entity.DmtChargeCommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))

public interface DmtChargeCommissionMapper {
    DmtChargeCommissionResponse toResponse(DmtChargeCommissionEntity entity);
}
