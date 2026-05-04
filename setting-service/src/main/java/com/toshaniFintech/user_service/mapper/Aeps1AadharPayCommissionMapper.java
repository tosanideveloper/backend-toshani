package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps1AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps1AadharPayCommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))

public interface Aeps1AadharPayCommissionMapper {

    Aeps1AadharPayCommissionResponseDTO toResponseDto(Aeps1AadharPayCommissionEntity aeps1AadharPayCommissionEntity);
}
