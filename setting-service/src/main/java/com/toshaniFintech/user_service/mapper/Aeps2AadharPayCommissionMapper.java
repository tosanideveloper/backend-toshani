package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps2AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps2AadharPayCommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface Aeps2AadharPayCommissionMapper {
    Aeps2AadharPayCommissionResponseDTO toResponseDto(Aeps2AadharPayCommissionEntity aeps2AadharPayCommissionEntity);
}
