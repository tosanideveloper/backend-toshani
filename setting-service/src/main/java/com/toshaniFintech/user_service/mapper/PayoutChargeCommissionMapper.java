package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.PayoutChargeCommissionResponse;
import com.toshaniFintech.user_service.entity.PayoutChargeCommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface PayoutChargeCommissionMapper {
    PayoutChargeCommissionResponse toResponse(PayoutChargeCommissionEntity entity);

}
