package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.PaytmPosChargeResponseDTO;
import com.toshaniFintech.user_service.entity.PaytmPosChargeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaytmPosChargeMapper {

    PaytmPosChargeResponseDTO toResponseDto(PaytmPosChargeEntity entity);
}