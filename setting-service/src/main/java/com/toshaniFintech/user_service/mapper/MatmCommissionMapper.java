package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.MatmCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.MatmCommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))

public interface MatmCommissionMapper {
    MatmCommissionResponseDTO toResponseDto(MatmCommissionEntity matmCommissionEntity);
}
