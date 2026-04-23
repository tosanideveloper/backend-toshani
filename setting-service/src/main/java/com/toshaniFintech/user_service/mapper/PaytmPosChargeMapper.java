package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.PaytmPosChargeResponseDTO;
import com.toshaniFintech.user_service.entity.PaytmPosChargeEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" ,builder = @Builder(disableBuilder = true))
public interface PaytmPosChargeMapper {

    PaytmPosChargeResponseDTO toResponseDto(PaytmPosChargeEntity entity);
}