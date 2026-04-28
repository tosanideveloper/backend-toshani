package com.toshaniFintech.user_service.mapper;

import com.toshaniFintech.user_service.dto.response.FinpayApiLogResponse;
import com.toshaniFintech.user_service.entity.FinpayApiLogEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface FinpayApiLogMapper {
    FinpayApiLogResponse toResponse(FinpayApiLogEntity entity);

}
