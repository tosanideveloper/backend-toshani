package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.UpiLiteChargeResponseDTO;
import com.toshaniFintech.user_service.entity.UpiLiteChargeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UpiLiteChargeMapper {

    UpiLiteChargeResponseDTO toResponseDto(UpiLiteChargeEntity entity);
}