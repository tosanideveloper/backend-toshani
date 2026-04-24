package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.CardPayChargeResponseDTO;
import com.toshaniFintech.user_service.entity.CardPayChargeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CardPayChargeMapper {

    CardPayChargeResponseDTO toResponseDto(CardPayChargeEntity entity);
}