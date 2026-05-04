package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps3CommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps3CommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface Aeps3CommissionMapper {
    Aeps3CommissionResponseDTO toResponseDto(Aeps3CommissionEntity aeps3CommissionEntity);
}
