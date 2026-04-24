package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.Aeps1ReportResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps1ReportEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface Aeps1ReportMapper {

    Aeps1ReportResponseDTO toResponseDto(Aeps1ReportEntity entity);
}