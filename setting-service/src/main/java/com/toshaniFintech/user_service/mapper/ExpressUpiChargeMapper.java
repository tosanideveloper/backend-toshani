package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.ExpressUpiChargeResponseDTO;
import com.toshaniFintech.user_service.entity.ExpressUpiChargeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ExpressUpiChargeMapper {

    ExpressUpiChargeResponseDTO toResponseDto(ExpressUpiChargeEntity entity);
}