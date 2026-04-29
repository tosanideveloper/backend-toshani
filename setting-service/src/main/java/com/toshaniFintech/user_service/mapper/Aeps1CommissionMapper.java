package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps1CommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps1CommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))

public interface Aeps1CommissionMapper {

    Aeps1CommissionResponseDTO toResponseDto(Aeps1CommissionEntity aeps1CommissionEntity);
}
