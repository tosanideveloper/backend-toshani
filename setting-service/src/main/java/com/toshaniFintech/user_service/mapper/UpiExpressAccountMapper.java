package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.UpiExpressAccountResponseDTO;
import com.toshaniFintech.user_service.entity.UpiExpressAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UpiExpressAccountMapper {

    UpiExpressAccountResponseDTO toResponseDto(UpiExpressAccountEntity entity);
}