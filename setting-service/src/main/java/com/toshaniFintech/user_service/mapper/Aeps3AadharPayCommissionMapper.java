package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps3AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps3AadharPayCommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface Aeps3AadharPayCommissionMapper {
    Aeps3AadharPayCommissionResponseDTO toResponseDto(Aeps3AadharPayCommissionEntity aeps3AadharPayCommissionEntity);
}
