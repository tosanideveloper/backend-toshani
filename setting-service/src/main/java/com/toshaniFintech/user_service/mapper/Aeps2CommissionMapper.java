package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps2CommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps2CommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))

public interface Aeps2CommissionMapper {

    Aeps2CommissionResponseDTO toResponseDto(Aeps2CommissionEntity aeps2CommissionEntity);
}
