package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.CreditCardChargeCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.CreditCardChargeCommissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CreditCardChargeCommissionMapper {

    CreditCardChargeCommissionResponseDTO toResponseDto(CreditCardChargeCommissionEntity entity);
}